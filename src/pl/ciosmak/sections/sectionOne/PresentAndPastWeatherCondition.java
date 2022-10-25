package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.data.FileDataProvider;
import pl.ciosmak.sections.Section;

import java.util.ArrayList;

public class PresentAndPastWeatherCondition extends Section
{
    public PresentAndPastWeatherCondition(final String parameters, final String stationType)
    {
        boolean parametersExists = checkIfParametersExists(parameters);
        if (!parametersExists)
            return;

        if (stationType.equals("stacja nieautomatyczna"))
        {
            String tmpPresentWeather = parameters.substring(1, 3);
            for (var array : tableOfPresentWeatherNonAutomatic)
            {
                if (array.get(0).equals(tmpPresentWeather))
                {
                    presentWeather = array.get(1);
                    break;
                }
            }

            String tmpPastWeather = parameters.substring(3, 5);
            char tmpPartOfPastWeather;
            pastWeather = "";
            for (int i = 0; i < 2; ++i)
            {
                tmpPartOfPastWeather = tmpPastWeather.charAt(i);
                switch (tmpPartOfPastWeather)
                {
                    case '0' -> pastWeather = pastWeather.concat("chmury pokrywały połowę lub mniej niż połowę nieba w ciągu branego pod uwagę okresu");
                    case '1' -> pastWeather = pastWeather.concat("chmury pokrywały ponad połowę nieba przez część okresu i mniej niż połowę przez pozostałą część okresu");
                    case '2' -> pastWeather = pastWeather.concat("chmury pokrywały ponad połowę nieba w ciągu branego pod uwagę okresu");
                    case '3' -> pastWeather = pastWeather.concat("wichura pyłowa, wichura piaskowa lub zamieć śnieżna wysoka");
                    case '4' -> pastWeather = pastWeather.concat("mgła, mgła lodowa lub gęste zmętnienie (widzialność poniżej 1000 m)");
                    case '5' -> pastWeather = pastWeather.concat("mżawka");
                    case '6' -> pastWeather = pastWeather.concat("deszcz ciągły");
                    case '7' -> pastWeather = pastWeather.concat("śnieg lub śnieg z deszczem lub ziarna lodowe");
                    case '8' -> pastWeather = pastWeather.concat("opady przelotne");
                    case '9' -> pastWeather = pastWeather.concat("burza z opadem lub bez opadu");
                    case '/' -> pastWeather = pastWeather.concat("brak danych");
                    default -> pastWeather = "BLĄD PRZY WCZYTYWANIU";
                }
                if (i == 0)
                {
                    pastWeather = pastWeather.concat(" oraz ");
                }
            }
        }
        else if (stationType.equals("stacja automatyczna"))
        {
            String tmpPresentWeather = parameters.substring(1, 3);
            for (var array : tableOfPresentWeatherAutomatic)
            {
                if (array.get(0).equals(tmpPresentWeather))
                {
                    presentWeather = array.get(1);
                    break;
                }
            }

            String tmpPastWeather = parameters.substring(3, 5);
            char tmpPartOfPastWeather;
            pastWeather = "";
            for (int i = 0; i < 2; ++i)
            {
                tmpPartOfPastWeather = tmpPastWeather.charAt(i);
                switch (tmpPartOfPastWeather)
                {
                    case '0' -> pastWeather = pastWeather.concat("bez istotnych zjawisk atmosferycznych");
                    case '1' -> pastWeather = pastWeather.concat("OGRANICZONA WIDZIALNOŚĆ");
                    case '2' -> pastWeather = pastWeather.concat("zamieć lub wichura piaskowa, ograniczona widzialność");
                    case '3' -> pastWeather = pastWeather.concat("MGŁA");
                    case '4' -> pastWeather = pastWeather.concat("OPAD");
                    case '5' -> pastWeather = pastWeather.concat("mżawka");
                    case '6' -> pastWeather = pastWeather.concat("deszcz");
                    case '7' -> pastWeather = pastWeather.concat("śnieg lub krupa śnieżna albo lodowa");
                    case '8' -> pastWeather = pastWeather.concat("opad przelotny lub opad z przerwami");
                    case '9' -> pastWeather = pastWeather.concat("burza");
                    default -> pastWeather = "BLĄD PRZY WCZYTYWANIU";
                }
                if (i == 0)
                {
                    pastWeather = pastWeather.concat(" oraz ");
                }
            }
        }
        else
        {
            System.err.println("Błedny typ stacji.\nOpuszczanie programu");
            System.exit(1);
        }
    }

    @Override
    public void show()
    {
        if (!checkIfVariablesAreNotEmpty())
            return;
        System.out.println("Pogoda bieżąca: " + presentWeather);
        System.out.println("Pogoda ubiegla: " + pastWeather);
    }

    public static void loadTablesFromFile()
    {
        tableOfPresentWeatherNonAutomatic = new ArrayList<>();
        tableOfPresentWeatherNonAutomatic = FileDataProvider.readFromInputStream("files/presentWeatherNonAutomatic.txt");

        tableOfPresentWeatherAutomatic = new ArrayList<>();
        tableOfPresentWeatherAutomatic = FileDataProvider.readFromInputStream("files/presentWeatherAutomatic.txt");
    }

    private boolean checkIfParametersExists(final String parameters)
    {
        if (parameters.length() == 0)
        {
            presentWeather = "";
            pastWeather = "";
            return false;
        }
        return true;
    }

    private boolean checkIfVariablesAreNotEmpty()
    {
        return presentWeather.length() != 0 || pastWeather.length() != 0;
    }

    private String presentWeather;
    private String pastWeather;
    private static ArrayList<ArrayList<String>> tableOfPresentWeatherNonAutomatic;
    private static ArrayList<ArrayList<String>> tableOfPresentWeatherAutomatic;
}