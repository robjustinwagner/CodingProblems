/*
An English text needs to be encrypted using the following encryption scheme. 
First, the spaces are removed from the text. Let L be the length of this text. 
Then, characters are written into a grid, whose rows and columns have the following constraints:

> Math.floor(Math.sqrt(L)) <= rows <= column <= Math.ceil(Math.sqrt(L))

For example, the sentence "if man was meant to stay on the ground god would have given us roots" 
after removing spaces is 54 characters long, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots

> Ensure that rows x columns >= L
> If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .

The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and 
inserting a space, and so on. For example, the encoded message for the above rectangle is:

"imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"

You will be given a message in English with no spaces between the words. The maximum message length can be characters. Print the encoded message.

Here are some more examples:

Sample Input: haveaniceday
Sample Output: hae and via ecy

Sample Input: feedthedog    
Sample Output: fto ehg ee dd

Sample Input: chillout
Sample Output: clu hlt io

https://www.hackerrank.com/challenges/encryption
@author	rob.wagner
 */

package algorithms;

import java.util.*;

public class Implementation_Encryption {

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String message = in.next();
	    
	    int L = message.length();
	    char[][] encryptedGrid = 
	    		new char[(int)Math.floor(Math.sqrt(L))][(int)Math.ceil(Math.sqrt(L))];
	    
	    printEncryptedMessage(encryptedGrid);
	}
	
	static void printEncryptedMessage(char[][] encryptedGrid){
		//no null check, since primitive types cannot be null.
		
		printEncryptedRecurse(encryptedGrid, 0, 0);
	}
	
	private static void printEncryptedRecurse(char[][] encryptedGrid, int row, int col){
		if(col != 0 && row == 0){
			System.out.println(" ");
		}
		System.out.println(encryptedGrid[row][col]);
		
		//modify row/col values
		//extensible, if problem statement changed and rows needed to be different lengths.
		row = (row++) % encryptedGrid.length;
		col = (row == 0) ? col++ : col;
		printEncryptedRecurse(encryptedGrid, row, col);
	}
	
}
