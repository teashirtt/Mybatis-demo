import com.demo.mapper.BrandMapper;
import com.demo.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = mapper.selectAll();
//        Brand b = mapper.selectById(2);
//        System.out.println(b);
//        List<Brand> brands = mapper.selectByCondition(1, "", "%为%");
//        System.out.println(brands);
//        mapper.add(add_func());
//        mapper.update(update_func());
//        mapper.del(3);
        sqlSession.close();
    }

    // 封装对象的函数 --非必要 这里只为主函数简洁
    public static Brand add_func() {
        //return new Brand(4, "农夫山泉", "农夫山泉有限公司", 20, "我们只是大自然的搬运工", 1);
        return new Brand(1, "可口可乐", "可口可乐有限公司", 200, "享受清新一刻", 0);
    }

    public static Brand update_func() {
        return new Brand(1, "可口可乐", "可口可乐有限公司", 200, "享受清新一刻", 0);
    }

}

// 修改数据需要事务 commit 否则会自动回滚
