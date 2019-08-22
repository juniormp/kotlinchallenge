package domain.order

import application.event.order.DomainEvent
import domain.product.Product
import kotlin.properties.Delegates

class OrderItem(val product : Product, private val quantity : Int, private val orderId : Int) {

    val total get() = product.price * quantity
    var isClosed: Boolean by Delegates.observable(false) { _, _, _ ->
        val eventType = "${product.type}ItemClosed"
        DomainEvent.publish(eventType, OrderItemClosed(orderId))
    }

    fun close() {
        isClosed = true
    }
}