package com.patrickstocklin.kotlinpushups.gettingstarted

/*
   The most basic Kt app
 */

const val helloWorld: String = "Hello World"

//Variables
val a: Int = 1 //immediate assignment
val b = 2 //Int type is inferred
//All other ways of instantiating vals are wrong

val PI = 3.14
var x = 0

val fruits = listOf("Banana", "Apple", "Grape", "Avocado")

fun main() {
    println(helloWorld)
    println(functionWithArgs(2, 2))
    println(functionWithExpressionBodyAndInferredReturnType(3, 3))
    functionWithNoReturnValue(4, 4)
    functionWithOmittedUnitReturnType(5, 5)
    incrementX()
    incrementX()
    println(functionStringTemplate(111))
    println(functionMaxOfTwoNumbers(4, 5))
    printProduct("5", "5")
    println(getStringLength("apples"))
    functionLoopThroughFruit()
    functionLoopThroughFruitByInd()
    println(functionDescribeObjectWithWhen(2L))
    println(functionIntegerIsWithinRange(5, 10))
    println(functionIntegerIsWithinRange(15, 10))
    functionPrintCollectionUsingMaps()
}

//2 params and a return type of Int
fun functionWithArgs(a: Int, b: Int) : Int {
    return a + b
}

//The return type is inferred
//Uses an Expression Body
fun functionWithExpressionBodyAndInferredReturnType(a: Int, b: Int) = a + b

//Function that returns nothing
fun functionWithNoReturnValue(a: Int, b: Int) : Unit {
    println(a + b)
}

//TODO:
//Function with omitted Unit (What is this?)
fun functionWithOmittedUnitReturnType(a: Int, b: Int) {
    println(a + b)
}

fun incrementX() {
    println("Incrementing X")
    x+=1
    println("Value of X=$x")
}

//Uses a String Template
fun functionStringTemplate(a: Int) : String {
    return "This string contains Integer: $a"
}

// this is valid
fun functionMaxOfTwoNumbers(a: Int, b: Int) = if (a > b) a else b

//Nullable Checks
fun printProduct(a: String, b: String) {
    val x = parseInt(a)
    val y = parseInt(b)

    //Using x*y here yields an error because they can be null
    if (x != null && y != null) {
        //x and y are immediately casted to non-nullable after this null check
        println(x * y)
    } else {
        println("$a or $b is not a non-null number")
    }
}

//Can return a Null Object
fun parseInt(s: String) : Int? {
    return s.toInt()
}

//Type Checks and Automatic Casts
fun getStringLength(obj: Any) : Int? {
    if (obj is String && obj.length > 0) { //obj is also automatically casted here
        //obj is automatically casted to String in this conditional
        return obj.length
    }
    return null
}

//
fun functionLoopThroughFruit() {
    for (fruit in fruits) {
        println(fruit)
    }
}

fun functionLoopThroughFruitByInd() {
    var index = 0
    while (index < fruits.size) {
        println("item at $index is ${fruits[index]}")
        index++
    }
}

//Switch Blocks
fun functionDescribeObjectWithWhen(obj: Any) : String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "I don't know"
    }

//Ranges
fun functionIntegerIsWithinRange(arg: Int, upperBound: Int) : Boolean {
    return arg in 1..upperBound
}

//Collections
fun functionPrintCollectionUsingMaps() {
    fruits
        .filter { it.toLowerCase().startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}