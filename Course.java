package p3;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.FileReader;


public class Course {
	
	int read;
	String classType;
	String classID;
	public void showClass() {
	 try {
		 
			FileReader reader = new FileReader("Courses.txt");
			read = reader.read();
			
			while (read != -1) {
				
				System.out.print((char)read);
				read =reader.read();
			}
			System.out.println("\n");
			
		}
			catch (FileNotFoundException e) {
				System.out.println("Courses.txt does not exsit, creating a new file...");
				Writer writer;
				try {
					writer = new FileWriter("Courses.txt");
					writer.close();
					}
					
				catch (IOException o) {
					o.printStackTrace();
					}	
		} 
				catch (IOException e) {
					e.printStackTrace();
					}	
}
	
	void setClassType(String classType){
		this.classType = classType;
	}
	void setClassID(String classID){
		this.classID = classID;
		
	}
	void courses() {
		
	}
	
	String getClassType(){
		return classType;
	}
	
	String getClassID(){
		return classID;
	}
	
	
}
