package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.dynamite.b;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.DelegateLastClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
final class NewClassLoaderInjector {
    private NewClassLoaderInjector() {
        throw new UnsupportedOperationException();
    }

    @SuppressLint({"NewApi"})
    private static ClassLoader createNewClassLoader(ClassLoader classLoader, File file, boolean z10, boolean z11, String... strArr) throws Throwable {
        ClassLoader tinkerClassLoader;
        Object obj = findField(Class.forName("dalvik.system.BaseDexClassLoader", false, classLoader), "pathList").get(classLoader);
        StringBuilder sb2 = new StringBuilder();
        if (strArr != null && strArr.length > 0) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (i11 > 0) {
                    sb2.append(File.pathSeparator);
                }
                sb2.append(strArr[i11]);
            }
        }
        String sb3 = sb2.toString();
        Field findField = findField(obj.getClass(), "nativeLibraryDirectories");
        List<File> asList = findField.getType().isArray() ? Arrays.asList((File[]) findField.get(obj)) : (List) findField.get(obj);
        StringBuilder sb4 = new StringBuilder();
        boolean z12 = true;
        for (File file2 : asList) {
            if (file2 != null) {
                if (z12) {
                    z12 = false;
                } else {
                    sb4.append(File.pathSeparator);
                }
                sb4.append(file2.getAbsolutePath());
            }
        }
        String sb5 = sb4.toString();
        if (!z10 || !ShareTinkerInternals.isNewerOrEqualThanVersion(27, true)) {
            tinkerClassLoader = new TinkerClassLoader(sb3, file, sb5, classLoader);
        } else if (ShareTinkerInternals.isNewerOrEqualThanVersion(31, true)) {
            tinkerClassLoader = a.a(sb3, sb5, classLoader);
        } else {
            b.a();
            DelegateLastClassLoader a11 = a.a(sb3, sb5, ClassLoader.getSystemClassLoader());
            Field declaredField = ClassLoader.class.getDeclaredField("parent");
            declaredField.setAccessible(true);
            declaredField.set(a11, classLoader);
            tinkerClassLoader = a11;
        }
        if (z11 && !ShareTinkerInternals.isNewerOrEqualThanVersion(26, true)) {
            findField(obj.getClass(), "definingContext").set(obj, tinkerClassLoader);
        }
        return tinkerClassLoader;
    }

    private static void doInject(Application application, ClassLoader classLoader) throws Throwable {
        Thread.currentThread().setContextClassLoader(classLoader);
        Context context = (Context) findField(application.getClass(), "mBase").get(application);
        try {
            findField(context.getClass(), "mClassLoader").set(context, classLoader);
        } catch (Throwable unused) {
        }
        Object obj = findField(context.getClass(), "mPackageInfo").get(context);
        findField(obj.getClass(), "mClassLoader").set(obj, classLoader);
        Resources resources = application.getResources();
        try {
            findField(resources.getClass(), "mClassLoader").set(resources, classLoader);
        } catch (Throwable unused2) {
        }
        try {
            Object obj2 = findField(resources.getClass(), "mDrawableInflater").get(resources);
            if (obj2 != null) {
                findField(obj2.getClass(), "mClassLoader").set(obj2, classLoader);
            }
        } catch (Throwable unused3) {
        }
    }

    private static Field findField(Class<?> cls, String str) throws Throwable {
        Class<?> cls2 = cls;
        while (true) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable unused) {
                if (cls2 == Object.class) {
                    throw new NoSuchFieldException("Cannot find field " + str + " in class " + cls.getName() + " and its super classes.");
                }
                cls2 = cls2.getSuperclass();
            }
        }
    }

    public static ClassLoader inject(Application application, ClassLoader classLoader, File file, boolean z10, List<File> list) throws Throwable {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = list.get(i11).getAbsolutePath();
        }
        ClassLoader createNewClassLoader = createNewClassLoader(classLoader, file, z10, true, strArr);
        doInject(application, createNewClassLoader);
        return createNewClassLoader;
    }

    public static ClassLoader triggerDex2Oat(Context context, File file, boolean z10, String... strArr) throws Throwable {
        return createNewClassLoader(context.getClassLoader(), file, z10, false, strArr);
    }
}
