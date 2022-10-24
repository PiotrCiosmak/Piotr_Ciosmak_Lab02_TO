package pl.ciosmak;

import pl.ciosmak.data.RemoteDataProvider;
import pl.ciosmak.extractor.Extractor;
import pl.ciosmak.sections.Section;
import pl.ciosmak.sections.sectionOne.PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility;
import pl.ciosmak.sections.sectionZero.Date;
import pl.ciosmak.sections.sectionZero.StationID;
import pl.ciosmak.sections.sectionZero.StationTypeID;
import pl.ciosmak.sections.sectionZero.WindIndex;

import java.util.ArrayList;

import static pl.ciosmak.data.DataProvider.splitData;

public class Main
{
    public static void main(String[] args)
    {
        RemoteDataProvider remoteDataProvider = new RemoteDataProvider();
        remoteDataProvider.initialize();
        ArrayList<String> linesOfData = splitData(remoteDataProvider.getData());
        ArrayList<Section> listOfSection = new ArrayList<>();
        for (var line : linesOfData)
        {
            Extractor extractor = new Extractor(line);
            if (!extractor.getStationTypeID().equals("AAXX"))
                continue;
            listOfSection.add(new StationID(extractor.getStationID()));
            listOfSection.add(new Date(extractor.getYear(), extractor.getMonth(), extractor.getDay(), extractor.getHour(), extractor.getMinute()));
            listOfSection.add(new StationTypeID(extractor.getStationTypeID()));
            listOfSection.add(new WindIndex(extractor.getTimeOfObservationAndWindIndex()));
            listOfSection.add(new PrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility(extractor.getPrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility()));
        }
    }
}
