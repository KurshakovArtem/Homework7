package attachments

data class Photo(
    val id: Int,                                                 // Идентификатор фотографии
    val albumId: Int,                                            // Идентификатор альбома
    val ownerId: Int,                                            // Идентификатор владельца фотографии
    val date: Int,                                               // Дата добавления
    val userId: Int = 100,                                       // Идентификатор пользователя загрузившего фотографию
    val text: String = "Отсутствует",                            // Текст описания
    val width: Int = 1024,                                       // Щирина
    val height: Int = 768                                        // Высота
)

data class Video(
    val id: Int,                                                 // Идентификатор видеозаписи
    val ownerId: Int,                                            // Идентификатор владельца видеозаписи
    val date: Int,                                               // Дата создания видеозаписи
    val addingDate: Int,                                         // Дата добавления видеозаписи
    val duration: Int,                                           // Длительность ролика
    val title: String = "Отсутствует",                           // Название видеозаписи
    val description: String = "Отсутствует",                     // Текст описания видеозаписи
    val photo: String = "Отсутствует",                           // URL изображения-обложки
    val firstFrame: String = "Отсутствует",                      // URL изображения первого кадра
    val views: Int = 0,                                          // Количество просмотров
    val comments: Int = 0,                                       // Количество комментариев
    val canEdit: Boolean = true,                                 // Возможность редактировать видеозапись
    val canAdd: Boolean = true,                                  // Возможность добавить видеозапись к себе
    val isPrivate: Boolean = false                               // Видеозапись приватная
)

data class Audio(
    val id: Int,                                                 // Идентификатор аудиозаписи
    val ownerId: Int,                                            // Идентификатор владельца аудиозаписи
    val date: Int,                                               // Дата добавления
    val duration: Int,                                           // Длительность аудиозаписи
    val artist: String = "Неизвестен",                           // Исполнитель
    val title: String = "Неизвестна",                            // Название композиции
    val url: String = "Отсутствует",                             // Ссылка на mp3
    val lyricsId: Int = 0,                                       // Идентификатор текста аудиозаписи
    val albumId: Int = 0,                                        // Идентификатор альбома
    val genreId: Int = 0,                                        // Идентификатор жанра
    val noSearch: Boolean = false,                               // Не выводить при поиске
    val isHd: Boolean = false                                    // Высокое качество
)

data class Link(
    val url: String,                                             // URL ссылки
    val title: String = "Отсутствует",                           // Заголовок ссылки
    val caption: String = "Отсутствует",                         // Подпись ссылки
    val description: String = "Отсутствует",                     // Описание ссылки
    val photo: Photo = Photo(1, 1, 1, 1),// Изображение превью
    val previewPage: String = "Отсутствует",                     // Идентификатор вики-страницы для предпросмотра
    val previewUrl: String = "Отсутствует"                       // URL страницы для предпросмотра
)

data class Note(                                                 // Заметка
    val id: Int,                                                 // Идентификатор заметки
    val ownerId: Int,                                            // Идентификатор владельца заметки
    val date: Int,                                               // Дата создания заметки
    val comments: Int = 0,                                       // Количество комментариев
    val readComments: Int = 0,                                   // Количество прочитанных комментариев
    val viewUrl: String = "Отсутствует",                         // URL страницы для отображения заметки
    val title: String = "Отсутствует",                           // Заголовок заметки
    val text: String = "Отсутствует"                             // Текст заметки
)