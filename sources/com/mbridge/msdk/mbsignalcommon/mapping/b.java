package com.mbridge.msdk.mbsignalcommon.mapping;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static class a<C> {

        /* renamed from: a, reason: collision with root package name */
        protected Class<C> f36555a;

        public a(Class<C> cls) {
            this.f36555a = cls;
        }

        public C0515b a(String str, Class<?>... clsArr) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
            return new C0515b(this.f36555a, str, clsArr, 0);
        }
    }

    /* renamed from: com.mbridge.msdk.mbsignalcommon.mapping.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0515b {

        /* renamed from: a, reason: collision with root package name */
        protected final Method f36556a;

        C0515b(Class<?> cls, String str, Class<?>[] clsArr, int i11) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
            Method method = null;
            if (cls == null) {
                return;
            }
            while (cls != Object.class && cls != null) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e11) {
                    if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                        e11.printStackTrace();
                    }
                    cls = cls.getSuperclass();
                } catch (SecurityException e12) {
                    try {
                        if (MBridgeConstans.DEBUG && cls.getSuperclass() == Object.class) {
                            e12.printStackTrace();
                        }
                        cls = cls.getSuperclass();
                    } catch (Exception e13) {
                        com.mbridge.msdk.mbsignalcommon.mapping.a aVar = new com.mbridge.msdk.mbsignalcommon.mapping.a(e13);
                        aVar.a(cls);
                        aVar.a(str);
                        b.b(aVar);
                        return;
                    } finally {
                        this.f36556a = method;
                    }
                }
            }
            if (method != null) {
                if (i11 > 0 && (method.getModifiers() & i11) != i11) {
                    b.b(new com.mbridge.msdk.mbsignalcommon.mapping.a(method + " does not match modifiers: " + i11));
                }
                method.setAccessible(true);
            }
        }

        public Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            Method method = this.f36556a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e11) {
                o0.a("MappingedMethod", "invoke error:" + e11.getMessage());
                return null;
            }
        }

        public Method a() {
            return this.f36556a;
        }
    }

    public static <T> a<T> a(ClassLoader classLoader, String str) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
        try {
            return new a<>(classLoader.loadClass(str));
        } catch (Exception e11) {
            b(new com.mbridge.msdk.mbsignalcommon.mapping.a(e11));
            return new a<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.mbridge.msdk.mbsignalcommon.mapping.a aVar) throws com.mbridge.msdk.mbsignalcommon.mapping.a {
        throw aVar;
    }
}
