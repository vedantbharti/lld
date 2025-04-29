package commonLLDQuestions.stackoverflow.repositories;

import commonLLDQuestions.stackoverflow.dao.Comment;
import commonLLDQuestions.stackoverflow.dao.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuesRepo {

    Map<Integer, Question> questions;

    private static QuesRepo quesRepo;

    private QuesRepo() {
        questions = new HashMap<>();
    }

    public static synchronized QuesRepo getInstance() {
        if(quesRepo==null) quesRepo = new QuesRepo();
        return quesRepo;
    }

    public void addQuestion(Question question) {
        questions.put(question.getQuesId(),question);
    }

    public Question getQuestionById(int questionId) {
        return questions.get(questionId);
    }

    public List<Question> getQuestionByTags(String tag) {
        List<Question> result = questions.values().stream().filter(ques -> ques.getTags().contains(tag)).collect(Collectors.toList());
        return result;
    }

    public List<Question> getQuestionsByUsers(int authorId){
        List<Question> result = questions.values().stream().filter(ques -> ques.getAuthorId()==authorId).collect(Collectors.toList());
        return result;
    }

    public synchronized int updateVoteCount(int questionId, int x){
        Question question = questions.get(questionId);
        int voteCount = question.getVoteCounts();
        voteCount = voteCount + x;
        question.setVoteCounts(voteCount);
        return voteCount;
    }

//    public void addComment(int questionId, int commentId){
//        Question question = questions.get(questionId);
//        List<Integer> comments = question.getComments();
//        comments.add(commentId);
//        question.setComments(comments);
//    }
//
//    public List<Integer> getAllCommentIds(int questionId){
//        return questions.get(questionId).getComments();
//    }
//
//    public void addAnswer(int questionId, int answerId){
//        Question question = questions.get(questionId);
//        List<Integer> answers = question.getAnswers();
//        answers.add(answerId);
//        question.setAnswers(answers);
//    }
//
//    public List<Integer> getAllAnsweIds(int questionId){
//        return questions.get(questionId).getAnswers();
//    }



}
