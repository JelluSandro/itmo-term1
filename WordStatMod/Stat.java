public class Stat implements Comparable<Stat> {
	private IntList countIndex;
	private int pos;
	private int length;
	
	public Stat() {
		length = 0;
		countIndex = new IntList();
		pos = -1;
	}
	
	public int getCountIndex(int x) {
		return countIndex.get(x);
	}
	
	public int countIndexSize() {
		return countIndex.size();
	}
	
	public void add(int x) {
		countIndex.add(x);
	}

	public void addCount() {
		length++;
	}
	
	public int lastPos() {
		return pos;
	}
	
	public void updatePos(int x) {
		pos = x;
	}
	
	public int compareTo(Stat x) {
		return this.length - x.length;
	}
	
	public int length() {
		return length;
	}

}