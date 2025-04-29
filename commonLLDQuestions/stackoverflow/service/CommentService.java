package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.Comment;
import commonLLDQuestions.stackoverflow.repositories.CommentRepo;

import java.util.List;

public interface CommentService {

    public void addComment(Comment comment);

    public List<Integer> getAllCommentsForOwner(int ownerId);
}
