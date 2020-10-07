package com.marcos.dengue_notific

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        // Setup
        login()

    }
    private fun login(){
        title= "Autenticación"
        signUpbutton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(emailEditText.text.toString(),
                        passwordEditText.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showHome()

                        }else{
                            showAlert()

                        }
                    }
            }

            }
        loginbutton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(emailEditText.text.toString(),
                        passwordEditText.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showHome()

                        }else{
                            showAlert()

                        }
                    }
            }

        }

        }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un errror de Autenticacion de Usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
        }
    private fun showHome(){
        val homeIntent = Intent( this, HomeActivity::class.java)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
    }

 }

