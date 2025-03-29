package service

import data.*
import exceptions.*

object WallService {
    private var postId = 0
    private var commentId = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()

    fun createComment(postID: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postID) {
                comments += comment.copy(id = ++commentId, refersToPostId = postID)
                return comments.last()
            }
        }
        throw PostNotFoundException()
    }

    fun createReportComment(report: ReportComment): Boolean {
        for (comment in comments) {
            if (comment.fromId == report.ownerId && comment.id == report.commentId) {
                if (report.reason in 0..6 || report.reason == 8) {
                    reportComments += report.copy()
                    return true
                }
                throw ReasonReportNotFoundException()
            }
        }
        throw CommentNotFoundException()
    }

    fun add(post: Post): Post {
        posts += post.copy(
            id = ++postId, likes = post.likes?.copy() ?: Likes(0),
            coments = post.coments?.copy() ?: Coments(0)
        )
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, actualPost) in posts.withIndex()) {
            if (actualPost.id == post.id) {
                posts[index] = post.copy(
                    likes = post.likes?.copy() ?: Likes(0),
                    coments = post.coments?.copy() ?: Coments(0)
                )
                return true
            }
        }
        return false
    }

    fun printPosts() {
        for (post in posts) {
            print(post)
            println()
        }
    }

    fun printComment() {
        for (comment in comments) {
            print(comment)
            println()
        }
    }

    fun printReportComment() {
        for (report in reportComments) {
            print(report)
            println()
        }
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
        commentId = 0
        comments = emptyArray()
    }
}