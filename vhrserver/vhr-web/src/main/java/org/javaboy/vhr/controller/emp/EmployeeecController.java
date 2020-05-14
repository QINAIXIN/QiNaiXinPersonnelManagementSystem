package org.javaboy.vhr.controller.emp;


import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeeecService;
import org.javaboy.vhr.model.vo.EmployeeecReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/employeeec")
public class EmployeeecController {

    @Autowired
    private EmployeeecService employeeecService;


    @GetMapping("/list")
    public RespBean list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        RespPageBean pageBean =  employeeecService.list(page,size);
        return RespBean.ok("查询成功",pageBean);
    }


    /**
     * 保存数据
     * @param employeeecReqVo
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody EmployeeecReqVo employeeecReqVo){
        employeeecService.add(employeeecReqVo);
        return RespBean.ok("新增成功");
    }

    /**
     * 保存数据
     * @param employeeecReqVo
     * @return
     */
    @PutMapping("/update")
    public RespBean update(@RequestBody EmployeeecReqVo employeeecReqVo){
        employeeecService.update(employeeecReqVo);
        return RespBean.ok("修改成功");
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public RespBean delete(@PathVariable("id") Integer id){
        employeeecService.delete(id);
        return RespBean.ok("删除成功");
    }

}
