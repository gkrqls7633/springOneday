package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//책 입력 기능 DAO 메소드 생성
	public int Insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	
	//책 상세 DAO 메소드 자성
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
}

