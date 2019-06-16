package cn.vaf714.shop.entity;

import cn.vaf714.shop.entity.generator.Commodity;


public class CommodityUpdateVo {
    private String preId;
    private Commodity commodity;

    public CommodityUpdateVo(String preId, Commodity commodity) {
        this.preId = preId;
        this.commodity = commodity;
    }

    public CommodityUpdateVo() {
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
