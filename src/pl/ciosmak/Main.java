package pl.ciosmak;

import pl.ciosmak.data.RemoteDataProvider;
import pl.ciosmak.extractor.Extractor;

import java.util.ArrayList;

import static pl.ciosmak.data.DataProvider.splitData;

public class Main
{
    public static void main(String[] args)
    {
        RemoteDataProvider remoteDataProvider = new RemoteDataProvider();
        remoteDataProvider.initialize();
        ArrayList<String> linesOfData = splitData(remoteDataProvider.getData());
        int licznik = 0;
        for (var line : linesOfData)
        {
            Extractor extractor = new Extractor(line);
            licznik++;
            System.out.println(licznik);
            if (!extractor.getStationTypeID().equals("AAXX"))
            {
                continue;
            }

        }
    }
}
