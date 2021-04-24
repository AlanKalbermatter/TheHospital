package dao.domain;

public class Medicine {
    private long id;
    private String name;

    public Medicine(){}

    public Medicine(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
