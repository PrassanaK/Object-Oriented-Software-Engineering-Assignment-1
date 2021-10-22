import java.util.*;
import java.io.*;
public class ReadInput implements Input
{
    CityNode node = null;

    public ReadInput()
    {
        node = new CityPart("","");
    }

    public void getInput(String input)//Read or Generate. String input is either Filename or depth
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        try
        {
            fileStrm = new FileInputStream(input);
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);
 
            line = bufRdr.readLine();//Reading first line
            CityNode rootNode = new CityPart(line, "");
            while (line != null)
            {
                line = bufRdr.readLine();
                if(line != null)
                {
                    String[] lineArray = line.split(",");
                    if(lineArray.length == 2)//If line is a non-root/non-leaf node
                    {
                        CityNode newNode = new CityPart(lineArray[0], lineArray[1]);//Create node with label
                        rootNode.find(lineArray[1]).add(newNode);
                    }
                    else if(lineArray.length > 2)//If line is a leaf node
                    {
                        ArrayList<String> categories = new ArrayList<String>();
                        ArrayList<Double> powerVals = new ArrayList<Double>();
                        for(int ii=2; ii<lineArray.length; ii++)
                        {
                            String[] catArray = lineArray[ii].split("=");
                            categories.add(catArray[0]);
                            powerVals.add(Double.parseDouble(catArray[1]));
                        }
                        CityNode newNode = new CityLeaf(lineArray[0], lineArray[1], categories, powerVals);
                        rootNode.find(lineArray[1]).add(newNode);                    
                    }
                }
                node = rootNode; 
            }
            fileStrm.close();
        }
        catch(IOException e)
        {
            if(fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch(IOException e2)
                {
                }
            }
        }
    }

    public CityNode getNode()
    {
        return node;
    }
    
}
