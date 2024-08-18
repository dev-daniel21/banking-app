package entity

class Bank(bankName: String, bankCity: String, bankCountry: String, bankProducts: Set[BankProducts], bankCustomers: Set[Customer], bankAccounts: Set[BankAccount]) {
  val bName: String = bankName
  val city: String = bankCity
  val country: String = bankCountry
  val products: Set[BankProducts] = bankProducts
  val customers: Set[Customer] = bankCustomers
  val accounts: Set[BankAccount] = bankAccounts

}
