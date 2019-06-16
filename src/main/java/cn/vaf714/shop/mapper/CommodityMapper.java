package cn.vaf714.shop.mapper;

import cn.vaf714.shop.entity.CommodityQueryVo;
import cn.vaf714.shop.entity.CommodityUpdateVo;
import cn.vaf714.shop.entity.CommodityVo;
import cn.vaf714.shop.entity.generator.Commodity;

import java.util.List;

public interface CommodityMapper {

    /**
     * 计算模糊查询总数
     *
     * @param id
     * @return
     */
    int countCommodityNum(String id);

    /**
     * 模糊查询
     */
    List<CommodityVo> findCommodity(CommodityQueryVo commodityQueryVo);

    /**
     * 增加商品
     *
     * @param commodityVo
     */
    void addCommodity(CommodityVo commodityVo);

    /**
     * 根据 id 删除商品
     *
     * @param id
     */
    void deleteCommodityById(String id);

    /**
     * 根据 ID 修改商品
     */
    void alterCommodity(CommodityUpdateVo commodityUpdateVo);

    CommodityVo findSingleCommodityById(String id);
    /**
     * 获取全部商品
     */
    List<CommodityVo> selectAllCommodity();
}