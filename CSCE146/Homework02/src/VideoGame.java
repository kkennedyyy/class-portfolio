//Written by Kennedy Poag
public class VideoGame 
//Instance Var
{
    private String name;
    private String console;

    public VideoGame(){
    	//Set instance var to default val
        this.name="none";
        this.console="none";
    }
    public VideoGame(String name, String console){
        this.setName(name);
        this.setConsole(console);
    }
    //Checks to see if variables are empty
    public void setName(String name){
        if(name!=null)
            this.name=name;
        else
            this.name="none";
    }
    public void setConsole(String console){
        if(console!=null)
            this.console=console;
        else
            this.console="none";
    }//Returns our variables
    public String getName(){
        return this.name;
    }
    public String getConsole(){
        return this.console;
    }
    public String toString(){
        return name+"\t"+console;
    }
    //Checks to see if list contains our var
    public boolean containsName(VideoGame other){
    	 return other != null && this.getName().toUpperCase().contains(other.getName().toUpperCase());
    }    
    public boolean containsConsole(VideoGame other){
        return other!=null && this.getConsole().toUpperCase().contains(other.getConsole().toUpperCase());
    }
    public boolean equals(VideoGame other){
        return other!=null && this.getName().equalsIgnoreCase(other.getName()) && 
        this.getConsole().equalsIgnoreCase(other.getConsole());
    }
}