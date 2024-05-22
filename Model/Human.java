package Model;

import java.time.LocalDate;

class Human {

    protected String name;
    private int id;
    static int nextId = 1;
    protected String address;
    protected double height;
    protected double weight;
    protected LocalDate dateOfBirth;

    // constructor
    public Human(   String name,           
                    String address,
                    double height,
                    double weight,
                    LocalDate dateOfBirth
                ) {
        this.name = name;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
        this.id = nextId++;    
    
    }

    //getter and setter
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //@Override 
    public String toString() {
        return "Sinh viên:" + this.getName() +
                "ID '" + this.getId() + "', " +
                "ngày sinh: '" + this.getDateOfBirth() + "', " +
                "địa chỉ: '" + this.getAddress() +"', " +
                "chiều cao: '" + this.getHeight() +"', " +
                "cân mặng: '" + this.getWeight() ;
    }
}