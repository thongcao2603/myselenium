package org.example.listeners;

import org.example.utils.ExcelUtils;
import org.example.utils.MyUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();

        List<Map<String, String>> list = ExcelUtils.getTestDetails("RUNMANAGER");

        for(int i =0; i<methods.size(); i++){
            for(int j=0;j<list.size();j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))){
                    if(list.get(j).get("execute").equalsIgnoreCase("yes")){
                        methods.get(i).getMethod().setDescription(list.get(j).get("description"));
                        methods.get(i).getMethod().setInvocationCount((Integer) MyUtils.convertToNumeric(list.get(j).get("count")));
                        methods.get(i).getMethod().setPriority((Integer) MyUtils.convertToNumeric(list.get(j).get("priority")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        return result;
    }
}