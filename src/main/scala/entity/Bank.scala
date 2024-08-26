package entity

import java.time.{Instant, LocalDate}
import java.util.UUID


class Bank(
            val bankName: String,
            val bankCity: String,
            val bankCountry: String) {

  private var depositProducts: Map[UUID, BankDeposits] = Map.empty
  private var depositAccounts: Map[UUID, DepositAccount] = Map.empty
  private var lendingProducts: Map[UUID, BankLendings] = Map.empty
  private var lendingAccounts: Map[UUID, LendingsAccount] = Map.empty
  private var customers: Map[UUID, Customer] = Map.empty

  println(s"$bankName founded in ${LocalDate.of(1990, 4, 24)}")

  def registerNewCustomer(firstName: String, lastName: String, emailAddr: String, birthDate: String): UUID = {
    def getEmail: Email = {
      val Array(addr, domain) = emailAddr.split('@')
      Email(addr, domain)
    }

    def getDOB: LocalDate = {
      val Array(year, month, day) = birthDate.split('-')
      LocalDate.of(year.toInt, month.toInt, day.toInt)
    }

    val newCustomer = new Customer(firstName, lastName, getEmail, getDOB)
    customers += (newCustomer.id -> newCustomer)
    newCustomer.id
  }

  def addNewDepositProduct(officialName: String, minBalance: Int, ratePerYear: Double, transactionsAllowed: Int = 2): UUID = {
    val newProduct = officialName match {
      case "BasicCheckingAccount" => new BasicCheckingAccount(Dollars(minBalance), ratePerYear)
      case "StudentsCheckingAccount" => new StudentsCheckingAccount(Dollars(minBalance), ratePerYear)
      case "BasicSavingsAccount" => new BasicSavingsAccount(Dollars(100), ratePerYear, transactionsAllowed)
    }
    depositProducts += (newProduct.id -> newProduct)
    newProduct.id
  }

  def addNewLendingProduct(annualFee: Double, rate: Double, pct: Double): UUID = {
    val newLendingProduct = new CreditCardAccount(annualFee, rate, pct)
    lendingProducts += (newLendingProduct.id -> newLendingProduct)
    newLendingProduct.id
  }

  def openNewDepositAccount(customerId: UUID, productId: UUID, amount: Dollars): UUID = {
    require(customers.contains(customerId), s"customer with id $customerId not found")
    require(depositProducts.contains(productId), s"bank product with id $productId not found")

    val newAccount = new DepositAccount(customers(customerId), depositProducts(productId), amount)
    depositAccounts += (newAccount.id -> newAccount)
    newAccount.id
  }

  def openNewLendingAccount(customerId: UUID, productId: UUID, amount: Dollars = Dollars(0)): UUID = {
    require(customers.contains(customerId), s"customer with id $customerId not found")
    require(lendingProducts.contains(productId), s"bank product with id $productId not found")

    val newAccount = new LendingsAccount(customers(customerId), lendingProducts(productId), amount)
    lendingAccounts += (newAccount.id -> newAccount)
    newAccount.id
  }

  def depositMoney(accountId: UUID, amount: Dollars): Unit = {
    require(depositAccounts.contains(accountId), s"deposit account with id $accountId not found")
    depositAccounts(accountId) makeDeposit amount
  }

  def withdrawMoney(accountId: UUID, amount: Dollars): Unit = {
    require(depositAccounts.contains(accountId), s"deposit account with id $accountId not found")
    depositAccounts(accountId) makeWithdrawal amount
  }

  def payWithCreditCard(accountId: UUID, amount: Dollars): Unit = {
    require(lendingAccounts.contains(accountId), s"lending account with id $accountId not found")
    lendingAccounts(accountId) lendMoney amount
  }

  def payCreditCardDebt(accountId: UUID, amount: Dollars): Unit = {
    require(lendingAccounts.contains(accountId), s"lending account with id $accountId not found")
    lendingAccounts(accountId) makePayments amount
  }

  override def toString: String = s"$bankName \n" +
    s"number of customers: ${customers.size}\n" +
    s"number of deposits products: ${depositProducts.size}\n" +
    s"number of lending products: ${lendingProducts.size}\n" +
    s"number of deposits accounts: ${depositAccounts.size}\n" +
    s"number of lending accounts: ${lendingAccounts.size}\n"

}
