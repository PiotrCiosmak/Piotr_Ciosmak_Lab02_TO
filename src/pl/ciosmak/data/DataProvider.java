package pl.ciosmak.data;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider
{
    public static ArrayList<String> splitData(final String data)
    {
        String[] tmpListOfLines = data.split("\n");
        return new ArrayList<>(Arrays.asList(tmpListOfLines));
    }
}