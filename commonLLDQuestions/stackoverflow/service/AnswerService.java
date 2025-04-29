package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.Answer;
import commonLLDQuestions.stackoverflow.repositories.AnswerRepo;
import commonLLDQuestions.stackoverflow.repositories.QuesRepo;

import java.util.List;

public class AnswerService {

    AnswerRepo answerRepo = AnswerRepo.getInstance();

    public void addAnswer(Answer answer){
        answerRepo.addAnswer(answer);
    }

    public  int addVote(int answerId, int x){
        answerRepo.updateVoteCount(answerId,x);
        return answerRepo.getAnswer(answerId).getVoteCounts();
    }

    public int getVoteCount(int answerId){
        return answerRepo.getAnswer(answerId).getVoteCounts();
    }

    public List<Answer> getAllAnswersForAQues(int questionId){
        return answerRepo.getAllAnswersForAQues(questionId);
    }
}
