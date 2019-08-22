package application.event.order

import domain.order.OrderItemClosed
import infrastructure.repository.OrderRepository
import infrastructure.service.shipping.ShippingLabelService

class PhysicalItemShippingHandler(private val orderRepository : OrderRepository,
                                  private val shippingLabel : ShippingLabelService) : ItemShippingHandler {

    override fun handle(eventData : OrderItemClosed){
        val message = "Physical"
        shippingLabel.generate(message)
    }
}