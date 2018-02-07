import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

public class DankPaths {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grid g = new Grid();
		frame.add(g);
		System.out.println("Weclome to the Path Counter\nThis application counts the number of possible paths from the upper right corner of the screen to the bottom left corner\nby moving only right and down");
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to read from a grid (.grd) file (y/n):");
		if (input.next().toLowerCase().equals("y")) 
		{
			g.loadGrid();
			g.printGrid();
			System.out.println(g.countPathsRightDown(0, 0));
		}
		else 
		{
			System.out.println("Enter the number of rows in your grid:");
			int rows = 0, cols = 0;
			boolean fail = false;
			if (input.hasNextInt()) {
				rows = input.nextInt();
			} else {
				System.out.println("BOI FREAKING ENTER THE NUMBER OF ROWS JESUS");
				fail = true;
			}
			System.out.println("Enter the number of rows in your grid:");
			if (input.hasNextInt()) {
				cols = input.nextInt();
			} 
			else {
				System.out.println("BOI FREAKING ENTER THE NUMBER OF COLUMNS JESUS");
				fail = true;
			}
			System.out.println("Enter the probability of a square being blocked:");
			float likely=0;
			if (input.hasNextFloat()) {
				likely = input.nextFloat();
			} 
			else {
				System.out.println("BOI FREAKING ENTER THE PROBABILITY JESUS");
				fail = true;
			}
			if (!fail) {
				g.setDimensions(rows, cols);
				g.generateGrid(likely);
				g.printGrid();
				System.out.println(g.countPathsRightDown(0, 0));
			} else {
				System.out.println("I CAN'T BELIVE YA ENTERED YER INFO WRONG");
			}
			input.close();

		}

	}
}