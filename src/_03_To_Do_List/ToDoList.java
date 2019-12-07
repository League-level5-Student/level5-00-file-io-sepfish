package _03_To_Do_List;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	JFrame frame;
	JPanel panel;
	JButton addTask;
	JButton viewTasks;
	JButton removeTask;
	JButton saveList;
	JButton loadList;
	ArrayList<String> tasks = new ArrayList<String>();
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	void setup() {
		loadList();
		frame = new JFrame();
		panel = new JPanel();
		addTask = new JButton();
		addTask.setText("Add Task");
		addTask.setForeground(new Color(220, 50, 48));
		addTask.addActionListener(this);
		viewTasks = new JButton();
		viewTasks.setText("View Tasks");
		viewTasks.setForeground(new Color(210, 160, 42));
		viewTasks.addActionListener(this);
		removeTask = new JButton();
		removeTask.setText("Remove Tasks");
		removeTask.setForeground(new Color(23, 220, 100));
		removeTask.addActionListener(this);
		saveList = new JButton();
		saveList.setText("Save List"); 
		saveList.setForeground(new Color(23, 80, 230));
		saveList.addActionListener(this);
		loadList = new JButton();
		loadList.setText("Load List");
		loadList.setForeground(new Color(120, 48, 242));
		loadList.addActionListener(this);
		panel.add(addTask);
		panel.add(viewTasks);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		frame.add(panel);
		frame.setName("To Do List :)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addTask() {
		String a = JOptionPane.showInputDialog("Add a task to the to-do list: ");
		if (a != null) {
			tasks.add(a);
		}
	}
	
	public void viewTasks() {
		String oof = "";
		for (String s: tasks) {
			oof += s;
			oof += "\n";
		}
		JOptionPane.showMessageDialog(null, "Tasks:\n" + oof);
	}
	
	public void removeTask() {
		String bye = JOptionPane.showInputDialog("Which task would you like to remove?");
		if (tasks.contains(bye)) {
			tasks.remove(bye);
		} else {
			JOptionPane.showMessageDialog(null, "That task isn't in the to-do list.");
		}
	}
	
	public void saveList() {
		String yes = "";
		for (String s: tasks) {
			yes += s;
			yes += "\n";
		}
		try {
			FileWriter fw = new FileWriter("list.txt");
			fw.write(yes);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadList() {
		System.out.println("h");
	}
	
	public static void main(String[] args) {
		ToDoList todoist = new ToDoList();
		todoist.setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.equals(addTask)) {
			addTask();
		} else if (b.equals(viewTasks)) {
			viewTasks();
		} else if (b.equals(removeTask)) {
			removeTask();
		} else if (b.equals(saveList)) {
			saveList();
		} else if (b.equals(loadList)) {
			loadList();
		}
	}
}
