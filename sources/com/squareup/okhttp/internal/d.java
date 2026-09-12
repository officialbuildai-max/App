package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final Class f40343a;

    /* renamed from: b, reason: collision with root package name */
    private final String f40344b;

    /* renamed from: c, reason: collision with root package name */
    private final Class[] f40345c;

    public d(Class cls, String str, Class... clsArr) {
        this.f40343a = cls;
        this.f40344b = str;
        this.f40345c = clsArr;
    }

    private Method a(Class cls) {
        Class cls2;
        String str = this.f40344b;
        if (str == null) {
            return null;
        }
        Method b11 = b(cls, str, this.f40345c);
        if (b11 == null || (cls2 = this.f40343a) == null || cls2.isAssignableFrom(b11.getReturnType())) {
            return b11;
        }
        return null;
    }

    private static Method b(Class cls, String str, Class[] clsArr) {
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

    public Object c(Object obj, Object... objArr) {
        Method a11 = a(obj.getClass());
        if (a11 == null) {
            throw new AssertionError("Method " + this.f40344b + " not supported for object " + obj);
        }
        try {
            return a11.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a11);
            assertionError.initCause(e11);
            throw assertionError;
        }
    }

    public Object d(Object obj, Object... objArr) {
        Method a11 = a(obj.getClass());
        if (a11 == null) {
            return null;
        }
        try {
            return a11.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(Object obj, Object... objArr) {
        try {
            return d(obj, objArr);
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

    public Object f(Object obj, Object... objArr) {
        try {
            return c(obj, objArr);
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

    public boolean g(Object obj) {
        return a(obj.getClass()) != null;
    }
}
