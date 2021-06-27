package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ie.dkit.entity.Goods;
import ie.dkit.entity.GoodsImage;
import ie.dkit.mapper.GoodsImageMapper;

import ie.dkit.mapper.GoodsMapper;
import ie.dkit.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author D00216118@DkIT
 * @date 2021/6/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUD {

    @Autowired
    private GoodsImageMapper goodsImageMapper;

    @Test
    public void testCreate() {
        GoodsImage goodsImage = new GoodsImage(0, 2, "aca", "bcb", 1, 66, 1);

        int result = goodsImageMapper.insert(goodsImage);
        System.out.println(result);
        System.out.println(goodsImage);

//        JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@b0a1231] will not be managed by Spring
//        ==>  Preparing: INSERT INTO ecm_goods_image ( goods_id, image_url, thumbnail, sort_order, file_id ) VALUES ( ?, ?, ?, ?, ? )
//        ==> Parameters: 2(Integer), aa(String), bb(String), 1(Integer), 55(Integer)
//        <==    Updates: 1
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@3f36e8d1]
//        1
//        GoodsImage(imageId=1471, goodsId=2, imageUrl=aa, thumbnail=bb, sortOrder=1, fileId=55)


       /* List<GoodsImage> goodsImageL = goodsImageMapper.selectImageByGoodsId(7);
        goodsImageL.forEach(System.out::println);*/

    }

    @Test
    public void testUpate() {
        GoodsImage goodsImage = new GoodsImage();

        goodsImage.setGoodsId(899);
        goodsImage.setImageUrl("aa1-lock");
        goodsImage.setThumbnail("bbb2-lock");
        goodsImage.setSortOrder(1);
        goodsImage.setFileId(891);
        goodsImage.setImageId(1471);
        goodsImage.setVersion(2);

        int result = goodsImageMapper.updateById(goodsImage);
        System.out.println(result);

//        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@794366a5] was not registered for synchronization because synchronization is not active
//        JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@77f905e3] will not be managed by Spring
//        ==>  Preparing: UPDATE ecm_goods_image SET goods_id=?, image_url=?, thumbnail=?, sort_order=?, file_id=? WHERE image_id=?
//        ==> Parameters: 996(Integer), aa1(String), bbb2(String), 1(Integer), 891(Integer), 1471(Integer)
//        <==    Updates: 1
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@794366a5]

    }


    // Optimistic Locking
    @Test
    public void testUpateWithLock() {
        GoodsImage goodsImage = (GoodsImage) goodsImageMapper.selectById(1473);
        goodsImage.setImageUrl("fuck lock !");

        goodsImageMapper.updateById(goodsImage);

//        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@40f35e52] was not registered for synchronization because synchronization is not active
//        JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41184371] will not be managed by Spring
//        ==>  Preparing: SELECT image_id,goods_id,image_url,thumbnail,sort_order,file_id,version FROM ecm_goods_image WHERE image_id=?
//        ==> Parameters: 1471(Integer)
//        <==    Columns: image_id, goods_id, image_url, thumbnail, sort_order, file_id, version
//        <==        Row: 1471, 999, aa1-lock, bbb2-lock, 1, 891, 1
//        <==      Total: 1
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@40f35e52]

//        Creating a new SqlSession
//        SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1a47a1e8] was not registered for synchronization because synchronization is not active
//        JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@41184371] will not be managed by Spring
//        ==>  Preparing: UPDATE ecm_goods_image SET goods_id=?, image_url=?, thumbnail=?, sort_order=?, file_id=?, version=? WHERE image_id=? AND version=?
//        ==> Parameters: 999(Integer), fuck lock !(String), bbb2-lock(String), 1(Integer), 891(Integer), 2(Integer), 1471(Integer), 1(Integer)
//        <==    Updates: 1
//        Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1a47a1e8]

    }


    //Pessimistic Optimistic Locking
    @Test
    public void testOptimisticLock() {
        GoodsImage goodsImage = new GoodsImage();
        goodsImage.setGoodsId(999);
        goodsImage.setImageUrl("aa1-lock");
        goodsImage.setThumbnail("bbb2-lock");
        goodsImage.setSortOrder(1);
        goodsImage.setFileId(891);
        goodsImage.setImageId(1471);
        goodsImage.setVersion(1);


        GoodsImage goodsImage2 = new GoodsImage();
        goodsImage2.setGoodsId(19);
        goodsImage2.setImageUrl("aa1-lock-pessimistic");
        goodsImage2.setThumbnail("bbb2-lock");
        goodsImage2.setSortOrder(1);
        goodsImage2.setFileId(891);
        goodsImage2.setImageId(1471);
        goodsImage2.setVersion(1);

        goodsImageMapper.updateById(goodsImage2);

        goodsImageMapper.updateById(goodsImage);

        //the goodsImage cant be executed, so the table row data is goodsImage2
        // the goodImage2 completed the execution so the version is change that is 2.
        // but the goodImage version also is 1, it not be executed
    }

    @Test
    public void testDelete() {
        goodsImageMapper.deleteBatchIds(Arrays.asList(1471, 1472));
    }


    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void testQuery() {
        //between and, orderBy, inSql
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.between("price", 100.00, 200.00);
        qw.orderByDesc("price");
//        qw.inSql("goodS_id","select goods_id from ecm_goods where add_time<1395772806");
//        List<Goods>  goodsList=goodsMapper.selectList(qw);
        List<Map<String, Object>> goodsList = goodsMapper.selectMaps(qw);
//        goodsList.forEach(System.out::println);
        for (Map<String, Object> x : goodsList) {
            System.out.println(x.get("goods_name"));
        }

    }

    @Test
    public void testQuery2() {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.select("store_id", "AVG(price) as avg")
        .groupBy("store_id");
        List<Map<String, Object>> goodsList = goodsMapper.selectMaps(qw);
        System.out.println("list size: "+goodsList.size());
        for (Map<String, Object> x : goodsList) {
            System.out.println("Map size: "+x.keySet().size());
            System.out.print(x.get("store_id")+"==>");
            System.out.println(x.get("avg"));
        }
    }

}
