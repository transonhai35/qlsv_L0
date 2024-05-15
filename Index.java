
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Student;
import controller.MethodsStudent;

public class Index {

    //Static array
    // Student[] listStudents = new Student[100];

    //Dynamic array
    List<Student> listStudents = new ArrayList<Student>();

    Scanner scanner = new Scanner(System.in);

    public void main(String[] args) {   


        MethodsStudent methodsStudent = new MethodsStudent(listStudents);

        int yourChoice;

        do {
            System.out.println("===================Menu===================");
            System.out.print("Nhập lựa chọn của bạn: ");
            System.out.println("=============================");
            System.out.println("1: Thêm sinh viên");
            System.out.println("2: Tìm kiếm sinh viên theo Id");
            System.out.println("3: Cập nhật sinh viên");
            System.out.println("4: Xóa sinh viên");
            System.out.println("5: Xem danh sách sinh viên");
            System.out.println("6: Xem phầm trăm học lực");
            System.out.println("7: Xem phần trăm GPA đã sắp xếp");
            System.out.println("8: Lấy danh sách sinh viên theo học lực");
            System.out.println("9: Thoát khỏi chương trình");
            System.out.println("==========================================");       
            yourChoice = scanner.nextInt();

            switch (yourChoice) {
                case 1:
                    methodsStudent.addStudent();
                    break;
                case 2:
                    methodsStudent.readStudentById();
                    break;
                case 3:
                    methodsStudent.updateStudentById();
                    break;
                case 4:
                    methodsStudent.destroyStudentById();
                    break;
                case 5:
                    methodsStudent.showListStudents();
                    break;
                case 6:
                    methodsStudent.showPercentageOfClassification();
                    break;
                case 7:
                    methodsStudent.PercentCpa();
                    break;
                case 8:
                    methodsStudent.getStudentByClassification();
                    break;
                case 9:
                    System.out.println("Bạn đã chọn thoát khỏi chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (yourChoice != 8);

        methodsStudent.saveStudentsToFile("listStudents");
        scanner.close();
    }
} 
       
        

