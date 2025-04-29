package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.Comment;
import commonLLDQuestions.stackoverflow.repositories.AnswerCommentRepo;
import commonLLDQuestions.stackoverflow.repositories.CommentRepo;

import java.util.List;

public class AnsCommentService implements CommentService{

    CommentRepo commentRepo = AnswerCommentRepo.getInstance();

    public void addComment(Comment comment) {
        commentRepo.addComment(comment);
    }

    public List<Integer> getAllCommentsForOwner(int answerId){
        return commentRepo.getAllCommentsForOwner(answerId);
    }
}
