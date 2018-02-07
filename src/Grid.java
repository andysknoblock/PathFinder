import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Grid extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows, columns;
	private int grid[][];
	public void setDimensions(int rows, int columns)
	{
		this.rows=rows;this.columns=columns;
		grid = new int [rows][columns];
	}
	public void generateGrid(float likely)
	{
		grid[0][0]=0;
		for (int i=0;i<rows;i++)
		{
			for (int a=1;a<columns;a++)
			{
				Random r = new Random();
				if (r.nextFloat()<likely)
					grid[i][a]=1;
				else
					grid[i][a]=0;
				if (i==rows-1 && a==columns-1)
					grid[i][a]=0;
			}
		}
		try 
		{
			PrintWriter pw = new PrintWriter("defaultGrid.grd");
			for (int i=0;i<rows;i++)
			{
				for (int a=0;a<columns;a++)
				{
					pw.print(grid[i][a]);
					if (a<columns-1)
						pw.print(",");
				}
				pw.println();
			}
			pw.close();
			System.out.println("Grid Generated");
		} 
		catch (FileNotFoundException e) {
			System.out.println(e);
		} 
	}
	public void loadGrid()
	{
		JFileChooser jfc = new JFileChooser();
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter= new FileNameExtensionFilter("Grid files (.GRD)", "grd");
		jfc.setFileFilter(filter);
		int returnVal = jfc.showOpenDialog(this);
		File f=null;
		if (returnVal==JFileChooser.APPROVE_OPTION)
		{
			System.out.println("Reading from grid file");
			f = jfc.getSelectedFile();
			
		}
		else
		{
			System.out.println("Literally not a file good work");
		}
		Scanner input;
		try {
			input = new Scanner(f);
			int c=0,r=0;
			while(input.hasNextLine())
			{
				String data = input.nextLine();
				String[] info = data.split(",");
				r = info.length;
				c++;
			}
			setDimensions(r,c);
			input.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int c=0;
		Scanner dat;
		try {
			dat = new Scanner(f);
			c=0;
			while(dat.hasNextLine())
			{
				String data = dat.nextLine();
				String[] info = data.split(",");
				for (int a=0;a<info.length;a++)
				{
					grid[a][c]=Integer.parseInt(info[a]);
				}
				c++;
			}
			dat.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private boolean isValidSquare(int r, int c)
	{
		if ( r<rows && c<columns)
		{
			if (grid[r][c]==0 && grid[r][c]!=1)
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
	}
	public void printGrid()
	{
		for (int i=0;i<rows;i++)
		{
			for (int a=0;a<columns;a++)
			{
				System.out.print("|");
				if (grid[i][a]==1)
					System.out.print("X");
				else
					System.out.print(" ");
			}
			System.out.println("|");
		}
	}
	public int countPathsRightDown(int r, int c)
	{
		if (!isValidSquare(r,c))
			return 0;
		if (r==rows-1 && c == columns-1)
			return 1;
		else
		{
			return countPathsRightDown(r+1,c)+countPathsRightDown(r,c+1);
		}
		
	}

}