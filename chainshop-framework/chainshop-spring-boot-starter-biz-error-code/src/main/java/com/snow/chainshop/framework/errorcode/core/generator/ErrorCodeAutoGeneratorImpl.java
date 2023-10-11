package com.snow.chainshop.framework.errorcode.core.generator;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.snow.chainshop.framework.common.exception.ErrorCode;
import com.snow.chainshop.module.system.api.errorcode.ErrorCodeApi;
import com.snow.chainshop.module.system.api.errorcode.dto.ErrorCodeAutoGenerateReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ErrorCodeAutoGenerator 的实现类
 * 目的是，扫描指定的 {@link #constantsClassList} 类，写入到 system 服务中
 *
 * @author dylan
 */
@RequiredArgsConstructor
@Slf4j
public class ErrorCodeAutoGeneratorImpl implements ErrorCodeAutoGenerator {

    /**
     * 应用分组
     */
    private final String applicationName;
    /**
     * 错误码枚举类
     */
    private final List<String> constantsClassList;
    /**
     * 错误码 Api
     */
    private final ErrorCodeApi errorCodeApi;

    @Override
    @EventListener(ApplicationReadyEvent.class)
    @Async // 异步，保证项目的启动过程，毕竟非关键流程
    public void execute() {
        // 第一步，解析错误码
        List<ErrorCodeAutoGenerateReqDTO> autoGenerateDTOs = parseErrorCode();
        log.info("[execute][解析到错误码数量为 ({}) 个]", autoGenerateDTOs.size());

        // 第二步，写入到 system 服务
        errorCodeApi.autoGenerateErrorCodeList(autoGenerateDTOs);
        log.info("[execute][写入到 system 组件完成]");
    }

    /**
     * 解析 constantsClassList 变量，转换成错误码数组
     *
     * @return 错误码数组
     */
    private List<ErrorCodeAutoGenerateReqDTO> parseErrorCode() {
        // 校验 errorCodeConstantsClass 参数
        if (CollUtil.isEmpty(constantsClassList)) {
            log.info("[execute][未配置 chainshop.error-code.constants-class-list 配置项，不进行自动写入到 system 服务中]");
            return new ArrayList<>();
        }

        // 解析错误码
        List<ErrorCodeAutoGenerateReqDTO> autoGenerateDTOs = new ArrayList<>();
        constantsClassList.forEach(constantsClass -> {
            try {
                // 解析错误码枚举类
                Class<?> errorCodeConstantsClazz = ClassUtil.loadClass(constantsClass);
                // 解析错误码
                autoGenerateDTOs.addAll(parseErrorCode(errorCodeConstantsClazz));
            } catch (Exception ex) {
                log.warn("[parseErrorCode][constantsClass({}) 加载失败({})]", constantsClass,
                        ExceptionUtil.getRootCauseMessage(ex));
            }
        });
        return autoGenerateDTOs;
    }

    /**
     * 解析错误码类，获得错误码数组
     *
     * @return 错误码数组
     */
    private List<ErrorCodeAutoGenerateReqDTO> parseErrorCode(Class<?> constantsClass) {
        List<ErrorCodeAutoGenerateReqDTO> autoGenerateDTOs = new ArrayList<>();
        Arrays.stream(constantsClass.getFields()).forEach(field -> {
            if (field.getType() != ErrorCode.class) {
                return;
            }
            // 转换成 ErrorCodeAutoGenerateReqDTO 对象
            ErrorCode errorCode = (ErrorCode) ReflectUtil.getFieldValue(constantsClass, field);
            autoGenerateDTOs.add(new ErrorCodeAutoGenerateReqDTO().setApplicationName(applicationName)
                    .setCode(errorCode.getCode()).setMessage(errorCode.getMsg()));
        });
        return autoGenerateDTOs;
    }

}

