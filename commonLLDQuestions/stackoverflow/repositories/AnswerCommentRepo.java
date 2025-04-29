package commonLLDQuestions.stackoverflow.repositories;

import commonLLDQuestions.stackoverflow.dao.Comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerCommentRepo implements CommentRepo{

    private Map<Integer, Comment> comments;

    private static CommentRepo commentRepo;

    private AnswerCommentRepo(){
        comments = new HashMap<>();
    }

    public static synchronized CommentRepo getInstance(){
        if(commentRepo==null) commentRepo = new AnswerCommentRepo();
        return commentRepo;
    }

    public void addComment(Comment comment) {
        comments.put(comment.getCommentId(),comment);
    }

    public Comment getComment(int commentId){
        return comments.get(commentId);
    }

    public List<Integer> getAllCommentsForOwner(int answerId){
        return comments.values().stream().filter(comment -> comment.getOwnerId()==answerId).map(comment -> comment.getCommentId()).collect(Collectors.toList());
    }
}
