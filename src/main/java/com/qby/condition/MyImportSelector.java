package com.qby.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author qby
 * @date 2020/6/9 17:53
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值 就是导入到容器中的组件的全类名
     *
     * @param importingClassMetadata 当前标注的@import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 方法不返回null
        return new String[]{"com.qby.beans.Blue", "com.qby.beans.Yellow"};
    }

}
