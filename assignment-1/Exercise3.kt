fun main() {
    val sum = addNumbers(5, 3)
    println(sum)

    val multiplication = multiplyNumbers(4, 6)
    println(multiplication)

    val result = applyOperation(10, 2, multiplyNumbers)
    println(result)
}


fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

val multiplyNumbers: (Int, Int) -> Int = { x, y -> x * y }

fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
