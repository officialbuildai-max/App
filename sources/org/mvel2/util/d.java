package org.mvel2.util;

/* loaded from: classes7.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static a f72167a = new b();

    /* loaded from: classes7.dex */
    public interface a {
        boolean a(Class cls, Class cls2);

        boolean b(Class cls, Class cls2);
    }

    /* loaded from: classes7.dex */
    public static class b implements a {
        private boolean c(Class cls, Class cls2, boolean z10) {
            if (cls == Boolean.TYPE) {
                return cls2 == Boolean.class;
            }
            if (cls != Integer.TYPE && cls != Long.TYPE && cls != Double.TYPE && cls != Float.TYPE) {
                return cls == Character.TYPE ? cls2 == Character.class : cls == Byte.TYPE ? cls2 == Byte.class : cls == Short.TYPE && cls2 == Short.class;
            }
            return d(cls2, z10);
        }

        private boolean d(Class cls, boolean z10) {
            return Number.class.isAssignableFrom(cls) || (z10 && cls == String.class);
        }

        @Override // org.mvel2.util.d.a
        public boolean a(Class cls, Class cls2) {
            return b(cls, cls2);
        }

        @Override // org.mvel2.util.d.a
        public boolean b(Class cls, Class cls2) {
            if (cls == l.class || cls2 == l.class || cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls)) {
                return true;
            }
            if (d(cls, false) && d(cls2, true)) {
                return true;
            }
            if (cls.isPrimitive()) {
                return cls2.isPrimitive() || c(cls, cls2, true);
            }
            if (cls2.isPrimitive()) {
                return c(cls2, cls, false);
            }
            return false;
        }
    }

    public static boolean a(Class cls, Class cls2) {
        return f72167a.a(cls, cls2);
    }

    public static boolean b(Class cls, Class cls2) {
        return f72167a.b(cls, cls2);
    }
}
