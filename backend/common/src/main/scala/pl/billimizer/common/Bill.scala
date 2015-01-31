package pl.billimizer.common

case class Bill(total: BigDecimal, items: List[BillItem])
