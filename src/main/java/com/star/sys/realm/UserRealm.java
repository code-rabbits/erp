package com.star.sys.realm;

import com.star.sys.pojo.User;
import com.star.sys.service.UserService;
import com.star.sys.vo.LoginUserVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * 自定义 Realm
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取当前登录主体
       String userName = (String) authenticationToken.getPrincipal();
        try {
            //根据用户名查询用户信息的方法
            User user = userService.findUserByUserName(userName);
            //对象不为空
            if(user!=null){
                //创建当前登录用户对象
                //创建登录用户对象，传入用户信息，角色列表，权限列表
                LoginUserVo loginUserVo = new LoginUserVo(user,null,null);
                //创建盐值(以用户名作为盐值)
                ByteSource salt = ByteSource.Util.bytes(user.getSalt());
                //创建身份验证对象
                //参数1：当前登录对象  参数2：密码  参数3：盐值 参数4：域名
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(loginUserVo,user.getLoginpwd(),salt,"");
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //验证失败
        return null;
    }
}
