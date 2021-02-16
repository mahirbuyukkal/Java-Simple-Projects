
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // Idman Olu�turma Program�
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Idman Program�na Ho�geldiniz...");
        
        String idmanlar = "Ge�erli Hareketler...\n"
                          + "Burpee\n"
                          +"Pushup(��nav)\n"
                          +"Situp(Mekik)\n"
                          +"Squat";
        System.out.println(idmanlar);
        
        System.out.println("Bir idman olu�turun...");
        
        System.out.print("Burpee Say�s� : ") ;
        int burpee = scanner.nextInt();
        System.out.print("Pushup Say�s� : ") ;
        int pushup = scanner.nextInt();
        System.out.print("Situp Say�s� : ") ;
        int situp = scanner.nextInt();
        System.out.print("Squat Say�s� : ") ;
        int squat = scanner.nextInt();
        
        scanner.nextLine();
        
    
        Idman idman = new Idman(burpee, pushup, situp, squat);
        
        System.out.println("�dman�n�z Ba�l�yor.....");
        
        
        while (idman.idmanBittiMi() == false){
            
            System.out.print("Hareket T�r�(Burpee,Pushup,Situp,Squat) : ");
            String tur = scanner.nextLine();
            System.out.print("Bu hareketten ka� tane yapacaks�n�z ? : ");
            int sayi = scanner.nextInt();
            scanner.nextLine();
            idman.hareketYap(tur, sayi);
            
            
            
        }
        System.out.println("Idman�n� ba�ar�yla bitirdin....");
    
    
    }
}
