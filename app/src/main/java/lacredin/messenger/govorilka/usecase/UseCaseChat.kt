package lacredin.messenger.govorilka.usecase

import android.content.Context
import lacredin.messenger.govorilka.controllers.ControllerDB
import lacredin.messenger.govorilka.data.models.chats.UserEntity

class UseCaseChat(private val context: Context, private val db: ControllerDB) {

    fun getlAllUser(): List<UserEntity> {
        return db.db.govorilkaDao().getAllUser()
    }
}