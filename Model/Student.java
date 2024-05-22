package Model;
import java.time.LocalDate;
import java.util.Map;

import Constant.ClassificationConst;



public class Student extends Human {


    private Classification classification;

    private String idNo;
    private String school = "";
    private double cpa = 0;
    private String yearStart;

    // Constructor
    public Student( String name,
                    String idNo,          
                    String address,
                    double height,
                    double weight,
                    LocalDate dateOfBirth,
                    String school,
                    double cpa,
                    String yearStart
                ) {
        super(  name,
                address,
                height,
                weight,
                dateOfBirth);
        this.school = school;
        this.idNo = idNo;
        this.yearStart = yearStart;
        this.cpa = cpa;
        this.setClassification(cpa);
    }

    //getter,setter
    
    public void setName(String name){
         super.name = name;
    }

    public String getName() {
        return super.name;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public double getCpa() {
        return cpa;
    }

    public void setCpa(double cpa){
        this.cpa= cpa;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo){
        this.idNo = idNo;
    }

    public String getYearStart () {
        return yearStart;
    }

    public void setYearStart (String yearStart) {
        this.yearStart = yearStart;
    }

    public void setClassification(double cpa) {
        updateClassification();
    }

    public Classification getClassification(){
        return classification;
    } 

    public void updateClassification(){
        Map<Double, Classification> classificationMap = ClassificationConst.CLASSIFICATION_CONST_MAP;
        for (Map.Entry<Double, Classification> entry : classificationMap.entrySet()) {
            if (cpa >= entry.getKey()) {
                classification = entry.getValue();
            }
        }
    }

    //@Override 
    public String toString() {
        return "Sinh viên:" + this.getName() +
                "ID '" + this.getId() + "', " +
                "MSSV: '" + this.getIdNo() +"', " +
                "ngày sinh: '" + this.getDateOfBirth() + "', " +
                "địa chỉ: '" + this.getAddress() +"', " +
                "chiều cao: '" + this.getHeight() +"', " +
                "cân mặng: '" + this.getWeight() +"', " +
                "MSSV='" + idNo + '\'' +
                ", schoolName='" + school + '\'' +
                ", startYear=" + yearStart +
                ", CPA=" + cpa +
                ", Học lực= " + this.getClassification();
    }
    

}


