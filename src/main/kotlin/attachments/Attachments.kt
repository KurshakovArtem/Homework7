package attachments

sealed class Attachments(val type: String)

data class PhotoAttachments(val photo: Photo) : Attachments("photo")

data class VideoAttachments(val video: Video) : Attachments("video")

data class AudioAttachments(val audio: Audio) : Attachments("audio")

data class LinkAttachments(val link: Link) : Attachments("link")

data class NoteAttachments(val note: Note) : Attachments("note")

data class AbsentAttachments(val message: String = "Вложение Отсутствует") : Attachments("Attachment missing")