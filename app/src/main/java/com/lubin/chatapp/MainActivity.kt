package com.lubin.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.lubin.chatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG=MainActivity::class.java.simpleName
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {//當activity準備產生,呼叫onCreate()
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun homeBT(view: View){

    }
    fun searchBT(view: View){
        var search=binding.idSearch.text.toString()
        //search="star planet"//anchor name
        //Toast.makeText(this,search.toString(),Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this).setTitle("Go Searching")//設定標題
                    .setMessage("Please go to Search Activity")//設定標題內的訊息
                    .setPositiveButton("Go",null)//右下按Go前往SearchActivity
                    .setNeutralButton("Exit",null)//左下按Exit返回首頁
                    //.show()
        /*val intent=Intent(this,SearchActivity::class.java)
            intent.putExtra("Your Anchor name",search)
            startActivity(intent)*/
        Intent(this,SearchActivity::class.java).apply {
            putExtra("Your Anchor name",search)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至SearchActivity(增加可讀性)
    }
    fun personBT(view: View){
        var person=binding.idPerson.text.toString()
        Intent(this,LoginFragment::class.java).apply {
            putExtra("Your Anchor name",person)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至PersonActivity(增加可讀性)
    }

    override fun onStart() {//當activity產生後(未顯示在手機畫面上),呼叫onStart()
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {//當activity顯示在手機上後,呼叫OnResume()
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onRestart() {//切換activity情境,由user使用點擊此ＡＰＰ後執行onRestart()
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {//當user按下返回鍵結束activity,呼叫onPause()
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {//當activity從螢幕上消失，呼叫onStop()
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {//完全結束,呼叫onDestroy()
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")

    }
}
