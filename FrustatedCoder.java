/*3. Frustrated coders   There are N frustrated coders standing in a circle with a gun in their hands. 
 * Each coder has a skill value S[ i ] and he can only kill those coders that have strictly less skill than 
 * him. One more thing, all the guns have only 1 bullet. This roulette can take place in any random order.
 *  Fortunately, you have the time stone (haaan wo harre wala) and you can see all possible outcomes of this 
 *  scenario. Find the outcome where the total sum of the remaining coder's skill is minimum. Print this sum. 
 
Input Format The first line contains N the no. of coders The next line contains N  elements where the ith 
element is theS[ i ] of ith coder. */





package git;
import java.util.*;
public class FrustrateCoders {
	public static void main(String args[]) {
		int i,j,max,k,n,temp=0,sum=0;
		int S[]=new int[10];
		int kill[]=new int[10];
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		for(i=0;i<n;i++) {
			S[i]=sc.nextInt();
		}
		
		for(i=0;i<n;i++) {
			max=S[i];
			k=i;
			for(j=i+1;j<n;j++) {
				if(S[j]>max) {
					max=S[j];
					k=j;
				}
			}
			temp=S[k];
			S[k]=S[i];
			S[i]=temp;
		}
		
		for(i=0;i<n;i++) {
			kill[i]=0;
		}
		
		for(i=0;i<n;i++) {
			for(j=i+1;j<n;j++) {
				if( (S[j]<S[i]) && (kill[j]!=-1) ){
					kill[j]=-1;
					break;
				}
			}
		}
		
		for(i=0;i<n;i++) {
			if(kill[i]==0) {
				sum=sum+S[i];
			}
		}
		System.out.println(sum);
	}
}

