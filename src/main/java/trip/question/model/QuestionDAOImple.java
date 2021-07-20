package trip.question.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionDAOImple implements QuestionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap; 
	
	public QuestionDAOImple() {
	
	}
	
	public List questionList() {
		List list = sqlMap.selectList("questionList");
		return list;
	}
	
}
