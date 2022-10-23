package pl.ciosmak.data;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider
{
    public static ArrayList<String> splitData(String data)
    {
        String[] tmpListOfLines = data.split("\n");
        ArrayList<String> listOfLines = new ArrayList<String>(Arrays.asList(tmpListOfLines));
        return listOfLines;
    }
}
