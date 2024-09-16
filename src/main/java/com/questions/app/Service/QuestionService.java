package com.questions.app.Service;

import com.questions.app.Dao.QuestionDao;
import com.questions.app.Model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;




    public ResponseEntity<List<Questions>> getAllQuestions() {/// tüm soruları sıralama

      try {
          return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
      } catch (Exception e){
          e.printStackTrace();
      }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {     // category göre sıralama
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<String>  addQuestions(Questions questions) {              // questions ekleme
        questionDao.save(questions);

        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
   public ResponseEntity<String> deleteQuestions(@PathVariable int id){      /// questions silme
        questionDao.deleteById(id);
        return new ResponseEntity<>("removed",HttpStatus.OK);
   }


   public ResponseEntity<String> updateQuestions(Questions questions){
        questionDao.findById(questions.getId()).orElseThrow();
        questionDao.save(questions);
      return new  ResponseEntity<>("updated",HttpStatus.OK);






   }
}






