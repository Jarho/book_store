package cn.vaf714.shop.entity.generator;

public class Cart {
  private Long id;
  private String userName;
  private String commodityId;
  private int buyNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", buyNum=" + buyNum +
                '}';
    }

    public Cart() {
    }

    public Cart(long id,String userName, String commodityId, int buyNum){
        this.id=id;
        this.userName = userName;
        this.commodityId = commodityId;
        this.buyNum = buyNum;
    }
    public Cart(String userName, String commodityId, int buyNum) {
        this.userName = userName;
        this.commodityId = commodityId;
        this.buyNum = buyNum;
    }
}
