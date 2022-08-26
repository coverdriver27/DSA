/*Guillermo Haro
 * Comp 182	
 * 4/13/17
 * */
 class InsertionSort extends BasicSort {
	public InsertionSort(){
		 super("InsertionSort");
		 }
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		for (int i = 1; i < data.length; i++) {// nested for loops to traverse through the array
            for(int j = i ; j > 0 ; j--){//assign the value of i to j and whenever j is greater than 0.. next line
            	//check weather the index of j is less than the index of j -1
                if(data[j] < data[j-1]){//if it is thenn passit to the checked swap method 
                	checkedswap(j, j-1);
                }//end of if statament
            }//end of second for loop
        }// end of first for loop

	}//end sort
	 
	            
	        
	}
 
