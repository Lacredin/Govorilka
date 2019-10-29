package testing.task.local.govorilka.data.models.chats

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class UserEntity (
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
)