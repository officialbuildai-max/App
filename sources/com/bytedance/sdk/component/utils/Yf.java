package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.transsion.gslb.Utils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Yf {
    public static final Class<?>[] Sj;
    private static final HashMap<Class<?>, Class<?>> TKC;
    private static Map<String, Method> sP = new HashMap();

    static {
        HashMap<Class<?>, Class<?>> hashMap = new HashMap<>();
        TKC = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        hashMap.put(Void.TYPE, Void.class);
        Sj = new Class[0];
    }

    public static int Sj(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int Sj(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Object Sj(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return Sj(obj, str, objArr, Sj(objArr));
    }

    public static Object Sj(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method Sj2 = Sj(obj.getClass(), str, clsArr);
        if (Sj2 != null) {
            return Sj2.invoke(obj, objArr);
        }
        throw new NoSuchMethodException(str);
    }

    public static Method Sj(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String sP2 = sP(cls, str, clsArr);
        synchronized (sP) {
            method = sP.get(sP2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z10 = true;
                                for (int i11 = 0; i11 < clsArr.length; i11++) {
                                    if (!Sj(clsArr[i11], parameterTypes[i11])) {
                                        z10 = false;
                                    }
                                }
                                if (z10) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (sP) {
                    sP.put(sP2, method);
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static boolean Sj(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = TKC.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = TKC.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Class<?>[] Sj(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return Sj;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            clsArr[i11] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }

    private static String sP(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.toString());
        sb2.append(Utils.SEPARATOR);
        sb2.append(str);
        sb2.append(Utils.SEPARATOR);
        sb2.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr == null || clsArr.length <= 0) {
            sb2.append(Void.class.toString());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb2.append(cls2.toString());
                sb2.append(Utils.SEPARATOR);
            }
        }
        return sb2.toString();
    }
}
