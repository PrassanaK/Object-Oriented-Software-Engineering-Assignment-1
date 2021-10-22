import java.util.*;
import java.io.*;
public class WriteOutput implements Output
{
    public void doOutput(String getOutput, CityNode everything)//getOutput is the filename
    {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(getOutput);
            pw = new PrintWriter(fileStrm);
            everything.write(pw);
            pw.close();
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
}
