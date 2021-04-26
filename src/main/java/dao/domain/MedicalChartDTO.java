package dao.domain;

public class MedicalChartDTO extends BaseModel{
    private String history;

    public MedicalChartDTO(){}

    public MedicalChartDTO(String history){
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}

