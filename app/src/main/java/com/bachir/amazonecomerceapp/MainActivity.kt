package com.bachir.amazonecomerceapp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_main)
            val credentials =Data.credentials
            credentials["a1@email.com"] = User("a1@email.com" ,"pass1","bachir")
            credentials["a2@email.com"] = User("a2@email.com" ,"pass2","cherif")

                 val signInButton = findViewById<Button>(R.id.sign)
                 val createButton = findViewById<Button>(R.id.create)
            // handle create
            createButton.setOnClickListener{


                val intent=Intent(this,CreateAccountActivity::class.java)
                startActivity(intent)

            }
            // handle Sign in
            signInButton.setOnClickListener{

                val email  = findViewById<TextView>(R.id.Email).text.toString()
                val password = findViewById<TextView>(R.id.Password).text.toString()

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(this, "Please provide both email and password  ", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val user = credentials[email]
                if(user == null || user.password != password){
                    Toast.makeText(this, "wrong credentials ", Toast.LENGTH_SHORT).show()
                }else {
                    val intent=Intent(this,ShoppingActivity::class.java)
                    intent.putExtra("name", user.name)
                    startActivity(intent)
                    finish()
                }



            }
        }
    }
}


