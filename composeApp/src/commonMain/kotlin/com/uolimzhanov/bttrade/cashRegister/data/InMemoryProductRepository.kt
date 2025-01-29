package com.uolimzhanov.bttrade.cashRegister.data

import com.uolimzhanov.bttrade.cashRegister.domain.Product
import com.uolimzhanov.bttrade.cashRegister.domain.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class InMemoryProductRepository : ProductRepository {
    private val products = listOf(
        Product(
            id = 1,
            name = "Стиральный порошок Persil Color, 1.52 кг",
            price = 64_990L,
            hasDiscount = true,
            isFavorite = false,
            discountPercent = 27,
            priceWithDiscount = 32_990L,
            quantityInStock = 83,
            unitType = "шт",
            image = "https://i.postimg.cc/44bvbxG2/persil.png"
        ),
        Product(
            id = 2,
            name = "Набор конфет Raffaello миндаль и кокос, 150 гр",
            price = 53_490L,
            hasDiscount = true,
            isFavorite = false,
            discountPercent = 10,
            priceWithDiscount = 48_000L,
            quantityInStock = 10,
            unitType = "шт",
            image = "https://i.postimg.cc/4N4YVqCC/rafaello.png"
        ),
        Product(
            id = 3,
            name = "Маленький лепёшк, 1 шт",
            price = 3_000L,
            hasDiscount = false,
            isFavorite = false,
            discountPercent = null,
            priceWithDiscount = null,
            quantityInStock = 32,
            unitType = "шт",
            image = "https://i.postimg.cc/Dwy1fmfX/bread.png"
        ),
        Product(
            id = 4,
            name = "Печёный патырь, 1 шт",
            price = 6_500L,
            hasDiscount = false,
            isFavorite = false,
            discountPercent = null,
            priceWithDiscount = null,
            quantityInStock = 14,
            unitType = "шт",
            image = "https://i.postimg.cc/bvsLmcgD/patyr.png"
        ),
        Product(
            id = 5,
            name = "Масло подсолнечное Затея рафинированное",
            price = 123_500L,
            hasDiscount = false,
            isFavorite = false,
            discountPercent = null,
            priceWithDiscount = null,
            quantityInStock = 10,
            unitType = "шт",
            image = "https://i.postimg.cc/GhLFMnhL/zateya.png"
        ),
        Product(
            id = 6,
            name = "Розмарин, 1 пучок",
            price = 17_500L,
            hasDiscount = false,
            isFavorite = false,
            discountPercent = null,
            priceWithDiscount = null,
            quantityInStock = 24,
            unitType = "пучок",
            image = "https://i.postimg.cc/65Mdgbyd/rosemary.png"
        ),
        Product(
            id = 7,
            name = "Капуста белокочанная, 1 кг",
            price = 16_500L,
            hasDiscount = false,
            isFavorite = false,
            discountPercent = null,
            priceWithDiscount = null,
            quantityInStock = 56,
            unitType = "кг",
            image = "https://i.postimg.cc/Gm9kCPy6/capusta.png"
        ),
        Product(
            id = 8,
            name = "Мандарины Everyday Fresh, 1 кг",
            price = 29_990L,
            hasDiscount = true,
            isFavorite = false,
            discountPercent = 20,
            priceWithDiscount = 23_990L,
            quantityInStock = 96,
            unitType = "кг",
            image = "https://i.postimg.cc/qR6bvVCV/mandarins.png"
        )
    )
    override fun getAllProducts(): Flow<List<Product>> = flow {
        emit(products)
    }

    override fun getById(id: Int): Product? {
        return products[id]
    }
}
