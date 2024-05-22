package controller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.Classification;

import Model.Student;
import Util.GetDataInput;

public class MethodsStudent {   


    private Student[] listStudentsStaticArr = new Student[100];

    private List<Student> listStudentsDynamicArr = new ArrayList<Student>();

    private static final String FILE_PATH = "QLSV.iml";

    Map<Double, Integer> cpaToCountMap = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    GetDataInput getDataInput = new GetDataInput();

    //check data is invalid
    private boolean dataIsInvalid = true;

    public  MethodsStudent(Student[] listStudentsStaticArr, List<Student> listStudentsDynamicArr){
        this.listStudentsDynamicArr = listStudentsDynamicArr;
        this.listStudentsStaticArr = listStudentsStaticArr;
    }

    //method static array

    //findstudent
    public Student findStudentStaticArrById(String id){
        //find student have id
        for (Student student : this.listStudentsStaticArr) {
            if(student != null){
                if (student.getId() == Integer.parseInt(id)) {
                    dataIsInvalid = false;
                    return student;
                }
            }else {
                dataIsInvalid = true;
            }
        }
        if (dataIsInvalid){
            System.out.println("Không có sinh viên nào có mã sỗ như bạn vừa nhập");
        }
        return null;
    }

    //create
    public void addStudentStaticArr() {
       
                String name = getDataInput.enterName();
                String idNo = getDataInput.enterIdNoStaticArr(this.listStudentsStaticArr);
                String address = getDataInput.enterAddress();
                Double height = getDataInput.enterHeight();
                Double weight = getDataInput.enterWeight();
                LocalDate dateOfBirth = getDataInput.enterDateOfBirth();
                String school = getDataInput.enterSchool();
                Double cpa = getDataInput.enterCpa();
                String yearStart = getDataInput.enterYearStart();
                // insert new student
                for(int i = 0; i< this.listStudentsStaticArr.length; i++){
                   if(this.listStudentsStaticArr[i] == null) {
                        listStudentsStaticArr[i] = new Student(
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
                            System.out.println("Đã thêm: " +  listStudentsStaticArr[i]);
                            return;
                        }
               }
           
    }
    
    //read
    public void readStudentStaticArrById(){
        System.out.println("Nhập id: ");
        String idNo = this.scanner.nextLine();

        //find student have id
        Student student = this.findStudentStaticArrById(idNo);

            if (student != null) {
                System.out.println(student.toString());
            }

            if (dataIsInvalid){
                System.out.println("Dữ liệu không phù hợp");
            }
    }

    //update
    public void updateStudentStaticArrById() {

        System.out.println("Nhập id: ");
        String id = this.scanner.nextLine();
        
        // MethodsStudent methodsStudent = new MethodsStudent(this.listStudents);

        Student foundStudent = this.findStudentStaticArrById(id);

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
                        for (Student student: this.listStudentsStaticArr) {        
                                student.setName(newName);
                                break;
                        }   
                        break;
                    case 2:
                        String newAddress = getDataInput.enterAddress();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setAdress(newAddress);
                                break;
                        }
                        break;
                    case 3:
                        Double newHeight = getDataInput.enterHeight();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setHeight(newHeight);
                                break;
                        }
                        break;
                    case 4:
                        Double newWeight = getDataInput.enterWeight();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setWeight(newWeight);
                                break;
                        }
                        break;
                    case 5:
                        System.out.print("Nhập MSSV: ");
                        String newIdNo= this.scanner.nextLine();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setIdNo(newIdNo);
                                break;
                        }
                        break;
                    case 6:
                        String newSchool = getDataInput.enterSchool();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setSchool(newSchool);
                                break;
                        }
                        break;
                    case 7:
                        String newYearStart = getDataInput.enterYearStart();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setYearStart(newYearStart);
                                break;
                        }
                        break;
                    case 8:
                        Double newCpa = getDataInput.enterCpa();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setCpa(newCpa);
                                break;
                        }
                        break;
                    case 9:
                        LocalDate newDateOfBirth = getDataInput.enterDateOfBirth();
                        for (Student student: this.listStudentsStaticArr) {
                                student.setDateOfBirth(newDateOfBirth);
                                break;
                        }
                        break;
                }
                System.out.println("Cập nhật thành công: ");
                System.out.println(foundStudent.toString());
                return;
           
        } else {
            System.out.println("Không tìm thấy sinh viên có: " + id);
        }
    }

    //delete static array
    public void destroyStudentStaticArrById(){
        
        boolean found = false;
        int foundIndex = -1;

        System.out.println("Nhập id: ");
        String id = this.scanner.nextLine();
    
        // Tìm vị trí của sinh viên trong mảng
        for (int i = 0; i < this.listStudentsStaticArr.length; i++) {
            if (listStudentsStaticArr[i] != null && listStudentsStaticArr[i].getIdNo().equals(id)) {
                found = true;
                foundIndex = i;
                break;
            }
        }
    
        if (found) {
            for (int i = foundIndex; i < this.listStudentsStaticArr.length - 1; i++) {
                listStudentsStaticArr[i] = listStudentsStaticArr[i + 1];
            }
            listStudentsStaticArr[listStudentsStaticArr.length - 1] = null;
    
            System.out.println("Xóa sinh viên có mssv là " + id);
        } else {
            System.out.println("Không tìm thấy sinh viên có mssv là " + id);
        }
    }

    //show static array
    public void showListStudentsStaticArr() {
        for (Student student : this.listStudentsStaticArr) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }

    // method dynamic array

    //show list student
    public void showListStudentsDynamicArr() {
        for (Student student : this.listStudentsDynamicArr) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }

    //find student by id
    public Student findStudentDynamicArrById(String id){
            //find student have id
            for (Student student : this.listStudentsDynamicArr) {
                if (student.getId()== Integer.parseInt(id)) {
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
    public void addStudentDynamicArr() {

                String name = getDataInput.enterName();
                String idNo = getDataInput.enterIdNo(this.listStudentsDynamicArr);
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
                this.listStudentsDynamicArr.add(newStudent);
                newStudent.toString();
    }

    //read
    public void readStudentDynamicArrById(){
        System.out.println("Nhập id: ");
        String id = this.scanner.nextLine();

        //find student have id
        Student student = this.findStudentDynamicArrById(id);

            if (student != null) {
                System.out.println(student.toString());
            }

            if (dataIsInvalid){
                System.out.println("Dữ liệu không phù hợp");
            }
    }

    //update
    public void updateStudentDynamicArrById() {

        System.out.println("Nhập id: ");
        String id = this.scanner.nextLine();
        
        // MethodsStudent methodsStudent = new MethodsStudent(this.listStudents);

        Student foundStudent = this.findStudentDynamicArrById(id);

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
                    for (Student student: this.listStudentsDynamicArr) {
                            student.setName(newName);
                            break;
                    }
                        break;
                    case 2:
                        String newAddress = getDataInput.enterAddress();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setAdress(newAddress);
                                break;
                        }
                        break;
                    case 3:
                        Double newHeight = getDataInput.enterHeight();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setHeight(newHeight);
                                break;
                        }
                        break;
                    case 4:
                        Double newWeight = getDataInput.enterWeight();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setWeight(newWeight);
                                break;
                        }
                        break;
                    case 5:
                        System.out.print("Nhập MSSV: ");
                        String newIdNo= getDataInput.enterIdNo(listStudentsDynamicArr);
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setIdNo(newIdNo);
                                break;
                        }
                        break;
                    case 6:
                        String newSchool = getDataInput.enterSchool();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setSchool(newSchool);
                                break;
                        }
                        break;
                    case 7:
                        String newYearStart = getDataInput.enterYearStart();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setYearStart(newYearStart);
                                break;
                        }
                        break;
                    case 8:
                        Double newCpa = getDataInput.enterCpa();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setCpa(newCpa);
                                student.updateClassification();
                                break;
                        }
                        break;
                    case 9:
                        LocalDate newDateOfBirth = getDataInput.enterDateOfBirth();
                        for (Student student: this.listStudentsDynamicArr) {
                                student.setDateOfBirth(newDateOfBirth);
                                break;
                        }
                        break;
                }
                System.out.println("Cập nhật thành công: ");
                System.out.println(foundStudent.toString());
                return;
           
        } else {
            System.out.println("Không tìm thấy sinh viên có: " + id);
        }
    }

    //delete
    public void destroyStudentDynamicArrById() {
        
        System.out.println("Nhập id: ");
        String id = this.scanner.nextLine();


        Student foundStudent = this.findStudentDynamicArrById(id);
    
         // found student
         if (foundStudent != null) {
            this.listStudentsDynamicArr.remove(foundStudent);
            System.out.println("Đã xóa sinh viên có ID " + id);
        } else {
            System.out.println("Không tìm thấy sinh viên có ID " + id + " trong danh sách");
        }
    }


    public void showPercentageOfClassification() {
        Map<Classification, Integer> classificationCounts = new HashMap<>();
    
        for (Student student : this.listStudentsDynamicArr) {
            classificationCounts.put(student.getClassification(), classificationCounts.getOrDefault(student.getClassification(), 0) + 1);
        }
    
        int totalStudents = this.listStudentsDynamicArr.size();
    
        System.out.println("Phần trăm học lực:");
        for (Map.Entry<Classification, Integer> entry : classificationCounts.entrySet()) {
            double percentage = (double) entry.getValue() / totalStudents * 100;
            System.out.println(entry.getKey() + ": " + percentage + "%");
        }
    }

    //PercentClassification
    public void percentCpa() {

        for (Student cpa : this.listStudentsDynamicArr) {
            cpaToCountMap.put(cpa.getCpa(), cpaToCountMap.getOrDefault(cpa.getCpa(),    0) + 1);
        }

        for (Map.Entry<Double, Integer> entry : cpaToCountMap.entrySet()) {
            double mediumScore = entry.getKey();
            int count = entry.getValue();
            double percentCpa = (double) count / this.listStudentsDynamicArr.size() * 100;
            System.out.println(mediumScore + ": " + percentCpa + "%");
        }
    }

    //getStudentClassification
    public void getStudentByClassification(){

        System.out.print("Nhập học lực muốn tìm kiếm (POOR, WEAK, AVERAGE, GOOD, VERY_GOOD, EXCELLENT): ");
        String getClassification  = scanner.nextLine();

        // Hiển thị danh sách sinh viên có học lực như đã nhập
        System.out.println("Danh sách sinh viên có học lực: " + getClassification + ":");
        for (Student student : listStudentsDynamicArr) {
            if (student.getClassification().name().equals(getClassification)) {
                System.out.println(student.toString());
            }
        }
    }

    // save students to file
    public void saveStudentsDynamicArrToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : this.listStudentsDynamicArr) {
                // Ghi thông tin của mỗi sinh viên vào tệp
                writer.println(student.toString());
            }
            System.out.println("Danh sách sinh viên đã được lưu vào tệp " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu trữ danh sách sinh viên vào tệp " + fileName);
            e.printStackTrace();
        }
    }

    public void saveStudentsStaticArrToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : this.listStudentsStaticArr) {
                if(student != null){
                    // Ghi thông tin của mỗi sinh viên vào tệp
                    writer.println(student.toString()); 
                }
            }
            System.out.println("Danh sách sinh viên đã được lưu vào tệp " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu trữ danh sách sinh viên vào tệp " + fileName);
            e.printStackTrace();
        }
    }
    

}