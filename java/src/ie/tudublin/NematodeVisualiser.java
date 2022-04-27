package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	//variables for drawNematode
	public float border;
    public int i = 0; //counter

	//Create an array list for Nematodes
	public ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
        {
            if (i == 0)
				//wrap around (-1)
                i = nematodes.size() - 1;
            else
                i--;
        }
        if (keyCode == RIGHT)
        {
			//wrap around (-1)
            if (i == nematodes.size() - 1)
                i = 0;
            else
                i++;
        }  	
	}


	public void settings()
	{
		//Create size of application
		size(800, 700);

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

	//prints each line of data into terminal
	public void printNematodes() {
		for(Nematode n:nematodes) {
			System.out.println(n);
		}
	}
	
	//Visualise the nematode data 
	public void draw()
	{	
		//Black background 
		background(0);
	
		//Draw each instance of Nematode
		drawNematode();
	}

    void drawNematode() {
		//white and line (sz3)
        stroke(255, 0, 255);
        strokeWeight(3);

		//location of nematode in x-axis & y-axis and size 
        float x = width / 2;
		float y = (height / 4);
        int size = 50;
        noFill();

		//variables
		String gender = nematodes.get(i).gender;
        int length = nematodes.get(i).length;
        int limb = nematodes.get(i).limbs;

        //Body -> length = 1 circle
        for(int i = 0; i < length; i++) 
        {
            ellipse(x, y, size, size);
            if (limb == 1)
            {    
                //legs - line(x1, y1, x2, y2);    
                line(x + size / 2, y, x + size, y); //right limbs
                line(x - size / 2, y, x - size, y); //left limbs
            }
			//lowering each circle for the body 
            y = y + size;
        }

		//F, M, H, N(No display)
		if (gender.charAt(0) == 'f') {
            ellipse(x, y - size, size / 2, size / 2); //Add another small circle into the last one
        }
        else if (gender.charAt(0) == 'm') {
            line(x, y - size / 2, x, y); //Draws the small line (tail?)
            ellipse(x, y + size / 7, size / 5, size / 5); //extra circle at the end
        }
		else if (gender.charAt(0) == 'h') { //both m and f together
            ellipse(x, y - size, size / 2, size / 2);
            line(x, y - size / 2, x, y);
            ellipse(x, y + size / 7, size / 5, size / 5);
        }
    }
}
