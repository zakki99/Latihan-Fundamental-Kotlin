package com.example.latihan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etsername: EditText
    private lateinit var etpassword: EditText
    private lateinit var history: TextView

    val resultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode==Activity.RESULT_OK){
            val data:Intent?=result.data
            val returnString:String?=data?.getStringExtra("history")
            history.text=returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etsername= findViewById(R.id.editTextUsername)
        etpassword= findViewById(R.id.editTextPassword)
        history= findViewById(R.id.history_tv)

        val bundle=intent.extras
        if (bundle!=null){
            etsername.setText(bundle.getString("username"))
            etpassword.setText(bundle.getString("password"))
        }


        val btnLogin: Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.buttonLogin-> {
                val intent= Intent(this@LoginActivity,MainActivity::class.java)
                intent.putExtra("User",User(etsername.text.toString(),etpassword.text.toString()))
                resultLauncher.launch(intent)
            }
        }


    }
}