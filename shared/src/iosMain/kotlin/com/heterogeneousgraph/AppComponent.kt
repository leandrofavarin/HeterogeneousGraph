package com.heterogeneousgraph

import com.example.MyDatabase
import me.tatarka.inject.annotations.Component

@Component
abstract class AppComponent : DriverComponent {
    abstract val myDatabase: MyDatabase
}

fun createComponent(): AppComponent {
    return AppComponent::class.create()
}
