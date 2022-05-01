package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences :SharedPreferences
    var getUsername :String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences=this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE)
        getUsername=sharedPreferences.getString("user","")
        if(getUsername!=null)
        {
            textView.text="Kaydedilen Değer:${getUsername}"
        }
    }

    fun save(view:View)
    {
        val userName=editText.text.toString()
        if(userName=="")
        {
            Toast.makeText(this,"Lütfen Kullanıcı Adını Giriniz",Toast.LENGTH_LONG).show()
        }
        else{

            sharedPreferences.edit().putString("user",userName).apply()
            textView.text="Kaydedilen Değer:${userName}"
        }

    }
    fun delete(view:View)
    {

    }
}