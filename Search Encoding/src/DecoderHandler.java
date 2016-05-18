import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DecoderHandler {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Scanner k = new Scanner(System.in);
		System.out.println("File to read: ");
		String infile = k.nextLine();
		System.out.println("Output filename: ");
		Decoder.decode(infile, k.nextLine());
		System.out.println("Decoding done!");
		
		k.close();
	}

}
