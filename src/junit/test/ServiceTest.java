package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.service.QuestionTypeService;


public class ServiceTest {

	@Test
	public void test() {
		ApplicationContext c=new ClassPathXmlApplicationContext("beans.xml");
		QuestionTypeService s=(QuestionTypeService) c.getBean("questionTypeServiceImpl");
		List<Integer> list=s.getSubTypeid(new Integer[]{1});
		System.out.println(list);
	}
	@Test
	public void test2() {
	}

}
