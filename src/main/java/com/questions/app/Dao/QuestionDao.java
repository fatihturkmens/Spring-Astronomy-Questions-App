package com.questions.app.Dao;

import com.questions.app.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {
  List<Questions> findByCategory(String category);


}
