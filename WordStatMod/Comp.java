import java.util.*;
private static class Stat implements Comparable<Stat> {
	public int compareTo(Stat x) {
		return this.length - x.length;
	}
}