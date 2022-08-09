import java.math.BigInteger;

public class SumBigIntegerSpace {
	public static BigInteger SumString(String s) {
		BigInteger sm = BigInteger.valueOf(0);
		int cur = -1;
		for(int i = 0; i < s.length(); i++) {
			if(Character.getType(s.charAt(i)) == java.lang.Character.SPACE_SEPARATOR ) {
				if(cur + 1 < i) {
					String t = s.substring(cur + 1, i);
					BigInteger x = new BigInteger(t);
					sm = sm.add(x);
				}
				cur = i;
			} 
		}
		if(cur + 1 != s.length()) {
			String t = s.substring(cur + 1, s.length());
			BigInteger x = new BigInteger(t);
			sm = sm.add(x);
		}
		return sm;
	}
	public static void main(String[] args) {
		BigInteger ans = BigInteger.valueOf(0);
		for(int i = 0; i < args.length; i++) {
			ans = ans.add(SumString(args[i]));
		}
		System.out.println(ans);
	}
}