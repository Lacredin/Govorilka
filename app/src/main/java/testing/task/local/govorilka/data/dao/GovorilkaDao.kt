package testing.task.local.govorilka.data.dao

import androidx.room.*
import io.reactivex.Completable
import testing.task.local.govorilka.data.models.chats.*

@Dao
interface GovorilkaDao {

    @Query("SELECT * FROM ChatEntity")
    fun getAllChats(): List<ChatEntity>

    @Query("SELECT * FROM UsersChatsEntity")
    fun getAllUsersChats(): List<UsersChatsEntity>

    @Query("SELECT * FROM UserEntity")
    fun getAllUser(): List<UserEntity>

    @Transaction
    @Query(
        "SELECT * FROM ChatEntity " +
                "INNER JOIN UsersChatsEntity ON UsersChatsEntity.idChat == ChatEntity.id " +
                "INNER JOIN UserEntity ON UserEntity.id == UsersChatsEntity.idUser " +
                "WHERE ChatEntity.id == :idChat"
    )
    fun getUsersChat(idChat: String): UsersChat

    @Transaction
    @Query("SELECT * FROM MessageEntity WHERE MessageEntity.id == :idChat")
    fun getMessage(idChat: String): List<MessageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChat(chat: ChatEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserChats(usersChats: UsersChatsEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsersChats(usersChats: List<UsersChatsEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMessagesEntity(messages: List<MessageEntity>): Completable
}