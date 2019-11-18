package testing.task.local.govorilka.controllers

import android.content.Context
import testing.task.local.govorilka.usecase.UseCaseChat

class ControllerUseCases(context: Context, controllerDB: ControllerDB) {

    init {
        createUseCases(context, controllerDB)
    }

    lateinit var useCaseChat: UseCaseChat
    private set

    fun createUseCases(context: Context, controllerDB: ControllerDB){
        useCaseChat = UseCaseChat(context, controllerDB)
    }

}