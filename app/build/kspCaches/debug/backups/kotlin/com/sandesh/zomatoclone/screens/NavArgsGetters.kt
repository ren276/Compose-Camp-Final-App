package com.sandesh.zomatoclone.screens

import androidx.lifecycle.SavedStateHandle
import com.sandesh.zomatoclone.screens.destinations.RestaurantScreenDestination

inline fun <reified T> SavedStateHandle.navArgs(): T {
    return navArgs(T::class.java, this)
}

@Suppress("UNCHECKED_CAST")
fun <T> navArgs(argsClass: Class<T>, savedStateHandle: SavedStateHandle): T {
    return when (argsClass) {
		RestaurantScreenDestination.NavArgs::class.java -> RestaurantScreenDestination.argsFrom(savedStateHandle) as T
        else -> error("Class ${argsClass} is not a navigation arguments class!")
    }
}
