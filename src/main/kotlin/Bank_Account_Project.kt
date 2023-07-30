// Bank Account Project
fun main() {
    // Step 1  Start the bank system interface
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    // Step 2 Create variables for the bank account type and user input
    var accountType = ""
//    var userChoice = 0

    // Step 3  Create the bank account based on user input
    while (accountType == "") {
        println("Choose an option (1, 2 or 3)")
        var userChoice = readln()!!.toInt()
//        userChoice = (1..5).random()
        println("The selected option is ${userChoice}.")

        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue
        }
    }

    //Step 4 Display account type
    println("You have created a ${accountType} account.")

    // Step 5 Create constants and variables for the account balance and amount of money to transfer

    var accountBalance = (0..1000).random()
    println("The current balance is ${accountBalance} dollars.")

    val money = (0..1000).random()
    println("The amount you transferred is ${money} dollars.")



    // Step 6 Create a test variable for the output of the bank account operations

    var output = 0

    //step 7 Implement the withdrawal operation for generic and credit bank accounts
    fun withdraw(amount: Int): Int {
        accountBalance -= amount
        println("You successfully withdrew ${amount} dollars. The current balance is ${accountBalance} dollars.")
        return amount
    }

    // Step 8 Test the withdrawal operation for generic and credit accounts
    output = withdraw(money)
    println("The amount you withdrew is ${output} dollars.")

    //step 9 Implement the withdrawal operation for debit accounts
    fun debitWithdraw(amount: Int): Int {
        if (accountBalance == 0) {
            println("Can't withdraw, no money on this account!")
            return accountBalance
        } else if (amount > accountBalance) {
            println("Not enough money on this account! The current balance is ${accountBalance} dollars.")
            return 0
        } else {
            return withdraw(amount)
        }
    }

    // Step 10 Test the withdrawal operation for debit accounts

    output = debitWithdraw(money)
    println("The amount you withdrew is ${output} dollars.")

    // Step 11 Implement the deposit operation for generic and debit accounts

    fun deposit(amount: Int): Int {
        accountBalance += amount
        println("You successfully deposited ${amount} dollars. The current balance is ${accountBalance} dollars.")
        return amount
    }

    // Step 12  Test the deposit operation for generic and debit accounts
    output = deposit(money)
    println("The amount you deposited is ${output} dollars.")

    // step 13  Implement the deposit operation for credit accounts
    fun creditDeposit(amount: Int): Int {
        if (accountBalance == 0) {
            println("This account is completely paid off! Do not deposit money!")
            return accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. The current balance is ${accountBalance} dollars.")
            return 0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid off this account!")
            return amount
        } else {
            return deposit(amount)
        }
    }

    // Step 14  Test the deposit operation for credit accounts

    output = creditDeposit(money)
    println("The amount you deposited is ${output} dollars.")

    // step 15  Implement the transfer operation for checking, debit and credit accounts
    fun transfer(mode: String) {
        val transferAmount: Int

        when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = withdraw(money)
                }
                println("The amount you withdrew is ${transferAmount} dollars.")
            }
            "deposit" -> {
                if (accountType == "credit") {
                    transferAmount = creditDeposit(money)
                } else {
                    transferAmount = deposit(money)
                }
                println("The amount you deposited is ${transferAmount} dollars.")
            }
            else -> return
        }
    }
// Step 16 Create variables for the virtual bank system interface status and user interface option
    var isSystemOpen= true
//    var option = 0

// step 17 Manage the bank account based on the user interface option
    while (isSystemOpen == true) {
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        var option = readln()!!.toInt()
//        option = (1..5).random()
        println("The selected option is ${option}.")

        when (option) {
            1 -> println("The current balance is ${accountBalance} dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}
