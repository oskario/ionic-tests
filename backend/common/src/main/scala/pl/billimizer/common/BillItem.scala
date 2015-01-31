package pl.billimizer.common

case class BillItem(name: String, quantity: BigDecimal, total: BigDecimal) {

  lazy val perItemCost: BigDecimal = {
    if (quantity > 0) total / quantity
    else 0
  }
}
