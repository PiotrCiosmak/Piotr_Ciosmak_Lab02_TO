package pl.ciosmak.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDataProvider
{
    //dodać interfejs
    public static ArrayList<ArrayList<String>> readFromInputStream(String pathToFile)
    {
        var table = new ArrayList<ArrayList<String>>();
        try
        {
            File file = new File(pathToFile);
            Scanner fileReader = new Scanner(file);
            String line;
            int indexOfSplitSign;
            while (fileReader.hasNextLine())
            {
                var tmpArray = new ArrayList<String>();
                line = fileReader.nextLine();
                indexOfSplitSign = line.indexOf('-');
                tmpArray.add(line.substring(0, indexOfSplitSign));
                tmpArray.add(line.substring(indexOfSplitSign + 1));
                table.add(tmpArray);
            }
            fileReader.close();
        }
        catch (final FileNotFoundException ex)
        {
            System.err.println("Błąd związany z czytaniem z pliku");
            ex.printStackTrace();
        }
        return table;
    }
}
