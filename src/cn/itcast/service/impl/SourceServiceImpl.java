package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.Source;
import cn.itcast.service.SourceService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class SourceServiceImpl extends DaoSupport<Source> implements SourceService{

}
