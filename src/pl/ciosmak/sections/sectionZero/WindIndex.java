package pl.ciosmak.sections.sectionZero;

import pl.ciosmak.sections.Section;

public class WindIndex extends Section
{
    public WindIndex(final String parameters)
    {
        char tmpWindIndex = parameters.charAt(4);
        switch (tmpWindIndex)
        {
            case '0' -> windIndex = "prędkość wiatru oszacowano w m/s";
            case '1' -> windIndex = "prędkość wiatru zmierzono anemometrem w m/s";
            case '3' -> windIndex = "prędkość wiatru oszacowano w węzłach";
            case '4' -> windIndex = "prędkość wiatru zmierzono anemometrem w węzłach";
            default -> windIndex = "BLĄD PRZY WCZYTYWANIU";
        }
    }

    @Override
    public void show()
    {
        System.out.println("Wskaznik wiatru: " + windIndex);
    }

    private final String windIndex;
}
