package Models;

import java.util.List;

/**
 *
 */
public class Period {

    public Period(PeriodInformation period_information, List<Theater> theaters) {
        this.period_information = period_information;
        this.theaters = theaters;
    }

    private PeriodInformation period_information;
    private List<Theater> theaters;

    public PeriodInformation getPeriod_information() {
        return period_information;
    }

    public void setPeriod_information(PeriodInformation period_information) {
        this.period_information = period_information;
    }

    public List<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(List<Theater> theaters) {
        this.theaters = theaters;
    }
}