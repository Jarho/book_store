package cn.vaf714.shop.service;

import cn.vaf714.shop.entity.*;
import cn.vaf714.shop.entity.generator.Cart;
import cn.vaf714.shop.entity.generator.Commodity;
import cn.vaf714.shop.mapper.CartMapper;
import cn.vaf714.shop.mapper.CommodityMapper;
import cn.vaf714.shop.util.ExceptionUtils;
import cn.vaf714.shop.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    public static final int ADD_TO_CART_TRUE = 1;
    public static final int ADD_TO_CART_FALSE = 2;
    public static final int DELETE_FROM_CART_TRUE = 1;
    public static final int DELETE_FROM_CART_FALSE = 2;
    public static final int CLEAR_CART_TRUE = 1;
    public static final int CLEAR_CART_FALSE = 2;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    final Logger logger = LoggerFactory.getLogger("myLogger");

    public Page<CartResultVo> queryCart(UserVo userVo, int pageNum) {
        Page<CartResultVo> page = new Page<>(pageNum);

        logger.info("name: {}, pageNum: {}", userVo.getName(), pageNum);

        page.setTotalItemNum(cartMapper.countCartNum(userVo.getName()));

        // 构造查询条件
        CartQueryVo cartQueryVo = new CartQueryVo(userVo.getName(), (page.getPageNum() - 1) * page.getPageSize(), page.getPageSize());

        page.setList(cartMapper.findCart(cartQueryVo));

        return page;
    }

    public int addToCar(String id, int buyNum, HttpSession session) {

        UserVo userVo = (UserVo) session.getAttribute("generalUser");
        Commodity commodityVo = commodityMapper.findSingleCommodityById(id);
        try {
            //商品减
            commodityVo.setNum(commodityVo.getNum() - buyNum);
            CommodityUpdateVo commodityUpdateVo = new CommodityUpdateVo(id, commodityVo);
            commodityMapper.alterCommodity(commodityUpdateVo);
            //int i = 1 / 0;

            //购物车加
            Map<String, String> map = new HashMap<>();
            map.put("commodityId", id);
            map.put("userName", userVo.getName());
            CartVo cartVoFromDB = cartMapper.findCommodityFromCartById(map);
            if (cartVoFromDB != null) {
                // 1.该商品已经存在于购物车,更新该记录
                Map<String, Object> map2 = new HashMap<>();
                map2.put("buyNum", cartVoFromDB.getBuyNum() + buyNum);
                map2.put("userName", userVo.getName());
                map2.put("commodityId", id);
                cartMapper.alterCart(map2);
            } else {
                // 2.该商品不存在与购物车,直接添加
                CartVo cartVo = new CartVo(userVo.getName(), id, buyNum);
                cartMapper.addCart(cartVo);
            }
            logger.info(" {}向购物车添加了 {} 个 {}", userVo.getName(), buyNum, commodityVo.getName());

            return ADD_TO_CART_TRUE;
        } catch (Exception e) {
            logger.warn(" {}向购物车添加商品失败: {}", userVo.getName(), ExceptionUtils.getTrace(e));

            return ADD_TO_CART_FALSE;
        }
    }
    public int clearCart(HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("generalUser");
        try{

            cartMapper.deleteUserCart(userVo.getName());
            return CLEAR_CART_TRUE;
        }catch (Exception e){
            e.printStackTrace();
            return CLEAR_CART_FALSE;
        }

    }
    public int deleteFromCart(String id,int deleteNum,HttpSession session){
        UserVo userVo = (UserVo) session.getAttribute("generalUser");
        Commodity commodityVo = commodityMapper.findSingleCommodityById(id);
        Map<String, String> map = new HashMap<>();
        map.put("commodityId", id);
        map.put("userName", userVo.getName());
        Cart cartVo=cartMapper.findCommodityFromCartById(map);
        try{
            //购物车减
            if(cartVo.getBuyNum()!=deleteNum) {
                Map<String, Object> map3 = new HashMap<>();
                map3.put("buyNum", cartVo.getBuyNum() - deleteNum);
                map3.put("userName", userVo.getName());
                map3.put("commodityId", id);
                cartMapper.alterCart(map3);
            }else{
                cartMapper.deleteSingleCart(cartVo);
            }

            //商品加
            commodityVo.setNum(commodityVo.getNum()+deleteNum);
            CommodityUpdateVo commodityUpdateVo=new CommodityUpdateVo(id,commodityVo);
            commodityMapper.alterCommodity(commodityUpdateVo);
            return DELETE_FROM_CART_TRUE;
        }catch (Exception e){
            e.printStackTrace();
            return DELETE_FROM_CART_FALSE;
        }

    }

    public CartVo findAll(Map<String,String> map){
        return cartMapper.findCommodityFromCartById( map);
    }

}
