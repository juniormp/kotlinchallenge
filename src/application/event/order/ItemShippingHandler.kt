package application.event.order

import domain.order.OrderItemClosed

interface ItemShippingHandler {
    fun handle(eventData : OrderItemClosed)
}