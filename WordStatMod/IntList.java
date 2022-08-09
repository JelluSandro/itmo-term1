import java.util.Arrays;
public class IntList {
	private int size;
	private int[] arr;
	
	public IntList() {
		size = 0;
		arr = new int[10];
	}
	
	public IntList(int x) {
		size = 0;
		arr = new int[10];
		this.add(x);
	}
	
	public int last() {
		return arr[size - 1];
	}
	
	public void add(int x) {
		if	(arr.length == size) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		arr[size++] = x;
	}
	
	public int get(int x) {
		return arr[x];
	}
	
	public int size() {
		return size;
	}
}