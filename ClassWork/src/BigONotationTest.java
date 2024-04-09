
public class BigONotationTest {
	public static void main(String[] args) {
		
		int n = 5;
		
		
		
		long a = 1;
		  long total = 0;
		  for(int i=0; i<n; i++)
		  	a = 2 * a; 				
		  for(int j=0; j<a; j++)
		  	total += j;			
		  
		   // (2^(n + (n-1)) ) - n*n/2
		  
		  // Input : 	#1 			: #2 		: #3 			: #4 
		  // 1 : 		0 			: -1 		: 1 			: 1  
		  // 5 : 		10 			: -25 		: 496 			: 2 
		  // 10 : 		120 		: -100 		: 523776 		: 2 
		  // 100 : 		161700 		: -10000 	: 0 (overflow) 	: 4  
		System.out.println(total);
		
/*		#1
		int total = 0;
		for(int i=0; i<n; i++) n
			for(int j=0; j<i; j++) n
				total += j;
		      
		#2
		 int total = 0;
		 int d = 1;
		 for(int i=0; i<n;) { // 2n
		 	if(d < 0) 
		 		i++;
		 	total += d * i * i;
		 	d = -d;
		 }

		#3
		  long a = 1;
		  long total = 0;
		  for(int i=0; i<n; i++) 	n
		  	a = 2 * a; 				a = 2n +
		  for(int j=0; j<a; j++)
		  	total += j;
   
		#4
		int total = 0;
		if(n < 0) n = -n;
			while(n > 0) {
				n /= 4;
				total++;
			}
*/
	}
}
