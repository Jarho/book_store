package cn.vaf714.shop.controller;

import cn.vaf714.shop.entity.CommodityUpdateVo;
import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.service.CommodityService;
import cn.vaf714.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * 添加商品
     */
    @RequestMapping("addCommodity")
    @ResponseBody
    public Map<String, Object> addCommodity(CommodityVo commodityVo){
        int status = commodityService.addCommodity(commodityVo);

        Map<String,Object> result = new HashMap<>();
        result.put("addCommodityStatus",status);
        return result;
    }

    /**
     * 修改商品
     */
    @RequestMapping("alterCommodity")
    @ResponseBody
    public Map<String, Object> alterCommodity(CommodityUpdateVo commodityUpdateVo){
        int status = commodityService.alterCommodity(commodityUpdateVo);

        Map<String,Object> result = new HashMap<>();
        result.put("alterCommodityStatus",status);
        return result;
    }

    /**
     * 删除商品
     */
    @RequestMapping("deleteCommodity")
    @ResponseBody
    public Map<String, Object> deleteCommodity(String id){
        int status = commodityService.deleteCommodity(id);

        Map<String,Object> result = new HashMap<>();
        result.put("deleteCommodityStatus",status);
        return result;
    }

    /**
     * 查询商品
     */
    @RequestMapping("queryCommodity")
    @ResponseBody
    public Page<CommodityVo> queryCommodity(String id, int pageNum){
        return commodityService.queryCommodity(id, pageNum);
    }
    /**
     * 全部商品
     */
    @RequestMapping("findAllCommdity")
    @ResponseBody
    public List<CommodityVo> findAllCommodity(){
    return commodityService.getAllCommodity();
    }
}
