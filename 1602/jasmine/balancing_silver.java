//33 minutes 
//Blocked on one part that preventing me from passing silver
import java.util.*;
import java.io.*;
public class balancing {
	static long [] coord;
	static int n;
	static long B;
	public static void main(String[] args) throws IOException{
		
		Scanner scan = new Scanner (new File ("balancing.in"));
		n = scan.nextInt();
		//B = scan.nextInt();
		
		int [] x = new int [n];
		int [] y = new int [n];
		coord = new long [n];
		for (int i = 0; i < n; i++) {
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
			coord[i] = x[i]*1000000 + y[i];  // <-- this is wrong, why?
			//System.out.println(n);
		}
		Arrays.sort(x);
		Arrays.sort(y);
		
		
		int min = n;
		//instead of incrementing by 2, it should be faster doing by cow
		for (int i = 0; i <= n ; i++) {
			for (int j = 0; j <=n; j++) {
				int a, b;
				if (i == n) 
					a = x[n-1]+1;
				else
					a = x[i]-1;
				if (j == n) 
					b = y[n-1]+1;
				else
					b = y[j]-1;
				int m = largestM(a,b);
				if (m < min)
					min = m;
			}
			
		}
		
		System.out.println(min);
		//int larger = (n+1)/2;
		/*
		int i1;
		int i2;
		if (n%2 == 0) {
			i1 = n/2-1;
			i2 = n/2;
		}
		else {
			i1 = n/2-1;
			i2 = n/2+1;
		}
		//System.out.println(i1 + " " + i2);
		int a = shift(i1,i2,x);
		System.out.println();
		int b = shift(i1,i2,y);
		System.out.println(a);
		System.out.println(b);*/
		
		
		
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		//System.out.println(sections[3]);
		//out.println(sections[3]);
		out.println(min);
		
		
		
	
		out.close();
		scan.close();
	}
	//can't figure out how to calculate the largest region size -> preventing me from passing silver
	public static int largestM (int a, int b) {
		int [] sections = new int [4];
		for (int i = 0; i < n; i++) {
			long xVal = coord[i]/1000000;
			long yVal = coord[i]%1000000;
			
			if (xVal < a) {
				if (yVal < b)
					sections[0]++;
				else
					sections[1]++;
			}
			else {
				if (yVal < b)
					sections[2]++;
				else
					sections[3]++;
			}
		}
		Arrays.sort(sections);
		return sections[3];
	}
	
	//didn't work
	public static int shift (int i1, int i2, int [] a) {
		while (i1 >= 0) {
			System.out.println(a[i1] + " " + a[i1+1]);
			System.out.println(a[i2] + " " + a[i2-1]);
			if (a[i2] != a[i2-1]) 
				return (a[i2] + a[i2-1])/2;
			if (a[i1] != a[i1+1]) 
				return (a[i1] + a[i1+1])/2;
			
			i1-= 1;
			i2+=1;
			System.out.println(i1+ " " + i2);
		}
		
		return 0;
	}

}
