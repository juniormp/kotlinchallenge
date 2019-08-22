package application.command.order

import infrastructure.repository.OrderRepository
import infrastructure.repository.ProductRepository


class AddProductToOrderCommand(private val dto : AddProductToOrderDTO,
                               private val orderRepository : OrderRepository,
                               private val productRepository : ProductRepository) : OrderCommand {

    override fun execute(){
        val product = productRepository.findProduct(dto.productId)
        val order = orderRepository.findOrder(dto.orderId)

        order?.addProduct(product, dto.quantity)

        if (order != null) {
            orderRepository.save(order)
        }
    }
}