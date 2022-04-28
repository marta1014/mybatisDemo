package com.mybatisTest;

import com.Mapper.BrandMapper;
import com.jopo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void testSelectAll() throws Exception {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws Exception {
        int id = 2;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectByIdBrand(id);

        System.out.println(brand);
        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws Exception {
        // 接受参数
        int statu = 1;
        String companyName = "苹果";
        String brandName = "苹果";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 组装对象 for interface 2
        // Brand b = new Brand();
        // b.setBrandName(brandName);
        // b.setCompanyName(companyName);
        // b.setStatu(statu);

        // for Map 3
        Map m = new HashMap();
        // m.put("statu",statu);
        m.put("companyName",companyName);
        // m.put("brandName",brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // List<Brand> brandList = brandMapper.selectByCondition(statu,companyName,brandName);

        // for interface 2
        //List<Brand> brandList = brandMapper.selectByCondition (b);

        List<Brand> brandList = brandMapper.selectByCondition(m);

        System.out.println(brandList);
        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws Exception {
        // 接受参数
        int statu = 1;
        String companyName = "苹果";
        String brandName = "苹果";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 组装对象 for interface 2
         Brand b = new Brand();
         // b.setBrandName(brandName);
         // b.setCompanyName(companyName);
         //b.setStatu(statu);



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // List<Brand> brandList = brandMapper.selectByCondition(statu,companyName,brandName);

        // for interface 2
        List<Brand> brandList = brandMapper.selectByConditionSingle(b);

        System.out.println(brandList);
        sqlSession.close();

    }


    @Test
    public void add() throws Exception {

        int statu = 1;
        String companyName = "HTC手机公司";
        String brandName = "HTC";
        String description = "htc火遍全亚洲";
        int ordered = 200;

        Brand b = new Brand();
        b.setBrandName(brandName);
        b.setCompanyName(companyName);
        b.setStatu(statu);
        b.setDescription(description);
        b.setOrdered(ordered);



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(b);
        // 设置主键返回 最终拿到成功后的id主键
        int resId = b.getId();
        System.out.println(resId);

        // 主动提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void updateInfo() throws Exception {

        int statu = 0;
        String companyName = "牛逼HTC手机公司有限公司";
        String brandName = "HTC pro";
        String description = "htc火遍全亚洲仅仅只是时间问题,";
        int ordered = 800;
        int id = 5;

        Brand b = new Brand();
//        b.setBrandName(brandName);
//        b.setCompanyName(companyName);
        b.setStatu(statu);
//        b.setDescription(description);
//        b.setOrdered(ordered);
        b.setId(id);




        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int num = brandMapper.update(b);
        // 设置主键返回 最终拿到成功后的id主键

        System.out.println(num);

        // 主动提交事务
        sqlSession.commit();

        sqlSession.close();

    }


    @Test
    public void deleteInfo() throws Exception {

        int id = 5;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int num = brandMapper.deleteById(id);
        // 设置主键返回 最终拿到成功后的id主键

        System.out.println(num);

        // 主动提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void deleteByIds() throws Exception {

        int[] ids = {1,6};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        // 设置主键返回 最终拿到成功后的id主键

        // 主动提交事务
        sqlSession.commit();

        sqlSession.close();

    }

}
