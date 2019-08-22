package infrastructure.repository

import domain.product.Product
import domain.product.ProductType
import java.lang.Exception

// Silly implementation of repository just for the problem context
class ProductRepository {

    fun findProduct(id: Int) : Product{
        return when(id) {
           1 ->  Product(1, "Flowered t-shirt", ProductType.Physical, 35.00)
           2 ->  Product(2, "Familiar plan", ProductType.Membership, 29.90)
           3 ->  Product(3, "The Hitchhiker's Guide to the Galaxy", ProductType.Book, 120.00)
           4 ->  Product(4, "Stairway to Heaven", ProductType.Digital, 5.00)
            else -> throw Exception("Product not found.")
       }
    }
}