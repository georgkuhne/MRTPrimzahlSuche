package iks.mrt.primzahlsuche.algorithm;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabinPrimzahlTest {
	String bin;
	BigInteger Big0 = BigInteger.valueOf(0);
	BigInteger Big1 = BigInteger.valueOf(1);
	BigInteger Big2 = BigInteger.valueOf(2);
	int w = 10;

	public boolean isPrime(BigInteger N, int wiederholungen) {

		BigInteger a, N_2 = N.subtract(Big2);
		
		for (w = 1; w < wiederholungen + 1; w++) {
			a = random(N_2);
			
			if (!mrt(a, N)) {
				
				return false;
			}
		}
		return true;

	}

	Random seed = new Random();

	public BigInteger random(BigInteger N_2) {

		BigInteger R;

		// Zufallszahl aus [1,N-1]
		do {
			R = new BigInteger(N_2.bitLength(), seed).add(Big1);
		} while (R.compareTo(N_2) > 0);

		return R;
	}

	public String bigIntToBinaryString(BigInteger B) {

		// Eingabe in binäre Form umwandeln
		for (BigInteger I = Big2.pow(B.bitLength() - 1); I.compareTo(Big0) != 0; I = I
				.divide(Big2)) {
			if (B.compareTo(I) >= 0) {
				bin += "1";
				B = B.subtract(I);
			} else
				bin += "0";
		}

		return bin;
	}

	public BigInteger modular_exponentiation(BigInteger A, BigInteger d,
			BigInteger N) {
//	a^d mod n
		
		
		BigInteger C = Big0;
		BigInteger D = Big1;

		// Sei {b[0],b[1],...,b[k-1],b[k]} die binäre Darstellung von b
		if (w == 1)
			bin = bigIntToBinaryString(d);
		// Da für alle Zeugen gleich, nur einmal berechnen

		for (int i = 0; i < bin.length(); i++) {

			C = C.multiply(Big2);
			D = D.pow(2).mod(N);

			if (bin.charAt(i) == '1') {
				C = C.add(Big1);
				D = D.multiply(A).mod(N);
			}
		}

		return D;
	}

	int s;

	public boolean mrt(BigInteger A, BigInteger N) {
		if(ggt(A,N).compareTo(BigInteger.ONE)!=0)
			return false;
		BigInteger N_1 = N.subtract(Big1);

		// Sei n-1 = 2^t*u mit t >= 1 und u ungerade
		if (w == 1)
			while (N_1.divide(Big2.pow(s)).mod(Big2).compareTo(Big0) == 0)
				s++;
		// Da für alle Zeugen gleich, nur einmal berechnen

		BigInteger d = N_1.divide(Big2.pow(s));

		BigInteger x1 = modular_exponentiation(A, d, N); // a^d mod N
		//Bedingung 1:
		if(x1.compareTo(Big1)==0||(x1.compareTo(N_1)==0))
			return true; 
		///Bedingung 2: 
		for (int i = 1; i < s + 1; i++) {
			x1 = x1.pow(2).mod(N);
			
			if (x1.compareTo(N_1)==0)
				return true;
			if (x1.compareTo(Big1)<0)
				break; 
		}
		
	
			return false;
	}

	private BigInteger ggt(BigInteger x, BigInteger y)
	{
		if(x.mod(y).compareTo(new BigInteger("0")) == 0)
			return y;
		return ggt(y, x.mod(y));
	}
	
	public static void test(String[] args) {
		BigInteger n = BigInteger.valueOf(10);
		for (int i = 0; i < 500000; i++) {
			MillerRabinPrimzahlTest test = new MillerRabinPrimzahlTest();
			if (test.isPrime(n, 10))
				System.err.println(n.toString() + " " + "is prime");
			else
				System.err.println(n.toString() + " " + "is not prime");
			n = n.add(BigInteger.ONE);
		}
	}

}
