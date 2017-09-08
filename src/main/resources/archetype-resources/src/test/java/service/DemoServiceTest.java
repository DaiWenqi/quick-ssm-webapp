package ${package}.service;

import ${package}.pojo.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * DemoServiceTest
 * Created by xuzhuo on 2017/9/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
@WebAppConfiguration
public class DemoServiceTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DemoService demoService;


    @Test
    public void insertDemo() throws Exception {
        Demo demo = new Demo();
        demo.setName("inserDemo");
        int num = demoService.insertDemo(demo);
        Assert.assertEquals(num, 1);
    }

    @Test
    @Transactional
    @Rollback
    public void insertDemoRollback() throws Exception{
        Demo demo = new Demo();
        demo.setName("inserDemo");
        demoService.insertDemo(demo);
        System.out.println(demo.getId());
    }

    @Test
    public void queryDemoList() throws Exception {
        List<Demo> demoList = demoService.queryDemoList();
        Assert.assertNotEquals(demoList.size(), 0);
    }

    @Test
    public void queryDemoById() throws Exception {
        Demo demo = demoService.queryDemoById(1);
        Assert.assertNotNull(demo);
        demo = demoService.queryDemoById(Integer.MAX_VALUE);
        Assert.assertNull(demo);
    }

    @Test
    public void updateDemo() throws Exception {
        int num = demoService.updateDemo(3, "test");
        Assert.assertEquals(num, 1);
    }

    @Test
    public void updateDemoWithTranscationl() throws Exception {
    }
}