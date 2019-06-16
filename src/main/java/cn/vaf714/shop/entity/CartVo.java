package cn.vaf714.shop.entity;

import cn.vaf714.shop.entity.generator.Cart;


public class CartVo extends Cart {
    public CartVo(long id,String userName, String commodityId, int buyNum) {
        super(id,userName,commodityId,buyNum);
    }

    public CartVo(String name, String commdityId, int buyNum) {
        super(name, commdityId, buyNum);
    }
    public CartVo(){

    }
}
