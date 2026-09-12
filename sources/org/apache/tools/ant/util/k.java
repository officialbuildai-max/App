package org.apache.tools.ant.util;

/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final d f71713a = d.k();

    public static ClassLoader a() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static boolean b() {
        return true;
    }

    public static void c(ClassLoader classLoader) {
        Thread.currentThread().setContextClassLoader(classLoader);
    }
}
