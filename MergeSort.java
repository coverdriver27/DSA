/*Guillermo Haro
 * Comp 182	
 * 4/13/17
 * */
class MergeSort extends BasicSort{
	int [] temp;
	public MergeSort(){
		super("MergeSort");
	}//end of merge sort constructor
	
	public MergeSort(String n){
		super(n);
	}//end of merge sort constructor

	public void sort(){
		this.temp = new int[data.length];
		mergeSort(0, data.length - 1);
	}//end of sort method

	private void mergeSort(int first, int last)
	{

		if (first < last){//check if the left is smaller than the right because if it is then its already sorted
			int middle = first + (last - first) / 2;//assign the middle which is left plus right - left / 2
			
			mergeSort(first, middle);//this sorts the left side of the array
			mergeSort(middle + 1, last);//this sorts the right side
			//this for loop combines all of the values
			for (int i = first; i <= last; i++){//create a temporary array and assign all the value of our data array onto it
				temp[i] = data[i];
			}
			int i = first;
			int j = middle + 1;
			int k = first;
			while (i <= middle && j <= last)//copies the smallest left side of the array to the original array
			{
				if (temp[i] <= temp[j])
				{
					data[k] = temp[i];
					i++;
				}
				else
				{
					data[k] = temp[j];
					j++;
				}
				k++;
			}
			while (i <= middle)//assigns the rest
			{
				data[k] = temp[i];
				k++;
				i++;
			
		}
	}
}
}

