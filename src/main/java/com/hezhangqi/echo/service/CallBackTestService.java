package com.hezhangqi.echo.service;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:59:28
 * @Description: 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hezhangqi.echo.dao.Redhat001;
@Service
public class CallBackTestService {
    private final Redhat001 redhat001;

    public CallBackTestService(Redhat001 redhat001) {
        this.redhat001 = redhat001;
    }

    @Transactional(rollbackFor = Exception.class)
    public int findAll(){
        // throw new RuntimeException("测试异常");
        return redhat001.findByName();
    }
}
