package com.sandesh.zomatoclone.screens.destinations

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.*

/**
 * Handy typealias of [TypedDestination] when you don't
 * care about the generic type (probably most cases for app's use)
 */
typealias Destination = TypedDestination<*>

/**
 * TypedDestination is a sealed version of [DestinationSpec]
 */
sealed interface TypedDestination<T>: DestinationSpec<T>

/**
 * DirectionDestination is a sealed version of [DirectionDestinationSpec]
 */
sealed interface DirectionDestination: TypedDestination<Unit>, DirectionDestinationSpec
