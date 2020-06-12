package base.common;

/**
 * Description:
 * GET-version:
 * Date:2020-06-10  19:05
 * Author: wxr
 */

public class NowTime {
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer min;
    private Integer ss;

    private String year_s;
    private String month_s;
    private String day_s;
    private String hour_s;
    private String min_s;
    private String ss_s;

    public NowTime() {
    }

    public NowTime(Integer year, Integer month, Integer day, Integer hour, Integer min, Integer ss, String year_s, String month_s, String day_s, String hour_s, String min_s, String ss_s) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.ss = ss;
        this.year_s = year_s;
        this.month_s = month_s;
        this.day_s = day_s;
        this.hour_s = hour_s;
        this.min_s = min_s;
        this.ss_s = ss_s;
    }

    @Override
    public String toString() {
        return "NowTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", min=" + min +
                ", ss=" + ss +
                ", year_s='" + year_s + '\'' +
                ", month_s='" + month_s + '\'' +
                ", day_s='" + day_s + '\'' +
                ", hour_s='" + hour_s + '\'' +
                ", min_s='" + min_s + '\'' +
                ", ss_s='" + ss_s + '\'' +
                '}';
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public String getYear_s() {
        return year_s;
    }

    public void setYear_s(String year_s) {
        this.year_s = year_s;
    }

    public String getMonth_s() {
        return month_s;
    }

    public void setMonth_s(String month_s) {
        this.month_s = month_s;
    }

    public String getDay_s() {
        return day_s;
    }

    public void setDay_s(String day_s) {
        this.day_s = day_s;
    }

    public String getHour_s() {
        return hour_s;
    }

    public void setHour_s(String hour_s) {
        this.hour_s = hour_s;
    }

    public String getMin_s() {
        return min_s;
    }

    public void setMin_s(String min_s) {
        this.min_s = min_s;
    }

    public String getSs_s() {
        return ss_s;
    }

    public void setSs_s(String ss_s) {
        this.ss_s = ss_s;
    }
}
