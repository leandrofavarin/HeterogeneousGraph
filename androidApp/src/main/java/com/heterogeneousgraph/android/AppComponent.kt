package com.heterogeneousgraph.android

import android.content.Context
import com.example.MyDatabase
import com.heterogeneousgraph.DriverComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
abstract class AppComponent(
    @get:Provides val context: Context,
) : DriverComponent {
    abstract val myDatabase: MyDatabase
}
