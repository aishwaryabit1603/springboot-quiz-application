package aishwarya.springboot.quizApplication.controller;

import aishwarya.springboot.quizApplication.model.Question;
import aishwarya.springboot.quizApplication.model.QuestionWrapper;
import aishwarya.springboot.quizApplication.model.Response;
import aishwarya.springboot.quizApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title ) ;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        // now we want to send data with some data hiding
        // like when passing quiz we don't want to pass the answer
        // therefore we will use wrapper
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
