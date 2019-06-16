package cn.vaf714.shop.service;

import cn.vaf714.shop.entity.UserVo;
import cn.vaf714.shop.exception.NameFalseException;
import cn.vaf714.shop.exception.PasswordFalseException;
import cn.vaf714.shop.exception.UserDuplicationException;
import cn.vaf714.shop.mapper.UserMapper;
import cn.vaf714.shop.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Service
public class UserService {
    public static final int LOGIN_TRUE = 1;//登陆成功
    public static final int LOGIN_NAME_FALSE = 2;//登陆失败，用户名错误
    public static final int LOGIN_PASSWORD_FALSE = 3;//登陆失败，密码错误
    public static final int LOGIN_FALSE = 4;//登陆失败，其他错误

    public static final int LOGOUT_TRUE = 1;//注销成功
    public static final int LOGOUT_FALSE = 2;//注销失败

    public static final int REGISTER_TRUE = 1;//注册成功
    public static final int REGISTER_FALSE = 2;//注册失败
    public static final int REGISTER_DUPLICATE = 3;//注册失败，用户名重复

    final Logger logger = LoggerFactory.getLogger("myLogger");

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    public int userLogin(UserVo userVo, HttpSession session, HttpServletResponse response) {
        try {
            UserVo userByQuery = userMapper.findUserByName(userVo);
            if (userByQuery == null) {//判断是否找到了此用户
                throw new NameFalseException("用户名错误");
            } else if (!userByQuery.getPassword().equals(userVo.getPassword())) {//判断密码是否正确
                throw new PasswordFalseException("密码错误");
            }

            logger.info("{} 登陆成功", userVo.getName());
            holdSession(userVo, session, response);//保持会话
            return LOGIN_TRUE;

        } catch (NameFalseException e) {
            logger.info("{} 登陆失败, {}", userVo, e.toString());
            return LOGIN_NAME_FALSE;
        } catch (PasswordFalseException e) {
            logger.info("{} 登陆失败, {}", userVo, e.getMessage());
            return LOGIN_PASSWORD_FALSE;
        } catch (Exception e) {
            logger.warn("{} 登陆失败, {}", userVo, ExceptionUtils.getTrace(e));
            return LOGIN_FALSE;
        }
    }

    /**
     * 注册
     *
     * @param userVo
     * @return
     */
    public int userRegister(UserVo userVo, HttpSession session, HttpServletResponse response) {
        try {
            if (userMapper.findUserByName(userVo) != null) {//判断是否存在此用户
                throw new UserDuplicationException("注册的用户名已存在");
            }

            //注册
            userMapper.addUser(userVo);
            holdSession(userVo, session, response);//保持会话
            logger.info("{} 注册成功", userVo.getName());
            return REGISTER_TRUE;

        } catch (UserDuplicationException e) {
            logger.info("{} 注册失败, {}", userVo.getName(), e.getMessage());
            return REGISTER_DUPLICATE;
        } catch (Exception e) {
            logger.warn("{} 注册失败, {}", userVo.getName(), ExceptionUtils.getTrace(e));
            return REGISTER_FALSE;
        }
    }

    public int userLogout(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("generalUser");
        try {
            session.removeAttribute("generalUser");
            logger.info("{} 注销成功", userVo.getName());
            return LOGOUT_TRUE;
        } catch (Exception e) {
            logger.warn("{} 注销失败, {}", userVo.getName(), ExceptionUtils.getTrace(e));
            return LOGOUT_FALSE;
        }
    }

    /**
     * 保持会话状态
     *
     * @param userVo
     * @param session
     * @param response
     */
    private void holdSession(UserVo userVo, HttpSession session, HttpServletResponse response) {
        //登陆成功,保持会话
        session.setAttribute(userVo.getRole() == 1 ? "generalUser" : "adminUser", userVo);
        //持久化 session
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(300);
        response.addCookie(cookie);
    }
}
