package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Appeal;
import cn.itcast.service.AppealService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class AppealServiceImpl extends DaoSupport<Appeal> implements AppealService{

}
