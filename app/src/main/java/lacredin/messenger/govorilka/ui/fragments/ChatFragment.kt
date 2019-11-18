package lacredin.messenger.govorilka.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.schedulers.Schedulers
import lacredin.messenger.govorilka.R
import lacredin.messenger.govorilka.data.db.GovorilkaDB
import lacredin.messenger.govorilka.data.models.chats.ChatEntity
import lacredin.messenger.govorilka.data.models.chats.UserEntity
import lacredin.messenger.govorilka.data.models.chats.UsersChatsEntity


class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GovorilkaDB.getDatabase(context!!).apply {
            val chat = ChatEntity()
            val user = UserEntity()
            val userChatEntity = UsersChatsEntity(
                idChat = chat.id,
                idUser = user.id
            )
            this.govorilkaDao().insertChat(chat)
                .andThen(this.govorilkaDao().insertUser(user))
                .andThen(this.govorilkaDao().insertUserChats(userChatEntity))
                .subscribeOn(Schedulers.newThread())
                .subscribe {
                    val chats = this.govorilkaDao().getAllChats()
                    val userEntity = this.govorilkaDao().getAllChats()
                    val usersChatsEntity = this.govorilkaDao().getAllUsersChats()


                    val users = this.govorilkaDao().getUsersChat(chat.id)
                    UserEntity()
                }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ChatFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}
