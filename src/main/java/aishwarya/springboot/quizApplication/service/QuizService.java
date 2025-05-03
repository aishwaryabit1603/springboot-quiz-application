package aishwarya.springboot.quizApplication.service;

import aishwarya.springboot.quizApplication.dao.QuestionDao;
import aishwarya.springboot.quizApplication.dao.QuizDao;
import aishwarya.springboot.quizApplication.model.Question;
import aishwarya.springboot.quizApplication.model.QuestionWrapper;
import aishwarya.springboot.quizApplication.model.Quiz;
import aishwarya.springboot.quizApplication.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    // now we need to store the questions in a Quiz
    // Table to show data 2nd Table Quiz Table

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ) ;

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK) ;
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestions();

        // now we have to convert each question into question wrapper
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int right = 0;
        Map<Integer, String> questionAnswerMap = new HashMap<>();
        for (Question q : questions) {
            questionAnswerMap.put(q.getId(), q.getRightAnswer());
        }

        // Compare each response with the correct answer
        for (Response response : responses) {
            String correctAnswer = questionAnswerMap.get(response.getId());
            if (correctAnswer != null && correctAnswer.equalsIgnoreCase(response.getResponse())) {
                right++;
            }
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
