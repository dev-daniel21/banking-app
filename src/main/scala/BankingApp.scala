import entity.{Bank, Dollars}

import java.time.LocalDate
import scala.util.Random

object BankingApp {
  def main(args: Array[String]): Unit = {
    println("Bank app running")

    val bank = new Bank("New Corporate Bank", "Scranton", "USA")

    def getStartupCustomers: Seq[(String, String, String, String)] = {
      Seq(
        ("Michael", "Scott", "mscott@dunder.com", "1962-02-23"),
        ("Jim", "Halpert", "jhalpert@dunder.com", "1972-05-16")
      )
    }

    def getStartupDepositProducts: Seq[(String, Int, Double)] = {
      Seq(
        ("BasicCheckingAccount", 4531, 0.03),
        ("StudentsCheckingAccount", 223, 0.02),
        ("BasicSavingsAccount", 736, 0.01)
      )
    }

    def getStartupLendingProducts: Seq[(String, Double, Double, Double)] = {
      Seq(
        ("CreditCardAccount", 30, 0.05, 10)
      )
    }

    val customerIds = getStartupCustomers.map(c => bank.registerNewCustomer(c._1, c._2, c._3, c._4))
    val depositProductIds = getStartupDepositProducts.map(d => bank.addNewDepositProduct(d._1, d._2, d._3))
    val lendingProductIds = getStartupLendingProducts.map(l => bank.addNewLendingProduct(l._2, l._3, l._4))

    println(s"Bank: $bank")
    println(s"Customers: $customerIds")
    println(s"Deposit products: $depositProductIds")
    println(s"Lending products: $lendingProductIds")

    val depositAccounts = for {
      c <- customerIds
      d <- depositProductIds
    } yield bank.openNewDepositAccount(c, d, _: Dollars)

    val random = new Random()
    val depositAccountsIds = depositAccounts.map(a => a(Dollars(35 + random.nextInt(23))))

    println(s"Deposit accounts: ${depositAccounts}")
    println(s"Deposit accounts ids: $depositAccountsIds")

    val lendingAccounts = for {
      c <- customerIds
      l <- lendingProductIds
    } yield bank.openNewLendingAccount(c, l, _: Dollars)

    val lendingAccountIds = lendingAccounts.map(a => a(Dollars(12 + random.nextInt(65))))

    println(s"Lending accounts: $lendingAccounts")
    println(s"Lending accounts ids: $lendingAccountIds")

    val amountForTransaction = new Random(340)

    depositAccountsIds.foreach(bank.depositMoney(_, Dollars(2 + amountForTransaction.nextInt(22))))
    depositAccountsIds.foreach(bank.withdrawMoney(_, Dollars(1 + amountForTransaction.nextInt(62))))

    lendingAccountIds.foreach(bank.payWithCreditCard(_, Dollars(1 + amountForTransaction.nextInt(12))))
    lendingAccountIds.foreach(bank.payCreditCardDebt(_, Dollars(3 + amountForTransaction.nextInt(29))))

  }

}
