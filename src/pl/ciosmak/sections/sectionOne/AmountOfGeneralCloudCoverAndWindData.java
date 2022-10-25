package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.data.FileDataProvider;
import pl.ciosmak.sections.Section;

import java.util.ArrayList;

public class AmountOfGeneralCloudCoverAndWindData extends Section
{
    public AmountOfGeneralCloudCoverAndWindData(final String parameters)
    {
        char tmpAmountOfGeneralCloudiness = parameters.charAt(0);
        switch (tmpAmountOfGeneralCloudiness)
        {
            case '0' -> amountOfGeneralCloudiness = "0 (niebo bezchmurne)";
            case '1' -> amountOfGeneralCloudiness = "1/8 lub mniej lecz nie 0";
            case '2' -> amountOfGeneralCloudiness = "2/8";
            case '3' -> amountOfGeneralCloudiness = "3/8";
            case '4' -> amountOfGeneralCloudiness = "4/8";
            case '5' -> amountOfGeneralCloudiness = "5/8";
            case '6' -> amountOfGeneralCloudiness = "6/8";
            case '7' -> amountOfGeneralCloudiness = "7/8";
            case '8' -> amountOfGeneralCloudiness = "8/8";
            case '9' -> amountOfGeneralCloudiness = "niebo niewidoczne (zasłonięte mgłą lub innymi zjawiskami meteorologicznymi)";
            case '/' -> amountOfGeneralCloudiness = "chmury niewidoczne z powodów innych niż mgła czy inne zjawiska meteorologiczne lub nie prowadzi się obserwacji";
            default -> amountOfGeneralCloudiness = "BLĄD PRZY WCZYTYWANIU";
        }

        String tmpAverageWindDirectionFrom10Minutes = parameters.substring(1, 3);
        for (var array : tableOfAverageWindDirectionFrom10Minutes)
        {
            if (array.get(0).equals(tmpAverageWindDirectionFrom10Minutes))
            {
                averageWindDirectionFrom10Minutes = array.get(1);
                break;
            }
        }

        averageWindSpeedExpressedInKnotsFrom10Minutes = parameters.substring(3, 5);
    }

    @Override
    public void show()
    {
        System.out.println("Wielkość zachmurzenia ogólnego: " + amountOfGeneralCloudiness);
        System.out.println("Średni (z 10 minut) kierunek wiatru rzeczywistego: " + averageWindDirectionFrom10Minutes);
        System.out.println("Prędkość wiatru rzeczywistego wyrażona w węzłach (średnia 10-minutowa): " + averageWindSpeedExpressedInKnotsFrom10Minutes);

    }

    public static void loadTablesFromFile()
    {
        tableOfAverageWindDirectionFrom10Minutes = new ArrayList<>();
        tableOfAverageWindDirectionFrom10Minutes = FileDataProvider.readFromInputStream("files/averageWindDirectionFrom10Minutes.txt");
    }


    private final String amountOfGeneralCloudiness;
    private String averageWindDirectionFrom10Minutes;
    private final String averageWindSpeedExpressedInKnotsFrom10Minutes;
    private static ArrayList<ArrayList<String>> tableOfAverageWindDirectionFrom10Minutes;
}