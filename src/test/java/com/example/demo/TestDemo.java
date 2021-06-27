package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ie.dkit.entity.Goods;
import ie.dkit.entity.GoodsImage;
import ie.dkit.mapper.GoodsImageMapper;
import ie.dkit.mapper.GoodsMapper;
import ie.dkit.service.impl.GoodsImageServiceImpl;
import ie.dkit.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author D00216118@DkIT
 * @date 2021/6/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    private GoodsServiceImpl goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void t1(){
        Goods g= goodsService.getById(11);
        System.out.println(g.getGoodsName());

        List<GoodsImage> goodsImageList = g.getGoodsImageList();
        System.out.println(goodsImageList.size());

    }

//    @Test
    public void  t2(){
        List<Goods> goodsList=goodsService.findGoodsStoreId(3);
        System.out.println(goodsList.size());
        for (Goods g:goodsList) {
            System.out.println(g.getGoodsName());
            }

        List<Goods> goodsList2=goodsService.findGoodsStoreId(3);
        System.out.println("second :: "+goodsList2.size());

    }

    @Test
    public void t3(){
        Page<Goods> page=new Page<>(1,2);
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("store_id",3);
        IPage<Goods> goodsPage = goodsMapper.selectPage(page, qw);

        System.out.println(goodsPage.getPages());
        System.out.println(goodsPage.getTotal());
        System.out.println(goodsPage.getRecords().size());
    }


//    @Autowired
//    private GoodsImageMapper goodsImageService;
//
//    @Test
//    public void t1(){
//        GoodsImage g= goodsImageService.getById(3);
//        System.out.println(g);
//
//        GoodsImage g2= goodsImageService.selectByImageId();
//
//
//    }

}
