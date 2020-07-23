package example.thread_data_synchronization;

//multiple thread working with same class object needs synchronization
class Student{
    public synchronized void call(String name) throws InterruptedException {
        for (int i=0;i<5;i++) {
            System.out.println("Hello :"+name);
            Thread.sleep(1000);
        }
    }
}

class Student_Caller extends Thread{
    Student student;
    String name;

    Student_Caller(Student student,String name){
        this.student=student;
        this.name=name;
    }

    @Override
    public void run() {
        try {
            student.call(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}

public class Synchronized_Example {
    public static void main(String[] args) {
        Student student=new Student();
        Student_Caller student_caller=new Student_Caller(student,"sagar");
        Student_Caller student_caller1=new Student_Caller(student,"sourab");
        Student_Caller student_caller2=new Student_Caller(student,"navin");
        student_caller.start();
        student_caller1.start();
        student_caller2.start();
    }
}


