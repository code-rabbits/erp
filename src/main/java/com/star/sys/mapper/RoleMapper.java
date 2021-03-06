package com.star.sys.mapper;

import com.star.sys.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Njq
 * @since 2021-08-12
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 删除角色用户关系表的数据
     * @param id
     */
    @Delete("delete from sys_role_user where rid = #{id}")
    void deleteRoleUserByRoleId(Serializable id);

    /**
     * 删除角色权限关系表的数据
     * @param id
     */
    @Delete("delete from sys_role_permission where rid = #{id}")
    void deleteRolePermissionByRoleId(Serializable id);

    /**
     * 增加一个权限
     * @param rid
     * @param pid
     */
    @Insert("insert into sys_role_permission(rid,pid) values(#{rid},#{pid})")
    void insertRolePermission(@Param("rid") int rid, @Param("pid") String pid);


    /**
     * 根据角色ID查询该角色拥有的权限菜单id
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select pid from sys_role_permission where rid=#{roleId}")
    Set<Integer> findRolePermissionByRoleId(Integer roleId) throws Exception;
}
