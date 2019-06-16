package com.itheima.dao;

import com.itheima.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
