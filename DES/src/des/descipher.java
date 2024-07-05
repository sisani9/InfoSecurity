package des;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class descipher {


public static void main(String[] argv) {
try{
	System.out.println("Message Encryption Using DES Algorithm\n-------");
 
	KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	SecretKey myDesKey = keygenerator.generateKey();
	Cipher desCipher;
	desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
	
	Scanner sc = new Scanner(System.in);   
    
    // take input from the user   
    System.out.println("Enter message: ");   
    String inputStr = sc.nextLine();   
 
	byte[] text = inputStr.getBytes();
 
	System.out.println("Message [Byte Format] : " + text);
	System.out.println("Message : " + new String(text));
 
	byte[] textEncrypted = desCipher.doFinal(text);
	
	System.out.println("Encrypted Message: " + textEncrypted);
 
	desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
 
	byte[] textDecrypted = desCipher.doFinal(textEncrypted);
	
	System.out.println("Decrypted Message: " + new 
			String(textDecrypted));
}
	catch(NoSuchAlgorithmException e){
		e.printStackTrace();
}
	catch(NoSuchPaddingException e){
		e.printStackTrace();
}
	catch(InvalidKeyException e){
		e.printStackTrace();
}
	catch(IllegalBlockSizeException e){
		e.printStackTrace();
}
	catch(BadPaddingException e){
		e.printStackTrace();
}
}
}