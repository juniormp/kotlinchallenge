package application.command.order

import infrastructure.repository.OrderRepository
import infrastructure.repository.ProductRepository

open class OrderHandler(){
    private val queue = ArrayList<OrderCommand>()

    fun addToQueue(orderCommand: OrderCommand): OrderHandler =
        apply {
            queue.add(orderCommand)
        }

    fun processCommands(): OrderHandler =
        apply {
            queue.forEach { it.execute() }
            queue.clear()
        }
}