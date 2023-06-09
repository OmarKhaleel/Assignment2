package com.example.assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var handler: SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = SQLiteHelper(this)
        val emailED: EditText = findViewById(R.id.EmailED)
        val passwordED: EditText = findViewById(R.id.PasswordED)
        val btnSignUp: Button = findViewById(R.id.SignUpBT)
        val btnLogIn: Button = findViewById(R.id.LoginBT)

        btnLogIn.setOnClickListener {
            if (handler.userRegistered(emailED.text.toString(), passwordED.text.toString())) {
                val intent3 = Intent(this, Booking::class.java)
                startActivity(intent3)
            } else {
                Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignUp.setOnClickListener {
            val intent4 = Intent(this, SignUp::class.java)
            startActivity(intent4)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.flight_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.Rate -> {
                val rate_dialog = RateUsClass()
                rate_dialog.show(supportFragmentManager, "Rate Us Custom Dialog")
            }
            R.id.FirstClassDetails -> {
                val first_class_dialog = FirstClassDetailsClass()
                first_class_dialog.show(supportFragmentManager, "First Class Flight Details Custom Dialog")
            }
            R.id.EconomyClassDetails -> {
                val economy_class_dialog = EconomyClassDetailsClass()
                economy_class_dialog.show(supportFragmentManager, "Economy Class Flight Details Custom Dialog")
            }
            R.id.Location -> {
                val intent = Intent(this, Location::class.java)
                startActivity(intent)
            }
            R.id.ContactUs -> {
                val intent2 = Intent(this, ContactUs::class.java)
                startActivity(intent2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}