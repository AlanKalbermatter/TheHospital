package dao.domain.drugs;

public class Medicine {
    private String name;
    private double price;

    public Medicine(){}

    public Medicine(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MedicineDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
