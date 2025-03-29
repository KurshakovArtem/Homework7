import attachments.*
import data.*
import service.WallService
import exceptions.*

fun main() {
    val attachment: Attachments = AudioAttachments(Audio(1, 2, 1234, 120))
    println(attachment.type)

    val post = Post(
        10, 12, 23, 45, 1741444833, "Проверка",
        coments = Coments(1, canClose = true),
        likes = Likes(10),
        attachments = arrayOf(NoteAttachments(Note(1, 2, 5)), attachment)
    )
    val changePost = post.copy(canPin = true, canEdit = true, canDelete = true)
    val changePost2 = post.copy(id = 2, text = "проверка 2")
    val service = WallService
    println(service.add(post))
    println(service.add(changePost))
    println(service.update(changePost2))
    service.add(
        Post(
            4, 14, 11, 23, 1741444823, "Nullable проверка",
            coments = null,
            likes = null
        )
    )

    service.printPosts()

    service.createComment(1, Comment(1, 5, 1234121))
    try {
        service.createComment(7, Comment(2, 6, 41231))
    } catch (e: PostNotFoundException) {
        println(e)
    }

    service.createComment(3, Comment(4, 11, 124121))
    service.printComment()

    service.createReportComment(ReportComment(5, 1, 5))
    try {
        service.createReportComment(ReportComment(5, 1, 7))
    } catch (e: ReasonReportNotFoundException) {
        println(e)
    }
    try {
        service.createReportComment(ReportComment(6, 1, 5))
    } catch (e: CommentNotFoundException) {
        println(e)
    }
    service.printReportComment()

}