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

        presentWeatherOnly = (parameters.charAt(1) != '/');
        if (stationType.equals("stacja nieautomatyczna"))
        {
            if (presentWeatherOnly)//nie auto terazniejsza
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
            }
            else//nie auto ubiegła
            {
                String tmpPastWeather = parameters.substring(3, 5);
                char tmpPartOfPastWeather;
                pastWeather = "";
                for (int i = 0; i < 2; ++i)
                {
                    tmpPartOfPastWeather = tmpPastWeather.charAt(i);
                    switch (tmpPartOfPastWeather)
                    {
                        case '0' -> pastWeather = "chmury pokrywały połowę lub mniej niż połowę nieba w ciągu branego pod uwagę okresu";
                        case '1' -> pastWeather = "chmury pokrywały ponad połowę nieba przez część okresu i mniej niż połowę przez pozostałą część okresu";
                        case '2' -> pastWeather = "chmury pokrywały ponad połowę nieba w ciągu branego pod uwagę okresu";
                        case '3' -> pastWeather = "wichura pyłowa, wichura piaskowa lub zamieć śnieżna wysoka";
                        case '4' -> pastWeather = "mgła, mgła lodowa lub gęste zmętnienie (widzialność poniżej 1000 m)";
                        case '5' -> pastWeather = "mżawka";
                        case '6' -> pastWeather = "deszcz ciągły";
                        case '7' -> pastWeather = "śnieg lub śnieg z deszczem lub ziarna lodowe";
                        case '8' -> pastWeather = "opady przelotne";
                        case '9' -> pastWeather = "burza z opadem lub bez opadu";
                        case '/' -> pastWeather = "brak danych";
                        default -> pastWeather = "BLĄD PRZY WCZYTYWANIU";
                    }
                    if (i == 0)
                    {
                        pastWeather += " oraz ";
                    }
                }
            }
        }
        else if (stationType.equals("stacja automatyczna"))
        {
            if (presentWeatherOnly)//auto terazniszja
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
            }
            else//auto ubiegła
            {
                String tmpPastWeather = parameters.substring(3, 5);
                char tmpPartOfPastWeather;
                pastWeather = "";
                for (int i = 0; i < 2; ++i)
                {
                    tmpPartOfPastWeather = tmpPastWeather.charAt(i);
                    switch (tmpPartOfPastWeather)
                    {
                        case '0' -> pastWeather = "bez istotnych zjawisk atmosferycznych";
                        case '1' -> pastWeather = "OGRANICZONA WIDZIALNOŚĆ";
                        case '2' -> pastWeather = "zamieć lub wichura piaskowa, ograniczona widzialność";
                        case '3' -> pastWeather = "MGŁA";
                        case '4' -> pastWeather = "OPAD";
                        case '5' -> pastWeather = "mżawka";
                        case '6' -> pastWeather = "deszcz";
                        case '7' -> pastWeather = "śnieg lub krupa śnieżna albo lodowa";
                        case '8' -> pastWeather = "opad przelotny lub opad z przerwami";
                        case '9' -> pastWeather = "burza";
                        default -> pastWeather = "BLĄD PRZY WCZYTYWANIU";
                    }
                    if (i == 0)
                    {
                        pastWeather += " oraz ";
                    }
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
        {
            return;
        }
        if (presentWeatherOnly)
        {
            System.out.println("Pogoda bieżąca: " + presentWeather);
        }
        else
        {
            System.out.println("Pogoda ubiegla: " + pastWeather);
        }
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

    private boolean presentWeatherOnly;
    private String presentWeather;
    private String pastWeather;
    private static ArrayList<ArrayList<String>> tableOfPresentWeatherNonAutomatic;
    private static ArrayList<ArrayList<String>> tableOfPresentWeatherAutomatic;

}