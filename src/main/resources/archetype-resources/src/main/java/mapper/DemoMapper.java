package ${package}.mapper;

import ${package}.pojo.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DemoMapper
 * Created by xuzhuo on 2017/9/7.
 */
public interface DemoMapper {
    /**
     * 查询所有数据
     * @return
     */
    List<Demo> queryDemoList();

    /**
     * 通过ID查询数据
     * @param id
     * @return
     */
    Demo queryDemoById(Integer id);

    /**
     * 新增数据
     * @param demo
     * @return
     */
    int insertDemo(Demo demo);

    /**
     * 更新数据
     * @param id
     * @param name
     * @return
     */
    int updateDemo(@Param("id") Integer id, @Param("name") String name);
}
