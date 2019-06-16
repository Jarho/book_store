package cn.vaf714.shop.entity;

import cn.vaf714.shop.entity.generator.Commodity;


public class CommodityVo extends Commodity{

    public CommodityVo(String id, String name, String price, Integer num) {
        super(id, name, price, num);
    }

    public CommodityVo() {
    }
}
