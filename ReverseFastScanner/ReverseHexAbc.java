import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List; 

public class ReverseHexAbc {
	public static void main(String[] args) {
		FastScanner sl = new FastScanner(System.in);
		List<int[]> rows = new ArrayList<>();
		int mx = 0;
		int nextArg = 0;
		while (true) {
			int listLength = rows.size() - 1;
			int[] row = new int[10];
			int Rowslength = 0;
			while (true) {
				nextArg = sl.hasNext();
				if (nextArg == 1) continue;
				if (nextArg == -1 || nextArg == 2) break;
				String s = sl.next(); 
				int nextInt;
				if (s.length() > 1 && s.charAt(0) == '0' && (s.charAt(1) == 'x' || s.charAt(1) == 'X')) {
					nextInt = Integer.parseUnsignedInt(s.substring(2, s.length()), 16);
				} else {
					StringBuilder all = new StringBuilder();
					all.append(s);
					for (int i = 0; i < s.length(); i++) {
						if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
							all.setCharAt(i, ((char)((int)'0' + s.charAt(i) - 'a')));
						}
					}
					nextInt = Integer.parseInt(new String(all));
				}
				if (row.length == Rowslength) {
					row = Arrays.copyOf(row, row.length * 2);
				}
				row[Rowslength++] = nextInt;
			}
			if (nextArg == -1) break;
			rows.add(Arrays.copyOf(row, Rowslength));
			if (mx < Rowslength) {
				mx = Rowslength;
			}
      	}
		for (int i = rows.size() - 1; i >= 0; i--) {
			for (int j = rows.get(i).length - 1; j >= 0; j--) {
				System.out.print(String.format("%s%s", rows.get(i)[j], " "));
			}
			System.out.println();
		} 
	}
}