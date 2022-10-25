package pl.ciosmak.sections;

import pl.ciosmak.sections.sectionOne.AmountOfGeneralCloudCoverAndWindData;
import pl.ciosmak.sections.sectionOne.Clouds;
import pl.ciosmak.sections.sectionOne.PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility;
import pl.ciosmak.sections.sectionOne.PresentAndPastWeatherCondition;

public class LoadDataFromFile
{
    public static void load()
    {
        PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility.loadTablesFromFile();
        AmountOfGeneralCloudCoverAndWindData.loadTablesFromFile();
        PresentAndPastWeatherCondition.loadTablesFromFile();
        Clouds.loadTablesFromFile();
    }
}