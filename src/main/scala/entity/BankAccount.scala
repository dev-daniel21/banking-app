package entity

import java.util.UUID

abstract class BankAccount {
  val id: UUID = UUID.randomUUID()
  val bankCustomer: Customer
  val bankProduct: BankProducts
  def getBalance: Dollars
}

class DepositAccount(val bankCustomer: Customer, val bankProduct: BankDeposits, private var currentBalance: Dollars) extends BankAccount {

  def makeDeposit(amount: Dollars): Unit = {
    require(amount > Dollars(0), "deposit amount should be greater than zero")
    println(s"$amount added to account balance ${this.getBalance}")
    currentBalance += amount
  }

  def makeWithdrawal(amount: Dollars): Unit = {
    require(amount > Dollars(0) && currentBalance > Dollars(0), "deposit and balance should be greater than zero")
    println(s"$amount withdraw from account balance ${this.getBalance}")
    currentBalance -= amount
  }

  override def getBalance: Dollars = currentBalance

  override def toString: String = s"$bankCustomer with $bankProduct balance: $currentBalance"
}

class LendingsAccount(val bankCustomer: Customer, val bankProduct: BankLendings, private var currentBalance: Dollars) extends BankAccount {

  def makePayments(amount: Dollars): Unit = {
    require(amount > Dollars(0) && currentBalance > Dollars(0), "deposit and balance should be greater than zero")
    println(s"$amount payments made ${this.getBalance}")
    currentBalance += amount
  }

  def lendMoney(amount: Dollars): Unit = {
    require(amount > Dollars(0), "deposit amount should be greater than zero")
    println(s"$amount lended from account balance ${this.getBalance}")
    currentBalance -= amount
  }

  override def getBalance: Dollars = currentBalance

  override def toString: String = s"$bankCustomer with $bankProduct balance: $currentBalance"
}
