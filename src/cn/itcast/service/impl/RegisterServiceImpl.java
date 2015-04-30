package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Register;
import cn.itcast.service.RegisterService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class RegisterServiceImpl extends DaoSupport<Register> implements RegisterService{

}
