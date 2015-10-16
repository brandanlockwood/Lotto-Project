
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ReadFile file = new ReadFile("DownloadAllNumbers.txt");

		file.read();// read file
		//shows how the mapping of both lotto number and mega number
		System.out.println("Hot numbers's frequency "+file.nLook(15)+" "+file.nLook(6)+" "+file.nLook(13)+" "+file.nLook(30)+" "+file.nLook(7));
		System.out.println("Cold numbers's frequency "+file.nLook(37)+" "+file.nLook(3)+" "+file.nLook(27)+" "+file.nLook(40)+" "+file.nLook(14));
		System.out.println("Hot Mega numbers's frequency "+file.mLook(20)+" "+file.mLook(10)+" "+file.mLook(9)+" "+file.mLook(23)+" "+file.mLook(18));
		System.out.println("Cold Mega numbers's frequency "+file.mLook(14)+" "+file.mLook(7)+" "+file.mLook(6)+" "+file.mLook(3)+" "+file.mLook(21));
		System.out.println();
		//prints frequencies in ascending order
		file.printA();
		System.out.println();
		//prints frequencies in descending order
		file.printD();
		//prints report
		file.printReport();
	}

}
