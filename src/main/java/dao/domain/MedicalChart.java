package dao.domain;

public class MedicalChart {
    private long id;
    private String history;

    public MedicalChart(){}

    public MedicalChart(String history){
        this.history = history;
    }

    public long getId() {
        return id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
