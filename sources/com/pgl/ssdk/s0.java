package com.pgl.ssdk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    private static Method f40249a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f40250b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f40251c;

    static {
        try {
            f40249a = Class.class.getDeclaredMethod("forName", String.class);
            f40250b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f40251c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object a(Object obj, Class cls, String str, Object obj2) {
        try {
            Field a11 = a(cls, str);
            if (a11 == null) {
                return obj2;
            }
            a11.setAccessible(true);
            return a11.get(obj);
        } catch (Throwable unused) {
            return obj2;
        }
    }

    public static Object a(Object obj, Class cls, String str, Class[] clsArr, Object... objArr) {
        try {
            Method a11 = a(cls, str, clsArr);
            if (a11 != null) {
                return a11.invoke(obj, objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Field a(Class cls, String str) {
        if (!a()) {
            return null;
        }
        try {
            Field field = (Field) f40251c.invoke(cls, str);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Method a(Class cls, String str, Class[] clsArr) {
        if (!a()) {
            return null;
        }
        try {
            Method method = (Method) f40250b.invoke(cls, str, clsArr);
            try {
                method.setAccessible(true);
            } catch (Throwable unused) {
            }
            return method;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean a() {
        return (f40249a == null || f40250b == null || f40251c == null) ? false : true;
    }
}
