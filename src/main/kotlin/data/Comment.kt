package data

import attachments.*

data class Comment(
    val id: Int,                                           // Идентификатор комментария
    val fromId: Int,                                       // Идентификатор автора комментария
    val date: Int,                                         // Дата создания комментария
    val refersToPostId: Int = 0,                           // Пост к которому относится комментарий
    val text: String = "Отсутствует",                      // Текст комментария
    val donut: Donut = Donut(),                            // Информация о VK Donut
    val replyToUser: Int = 0,                              // Идентификатор общества или пользователя,
                                                           // в ответ к которому оставлен комментарий
    val replyToComment: Int = 0,                           // Идентификатор комментария,
                                                           // в ответ к которому оставлен комментарий
    val attachments: Attachments = AbsentAttachments(),    // Вложения комментария
    val parentsStack: Array<Int> = emptyArray(),           // Массив идентификаторов родительских комментариев
    val thread: Thread = Thread(0)                   // Информация о вложенной ветке комментариев
)

data class ReportComment(
    val ownerId: Int,                                      // Идентификатор сообщества или пользователя,
                                                           // которому принадлежит комментарий
    val commentId: Int,                                    // Идентификатор комментария
    val reason: Int
    /* Причина жалобы:
    0 - спам
    1 - детская порнография
    2 - экстремизм
    3 - насилие
    4 - пропаганда наркотиков
    5 - материал для взрослых
    6 - оскорбление
    8 - призыв к суициду
    */
)


data class Donut(
    val isDon: Boolean = false,                            // Является ли комментатор подписчиком VK Donut
    val placeholder: String = ""                           // Заглушка для пользователей которые не оформили подписку
)

data class Thread(
    val count: Int,                                        // Количество комментариев в ветке
    val canPost: Boolean = true,                           // Может ли текущий пользователь оставлять комментарий
    val showReplyButton: Boolean = true,                   // Нужно ли отображать кнопку "Ответить" в ветке
    val groupsCanPost: Boolean = true                      // Могут ли сообщества оставлять комментарии в ветке
)
