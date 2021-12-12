package p3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Student {

	int id;
	String level;
	String status;
	String fname;
	String lname;
	String job;
	String jobType;
	int read;
	
	public Student() {
		
	}
	Student(int id, String level, String status, String fname, String lname, String job) {
		
		this.id = id;
		this.level = level;
		this.status = status;
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		
	}
	
	public void display(){
		System.out.println( this.id + ": " + this.fname + " " + this.lname + "\n" + "Level:" + this.level);
		
	}
	
	public String getfname() {
		return this.fname;
	}
	public String info() {
		return  id + ", " + fname + " " + lname + " " + ", "+ level + ", " + "Status: " + status;
	}
	 public int getid() {
		return this.id;
	}
	 public String getlname() {
			return this.lname;
		}
	 public String getFullname() {
		 	return this.fname + " " + this.lname + " ";
	 }
	 public String getjob() {
			return this.job;
		}

}

class Student_Employee extends Student {
	
	
	
	// Student_Employee(int id, String level, String status, String fname, String lname, String job) {
	//	super(id, level, status, fname, lname, job);
		
	//}
	
	void displayemp() {
	
		System.out.println(getfname() + " " + getlname() + "\n" + "On campus job: " + this.jobType + "  " +getjob());
	}

	 String empInfo (){
			return  this.id + " " + this.fname + " " + this.lname + " Job: " +this.jobType + "  " + this.job; 
	}
	 
	 Student_Employee (int id, String fname, String lname, String job, String jobType){
		 	this.id = id;
		 	this.fname = fname;
			this.lname = lname;
			this.job = job;
			this.jobType = jobType;
	 }
	 Student_Employee(){
		 
	 }
}


	
	