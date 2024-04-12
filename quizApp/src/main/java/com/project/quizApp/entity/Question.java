package com.project.quizApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Question {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "category")
	    private String category;

	    @Column(name = "difficulty_level")
	    private String difficultyLevel;

	    @Column(name = "option1")
	    private String option1;

	    @Column(name = "option2")
	    private String option2;

	    @Column(name = "option3")
	    private String option3;

	    @Column(name = "option4")
	    private String option4;

	    @Column(name = "question_title")
	    private String questionTitle;

	    @Column(name = "right_answer")
	    private String rightAnswer;

}
