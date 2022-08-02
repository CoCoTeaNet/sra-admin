package com.sraapp.schedule.service.impl;

import com.sraapp.schedule.job.MeaninglessDataJob;
import com.sraapp.schedule.service.IJobConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JobConfigServiceImpl implements IJobConfigService {
    @Resource
    private MeaninglessDataJob meaninglessDataJob;

    @Override
    public void setCorn(String corn) {
        meaninglessDataJob.setCorn(corn);
    }
}
