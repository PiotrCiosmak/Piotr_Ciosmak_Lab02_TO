package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class CurrentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero extends Section
{
    public CurrentObservationTimeWhenActualObservationTimeDiffersMoreThanTenMinutesFromStandardGGTimeInSectionZero(final String parameters)
    {
        boolean parametersExists = checkIfParametersExists(parameters);
        if (!parametersExists)
            return;

        hourOfObservation = parameters.substring(1, 3);
        minuteOfObservation = parameters.substring(3);
    }

    @Override
    public void show()
    {
        if (!checkIfVariablesAreNotEmpty())
            return;
        System.out.println("Godzina obserwacji: " + hourOfObservation);
        System.out.println("Minuta obserwacji: " + minuteOfObservation);
    }

    private boolean checkIfParametersExists(final String parameters)
    {
        if (parameters.length() == 0)
        {
            hourOfObservation = "";
            minuteOfObservation = "";
            return false;
        }
        return true;
    }

    private boolean checkIfVariablesAreNotEmpty()
    {
        return hourOfObservation.length() != 0 || minuteOfObservation.length() != 0;
    }

    private String hourOfObservation;
    private String minuteOfObservation;
}