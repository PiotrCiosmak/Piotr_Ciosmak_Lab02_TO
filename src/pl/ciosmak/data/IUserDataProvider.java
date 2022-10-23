package pl.ciosmak.data;

import java.util.ArrayList;

public interface IUserDataProvider
{
    public void initialize();

    public ArrayList<String> prepareDate();
}