package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.latihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv:TextView
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        binding.btn.setOnClickListener { replaceFragment(Fragment_1()) }
//        binding.btnFragment2.setOnClickListener { replaceFragment(Fragment_2()) }
        tv=findViewById(R.id.cobadulu)

        val username=intent.getParcelableExtra<User>("User")?.username
        val password=intent.getParcelableExtra<User>("User")?.password
        tv.text="Username:$username dan password$password"

        val btnImplict: Button = findViewById(R.id.btn_implict)
        btnImplict.setOnClickListener(this) }
//    private fun replaceFragment(fragment: Fragment_1) {

//        val fragmentManager =supportFragmentManager
//        val fragmentTransaction=fragmentManager.beginTransaction()
//        fragmentTransaction.replace(androidx.fragment.R.id.fragment_container_view_tag,fragment)
//        fragmentTransaction.commit()

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_implict ->{
//                val message="cekdulu"
//                val intent= Intent()
//                intent.action= Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT,message)
//                intent.type="text/plain"
//                startActivity(intent)

                val intent=Intent()
                intent.putExtra("history","Anda sudah login")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}