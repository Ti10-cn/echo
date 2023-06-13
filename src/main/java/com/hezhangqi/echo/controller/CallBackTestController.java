package com.hezhangqi.echo.controller;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:57:53
 * @Description: 
 */


import com.hezhangqi.echo.service.CallBackTestService;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.hezhangqi.echo.annotation.TransCallBack;
import com.hezhangqi.echo.enums.datatype.ErrorEnum;
import com.hezhangqi.echo.exception.EchoException;
import com.hezhangqi.echo.pojo.model.Recv001;
import com.hezhangqi.echo.pojo.vo.BaseResponse;

/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2023-05-05 15:57:53
 * @Description: 
 */
@RestController
public class CallBackTestController {
    private final CallBackTestService callBackTestService;

    public CallBackTestController(CallBackTestService callBackTestService) {
        this.callBackTestService = callBackTestService;
    }

    @TransCallBack("test01")
    @PostMapping("/test01")
    public BaseResponse<String> test01(@RequestBody Recv001 recv001){
        int findAll = callBackTestService.findAll();
        return new BaseResponse<String>(recv001.getStatusEnum().getValue());
    }

    @PostMapping("/test02")
    public BaseResponse<String> test02(@RequestHeader HttpHeaders headers){
        return new BaseResponse<String>(headers.getHost().toString());
    }

    @PostMapping("/echo/test03")
    public String test03(@RequestBody @Validated Recv001 recv001 ){
        throw new EchoException(ErrorEnum.ERROR_0001);
    }
    
}
