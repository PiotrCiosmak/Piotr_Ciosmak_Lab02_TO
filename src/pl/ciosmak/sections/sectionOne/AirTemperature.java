package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class AirTemperature extends Section
{
    public AirTemperature(final String parameters)
    {
        int tmpTemperatureValueIndicator = Character.getNumericValue(parameters.charAt(1));
        if (tmpTemperatureValueIndicator == 1)
        {
            temperatureValueIndicator = "dodatnia";
        }
        else
        {
            temperatureValueIndicator = "ujemna";
        }

        airTemperatureInTenthsOfDegreesCelsiusWithoutCommas = Integer.parseInt(parameters.substring(2, 4)) + "," + parameters.charAt(4);
    }

    @Override
    public void show()
    {
        System.out.println("Wskaźnik wartości temperatury: " + temperatureValueIndicator);
        System.out.println("Temperatura powietrza w stopniach Celsjusza: " + airTemperatureInTenthsOfDegreesCelsiusWithoutCommas);
    }

    private final String temperatureValueIndicator;
    private final String airTemperatureInTenthsOfDegreesCelsiusWithoutCommas;
}