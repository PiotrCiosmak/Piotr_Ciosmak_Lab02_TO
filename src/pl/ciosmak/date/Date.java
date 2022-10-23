package pl.ciosmak.date;

import java.util.Calendar;
import java.util.Scanner;

public class Date implements IDate
{
    public Date()
    {
        day = 0;
        month = 0;
        year = 0;
        hour = 0;
        minute = 0;
    }

    @Override
    public void initialize(String label)
    {
        label.toUpperCase();
        System.out.println(label);

        try
        {
            System.out.println("Podaj dzień:");
            day = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadzono błędny dzień!!!");
            initialize(label);
        }


        try
        {
            System.out.println("Podaj miesiąc:");
            month = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadzono błędny miesiąc!!!");
            initialize(label);
        }

        try
        {
            System.out.println("Podaj rok:");
            year = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadzono błędny rok!!!");
            initialize(label);
        }

        try
        {
            System.out.println("Podaj godzine:");
            hour = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadzono błędną godzinę!!!");
            initialize(label);
        }

        try
        {
            System.out.println("Podaj minute:");
            minute = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Wprowadzono błędną minutę!!!");
            initialize(label);
        }
        if (!checkDate())
        {
            initialize(label);
        }
    }

    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    private boolean checkDate()
    {
        if (year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR))
        {
            return false;
        }

        if (month < 1 || month > 12)
        {
            return false;
        }

        if (day < 1)
        {
            return false;
        }

        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31)
                {
                    return false;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30)
                {
                    return false;
                }
                break;

            case 2:
                if (year % 4 == 0)
                {
                    if (day > 29)
                    {
                        return false;
                    }
                }
                else
                {
                    if (day > 28)
                    {
                        return false;
                    }
                }
                break;
        }

        if (hour < 0 || hour > 24)
        {
            return false;
        }
        if (minute < 0 || minute > 60)
        {
            return false;
        }
        return true;
    }

    private final Scanner scanner = new Scanner(System.in);
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
}