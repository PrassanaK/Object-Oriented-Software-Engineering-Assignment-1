import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        String option1 = args[0]; 
        CityNode rootNode = null;
        Input readInput = null;

        if(args[0].equals("-r")&&((args[1].equals("-g"))||(args[1].equals("-d"))||(args[1].equals("-w"))))
        {
            System.out.println("No Filename found");
        }
        else
        {
            switch(option1)
            {
                case "-r":
                    String filename = args[1];
                    readInput = new ReadInput();
                    readInput.getInput(filename);
                    rootNode = readInput.getNode(); 
                    break;
                case "-g":
                    System.out.println("Generate Tree");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        if(args[0].equals("-g")&&((args[1].equals("-d"))||(args[1].equals("-w"))))
        {
            System.out.println("Generate option is valid");
        }

        String option2 = args[2];

        if(args[2].equals("-w")&&(args[3]==null))
        {
            System.out.println("No output filename");
        }
        else
        {
            switch(option2)
            {
                case "-w":
                    Output writeOutput = new WriteOutput();
                    writeOutput.doOutput("Output.csv", readInput.getNode());
                    break;
                case "-d":
                    Output display = new DisplayOutput();
                    display.doOutput("", readInput.getNode());
                    break;
                default:
                    System.out.println("Invalid option");
             }
        }
    }
}
