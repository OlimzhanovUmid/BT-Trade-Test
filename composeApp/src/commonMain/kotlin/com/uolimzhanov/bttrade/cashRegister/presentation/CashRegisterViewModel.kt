package com.uolimzhanov.bttrade.cashRegister.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uolimzhanov.bttrade.cashRegister.domain.CartItem
import com.uolimzhanov.bttrade.cashRegister.domain.ProductRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class CashRegisterViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {

    private var observeAllProductsJob: Job? = null
    private val cart = mutableStateListOf<CartItem>()

    private val _state = MutableStateFlow(CashRegisterState())
    val state = _state
        .onStart {
            observeAllProducts()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: CashRegisterAction) {
        when (action) {
            CashRegisterAction.OnDiscountedProductsClick -> {}

            CashRegisterAction.OnFavoriteProductsClick -> {}

            CashRegisterAction.OnSellClick -> {}

            is CashRegisterAction.OnViewModeChange -> {
                _state.update {
                    it.copy(
                        currentViewMode = action.viewMode
                    )
                }
            }

            is CashRegisterAction.OnAddToCartClick -> {
                val existingItemIndex = cart.indexOfFirst { it.product.id == action.product.id }
                if (existingItemIndex == -1) {
                    cart.add(
                        CartItem(
                            product = action.product,
                            quantity = 1
                        )
                    )
                }
                _state.update {
                    it.copy(cart = cart)
                }
            }

            is CashRegisterAction.OnRemoveFromCartClick -> {
                cart.remove(action.cartItem)
            }

            is CashRegisterAction.OnDecreaseQuantityClick -> {
                val cartItemIndex = cart.indexOf(action.cartItem)
                if (cartItemIndex != -1) {
                    cart[cartItemIndex] = cart[cartItemIndex].let {
                        if (it.quantity > 1) {
                            it.copy(quantity = it.quantity - 1)
                        } else {
                            it
                        }
                    }
                }
            }

            is CashRegisterAction.OnIncreaseQuantityClick -> {
                val cartItemIndex = cart.indexOf(action.cartItem)
                if (cartItemIndex != -1) {
                    cart[cartItemIndex] = cart[cartItemIndex].let {
                        if (it.quantity < it.product.quantityInStock) {
                            it.copy(quantity = it.quantity + 1)
                        } else {
                            it
                        }
                    }
                }
            }
        }
    }

    private fun observeAllProducts() {
        observeAllProductsJob?.cancel()
        observeAllProductsJob = productRepository
            .getAllProducts()
            .onEach { products ->
                _state.update {
                    it.copy(
                        allProducts = products
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}