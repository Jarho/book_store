package cn.vaf714.shop.test;

import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.service.CommodityService;
import cn.vaf714.shop.util.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;



public class CommodityServiceTest {
    private CommodityService commodityService;
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        commodityService = (CommodityService) applicationContext.getBean("commodityService");
    }

    @Test
    public void queryCommodity() throws Exception {
        Page<CommodityVo> pages = commodityService.queryCommodity("6", 1);
        List<CommodityVo> commodityVoList=commodityService.getAllCommodity();
        for (CommodityVo commodityVo: commodityVoList) {
            System.out.println(commodityVo);
        }
    }

}