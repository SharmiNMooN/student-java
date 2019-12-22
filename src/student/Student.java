package student;

import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Thread reg = new StudentThread(new StuRegRunnable());
        reg.start();
    }
    
}




class StudentThread extends Thread{
    Runnable r;
    public StudentThread(Runnable r){
        this.r = r;
    
    }
    public void run(){
    try{
       r.run();
    }catch(Exception e){
        System.out.println("An Exception occur : "+ e.getMessage());
    }
    }
}
class StuRegRunnable implements Runnable,StudentRegistration{
    String name;
    String dept;
    int id;
    int intake;
   
    Scanner s = new Scanner(System.in);
    public void run(){
        try{
            System.out.println("Enter name: ");
            String n = s.nextLine(); 
            System.out.println("Enter Department: ");
            String d = s.nextLine();
            System.out.println("Enter id: ");
            int id1 = s.nextInt();
             System.out.println("Enter intake: ");
            int intake1 = s.nextInt();
            register(n,d,id1,intake1);
            printStudent();
            
            
        }catch(Exception e) {
            System.out.println("An Exception occur : "+ e.getMessage());

        }
        
    }
    public void register(String name,String department,int id,int intake){
        this.name = name;
        this.dept = department;
        this.id = id;
        this.intake = intake;
    }
    public void printStudent(){
        System.out.println("name: "+this.name +" department: "+this.dept+" id: "+this.id+ " intake: "+this.intake);
    
    
    }
}



