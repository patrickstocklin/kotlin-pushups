package com.patrickstocklin.kotlinpushups.gettingstarted

import java.io.File
import java.lang.IllegalStateException

//val makes these READ-ONLY
val numbers : List<Int> = listOf(-4, -2, 0, 1, 5)
val mapItems : Map<Int, String> = mapOf(Pair(1,"One"), Pair(2,"Two"))
val emptyList : List<Int> = listOf()

fun main() {
    println("Hello World")
    val newCustomer = Customer("Ben", "123@gmail.com")
    println(newCustomer.name)
    println(newCustomer.email)
    val copyCustomer = newCustomer.copy()
    println(copyCustomer.equals(newCustomer)) // or ==
    println(copyCustomer.toString())

    functionWithDefaultValues()
    functionWithDefaultValues(1)

    println(functionFilterListForPositiveNumbers(numbers))
    functionTraverseMapByKeyValue(mapItems)
    println(functionAccessMapByKey(mapItems, 2))

    println(lazilyTrimmedValue)

    println(Resource.name)

    println(functionPrintFileSizeIfNotNull())
    //println(functionPrintFileSizeIfNotNullThrowExceptionIfDNE())
    println(functionGetFirstItemOfPossiblyEmptyMap(emptyList))
}


//Creates getters/setters for vars, equals, hashCode, toString, copy, component1()2()3()...
data class Customer(val name: String, val email: String)

//Default vals for function Params
fun functionWithDefaultValues(a : Int = 0) {
    println(a)
}

fun functionFilterListForPositiveNumbers(listToFilter: List<Int>) : List<Int> {
    return listToFilter.filter { it > 0 } // or listToFilter.filter { x -> x > 0}
}

//K V can be anything
fun functionTraverseMapByKeyValue(map: Map<Int, String>) {
    for ((key, value) in map) {
        println("$key $value")
    }
}

fun functionAccessMapByKey(map: Map<Int, String>, key: Int) : String? {
    return map[key]
}

//Learn more about this
val lazilyTrimmedValue: String by lazy {
    "someLazyStringComputation   ".trimWhitespaces()
}

//Extension Functions
fun String.trimWhitespaces() : String {
    return this.trim()
}

//Creating a Singleton
object Resource {
    const val name = "name of a singleton object"
}

//If not null shorthand
fun functionPrintFileSizeIfNotNull() : Int? {
    val files = File("Test").listFiles()

    return files?.size ?: 0
}

fun functionPrintFileSizeIfNotNullThrowExceptionIfDNE() : Int? {
    val files = File("Test").listFiles()

    return files?.size ?: throw IllegalStateException("Omg my file does not exist")
}

// Pay attention to ?:
fun functionGetFirstItemOfPossiblyEmptyMap(list: List<Int>) : Int {
    return list.firstOrNull() ?: -1
}