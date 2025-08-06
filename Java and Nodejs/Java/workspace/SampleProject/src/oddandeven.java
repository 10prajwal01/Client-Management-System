class OddEvenException extends Exception {
	OddEvenException(String msg) {
		super(msg);
	}
}


public class oddandeven {
	
	static void odd_even(int num) throws OddEvenException {
		if(num % 2 == 0) {
			System.out.println(num + " is even");
		}
		else {
			throw new OddEvenException(num + " is Odd");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  try {
			odd_even(10);
	  	} catch(OddEvenException err) {
			System.out.println(err);
	  		}
	}

}
