package com.bachir.amazonecomerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CreateAccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_create)

            val createButton = findViewById<Button>(R.id.create)




            createButton.setOnClickListener{

                val name = findViewById<TextView>(R.id.Name).text.toString()
                val email = findViewById<TextView>(R.id.email).text.toString()
                val password = findViewById<TextView>(R.id.password).text.toString()
                val passwordConfirm = findViewById<TextView>(R.id.passwordConfirm).text.toString()

                if(name.isEmpty() || password.isEmpty() ||email.isEmpty() || passwordConfirm.isEmpty()){

                    Toast.makeText(this, "please provide All the information", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                if(password != passwordConfirm){
                    Toast.makeText(this, "Password does not match ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(Data.credentials[email] != null){
                    Toast.makeText(this, "Already registred , please Sign in !!  ", Toast.LENGTH_SHORT).show()
                }

                val user = User(email,password,name)
                Data.credentials[email] = user
                Toast.makeText(this, "Account registred suuccessfully, please Log in!  ", Toast.LENGTH_SHORT).show()

            }




        }
    }
}