package commonLLDQuestions.stackoverflow.dao;

import java.util.Date;

public class Comment {

    private int commentId;
    private int authorId;
    private String content;
    private Date creationDate;
    private int ownerId;


    public Comment(int commentId, int authorId, int ownerId, String content) {
        this.commentId = commentId;
        this.authorId = authorId;
        this.ownerId = ownerId;
        this.content = content;
        creationDate = new Date();
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
