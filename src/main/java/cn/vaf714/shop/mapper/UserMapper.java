package cn.vaf714.shop.mapper;

import cn.vaf714.shop.entity.UserVo;
import cn.vaf714.shop.entity.generator.User;

import java.util.List;

public interface UserMapper {

    UserVo findUserByName(UserVo userVo);

    void addUser(UserVo userVo);



}