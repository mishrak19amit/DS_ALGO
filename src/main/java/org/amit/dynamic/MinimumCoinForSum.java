package org.amit.dynamic;

public class MinimumCoinForSum {

	public static void main(String[] args) {
		int coins[] =  {9, 6, 5, 1}; 
	       int m = coins.length; 
	       int V = 11; 
	       System.out.println("Minimum coins required is "+ minCoins(coins, m, V) ); 
	}

	public static int minCoins(int[] coins, int m, int v) {

		if(v==0) return 0;
		int res=Integer.MAX_VALUE;
		for(int i=0;i<m;i++)
		{
			if(coins[i]<=v)
			{
				int subRes=minCoins(coins, m, v-coins[i]);
				if(subRes!=Integer.MAX_VALUE && subRes+1<res )
				{
					res=subRes+1;
				}
			}
		}
		
		return res;
	}
	
}
