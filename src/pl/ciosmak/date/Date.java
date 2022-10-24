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
    public void initialize(final String label)
    {
        System.out.println(label.toUpperCase());

        try
        {
            System.out.println("Podaj dzień:");
            day = scanner.nextInt();
        }
        catch (Exception ex)
        {
            incorrectDataEntered("dzień");
        }


        try
        {
            System.out.println("Podaj miesiąc:");
            month = scanner.nextInt();
        }
        catch (Exception ex)
        {
            incorrectDataEntered("miesiąc");
        }

        try
        {
            System.out.println("Podaj rok:");
            year = scanner.nextInt();
        }
        catch (Exception ex)
        {
            incorrectDataEntered("rok");
        }

        try
        {
            System.out.println("Podaj godzine:");
            hour = scanner.nextInt();
        }
        catch (Exception ex)
        {
            incorrectDataEntered("godzinę");
        }

        try
        {
            System.out.println("Podaj minute:");
            minute = scanner.nextInt();
        }
        catch (Exception ex)
        {
            incorrectDataEntered("minutę");

        }
        if (!checkDate())
        {
            System.err.println("Wprowadzona błędną datę.");
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

    private void incorrectDataEntered(final String label)
    {
        System.err.println("Wprowadzono błędny " + label.toLowerCase() + ".");
        scanner = new Scanner(System.in);
        initialize(label);
    }

    private boolean checkDate()
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentDay = Calendar.getInstance().get(Calendar.DATE);
        if (year < currentYear - 1 || year > currentYear)
        {
            return false;
        }

        if (month < 1 || month > 12)
        {
            return false;
        }

        if (year == currentYear && month > currentMonth)
        {
            return false;
        }

        if (year == currentYear - 1 && month < currentMonth)
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

        if (year == currentYear && month == currentYear && day > currentDay)
        {
            return false;
        }

        if (year == currentYear - 1 && month == currentMonth && day < currentDay)
        {
            return false;
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

    private Scanner scanner = new Scanner(System.in);
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
}