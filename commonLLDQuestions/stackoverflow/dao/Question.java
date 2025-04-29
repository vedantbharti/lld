package commonLLDQuestions.stackoverflow.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {

    int quesId;
    String title;
    String content;
    int authorId;
//    List<Integer> answers;
//    List<Integer> comments;
    List<String> tags;
    int voteCounts;
    Date creationDate;

    public Question(int quesId, String title, String content, int authorId, Date creationDate, List<String> tags) {
        this.quesId = quesId;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.creationDate = creationDate;
        this.tags = tags;
        this.voteCounts = 0;
//        this.answers = new ArrayList<>();
//        this.comments = new ArrayList<>();
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

//    public List<Integer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(List<Integer> answers) {
//        this.answers = answers;
//    }
//
//    public List<Integer> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Integer> comments) {
//        this.comments = comments;
//    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getVoteCounts() {
        return voteCounts;
    }

    public void setVoteCounts(int voteCounts) {
        this.voteCounts = voteCounts;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
