package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.data.FileDataProvider;
import pl.ciosmak.sections.Section;

import java.util.ArrayList;

public class PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility extends Section
{
    public PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility(final String parameters)
    {
        loadTablesFromFile();//TODO usunac
        char tmpPrecipitationGroupIndex = parameters.charAt(0);
        switch (tmpPrecipitationGroupIndex)
        {
            case '0' -> precipitationGroupIndex = "grupa opadowa w sekcji 1 i 3";
            case '1' -> precipitationGroupIndex = "grupa opadowa tylko w sekcji 1";
            case '2' -> precipitationGroupIndex = "grupa opadowa tylko w sekcji 3";
            case '3' -> precipitationGroupIndex = "opady nie wystąpiły";
            case '4' -> precipitationGroupIndex = "nie wykonywano pomiarów opadu";
            default -> precipitationGroupIndex = "BLĄD PRZY WCZYTYWANIU";
        }

        char tmpStationType = parameters.charAt(1);
        switch (tmpStationType)
        {
            case '1', '2', '3' -> stationType = "stacja nieautomatyczna";
            case '4', '5', '6', '7' -> stationType = "stacja automatyczna";
            default -> stationType = "BLĄD PRZY WCZYTYWANIU";
        }

        char tmpRelativeHeightOfTheBaseOfTheLowestClouds = parameters.charAt(2);
        switch (tmpRelativeHeightOfTheBaseOfTheLowestClouds)
        {
            case '0' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 0 do 50 m";
            case '1' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 50 do 100 m";
            case '2' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 100 do 200 m";
            case '3' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 200 do 300 m";
            case '4' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 300 do 600 m";
            case '5' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 600 do 1000 m";
            case '6' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 1000 do 1500 m";
            case '7' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 1500 do 2000 m";
            case '8' -> relativeHeightOfTheBaseOfTheLowestClouds = "od 2000 do 2500 m";
            case '9' -> relativeHeightOfTheBaseOfTheLowestClouds = "powyżej 2500 m lub brak chmur";
            case '/' -> relativeHeightOfTheBaseOfTheLowestClouds = "wysokość podstawy chmur nieznana";
            default -> relativeHeightOfTheBaseOfTheLowestClouds = "BLĄD PRZY WCZYTYWANIU";
        }

        String tmpVisibilityInTheHorizontalDirection = parameters.substring(3, 5);
        for (var array : tableOfVisibilityInTheHorizontalDirection)
        {
            if (array.get(0).equals(tmpVisibilityInTheHorizontalDirection))
            {
                visibilityInTheHorizontalDirection = array.get(1);
                if (Integer.parseInt(array.get(0)) < 90)
                {
                    measurementMadeOn = "na lądzie";
                }
                else
                {
                    measurementMadeOn = "na morzu";
                }
                break;
            }
        }
    }

    @Override
    public void show()
    {
        System.out.println("Wskaźnik grupy opadowej: " + precipitationGroupIndex);
        System.out.println("Typ stacji: " + stationType);
        System.out.println("Wysokość względna podstawy najniższych chmur: " + relativeHeightOfTheBaseOfTheLowestClouds);
        System.out.println("Widzialność w kierunku poziomym na " + measurementMadeOn + ": " + visibilityInTheHorizontalDirection + " km");
    }

    //TODO wrzucic do jakiejs funkcji która wczyta to i inne podobne odrazu po starcie programu
    private static void loadTablesFromFile()
    {
        tableOfVisibilityInTheHorizontalDirection = new ArrayList<>();
        tableOfVisibilityInTheHorizontalDirection = FileDataProvider.readFromInputStream("files/visibilityInTheHorizontalDirection.txt");
    }

    private final String precipitationGroupIndex;
    private final String stationType;
    private final String relativeHeightOfTheBaseOfTheLowestClouds;
    private String measurementMadeOn;
    private String visibilityInTheHorizontalDirection;
    private static ArrayList<ArrayList<String>> tableOfVisibilityInTheHorizontalDirection;
}