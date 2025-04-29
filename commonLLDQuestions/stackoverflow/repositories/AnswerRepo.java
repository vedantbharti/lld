package commonLLDQuestions.stackoverflow.repositories;

import commonLLDQuestions.stackoverflow.dao.Answer;
import commonLLDQuestions.stackoverflow.dao.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerRepo {

    private Map<Integer, Answer> answers;

    private static AnswerRepo answerRepo;

    private AnswerRepo(){
        answers = new HashMap<>();
    }

    public static synchronized AnswerRepo getInstance(){
        if(answerRepo==null) answerRepo = new AnswerRepo();
        return answerRepo;
    }

    public void addAnswer(Answer answer) {
        answers.put(answer.getAnswerId(),answer);
    }

    public Answer getAnswer(int answerId){
        return answers.get(answerId);
    }

    public List<Answer> getAllAnswersForAQues(int questionId){
        return answers.values().stream().filter(answer -> answer.getQuestionId()==questionId).collect(Collectors.toList());
    }

    public synchronized int updateVoteCount(int answerId, int x){
        Answer answer = answers.get(answerId);
        int voteCount = answer.getVoteCounts();
        voteCount = voteCount + x;
        answer.setVoteCounts(voteCount);
        return voteCount;
    }

//    public void addComment(int answerId, int commentId){
//        Answer answer = answers.get(answerId);
//        List<Integer> comments = answer.getComments();
//        comments.add(commentId);
//        answer.setComments(comments);
//    }
//
//    public List<Integer> getAllCommentIds(int answerId){
//        return answers.get(answerId).getComments();
//    }
}
