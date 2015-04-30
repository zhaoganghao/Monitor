package cn.itcast.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.NoContent;
import cn.itcast.service.NoContentService;
import cn.itcast.service.base.DaoSupport;
@Service
@Transactional
public class NoContentServiceImpl extends DaoSupport<NoContent> implements NoContentService{

}
