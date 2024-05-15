package controller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.Classification;
import Model.Student;
import Util.GetDataInput;

public class MethodsStudent {   

    private  List<Student> listStudents;
    private Student[] listStudentsStatic;

    private static final String FILE_PATH = "QLSV.iml";

    Map<Double, Integer> cpaToCountMap = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    GetDataInput getDataInput = new GetDataInput();

    //check data is invalid
    private boolean dataIsInvalid = true;

    public  MethodsStudent(List<Student> listStudents){
        this.listStudents = listStudents;
    }


    public void showListStudents() {
        for (Student student : this.listStudents) {
            if (student != null) {
                System.out.println("Sinh viên:");
                System.out.println(student.toString());
            }
        }
    }

    //find student by id
    public Student findStudentById(String idNo){
        // Boolean foudIdNo = false;
            //find student have id
            for (Student student : listStudents) {
                if (student.getIdNo().equals(idNo)) {
                    dataIsInvalid = false;
                    return student;
                }
            }
        if (dataIsInvalid){
            System.out.println("Không có sinh viên nào có mã sỗ như bạn vừa nhập");
        }
        return null;
    }

    //create
    public void addStudent() {

        try {
            System.out.println("Nhập số lượng sinh viên bạn muốn thêm: ");
            int n = this.scanner.nextInt();
            for(int i = 0; i<n ; i++){
                System.out.println("Nhập thông tin sinh viên thứ " + (i+1));
                String name = getDataInput.enterName();
                String idNo = getDataInput.enterIdNo(this.listStudents);
                String address = getDataInput.enterAddress();
                Double height = getDataInput.enterHeight();
                Double weight = getDataInput.enterWeight();
                LocalDate dateOfBirth = getDataInput.enterDateOfBirth();
                String school = getDataInput.enterSchool();
                Double cpa = getDataInput.enterCpa();
                String yearStart = getDataInput.enterYearStart();
                  // create new student
                Student newStudent = new Student(
                    name,
                    idNo,         
                    address,
                    height,
                    weight,
                    dateOfBirth,
                    school,
                    cpa,
                    yearStart
                );

                // insert array
                this.listStudents.add(newStudent);
            }
        }catch (java.util.InputMismatchException e){
            System.out.println(e);
        }     

    }

    //read
    public void readStudentById(){
        System.out.println("Nhập MSSV ( = 10 kí tự): ");
        String idNo = this.scanner.nextLine();

        //find student have id
        Student student = this.findStudentById(idNo);

            if (student != null) {
                System.out.println(student.toString());
            }

            if (dataIsInvalid){
                System.out.println("Dữ liệu không phù hợp");
            }
    }

