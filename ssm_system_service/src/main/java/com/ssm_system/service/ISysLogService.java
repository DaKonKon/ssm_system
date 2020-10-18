package com.ssm_system.service;

import com.ssm_system.domain.Syslog;
import com.ssm_system.service.impl.SysLogServiceImpl;

import java.util.List;

public interface ISysLogService {
    void save(Syslog syslog) throws Exception;

    List<Syslog> findAll() throws Exception;
}
