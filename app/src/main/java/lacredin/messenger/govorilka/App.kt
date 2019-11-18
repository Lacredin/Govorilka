package lacredin.messenger.govorilka

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import lacredin.messenger.govorilka.controllers.ControllerDB
import lacredin.messenger.govorilka.controllers.ControllerUseCases

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        context = this
        db =
            ControllerDB(this)
        useCases =
            ControllerUseCases(
                this,
                db
            )
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        lateinit var useCases: ControllerUseCases
        lateinit var db: ControllerDB
    }
}