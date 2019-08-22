package application.command.order

import domain.billing.PaymentMethod

data class PerformOrderPaymentDTO(val orderId : Int, val paymentMethod : PaymentMethod) {}
