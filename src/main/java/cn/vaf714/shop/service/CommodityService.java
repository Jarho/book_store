package cn.vaf714.shop.service;

import cn.vaf714.shop.entity.CommodityQueryVo;
import cn.vaf714.shop.entity.CommodityUpdateVo;
import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.exception.CommodityDuplicationException;
import cn.vaf714.shop.mapper.CommodityMapper;
import cn.vaf714.shop.util.ExceptionUtils;
import cn.vaf714.shop.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommodityService {
    public static final int ADD_COMMODITY_TRUE = 1;
    public static final int ADD_COMMODITY_DUPLICATION = 2;
    public static final int ADD_COMMODITY_FALSE = 3;

    public static final int ALTER_COMMODITY_TRUE = 1;
    public static final int ALTER_COMMODITYID_DUPLICATION = 2;
    public static final int ALTER_COMMODITY_FALSE = 3;

    public static final int DELETE_COMMODITY_TRUE = 1;
    public static final int DELETE_COMMODITY_FALSE = 2;

    @Autowired
    private CommodityMapper commodityMapper;

    private Logger logger = LoggerFactory.getLogger("myLogger");

    public Page<CommodityVo> queryCommodity(String id, int pageNum) {
        Page<CommodityVo> page = new Page<>(pageNum);
        logger.debug("id: {}, pageNum: {}", id, pageNum);

        page.setTotalItemNum(commodityMapper.countCommodityNum(id));

        // 构造查询条件
        CommodityQueryVo commodityQueryVo = new CommodityQueryVo(id, (page.getPageNum() - 1) * page.getPageSize(), page.getPageSize());

        page.setList(commodityMapper.findCommodity(commodityQueryVo));

        return page;
    }
    public List<CommodityVo> getAllCommodity(){
        return commodityMapper.selectAllCommodity();
    }

    public int addCommodity(CommodityVo commodityVo) {
        try {
            //判断商品是否已存在
            if (commodityMapper.findSingleCommodityById(commodityVo.getId()) != null) {
                throw new CommodityDuplicationException("商品编号已存在");
            }
            commodityMapper.addCommodity(commodityVo);
            logger.info("商品添加成功：{}", commodityVo);
            return ADD_COMMODITY_TRUE;
        } catch (CommodityDuplicationException e) {
            logger.info("商品添加失败：{}", ExceptionUtils.getTrace(e));
            return ADD_COMMODITY_DUPLICATION;
        } catch (Exception e) {
            logger.info("商品添加失败：{}", ExceptionUtils.getTrace(e));
            return ADD_COMMODITY_FALSE;
        }
    }

    public int alterCommodity(CommodityUpdateVo commodityUpdateVo) {
        try {
            //判断商品是否已存在
            if ((!commodityUpdateVo.getCommodity().getId().equals(commodityUpdateVo.getPreId())) && commodityMapper.findSingleCommodityById(commodityUpdateVo.getCommodity().getId()) != null){
                throw new CommodityDuplicationException("商品编号已存在");
            }
            commodityMapper.alterCommodity(commodityUpdateVo);
            logger.info("商品修改成功：{}",commodityUpdateVo);
            return ALTER_COMMODITY_TRUE;
        } catch (CommodityDuplicationException e) {
            logger.info("商品修改失败：{}", ExceptionUtils.getTrace(e));
            return ALTER_COMMODITYID_DUPLICATION;
        } catch (Exception e) {
            logger.warn("商品修改失败：{}", ExceptionUtils.getTrace(e));
            return ALTER_COMMODITY_FALSE;
        }
    }

    public int deleteCommodity(String id) {
        try {
            commodityMapper.deleteCommodityById(id);
            logger.info("商品删除成功：{}",id);
            return DELETE_COMMODITY_TRUE;
        } catch (Exception e) {
            logger.warn("商品删除失败：{}", ExceptionUtils.getTrace(e));
            return DELETE_COMMODITY_FALSE;
        }
    }
}
