package com.questions.app.Controller;

import com.questions.app.Model.Questions;
import com.questions.app.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")           // tüm soruları sıralama
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")     // category göre sıralama
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);


    }
                                           // soru ekleme

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
      return questionService.addQuestions(questions);

    }
    @DeleteMapping("/remove/{id}")   // soru silme
    public ResponseEntity<String > deleteQuestion(@PathVariable int id){
      return questionService.deleteQuestions(id);

    }
    @PutMapping("/put")           // güncelleme
    public ResponseEntity<String> putQuestion(@RequestBody Questions questions){
        return questionService.updateQuestions(questions);

    }
}
