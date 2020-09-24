package com.example.order.service.impl;

import com.example.order.exception.AddUserException;
import com.example.order.mapper.GSysManageMapper;
import com.example.order.service.ManageService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.order.entity.GSysManage;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService {

    protected static final Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);

    @Autowired
    private GSysManageMapper  gSysManageMapper;

    @Override
    public GSysManage getInfo(@Param("objId")Long objId,@Param("type")String type) {
        GSysManage gSysManage = null;
        try {
            gSysManage = gSysManageMapper.getInfo(objId, type);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return gSysManage;
    }

    @Override
    public List<GSysManage> getList(@Param("type")String type,@Param("searchContent")String searchContent) {
        return gSysManageMapper.getList(type,searchContent);

    }

    @Override
    public void addInfo(GSysManage gSysManage) throws AddUserException {
        try {
            gSysManageMapper.insertSelective(gSysManage);
        } catch (Exception e) {
            logger.error("新增失败!");
            throw new AddUserException("新增失败");
        }
    }

    @Override
    public void updateList(GSysManage gSysManage) {
        try {
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }


    @Override
    public void doDelete(String objId) {
        try {
            gSysManageMapper.updateIsdelByOId(objId);
        } catch (Exception e) {
            logger.error("修改失败!");
            throw new AddUserException("修改失败");
        }
    }

    @Override
    public List<GSysManage> getManageList(String type, String searchContent) {

        return null;
    }

    @Override
    public Map<String, Object> getManageInfo(Long objId, String type) {
        /*Long readNum = gSysManage.getReadnum();
        gSysManage.setReadnum(readNum + 1);
        gSysManageMapper.updateByPrimaryKeySelective(gSysManage);*/
        return null;
    }

    @Override
    public boolean reviewById(Long objId,String exaId,String remark) {
        try {
            GSysManage gSysManage = gSysManageMapper.selectByPrimaryKey(objId);

            gSysManage.setExamineStatus(exaId);
            gSysManage.setRemark(remark);
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
    @Override
    public boolean releaseById(Long objId) {
        try {
            GSysManage gSysManage = gSysManageMapper.selectByPrimaryKey(objId);
            Date date = new Date();
            gSysManage.setReleasetime(date);
            gSysManage.setReleaseStatus("1");
            gSysManageMapper.updateByPrimaryKeySelective(gSysManage);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }
}
