
package pkg05200000080_05210000295;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Verilerin tutulacağı Doubly Linked List:
        DoublyLinkedList studentsDLL = new DoublyLinkedList();

        String information = "-Metin dosyasından verileri alarak liste oluşturmak için '1' e, \n" +
                "-Verileri klavyeden girerek listeye eklemek için '2'ye, \n" +
                "-Adı soyadı girilen öğrencinin bilgilerini ekrana yazdırmak için '3'e, \n" +
                "-Öğrenciyi listeden silmek için '4'e, \n" +
                "-Listedeki tüm kayıtları artan sırada yazdırmak için '5'e, \n" +
                "-Listedeki tüm kayıtları azalan sırada yazdırmak için '6'ya, \n" +
                "-Programdan çıkmak için ise '7'ye basınız.";
        System.out.println("----------------------------------------------------------------------");
        System.out.println(information);
        System.out.println("----------------------------------------------------------------------");

        int theOption = 0;
        while(theOption != 7){
            System.out.println("Lütfen tercihinizi yapınız(1-7):");
            theOption = scanner.nextInt();
            scanner.nextLine();

            if (theOption == 1){
                try {
                    Scanner reader = new Scanner(new FileReader("ogrenciler.txt"));

                    while (reader.hasNextLine()){
                        // Sıradaki satırdaki öğrencinin bilgilerini tutacak liste:
                        String[] studentInfos = reader.nextLine().split(",");

                        // Sıradaki satırdaki öğrencinin telefon numaralarını tutacak liste:
                        ArrayList<String> phoneNumbers = new ArrayList<>();
                        for(int i = 2 ; i < studentInfos.length ; i++){
                            phoneNumbers.add(studentInfos[i]);
                        }
                        Student newStudent = new Student(Integer.valueOf(studentInfos[0]),studentInfos[1],phoneNumbers);
                        studentsDLL.addInOrder(newStudent);

                    }
                    System.out.println("Dosyadaki veriler listeye eklendi");
                } catch (FileNotFoundException e) {
                    System.out.println("Dosya bulunamadı.");
                }

            }
            else if(theOption == 2){
                System.out.println("Eklenecek öğrencinin 'Öğrenci numarasını' giriniz:");
                int studentNo = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Öğrencinin adını soyadını giriniz:");
                String studentName = scanner.nextLine();


                ArrayList<String> phoneNumbers = new ArrayList<>();
                System.out.println("Öğrencinin kaç adet telefon numarası var?");
                int numberCount = scanner.nextInt();
                scanner.nextLine();

                for(int i = 1; i <= numberCount; i++){
                    System.out.println(i + ". Telefon numarasını giriniz:");
                    String number = scanner.nextLine();
                    phoneNumbers.add(number);
                }
                // Gerekli tüm bilgiler alındı, sıra bunlarla bir Student nesnesi oluşturup listeye eklemede.
                Student newStudent = new Student(studentNo,studentName,phoneNumbers);
                studentsDLL.addInOrder(newStudent);

                System.out.println(studentName + " Adlı öğrenci listeye eklendi");
            }
            else if(theOption == 3){
                System.out.println("Bilgileri ekrana yazdırmak için lütfen öğrencinin adını ve soyadını giriniz:");
                String studentName = scanner.nextLine();

                studentsDLL.findAndWrite(studentName);
            }

            else if(theOption == 4){
                System.out.println("Silmek istediğiniz öğrencinin 'Öğrenci Numarasını' giriniz:");
                int studentNumber = scanner.nextInt();
                scanner.nextLine();

                studentsDLL.remove(studentNumber);
            }

            else if(theOption == 5){
                studentsDLL.printSmallToLarge();
            }
            else if(theOption == 6){
                studentsDLL.printLargeToSmall();
            }
            else if(theOption == 7){
                System.out.println("Programdan çıkılıyor...");
            }
        }
    }
}



