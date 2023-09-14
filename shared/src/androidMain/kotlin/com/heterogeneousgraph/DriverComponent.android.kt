package com.heterogeneousgraph

import android.app.Application
import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.MyDatabase
import me.tatarka.inject.annotations.Provides

actual interface DriverComponent {
    @Provides fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }

    @Provides fun provideSqlDriver(application: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = MyDatabase.Schema,
            context = application,
            name = "my_db.db",
        )
    }

    @Provides fun provideMyDatabase(driver: SqlDriver): MyDatabase {
        return MyDatabase(driver)
    }
}
