package com.cloud.tmc.kernel.utils;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ReflectUtils {
    private static final Map<String, Method> sMethods = new ConcurrentHashMap();

    private static boolean equalsParamTypes(Class<?>[] clsArr, String[] strArr) {
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (!TextUtils.equals(clsArr[i11].getName(), strArr != null ? strArr[i11] : null)) {
                return false;
            }
        }
        return true;
    }

    public static Method findMethod(Class cls, String str, String[] strArr) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                if (method.getParameterTypes().length == (strArr != null ? strArr.length : 0) && equalsParamTypes(method.getParameterTypes(), strArr)) {
                    return method;
                }
            }
        }
        return null;
    }

    public static Object getDefaultValue(Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Boolean.FALSE;
        }
        if (cls == Void.TYPE) {
            return null;
        }
        return (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) ? 0 : null;
    }

    public static Object getField(Object obj, String str, Object obj2) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field declaredField = (obj instanceof Class ? (Class) obj : Class.forName(String.valueOf(obj))).getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Method getMethod(java.lang.Class<?> r6, java.lang.String r7, java.lang.Class[] r8) throws java.lang.NoSuchMethodException {
        /*
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = "."
            java.lang.String r0 = r0.concat(r1)
            java.lang.String r0 = r0.concat(r7)
            r1 = 1
            if (r8 == 0) goto L41
            int r2 = r8.length
            if (r2 <= 0) goto L41
            java.lang.String r2 = "("
            java.lang.String r0 = r0.concat(r2)
            int r2 = r8.length
            r3 = 0
            r4 = r3
        L1d:
            if (r4 >= r2) goto L32
            r5 = r8[r4]
            java.lang.String r5 = r5.getName()
            java.lang.String r0 = r0.concat(r5)
            java.lang.String r5 = ","
            java.lang.String r0 = r0.concat(r5)
            int r4 = r4 + 1
            goto L1d
        L32:
            int r2 = r0.length()
            int r2 = r2 - r1
            java.lang.String r0 = r0.substring(r3, r2)
            java.lang.String r2 = ")"
            java.lang.String r0 = r0.concat(r2)
        L41:
            r2 = 0
            java.util.Map<java.lang.String, java.lang.reflect.Method> r3 = com.cloud.tmc.kernel.utils.ReflectUtils.sMethods     // Catch: java.lang.Throwable -> L51
            boolean r4 = r3.containsKey(r0)     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L51
            java.lang.Object r3 = r3.get(r0)     // Catch: java.lang.Throwable -> L51
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch: java.lang.Throwable -> L51
            goto L52
        L51:
            r3 = r2
        L52:
            if (r3 != 0) goto L69
            if (r8 != 0) goto L5c
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r2)
        L5a:
            r3 = r6
            goto L61
        L5c:
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)
            goto L5a
        L61:
            r3.setAccessible(r1)
            java.util.Map<java.lang.String, java.lang.reflect.Method> r6 = com.cloud.tmc.kernel.utils.ReflectUtils.sMethods
            r6.put(r0, r3)
        L69:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.kernel.utils.ReflectUtils.getMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Object invokeMethod(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method method = getMethod(cls, str, clsArr);
        return objArr == null ? method.invoke(obj, null) : method.invoke(obj, objArr);
    }

    public static Object invokeMethod(Class cls, String str) throws Exception {
        return invokeMethod(cls, (Object) null, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeMethod(Object obj, String str) throws Exception {
        return invokeMethod(obj.getClass(), obj, str, (Class[]) null, (Object[]) null);
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(Class.forName(str), obj, str2, clsArr, objArr);
    }

    public static Object invokeMethod(String str, String str2) throws Exception {
        return invokeMethod(Class.forName(str), (Object) null, str2, (Class[]) null, (Object[]) null);
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(cls, (Object) null, str, clsArr, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object[] objArr) throws Exception {
        return invokeMethod(Class.forName(str), (Object) null, str2, clsArr, objArr);
    }
}
