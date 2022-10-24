package pl.ciosmak.sections;

import pl.ciosmak.sections.sectionOne.AmountOfGeneralCloudCoverAndWindData;
import pl.ciosmak.sections.sectionOne.PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility;

public class LoadDataFromFile
{
    public static void load()
    {
        PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility.loadTablesFromFile();
        AmountOfGeneralCloudCoverAndWindData.loadTablesFromFile();
        //dopisac reszte klas które korzystaja z plików z files
    }
}
