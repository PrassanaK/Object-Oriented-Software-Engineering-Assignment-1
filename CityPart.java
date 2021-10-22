import java.util.*;
import java.io.*;
//CityPart is the non-leaf tree node
public class CityPart extends CityNode
{
    //Contains any CityLeafs or CityParts that are 
    //added to this ArrayList
    ArrayList<CityNode> cityNodes = new ArrayList<CityNode>();
    private String indent;

    private String label;
    private String parent;

    public CityPart(String inLabel, String inParent)
    {
        label = inLabel;
        parent = inParent;
    }
    
    @Override
    public CityNode find(String name)//recursive method
    {
        CityNode found = null; 

        if(this.label.equals(name))
        {
            found = this;
        }
        else
        {

            for(CityNode node : cityNodes)
            {
                found = node.find(name);
                if(found != null)
                {
                    return found;
                }
            }
        }
        return found;
    }

    @Override
    public String getLabel()
    {
        return label;
    }
 
    @Override 
    public String getParent()
    {
        return parent;
    }     
  
    public void add(CityNode newNode)
    {
        cityNodes.add(newNode);
    }

    public void remove(CityNode newNode)
    {
        cityNodes.remove(newNode);
    }

    public CityNode getCityNode(int index)
    {
        return (CityNode)cityNodes.get(index);
    }

    public void displayCityInfo()
    {
        System.out.println(getLabel());        
    }

    @Override
    public void write(PrintWriter pw)
    {
        pw.println(getLabel() + "," + getParent());
        
        for(CityNode node : cityNodes)
        {
            node.write(pw);
        }
    }

    public void displayTree(String indent)
    {
        System.out.print(indent);
        System.out.println(getLabel());
 
        for(CityNode node : cityNodes)
        {
            String newIndent = indent + " ";
            node.displayTree(newIndent);
        }
    } 
}
