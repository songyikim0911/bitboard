package org.zerock.bitboard.dao;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

@Log4j2
public enum TimeDAO {

    INSTANCE;

    public String getTime() throws RuntimeException{
        String result = null;//이제 익명클래스를 쓰지 않기떄문에 StringBuffer를 쓸 필요가 없다.

        try(SqlSession session = MyBatisLoader.INSTANCE.getFactory().openSession()){
            result = session.selectOne("org.zerock.bitboard.dao.TimeMapper.getTime");
            log.info("=========");
            log.info(result);
        }catch(Exception e){
            e.printStackTrace();
        }



        return result;
    }

}
