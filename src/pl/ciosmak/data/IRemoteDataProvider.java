package pl.ciosmak.data;

public interface IRemoteDataProvider
{
    void initialize();

    String getData();
}