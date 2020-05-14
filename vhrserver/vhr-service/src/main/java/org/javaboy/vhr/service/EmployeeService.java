package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.RespPageBean;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope);

    Integer addEmp(Employee employee);

    Integer maxWorkID();

    Integer deleteEmpByEid(Integer id);

    public Integer updateEmp(Employee employee);

    Integer addEmps(List<Employee> list);

    RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size);

    Integer updateEmployeeSalaryById(Integer eid, Integer sid);

    Employee getEmployeeById(Integer empId);
}
