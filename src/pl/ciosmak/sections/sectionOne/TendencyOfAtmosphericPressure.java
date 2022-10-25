package pl.ciosmak.sections.sectionOne;

import pl.ciosmak.sections.Section;

public class TendencyOfAtmosphericPressure extends Section
{
    public TendencyOfAtmosphericPressure(final String parameters)
    {
        char tmpCharacteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = parameters.charAt(1);
        switch (tmpCharacteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation)
        {
            case '0' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "wzrost, potem spadek; ciśnienie jest wyższe lub takie samo jak przed trzema godzinami";
            case '1' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "wzrost potem stan stały; lub wzrost, potem wzrost wolniejszy; ciśnienie jest wyższe niż przed trzema godzinami";
            case '2' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "wzrost równomierny lub nierównomierny; ciśnienie jest wyższe niż przed trzema godzinami";
            case '3' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "spadek, potem wzrost; lub stan stały, potem wzrost; lub wzrost, potem wzrost słabszy; ciśnienie jest wyższe niż przed trzema godzinami";
            case '4' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "stan stały; ciśnienie jest takie samo jak przed trzema godzinami";
            case '5' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "spadek, potem wzrost; ciśnienie jest takie samo lub niższe niż przed trzema godzinami";
            case '6' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "spadek, potem stan stały; lub spadek, potem spadek wolniejszy; ciśnienie jest niższe niż przed trzema godzinami";
            case '7' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "spadek równomierny lub nierównomierny; ciśnienie jest niższe niż przed trzema godzinami";
            case '8' -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "wzrost, potem spadek; lub stan stały, potem spadek; lub spadek, potem spadek szybszy; ciśnienie jest niższe niż przed trzema godzinami";
            default -> characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation = "BLĄD PRZY WCZYTYWANIU";
        }

        int tmpAbsoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation = Integer.parseInt(parameters.substring(2));
        if (tmpAbsoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation < 500)
        {
            tmpAbsoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation += 1000;
        }
        absoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation = Integer.toString(tmpAbsoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation);
    }

    @Override
    public void show()
    {
        System.out.println("Charakterystyka tendencji ciśnienia atmosferycznego za okres trzech godzin poprzedzających obserwację: " + characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation);
        System.out.println("Bezwzględna wartość tendencji ciśnienia atmosferycznego za okres trzech godzin poprzedzających obserwację: " + absoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation + " hPa");
    }

    private final String characteristicsOfTheAtmosphericPressureTrendForTheThreeHoursPrecedingTheObservation;
    private final String absoluteValueOfTheAtmosphericPressureTrendOverTheThreeHoursPriorToObservation;
}