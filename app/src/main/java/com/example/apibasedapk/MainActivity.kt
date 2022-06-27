package com.example.apibasedapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {


    var url = "https://jsonplaceholder.typicode.com/posts"
    var requestQueue:RequestQueue?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)

        requestQueue = Volley.newRequestQueue(this)

        button.setOnClickListener{

            apiCalling()

        }

    }

    fun apiCalling() {

        var jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, Response.Listener {

            response ->
            Log.e("TAG", "apiCalling: ${response}", )
        }, Response.ErrorListener {

            error -> Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        requestQueue?.add(jsonArrayRequest)

    }
}