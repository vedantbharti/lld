package commonLLDQuestions.stackoverflow.repositories;

import commonLLDQuestions.stackoverflow.dao.Comment;

import java.util.List;
import java.util.Map;

public interface CommentRepo{

    public void addComment(Comment comment);

    public Comment getComment(int commentId);

    public List<Integer> getAllCommentsForOwner(int ownerId);
}
