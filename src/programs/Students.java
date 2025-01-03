package programs;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    public String NameID;
    public String information;
    public Student(String name, String information){
        this.NameID = name;
        this.information = information;
    }
}

public class Students {
    public static void showStudent(Student student){
        System.out.println("Student "+student.NameID);
        System.out.println(student.information);
        System.out.println();
    }
    public static void showStudents(ArrayList<Student> students){
        for (Student student: students){
            showStudent(student);
        }
    }
    public static ArrayList<Student> removeStudent(ArrayList<Student> students, String name){
        students.removeIf(student -> student.NameID.equals(name));
        return students;
    }
    public static ArrayList<Student> addStudent(ArrayList<Student> students, String name, String inf){
        Student newOne = new Student(name, inf);
        students.add(newOne);
        return students;
    }
    public static ArrayList<Student> editStudent(ArrayList<Student> students, String name, String inf){
        for (Student student: students){
            if (student.NameID.equals(name)) {
                student.information = inf;
            }
        }
        return students;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentsArray = new ArrayList<Student>();
        String command;
        String name;
        String information;
        while (true){
            System.out.print("Command (add, edit, remove, get_all, get, stop, clear): ");
            command = scanner.nextLine();
            if (command.equals("stop")){
                break;
            }
            else if (command.equals("add")){
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Information: ");
                information = scanner.nextLine();
                studentsArray = addStudent(studentsArray, name, information);
            }
            else if (command.equals("remove")){
                System.out.print("Name: ");
                name = scanner.nextLine();
                studentsArray = removeStudent(studentsArray, name);
            }
            else if (command.equals("edit")){
                System.out.print("Name: ");
                name = scanner.nextLine();
                System.out.print("Information: ");
                information = scanner.nextLine();
                studentsArray = editStudent(studentsArray, name, information);
            }
            else if (command.equals("get_all")){
                showStudents(studentsArray);
            }
            else if (command.equals("clear")){
                studentsArray = new ArrayList<Student>();
            }
            else {
                System.out.print("Name: ");
                name = scanner.nextLine();
                for (Student student: studentsArray){
                    if (student.NameID.equals(name)){
                        showStudent(student);
                    }
                }
            }
        }
        scanner.close();
    }
}
