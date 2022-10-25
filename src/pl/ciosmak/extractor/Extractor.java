package pl.ciosmak.extractor;

public class Extractor
{
    public Extractor(final String dataLine)
    {
        this.dataLine = dataLine;
        rightSplitIndex = -1;
        leftSplitIndex = 0;

        stationID = extractFromDataLine(',');
        year = extractFromDataLine(',');
        month = extractFromDataLine(',');
        day = extractFromDataLine(',');
        hour = extractFromDataLine(',');
        minute = extractFromDataLine(',');
        stationTypeID = extractFromDataLine(' ');
        if (!stationTypeID.equals("AAXX"))
        {
            return;
        }
        timeOfObservationAndWindIndex = extractFromDataLine(' ');
        String tmpStationID = extractFromDataLine(' ');
        if (!tmpStationID.equals(stationID))
        {
            System.out.println("BLĄD!!!");
            System.exit(1);
        }
        precipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility = extractFromDataLine(' ');
        amountOfGeneralCloudCoverAndWindData = extractFromDataLine(' ');
        airTemperature = extractFromDataLine(' ');
        dewPointTemperature = extractFromDataLine(' ');
        atmosphericPressureAtTheStationLevel = extractFromDataLine(' ');
        atmosphericPressureAtSeaLevel = extractFromDataLine(' ');
        tendencyOfAtmosphericPressure = extractFromDataLine(' ');

        String tmpData;
        boolean stayInTheWhileLoop = true;
        while (stayInTheWhileLoop)
        {
            //TODO sprawdzac czy len nie jest == 0 jestli jest to wpisac brak pomiaru
            tmpData = extractFromDataLine(' ');
            if (tmpData.charAt(0) == '6')
            {
                rainfall = tmpData;
            }
            else if (tmpData.charAt(0) == '7')//TODO Uważać na to ze albo są dwie liczby i // albo // i dwie liczby
            {
                presentAndPastWeatherCondition = tmpData;
            }
            else if (tmpData.charAt(0) == '8')
            {
                clouds = tmpData;
            }
            else if (tmpData.charAt(0) == '9')
            {
                currentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero = tmpData;
            }
            else
            {
                stayInTheWhileLoop = false;
            }
        }
    }

    public String getStationID()
    {
        return stationID;
    }

    public String getYear()
    {
        return year;
    }

    public String getMonth()
    {
        return month;
    }

    public String getDay()
    {
        return day;
    }

    public String getHour()
    {
        return hour;
    }

    public String getMinute()
    {
        return minute;
    }

    public String getStationTypeID()
    {
        return stationTypeID;
    }

    public String getTimeOfObservationAndWindIndex()
    {
        return timeOfObservationAndWindIndex;
    }

    public String getPrecipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility()
    {
        return precipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility;
    }

    public String getAmountOfGeneralCloudCoverAndWindData()
    {
        return amountOfGeneralCloudCoverAndWindData;
    }

    public String getAirTemperature()
    {
        return airTemperature;
    }

    public String getDewPointTemperature()
    {
        return dewPointTemperature;
    }

    public String getAtmosphericPressureAtTheStationLevel()
    {
        return atmosphericPressureAtTheStationLevel;
    }

    public String getAtmosphericPressureAtSeaLevel()
    {
        return atmosphericPressureAtSeaLevel;
    }

    public String getTendencyOfAtmosphericPressure()
    {
        return tendencyOfAtmosphericPressure;
    }

    public String getRainfall()
    {
        return rainfall;
    }

    public String getPresentAndPastWeatherCondition()
    {
        return presentAndPastWeatherCondition;
    }

    public String getClouds()
    {
        return clouds;
    }

    public String getCurrentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero()
    {
        return currentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero;
    }

    private String extractFromDataLine(final char splitSign)
    {
        leftSplitIndex = rightSplitIndex + 1;
        rightSplitIndex = dataLine.indexOf(splitSign, leftSplitIndex);
        if (rightSplitIndex == -1)
        {
            if (dataLine.charAt(leftSplitIndex) == '5')
            {
                return dataLine.substring(leftSplitIndex, leftSplitIndex + 5);
            }
            return "End of string";
        }
        return dataLine.substring(leftSplitIndex, rightSplitIndex);
    }

    private final String dataLine;
    private int leftSplitIndex;
    private int rightSplitIndex;

    private final String stationID;
    private final String year;
    private final String month;
    private final String day;
    private final String hour;
    private final String minute;
    private final String stationTypeID;
    private String timeOfObservationAndWindIndex;
    private String precipitationGroupIndexAndCloudBaseHeightAndHorizontalVisibility;
    private String amountOfGeneralCloudCoverAndWindData;
    private String airTemperature;
    private String dewPointTemperature;
    private String atmosphericPressureAtTheStationLevel;
    private String atmosphericPressureAtSeaLevel;
    private String tendencyOfAtmosphericPressure;
    private String rainfall;
    private String presentAndPastWeatherCondition;
    private String clouds;
    private String currentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero;
}