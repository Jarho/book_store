package cn.vaf714.shop.mapper;

import cn.vaf714.shop.entity.CartQueryVo;
import cn.vaf714.shop.entity.CartResultVo;
import cn.vaf714.shop.entity.CartVo;
import cn.vaf714.shop.entity.generator.Cart;

import java.util.List;
import java.util.Map;

public interface CartMapper {

    int countCartNum(String name);

    List<CartResultVo> findCart(CartQueryVo cartQueryVo);

    CartVo findCommodityFromCartById(Map<String,String> map);

    void addCart(CartVo cartVo);

    void alterCart(Map<String,Object> map);

    CartVo findSingleCartById(String commodityId,String userName);

    void alterCartBuyNum(Cart cart);

    //删除单个购物车
    void deleteSingleCart(Cart cartVo);

    //删除用户购物车
    void deleteUserCart(String userNmae);

    List<CartResultVo> findAll();
}