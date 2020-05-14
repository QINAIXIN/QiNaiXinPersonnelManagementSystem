package org.javaboy.vhr.controller.emp;


import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.AppraiseService;
import org.javaboy.vhr.model.vo.AppraiseReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 员工好评表
 */
@RestController
@RequestMapping("/employee/appraise")
public class AppraiseController {

    @Autowired
    private AppraiseService appraiseService;


    @GetMapping("/list")
    public RespBean list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        RespPageBean pageBean =  appraiseService.list(page,size);
        return RespBean.ok("查询成功",pageBean);
    }


    /**
     * 保存数据
     * @param appraiseReqVo
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody AppraiseReqVo appraiseReqVo){
        appraiseService.add(appraiseReqVo);
        return RespBean.ok("新增成功");
    }

    /**
     * 保存数据
     * @param appraiseReqVo
     * @return
     */
    @PutMapping("/update")
    public RespBean update(@RequestBody AppraiseReqVo appraiseReqVo){
        appraiseService.update(appraiseReqVo);
        return RespBean.ok("修改成功");
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public RespBean delete(@PathVariable("id") Integer id){
        appraiseService.delete(id);
        return RespBean.ok("删除成功");
    }

}
