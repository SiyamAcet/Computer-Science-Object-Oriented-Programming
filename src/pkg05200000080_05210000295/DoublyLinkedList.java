
package pkg05200000080_05210000295;

public class DoublyLinkedList {

    // Node class'ı inner class şeklinde DoublyLinkedList class'ının içerisine yazıldı.
    public class Node{
        private Student student;
        private Node previous;
        private Node next;

        public Node(){
            student = null;
            previous = null;
            next = null;
        }

        public Node(Student newStudent,Node previousNode,Node nextNode){
            student = newStudent;
            previous = previousNode;
            next = nextNode;
        }
    }   // Node class'ının sonu.


    // Çift bağlı liste sınıfının değişkenleri ve parametresiz constructor'ı:
    private Node head;
    private Node tail;

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    // Öğrenciyi sıralı ekleme metodu:
    public void addInOrder(Student student){
        Node node = new Node(student,null,null);
        // Boş listeye ekleme
        if (head == null){
            tail = node;
            head = node;
        }
        // Başa ekleme
        else if (head.student.getStudentNo() > node.student.getStudentNo()){
            head.previous = node;
            node.next = head;
            head = node;
        }
        // Sona ekleme
        else if (tail.student.getStudentNo() < node.student.getStudentNo()){
            node.previous = tail;
            tail.next = node;
            tail = node;
        }// Ortaya ekleme
        else {
            Node temp = head.next;
            while (temp.student.getStudentNo() < node.student.getStudentNo()){
                temp = temp.next;
            }
            temp.previous.next = node;
            node.previous = temp.previous;
            temp.previous = node;
            node.next = temp;
        }
    }// Ekleme metodunun sonu.

    // Adı ve Soyadı verilen öğrenciyi bulma ve yazdırma metodu:
    public void findAndWrite(String studentName){
        Node position = head;
        int counter = 0;     // Aynı ad ve soyada sahip kaç öğrencinin olduğunu tutacak değişken.

        // Aranan isimde kaç öğrenci varsa yazdıran döngü:
        while(position != null){
            if (position.student.getNameSurname().equals(studentName)){
                counter++;
                System.out.println(position.student.toString());

            }
            position = position.next;
        }
        if (counter == 0){
            System.out.println("Girilen Ad-Soyad a sahip hiç bir öğrenci bulunmamaktadır.");
        }
    }

    // Numarası verilen öğrenciyi listeden silme metodu
    public void remove(int ogrenciNo){
        //Liste boş uyarısı
        if (head == null){
            System.out.println("Liste boş...");
            return;
        }
        //Baştan silme
        else if (head.student.getStudentNo() == ogrenciNo){
            head = head.next;

        }
        // Sondan silme
        else if (tail.student.getStudentNo() == ogrenciNo){
            tail = tail.previous;
            tail.next = null;
        }
        //Ortadan silme
        else {
            Node temp = head;
            while (temp != null){
                if(temp == tail){
                    System.out.println("Böyle bir öğrenci bulunamadı...");
                    return;
                }
                else if (temp.next.student.getStudentNo() == ogrenciNo){
                    temp.next = temp.next.next;
                    temp.next.previous = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        System.out.println("Öğrenci siliniyor...");
    }


    public void printSmallToLarge(){
        Node position = head;

        while (position != null){
            System.out.println("***********************");
            System.out.println(position.student);
            position = position.next;
        }
    }


    public void printLargeToSmall(){
        Node position = tail;

        while(position != null){
            System.out.println("***********************");
            System.out.println(position.student);
            position = position.previous;
        }
    }

}
