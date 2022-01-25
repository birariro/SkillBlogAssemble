package com.example.skillblogassemble

import android.util.Log


fun main(args: Array<String>){

    var list = mutableListOf<Int>().apply {
        add(0)
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
    }
    val transList= list.map { number ->
        "name $number"
    }
    print(transList)

    list.forEach{
        print(it)
    }
}

fun sumFun(title:String, number:Int , completion:(String) -> Unit){
    completion(title+"name!"+number)
}
val sumFunLambda : (String,Int) -> String = { title, number ->
    println("sumFunLambda $title, $number")
    title+number
}



//val sumFunLambda = { input:String, number:Int ->
//    println("sumFunLambda $input, $number")
//}
