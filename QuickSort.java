/*Guillermo Haro
 * Comp 182	
 * 4/13/17
 * */
 class QuickSort extends BasicSort{
	 public QuickSort(){
			super("QuickSort");
		}//end of quicksort constructor

		public void sort(){
			quickSort(data, 0, data.length - 1);
		}//end of sort constructor

		public int partition(int tmpory[], int left, int right){//create a method that assigns the partition or list of numbers
			int i = left, j = right;
			int pivot = tmpory[(left + right) / 2];//assign a pivot which is a number that will be comparing and contrasting to every other number
			/*
			 * Create a nested while loop to traverse through the array
			 * Check if the left side of the array is less than the pivot
			 *If it is which it most likely is then increase index i by 1
			 * The next while loop checks if the right side of the array is greater than the pivot and if it is decrease j by 1
			 * run the checkedswap to compare
			 * increase left side and decrease right side
			 * */
			while (i <= j){//
				while (tmpory[i] < pivot){
					i++;
				}//end of second while loop
				while (tmpory[j] > pivot){
					j--;
				}//end of thirsd while loop
				if (i <= j){
					checkedswap(i, j);
					i++;
					j--;
				}//end of if statement
			}//end of while loop
			

			return i;//return the left side since its in order from left to right
		}

		void quickSort(int tmpory[], int left, int right){//create a quicksort methdod
			int index = partition(tmpory, left, right);//assign index to the left side which is i from the partition method
			if (left < index - 1){
				quickSort(tmpory, left, index - 1);//recursive method
			}//end of if statement
			if (index < right){
				quickSort(tmpory, index, right);//recursive method
			}//end of second if statement
	}//end of quicksort method

}//end of class
