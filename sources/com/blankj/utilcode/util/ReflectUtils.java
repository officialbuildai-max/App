package com.blankj.utilcode.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class ReflectUtils {

    /* renamed from: com.blankj.utilcode.util.ReflectUtils$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Comparator<Constructor<?>> {
        final /* synthetic */ ReflectUtils this$0;

        AnonymousClass1(ReflectUtils reflectUtils) {
        }

        @Override // java.util.Comparator
        public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
            int length = parameterTypes.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (!parameterTypes[i11].equals(parameterTypes2[i11])) {
                    return ReflectUtils.a(null, parameterTypes[i11]).isAssignableFrom(ReflectUtils.a(null, parameterTypes2[i11])) ? 1 : -1;
                }
            }
            return 0;
        }
    }

    /* renamed from: com.blankj.utilcode.util.ReflectUtils$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Comparator<Method> {
        final /* synthetic */ ReflectUtils this$0;

        AnonymousClass2(ReflectUtils reflectUtils) {
        }

        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            int length = parameterTypes.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (!parameterTypes[i11].equals(parameterTypes2[i11])) {
                    return ReflectUtils.a(null, parameterTypes[i11]).isAssignableFrom(ReflectUtils.a(null, parameterTypes2[i11])) ? 1 : -1;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th2) {
            super(str, th2);
        }

        public ReflectException(Throwable th2) {
            super(th2);
        }
    }

    static /* synthetic */ Class a(ReflectUtils reflectUtils, Class cls) {
        throw null;
    }
}
