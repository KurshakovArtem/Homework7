package service

import data.*
import exceptions.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before


class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun createCorrectCommentPostIdTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921, refersToPostId = 0)
        service.createComment(1, comment)
        assertEquals(1, service.createComment(1, comment).refersToPostId)
    }

    @Test
    fun createCorrectCommentIdTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921)
        service.createComment(1, comment)
        assertEquals(2, service.createComment(1, comment).id)
    }

    @Test
    fun createReportCommentTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921)
        service.createComment(1, comment)
        val report = service.createReportComment(ReportComment(5, 1, 3))
        assertTrue(report)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowCreateCommentTest() {
        val service = WallService
        val comment = Comment(1, 5, 14921, refersToPostId = 0)
        service.createComment(1, comment)
    }

    @Test(expected = ReasonReportNotFoundException::class)
    fun shouldThrowReasonReportCommentTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921)
        service.createComment(1, comment)
        service.createReportComment(ReportComment(5, 1, 7))
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowNotFoundOwnerReportCommentTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921)
        service.createComment(1, comment)
        service.createReportComment(ReportComment(4, 1, 8))
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowNotFoundIdReportCommentTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        val comment = Comment(5, 5, 14921)
        service.createComment(1, comment)
        service.createReportComment(ReportComment(5, 2, 8))
    }

    @Test
    fun addTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        val firstId = service.add(post).id
        assertEquals(1, firstId)
    }

    @Test
    fun updateTestTrue() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        assertTrue(service.update(post.copy(1)))
    }

    @Test
    fun updateTestFalse() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = Likes(5)
        )
        service.add(post)
        assertFalse(service.update(post.copy(2)))
    }

    @Test
    fun likesNullableTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = Coments(1),
            likes = null
        )
        assertEquals(Likes(0), service.add(post).likes)
    }

    @Test
    fun comentsNullableTest() {
        val service = WallService
        val post = Post(
            17, 11, 14, 17, 1741444833, "Проверочный текст",
            coments = null,
            likes = Likes(0)
        )
        assertEquals(Coments(0), service.add(post).coments)
    }
}