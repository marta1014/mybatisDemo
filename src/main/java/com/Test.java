package com;

import com.Mapper.MapperUser;
import com.jopo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
       // 加载核心配置文件 获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

       // 获取 SqlSession对象来执行sql
       SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取接口代理对象
        MapperUser userMapper = sqlSession.getMapper(MapperUser.class);
        List<User> users = userMapper.selectAll();

       System.out.println(users);
       // 释放资源
       sqlSession.close();

    }
}
