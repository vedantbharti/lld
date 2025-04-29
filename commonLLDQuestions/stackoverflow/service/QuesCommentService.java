package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.Comment;
import commonLLDQuestions.stackoverflow.repositories.CommentRepo;
import commonLLDQuestions.stackoverflow.repositories.QuestionCommentRepo;

import java.util.List;

public class QuesCommentService implements CommentService{

    CommentRepo commentRepo = QuestionCommentRepo.getInstance();

    public void addComment(Comment comment) {
        commentRepo.addComment(comment);
    }

    public List<Integer> getAllCommentsForOwner(int questionId){
        return commentRepo.getAllCommentsForOwner(questionId);
    }
}
