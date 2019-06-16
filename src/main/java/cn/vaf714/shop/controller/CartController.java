package cn.vaf714.shop.controller;

import cn.vaf714.shop.entity.CartResultVo;
import cn.vaf714.shop.entity.UserVo;
import cn.vaf714.shop.service.CartService;
import cn.vaf714.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加购物车
     */
    @RequestMapping("addToCart")
    @ResponseBody
    public Map<String, Object> addToCart(HttpSession session, String id, int num) {

        int status = cartService.addToCar(id, num, session);

        Map<String, Object> result = new HashMap<>();
        result.put("addStatus", status);
        return result;
    }
    /**
     * 删除购物车
     */
    @RequestMapping("deleteFromCart")
    @ResponseBody
    public Map<String,Object> deleteFromCart(HttpSession session,String id,int num){
        int status=cartService.deleteFromCart(id,num,session);
        Map<String,Object> result=new HashMap<>();
        result.put("deleteStatus",status);
        return result;
    }
    /**
     * 查询购物车
     */
    @RequestMapping("queryCart")
    @ResponseBody
    public Page<CartResultVo> queryCart(HttpSession session, int pageNum) {
        UserVo userVo = (UserVo) session.getAttribute("generalUser");
        return cartService.queryCart(userVo, pageNum);
    }
    /**
     * 清空购物车
     */
    @RequestMapping("clearCart")
    @ResponseBody
    public Map<String, Object> clearCart(HttpSession session, String id, int num) {
        int status=cartService.clearCart(session);
        Map<String,Object> result=new HashMap<>();
        result.put("clearStatus",status);
        return result;
    }
}
