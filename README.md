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

3. Matrix Rotation

20240307

4. SpringBoot Assessment Practical Question:
	
 DDL for table based on data model
	
 Writing Entity class with Annotations and marking Related Entities with correct relations Annotations
	
 Autowiring Configuration, Service, Repository, Controller, etc.
	
 Reading properties from properties file
	
 CRUD operations based on JpaRepository default methods and Spring JPA methods
 
5. Finding smallest positive integer that did not appear in array
	
 	[3,1,4,5,6] return 2
 	[-1,-3,-5] return 1
	number from the array is between -1,000,000 and 1,000,000

7. Bank. Only two accounts A and B.
	
 String and int array, representing transfering to account and value to transfer. Rule is after each transaction, account value must not be negative. Find out what is the minimum start value of the two accounts A and B in an array
 String "BAABA" array [2,4,1,1,2] return [2,4], meaning A start with 2 and B start with 4
