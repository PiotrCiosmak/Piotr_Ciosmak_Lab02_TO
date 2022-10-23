package pl.ciosmak.data;

import pl.ciosmak.date.Date;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class RemoteDataProvider implements IRemoteDataProvider
{
    public RemoteDataProvider()
    {
    }

    @Override
    public void initialize()
    {
        UserDataProvider userDataProvider = new UserDataProvider();
        userDataProvider.initialize();
        ArrayList<String> listOfDate = userDataProvider.prepareDate();
        prepareLink(listOfDate);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).GET().build();
        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getData()
    {
        return response.body();
    }

    private void prepareLink(ArrayList<String> listOfDate)
    {
        link = "https://www.ogimet.com/cgi-bin/getsynop?begin=" + listOfDate.get(0) + "&end=" + listOfDate.get(1) + "&state=Pol";
    }

    private HttpResponse<String> response;
    private String link;
}