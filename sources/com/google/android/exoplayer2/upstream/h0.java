package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator f27465h = new Comparator() { // from class: com.google.android.exoplayer2.upstream.f0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int g11;
            g11 = h0.g((h0.b) obj, (h0.b) obj2);
            return g11;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator f27466i = new Comparator() { // from class: com.google.android.exoplayer2.upstream.g0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h11;
            h11 = h0.h((h0.b) obj, (h0.b) obj2);
            return h11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f27467a;

    /* renamed from: e, reason: collision with root package name */
    private int f27471e;

    /* renamed from: f, reason: collision with root package name */
    private int f27472f;

    /* renamed from: g, reason: collision with root package name */
    private int f27473g;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f27469c = new b[5];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f27468b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private int f27470d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f27474a;

        /* renamed from: b, reason: collision with root package name */
        public int f27475b;

        /* renamed from: c, reason: collision with root package name */
        public float f27476c;

        private b() {
        }
    }

    public h0(int i11) {
        this.f27467a = i11;
    }

    private void d() {
        if (this.f27470d != 1) {
            Collections.sort(this.f27468b, f27465h);
            this.f27470d = 1;
        }
    }

    private void e() {
        if (this.f27470d != 0) {
            Collections.sort(this.f27468b, f27466i);
            this.f27470d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(b bVar, b bVar2) {
        return bVar.f27474a - bVar2.f27474a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(b bVar, b bVar2) {
        return Float.compare(bVar.f27476c, bVar2.f27476c);
    }

    public void c(int i11, float f11) {
        b bVar;
        d();
        int i12 = this.f27473g;
        if (i12 > 0) {
            b[] bVarArr = this.f27469c;
            int i13 = i12 - 1;
            this.f27473g = i13;
            bVar = bVarArr[i13];
        } else {
            bVar = new b();
        }
        int i14 = this.f27471e;
        this.f27471e = i14 + 1;
        bVar.f27474a = i14;
        bVar.f27475b = i11;
        bVar.f27476c = f11;
        this.f27468b.add(bVar);
        this.f27472f += i11;
        while (true) {
            int i15 = this.f27472f;
            int i16 = this.f27467a;
            if (i15 <= i16) {
                return;
            }
            int i17 = i15 - i16;
            b bVar2 = (b) this.f27468b.get(0);
            int i18 = bVar2.f27475b;
            if (i18 <= i17) {
                this.f27472f -= i18;
                this.f27468b.remove(0);
                int i19 = this.f27473g;
                if (i19 < 5) {
                    b[] bVarArr2 = this.f27469c;
                    this.f27473g = i19 + 1;
                    bVarArr2[i19] = bVar2;
                }
            } else {
                bVar2.f27475b = i18 - i17;
                this.f27472f -= i17;
            }
        }
    }

    public float f(float f11) {
        e();
        float f12 = f11 * this.f27472f;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f27468b.size(); i12++) {
            b bVar = (b) this.f27468b.get(i12);
            i11 += bVar.f27475b;
            if (i11 >= f12) {
                return bVar.f27476c;
            }
        }
        if (this.f27468b.isEmpty()) {
            return Float.NaN;
        }
        return ((b) this.f27468b.get(r5.size() - 1)).f27476c;
    }

    public void i() {
        this.f27468b.clear();
        this.f27470d = -1;
        this.f27471e = 0;
        this.f27472f = 0;
    }
}
