package pl.ciosmak.data;

import pl.ciosmak.date.Date;

import java.util.ArrayList;

public class UserDataProvider implements IUserDataProvider
{
    public UserDataProvider()
    {
        startData = new Date();
        endData = new Date();
    }

    @Override
    public void initialize()
    {
        startData.initialize("---DATA POCZĄTKOWA---");
        endData.initialize("---DATA KOŃCOWA---");
        checkOrderOfDates();
    }

    @Override
    public ArrayList<String> prepareDate()
    {
        var listOfDate = new ArrayList<String>();
        listOfDate.add(formatStringThatRepresentDate(startData));
        listOfDate.add(formatStringThatRepresentDate(endData));
        return listOfDate;
    }

    private void checkOrderOfDates()
    {
        boolean dateOrderChanged = false;
        if (startData.getYear() > endData.getYear())
        {
            dateOrderChanged = true;
        }
        else if (startData.getYear() == endData.getYear())
        {
            if (startData.getMonth() > endData.getMonth())
            {
                dateOrderChanged = true;
            }
            else if (startData.getMonth() == endData.getMonth())
            {
                if (startData.getDay() > endData.getDay())
                {
                    dateOrderChanged = true;
                }
                else if (startData.getDay() == endData.getDay())
                {
                    if (startData.getHour() > endData.getHour())
                    {
                        dateOrderChanged = true;
                    }
                    else if (startData.getHour() == endData.getHour())
                    {
                        if (startData.getMonth() >= endData.getMinute())
                        {
                            dateOrderChanged = true;
                        }
                    }
                }
            }
        }

        if (dateOrderChanged)
        {
            Date tmpDate = startData;
            startData = endData;
            endData = tmpDate;
            System.out.println("Daty zostały zamienione ze sobą.");
        }
    }

    private String formatStringThatRepresentDate(final Date date)
    {
        String tmpData = "";
        tmpData += Integer.toString(date.getYear());
        tmpData += String.format("%02d", date.getMonth());
        tmpData += String.format("%02d", date.getDay());
        tmpData += String.format("%02d", date.getHour());
        tmpData += String.format("%02d", date.getMinute());
        return tmpData;
    }

    private Date startData;
    private Date endData;
}
