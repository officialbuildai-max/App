package org.lsposed.hiddenapibypass;

import android.util.Log;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f72046a;

    /* renamed from: b, reason: collision with root package name */
    private static final long f72047b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f72048c;

    /* renamed from: d, reason: collision with root package name */
    private static final long f72049d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f72050e;

    /* renamed from: f, reason: collision with root package name */
    private static final long f72051f;

    /* renamed from: g, reason: collision with root package name */
    private static final long f72052g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f72053h;

    /* renamed from: i, reason: collision with root package name */
    private static final long f72054i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f72055j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f72056k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f72057l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f72058m;

    /* renamed from: n, reason: collision with root package name */
    private static final Set f72059n = new HashSet();

    static {
        MethodHandles.Lookup lookup;
        MethodHandle unreflect;
        MethodHandles.Lookup lookup2;
        MethodHandle unreflect2;
        MethodHandles.Lookup lookup3;
        MethodHandle unreflectGetter;
        MethodHandles.Lookup lookup4;
        MethodHandle unreflectGetter2;
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
            f72046a = unsafe;
            f72047b = unsafe.objectFieldOffset(c.class.getDeclaredField("artMethod"));
            f72048c = unsafe.objectFieldOffset(c.class.getDeclaredField("declaringClass"));
            long objectFieldOffset = unsafe.objectFieldOffset(f.class.getDeclaredField("artFieldOrMethod"));
            f72049d = objectFieldOffset;
            f72050e = unsafe.objectFieldOffset(g.class.getDeclaredField("info"));
            long objectFieldOffset2 = unsafe.objectFieldOffset(b.class.getDeclaredField("methods"));
            f72051f = objectFieldOffset2;
            long objectFieldOffset3 = unsafe.objectFieldOffset(b.class.getDeclaredField("iFields"));
            f72052g = objectFieldOffset3;
            f72053h = unsafe.objectFieldOffset(b.class.getDeclaredField("sFields"));
            f72054i = unsafe.objectFieldOffset(d.class.getDeclaredField("member"));
            Method declaredMethod = h.class.getDeclaredMethod("a", null);
            Method declaredMethod2 = h.class.getDeclaredMethod(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, null);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            lookup = MethodHandles.lookup();
            unreflect = lookup.unreflect(declaredMethod);
            lookup2 = MethodHandles.lookup();
            unreflect2 = lookup2.unreflect(declaredMethod2);
            long j11 = unsafe.getLong(unreflect, objectFieldOffset);
            long j12 = unsafe.getLong(unreflect2, objectFieldOffset);
            long j13 = unsafe.getLong(h.class, objectFieldOffset2);
            long j14 = j12 - j11;
            f72055j = j14;
            f72056k = (j11 - j13) - j14;
            Field declaredField = h.class.getDeclaredField("i");
            Field declaredField2 = h.class.getDeclaredField(com.mbridge.msdk.foundation.same.report.j.f35620b);
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            lookup3 = MethodHandles.lookup();
            unreflectGetter = lookup3.unreflectGetter(declaredField);
            lookup4 = MethodHandles.lookup();
            unreflectGetter2 = lookup4.unreflectGetter(declaredField2);
            long j15 = unsafe.getLong(unreflectGetter, objectFieldOffset);
            long j16 = unsafe.getLong(unreflectGetter2, objectFieldOffset);
            long j17 = unsafe.getLong(h.class, objectFieldOffset3);
            f72057l = j16 - j15;
            f72058m = j15 - j17;
        } catch (ReflectiveOperationException e11) {
            Log.e("HiddenApiBypass", "Initialize error", e11);
            throw new ExceptionInInitializerError(e11);
        }
    }

    static boolean a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (clsArr[i11].isPrimitive()) {
                Class cls = clsArr[i11];
                if (cls == Integer.TYPE && !(objArr[i11] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i11] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i11] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i11] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i11] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i11] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i11] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i11] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i11];
                if (obj != null && !clsArr[i11].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        Set set = f72059n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return d(strArr2);
    }

    public static Object c(Class cls, Object obj, String str, Object... objArr) {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = e.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = f72046a;
        long j11 = unsafe.getLong(cls, f72051f);
        if (j11 == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i11 = unsafe.getInt(j11);
        for (int i12 = 0; i12 < i11; i12++) {
            f72046a.putLong(declaredMethod, f72047b, (i12 * f72055j) + j11 + f72056k);
            if (str.equals(declaredMethod.getName()) && a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean d(String... strArr) {
        try {
            c(VMRuntime.class, c(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th2) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th2);
            return false;
        }
    }
}
