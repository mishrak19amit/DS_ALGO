package HackerEarth;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBooking {

	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		
		Collections.sort(arrive);
		Collections.sort(depart);
		
		boolean isPossible=true;
		int i=0,j=0;
		int available=K;
		while(i<arrive.size()&&j<depart.size()) {
			if(arrive.get(i)<depart.get(j)) {
				available--;
				i++;
				if(available<0) {
					return false;
				}
			}
			else {
				available++;
				j++;
			}
		}
		
		return isPossible;
    }
	
	public static void main(String[] args) {
		
		int arri[]=new int[] {1,3,5};
		int dep[]=new int[] {2,4,8};
		int k=1;
		
		MaxSubPostiveArray obj= new MaxSubPostiveArray();
		
		if(hotel(obj.getArryaListFromArray(arri), obj.getArryaListFromArray(dep),k)) {
			System.out.println("Possible");
		}
		else {
			System.out.println("Not possible");
		}
		
		
	}
	
}
