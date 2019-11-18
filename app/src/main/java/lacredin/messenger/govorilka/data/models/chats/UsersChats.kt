package lacredin.messenger.govorilka.data.models.chats

import androidx.room.*
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = ChatEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idChat"),
        onDelete = ForeignKey.CASCADE
    )]
)
class UsersChatsEntity(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var idChat: String? = null,

    var idUser: String? = null
)


class UsersChat(
    @Embedded
    var chat: ChatEntity? = null,

    @Relation(parentColumn = "id", entity = UsersChatsEntity::class, entityColumn = "idUser")
    var users: List<UserEntity>? = null
)

