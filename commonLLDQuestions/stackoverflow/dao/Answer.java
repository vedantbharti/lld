package commonLLDQuestions.stackoverflow.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer {
    private int answerId;
    private int questionId;
    private String content;
    private int authorId;
    private int voteCounts;
//    private List<Integer> comments;
    private Date creationDate;

    public Answer(int answerId, int questionId, String content, int authorId) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.content = content;
        this.authorId = authorId;
//        this.comments = new ArrayList<>();
        this.creationDate = new Date();
        this.voteCounts = 0;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

//    public List<Integer> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Integer> comments) {
//        this.comments = comments;
//    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getVoteCounts() {
        return voteCounts;
    }

    public void setVoteCounts(int voteCounts) {
        this.voteCounts = voteCounts;
    }
}
