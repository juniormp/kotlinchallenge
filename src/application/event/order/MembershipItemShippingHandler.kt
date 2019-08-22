package application.event.order

import domain.order.OrderItemClosed
import infrastructure.repository.OrderRepository
import infrastructure.service.mail.MailService
import infrastructure.service.shipping.ShippingLabelService

class MembershipItemShippingHandler(private val orderRepository : OrderRepository,
                                    private val mailService : MailService ) : ItemShippingHandler {

    override fun handle(eventData : OrderItemClosed){
        val message = "Membership"
        mailService.send(message)
    }
}