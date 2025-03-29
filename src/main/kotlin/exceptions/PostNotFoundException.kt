package exceptions

class PostNotFoundException(message: String = "Пост не найден") : RuntimeException(message)

class ReasonReportNotFoundException(message: String = "Причина жалобы не установленна") : RuntimeException(message)

class CommentNotFoundException(message: String = "Комментарий не найден") : RuntimeException(message)