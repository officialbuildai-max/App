package com.mbridge.msdk.thrid.okhttp.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
class f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f38297a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38298b;

    /* renamed from: c, reason: collision with root package name */
    private final Class[] f38299c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Class<?> cls, String str, Class... clsArr) {
        this.f38297a = cls;
        this.f38298b = str;
        this.f38299c = clsArr;
    }

    private Method a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f38298b;
        if (str == null) {
            return null;
        }
        Method a11 = a(cls, str, this.f38299c);
        if (a11 == null || (cls2 = this.f38297a) == null || cls2.isAssignableFrom(a11.getReturnType())) {
            return a11;
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object a(T t11, Object... objArr) throws InvocationTargetException {
        Method a11 = a(t11.getClass());
        if (a11 == null) {
            throw new AssertionError("Method " + this.f38298b + " not supported for object " + t11);
        }
        try {
            return a11.invoke(t11, objArr);
        } catch (IllegalAccessException e11) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a11);
            assertionError.initCause(e11);
            throw assertionError;
        }
    }

    public boolean a(T t11) {
        return a(t11.getClass()) != null;
    }

    public Object b(T t11, Object... objArr) throws InvocationTargetException {
        Method a11 = a(t11.getClass());
        if (a11 == null) {
            return null;
        }
        try {
            return a11.invoke(t11, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object c(T t11, Object... objArr) {
        try {
            return b(t11, objArr);
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object d(T t11, Object... objArr) {
        try {
            return a(t11, objArr);
        } catch (InvocationTargetException e11) {
            Throwable targetException = e11.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
