package application.event.order

import domain.order.OrderItemClosed
import infrastructure.repository.OrderRepository
import infrastructure.service.shipping.ShippingLabelService

class BookItemShippingHandler(private val orderRepository : OrderRepository,
                              private val shippingLabel : ShippingLabelService) : ItemShippingHandler {

    override fun handle(eventData : OrderItemClosed){
        val message  = "Book - Item insento de impostos conforme disposto na Constituição Art. 150, VI, d"
        shippingLabel.generate(message)
    }
}