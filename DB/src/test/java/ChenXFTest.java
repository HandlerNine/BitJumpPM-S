import com.chenxf.DB.Mapper.UsersMapper;
import com.chenxf.DB.POJO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ChenXFTest {

    public void test_UsersMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<FullInfo> users = sqlSession.selectList("test.selectFullInfo");

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

//        List<User> users = usersMapper.selectAll();
//        System.out.println(users);
        // [UserInfo{},...]

//        User test_user = usersMapper.selectByID("13618308366");
//        System.out.println(test_user);
        // UserInfo{UserID=,....}

        String userID = "13618308366";
//        String name = usersMapper.selectNameByID(userID);
//        System.out.println(name);
        // ChenXF

//        String Password = usersMapper.selectPasswordByID(userID);
//        System.out.println(Password);
        // hhh

        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {

    }

}
