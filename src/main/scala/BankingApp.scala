import entity.{Bank, BankAccount, BasicCheckingAccount, BasicSavingsAccount, CreditCardAccount, Customer, StudentsCheckingAccount}

import java.time.LocalDate

object BankingApp {
  def main(args: Array[String]): Unit = {
    println("Bank app running")

    val basicCheckingAccount = new BasicCheckingAccount(200, 0.03)
    val studentsCheckingAccount = new StudentsCheckingAccount(100, 0.02)
    val basicSavingsAccount = new BasicSavingsAccount(100, 0.01, 2)
    val creditCardAccount = new CreditCardAccount(20, 0.05, 10)
    val allBankProducts = Set(basicCheckingAccount, studentsCheckingAccount, basicSavingsAccount, creditCardAccount)

    val customerMichael = new Customer("Michael", "Scott", "mscott@duner.com", LocalDate.of(1962, 2, 23))
    val allCustomers = Set(customerMichael)

    val michaelBasicAcc = new BankAccount(customerMichael, basicCheckingAccount, 3234)
    val michaelsavingsAcc = new BankAccount(customerMichael, basicSavingsAccount, 654)
    val michaelCreditAcc = new BankAccount(customerMichael, creditCardAccount, 1732)

    val michaelAllAccounts = Set(michaelBasicAcc, michaelsavingsAcc, michaelCreditAcc)

    val bank = new Bank("New Corporate Bank", "Scranton", "USA", allBankProducts, allCustomers, michaelAllAccounts)

    println(michaelBasicAcc)
    michaelBasicAcc.makeDeposit(233)
    println(michaelBasicAcc)
    michaelBasicAcc.makeWithdrawal(42)
    println(michaelBasicAcc)

  }

}
