import java.io.* ;

class SBoxEncipher {
    public static void main(String[] args) {
        int[][] S1 = new int[4][4]; //S-box 1
        int[][] S2 = new int[4][4]; //S-box 2
	String plaintext = new String("1000 1100 1101 0110"); //Plaintext containing 4 binary numbers
	String key1 = new String("0001 0011 0010 1111"); //Key containing 4 binary numbers
	String key2 = new String("1010 0010 0011 1010"); //Key containing 4 binary numbers
	//TODO: use array literal to initialize S1 and S2, making code less lengthy
//initialize S-box 1 with appropriate values
	S1[0][0] = 15;
	S1[0][1] = 10;
	S1[0][2] = 2;
	S1[0][3] = 5;
	S1[1][0] = 8;
	S1[1][1] = 4;
	S1[1][2] = 11;
	S1[1][3] = 12;
	S1[2][0] = 1;
	S1[2][1] = 0;
	S1[2][2] = 14;
	S1[2][3] = 7;
	S1[3][0] = 9;
	S1[3][1] = 3;
	S1[3][2] = 6;
	S1[3][3] = 13;

//initialize S-box 2 with appropriate values
	S2[0][0] = 4;
	S2[0][1] = 5;
	S2[0][2] = 15;
	S2[0][3] = 10;
	S2[1][0] = 8;
	S2[1][1] = 9;
	S2[1][2] = 7;
	S2[1][3] = 13;
	S2[2][0] = 0;
	S2[2][1] = 1;
	S2[2][2] = 6;
	S2[2][3] =11;
	S2[3][0] = 2;
	S2[3][1] = 3;
	S2[3][2] = 14;
	S2[3][3] = 12;

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


