package com.guanshan.phoenix.service.imp;

import com.guanshan.phoenix.Util.Utility;
import com.guanshan.phoenix.cloudwareDomain.ResCloudware;
import com.guanshan.phoenix.dao.entity.Cloudware;
import com.guanshan.phoenix.dao.entity.Course;
import com.guanshan.phoenix.dao.entity.Experiment;
import com.guanshan.phoenix.dao.entity.Module;
import com.guanshan.phoenix.dao.mapper.*;
import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.service.CloudwareService;
import com.guanshan.phoenix.webdomain.request.ReqDeleteCloudware;
import com.guanshan.phoenix.webdomain.request.ReqStudentExperiment;
import com.guanshan.phoenix.webdomain.response.ResExperimentInfo;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/10/19.
 */
@Service
public class CloudwareServiceImp implements CloudwareService {

    static Logger log = Logger.getLogger(CloudwareServiceImp.class.getName());

    @Value("${cloudware.deleteCloudwareUrl}")
    private String deleteCloudwareUrl;

    @Autowired
    private StudentExperimentMapper studentExperimentMapper;

    @Autowired
    private CloudwareMapper cloudwareMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String getStudentExperiment(ReqStudentExperiment reqStudentExperiment) throws ApplicationErrorException {

        int cloudwareId = studentExperimentMapper.selectCloudwareIdByStudentIdAndExperimentId(reqStudentExperiment.getStudentId(), reqStudentExperiment.getExperimentId());

        return cloudwareMapper.selectWebSocketById(cloudwareId);
    }

    @Override
    public ResExperimentInfo getExperiment(int id) throws ApplicationErrorException{


        Experiment experiment = experimentMapper.selectByPrimaryKey(id);
        Module module = moduleMapper.selectByPrimaryKey(experiment.getModuleId());
        Course course = courseMapper.selectByPrimaryKey(module.getCourseId());

        ResExperimentInfo resExperiment = new ResExperimentInfo(experiment);

        resExperiment.setCourseName(course.getName());
        resExperiment.setModuleName(module.getName());

        return resExperiment;
    }

    @Override
    public void deleteCloudware(int cloudwareId) {
        log.info(String.format("Start to delete cloudware for cloudware id %d...", cloudwareId));

        Cloudware cloudware = cloudwareMapper.selectByPrimaryKey(cloudwareId);
        ReqDeleteCloudware reqDeleteCloudware = new ReqDeleteCloudware(cloudware);

        try {
            ResCloudware resCloudware = restTemplate.postForObject(deleteCloudwareUrl, reqDeleteCloudware, ResCloudware.class);
            if (resCloudware.getErrorCode() != 0) {
                log.error(String.format("Deleting cloudware failed. Error code returned %d.", resCloudware.getErrorCode()));
            } else {
                log.info("delete cloudware succeeded.");
            }
        } catch (RestClientException e) {
            //swallow the exception, because the cloudware may have been deleted
            log.error(String.format("delete cloudware failed."));
            log.log(Level.ERROR, e.getMessage(), e);
        }

        cloudwareMapper.deleteByPrimaryKey(cloudwareId);
    }
}
