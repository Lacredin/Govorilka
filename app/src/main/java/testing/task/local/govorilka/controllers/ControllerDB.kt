package testing.task.local.govorilka.controllers

import android.content.Context
import testing.task.local.govorilka.data.db.GovorilkaDB

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