package pl.ciosmak.data;

import java.util.ArrayList;

public interface IUserDataProvider
{
    void initialize();

    ArrayList<String> prepareDate();
}