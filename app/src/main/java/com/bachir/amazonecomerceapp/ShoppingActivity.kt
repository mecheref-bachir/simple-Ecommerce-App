package com.bachir.amazonecomerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.cardview.widget.CardView

class ShoppingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContentView(R.layout.activity_shopping)
            val receivedData = intent.getStringExtra("name")
            val welcome = findViewById<TextView>(R.id.welcome)
            welcome.text = "Welcome $receivedData"

            val card1 = findViewById<CardView>(R.id.beautyCardView)
            val card2 = findViewById<CardView>(R.id.homeCardView)
            val card3 = findViewById<CardView>(R.id.petCardView)
            val card4 = findViewById<CardView>(R.id.toysCardView)
            card1.setOnClickListener{
                Toast.makeText(this, "Hello you are in Beauty and self care ", Toast.LENGTH_SHORT).show()
            }
            card2.setOnClickListener{

                Toast.makeText(this, "Hello you are in Home and kitchen ", Toast.LENGTH_SHORT).show()
            }
            card3.setOnClickListener{

                Toast.makeText(this, "Hello you are in Pet supplies ", Toast.LENGTH_SHORT).show()
            }
            card4.setOnClickListener{
                Toast.makeText(this, "Hello you are in Toys and games  ", Toast.LENGTH_SHORT).show()

            }
        }

    }
}