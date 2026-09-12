package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {

    /* renamed from: a, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f6790a;

    /* renamed from: b, reason: collision with root package name */
    private a f6791b;

    /* renamed from: c, reason: collision with root package name */
    private String f6792c;

    /* renamed from: d, reason: collision with root package name */
    private int f6793d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f6794e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f6795f = 0;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f6796g = new ArrayList();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f6797a;

        /* renamed from: b, reason: collision with root package name */
        g f6798b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6799c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6800d;

        /* renamed from: e, reason: collision with root package name */
        private final int f6801e;

        /* renamed from: f, reason: collision with root package name */
        float[] f6802f;

        /* renamed from: g, reason: collision with root package name */
        double[] f6803g;

        /* renamed from: h, reason: collision with root package name */
        float[] f6804h;

        /* renamed from: i, reason: collision with root package name */
        float[] f6805i;

        /* renamed from: j, reason: collision with root package name */
        float[] f6806j;

        /* renamed from: k, reason: collision with root package name */
        float[] f6807k;

        /* renamed from: l, reason: collision with root package name */
        int f6808l;

        /* renamed from: m, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.b f6809m;

        /* renamed from: n, reason: collision with root package name */
        double[] f6810n;

        /* renamed from: o, reason: collision with root package name */
        double[] f6811o;

        /* renamed from: p, reason: collision with root package name */
        float f6812p;

        a(int i11, String str, int i12, int i13) {
            g gVar = new g();
            this.f6798b = gVar;
            this.f6799c = 0;
            this.f6800d = 1;
            this.f6801e = 2;
            this.f6808l = i11;
            this.f6797a = i12;
            gVar.g(i11, str);
            this.f6802f = new float[i13];
            this.f6803g = new double[i13];
            this.f6804h = new float[i13];
            this.f6805i = new float[i13];
            this.f6806j = new float[i13];
            this.f6807k = new float[i13];
        }

        public double a(float f11) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f6809m;
            if (bVar != null) {
                double d11 = f11;
                bVar.g(d11, this.f6811o);
                this.f6809m.d(d11, this.f6810n);
            } else {
                double[] dArr = this.f6811o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d12 = f11;
            double e11 = this.f6798b.e(d12, this.f6810n[1]);
            double d13 = this.f6798b.d(d12, this.f6810n[1], this.f6811o[1]);
            double[] dArr2 = this.f6811o;
            return dArr2[0] + (e11 * dArr2[2]) + (d13 * this.f6810n[2]);
        }

        public double b(float f11) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f6809m;
            if (bVar != null) {
                bVar.d(f11, this.f6810n);
            } else {
                double[] dArr = this.f6810n;
                dArr[0] = this.f6805i[0];
                dArr[1] = this.f6806j[0];
                dArr[2] = this.f6802f[0];
            }
            double[] dArr2 = this.f6810n;
            return dArr2[0] + (this.f6798b.e(f11, dArr2[1]) * this.f6810n[2]);
        }

        public void c(int i11, int i12, float f11, float f12, float f13, float f14) {
            this.f6803g[i11] = i12 / 100.0d;
            this.f6804h[i11] = f11;
            this.f6805i[i11] = f12;
            this.f6806j[i11] = f13;
            this.f6802f[i11] = f14;
        }

        public void d(float f11) {
            this.f6812p = f11;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f6803g.length, 3);
            float[] fArr = this.f6802f;
            this.f6810n = new double[fArr.length + 2];
            this.f6811o = new double[fArr.length + 2];
            if (this.f6803g[0] > 0.0d) {
                this.f6798b.a(0.0d, this.f6804h[0]);
            }
            double[] dArr2 = this.f6803g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f6798b.a(1.0d, this.f6804h[length]);
            }
            for (int i11 = 0; i11 < dArr.length; i11++) {
                double[] dArr3 = dArr[i11];
                dArr3[0] = this.f6805i[i11];
                dArr3[1] = this.f6806j[i11];
                dArr3[2] = this.f6802f[i11];
                this.f6798b.a(this.f6803g[i11], this.f6804h[i11]);
            }
            this.f6798b.f();
            double[] dArr4 = this.f6803g;
            if (dArr4.length > 1) {
                this.f6809m = androidx.constraintlayout.core.motion.utils.b.a(0, dArr4, dArr);
            } else {
                this.f6809m = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f6813a;

        /* renamed from: b, reason: collision with root package name */
        float f6814b;

        /* renamed from: c, reason: collision with root package name */
        float f6815c;

        /* renamed from: d, reason: collision with root package name */
        float f6816d;

        /* renamed from: e, reason: collision with root package name */
        float f6817e;

        public b(int i11, float f11, float f12, float f13, float f14) {
            this.f6813a = i11;
            this.f6814b = f14;
            this.f6815c = f12;
            this.f6816d = f11;
            this.f6817e = f13;
        }
    }

    public float a(float f11) {
        return (float) this.f6791b.b(f11);
    }

    public float b(float f11) {
        return (float) this.f6791b.a(f11);
    }

    protected void c(Object obj) {
    }

    public void d(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14) {
        this.f6796g.add(new b(i11, f11, f12, f13, f14));
        if (i13 != -1) {
            this.f6795f = i13;
        }
        this.f6793d = i12;
        this.f6794e = str;
    }

    public void e(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14, Object obj) {
        this.f6796g.add(new b(i11, f11, f12, f13, f14));
        if (i13 != -1) {
            this.f6795f = i13;
        }
        this.f6793d = i12;
        c(obj);
        this.f6794e = str;
    }

    public void f(String str) {
        this.f6792c = str;
    }

    public void g(float f11) {
        int size = this.f6796g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f6796g, new Comparator<b>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(b bVar, b bVar2) {
                return Integer.compare(bVar.f6813a, bVar2.f6813a);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f6791b = new a(this.f6793d, this.f6794e, this.f6795f, size);
        Iterator it = this.f6796g.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            float f12 = bVar.f6816d;
            dArr[i11] = f12 * 0.01d;
            double[] dArr3 = dArr2[i11];
            float f13 = bVar.f6814b;
            dArr3[0] = f13;
            float f14 = bVar.f6815c;
            dArr3[1] = f14;
            float f15 = bVar.f6817e;
            dArr3[2] = f15;
            this.f6791b.c(i11, bVar.f6813a, f12, f14, f15, f13);
            i11++;
            dArr2 = dArr2;
        }
        this.f6791b.d(f11);
        this.f6790a = androidx.constraintlayout.core.motion.utils.b.a(0, dArr, dArr2);
    }

    public boolean h() {
        return this.f6795f == 1;
    }

    public String toString() {
        String str = this.f6792c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator it = this.f6796g.iterator();
        while (it.hasNext()) {
            str = str + "[" + ((b) it.next()).f6813a + " , " + decimalFormat.format(r3.f6814b) + "] ";
        }
        return str;
    }
}
