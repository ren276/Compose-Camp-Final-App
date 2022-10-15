package com.sandesh.zomatoclone.screens.destinations

import androidx.annotation.RestrictTo
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.spec.*
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.navDeepLink
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavType
import com.ramcosta.composedestinations.navargs.primitives.DestinationsFloatNavType
import com.ramcosta.composedestinations.navargs.primitives.DestinationsIntNavType
import com.ramcosta.composedestinations.navargs.primitives.DestinationsStringNavType
import com.sandesh.zomatoclone.screens.destinations.RestaurantScreenDestination.NavArgs
import com.sandesh.zomatoclone.screens.restaurantScreen.RestaurantScreen

object RestaurantScreenDestination : TypedDestination<RestaurantScreenDestination.NavArgs> {
    
    override fun invoke(navArgs: NavArgs): Direction = with(navArgs) {
        invoke(offerPercentageText, offerUpToText, restaurantName, restaurantType, restaurantLocation, deliveryDistanceInKms, isMultipleLocations, deliveryTimeInMins, isPureVegetarian, ratingText)
    }
     
    operator fun invoke(
		offerPercentageText: Int?,
		offerUpToText: Int?,
		restaurantName: String,
		restaurantType: String,
		restaurantLocation: String,
		deliveryDistanceInKms: Int,
		isMultipleLocations: Boolean = false,
		deliveryTimeInMins: Int,
		isPureVegetarian: Boolean = false,
		ratingText: Float?,
    ): Direction {
        return object : Direction {
            override val route = "$baseRoute" + 
					"/${DestinationsStringNavType.serializeValue("restaurantName", restaurantName)}" + 
					"/${DestinationsStringNavType.serializeValue("restaurantType", restaurantType)}" + 
					"/${DestinationsStringNavType.serializeValue("restaurantLocation", restaurantLocation)}" + 
					"/${DestinationsIntNavType.serializeValue(deliveryDistanceInKms)}" + 
					"/${DestinationsIntNavType.serializeValue(deliveryTimeInMins)}" + 
					"?offerPercentageText=${DestinationsIntNavType.serializeValue(offerPercentageText)}" + 
					"?offerUpToText=${DestinationsIntNavType.serializeValue(offerUpToText)}" + 
					"?isMultipleLocations=${DestinationsBooleanNavType.serializeValue(isMultipleLocations)}" + 
					"?isPureVegetarian=${DestinationsBooleanNavType.serializeValue(isPureVegetarian)}" + 
					"?ratingText=${DestinationsFloatNavType.serializeValue(ratingText)}"
        }
    }
    
    @get:RestrictTo(RestrictTo.Scope.SUBCLASSES)
    override val baseRoute = "restaurant_screen"

    override val route = "$baseRoute/{restaurantName}/{restaurantType}/{restaurantLocation}/{deliveryDistanceInKms}/{deliveryTimeInMins}?offerPercentageText={offerPercentageText}?offerUpToText={offerUpToText}?isMultipleLocations={isMultipleLocations}?isPureVegetarian={isPureVegetarian}?ratingText={ratingText}"
    
	override val arguments get() = listOf(
		navArgument("offerPercentageText") {
			type = DestinationsIntNavType
			nullable = true
		},
		navArgument("offerUpToText") {
			type = DestinationsIntNavType
			nullable = true
		},
		navArgument("restaurantName") {
			type = DestinationsStringNavType
		},
		navArgument("restaurantType") {
			type = DestinationsStringNavType
		},
		navArgument("restaurantLocation") {
			type = DestinationsStringNavType
		},
		navArgument("deliveryDistanceInKms") {
			type = DestinationsIntNavType
		},
		navArgument("isMultipleLocations") {
			type = DestinationsBooleanNavType
			val defValue: Boolean = false
			defaultValue = defValue
		},
		navArgument("deliveryTimeInMins") {
			type = DestinationsIntNavType
		},
		navArgument("isPureVegetarian") {
			type = DestinationsBooleanNavType
			val defValue: Boolean = false
			defaultValue = defValue
		},
		navArgument("ratingText") {
			type = DestinationsFloatNavType
			nullable = true
		}
	)

