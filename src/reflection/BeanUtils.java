package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    public static void assign (Object to, Object from) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodFrom = "get";
        String methodTo = "set";
        List<String> gettersFrom = getMethods(from.getClass(), methodFrom);
        List<String> settersTo = getMethods(to.getClass(), methodTo);
        gettersFrom.retainAll(settersTo);
        for (String methodName: gettersFrom) {
            Method getterFrom = from.getClass().getMethod(methodFrom.concat(methodName));
            Method setterTo = to.getClass().getMethod(methodTo.concat(methodName), getterFrom.getReturnType());
            setterTo.invoke(to, getterFrom.invoke(from));
        }
    }

    private static List<String> getMethods(Class<?> aClass, String methodName) {
        List<String> getters = new ArrayList<>();
        int beginIndex = methodName.length();
        for (Method method: aClass.getMethods()) {
            if (method.getName().substring(0, beginIndex).equals(methodName)) {
                getters.add(method.getName().substring(beginIndex));
            }
        }
        return getters;
    }
}
