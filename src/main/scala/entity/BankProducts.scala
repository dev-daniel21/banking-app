package entity

abstract class BankProducts {
  val productName: String

  override def toString: String = s"bank product = $productName"
}

abstract class BankDeposits extends BankProducts {
  val interestRateYearly: Double
  val minimumBalanceMonthly: Dollars
}

abstract class BankLendings extends BankProducts {
  val annualFee: Double
  val apr: Double
  val rewardPercent: Double
}

abstract class CheckingAccount extends BankDeposits

abstract class SavingsAccount extends BankDeposits {
  val transactionsMonthly: Int
}

class BasicCheckingAccount(minimumBalance: Dollars, interestRate: Double) extends CheckingAccount {
  override val minimumBalanceMonthly: Dollars = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val productName: String = "Basic Checking Account"
  println("Basic checking account created")
}

class StudentsCheckingAccount(minimumBalance: Dollars, interestRate: Double) extends CheckingAccount {
  override val minimumBalanceMonthly: Dollars = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val productName: String = "Students Checking Account"
  println("Students checking account created")
}

class BasicSavingsAccount(minimumBalance: Dollars, interestRate: Double, transactions: Int) extends SavingsAccount {
  override val minimumBalanceMonthly: Dollars = minimumBalance
  override val interestRateYearly: Double = interestRate
  override val transactionsMonthly: Int = transactions
  override val productName: String = "Basic Savings Account"
  println("Basic savings account created")
}

class CreditCardAccount(fee: Double, rate: Double, pct: Double) extends BankLendings {
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardPercent: Double = pct
  override val productName: String = "Credit card Account"
  println("Credit card account created")
}

























