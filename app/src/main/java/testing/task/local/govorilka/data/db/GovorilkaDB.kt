package testing.task.local.govorilka.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import testing.task.local.govorilka.data.dao.GovorilkaDao
import testing.task.local.govorilka.data.models.chats.ChatEntity
import testing.task.local.govorilka.data.models.chats.MessageEntity
import testing.task.local.govorilka.data.models.chats.UserEntity
import testing.task.local.govorilka.data.models.chats.UsersChatsEntity

@Database(version = 1, entities = [
    ChatEntity::class,
    UserEntity::class,
    //Users::class,
    UsersChatsEntity::class,
    MessageEntity::class
])
abstract class  GovorilkaDB : RoomDatabase() {

    abstract fun govorilkaDao(): GovorilkaDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: GovorilkaDB? = null

        fun getDatabase(context: Context): GovorilkaDB {
            return INSTANCE ?: let {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        GovorilkaDB::class.java,
                        "govorilka_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}