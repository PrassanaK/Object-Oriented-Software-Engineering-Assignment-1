import java.util.*;
import java.io.*;
public abstract class CityNode
{
    public void add(CityNode newNode)
    {
        throw new UnsupportedOperationException();
    }
    
    public void remove(CityNode newNode)
    {
        throw new UnsupportedOperationException();
    }
    
    public CityNode getCityNode(int index)
    {
        throw new UnsupportedOperationException();
    }
    
    public abstract String getLabel();
    
    public abstract CityNode find(String name);

    public abstract void write(PrintWriter pw);

    public abstract String getParent();
  
    public abstract void displayTree(String indent);
    
    public void displayCityInfo()
    {
        throw new UnsupportedOperationException();
    }
    
    /*public ArrayList<String> getCategories()
    {
        throw new UnsupportedOperationException;
    }
    
    public ArrayList<String> getPowerVals()
    {
        throw new UnsupportedOperationException;
    }*/
}
