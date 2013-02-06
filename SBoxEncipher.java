import java.io.* ;

class SBoxEncipher {
    public static void main(String[] args) {
        int[][] S1 = { //S-box 1
      		     {15, 10, 2, 5},
      		     {8, 4, 11, 12},		     
      		     {1, 0, 14, 7},  		      
      		     {9, 3, 6, 13}
	             };                     

        int[][] S2 = { //S-box 2
      		     {4, 5, 15, 10},
      		     {8, 9, 7, 13},		     
      		     {0, 1, 6, 11},  		      
      		     {2, 3, 14, 12}
	             };            

	String plaintext = new String("1000 1100 1101 0110"); //Plaintext containing 4 binary numbers
	String key1 = new String("0001 0011 0010 1111"); //Key containing 4 binary numbers
	String key2 = new String("1010 0010 0011 1010"); //Key containing 4 binary numbers

	int base = 2;

	//Convert numbers to ints for proper xor evaluation
	int a2 = Integer.parseInt(plaintext.substring(5,9), base);
	int k1 = Integer.parseInt(key1.substring(0, 4), base);
	int k1xor1 = (a2 ^ k1);
	//Convert ints to binary string format with 0s for padding (e.g. 110 -> 0110)
	String k1xor1s = String.format("%4s", Integer.toBinaryString(k1xor1)).replace(' ', '0');

	int a4 = Integer.parseInt(plaintext.substring(15), base);
	int k3 = Integer.parseInt(key1.substring(10, 14), base);
	int k1xor2 = (a4 ^ k3);
	String k1xor2s = String.format("%4s", Integer.toBinaryString(k1xor2)).replace(' ', '0');

	int a1 = Integer.parseInt(plaintext.substring(0,4), base);
	int k2 = Integer.parseInt(key1.substring(5, 9), base);
	int k1xor3 = (a1 ^ k2);
	String k1xor3s = String.format("%4s", Integer.toBinaryString(k1xor3)).replace(' ', '0');

	int a3 = Integer.parseInt(plaintext.substring(10,14), base);
	int k4 = Integer.parseInt(key1.substring(15), base);
	int k1xor4 = (a3 ^ k4);
	String k1xor4s = String.format("%4s", Integer.toBinaryString(k1xor4)).replace(' ', '0');

	//obtain coordinates from binary strings
	int cipher1xCoord = Integer.parseInt(k1xor1s.substring(0, 2), base);
	int cipher1yCoord = Integer.parseInt(k1xor1s.substring(2, 4), base);
	int cipher2xCoord = Integer.parseInt(k1xor2s.substring(0, 2), base);
	int cipher2yCoord = Integer.parseInt(k1xor2s.substring(2, 4), base);
	int cipher3xCoord = Integer.parseInt(k1xor3s.substring(0, 2), base);
	int cipher3yCoord = Integer.parseInt(k1xor3s.substring(2, 4), base);
	int cipher4xCoord = Integer.parseInt(k1xor4s.substring(0, 2), base);
	int cipher4yCoord = Integer.parseInt(k1xor4s.substring(2, 4), base);

	int[] numberResult = new int[4]; //array to store numbers obtained from s-box lookups
	//First s-box lookup (s1)
	numberResult[0] = S1[cipher1yCoord][cipher1xCoord]; //lookup col first, then row
	//Second s-box lookup (s2)
	numberResult[1] = S2[cipher2yCoord][cipher2xCoord]; //lookup col first, then row
	//Third s-box lookup (s1)
	numberResult[2] = S1[cipher3yCoord][cipher3xCoord]; //lookup col first, then row
	//Fourth s-box lookup (s2)
	numberResult[3] = S2[cipher4yCoord][cipher4xCoord]; //lookup col first, then row

	//now our numberResult contains an array of numbers, e.g. 12 5 6 0
	//convert these numbers to their binary equivalents, e.g. 1100 0101 0110 0000, to complete encryption
	String[] binaryResult = {" ", " ", " ", " "}; //array of strings, each contaning one of the binary numbers
	binaryResult[0] = String.format("%4s", Integer.toBinaryString(numberResult[0])).replace(' ', '0');
	binaryResult[1] = String.format("%4s", Integer.toBinaryString(numberResult[1])).replace(' ', '0');
	binaryResult[2] = String.format("%4s", Integer.toBinaryString(numberResult[2])).replace(' ', '0');
	binaryResult[3] = String.format("%4s", Integer.toBinaryString(numberResult[3])).replace(' ', '0');
	System.out.println(binaryResult[0]);
	System.out.println(binaryResult[1]);
	System.out.println(binaryResult[2]);
	System.out.println(binaryResult[3]);

	}
}


