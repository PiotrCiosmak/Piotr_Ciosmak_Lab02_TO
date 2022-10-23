package pl.ciosmak.sections.sectionZero;

import pl.ciosmak.sections.Section;

public class WindIndex extends Section
{
    public WindIndex(String parametrs)
    {
        char tmp = parametrs.charAt(4);
        switch (tmp)
        {
            case '0':
                windIndex = "predkosc wiatru oszacowano w m/s";
                break;
            case '1':
                windIndex = "predkosc wiatru zmierzono anemometrem w m/s";
                break;
            case '3':
                windIndex = "predkosc wiatru oszacowano w wezłach";
                break;
            case '4':
                windIndex = "predkosc wiatru zmierzono anemometrem w wezłach";
                break;
            default:
                windIndex = "BLEDNE";
        }
    }

    @Override
    public void show()
    {
        System.out.println("Wskaznik wiatru: " + windIndex);
    }

    private String windIndex;
}
