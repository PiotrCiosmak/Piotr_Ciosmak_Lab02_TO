package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.data.FileDataProvider;
import pl.ciosmak.sections.Section;

import java.util.ArrayList;

public class Clouds extends Section
{
    public Clouds(final String parameters)
    {
        boolean parametersExists = checkIfParametersExists(parameters);
        if (!parametersExists)
            return;
        amountOfCloudCover = String.valueOf(parameters.charAt(1));

        String tmpStratocumulusClouds = String.valueOf(parameters.charAt(2));
        for (var array : tableOfStratocumulusClouds)
        {
            if (array.get(0).equals(tmpStratocumulusClouds))
            {
                stratocumulusClouds = array.get(1);
                break;
            }
        }

        String tmpAltocumulusClouds = String.valueOf(parameters.charAt(3));
        for (var array : tableOfAltocumulusClouds)
        {
            if (array.get(0).equals(tmpAltocumulusClouds))
            {
                altocumulusClouds = array.get(1);
                break;
            }
        }

        String tmpCirrusClouds = String.valueOf(parameters.charAt(4));
        for (var array : tableOfCirrusClouds)
        {
            if (array.get(0).equals(tmpCirrusClouds))
            {
                cirrusClouds = array.get(1);
                break;
            }
        }
    }

    @Override
    public void show()
    {
        if (!checkIfVariablesAreNotEmpty())
        {
            return;
        }
        System.out.println("Wielkosc zachmurzenia: " + amountOfCloudCover);
        System.out.println("Chmury Stratocumulus: " + stratocumulusClouds);
        System.out.println("Chmury Altocumulus: " + altocumulusClouds);
        System.out.println("Chmury Cirrus: " + cirrusClouds);
    }

    public static void loadTablesFromFile()
    {
        tableOfStratocumulusClouds = new ArrayList<>();
        tableOfStratocumulusClouds = FileDataProvider.readFromInputStream("files/stratocumulusClouds.txt");

        tableOfAltocumulusClouds = new ArrayList<>();
        tableOfAltocumulusClouds = FileDataProvider.readFromInputStream("files/altocumulusClouds.txt");

        tableOfCirrusClouds = new ArrayList<>();
        tableOfCirrusClouds = FileDataProvider.readFromInputStream("files/cirrusClouds.txt");
    }

    private boolean checkIfParametersExists(final String parameters)
    {
        if (parameters.length() == 0)
        {
            amountOfCloudCover = "";
            stratocumulusClouds = "";
            altocumulusClouds = "";
            cirrusClouds = "";
            return false;
        }
        return true;
    }

    private boolean checkIfVariablesAreNotEmpty()
    {
        return amountOfCloudCover.length() != 0 || stratocumulusClouds.length() != 0 || altocumulusClouds.length() != 0 || cirrusClouds.length() != 0;
    }

    private String amountOfCloudCover;
    private String stratocumulusClouds;
    private String altocumulusClouds;
    private String cirrusClouds;
    private static ArrayList<ArrayList<String>> tableOfStratocumulusClouds;
    private static ArrayList<ArrayList<String>> tableOfAltocumulusClouds;
    private static ArrayList<ArrayList<String>> tableOfCirrusClouds;

}
