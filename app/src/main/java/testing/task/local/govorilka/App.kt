package testing.task.local.govorilka

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import testing.task.local.govorilka.controllers.ControllerDB
import testing.task.local.govorilka.controllers.ControllerUseCases

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        context = this
        db = ControllerDB(this)
        useCases = ControllerUseCases(this, db)
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        lateinit var useCases: ControllerUseCases
        lateinit var db: ControllerDB
    }
}