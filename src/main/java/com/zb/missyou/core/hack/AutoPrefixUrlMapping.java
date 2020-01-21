package com.zb.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        // 获取之前的request信息
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if(mappingInfo != null) {
            String prefix = this.getPrefix(handlerType);
            // RequestMappingInfo.paths(prefix).build()这是前缀
            // combine(mappingInfo) 加上原来的
            RequestMappingInfo newMappingInfo = RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
            return newMappingInfo;
        }
        return mappingInfo;
    }

    private String getPrefix (Class<?> handlerType) {
        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName.replaceAll(this.apiPackagePath, "");
        return dotPath.replace(".", "/");
    }
}
