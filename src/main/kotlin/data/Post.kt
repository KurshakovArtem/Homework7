package data

import attachments.Attachments

data class Post(
    val id: Int,                       // Идентификатор записи
    val ownerId: Int,                  // Идентификатор владельца стены, на которой размещена запись
    val fromId: Int,                   // Идентификатор автора записи (от чьего имени опубликована запись)
    val createdBy: Int,                // Идентификатор администратора, который опубликовал запись
    val date: Int,                     // Время публикации записи в формате unixtime
    val text: String,                  // Текст записи
    val coments: Coments?,             // Информация о комментариях к записи (Nullable)
    val likes: Likes?,                 // Информация о лайках к записи (Nullable)
    val replyOwnerId: Int = 0,         // Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int = 0,          // Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean = false,  // true если запись была создана с опцией «Только для друзей»
    val canPin: Boolean = false,       // Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean = false,    // Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean = false,       // Информация о том, может ли текущий пользователь редактировать запись
    val attachments: Array<Attachments> = emptyArray()
)

data class Likes(
    val count: Int,                    // число пользователей, которым понравилась запись
    val userLikes: Boolean = false,    // наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean = true,       // может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean = true     // может ли текущий пользователь сделать репост записи
)

data class Coments(
    val count: Int,                      // количество комментариев
    val canPost: Boolean = true,         // информация о том, может ли текущий пользователь комментировать запись
    val groupsCanPost: Boolean = true,   // информация о том, могут ли сообщества комментировать запись
    val canClose: Boolean = false,       // может ли текущий пользователь закрыть комментарии к записи
    val canOpen: Boolean = false         // может ли текущий пользователь открыть комментарии к записи
)