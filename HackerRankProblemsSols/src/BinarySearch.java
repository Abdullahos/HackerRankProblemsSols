//alowing duplication while inserting
public class BinarySearch {
	private int mid = 0 ;
	public int binSearch(int [] list, int num, int first , int last) {
		
		if(first<last) {
			mid = (last+first)/2;
			//if found	
			if(list[mid]==num)	return mid;
			//if current>num--> go backward 
			if(list[mid]>num)	last = mid-1;
			//else -->go forward
			else	first = mid+1;
			binSearch(list,num,first,last);
		}
		return mid;
	}
	
	public  int[] insertInOrder(int num , int[] orderedList) {
		//to contains numbers after insertion
		int [] listAfterInser = new int[orderedList.length+1];
		if(num<orderedList[0])	{
			System.arraycopy(orderedList, 0, listAfterInser, 1,orderedList.length);
			listAfterInser[0] = num;
			return listAfterInser;
		}
		if (num>orderedList[orderedList.length-1]){
			System.arraycopy(orderedList, 0, listAfterInser, 0 ,orderedList.length);
			listAfterInser[listAfterInser.length-1] = num;
			return listAfterInser;
		}
			
		int lastMid = binSearch(orderedList,num,0,orderedList.length-1);
		System.out.println(lastMid);
		//if no<elem mov left till find a smaller one 
		if(num<orderedList[lastMid]) {

				while(lastMid-1>=0) {
					lastMid--;
					if(orderedList[lastMid] < num)	{
						//اتفضل رجعني بقى زي ما جبتني
						lastMid++;
						break;
					}
				}
			}
			//num is bigger than elem @ lastMid
			else {
				
				while(lastMid+1<=orderedList.length-1) {
					lastMid++;
					if(orderedList[lastMid] > num)	{
						//warning !اتفضل رجعني بقى زي ما جبتني
						//lastMid--;
						break;
					}
				}
			}
			//we got the index where num should be
			//clone 0->till lastMid, but num, then lastMid->end
			//before
			System.arraycopy(orderedList,0,listAfterInser,0,lastMid);
			//place
			listAfterInser[lastMid] = num;
			System.arraycopy(orderedList, lastMid, listAfterInser, lastMid+1, listAfterInser.length-(lastMid+1));
			return listAfterInser;
	}
	public static void main(String[] args) {
		int arr[] = {1,3,6,10,11};
		//get index
		int [] afterInser = new BinarySearch().insertInOrder(19,arr);
		for(int i = 0 ; i <afterInser.length; i++ )
		System.out.println(afterInser[i]);
		
	}
	
}
