package entity

abstract class BankAccount {
  val bankCustomer: Customer
  val bankProduct: BankProducts
  def getBalance: Dollars
}

class DepositAccount(val bankCustomer: Customer, val bankProduct: BankDeposits, private var currentBalance: Dollars) extends BankAccount {

  def makeDeposit(amount: Int): Unit = {
    require(amount > 0, "deposit amount should be greater than zero")
    println(s"$amount added to account balance")
    currentBalance += amount
  }

  def makeWithdrawal(amount: Int): Unit = {
    require(amount > 0 && currentBalance > 0, "deposit and balance should be greater than zero")
    println(s"$amount withdraw from account balance")
    currentBalance -= amount
  }

  override def getBalance: Dollars = currentBalance

  override def toString: String = s"$bankCustomer with $bankProduct balance: $currentBalance"
}

class LendingsAccount(val bankCustomer: Customer, val bankProduct: BankLendings, private var currentBalance: Dollars) extends BankAccount {

  def makePayments(amount: Int): Unit = {
    require(amount > 0 && currentBalance > 0, "deposit and balance should be greater than zero")
    println(s"$amount payments made")
    currentBalance += amount
  }

  def lendMoney(amount: Int): Unit = {
    require(amount > 0, "deposit amount should be greater than zero")
    println(s"$amount lended from account balance")
    currentBalance -= amount
  }

  override def getBalance: Dollars = currentBalance

  override def toString: String = s"$bankCustomer with $bankProduct balance: $currentBalance"
}
