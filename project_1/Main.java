
public class Main {
	
	public static void main(String[] args) {
		
		ATM atm = new ATM();
		Hesap hesap = new Hesap("Mahir B�y�kkal","12345",2000);
		
		
		atm.calis(hesap);
	    System.out.println("Program Sonland�r�l�yor");
		
	}

}
