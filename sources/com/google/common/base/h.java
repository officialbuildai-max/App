package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class h {

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f30290a;

        /* renamed from: b, reason: collision with root package name */
        private final C0404b f30291b;

        /* renamed from: c, reason: collision with root package name */
        private C0404b f30292c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f30293d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f30294e;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class a extends C0404b {
            private a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.base.h$b$b, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0404b {

            /* renamed from: a, reason: collision with root package name */
            String f30295a;

            /* renamed from: b, reason: collision with root package name */
            Object f30296b;

            /* renamed from: c, reason: collision with root package name */
            C0404b f30297c;

            C0404b() {
            }
        }

        private b(String str) {
            C0404b c0404b = new C0404b();
            this.f30291b = c0404b;
            this.f30292c = c0404b;
            this.f30293d = false;
            this.f30294e = false;
            this.f30290a = (String) m.o(str);
        }

        private C0404b e() {
            C0404b c0404b = new C0404b();
            this.f30292c.f30297c = c0404b;
            this.f30292c = c0404b;
            return c0404b;
        }

        private b f(Object obj) {
            e().f30296b = obj;
            return this;
        }

        private b g(String str, Object obj) {
            C0404b e11 = e();
            e11.f30296b = obj;
            e11.f30295a = (String) m.o(str);
            return this;
        }

        private a h() {
            a aVar = new a();
            this.f30292c.f30297c = aVar;
            this.f30292c = aVar;
            return aVar;
        }

        private b i(String str, Object obj) {
            a h11 = h();
            h11.f30296b = obj;
            h11.f30295a = (String) m.o(str);
            return this;
        }

        private static boolean k(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).isPresent() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d11) {
            return i(str, String.valueOf(d11));
        }

        public b b(String str, int i11) {
            return i(str, String.valueOf(i11));
        }

        public b c(String str, long j11) {
            return i(str, String.valueOf(j11));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public b j(Object obj) {
            return f(obj);
        }

        public String toString() {
            boolean z10 = this.f30293d;
            boolean z11 = this.f30294e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f30290a);
            sb2.append('{');
            String str = "";
            for (C0404b c0404b = this.f30291b.f30297c; c0404b != null; c0404b = c0404b.f30297c) {
                Object obj = c0404b.f30296b;
                if (!(c0404b instanceof a)) {
                    if (obj == null) {
                        if (z10) {
                        }
                    } else if (z11 && k(obj)) {
                    }
                }
                sb2.append(str);
                String str2 = c0404b.f30295a;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb2.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
