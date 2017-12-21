package top.itning.hrms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.itning.hrms.dao.job.JobLevelDao;
import top.itning.hrms.dao.job.JobTitleDao;
import top.itning.hrms.entity.job.JobLevel;
import top.itning.hrms.entity.job.JobTitle;
import top.itning.hrms.service.JobService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 社会职称/级别服务实现类
 *
 * @author Ning
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class JobServiceImpl implements JobService {
    private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    private JobTitleDao jobTitleDao;

    @Autowired
    private JobLevelDao jobLevelDao;

    @Override
    @Cacheable(cacheNames = "JobTitleInfoList", key = "#key")
    public List<JobTitle> getAllJobTitleInfoList(String key) {
        logger.debug("getAllJobTitleInfoList::开始获取所有社会职称信息集合");
        return jobTitleDao.findAll();
    }

    @Override
    @Cacheable(cacheNames = "JobLevelInfoList", key = "#key")
    public List<JobLevel> getAllJobLevelInfoList(String key) {
        logger.debug("getAllJobLevelInfoList::开始获取所有职称级别信息集合");
        return jobLevelDao.findAll();
    }
}