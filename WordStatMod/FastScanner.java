import java.io.*;
import java.util.*;

public class FastScanner {
	private BufferedReader reader;
	private int begBlock;
	private int endBlock;
	private char[] block;
	private final int blockSize = 8192;
	private char symbol = '%';
	private final Exp func;
	
	public FastScanner(String input, Exp func) {
		this.func = func;
		begBlock = 0;
		endBlock = 0;
		block = new char[blockSize];
		try { 
			reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(input), "utf8")
			);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException in create new FastScanner, can't find file" + e);
		} catch (UnsupportedEncodingException e) {
			System.err.println("UnsupportedEncodingException in create new FastScanner" + e);
		}
	}
	
	public FastScanner(InputStream input, Exp func) {
		this.func = func;
		begBlock = 0;
		endBlock = 0;
		block = new char[blockSize];
		reader = new BufferedReader(new InputStreamReader(input));
	}
	
	public void close() {
		try {
			reader.close();
		} catch(IOException e) {
			System.err.println("IOException can't close" + e);
		}
	}
	
	public String next() {
		StringBuilder all = new StringBuilder();
		int read = 0;
		while (read == 0) {
			for (int i = begBlock; i < endBlock; i++) {
				if (separator(block[i])) {
					if (i - begBlock > 0) {
						all.append(new String(block, begBlock, i - begBlock));
					}
					begBlock = i;
					return (new String(all));
				}
			}
			all.append(new String(block, begBlock, endBlock - begBlock));
			begBlock = endBlock;
			read = this.hasNext();
		}
		if (read == 2) begBlock--; 
		return (new String(all));
	}
	
	public int hasNext() {
		if (begBlock < endBlock) {
			char b = block[begBlock];
			int ans = type(b);
			return (ans);
		}
		try {
			int read = reader.read(block);
			if (read == -1) return -1;
			begBlock = 0;
			endBlock = read;
			char b = block[begBlock];
			int ans = type(b);
			return (ans);
		} catch (IOException e) {
			System.err.println("IOException in hasNext can't read block" + e);
		}
		return -1;
	}
	
	public int hasNextWord() {
		int ans = 1;
		while (ans == 1) {
			ans = this.hasNext();
		}
		return ans;
	}
	
	private boolean separator(char a) {
		return (func.valChar(a));
	}

	private boolean nextLine(char a) {
		if (a == '\r' || ((a == '\n') && (symbol != '\r'))) {
			symbol = a;
			return true;
		}
		symbol = a;
		return false;
	}
	
	private int type(char a) {
		if (separator(a)) {
			begBlock++;
			if (nextLine(a)) {
				return 2;
			}
			return 1;
		}
		return 0;
	}
}