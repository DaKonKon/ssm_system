package com.ssm_system.service.impl;

import com.ssm_system.dao.ISysLogDao;
import com.ssm_system.domain.Syslog;
import com.ssm_system.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    ISysLogDao sysLogDao;
    @Override
    public void save(Syslog syslog) throws Exception {
        sysLogDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll() throws Exception {
        List<Syslog> syslogs = sysLogDao.findAll();
        return syslogs;
    }
}
