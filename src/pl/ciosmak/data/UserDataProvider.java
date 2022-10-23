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
        try
        {
            if (startData.getYear() > endData.getYear())
            {
                throw new Exception();
            }
            else if (startData.getYear() == endData.getYear())
            {
                if (startData.getMonth() > endData.getMonth())
                {
                    throw new Exception();
                }
                else if (startData.getMonth() == endData.getMonth())
                {
                    if (startData.getDay() > endData.getDay())
                    {
                        throw new Exception();
                    }
                    else if (startData.getDay() == endData.getDay())
                    {
                        if (startData.getHour() > endData.getHour())
                        {
                            throw new Exception();
                        }
                        else if (startData.getHour() == endData.getHour())
                        {
                            if (startData.getMonth() >= endData.getMinute())
                            {
                                throw new Exception();
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Daty zostały zamienione ze sobą.");
            Date tmpDate = startData;
            startData = endData;
            endData = tmpDate;
        }
    }

    @Override
    public ArrayList<String> prepareDate()
    {
        ArrayList<String> listOfDate = new ArrayList<String>();
        String tmpStartDate = "";
        tmpStartDate += Integer.toString(startData.getYear());
        tmpStartDate += String.format("%02d", startData.getMonth());
        tmpStartDate += String.format("%02d", startData.getDay());
        tmpStartDate += String.format("%02d", startData.getHour());
        tmpStartDate += String.format("%02d", startData.getMinute());
        listOfDate.add(tmpStartDate);

        String tmpEndDate = "";
        tmpEndDate += Integer.toString(endData.getYear());
        tmpEndDate += String.format("%02d", endData.getMonth());
        tmpEndDate += String.format("%02d", endData.getDay());
        tmpEndDate += String.format("%02d", endData.getHour());
        tmpEndDate += String.format("%02d", endData.getMinute());
        listOfDate.add(tmpEndDate);

        return listOfDate;
    }

    private Date startData;
    private Date endData;
}
