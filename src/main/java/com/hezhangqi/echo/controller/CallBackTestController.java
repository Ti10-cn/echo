package com.hezhangqi.echo.controller;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:57:53
 * @Description: 
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.hezhangqi.echo.annotation.CallBack;
import com.hezhangqi.echo.pojo.model.Recv001;
import com.hezhangqi.echo.pojo.vo.BaseResponse;
import com.hezhangqi.echo.service.CallBactTestService;

/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:57:53
 * @Description: 
 */
@RestController
public class CallBackTestController {
    @Autowired
    private CallBactTestService callBactTestService;
    
    @CallBack("test01")
    @PostMapping("/test01")
    public BaseResponse<String> test01(@RequestBody Recv001 recv001){
        int findAll = callBactTestService.findAll();
        return new BaseResponse<String>(recv001.getStatusEnum().getValue());
    }

    @PostMapping("/test02")
    public BaseResponse<String> test02(@RequestHeader HttpHeaders headers){
        return new BaseResponse<String>(headers.getHost().toString());
    }

    @PostMapping("/echo/test03")
    public String test03(@RequestBody @Validated Recv001 recv001 ){
        return recv001.getStatusEnum().getValue();
    }
    
}
