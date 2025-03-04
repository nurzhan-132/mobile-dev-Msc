fun main() {
    val person = Person("Nurzhan", 22, "nurzhan@asd.com")
    person.displayInfo()

    val employee = Employee("Employee example", 28, "example@example.com", 575000.0)
    employee.displayInfo()

    val bankAccount = BankAccount(100000.0)
    println("\nBank Account Operations:")
    bankAccount.deposit(50000.0)
    bankAccount.withdraw(30000.0)
    bankAccount.withdraw(1500000.0)
}

open class Person(val name: String, val age: Int, val email: String) {
    open fun displayInfo() {
        println("Name: $name")
        println("Age: $age")
        println("Email: $email")
    }
}

class Employee(name: String, age: Int, email: String, val salary: Double) :
    Person(name, age, email) {
    override fun displayInfo() {
        super.displayInfo()
        println("Salary: $salary")
    }
}

class BankAccount(private var balance: Double) {
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Successfully deposited $amount. Current balance: $balance")
        } else {
            println("Invalid deposit amount.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Successfully withdrew $amount. Current balance: $balance")
        } else {
            println("Insufficient funds or invalid withdrawal amount.")
        }
    }
}
