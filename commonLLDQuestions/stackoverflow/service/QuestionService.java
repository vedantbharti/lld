package commonLLDQuestions.stackoverflow.service;

import commonLLDQuestions.stackoverflow.dao.Question;
import commonLLDQuestions.stackoverflow.repositories.QuesRepo;

import java.util.List;

public class QuestionService {

    QuesRepo quesRepo = QuesRepo.getInstance();

    public void addQuestion(Question question) {
        quesRepo.addQuestion(question);
    }

    public  int addVote(int questionId, int x){
        quesRepo.updateVoteCount(questionId,x);
        return quesRepo.getQuestionById(questionId).getVoteCounts();
    }

    public int getVoteCount(int questionId){
        return quesRepo.getQuestionById(questionId).getVoteCounts();
    }

    public List<Question> getQuestionsByUsers(int authorId) {
        return quesRepo.getQuestionsByUsers(authorId);
    }

    public List<Question> getQuestionByTags(String tag) {
        return quesRepo.getQuestionByTags(tag);
    }
}
