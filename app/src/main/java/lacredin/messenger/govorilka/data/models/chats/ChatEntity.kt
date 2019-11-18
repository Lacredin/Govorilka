package lacredin.messenger.govorilka.data.models.chats

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class ChatEntity (
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
)
