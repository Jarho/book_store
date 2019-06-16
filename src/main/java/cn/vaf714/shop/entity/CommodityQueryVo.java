package cn.vaf714.shop.entity;

public class CommodityQueryVo {
    private String id;
    private int startNum;
    private int num;

    @Override
    public String toString() {
        return "CommodityQueryVo{" +
                "id='" + id + '\'' +
                ", startNum=" + startNum +
                ", endNum=" + num +
                '}';
    }

    public CommodityQueryVo(String id, int startNum, int endNum) {
        this.id = id;
        this.startNum = startNum;
        this.num = endNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getEndNum() {
        return num;
    }

    public void setEndNum(int endNum) {
        this.num = endNum;
    }
}
