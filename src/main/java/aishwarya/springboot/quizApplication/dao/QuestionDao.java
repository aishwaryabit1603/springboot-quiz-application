package aishwarya.springboot.quizApplication.dao;

import aishwarya.springboot.quizApplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
    List<Question> findByCategory(String category);

    @Query(value = "Select * from question q where LOWER(q.category) = LOWER(:category) order by RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
}
