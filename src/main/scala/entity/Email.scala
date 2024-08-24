package entity

object Email {
  def apply(emailName: String, domain: String): Email = new Email(emailName, domain)
}

class Email(val emailName: String, val domain: String) {
  override def toString: String = s"$emailName@$domain"
}
