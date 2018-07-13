package lesson9;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumbers {

	public static void main(String[] args) {
		
//		final Stream<BigInteger> primeNums = Stream.iterate(BigInteger.TWO, n->n.add(BigInteger.ONE)).
//				filter(n->n.intValue()==2?true:!(Stream.iterate(BigInteger.TWO, x->x.add(BigInteger.ONE)).limit(n.intValue()/2).
//						map(x->(n.intValue()%x.intValue())!=0?true:false).collect(Collectors.toList()).contains(false)));
		
		
		System.out.println("Prime Numbers upto 10: ");
		PrimeNumbers.printFirstNPrimes(10);
		System.out.println("Prime Numbers upto 50: ");
		PrimeNumbers.printFirstNPrimes(50);

	}
	
	public static void printFirstNPrimes(long m) {
		final Stream<BigInteger> primeNums = Stream.iterate(BigInteger.TWO, n->n.add(BigInteger.ONE)).limit(m-1).
				filter(n->n.intValue()==2?true:!(Stream.iterate(BigInteger.TWO, x->x.add(BigInteger.ONE)).limit(n.intValue()/2).
						map(x->(n.intValue()%x.intValue())!=0?true:false).collect(Collectors.toList()).contains(false)));
		System.out.println(primeNums.collect(Collectors.toList()));
	}

}
