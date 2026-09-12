package com.apm.insight.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f19628a;

    /* renamed from: com.apm.insight.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0186a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f19629a;

        /* renamed from: b, reason: collision with root package name */
        public final T f19630b;
    }

    static {
        HashMap hashMap = new HashMap();
        f19628a = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        Class cls2 = Byte.TYPE;
        hashMap.put(Byte.class, cls2);
        Class cls3 = Character.TYPE;
        hashMap.put(Character.class, cls3);
        Class cls4 = Short.TYPE;
        hashMap.put(Short.class, cls4);
        Class cls5 = Integer.TYPE;
        hashMap.put(Integer.class, cls5);
        Class cls6 = Float.TYPE;
        hashMap.put(Float.class, cls6);
        Class cls7 = Long.TYPE;
        hashMap.put(Long.class, cls7);
        Class cls8 = Double.TYPE;
        hashMap.put(Double.class, cls8);
        hashMap.put(cls, cls);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        hashMap.put(cls5, cls5);
        hashMap.put(cls6, cls6);
        hashMap.put(cls7, cls7);
        hashMap.put(cls8, cls8);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        Method method;
        Class<?>[] parameterTypes;
        try {
            Class<?> cls = Class.forName(str);
            Class<?>[] clsArr = new Class[4];
            for (int i11 = 0; i11 < 4; i11++) {
                Object obj = objArr[i11];
                clsArr[i11] = (obj == null || !(obj instanceof C0186a)) ? obj == null ? null : obj.getClass() : ((C0186a) obj).f19629a;
            }
            while (true) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i12];
                    if (method.getName().equals(str2) && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 4) {
                        for (int i13 = 0; i13 < parameterTypes.length; i13++) {
                            if (!parameterTypes[i13].isAssignableFrom(clsArr[i13])) {
                                Map<Class<?>, Class<?>> map = f19628a;
                                if (map.containsKey(parameterTypes[i13]) && map.get(parameterTypes[i13]).equals(map.get(clsArr[i13]))) {
                                }
                            }
                        }
                        break;
                    }
                    i12++;
                }
                if (method != null) {
                    method.setAccessible(true);
                    Object[] objArr2 = new Object[4];
                    for (int i14 = 0; i14 < 4; i14++) {
                        Object obj2 = objArr[i14];
                        if (obj2 == null || !(obj2 instanceof C0186a)) {
                            objArr2[i14] = obj2;
                        } else {
                            objArr2[i14] = ((C0186a) obj2).f19630b;
                        }
                    }
                    return (T) method.invoke(null, objArr2);
                }
                if (cls.getSuperclass() == null) {
                    throw new NoSuchMethodException();
                }
                cls = cls.getSuperclass();
            }
        } catch (Exception e11) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e11);
            return null;
        }
    }
}
