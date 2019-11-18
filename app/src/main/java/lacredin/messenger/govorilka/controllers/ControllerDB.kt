package lacredin.messenger.govorilka.controllers

import android.content.Context
import lacredin.messenger.govorilka.data.db.GovorilkaDB

class ControllerDB(context: Context) {

    lateinit var db: GovorilkaDB
    private set

    init {
        create(context)
    }

    fun create(context: Context){
        db = GovorilkaDB.getDatabase(context)
    }
}