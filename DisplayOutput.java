import java.util.*;
public class DisplayOutput implements Output
{
    CityNode everything;

    public void doOutput(String getOutput, CityNode inEverything)
    {
        everything = inEverything;
        everything.displayTree("");
        
    }
}
