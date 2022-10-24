package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class AtmosphericPressureAtSeaLevel extends Section
{
    public AtmosphericPressureAtSeaLevel(final String parameters)
    {
        int tmpAtmosphericPressureAtSeaLevel = Integer.parseInt(parameters.substring(1));
        if (tmpAtmosphericPressureAtSeaLevel < 1000)
        {
            tmpAtmosphericPressureAtSeaLevel += 10000;
        }
        tmpAtmosphericPressureAtSeaLevel /= 10;
        atmosphericPressureAtSeaLevel = Integer.toString(tmpAtmosphericPressureAtSeaLevel);
    }

    @Override
    public void show()
    {
        System.out.println("Ciśnienie atmosferyczne na poziomie stacji: " + atmosphericPressureAtSeaLevel + " hPa");
    }

    private final String atmosphericPressureAtSeaLevel;
}
