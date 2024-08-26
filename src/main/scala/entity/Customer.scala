package entity

import java.time.LocalDate
import java.util.UUID

class Customer(firstName: String, lastName: String, emailAddr: Email, birthDate: LocalDate) {
  val id: UUID = UUID.randomUUID()
  val fName: String = firstName
  val lName: String = lastName
  val email: Email = emailAddr
  val bDate: LocalDate = birthDate

  override def toString: String = s"$fName, $lName"
}
