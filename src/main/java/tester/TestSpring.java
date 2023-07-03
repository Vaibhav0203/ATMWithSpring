package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// starting Spring Container (SC)  uding xml based instruction 
		// src/main/resourses
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC up n running!!!!!");
			//autocloseable
			// get rdy to use atm bean from SC
			ATMImpl ref1 = ctx.getBean("my_atm", ATMImpl.class);
			ref1.withdraw(1000);
			ATMImpl ref2 = ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1 == ref2);//f
		} // ctx.close() ---> ctx : SC --chks for any singleton beans --destroy --called
			// -- marked for GC, sc shuts down!
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
