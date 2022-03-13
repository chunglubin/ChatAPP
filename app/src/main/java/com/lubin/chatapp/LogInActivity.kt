package com.lubin.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lubin.chatapp.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun loginBT(view: View){
        var login=binding.idLogin.text.toString()
        Intent(this,MainActivity::class.java).apply {
            putExtra("Your Anchor name",login)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至首頁(MainActivity)
    }
    fun registerBT(view: View){
        var register=binding.idRegister.text.toString()
        Intent(this,SignUpActivity::class.java).apply {
            putExtra("Your Anchor name",register)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至首頁(MainActivity)
    }
}