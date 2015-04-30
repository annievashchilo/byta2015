package reader;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Dataset 
{	
    public List<String> fileContent;
    public final String pathToFile;

    public Dataset(String pathToFile)
    {
        this.pathToFile = pathToFile;
        fileContent = new ArrayList<String>();
        read();
    }

	public void read() 
    {
        fileContent.clear();

        try  
        {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile));
            Scanner scanner = new Scanner(br);
            while(scanner.hasNextLine()) 
            {
                fileContent.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) 
        {
            System.err.println("File not found");
        }
    }

    public void swapChars()
    {
        String newLine = null;
        for (int i = 0; i <= fileContent.size(); i += 2)
        {
            newLine = fileContent.get(i);
            int n_bytes = newLine.length();
            if (n_bytes > 1) {
                char[] chars = new char[n_bytes];
                newLine.getChars(0, n_bytes, chars, 0);

                char temp = chars[0];
                chars[0] = chars[n_bytes-1];
                chars[n_bytes-1] = temp;

                newLine = new String(chars);
                fileContent.set(i, newLine);
            }
        }
    }

}
