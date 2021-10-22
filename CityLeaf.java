import java.util.*;
import java.io.*;
public class CityLeaf extends CityNode
{
    private String label;
    private String parent;
    ArrayList<String> categories = new ArrayList<String>();
    ArrayList<Double> powerVals = new ArrayList<Double>();

    public CityLeaf(String inLabel, String inParent, ArrayList<String> inCat, ArrayList<Double> inPower)
    {
        label = inLabel;
        parent = inParent;
        categories = inCat;
        powerVals = inPower;
    }

    @Override
    public CityNode find(String name)
    {
        CityNode found = null; 
        if(this.label.equals(name))
        {
            found = this;
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

    public ArrayList<String> getCategories()
    {
        return categories;
    }

    public ArrayList<Double> getPowerVals()
    {
        return powerVals;
    }

    @Override
    public void write(PrintWriter pw)
    {

            pw.println(getLabel() + "," + getParent());
            
            for(int i = 0; i <categories.size(); i++)
            {
                pw.print(categories.get(i) + " = " + powerVals.get(i));
            }
            
    }

    public void displayTree(String indent)
    {
        System.out.print(indent);
        System.out.println(getLabel());
    }
}
