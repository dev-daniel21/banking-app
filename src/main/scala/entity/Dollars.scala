package entity

object Dollars {
  def apply(amount: Int): Dollars = new Dollars(amount)
}

class Dollars(val amount: Int) extends AnyVal {
  def +(value: Dollars): Dollars = new Dollars(amount + value.amount)
  def -(value: Dollars): Dollars = new Dollars(amount - value.amount)
  def >(value: Dollars): Boolean = amount > value.amount

  override def toString: String = "$" + amount

}
