package com.google.common.math;

import com.google.common.base.m;

/* loaded from: classes4.dex */
public abstract class e {

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final double f30948a;

        /* renamed from: b, reason: collision with root package name */
        private final double f30949b;

        private b(double d11, double d12) {
            this.f30948a = d11;
            this.f30949b = d12;
        }

        public e a(double d11) {
            m.d(!Double.isNaN(d11));
            return com.google.common.math.c.c(d11) ? new d(d11, this.f30949b - (this.f30948a * d11)) : new C0415e(this.f30948a);
        }
    }

    /* loaded from: classes4.dex */
    private static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        static final c f30950a = new c();

        private c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* loaded from: classes4.dex */
    private static final class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final double f30951a;

        /* renamed from: b, reason: collision with root package name */
        final double f30952b;

        /* renamed from: c, reason: collision with root package name */
        e f30953c = null;

        d(double d11, double d12) {
            this.f30951a = d11;
            this.f30952b = d12;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f30951a), Double.valueOf(this.f30952b));
        }
    }

    /* renamed from: com.google.common.math.e$e, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static final class C0415e extends e {

        /* renamed from: a, reason: collision with root package name */
        final double f30954a;

        /* renamed from: b, reason: collision with root package name */
        e f30955b = null;

        C0415e(double d11) {
            this.f30954a = d11;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f30954a));
        }
    }

    public static e a() {
        return c.f30950a;
    }

    public static e b(double d11) {
        m.d(com.google.common.math.c.c(d11));
        return new d(0.0d, d11);
    }

    public static b c(double d11, double d12) {
        m.d(com.google.common.math.c.c(d11) && com.google.common.math.c.c(d12));
        return new b(d11, d12);
    }

    public static e d(double d11) {
        m.d(com.google.common.math.c.c(d11));
        return new C0415e(d11);
    }
}
