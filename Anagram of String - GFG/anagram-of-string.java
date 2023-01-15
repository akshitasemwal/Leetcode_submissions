//{ Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
            /*char a1[]=s.toCharArray();
            Arrays.sort(a1);
            System.out.println(a1); */
            
            /*char a2[]=s1.toCharArray();
            Arrays.sort(a2);
            System.out.println(a2); */
            
            int[] count= new int[26];
            for(int i=0;i<s.length();i++)
            {
                count[s.charAt(i)-'a']++;
            }
            
            for(int i=0;i<s1.length();i++)
            {
                count[s1.charAt(i)-'a']--;
            }
            int num=0;
            
            for(int i=0;i<26;i++)
            {
                num+=Math.abs(count[i]);
            }
            return num;
        }
}