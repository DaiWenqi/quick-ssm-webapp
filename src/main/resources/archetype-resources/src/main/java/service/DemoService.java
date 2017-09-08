package ${package}.service;

import ${package}.mapper.DemoMapper;
import ${package}.pojo.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DemoService
 * Created by xuzhuo on 2017/9/7.
 */
@Service
public class DemoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private DemoMapper demoMapper;

    /**
     * 查询列表
     * @return
     */
    public List<Demo> queryDemoList() {
        LOGGER.info("查询列表");
        List<Demo> demoList = demoMapper.queryDemoList();
        LOGGER.info("查询结果数量：{}", demoList.size());
        return demoList;
    }

    /**
     * 通过ID查询数据
     * @param id
     * @return
     */
    public Demo queryDemoById(Integer id) {
        LOGGER.info("通过ID[{}]查询", id);
        Demo demo = demoMapper.queryDemoById(id);
        LOGGER.info("通过ID查询完成");
        return demo;
    }

    /**
     * 更新数据
     * @param id
     * @param name
     * @return
     */
    public int updateDemo(Integer id, String name) {
        LOGGER.info("通过ID[{}]更新数据为[{}]", id, name);
        int num = demoMapper.updateDemo(id, name);
        LOGGER.info("更新数据结果：{}", num);
        return num;
    }

    /**
     * 更新事务回滚测试
     * @param id
     * @param name
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateDemoWithTranscationl(Integer id, String name) {
        LOGGER.info("通过ID[{}]更新数据为[{}]", id, name);
        int num = demoMapper.updateDemo(id, name);
        //测试事务是否生效
        int i = 1 / 0;
        LOGGER.info("更新数据结果：{}", num);
        return num;
    }

    /**
     * 新增数据
     * @param demo
     * @return
     */
    public int insertDemo(Demo demo) {
        LOGGER.info("新增数据");
        int num = demoMapper.insertDemo(demo);
        LOGGER.info("更新数据结果：{}", num);
        return num;
    }
}
