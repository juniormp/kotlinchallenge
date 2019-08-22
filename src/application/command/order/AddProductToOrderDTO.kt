package application.command.order

data class AddProductToOrderDTO(val orderId: Int, val productId: Int, val quantity: Int) {}