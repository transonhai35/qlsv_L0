

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Student;
import controller.MethodsStudent;


public class Index {

    public static void main(String[] args) {   


        Scanner scanner = new Scanner(System.in);

        //Dynamic array
        Student[] listStudentsStaticArr = new Student[100];

        //Static array
        List<Student> listStudentsDynamicArray = new ArrayList<Student>();

        MethodsStudent methodsStudent = new MethodsStudent(listStudentsStaticArr, listStudentsDynamicArray);

        int yourChoice;
    
            do {
                System.out.println("===================Menu===================");
                System.out.println("Chọn loại mảng để lưu trữ");
                System.out.println("1: Mảng tĩnh");
                System.out.println("2: Mảng động");
                System.out.println("3: Thoát khỏi chương trình");
                System.out.println("==========================================");
                System.out.print("Nhập lựa chọn của bạn: ");
                yourChoice = scanner.nextInt();
                System.out.println("==========================================");
                switch (yourChoice){
                    case 1:
                        int choiceStaticArr;
                        do{
                            System.out.println("=============================");
                            System.out.println("1: Thêm sinh viên");
                            System.out.println("2: Tìm kiếm sinh viên theo id");
                            System.out.println("3: Cập nhật sinh viên");
                            System.out.println("4: Xóa sinh viên");
                            System.out.println("5: Xem danh sách sinh viên");
                            System.out.println("6: Thoát khỏi chương trình");
                            System.out.println("=============================");
                            System.out.print("Nhập lựa chọn của bạn : ");

                            choiceStaticArr= scanner.nextInt();
                            switch (choiceStaticArr) {
                                
                                case 1:
                                    methodsStudent.addStudentStaticArr();
                                    break;
                                case 2:
                                    methodsStudent.readStudentStaticArrById();
                                    break;
                                case 3:
                                    methodsStudent.updateStudentStaticArrById();
                                    break;
                                case 4:
                                    methodsStudent.destroyStudentStaticArrById();
                                    break;
                                case 5:
                                    methodsStudent.showListStudentsStaticArr();
                                    break;
                            }
                        }while(choiceStaticArr != 6);
                        break;
                    case 2:
                        int choiceDynamicArr;
                        do{
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
                            System.out.println("=============================");
                            System.out.print("Nhập lựa chọn của bạn: ");
                            choiceDynamicArr = scanner.nextInt();
                        switch (choiceDynamicArr){
                            case 1:
                                methodsStudent.addStudentDynamicArr();
                                break;
                            case 2:
                                methodsStudent.readStudentDynamicArrById();
                                break;
                            case 3:
                                methodsStudent.updateStudentDynamicArrById();;
                                break;
                            case 4:
                                methodsStudent.destroyStudentDynamicArrById();;
                                break;
                            case 5:
                                methodsStudent.showListStudentsDynamicArr();;
                                break;
                            case 6:
                                methodsStudent.showPercentageOfClassification();
                                break;
                            case 7:
                                methodsStudent.percentCpa();
                                break;
                            case 8:
                                methodsStudent.getStudentByClassification();
                                break;
                        }
                        }while (choiceDynamicArr !=9);
                        break;                        
                    case 3:
                        methodsStudent.saveStudentsDynamicArrToFile("studentsDynamicArr.txt");
                        methodsStudent.saveStudentsStaticArrToFile("studentsStaticArr.txt");
                        System.out.println("Danh sách sinh viên đã được lưu. Bạn đã chọn thoát khỏi chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } while (yourChoice != 3);            
            scanner.close();
    }
        

    
} 
       
        

