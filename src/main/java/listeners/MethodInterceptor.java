package listeners;

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

        Map<String,String> test1 = new HashMap<>();
        test1.put("name","test1");
        test1.put("count","3");
        test1.put("priority","1");

        Map<String,String> test2 = new HashMap<>();
        test2.put("name","test2");
        test2.put("count","3");
        test2.put("priority","2");

        List<Map<String,String>> list1 = new ArrayList<>();
        list1.add(test1);
        list1.add(test2);

        for(int i =0; i<methods.size(); i++){
            for(int j=0;j<list1.size();j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list1.get(j).get("name"))){
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list1.get(j).get("count")));
                    methods.get(i).getMethod().setPriority(Integer.parseInt(list1.get(j).get("priority")));
                    result.add(methods.get(i));
                }
            }
        }
        return result;
    }
}
