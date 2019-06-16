package cn.vaf714.shop.entity.generator;

public class Commodity {
    private String id;

    private String name;

    public Commodity(String id, String name, String price, Integer num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public Commodity() {
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", num=" + num +
                '}';
    }

    private String price;

    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}