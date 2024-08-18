package entity

class BankAccount(bankCustomer: Customer, bankProduct: BankProducts, currentBalance: Int) {
  val customer: Customer = bankCustomer
  val product: BankProducts = bankProduct
  private var balance = currentBalance

  def makeDeposit(amount: Int): Unit = {
    balance += amount
    print(s"$amount added to account balance")
  }

  def makeWithdrawal(amount: Int): Unit = {
    balance -= amount
    print(s"$amount withdraw from account balance")
  }

  override def toString: String = s"$customer with $product balance: $balance"

}
