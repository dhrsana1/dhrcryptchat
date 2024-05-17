package package cryptchat.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

import org.bouncycastle.crypto.DataLengthException;

public class BouncyCastleAPI_AES_CBC_UnitTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try {
			FileInputStream fis = new FileInputStream(
					new File("src/main/java/com/ibm/integration/resources/java/bcltwtapi/AES_CBC/clear.txt"));
			FileOutputStream fos = new FileOutputStream(
					new File("src/main/java/com/ibm/integration/resources/java/bcltwtapi/AES_CBC/encrypt.txt"));

			// solution 1
			BouncyCastleAPI_AES_CBC bc = new BouncyCastleAPI_AES_CBC();
			bc.InitCiphers();

			// encryption
			bc.CBCEncrypt(fis, fos);

			fis = new FileInputStream(new File("src/main/java/com/ibm/integration/resources/java/bcltwtapi/AES_CBC/encrypt.txt"));
			fos = new FileOutputStream(
					new File("src/main/java/com/ibm/integration/resources/java/bcltwtapi/AES_CBC/clear_test.txt"));

			// decryption
			bc.CBCDecrypt(fis, fos);

		} catch (ShortBufferException ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (DataLengthException ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalStateException ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(BouncyCastleAPI_AES_CBC_UnitTest.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println("Test done !");

	}
}
