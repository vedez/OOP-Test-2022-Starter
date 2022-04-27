package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//Create an array list for Nematodes
	public ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		//Create size of application
		size(800, 800);

		//Call load and print functions
		loadNematodes();
		printNematodes();
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}

	//loads and input data into the array list 
	public void loadNematodes() {
		Table t = loadTable("nematodes.csv", "header");

		for(TableRow row:t.rows()) {
			Nematode n = new Nematode(row);
			nematodes.add(n);
		}
	}

	public void printNematodes() {
		for(Nematode n:nematodes) {
			System.out.println(n);
		}
	}
	


	public void draw()
	{	
	}
}
