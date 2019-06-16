package cn.vaf714.shop.service.impl;

import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.entity.generator.Commodity;
import cn.vaf714.shop.mapper.CommodityMapper;
import cn.vaf714.shop.mapper.UserMapper;
import cn.vaf714.shop.service.CommodityService;
import cn.vaf714.shop.service.CommodityService1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommodityServiceImpl implements CommodityService1 {
    private CommodityMapper commodityMapper;
    @Override
    public List<CommodityVo> getAllCommodity() {
        return commodityMapper.selectAllCommodity();
    }
}
