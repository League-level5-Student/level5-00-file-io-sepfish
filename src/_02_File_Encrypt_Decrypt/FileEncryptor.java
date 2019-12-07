package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public String fileName = "fileToDecrypt.txt";
	
	public void takeMessage() {
		String message = JOptionPane.showInputDialog("Input a message: ");
		String encrypt = "";
		char[] yeet = new char[message.length()];
		yeet = message.toCharArray();
		for (int i = 0; i < message.length()/2; i++) {
			char c = yeet[i];
			yeet[i] = yeet[yeet.length - 1 - i];
			yeet[yeet.length - 1 - i] = c;
		}
		for (char c: yeet) {
			encrypt += c;
		}
		
		try {
			FileWriter fw = new FileWriter("fileToDecrypt.txt");
			fw.write(encrypt);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		FileEncryptor effie = new FileEncryptor();
		effie.takeMessage();
	}
}
