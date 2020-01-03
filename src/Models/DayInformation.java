package Models;

import java.util.List;

public class DayInformation {
    private String day_name;
    private List<PeriodInformation> period_information;

    public DayInformation(String day_name, List<PeriodInformation> period_information) {
        this.day_name = day_name;
        this.period_information = period_information;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public List<PeriodInformation> getPeriod_information() {
        return period_information;
    }

    public void setPeriod_information(List<PeriodInformation> period_information) {
        this.period_information = period_information;
    }
}
