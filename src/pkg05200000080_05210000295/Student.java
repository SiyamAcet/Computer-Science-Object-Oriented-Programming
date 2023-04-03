
package pkg05200000080_05210000295;

import java.util.ArrayList;


public class Student {

    private int studentNo;
    private String nameSurname;
    private ArrayList<String> phoneNumberList = new ArrayList<>();

    // Parametresiz constructor
    public Student(){
        studentNo = 0;
        nameSurname = null;
    }

    // Parametreli consructor
    public Student(int ogrenciNo, String adSoyad,ArrayList<String> telefonNoList){
        studentNo = ogrenciNo;
        nameSurname = adSoyad;
        phoneNumberList = telefonNoList;
    }

    // Copy constructor
    public Student(Student otherStudent){
        studentNo = otherStudent.studentNo;
        nameSurname = otherStudent.nameSurname;
        phoneNumberList = otherStudent.phoneNumberList;
    }

    // Get Set metodları:

    public int getStudentNo() {
        return studentNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.studentNo = ogrenciNo;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public ArrayList<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(ArrayList<String> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }


    public String toString(){
        String phoneNumbers = "";
        for (String i : phoneNumberList){
            phoneNumbers += i + "\n";
        }
        return "Öğrenci Numarası: " + studentNo + "\nAdı Soyadı: " + nameSurname + "\nTelefon Numaraları:\n" + phoneNumbers;
    }
}

