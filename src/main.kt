import application.command.order.*
import domain.billing.CreditCard
import infrastructure.repository.OrderRepository
import infrastructure.repository.ProductRepository


fun main(args : Array<String>) {

    OrderHandler()
        .addToQueue(physicalProductSetup())
        .addToQueue(membershipProductSetup())
        .addToQueue(bookProductSetup())
        .addToQueue(digitalProductSetup())
        .addToQueue(paymentSetup())
        .processCommands()
}

fun physicalProductSetup() : AddProductToOrderCommand {
    val addProductToOrderDTO = AddProductToOrderDTO(1, 1, 1)
    return AddProductToOrderCommand(addProductToOrderDTO, OrderRepository, ProductRepository())
}

fun membershipProductSetup() : AddProductToOrderCommand {
    val addProductToOrderDTO = AddProductToOrderDTO(1, 2, 1)
    return AddProductToOrderCommand(addProductToOrderDTO, OrderRepository, ProductRepository())
}

fun bookProductSetup() : AddProductToOrderCommand {
    val addProductToOrderDTO = AddProductToOrderDTO(1, 3, 1)
    return AddProductToOrderCommand(addProductToOrderDTO, OrderRepository, ProductRepository())
}

fun digitalProductSetup() : AddProductToOrderCommand {
    val addProductToOrderDTO = AddProductToOrderDTO(1, 4, 1)
    return AddProductToOrderCommand(addProductToOrderDTO, OrderRepository, ProductRepository())
}

fun paymentSetup() : PerformOrderPaymentCommand{
    val performOrderPaymentDTO = PerformOrderPaymentDTO(1, CreditCard("43567890-987654367"))
    return PerformOrderPaymentCommand(performOrderPaymentDTO, OrderRepository)
}




