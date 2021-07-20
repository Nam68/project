package trip.question.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import trip.question.model.QuestionDAO;
import trip.question.model.QuestionDTO;

public class QuestionServiceImple implements QuestionService {
	
	@Autowired
	QuestionDAO dao;
	
	public QuestionServiceImple() {
	
	}
	
	public List questionList() {
		List list = dao.questionList();
		return list;
	}
	
}
