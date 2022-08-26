/*Guillermo Haro
 * Comp 182	
 * 4/13/17
 * */
class BubbleSort extends BasicSort {
	public BubbleSort() {
		super("BubbleSort");
	}// end of bubblesort constructor

	public void sort() {
		// details of Bubble Sort algorithm go here.
		// it overrides and implements inherited abstract method
		// assume int[] data already contains values to sort
	
	
	for(int i = 1; (i < data.length); ++i){// for loop to traverse through the array
	//
		for(int index = 0; index < data.length - i; ++index){//nested for loop assign index 0 and if index is less than the length - 1 then pass on 
			//to this line where you assign nextIn to index plus 1
			int nextIn = index + 1;
			if(data[index] > data[nextIn]){//if index is greater than nextIn indexed then pass it to the checked swap method
				checkedswap(index, nextIn);
			}
		}//end of second for loops
	}//end of for loop

	
			  
			          
			         }
			      
			

}
// end of sort method
