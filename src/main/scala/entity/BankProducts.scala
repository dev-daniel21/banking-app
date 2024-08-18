package entity

abstract class BankProducts {
  val productName: String

  override def toString: String = s"bank product = $productName"
}

abstract class BankDeposits extends BankProducts {
  val interestRateYearly: Double
  val minimumBalanceMonthly: Int
}

abstract class CheckingAccount extends BankDeposits

class BasicCheckingAccount(minimumBalance: Int, interestRate: Double) extends CheckingAccount {
  override val minimumBalanceMonthly: Int = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val productName: String = "Basic Checking Account"
  println("Basic checking account created")
}

class StudentsCheckingAccount(minimumBalance: Int, interestRate: Double) extends CheckingAccount {
  override val minimumBalanceMonthly: Int = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val productName: String = "Students Checking Account"
  println("Students checking account created")
}

abstract class SavingsAccount extends BankDeposits {
  val transactionsMonthly: Int
}

class BasicSavingsAccount(minimumBalance: Int, interestRate: Double, transactions: Int) extends SavingsAccount {
  override val minimumBalanceMonthly: Int = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val transactionsMonthly: Int = transactions
  override val productName: String = "Basic Savings Account"
  println("Basic savings account created")
}

abstract class LendingAccount extends BankProducts {
  val annualFee: Double
  val apr: Double
  val rewardPercent: Double
}

class CreditCardAccount(fee: Double, rate: Double, pct: Double) extends LendingAccount {
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardPercent: Double = pct
  override val productName: String = "Credit card Account"
  println("Credit card account created")

}

























