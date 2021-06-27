## Mybatis 延迟加载



**深度延迟加载**

```yml
aggressive-lazy-loading: false
lazy-loading-enabled: true
```



**侵入式延迟加载**

```yml
aggressive-lazy-loading: true
lazy-loading-enabled: true
```



**单向一对多例子**

goods商品表，goodsImage商品图片表（1：n）

Goods entity对象，加入关联的goodsImage对象集合。

```java
@TableField(exist = false)
private List<GoodsImage> goodsImageList;
```



Goods mapper xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="ie.dkit.mapper.GoodsMapper">
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="ie.dkit.entity.Goods">
        <id column="goods_id" property="goodsId"/>
        <result column="store_id" property="storeId"/>
        <result column="type" property="type"/>
        <result column="goods_name" property="goodsName"/>
        <result column="barcode" property="barcode"/>
        <result column="description" property="description"/>
        <result column="cate_id" property="cateId"/>
        <result column="cate_name" property="cateName"/>
        <result column="brand" property="brand"/>
        <result column="spec_qty" property="specQty"/>
        <result column="spec_name_1" property="specName1"/>
        <result column="spec_name_2" property="specName2"/>
        <result column="spec_name_3" property="specName3"/>
        <result column="if_show" property="ifShow"/>
        <result column="time_starter" property="timeStarter"/>
        <result column="time_over" property="timeOver"/>
        <result column="closed" property="closed"/>
        <result column="close_reason" property="closeReason"/>
        <result column="add_time" property="addTime"/>
        <result column="last_update" property="lastUpdate"/>
        <result column="default_spec" property="defaultSpec"/>
        <result column="default_image" property="defaultImage"/>
        <result column="recommended" property="recommended"/>
        <result column="cate_id_1" property="cateId1"/>
        <result column="cate_id_2" property="cateId2"/>
        <result column="cate_id_3" property="cateId3"/>
        <result column="cate_id_4" property="cateId4"/>
        <result column="price" property="price"/>
        <result column="tags" property="tags"/>

        <collection property="goodsImageList" column="goods_id" 			ofType="ie.dkit.entity.GoodsImage" select="ie.dkit.mapper.GoodsImageMapper.selectImageByGoodsId" />
<!--        fetchType="lazy"-->
    </resultMap>
</mapper>
```



goodsImage Mapper xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="ie.dkit.mapper.GoodsImageMapper">
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="ie.dkit.entity.GoodsImage">
        <id column="image_id" property="imageId"/>
        <result column="goods_id" property="goodsId"/>
        <result column="image_url" property="imageUrl"/>
        <result column="thumbnail" property="thumbnail"/>
        <result column="sort_order" property="sortOrder"/>
        <result column="file_id" property="fileId"/>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        select image_id, goods_id, image_url, thumbnail, sort_order, file_id from ecm_goods_image
    </sql>

    <select id="selectImageByGoodsId" resultMap="BaseResultMap" parameterType="integer">
        <include refid="Base_Column_List"/>
        where goods_id= #{goodsId}
    </select>

</mapper>
```



说明：当调用goods方法查询到时：

1，**直接加载** 如果不设置延时加载，会产生级联查询GoodImage表（此时不管是否调用g.getGoodsName()属性获取值）

2，**侵入式延迟加载** 设置 aggressive-lazy-loading: true   lazy-loading-enabled: true 此时仅当调用商品属性时，产生级联查询GoodImage表， 并且此属性并不是关联的属性值。



3，**深度延迟加载** aggressive-lazy-loading: false ， lazy-loading-enabled: true，只有调用关联的级联属性时参数级联查询。

```java
Goods g= goodsService.getById(11);
System.out.println(g.getGoodsName());

List<GoodsImage> goodsImageList = g.getGoodsImageList(); //级联查询属性
```

