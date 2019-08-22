package application.event.order

import domain.order.OrderItemClosed
import infrastructure.repository.OrderRepository
import infrastructure.service.mail.MailService
import infrastructure.service.shipping.ShippingLabelService

object DomainEvent {
    private val shippingLabelService = ShippingLabelService()
    private val mailService = MailService()
    private val orderRepository = OrderRepository

    private val eventHandlerList = mapOf(
        "PhysicalItemClosed" to PhysicalItemShippingHandler(orderRepository, shippingLabelService),
        "MembershipItemClosed" to MembershipItemShippingHandler(orderRepository, mailService),
        "BookItemClosed" to BookItemShippingHandler(orderRepository, shippingLabelService),
        "DigitalItemClosed" to DigitalItemShippingHandler(orderRepository, mailService))

    fun publish(eventType : String, eventData: OrderItemClosed){
        val eventHandler : ItemShippingHandler? = eventHandlerList[eventType]
        eventHandler?.handle(eventData)
    }
}