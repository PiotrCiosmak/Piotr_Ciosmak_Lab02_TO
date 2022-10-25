package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class Rainfall extends Section
{
    public Rainfall(final String parameters)
    {
        if (parameters.length() == 0)
        {
            sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "";
            durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "";
            return;
        }
        int tmpSumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = Integer.parseInt(parameters.substring(1, 4));
        switch (tmpSumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation)
        {
            case 0 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "brak opadu";
            case 989 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "989 mm lub wiecej";
            case 990 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "ślad opadu";
            case 991 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,1 mm";
            case 992 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,2 mm";
            case 993 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,3 mm";
            case 994 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,4 mm";
            case 995 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,5 mm";
            case 996 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,6 mm";
            case 997 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,7 mm";
            case 998 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,8 mm";
            case 999 -> sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = "0,9 mm";
            default ->
                    sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation = tmpSumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation + " mm";

        }

        char tmpDurationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = parameters.charAt(4);
        switch (tmpDurationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall)
        {
            case '1' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 6 godzin poprzedzających obserwację";
            case '2' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 12 godzin poprzedzających obserwację";
            case '3' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 18 godzin poprzedzających obserwację";
            case '4' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 24 godzin poprzedzających obserwację";
            case '5' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 1 godziny poprzedzających obserwację";
            case '6' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 2 godzin poprzedzających obserwację";
            case '7' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 3 godzin poprzedzających obserwację";
            case '8' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 9 godzin poprzedzających obserwację";
            case '9' ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "całkowite opady w ciągu 15 godzin poprzedzających obserwację";
            default ->
                    durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall = "BLĄD PRZY WCZYTYWANIU";
        }
    }

    @Override
    public void show()
    {
        if (sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation.length() == 0 && durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall.length() == 0)
        {
            return;
        }
        System.out.println("Suma opadów w okresie poprzedzającym czas obserwacji: " + sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation);
        System.out.println("Czas trwania okresu opadów kończącego się w terminie obserwacji, za który podaje się wysokośc opadów: " + durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall);
    }

    private final String sumOfPrecipitationInMmInThePeriodPrecedingTheTimeOfObservation;
    private final String durationOfTheRainfallPeriodEndingAatTheTimeOfObservationAsDefinedByTheAmountOfRainfall;
}