    //update
    public void updateStudentById() {

        System.out.println("Nhập MSSV ( = 10 kí tự): ");
        String idNo = this.scanner.nextLine();
        
        // MethodsStudent methodsStudent = new MethodsStudent(this.listStudents);

        Student foundStudent = this.findStudentById(idNo);

        if (foundStudent != null) {
                System.out.println("Bạn muốn cập nhật gì? ");
                System.out.println("1: Name");
                System.out.println("2: Địa chỉ");
                System.out.println("3: Chiều cao");
                System.out.println("4: Cân nặng");
                System.out.println("5: Mã số sinh viên");
                System.out.println("6: Tên trường");
                System.out.println("7: Năm bắt đầu");
                System.out.println("8: Gpa");
                System.out.println("9: Ngày sinh");
                System.out.print("Nhập lựa chọn: ");
                Integer n = this.scanner.nextInt();
                switch (n){
                    case 1:
                        String newName = getDataInput.enterName();
                        // update
                    for (Student student: this.listStudents) {
                        if (student.getIdNo() == idNo) {
                            student.setName(newName);
                            break;
                        }
                    }
                        break;
                    case 2:
                        String newAddress = getDataInput.enterAddress();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setAdress(newAddress);
                                break;
                            }
                        }
                        break;
                    case 3:
                        Double newHeight = getDataInput.enterHeight();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setHeight(newHeight);
                                break;
                            }
                        }
                        break;
                    case 4:
                        Double newWeight = getDataInput.enterWeight();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setWeight(newWeight);
                                break;
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Nhập MSSV: ");
                        String newIdNo= this.scanner.nextLine();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setIdNo(newIdNo);
                                break;
                            }
                        }
                        break;
                    case 6:
                        String newSchool = getDataInput.enterSchool();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setSchool(newSchool);
                                break;
                            }
                        }
                        break;
                    case 7:
                        String newYearStart = getDataInput.enterYearStart();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setYearStart(newYearStart);
                                break;
                            }
                        }
                        break;
                    case 8:
                        Double newCpa = getDataInput.enterCpa();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setCpa(newCpa);
                                break;
                            }
                        }
                        break;
                    case 9:
                        LocalDate newDateOfBirth = getDataInput.enterDateOfBirth();
                        for (Student student: this.listStudents) {
                            if (student.getIdNo() == idNo) {
                                student.setDateOfBirth(newDateOfBirth);
                                break;
                            }
                        }
                        break;
                }
                System.out.println("Cập nhật thành công: ");
                System.out.println(foundStudent.toString());
                return;
           
        } else {
            System.out.println("Không tìm thấy sinh viên có: " + idNo);
        }
    }

    //delete
    public void destroyStudentById() {
        
        System.out.println("Nhập MSSV ( = 10 kí tự): ");
        String idNo = this.scanner.nextLine();

        MethodsStudent methodsStudent = new MethodsStudent(this.listStudents);

        Student foundStudent = methodsStudent.findStudentById(idNo);
    
         // found student
         if (foundStudent != null) {
            listStudents.remove(foundStudent);
            System.out.println("Đã xóa sinh viên có ID " + idNo);
        } else {
            System.out.println("Không tìm thấy sinh viên có ID " + idNo + " trong danh sách");
        }
    }


    //delete static array
    public void destroyStudentStaticArrById(){
        
        boolean found = false;
        int foundIndex = -1;

        System.out.println("Nhập MSSV ( = 10 kí tự): ");
        String idNo = this.scanner.nextLine();
    
        // Tìm vị trí của sinh viên trong mảng
        for (int i = 0; i < listStudentsStatic.length; i++) {
            if (listStudentsStatic[i] != null && listStudentsStatic[i].getIdNo().equals(idNo)) {
                found = true;
                foundIndex = i;
                break;
            }
        }
    
        if (found) {
            for (int i = foundIndex; i < listStudentsStatic.length - 1; i++) {
                listStudentsStatic[i] = listStudentsStatic[i + 1];
            }
            listStudentsStatic[listStudentsStatic.length - 1] = null;
    
            System.out.println("Xóa sinh viên có mssv là " + idNo);
        } else {
            System.out.println("Không tìm thấy sinh viên có mssv là " + idNo );
        }
    }


    public void showPercentageOfClassification() {
        Map<Classification, Integer> classificationCounts = new HashMap<>();
    
        for (Student student : listStudents) {
            classificationCounts.put(student.getClassification(), classificationCounts.getOrDefault(student.getClassification(), 0) + 1);
        }
    
        int totalStudents = listStudents.size();
    
        System.out.println("Phần trăm học lực:");
        for (Map.Entry<Classification, Integer> entry : classificationCounts.entrySet()) {
            double percentage = (double) entry.getValue() / totalStudents * 100;
            System.out.println(entry.getKey() + ": " + percentage + "%");
        }
    }

    //PercentClassification
    public void PercentCpa() {

        for (Student cpa : this.listStudents) {
            cpaToCountMap.put(cpa.getCpa(), cpaToCountMap.getOrDefault(cpa.getCpa(),    0) + 1);
        }

        for (Map.Entry<Double, Integer> entry : cpaToCountMap.entrySet()) {
            double mediumScore = entry.getKey();
            int count = entry.getValue();
            double percentCpa = (double) count / this.listStudents.size() * 100;
            System.out.println(mediumScore + ": " + percentCpa + "%");
        }
    }

    //getStudentClassification
    public void getStudentByClassification(){

        System.out.print("Nhập học lực muốn tìm kiếm (POOR, WEAK, AVERAGE, GOOD, VERY_GOOD, EXCELLENT): ");
        String getClassification  = scanner.nextLine();

        // Hiển thị danh sách sinh viên có học lực như đã nhập
        System.out.println("Danh sách sinh viên có học lực: " + getClassification + ":");
        for (Student student : listStudents) {
            if (student.getClassification().name().equals(getClassification)) {
                System.out.println(student.toString());
            }
        }
    }

    // Phương thức để lưu danh sách sinh viên vào file
    public void saveStudentsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : this.listStudents) {
                writer.println(student.toString()); // Ghi thông tin của mỗi sinh viên vào tệp
            }
            System.out.println("Danh sách sinh viên đã được lưu vào tệp " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu trữ danh sách sinh viên vào tệp " + fileName);
            e.printStackTrace();
        }
}
    

}