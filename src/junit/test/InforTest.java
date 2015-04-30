package junit.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class InforTest {

	@Test
	public void test() {
		List list=new ArrayList();
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.get(1));
	}
	@Test
	public void test2() {
	}

}
