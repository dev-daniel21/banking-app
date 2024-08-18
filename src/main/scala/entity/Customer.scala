package entity

import java.time.LocalDate

class Customer(firstName: String, lastName: String, emailAddr: String, birthDate: LocalDate) {
  val fName: String = firstName
  val lName: String = lastName
  val email: String = emailAddr
  val bDate: LocalDate = birthDate

  override def toString: String = s"$fName, $lName"
}
