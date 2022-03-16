package com.lubin.chatapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.lubin.chatapp.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    var remember=false
    private lateinit var binding:FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentLoginBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref=requireContext().getSharedPreferences("LoginPassword",Context.MODE_PRIVATE)
        val checked=pref.getBoolean("Remember my account & password",remember)
        checked.also {
            binding.idRemember.isChecked=it
        }
        binding.idRemember.setOnCheckedChangeListener { compoundButton, checked ->
            remember=checked
            pref.edit().putBoolean("Remember my account & password",remember).apply()
            if(!checked){
                pref.edit().putString("username","").apply()
            }
        }

        val pref_user=pref.getString("username","")
        if(pref_user!="")binding.inputAccount.setText(pref_user)
        binding.idButtonLogin.setOnClickListener {
            val user_account=binding.inputAccount.text.toString()
            val user_password=binding.inputPassword.text.toString()
            if(user_account=="lubinflower"&&user_password=="20220321"){
                if(remember){//按remember後可執行以下區塊
                    pref.edit()
                        .putString("User_Account",user_account)
                        .putInt("level",2)
                        .apply()
                }
            }else{//登入失敗
                AlertDialog.Builder(requireContext())
                    .setTitle("Please login your account & password.")
                    .setMessage("Login failed,please try again.")
                    .setPositiveButton("OK",null)//right
                    .setNeutralButton("Try again",null)//left
                    .show()
            }
        }
    }
    fun loginBT(view: View){
        binding.idButtonLogin.setOnClickListener {
            val account=binding.inputAccount.text.toString()
            val password=binding.inputPassword.text.toString()
            if(account=="lubin"&&password=="20220321"){
                if(remember){

                }
            }
        }
        var login=binding.idButtonLogin.text.toString()
    }
    fun registerBT(view: View){
        var register=binding.idButtonRegister.text.toString()
        /*Intent(this,SignUpActivity::class.java).apply {
            putExtra("Your Anchor name",register)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至首頁(MainActivity)*/
    }
}