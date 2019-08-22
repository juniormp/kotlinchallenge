package domain.test.order

import domain.billing.CreditCard
import domain.customer.Address
import domain.customer.Customer
import domain.order.Order
import domain.billing.Payment
import domain.product.Product
import domain.product.ProductType
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class OrderTest() {

    private val address = Address(1234567)
    private val customer = Customer(1, "Mauricio", address)
    private val order = Order(1, customer, address)

    @Test
    fun addProductToOrder() {
        val product = Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)

        order.addProduct(product, 1)

        assert(order.items.any { it -> it.product == product })
    }

    @Test
    fun throwExceptionForDuplicatedProduct() {
        assertFailsWith(Exception::class, "The product have already been added. Change the amount if you want more.") {
            val product = Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)
            val sameProduct = Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)

            order.addProduct(product, 1)
            order.addProduct(sameProduct, 1)
        }
    }

    @Test
    fun performPaymentOrder() {
        val paymentMethod = CreditCard("43567890-987654367")
        val product = Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)
        order.addProduct(product, 1)

        order.pay(paymentMethod)

        assertEquals(order.totalAmount, order.payment?.amount)
    }

    @Test
    fun throwExceptionForPaidOrder() {
        val paymentMethod = CreditCard("43567890-987654367")
        val product = Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)
        order.addProduct(product, 1)
        order.pay(paymentMethod)

        assertFailsWith(Exception::class, "The order has already been paid!") {
            order.pay(paymentMethod)
        }
    }

    @Test
    fun throwExceptionForEmptyOrder() {
        assertFailsWith(Exception::class, "Empty order can not be paid!") {
            val paymentMethod = CreditCard("43567890-987654367")

            order.pay(paymentMethod)
        }
    }
}