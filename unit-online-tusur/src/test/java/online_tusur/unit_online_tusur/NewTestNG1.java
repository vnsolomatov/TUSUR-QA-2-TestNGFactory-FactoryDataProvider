package online_tusur.unit_online_tusur;
import static org.testng.Assert.*;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.*;

public class NewTestNG1 {
	Student s = new Student();
	ArrayList <Student> arr = new ArrayList<Student>();

  @BeforeClass()
  public void setUp() {
	  arr = new ArrayList<Student>();
  }

  @AfterClass()
  public void tearDown() {
	  arr.clear();
  }
  
  @Test(groups = {"StudentTest"})
  public void testAge1() {
	  int age = 30;
	  s.setAge(age);
	  int expectedAge = 30;
	  assertEquals(expectedAge, s.getAge());
  }
  
  @Test(groups = {"StudentTest"}, enabled = true)
  public void testAge2() {
	  int age = 40;
	  s.setAge(age);
	  int expectedAge = 40;
	  assertEquals(expectedAge, s.getAge());
  }
  
  @Test(priority = 0, groups = {"StudentCollection"})
  public void testEmptyCollection() {
	  assertTrue(arr.isEmpty());
  }
  
  @Test(priority = 1, groups = {"StudentCollection"})
  public void testItemCollection() {
	  int k = arr.size();
	  arr.add(new Student("Piter","Pen",35));
	  assertEquals(k+1,arr.size());
  }
  
  @Test(priority = 2, groups = {"StudentCollection"}, dependsOnMethods = {"testItemCollection"})
  public void testNotEmptyCollection() {
	  assertFalse(arr.isEmpty());
  }
 
  @Test(priority = 0, groups = {"StudentCollection"}, expectedExceptions = {NullPointerException.class})
  public void testExceptCollection() {
	  arr = null;
	  int size = arr.size();
  }
  
}
