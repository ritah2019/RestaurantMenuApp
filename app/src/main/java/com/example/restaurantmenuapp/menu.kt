package com.example.restaurantmenuapp

import android.content.ClipData
import android.content.Context
import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
//import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_item.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
    var listProducts=ArrayList<item_info>()
    var adapter:MyProductAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        // loadURLonline()

        listProducts.add(item_info(R.drawable.melon,"melon","2000Ugshs"," Melon juice"))
        listProducts.add(item_info(R.drawable.juice,"juice","2000Ugshs","Orange juice"))
        listProducts.add(item_info(R.drawable.food,"food","8000Ugshs","food"))
        listProducts.add(item_info(R.drawable.pineapple,"pineapple","2000Ugshs","Pineapple"))
        listProducts.add(item_info(R.drawable.salad,"salad","7000Ugshs","Salad"))
        listProducts.add(item_info(R.drawable.fish,"fish","10000Ugshs","Fish"))
        listProducts.add(item_info(R.drawable.chick,"chicken","20000Ugshs","Fried Chicken"))
        listProducts.add(item_info(R.drawable.rice,"rice","5000Ugshs","Rice"))
        listProducts.add(item_info(R.drawable.coffee,"coffee","4000Ugshs","Coffee"))
        listProducts.add(item_info(R.drawable.icecream,"icecream","2500Ugshs","Icecream"))
        listProducts.add(item_info(R.drawable.spiced,"spiced","7000Ugshs","Spiced food"))
        listProducts.add(item_info(R.drawable.banana,"banana","1000ugs","Yellow banana"))

        adapter=MyProductAdapter(this, listProducts)
        listview.adapter=adapter

    }


    inner class MyProductAdapter:BaseAdapter {
        var context:Context? = null
        var MylistProducts=ArrayList<item_info>()

        constructor(context: Context, MylistProducts:ArrayList<item_info>):super() {
            this.MylistProducts=MylistProducts
            this.context = context
        }

        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
            val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myview=inflator.inflate(R.layout.activity_item,null)
            val product=this.MylistProducts[position]
            myview.image.setImageResource(product.foodimage!!)
            myview.name.text=product.foodname
            myview.price.text=product.price
            myview.send.setOnClickListener(View.OnClickListener{
                val intent = Intent(context, details::class.java)
                intent.putExtra("name", product.foodname)
                intent.putExtra("price", product.price)
                intent.putExtra("image", product.foodimage!!)
                intent.putExtra("description", product.description)
                context!!.startActivity(intent)
            })
            return myview
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun  getItem(Item: Int): Any {
            return MylistProducts[Item]
        }

        override fun getCount(): Int {
            return this.MylistProducts.size
        }
    }


}

