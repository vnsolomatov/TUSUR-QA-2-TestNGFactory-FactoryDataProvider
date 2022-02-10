package online_tusur.unit_online_tusur;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class TestFactory {
	private String ages, averAge;
	public TestFactory(String ages, String averAge) {
		this.ages = ages;
		this.averAge = averAge;
	}

    @Test
    void testAverAge() {
	    String[] ageA = ages.split(" ");
		Student[] sA = new Student[ageA.length];
		for (int i = 0; i < ageA.length; i++) {
			sA[i] = new Student();
			sA[i].setAge(Integer.parseInt(ageA[i]));
		}
		System.out.println("TestNGFactory: actual averAge="+Student.avgAge(sA));
        assert Integer.parseInt(averAge) == Student.avgAge(sA);
    }
}

public class TestNGFactory {
	@Factory
	public Object[] factoryMethod() {
		return new Object[] {
				new TestFactory("18 19 20 21 22 23 24 25","21"), 
				new TestFactory("26 27 28 29 30 31 32 33 34 35 36","31"),
				new TestFactory("37 38 39 40 41 42 43 44 45 46 47 48 49","43"),
		};
	}	
}