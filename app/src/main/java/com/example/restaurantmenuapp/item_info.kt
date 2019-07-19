package com.example.restaurantmenuapp

class item_info {
    var foodimage:Int?=null
    var foodname:String?=null
    var  description:String?=null
    var price:String?=null
    constructor(foodimage:Int , foodname:String,price:String, description:String){
        this.foodimage=foodimage
        this.foodname=foodname
        this.description=description
        this.price=price
    }
}