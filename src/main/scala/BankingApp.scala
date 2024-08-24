import entity.{Bank, BasicCheckingAccount, BasicSavingsAccount, CreditCardAccount, Customer, DepositAccount, Dollars, Email, LendingsAccount, StudentsCheckingAccount}

import java.time.LocalDate

object BankingApp {
  def main(args: Array[String]): Unit = {
    println("Bank app running")

    val basicCheckingAccount = new BasicCheckingAccount(Dollars(200), 0.03)
    val studentsCheckingAccount = new StudentsCheckingAccount(Dollars(100), 0.02)
    val basicSavingsAccount = new BasicSavingsAccount(Dollars(100), 0.01, 2)
    val creditCardAccount = new CreditCardAccount(20, 0.05, 10)
    val allBankProducts = Set(basicCheckingAccount, studentsCheckingAccount, basicSavingsAccount, creditCardAccount)

    val customerMichael = new Customer("Michael", "Scott", Email("mscott", "dunder.com"), LocalDate.of(1962, 2, 23))
    val allCustomers = Set(customerMichael)

    val michaelBasicAcc = new DepositAccount(customerMichael, basicCheckingAccount, Dollars(3234))
    val michaelsavingsAcc = new DepositAccount(customerMichael, basicSavingsAccount, Dollars(654))
    val michaelCreditAcc = new LendingsAccount(customerMichael, creditCardAccount, Dollars(1732))

    val michaelAllAccounts = Set(michaelBasicAcc, michaelsavingsAcc, michaelCreditAcc)

    val bank = new Bank("New Corporate Bank", "Scranton", "USA", allBankProducts, allCustomers, michaelAllAccounts)

    println(michaelBasicAcc)
    michaelBasicAcc.makeDeposit(43)
    println(michaelBasicAcc.getBalance)
    michaelBasicAcc.makeWithdrawal(32)
    println(michaelBasicAcc)

  }

}
