# Interview
1. Reverse a LinkedList
	
	original: 1->2->3->4->5->null
	
	reversed: 5->4->3->2->1->null


2. Sort and Edit and array
	
	original: [0,2,3,100,5]

	output:	  [0,-1,2,3,-1]

	for (int index = 0; index < arr.length; index ++) {
		if (arr.contains(index)) {
			out[index] = index;
		} else {
			out[index] = -1;
		}
	}