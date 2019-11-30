package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		FileRecorder fr = new FileRecorder();
		fr.program();
	}
	
	void program() {
		String s = JOptionPane.showInputDialog("Enter a message to save to a file:");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/file.txt");
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
