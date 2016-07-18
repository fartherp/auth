package cn.vansky.auth.dao.dbunit;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2016/2/4
 */
public class DBUnitExecutionListener extends AbstractTestExecutionListener {
    public void beforeTestMethod(TestContext testContext) throws Exception {
        Object testInstance = testContext.getTestInstance();
        Method testMethod = testContext.getTestMethod();
        Class<?> testClass = testContext.getTestClass();
        if (testInstance instanceof BaseBusinessTestCase) {
            UseDbUnit annotation = testMethod.getAnnotation(UseDbUnit.class);
            if (annotation == null) {
                annotation = testClass.getAnnotation(UseDbUnit.class);
            }
            if (annotation != null) {
                String[] tables = annotation.tables();
                /*
                 * if(tables==null||tables.length==0){ tables = new String[1];
                 * tables[0] = BaseBusinessTestCase.ALL_TABLES; }
                 */
                String fileType = annotation.fileType();
                ((BaseBusinessTestCase) testInstance).beforeForDBUnit(fileType, tables);
            }
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        Object testInstance = testContext.getTestInstance();
        Method testMethod = testContext.getTestMethod();
        Class<?> testClass = testContext.getTestClass();
        if (testInstance instanceof BaseBusinessTestCase) {
            UseDbUnit annotation = testMethod.getAnnotation(UseDbUnit.class);
            if (annotation == null) {
                annotation = testClass.getAnnotation(UseDbUnit.class);
            }
            if (annotation != null) {
                String[] tables = annotation.tables();
                /*
                 * if(tables==null||tables.length==0){ tables = new String[1];
                 * tables[0] = BaseBusinessTestCase.ALL_TABLES; }
                 */
                String fileType = annotation.fileType();
                ((BaseBusinessTestCase) testInstance).afterForDBUnit(fileType, tables);
            }
        }
    }
}
