package Util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Model.Student;
import Validate.Validate;


public class GetDataInput {

    Scanner scanner = new Scanner(System.in);

    public String enterName(){
         String name = null;
      do {
          try {
            System.out.print("Nhập tên (tối đa 100 kí tự): ");
            name = this.scanner.nextLine();
            if (Validate.checkLenghtName(name)) {
                System.out.println("Bạn chỉ được nhập tên tối đa 100 kí tự");
            } else if(name.replaceAll("\\s", "").length() == 0){
                System.out.println("Bạn không được để trống tên");
            }else if (name.matches(".*\\d.*")) {
                System.out.println("Tên không được chứa số");
            }else  {
                break;      
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println(e);
        }
    } while (true);

    return name;
}

    public String enterAddress(){
          String address;
          do{
               System.out.print("Nhập địa chỉ ( tối đa 300 kí tự): ");
               address = this.scanner.nextLine();
               if(Validate.checkAddress(address)){
                   System.out.println("Bạn phải nhập địa chỉ có độ dài nhỏ hơn 300 kí tự");
               }else if(address.trim().length() == 0) {
                   System.out.println("Bạn không được để trống");
               }else break;
          }while (true);
          return address;
    }

    public Double enterHeight(){
          Double height;
          do {
              System.out.print("Nhập chiều cao (50 - 300): ");
              String heightString = this.scanner.nextLine();
              if(heightString.trim().length() == 0){
                   System.out.println("Bạn không được để trống");
              }else if(!Validate.checkHeight(Double.parseDouble(heightString))){

                   System.out.println("Bạn phải nhập chiều cao lớn hơn 50cm và nhỏ hơn 300cm");
              }else {
                 height = Double.parseDouble(heightString);
                 break; 
              }
          }while (true);
          return height;
    }

    public Double enterWeight(){
        Double weight;
        do {
            System.out.print("Nhập cân nặng ( 5 - 1000): ");
            String weightString = this.scanner.nextLine();
            if(weightString.trim().length() == 0){
                System.out.println("Bạn không được để trống");
            }else if(!Validate.checkWeight(Double.parseDouble(weightString))){

                System.out.println("Bạn phải nhập cân nặng lớn hơn 5 và nhỏ hơn 1000");
            }else {
                weight = Double.parseDouble(weightString);
                break;
            }
        }while (true);
        return weight;
    }

    public LocalDate enterDateOfBirth(){
        LocalDate dateOfBirth = null;
         do{
             try {
                 System.out.print("Nhập ngày sinh(yyyy-MM-dd): ");
                 dateOfBirth = LocalDate.parse(this.scanner.nextLine());
                 if(!Validate.checkOverDate(dateOfBirth)){
                        System.out.println("Bạn không được nhập quá thời gian hiện tại");
                 }else if(!Validate.chechMinDate(dateOfBirth)){
                        System.out.println("Bạn phải nhập ngày sinh sau ngày 1900-01-01");
                 }else break;
             }catch(Exception e){
                 System.out.println(e.getMessage());
             }
         }while(true);
        return dateOfBirth;
    }

    public String enterSchool(){
        String school;
        while (true){
            System.out.print("Nhập tên trường ( tối đa 200 kí tự): ");
            school = this.scanner.nextLine();
            if(school.trim().length() == 0){
                System.out.println("Bạn không được để trống");
            }else if(!Validate.checkSchoolName(school)){
                System.out.println("Bạn không được tên trường nhập quá 200 kí tự");
            }else {
                break;
            }
        }
        return school;
    }


    public Double enterCpa(){
        Double cpa;
        while (true){
            System.out.print("Nhập CPA (0.0 - 10.0): ");
            String cpaString = this.scanner.nextLine();
            if(cpaString.trim().length() == 0){
                System.out.println("Bạn không được để trống");
            }else if(!Validate.checkCpa(Double.parseDouble(cpaString))){
                System.out.println("Điểm CPA phải trong khoản từ 0.0 tới 10.0");
            }else {
                cpa = Double.parseDouble(cpaString);
                break;
            };
        }
        return cpa;
    }

    public String enterYearStart(){
        String startYear;
        while (true){
            System.out.print("Nhập năm bắt đầu: ");
            startYear = this.scanner.nextLine();
            if(startYear.trim().length() == 0){
                System.out.println("Không được để trống");
            }else if(!Validate.checkStartYear(startYear)){
                System.out.println("Năm băt đầu phải sau năm 1900");
            }else {
                break;
            }
        }
        return startYear;
    }

    
    public String enterId(){
        // MethodsStudent methodsStudent = new MethodsStudent(listStudents);
        
        String id;
        while (true){
            System.out.print("Nhập id: ");
            id = this.scanner.nextLine();
            

            if(id.trim().length() == 0){
                System.out.println("Không được để trống");
            }else {
                break;
            }
        }
        return id;
    }

    public boolean hasDuplicates(String value) {
        HashSet<Character> set = new HashSet<>();
        for (char val : value.toCharArray()) {
            if (!set.add(val)) {
                return true;
            }
        }
        return false;
    }
    
    public String enterIdNo(List<Student> listStudents){
        // MethodsStudent methodsStudent = new MethodsStudent(listStudents);
        
        String idNo;
        while (true){
            System.out.print("Nhập MSSV ( = 10 kí tự): ");
            idNo = this.scanner.nextLine();
            Boolean foudIdNo = false;
            for (Student student : listStudents) {
                if (student.getIdNo().equals(idNo)) {
                    foudIdNo = true;
                }else{
                    foudIdNo = false;
                }
            }

            if(idNo.trim().length() == 0){
                System.out.println("Không được để trống");
            }else if(!Validate.checkMsv(idNo)){
                System.out.println("Mã số sinh viên phải có 10 kí tự");
            }else if(foudIdNo == true) {
                System.out.println("Mã số sinh viên đã tồn tại");
            }else if(this.hasDuplicates(idNo) == true){
                System.out.println("Mã số sinh viên có kí tự bị trùng");
            }else {
                break;
            }
        }
        return idNo;
    }

    public String enterIdNoStaticArr(Student[] listStudents){
        // MethodsStudent methodsStudent = new MethodsStudent(listStudents);
        
        String idNo;
        while (true){
            System.out.print("Nhập MSSV ( = 10 kí tự): ");
            idNo = this.scanner.nextLine();
            Boolean foudIdNo = false;
            for (Student student : listStudents) {
                if(student != null){
                    if (student.getIdNo().equals(idNo)) {
                        foudIdNo = true;
                    }else{
                        foudIdNo = false;
                    }
                }else{
                    foudIdNo = false;
                }
            }

            if(idNo.trim().length() == 0){
                System.out.println("Không được để trống");
            }else if(!Validate.checkMsv(idNo)){
                System.out.println("Mã số sinh viên phải có 10 kí tự");
            }else if(foudIdNo == true) {
                System.out.println("Mã số sinh viên đã tồn tại");
            }else if(this.hasDuplicates(idNo) == true){
                System.out.println("Mã số sinh viên có kí tự bị trùng");
            }else {
                break;
            }
        }
        return idNo;
    }
}