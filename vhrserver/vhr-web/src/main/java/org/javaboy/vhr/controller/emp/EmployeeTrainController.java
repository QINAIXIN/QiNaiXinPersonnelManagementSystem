package org.javaboy.vhr.controller.emp;


import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeeTrainService;
import org.javaboy.vhr.model.vo.EmployeeTrainReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 员工培训操作类
 */
@RestController
@RequestMapping("/employee/train")
public class EmployeeTrainController {

    @Autowired
    private EmployeeTrainService employeeTrainService;


    /**
     * 分页
     * @return
     */
    @GetMapping("/list")
    public RespBean list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        RespPageBean pageBean =  employeeTrainService.list(page,size);
        return RespBean.ok("查询成功",pageBean);
    }


    /**
     * 保存数据
     * @param employeeTrainReqVo
     * @return
     */
    @PostMapping("/add")
    public RespBean add(@RequestBody Employeetrain employeeTrainReqVo){
        employeeTrainService.add(employeeTrainReqVo);
        return RespBean.ok("新增成功");
    }

    /**
     * 保存数据
     * @param employeeTrainReqVo
     * @return
     */
    @PutMapping("/update")
    public RespBean update(@RequestBody EmployeeTrainReqVo employeeTrainReqVo){
        employeeTrainService.update(employeeTrainReqVo);
        return RespBean.ok("修改成功");
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public RespBean delete(@PathVariable("id") Integer id){
        employeeTrainService.delete(id);
        return RespBean.ok("删除成功");
    }

}
