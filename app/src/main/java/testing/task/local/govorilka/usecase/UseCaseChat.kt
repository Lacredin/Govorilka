package testing.task.local.govorilka.usecase

import android.content.Context
import testing.task.local.govorilka.controllers.ControllerDB
import testing.task.local.govorilka.data.models.chats.UserEntity

class UseCaseChat(private val context: Context, private val db: ControllerDB) {

    fun getlAllUser(): List<UserEntity> {
        return db.db.govorilkaDao().getAllUser()
    }
}