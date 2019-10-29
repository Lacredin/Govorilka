package testing.task.local.govorilka.data.models.chats

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = ChatEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idChat"),
        onDelete = ForeignKey.CASCADE
    )]
)
class MessageEntity(
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var message: String? = null,

    var idUser: String? = null,

    var idChat: String? = null
)