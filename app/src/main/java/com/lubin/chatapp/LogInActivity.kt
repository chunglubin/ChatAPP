package com.lubin.chatapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lubin.chatapp.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {
    var remember=false
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var account=getSharedPreferences("Login account",Context.MODE_PRIVATE).getString("pref_account","")
        var password=getSharedPreferences("Login password",Context.MODE_PRIVATE).getString("pref_password","")

    }

    fun loginBT(view: View){
        binding.buttonLogin.setOnClickListener {
            var account=binding.inputAccount.text.toString()
            var password=binding.inputPassword.text.toString()
            if(account=="lubin"&&password=="20220321"){
                if(remember){

                }
            }
        }
        var login=binding.buttonLogin.text.toString()
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