    @Composable
    override fun DestinationScope<NavArgs>.Content(
		dependenciesContainerBuilder: @Composable DependenciesContainerBuilder<NavArgs>.() -> Unit
    ) {
		val (offerPercentageText, offerUpToText, restaurantName, restaurantType, restaurantLocation, deliveryDistanceInKms, isMultipleLocations, deliveryTimeInMins, isPureVegetarian, ratingText) = navArgs
		RestaurantScreen(
			offerPercentageText = offerPercentageText, 
			offerUpToText = offerUpToText, 
			restaurantName = restaurantName, 
			restaurantType = restaurantType, 
			restaurantLocation = restaurantLocation, 
			deliveryDistanceInKms = deliveryDistanceInKms, 
			isMultipleLocations = isMultipleLocations, 
			deliveryTimeInMins = deliveryTimeInMins, 
			isPureVegetarian = isPureVegetarian, 
			ratingText = ratingText
		)
    }
                    
	override fun argsFrom(navBackStackEntry: NavBackStackEntry): NavArgs {
	    return NavArgs(
			offerPercentageText = DestinationsIntNavType.get(navBackStackEntry, "offerPercentageText"),
			offerUpToText = DestinationsIntNavType.get(navBackStackEntry, "offerUpToText"),
			restaurantName = DestinationsStringNavType.get(navBackStackEntry, "restaurantName") ?: throw RuntimeException("'restaurantName' argument is mandatory, but was not present!"),
			restaurantType = DestinationsStringNavType.get(navBackStackEntry, "restaurantType") ?: throw RuntimeException("'restaurantType' argument is mandatory, but was not present!"),
			restaurantLocation = DestinationsStringNavType.get(navBackStackEntry, "restaurantLocation") ?: throw RuntimeException("'restaurantLocation' argument is mandatory, but was not present!"),
			deliveryDistanceInKms = DestinationsIntNavType.get(navBackStackEntry, "deliveryDistanceInKms") ?: throw RuntimeException("'deliveryDistanceInKms' argument is mandatory, but was not present!"),
			isMultipleLocations = DestinationsBooleanNavType.get(navBackStackEntry, "isMultipleLocations") ?: throw RuntimeException("'isMultipleLocations' argument is not mandatory and not nullable but was not present!"),
			deliveryTimeInMins = DestinationsIntNavType.get(navBackStackEntry, "deliveryTimeInMins") ?: throw RuntimeException("'deliveryTimeInMins' argument is mandatory, but was not present!"),
			isPureVegetarian = DestinationsBooleanNavType.get(navBackStackEntry, "isPureVegetarian") ?: throw RuntimeException("'isPureVegetarian' argument is not mandatory and not nullable but was not present!"),
			ratingText = DestinationsFloatNavType.get(navBackStackEntry, "ratingText"),
	    )
	}
                
	override fun argsFrom(savedStateHandle: SavedStateHandle): NavArgs {
	    return NavArgs(
			offerPercentageText = DestinationsIntNavType.get(savedStateHandle, "offerPercentageText"),
			offerUpToText = DestinationsIntNavType.get(savedStateHandle, "offerUpToText"),
			restaurantName = DestinationsStringNavType.get(savedStateHandle, "restaurantName") ?: throw RuntimeException("'restaurantName' argument is mandatory, but was not present!"),
			restaurantType = DestinationsStringNavType.get(savedStateHandle, "restaurantType") ?: throw RuntimeException("'restaurantType' argument is mandatory, but was not present!"),
			restaurantLocation = DestinationsStringNavType.get(savedStateHandle, "restaurantLocation") ?: throw RuntimeException("'restaurantLocation' argument is mandatory, but was not present!"),
			deliveryDistanceInKms = DestinationsIntNavType.get(savedStateHandle, "deliveryDistanceInKms") ?: throw RuntimeException("'deliveryDistanceInKms' argument is mandatory, but was not present!"),
			isMultipleLocations = DestinationsBooleanNavType.get(savedStateHandle, "isMultipleLocations") ?: throw RuntimeException("'isMultipleLocations' argument is not mandatory and not nullable but was not present!"),
			deliveryTimeInMins = DestinationsIntNavType.get(savedStateHandle, "deliveryTimeInMins") ?: throw RuntimeException("'deliveryTimeInMins' argument is mandatory, but was not present!"),
			isPureVegetarian = DestinationsBooleanNavType.get(savedStateHandle, "isPureVegetarian") ?: throw RuntimeException("'isPureVegetarian' argument is not mandatory and not nullable but was not present!"),
			ratingText = DestinationsFloatNavType.get(savedStateHandle, "ratingText"),
	    )
	}

	data class NavArgs(
		val offerPercentageText: Int?,
		val offerUpToText: Int?,
		val restaurantName: String,
		val restaurantType: String,
		val restaurantLocation: String,
		val deliveryDistanceInKms: Int,
		val isMultipleLocations: Boolean = false,
		val deliveryTimeInMins: Int,
		val isPureVegetarian: Boolean = false,
		val ratingText: Float?,
	)
}