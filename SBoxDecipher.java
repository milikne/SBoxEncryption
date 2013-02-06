import java.io.* ;

class SBoxDecipher {
    public static void main(String[] args) {
        int[][] S1 = new int[4][4]; //S-box 1
        int[][] S2 = new int[4][4]; //S-box 2
	String plaintext = new String("1000 1100 1101 0110"); //Plaintext containing 4 binary numbers
	String key1 = new String("0001 0011 0010 1111"); //Key containing 4 binary numbers
	String key2 = new String("1010 0010 0011 1010"); //Key containing 4 binary numbers
	
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
//Convert ints to binary string format with 0s for padding 
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


//TODO: create cipher text from s-boxes
}
}


