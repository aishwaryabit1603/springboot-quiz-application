package aishwarya.springboot.quizApplication.model;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="question")
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_title")
    private String questionTitle;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    public String getRightAnswer() {
        return rightAnswer;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    @Column(name = "right_answer")
    private String rightAnswer;

    @Column(name = "difficulty_level")
    private String difficultylevel;

    private String category;

}
