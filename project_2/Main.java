
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // Idman Oluþturma Programý
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Idman Programýna Hoþgeldiniz...");
        
        String idmanlar = "Geçerli Hareketler...\n"
                          + "Burpee\n"
                          +"Pushup(Þýnav)\n"
                          +"Situp(Mekik)\n"
                          +"Squat";
        System.out.println(idmanlar);
        
        System.out.println("Bir idman oluþturun...");
        
        System.out.print("Burpee Sayýsý : ") ;
        int burpee = scanner.nextInt();
        System.out.print("Pushup Sayýsý : ") ;
        int pushup = scanner.nextInt();
        System.out.print("Situp Sayýsý : ") ;
        int situp = scanner.nextInt();
        System.out.print("Squat Sayýsý : ") ;
        int squat = scanner.nextInt();
        
        scanner.nextLine();
        
    
        Idman idman = new Idman(burpee, pushup, situp, squat);
        
        System.out.println("Ýdmanýnýz Baþlýyor.....");
        
        
        while (idman.idmanBittiMi() == false){
            
            System.out.print("Hareket Türü(Burpee,Pushup,Situp,Squat) : ");
            String tur = scanner.nextLine();
            System.out.print("Bu hareketten kaç tane yapacaksýnýz ? : ");
            int sayi = scanner.nextInt();
            scanner.nextLine();
            idman.hareketYap(tur, sayi);
            
            
            
        }
        System.out.println("Idmanýný baþarýyla bitirdin....");
    
    
    }
}
