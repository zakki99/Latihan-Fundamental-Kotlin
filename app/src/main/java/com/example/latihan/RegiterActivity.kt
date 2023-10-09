package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegiterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsename :EditText
    private lateinit var etEmail :EditText
    private lateinit var etPassword :EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regiter)

        etUsename = findViewById(R.id.editTextUsername)
        etEmail = findViewById(R.id.editTextEmail)
        etPassword = findViewById(R.id.editTextPassword)


        val btnRegiter: Button= findViewById(R.id.buttonRegister)
        btnRegiter.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.buttonRegister -> {

                val bundle=Bundle()
                bundle.putString("username",etUsename.text.toString())
                bundle.putString("password",etPassword.text.toString())

                val intent= Intent(this@RegiterActivity, LoginActivity::class.java)

                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

    }
}