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
    val customerJim = new Customer("Jim", "Halpert", Email("jhalpert", "dunder.com"), LocalDate.of(1972, 5, 16))
    val allCustomers = Set(customerMichael, customerJim)

    val michaelBasicAcc = new DepositAccount(customerMichael, basicCheckingAccount, Dollars(3234))
    val michaelSavingsAcc = new DepositAccount(customerMichael, basicSavingsAccount, Dollars(654))
    val michaelCreditAcc = new LendingsAccount(customerMichael, creditCardAccount, Dollars(1732))

    val jimBasicAcc = new DepositAccount(customerJim, basicCheckingAccount, Dollars(1753))
    val jimCreditAcc = new LendingsAccount(customerJim, creditCardAccount, Dollars(437))

    val customersAccounts = Set(michaelBasicAcc, michaelSavingsAcc, michaelCreditAcc, jimBasicAcc, jimCreditAcc)

    val bank = new Bank("New Corporate Bank", "Scranton", "USA", allBankProducts, allCustomers, customersAccounts)

    println(michaelBasicAcc)
    michaelBasicAcc.makeDeposit(43)
    println(michaelBasicAcc.getBalance)
    michaelBasicAcc.makeWithdrawal(32)
    println(michaelBasicAcc)
    println(michaelSavingsAcc)
    println(michaelCreditAcc)
    println(jimBasicAcc.toString)
    println(jimCreditAcc.toString)
    jimCreditAcc.lendMoney(54)
    println(jimCreditAcc.getBalance)
    jimCreditAcc.makePayments(96)
    print(jimCreditAcc)
  }

}
