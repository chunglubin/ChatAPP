package com.lubin.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lubin.chatapp.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private val TAG=SearchActivity::class.java.simpleName
    lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ")
        //val search2=intent.getStringExtra("Anchor Name")

    }
    fun searchBT2(view:View){
        //val search2=binding.idSearch2.text.toString()
        val search2=intent.getStringExtra("Your Anchor Name")
        Log.d(TAG, "I search this anchor is $search2, I'm so happy.")
        binding.idSearch2.text=search2.toString()
    }
}