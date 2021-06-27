package ie.dkit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ie.dkit.entity.Goods;
import ie.dkit.mapper.GoodsMapper;
import ie.dkit.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author d00216118
 * @since 2021-06-02
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private  GoodsMapper  goodsMapper;

    @Override
    public List<Goods> findGoodsStoreId(Integer storeId) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("store_id",storeId);
        return goodsMapper.selectList(qw);
    }
}
