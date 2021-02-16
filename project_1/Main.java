
public class Main {
	
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		Hesap hesap = new Hesap("Mahir Büyükkal","12345",2000);
		
		
		atm.calis(hesap);
	    System.out.println("Program Sonlandýrýlýyor");
		
	}

}
