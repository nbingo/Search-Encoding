import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Decoder {
	
	public static void decode(String infile, String outfile) throws IOException, FileNotFoundException
	{
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
		
		ArrayList<String> lastCol = new ArrayList<String>();
		
		while (reader.ready())
			lastCol.add((char)reader.read()+"");
		
		ArrayList<String> firstCol = new ArrayList<String>(lastCol);
		
		Collections.sort(firstCol);
		
		while (firstCol.get(0).length() < firstCol.size())
		{
			ArrayList<String> temp = new ArrayList<String>(lastCol);
			
			for (int i = 0; i < firstCol.size(); i++)
				temp.set(i, lastCol.get(i) + firstCol.get(i));
			Collections.sort(temp);
			Collections.copy(firstCol, temp);
		}
		
		writer.print(firstCol.get(0));
		
		reader.close();
		writer.close();
	}
}
