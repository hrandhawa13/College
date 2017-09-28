/**
*
*College class which is the main class for creating the instance of the college 
*
* @author Harmanjit Randhawa 
* @version September 21, 2017
*/

import java.util.ArrayList;

public class College {
	private ArrayList<Student> collegeList;
    /**
     * Default constructor with no arguments
     */
   public College(){
      collegeList = new ArrayList<Student>();
   }
   /**
   * constructor with 1 arguments
   * @param stu It is the first student that is to be added into the arraylist
   */
   public College(Student stu){
      collegeList = new ArrayList<Student>();
      add(stu);
      }
   /**
   * Adds student object to the arraylist
   * @param stu student It is the student that is to be added into the arraylist
   */
   public void add( Student stu ){
      collegeList.add( stu );
      }
   /**
   * Finds student object fromn the arraylist
   * @param number It is the student number that is to be found from the arraylist
   * @return Returns the student object whose student number matches the parameter
   */   
   public Student find ( int number ){
      Student stu;
      int size = collegeList.size();
      for (int i =0; i< size; i++){
         stu = collegeList.get(i);
         if ( stu.getStudentNum() == number ){
            return stu;
            }
         }
      System.out.println(" No student with ID " + number + " exist");
      return null;
      }
    /**
   * Finds login ID of the student from the college 
   * @param number It is the student number of the student that is to be found from the arraylist
   * @return Returns the login ID whose student number matches the parameter
   */   
   public String getLoginID( int number ){
      Student stu = find ( number );
      return stu.getLoginID();
      }
   /**
   * Removes student from the college
   * @param number It is the student number of the student that is to be removed from the arraylist
   * @return Returns the student whose student number matches the parameter
   */   
   public Student remove ( int number ){
      Student stu;
      int size = collegeList.size();
      for (int i =0; i< size; i++){
         stu = collegeList.get(i);
         if ( stu.getStudentNum() == number ){
            Student removed = stu;
            collegeList.remove(i);
            return removed;
            }
         }
      System.out.println(" No student with ID " + number + " exist");
      return null;
      }
   /**
   * Adds course to the student
   * @param points It is the grade point earned by student in a course
   * @param credits It is the credits completed by student in that particular course
   * @param studentNum It is the student number of the student who completed the course
   * @return Returns true if course is added and false otherwise
   */     
   public boolean addCourse( double points, double credits, int studentNum ){
      Student stu = find( studentNum );
      if ( stu == null){
         return false;
         }
      stu.addCourse( points, credits );
      return true;
      }
   /**
   * Gets the student whose GPA is highest
   * @return Returns the student whose GPA is highest
   */     
   public Student getHighestGPAStudent(){
      Student stu;
      Student topper = new Student () ;//allocate memory 
      int size = collegeList.size();
      double max = 0;
      for (int i =0; i< size; i++){
         stu = collegeList.get(i);
         if ( max < stu.getGPA() ){
            max = stu.getGPA();
            topper.copyInfo(stu);
            }
         }
      return topper;
      }
   /**
   * Gets total number of students in the course
   * @return Returns the total number of the students
   */   
   public int getTotalNumberOfStudents(){
      return collegeList.size();
      }
   /**
   *Prints all the students in the college
   */      
   public void printAll(){
      Student stu;
      int size = collegeList.size();
      for (int i =0; i< size; i++){
         stu = collegeList.get(i);
         System.out.println( stu.to_String() );
      }
   }
   /**
   * Returns all the info of all students in college
   * @return Returns all info of the students in college
   */   
   public String to_String(){
      Student stu;
      int size = collegeList.size();
      String str = "";
      for (int i =0; i< size; i++){
         stu = collegeList.get(i);
         str += stu.to_String() + "\n";
      }
      return str;
   }
}
