package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class AtmosphericPressureAtTheStationLevel extends Section
{
    public AtmosphericPressureAtTheStationLevel(final String parameters)
    {
        double tmpAtmosphericPressureAtTheStationLevel = Double.parseDouble(parameters.substring(1));
        if (tmpAtmosphericPressureAtTheStationLevel < 1000)
        {
            tmpAtmosphericPressureAtTheStationLevel += 10000;
        }
        tmpAtmosphericPressureAtTheStationLevel /= 10;
        atmosphericPressureAtTheStationLevel = replacePeriodWithComma(new StringBuilder(Double.toString(tmpAtmosphericPressureAtTheStationLevel)));
    }

    @Override
    public void show()
    {
        System.out.println("Ciśnienie atmosferyczne na poziomie stacji: " + atmosphericPressureAtTheStationLevel + " hPa");
    }

    private String replacePeriodWithComma(StringBuilder text)
    {
        int indexOfPeriod = text.indexOf(".");
        text.replace(indexOfPeriod, indexOfPeriod + 1, ",");
        return text.toString();
    }

    private final String atmosphericPressureAtTheStationLevel;
}