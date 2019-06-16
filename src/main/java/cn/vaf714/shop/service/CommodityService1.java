package cn.vaf714.shop.service;

import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.entity.generator.Commodity;
import cn.vaf714.shop.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CommodityService1 {

    List<CommodityVo> getAllCommodity();
}
