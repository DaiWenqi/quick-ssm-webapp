package ${package}.controller;

import ${package}.pojo.Demo;
import ${package}.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * DemoController
 * Created by xuzhuo on 2017/9/7.
 */
@Controller
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 查询列表
     * @param model
     * @return
     */
    @RequestMapping("showList")
    public String showList(Model model){
        List<Demo> demoList = demoService.queryDemoList();
        model.addAttribute("demoList", demoList);
        return "demo/demoList";
    }

    /**
     * 保存数据
     * @param demo
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public int saveDemo(@ModelAttribute Demo demo){
        return demoService.insertDemo(demo);
    }
}
