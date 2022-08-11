package com.kuang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.reggie.entity.Employee;
import com.kuang.reggie.mapper.EmployeeMapper;
import com.kuang.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
//继承父类，实现父接口（MyBatis-Plus规范）
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
