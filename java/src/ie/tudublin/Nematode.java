package ie.tudublin;
import processing.data.TableRow; //Importing table func

public class Nematode {
    //private variables
    private String name;
    private String gender; //m, f, h, n
    private int length;
    private int limbs = 0; //no limbs
    private int eyes = 0; //no eyes

    //constructor
    public Nematode(String name, String gender, int length, int limbs, int eyes) {
        this.name = name;
        this.gender = gender;
        this.length = length;
        this.limbs = limbs;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr){
        this(tr.getString("name"), tr.getString("gender"), tr.getInt("length"), tr.getInt("limbs"),  tr.getInt("eyes"));
    }

    //accessor methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    //toString method
    public String toString() {
        return "[" + this.name + ", " + this.gender + ", " + this.length +  ", " + this.limbs  + ", " + this.eyes + "]";
    }
}
