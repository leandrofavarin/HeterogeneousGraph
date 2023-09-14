package com.heterogeneousgraph

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.MyDatabase
import me.tatarka.inject.annotations.Provides

actual interface DriverComponent {
    @Provides fun provideSqlDriver(): SqlDriver {
        return NativeSqliteDriver(MyDatabase.Schema, name = "my_db.db")
    }

    @Provides fun provideMyDatabase(driver: SqlDriver): MyDatabase {
        return MyDatabase(driver)
    }
}
