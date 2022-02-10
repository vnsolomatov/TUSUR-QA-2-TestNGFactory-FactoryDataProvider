package online_tusur.unit_online_tusur;

import org.testng.annotations.*;

public class NewTestNGParam {
	
	  @DataProvider(name = "dataAges")
	  public static Object[][] getAverAge() {
		  return new Object[][] {
			  {"18,19,20,21,22,23,24,25","21"}, 
			  {"26,27,28,29,30,31,32,33,34,35,36","31"},
			  {"37,38,39,40,41,42,43,44,45,46,47,48,49","43"},
		  };
	  }
		
	  @Test(dataProvider = "dataAges")
	  void testAverAge(String ages, String expectedAverAge) {
		  String[] ageA = ages.split(",");
			Student[] sA = new Student[ageA.length];
			for (int i = 0; i < ageA.length; i++) {
				sA[i] = new Student();
				sA[i].setAge(Integer.parseInt(ageA[i]));
			}
	        assert Integer.parseInt(expectedAverAge) == Student.avgAge(sA);
	  }	
  
  @Test
  @Parameters({"averAge","ages"})
  public void params(@Optional("0")int averAge, @Optional("null")String ages) {
	  String[] ageA = ages.split(",");
		Student[] sA = new Student[ageA.length];
		for (int i = 0; i < ageA.length; i++) {
			sA[i] = new Student();
			sA[i].setAge(Integer.parseInt(ageA[i]));
		}
      assert averAge == Student.avgAge(sA);
  }
  
}
