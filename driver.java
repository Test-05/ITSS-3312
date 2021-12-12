package p3;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;


public class driver {

	public static void main(String[] args) {
		boolean loop = true;
		boolean loop2 = true;
		boolean CMSsystem = false;
		boolean SMSsystem = false;
		boolean system = true;
		int read;
		int id;
		int i =0;
		int idChoice;
		int b;
		int c;
		int d =0;
		
		String level = "null";
		String status;
		String fname;
		String lname;
		String info;
		String course;
		String job = null;
		String jobChoice;
		String jobType = null;
		String txtLine = null;
		String classType = null;
		String classID = null;
		ArrayList txtList;
		
		Scanner input = new 
		Scanner(System.in);
		Course classs = new Course();
		Student student = new Student();
		Student_Employee employee = new Student_Employee();
		// Reserve enough spaces in the object list for students at the beginning
		System.out.println("How many student are there?");
		ArrayList<String> courses = new ArrayList<String>();
		Student[] studentList = new Student [input.nextInt()];
		String[] fnameSort = new String [studentList.length];
		Student_Employee[] stuempList = new Student_Employee [studentList.length];
		//list length testing
		//System.out.println("list length =" + studentList.length);
		
		
		//SMS system part
		
		while (system == true) {
			System.out.println("please select the system you want to enter" + "\n" + "1: Student Management System" + "\n" + "2: Course Management System" + "\n0: Exit");
				
		switch (input.next()) {
	
		case "1":
			SMSsystem = true;
			break;
		case "2":
			CMSsystem = true;
			break;
		case "0":
			system = false;
			System.out.println("bye");
			break;
		default:
				System.out.println("Enter either s or c to choose a system");
				break;
		}
		
		
		
		while (SMSsystem == true) {
			System.out.println("\n"+"\n"+"Main Menu");
			System.out.println("1: Add a student");
			System.out.println("2: Activate / deactivate a student");
			System.out.println("3: Display all students and generate a report");
			System.out.println("4: Search a student by ID");
			System.out.println("5: Assign an on-campus job");
			System.out.println("6: Display student with a job");
			System.out.println("0: Exit");
			
			switch (input.nextInt()) {
			
			 case 1:
				 input.nextLine();
				 //random not repeating number 0-99
				 id = (int) (0 + Math.random() * 99 );
				 
				 for (i=0; i < studentList.length;) {
					 if (studentList[i] == null) {
						 i++;
						 continue;
					 }
					 else if (id == studentList[i].id) {
						 id ++;
						 i++;
					 }
					 else {
						 i++;
						 continue;
					 }
				 }
				 // set up student information.
			
				 System.out.println("Please enter the first name of this student.");
				 fname = input.nextLine();
				 System.out.println("Please enter the last name of this student.");
				 lname = input.nextLine();
				 
				 
				 System.out.println("What grade is this student in?" + "\n" + "F: Freshman\nSo: Sophmore\nJ: Junior\nS: Senior" );	 
				 loop = true;
				 while(loop == true) {
					 
				 switch (input.nextLine().toLowerCase()) {
				 	
				 	case "f":
				 		level = "Freshman";
				 		loop = false;
				 		break;
				 		
				 	case "so":
				 		level = "Sophmore";
				 		loop = false;
				 		break;
				 		
				 	case "j": 
				 		level = "Junior";
				 		loop = false;
				 		break;
				 		
				 	case "s":
				 		level = "Senior";
				 		loop = false;
				 		
				 		break;
				 		
				 		default:
				 			System.out.println("please select a grade level");
				 			
				 	}
				 }
				 
				 status = "Active";
				 job = "none";
				 for (i=0; i < studentList.length;) {
					 if (studentList[i] == null) {
						 student  = new	Student (id, level,status,fname,lname,job );  
						 studentList[i] = student;
				 System.out.println("Student " + fname + " " + lname + " is added to the student list, id: " + id);
				 
				 	break;
					 }
					 else if (i == studentList.length-1 ) {
						  System.out.println("No enough space in the student list for this student");
					break;
					 }
					 else {
						i++;
					 }
				 }
				
				 break;
				 
		 
			 case 2:
				 input.nextLine();
				 for (i =0; i < studentList.length;) {
					 
				 
					 if (studentList[i] == null) {
						  
						  i++;
					 }
					 else {
						 System.out.println(studentList[i].id + " " + studentList[i].fname + " " + studentList[i].lname + "  Status: "+ studentList[i].status);
						  i++;
					 }
				 } 
					 System.out.print("Select an ID to switch status");
					 idChoice = input.nextInt();
					 
					 for(i=0; i<studentList.length;) {
						 
						 
						 if (i == studentList.length -1) {
							 System.out.println("No student has this ID" + "\n");
							 break;
							 }
						 
						 
						 
						 if (studentList[i] == null) {
							//System.out.println(i);
							 i++;
						 	}
							 
						 else if (studentList[i].id == idChoice) {
						   
						   if (studentList[i].status == "Active") {
						 studentList[i].status = "Inactive";
						 System.out.print(studentList[i].fname + " " + studentList[i].lname + " " + "is now deactivated");
						 break;
						   } 
					 
						   else {
						 studentList[i].status = "Active";
						 
						System.out.print(studentList[i].fname + " " + studentList[i].lname + " " + "is now Activated");
						break;
						   }
						   
					 }
						 else {
							 i++;
						 }
					}
					 
						 
					 
				  
				 break;
				 
				 
			// display student all student in ascending order (first name).
			 case 3:
				 
				Writer writer;
				try {
					writer = new FileWriter("StudentRecord.txt");
				
				
				 
				 input.nextLine();
				b=0;
				 for (i =0; i < studentList.length;) {
					 
					 
					 if (studentList[i] == null) {
						  
						  i++;
					 }
					 else {
						 fnameSort[b] = studentList[i].fname;
						 b++;
						 i++;
					 }
				   }
				 Arrays.sort(fnameSort, 0, b);
				 b=0;
				 
				 for (c=0; c < studentList.length; ) {
				 
				   for  (i =0; i < studentList.length;) {
					   if (studentList[i] == null) {
						   i++;
					   }
					   else if (fnameSort[b] == studentList[i].fname) {
						   studentList[i].display();
						   System.out.println("\n");
						
						   
						   //writing file
						   info = studentList[i].info();
						  writer.append(info);
						  writer.append("\n");
						    b++;
						   i = studentList.length;  
					   }
					   else {
						   i++;
					   }
					  
				   }
				   c++;
			} 
				writer.close(); } 
				catch (IOException e) {
				
				e.printStackTrace();
			}
				c=0;
				  break;	 	
			
				  
				  
				  // search for a student by ID
			 case 4:
				 input.nextLine();
				
				 
				 System.out.println("Enter student ID to search for a student");
				 idChoice = input.nextInt();
				 
				 for (i =0; i <studentList.length;) {
					 
					 
					  if (i == studentList.length -1) {
							 System.out.println("No student has this ID" + "\n");
						break;
						 }
					 if (studentList[i] == null) {
						 i++;
					 }
				
					 else if (idChoice == studentList[i].id) {
				studentList[i].display();	
				 System.out.println("Status: " + studentList[i].status);
				 break;
				 }
				  	 
				
				 else {
					 i++;
				 }

			}
				 
			 break;
			 
			 case 0:
				SMSsystem = false; 
			 	break;
			 	
			 	default:
			 		break;
			 		
			 		
			 		
			 	case 5:
			 		 input.nextLine();
			 		 loop = true;
			 		 loop2 = true;
			 		 while (loop == true) {
			 		 System.out.println("Please select the on-campus job you  want to assign" + "\n" + "T:Teaching assistant " + "\n" + "R:Research assistant");
			 		 jobChoice = input.nextLine();	
			 		 jobChoice = jobChoice.toLowerCase();
			 		 if("t".equals(jobChoice)) {
			 			 job = "Teaching assistant";
			 			loop = false;
			 		 }
			 		 else if ("r".equals(jobChoice)) {
			 			 job = "Research assistant";
			 			 loop = false;
			 		 }
			 		 else if ("n".equals(jobChoice)) {
			 			 loop = false;
			 			 loop2=false;
			 		 }
			 		 else
			 			 System.out.println("Invaild choice");
			 		 }
			 		 
			 		 while (loop2 == true) {
				 		 System.out.println("Select job type: \nF: Full-time\nP: Part-time\nN: exit;");
				 		 jobType = input.nextLine();	
				 		 jobType = jobType.toLowerCase();
				 		 if("f".equals(jobType)) {
				 			 jobType = "Full-time";
				 			loop2 = false;
				 			loop = true;
				 		 }
				 		 else if ("p".equals(jobType)) {
				 			 jobType = "Part-time";
				 			 loop2 = false;
				 			 loop = true;
				 		 }
				 		 else if ("n".equals(jobType)) {
				 			 loop2 = false;
				 			 loop = false;
				 		 }
				 		 else
				 			 System.out.println("Invaild choice");
				 		 }

			 		
			 		 
			 		 while (loop == true) {
			 		 System.out.println("Please enter the student ID that you want to assign an on-campus job");
			 		 
			 		 idChoice = input.nextInt();
			 		 for (i =0; i <studentList.length;) {
						 
						  if (i == studentList.length -1) {
								 System.out.println("No student has this ID" + "\n");
								loop = false;
							break;
							 }
						   if (studentList[i] == null) {
							 i++;
							 
						 }
						 else if ( idChoice == studentList[i].id) {
							 
							 stuempList[i] = new Student_Employee(studentList[i].id,studentList[i].fname, studentList[i].lname, job,jobType);
							
						
							System.out.println("Job assigned");
							 i = studentList.length;
							 loop = false;
							 
						 }
						 else {
							 i++;
							
						 }
						 
						}
			 		 }
						 break;
						 
						 
						 
						 
						 // 6: display student with a job
						 case 6: 
							 for (i=0; i<stuempList.length;) {
								 if (stuempList[i] == null) {
									 i++;
								 }
								 else  {
									 stuempList[i].displayemp();
									 System.out.println("\n");
									 i++;
								 }
								
							 }
							 break;
			 		 
			 		 
			 		 
	   }
	 }
   
	
		
		
		
		
		while (CMSsystem == true) {
			//input.nextLine();
			System.out.println("\n\n\nWelcome to CMC system");
			System.out.println("1: Add a course");
			System.out.println("2: Assign a class for student");
			System.out.println("3: Display all students with their classes");
			System.out.println("0: Exit");
			
			
			switch (input.nextInt()) {
		
			
			
			//Add new course (To courses.txt)
			case 1:
				input.nextLine();
				System.out.println("Current classes: \n");
			
				classs.showClass();
				
				System.out.println("Enter the new class type (example:ITSS), or enter 0 to quit");
				
				classType = input.nextLine();
				System.out.println(classType);
				
				if (classType.equals("0")) {
					
				
					break;
				}
				
				
				System.out.println("Enter the new class type (example:3312), or enter 0 to quit");
				classID= input.nextLine();
				if (classType.equals("0")) {
					break;
				}
				
				//  Class type and ID, write into the txt.
				info = classType+classID;
				classs.setClassType(classType);
				classs.setClassID(classID);
				courses.add(info);
				
			
				
					Writer writer;
					try {
						writer = new FileWriter ("Courses.txt",true);
						writer.append(info + "\n");
						System.out.println("course added");
						writer.close();
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}
				//}
				
				break;
				
				
			
			// Add course to student(write to courseassignment.txt)
			case 2:
				input.nextLine();
				for (i =0; i < studentList.length;) {
					 
					 
					 if (studentList[i] == null) {
						  
						  i++;
					 }
					 else {
						 System.out.println(studentList[i].id + " " + studentList[i].fname + " " + studentList[i].lname);
						  i++;
					 }
				 } 
					 System.out.print("Select an ID to assign a class");
					 
					 idChoice = input.nextInt();
					 
					 for (i =0; i <studentList.length;) {
						 
						 
						  if (i == studentList.length -1) {
								 System.out.println("No student has this ID" + "\n");
							break;
							 }
						 if (studentList[i] == null) {
							 i++;
						 }
					
						 else if (idChoice == studentList[i].id) {
							
							  
							 System.out.println("Type in the course you want to assign to " + studentList[i].fname + " " + studentList[i].lname);
							 System.out.println("Current available classes: ");
							 classs.showClass();
							 
							 input.nextLine();
							 course = input.nextLine();
							 course = course.toLowerCase();
							 
							 // Check courses.txt to ensure it's an available class
							try {
								BufferedReader reader = new BufferedReader(new FileReader("Courses.txt"));
							
									txtLine = reader.readLine();
									txtList = new ArrayList();
									while(txtLine!=null)
									{
									txtLine = txtLine.toLowerCase();
									txtList.add(txtLine);
									txtLine = reader.readLine();
									}
									
									if (txtList.contains(course)) {
									//	Writer writer;
										try {
											writer = new FileWriter ("CourseAssignment.txt",true);
											writer.append("\n" + studentList[i].id + " " + studentList[i].getFullname() + " Assigned Courses: " + course );
											System.out.println("Course has been assigned to :"+ studentList[i].getFullname() );
										
											writer.close();
									} catch (IOException e) {
											e.printStackTrace();
											System.out.println("Error when writing CourseAssignment.txt");
										}
										
									}		
									else {
										System.out.println("No this class in record");
									}
							}
								catch (IOException e) {
									
									e.printStackTrace();
									System.out.println("Error found");
								}
							
							i = studentList.length;
							  break;		 
					 }
						 else {
							 i++;
						 }
					 }
					 break;
					 
					 
			//Display student with their classes (read from courseassignment.txt)		 
			case 3:
				
				 try {
						FileReader reader = new FileReader("CourseAssignment.txt");
						read = reader.read();
						
						while (read != -1) {
							
							System.out.print((char)read);
							read =reader.read();
						}
						System.out.println("\n");
						
					}
						catch (FileNotFoundException e) {
							System.out.println("Please assign classes to student first");
							
					} 
							catch (IOException e) {
								System.out.println("Error found");
								e.printStackTrace();
								}	
			
		

				
				
				
				
					 break;
					 
			case 0:
			 
					CMSsystem = false; 
				 	break;
				 	
				 	
			default:
				break;
				 	
				
				
				
				
				
				
			// CMS system - switch		 
			}
		
			
			//CMS system	
		}
		
		
		
		
		
	
		
		//first interface
		}
		
		
		
		
//Two main		
	}
}
