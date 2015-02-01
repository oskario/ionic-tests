package pl.billimizer.common

object Bill {

  def apply(total: BigDecimal): Bill = {
    Bill(total, List())
  }
}

case class Bill(total: BigDecimal, items: List[BillItem])
