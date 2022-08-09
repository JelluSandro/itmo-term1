import java.io.*;
import java.util.*;

public class WordStatCountFirstIndex {	
	
	private static boolean check (char a) {
		if (Character.getType(a) != Character.DASH_PUNCTUATION 
		&& (Character.isLetter(a) == false) 
		&& a != '\'') 
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Map<String, Stat> map = new LinkedHashMap<>();
		FastScanner reader = new FastScanner(args[0], WordStatCountFirstIndex::check);
		int read = reader.hasNextWord();
		int countWord = 0;
		int nextLine = 0;
		while (read != -1) {
			if (read == 2) {
				nextLine++;
				countWord = 0;
				read = reader.hasNextWord();
				continue;
			}
			int ki = 0;
			String word = reader.next();
			word = word.toLowerCase();
			countWord++;
			Stat statWord = map.getOrDefault(word, new Stat());
			statWord.addCount();
			if (statWord.length() < 2 || statWord.lastPos() < nextLine) {
				statWord.add(countWord);
				statWord.updatePos(nextLine);
			}
			map.put(word, statWord);
			read = reader.hasNextWord();
		}
		reader.close();
		List<Map.Entry<String, Stat>> ans = new ArrayList<>(map.entrySet());
		ans.sort(Map.Entry.comparingByValue());
		try {
			PrintWriter writer = new PrintWriter(
			new OutputStreamWriter(new FileOutputStream(args[1]), "utf8")
			);
			try {
				for (int i = 0; i < ans.size(); i++) {
					Map.Entry<String, Stat> elem = ans.get(i);
					Stat index = elem.getValue();
					writer.write(String.format("%s %d", elem.getKey(), index.length()));
					for (int j = 0; j < index.countIndexSize(); j++) {
						writer.write(String.format(" %d", index.getCountIndex(j)));
					}
					writer.write("\n");
				}
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException e){
			System.out.println("FileNotFoundException");
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException");
		}
 	}	
}