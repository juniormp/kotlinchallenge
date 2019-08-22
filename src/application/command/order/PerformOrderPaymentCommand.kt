package application.command.order

import domain.billing.Payment
import infrastructure.repository.OrderRepository

class PerformOrderPaymentCommand(private val dto : PerformOrderPaymentDTO,
                                 private val orderRepository : OrderRepository) : OrderCommand{

    override fun execute() {
        val order = orderRepository.findOrder(dto.orderId)

        order?.pay(dto.paymentMethod)

        if (order != null) {
            orderRepository.save(order)
        }
     }
}