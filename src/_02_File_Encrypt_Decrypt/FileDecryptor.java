package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public void analysis(String s) {
		String message = "";
		String y = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("fileToDecrypt.txt"));
			String line = br.readLine();
			while(line != null){
				message += line;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char[] yeet = new char[message.length()];
		yeet = message.toCharArray();
		for (int i = 0; i < message.length()/2; i++) {
			char c = yeet[i];
			yeet[i] = yeet[yeet.length - 1 - i];
			yeet[yeet.length - 1 - i] = c;
		}
		for (char c: yeet) {
			y += c;
		}
		
		JOptionPane.showMessageDialog(null, "Your message is: " + y);
	}
	
	public static void main(String[] args) {
		FileEncryptor effie = new FileEncryptor();
		effie.takeMessage();
		FileDecryptor kowalski = new FileDecryptor();
		kowalski.analysis(effie.fileName);
	}
	
}
