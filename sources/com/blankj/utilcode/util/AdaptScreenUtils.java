package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AdaptScreenUtils {

    /* renamed from: a, reason: collision with root package name */
    private static List f20085a;

    private static void b(Resources resources, float f11) {
        resources.getDisplayMetrics().xdpi = f11;
        Utils.a().getResources().getDisplayMetrics().xdpi = f11;
        d(resources, f11);
    }

    private static void c(Resources resources, float f11) {
        Iterator it = f20085a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) ((Field) it.next()).get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f11;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private static void d(Resources resources, float f11) {
        if (f20085a != null) {
            c(resources, f11);
            return;
        }
        f20085a = new ArrayList();
        Class<?> cls = resources.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics e11 = e(resources, field);
                    if (e11 != null) {
                        f20085a.add(field);
                        e11.xdpi = f11;
                    }
                }
            }
            cls = cls.getSuperclass();
            if (cls == null) {
                return;
            } else {
                declaredFields = cls.getDeclaredFields();
            }
        }
    }

    private static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable f() {
        return new Runnable() { // from class: com.blankj.utilcode.util.AdaptScreenUtils.1
            @Override // java.lang.Runnable
            public void run() {
                AdaptScreenUtils.g();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
