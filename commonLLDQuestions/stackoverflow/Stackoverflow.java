package commonLLDQuestions.stackoverflow;

import commonLLDQuestions.stackoverflow.dao.Answer;
import commonLLDQuestions.stackoverflow.dao.Comment;
import commonLLDQuestions.stackoverflow.dao.Question;
import commonLLDQuestions.stackoverflow.dao.User;
import commonLLDQuestions.stackoverflow.repositories.AnswerRepo;
import commonLLDQuestions.stackoverflow.repositories.CommentRepo;
import commonLLDQuestions.stackoverflow.repositories.QuesRepo;
import commonLLDQuestions.stackoverflow.repositories.UserRepo;
import commonLLDQuestions.stackoverflow.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Stackoverflow {

    public static void main(String[] args) {


        //create user

        User user1 = new User(1,"user1", "user1@gmail.com");
        User user2 = new User(2,"user2", "user2@gmail.com");
        User user3 = new User(3,"user3", "user3@gmail.com");
        User user4 = new User(4,"user4", "user4@gmail.com");
        User user5 = new User(5,"user5", "user5@gmail.com");

        UserService userService = new UserService();

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);

        //create Questions:
        Question ques1 = new Question(1,"que1", "que1",1,new Date(),new ArrayList<>(Arrays.asList("A","B","C")));
        Question ques2 = new Question(2,"que2", "que2",2,new Date(),new ArrayList<>(Arrays.asList("A","B")));
        Question ques3 = new Question(3,"que3", "que3",3,new Date(),new ArrayList<>(Arrays.asList("A","C")));

        QuestionService questionService = new QuestionService();

        questionService.addQuestion(ques1);
        questionService.addQuestion(ques2);
        questionService.addQuestion(ques3);

        //answers

        Answer answer1 = new Answer(1,1,"ans1",1);
        Answer answer2 = new Answer(2,1,"ans2",2);
        Answer answer3 = new Answer(3,2,"ans3",1);

        AnswerService answerService = new AnswerService();
        answerService.addAnswer(answer1);
        answerService.addAnswer(answer2);
        answerService.addAnswer(answer3);

        // Comments on question

        Comment comment1 = new Comment(1,1,1,"comment1");
        Comment comment2 = new Comment(2,2,1,"comment2");

        CommentService quesCommentService = new QuesCommentService();
        quesCommentService.addComment(comment1);
        quesCommentService.addComment(comment2);

        // Comment on answer

        Comment comment3 = new Comment(3,3,2,"comment1");
        Comment comment4 = new Comment(4,4,2,"comment2");

        CommentService answerCommentService = new AnsCommentService();
        answerCommentService.addComment(comment3);
        answerCommentService.addComment(comment4);

        //add vote to questions and answers

        questionService.addVote(1,1);
        questionService.addVote(2,-1);

        System.out.println("Vote count for question id 1 is: " + questionService.getVoteCount(1));
        System.out.println("Vote count for question id 2 is: " + questionService.getVoteCount(2));


        answerService.addVote(1,1);
        answerService.addVote(2,1);

        System.out.println("Vote count for answer id 1 is: " + answerService.getVoteCount(1));
        System.out.println("Vote count for answer id 2 is: " + answerService.getVoteCount(2));


        //get all comments for a question:

        System.out.println("comment ids for question 1 are: " + quesCommentService.getAllCommentsForOwner(1));
        System.out.println("comment ids for answer 2 are: " + answerCommentService.getAllCommentsForOwner(2));

        // get all answers for a question:
        System.out.println("Answers for question 1 are: " + answerService.getAllAnswersForAQues(1));

        // get all questions for a user:
        System.out.println("All questions for user 1 are: " + questionService.getQuestionsByUsers(1));

        //search based on:

        System.out.println("All questions for a tag 'A' are: " + questionService.getQuestionByTags("A"));

    }
}
