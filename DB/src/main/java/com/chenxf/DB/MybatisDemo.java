package com.chenxf.DB;

import com.chenxf.DB.Mapper.UsersMapper;
import com.chenxf.DB.POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<FullInfo> users = sqlSession.selectList("test.selectFullInfo");

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
//        List<FullInfo> users = usersMapper.selectFullInfo();


//        System.out.println(users);

        sqlSession.close();
    }
}
