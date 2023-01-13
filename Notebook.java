public class Notebook 
{
    private String nbName;
    private int screenSizeInch;
    private int ramSize;
    private int diskSize;
    private String os;
    private String color;

    public Notebook(String nbName, int screenSizeInch, int ramSize, int diskSize, String os, String color) 
    {
        this.nbName = nbName;
        this.screenSizeInch = screenSizeInch;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.os = os;
        this.color = color;
    }

    public String getNbName() 
    {
        return nbName;
    }

    public int getScreenSizeInch() 
    {
        return screenSizeInch;
    }

    public int getRamSize() 
    {
        return ramSize;
    }

    public int getDiskSize() 
    {
        return diskSize;
    }

    public String getOs() 
    {
        return os;
    }

    public String getColor() 
    {
        return color;
    }
}