package application.event.order

import domain.order.OrderItemClosed
import infrastructure.repository.OrderRepository
import infrastructure.service.mail.MailService
import infrastructure.service.shipping.ShippingLabelService

class DigitalItemShippingHandler(private val orderRepository : OrderRepository,
                                 private val mailService : MailService ) : ItemShippingHandler {

    override fun handle(eventData : OrderItemClosed){
        val message = "Digital - voucher de desconto de R$ 10 ao comprador associado ao pagamento."
        mailService.send(message)
    }
}