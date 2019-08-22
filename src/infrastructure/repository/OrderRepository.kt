package infrastructure.repository

import domain.customer.Customer
import domain.customer.Address
import domain.order.Order
import java.lang.Exception

object OrderRepository {

    private val address = Address(1234567)
    private val customer = Customer(1, "Mauricio", address)
    private val orderList = mutableMapOf(1 to Order(1, customer, address))

    fun findOrder(id: Int) : Order? {
        return when (id) {
            1 -> orderList[1]
            else -> throw Exception("Order not found.")
        }
    }

    fun save(order : Order){
        when (order.id) {
            1 -> orderList[1] = order
            else -> throw Exception("Order not found.")
        }

    }
}