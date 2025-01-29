//written by kennedy poag
public class RightTriangle extends Shape
{
	//instance variables
    private double base;
    private double height;
    private double area;
    //default constructor
    public RightTriangle()
    {
        super();
        this.base=0;
        this.height=0;
        this.area=0.5*this.base*this.height;
    }
    //parameterized constructor
    public RightTriangle(String name, double base, double height)
    {
        super(name);
        this.setBase(base);
        this.setHeight(height);
        this.setArea();
    }
    //setter for base
    public void setBase(double base)
    {
        if(base>=0)
            this.base=base;
        else
            this.base=0;
    }
    //setter for height
    public void setHeight(double height)
    {
        if(height>=0)
            this.height=height;
        else
            this.height=0;
    }
    //getter for base
    public double getBase()
    {
        return this.base;
    }
    //getter for height
    public double getHeight()
    {
        return this.height;
    }
    //setter for area
    public void setArea()
    {
        if(this.height>0&&this.base>0)
            this.area=0.5*this.base*this.height;
        else
            this.area=0;
    }
    //getter for area
    public double getArea()
    {
        return this.area;
    }
    //right triangle string
    public String toString()
    {
        return super.toString()+"\t"+"Base: "+this.base+"\t"+"Height: "+this.height+
        "\t"+"Area: "+this.area;
    }
    //create string for output file
    public String toFile()
    {
        return super.toFile()+"\t"+this.base+"\t"+this.height+"\n";
    }
    //check equality of another triangle
    public boolean equals(RightTriangle other)
    {
        return other!=null && super.equals(other) && this.getBase()==other.getBase() && 
        this.getHeight()==other.getHeight();
    }
}