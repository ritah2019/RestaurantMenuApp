package com.example.restaurantmenuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val bundle = intent.extras
        foodimage.setImageResource(bundle!!.getInt("image"))
        name.text = bundle.getString("name")
        price.text = bundle.getString("price")
        description.text = bundle.getString("description")
    }
}
