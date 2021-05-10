package dao.domain.misc;

import dao.domain.BaseModel;

public class MedicalChart extends BaseModel {
    private String history;

    public MedicalChart(){}

    public MedicalChart(String history){
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}

