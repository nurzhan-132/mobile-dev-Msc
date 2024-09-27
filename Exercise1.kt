fun main() {
    printVariables()

    checkNumber(-5)

    forLoop()
    whileLoop()

    val numbersList = listOf(1, 2, 3, 4, 5)
    val sum = sumOfNumbers(numbersList)
    println("Sum of list: $sum")
}

fun printVariables() {
    val myInt: Int = 10
    val myDouble: Double = 20.5
    val myString: String = "Hello, World!"
    val myBoolean: Boolean = true

    println(myInt)
    println(myDouble)
    println(myString)
    println(myBoolean)
}

fun checkNumber(number: Int) {
    if (number > 0) {
        println("positive")
    } else if (number < 0) {
        println("negative")
    } else {
        println("zero")
    }
}

fun forLoop() {
    println("Using for loop:")
    for (i in 1..10) {
        println(i)
    }
}

fun whileLoop() {
    println("Using while loop:")
    var i = 1
    while (i <= 10) {
        println(i)
        i++
    }
}

fun sumOfNumbers(numbers: List<Int>): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    return sum
}