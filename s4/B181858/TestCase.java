package s4.B181858; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	int c;
	c = 0;
	try {
		FrequencerInterface  myObject;
		FrequencerInterface  myObject1;
		FrequencerInterface  myObject2;
		FrequencerInterface  myObject3;
		FrequencerInterface  myObject4;
		FrequencerInterface  myObject5;
		FrequencerInterface  myObject6;
		FrequencerInterface  myObject7;
		FrequencerInterface  myObject8;

		int freq,freq1,freq2, freq3,freq4,freq5,freq6,freq7,freq8;
		
		c = 0;
	    System.out.println("checking Frequencer");

	    // This is smoke test
	    myObject = new Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    if(4 != freq) {System.out.println("frequency() for Hi_Ho_Hi_Ho, should return 4, when target is H. But it returns "+freq); c++; }

		// Write your testCase here
		//Test case 1: TARGET is not set or TARGET's length is zero.
		myObject1 = new Frequencer();
		myObject1.setSpace("Hi Ho Hi Ho".getBytes());
		myObject1.setTarget("".getBytes());
		freq1 = myObject1.frequency();
		if(-1 != freq1) {System.out.println("Test case 1: frequency() for Hi_Ho_Hi_Ho, should return -1, when target is not set. But it returns "+freq1); c++; }

		//Test case 2: It returns 0 when SPACE is not set or SPACE's length is zero.
		myObject2 = new Frequencer();
		myObject2.setSpace("".getBytes());
		myObject2.setTarget("H".getBytes());
	    freq2 = myObject2.frequency();
		if(0 != freq2) {System.out.println("Test case 2: frequency() for empty, should return 0, when target is H. But it returns "+freq2); c++; }
		
		//Test case 3: 小文字
		myObject3 = new Frequencer();
		myObject3.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject3.setTarget("o".getBytes());
	    freq3 = myObject3.frequency();
		if(2 != freq3) {System.out.println("Test case 3: frequency() for Hi_Ho_Hi_Ho, should return 2, when target is o. But it returns "+freq3); c++; }
		
		//Test case 4: スペースの数
		myObject4 = new Frequencer();
		myObject4.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject4.setTarget(" ".getBytes());
	    freq4 = myObject4.frequency();
		if(3 != freq4) {System.out.println("Test case 4: frequency() for Hi_Ho_Hi_Ho, should return 3, when target is space. But it returns "+freq4); c++; }

		//Test case 5: 文字列
		myObject5 = new Frequencer();
		myObject5.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject5.setTarget("Hi".getBytes());
	    freq5 = myObject5.frequency();
		if(2 != freq5) {System.out.println("Test case 5: frequency() for Hi_Ho_Hi_Ho, should return 2, when target is Hi. But it returns "+freq5); c++; }

		//Test case 6: 小文字と大文字
		myObject6 = new Frequencer();
		myObject6.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject6.setTarget("h".getBytes());
	    freq6 = myObject6.frequency();
		if(0 != freq6) {System.out.println("Test case 6: frequency() for aaaaaaa, should return 6, when target is aa. But it returns "+freq6); c++; }

		//Test case 7: duplicate string
		myObject7 = new Frequencer();
		myObject7.setSpace("aaaaaaa".getBytes());
	    myObject7.setTarget("aa".getBytes());
	    freq7 = myObject7.frequency();
		if(6 != freq7) {System.out.println("Test case 6: frequency() for aaaaaaa, should return 6, when target is aa. But it returns "+freq7); c++; }

		//Test case 8: targetLength > spaceLength:
		myObject8 = new Frequencer();
		myObject8.setSpace("Hi".getBytes());
	    myObject8.setTarget("Hiho".getBytes());
	    freq8 = myObject8.frequency();

	}
	catch(Exception e) {
	    System.out.println("Exception occurred in Frequencer Object");
	    c++;
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking InformationEstimator");
	    myObject = new InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    if((value < 1.9999) || (2.0001 <value)) { System.out.println("IQ for 0 in 3210321001230123 should be 2.0. But it returns "+value); c++; }
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 01 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    if((value < 2.9999) || (3.0001 <value)) { System.out.println("IQ for 0123 in 3210321001230123 should be 3.0. But it returns "+value); c++; }
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    if((value < 3.9999) || (4.0001 <value)) { System.out.println("IQ for 00 in 3210321001230123 should be 4.0. But it returns "+value); c++; }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred in InformationEstimator Object");
	    c++;
	}
	if(c == 0) { System.out.println("TestCase OK"); }
    }
}	    
	    
