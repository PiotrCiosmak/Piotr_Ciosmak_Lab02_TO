package pl.ciosmak.sections.sectionZero;

import pl.ciosmak.sections.Section;

public class Date extends Section
{
    public Date(final String year, final String month, final String day, final String hour, final String minute)
    {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public void show()
    {
        System.out.println("Data: " + year + '-' + month + '-' + day + ' ' + hour + ":" + minute);
    }

    private final String year;
    private final String month;
    private final String day;
    private final String hour;
    private final String minute;
}