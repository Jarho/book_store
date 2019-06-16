package cn.vaf714.shop.test;

import cn.vaf714.shop.entity.CartResultVo;
import cn.vaf714.shop.entity.CartVo;
import cn.vaf714.shop.entity.UserVo;
import cn.vaf714.shop.mapper.CartMapper;
import cn.vaf714.shop.service.CartService;
import cn.vaf714.shop.util.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


public class CartServiceTest {
    private CartService cartService;
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        cartService = (CartService) applicationContext.getBean("cartService");

    }


    @Test
    public void queryCommodity() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("commodityId", "10");
        map.put("userName", "zsc");
    }
}