package cn.vaf714.shop.entity;


public class CartQueryVo {
    private String name;
    private int startNum;
    private int num;

    public CartQueryVo(String name, int startNum, int num) {
        this.name = name;
        this.startNum = startNum;
        this.num = num;
    }

    @Override
    public String toString() {
        return "CartQueryVo{" +
                "name='" + name + '\'' +
                ", startNum=" + startNum +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
