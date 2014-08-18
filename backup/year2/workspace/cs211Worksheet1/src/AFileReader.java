import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AFileReader {
	public static void main (String[] arg) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("lines.txt"));
			for (int i =0; i<20; i++) {
				String line ="";
				if ((line = br.readLine()) != null) {
					String [] words = line.split(" ");
					int index = (i > words.length -1) ? words.length-1 : i;
					System.out.println(words[index]);
				}
			}
			br.close();
			br = new BufferedReader(new FileReader("lines.txt"));
			
			String line ="";
			StringBuffer str = new StringBuffer();
			while ((line = br.readLine()) != null) {
					str.append(line);
			}
			
			String file = str.toString();
			String [] sentances = file.split("\\. ");

			int length = (sentances.length < 200) ? sentances.length : 200;
			for (int i=0;i<length;i++) {
				String [] moreWords = sentances[i].split(" ");
				System.out.println("First word: " + moreWords[0] + ", Last Word: " + moreWords[moreWords.length-1]);
				System.out.println("No. of words inbetween: " + (moreWords.length-2));
				System.out.println();
			}
			
		} catch (IOException e) {
			System.err.println("Could not oopen file!");
			System.err.println(e.getMessage());
		}
		
	}
}
