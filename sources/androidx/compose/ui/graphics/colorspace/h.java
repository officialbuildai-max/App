package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.b;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class h {

    /* renamed from: g, reason: collision with root package name */
    public static final a f4452g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final c f4453a;

    /* renamed from: b, reason: collision with root package name */
    private final c f4454b;

    /* renamed from: c, reason: collision with root package name */
    private final c f4455c;

    /* renamed from: d, reason: collision with root package name */
    private final c f4456d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4457e;

    /* renamed from: f, reason: collision with root package name */
    private final float[] f4458f;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: androidx.compose.ui.graphics.colorspace.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0047a extends h {
            C0047a(c cVar, int i11) {
                super(cVar, cVar, i11, null);
            }

            @Override // androidx.compose.ui.graphics.colorspace.h
            public long a(long j11) {
                return j11;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] b(c cVar, c cVar2, int i11) {
            if (!n.e(i11, n.f4480a.a())) {
                return null;
            }
            long e11 = cVar.e();
            b.a aVar = androidx.compose.ui.graphics.colorspace.b.f4419a;
            boolean e12 = androidx.compose.ui.graphics.colorspace.b.e(e11, aVar.b());
            boolean e13 = androidx.compose.ui.graphics.colorspace.b.e(cVar2.e(), aVar.b());
            if (e12 && e13) {
                return null;
            }
            if (!e12 && !e13) {
                return null;
            }
            if (!e12) {
                cVar = cVar2;
            }
            Intrinsics.f(cVar, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) cVar;
            float[] c11 = e12 ? rgb.N().c() : k.f4463a.c();
            float[] c12 = e13 ? rgb.N().c() : k.f4463a.c();
            return new float[]{c11[0] / c12[0], c11[1] / c12[1], c11[2] / c12[2]};
        }

        public final h c(c cVar) {
            return new C0047a(cVar, n.f4480a.c());
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends h {

        /* renamed from: h, reason: collision with root package name */
        private final Rgb f4459h;

        /* renamed from: i, reason: collision with root package name */
        private final Rgb f4460i;

        /* renamed from: j, reason: collision with root package name */
        private final float[] f4461j;

        private b(Rgb rgb, Rgb rgb2, int i11) {
            super(rgb, rgb2, rgb, rgb2, i11, null, null);
            this.f4459h = rgb;
            this.f4460i = rgb2;
            this.f4461j = b(rgb, rgb2, i11);
        }

        public /* synthetic */ b(Rgb rgb, Rgb rgb2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i11);
        }

        private final float[] b(Rgb rgb, Rgb rgb2, int i11) {
            if (d.f(rgb.N(), rgb2.N())) {
                return d.l(rgb2.G(), rgb.M());
            }
            float[] M = rgb.M();
            float[] G = rgb2.G();
            float[] c11 = rgb.N().c();
            float[] c12 = rgb2.N().c();
            y N = rgb.N();
            k kVar = k.f4463a;
            if (!d.f(N, kVar.b())) {
                float[] b11 = androidx.compose.ui.graphics.colorspace.a.f4414b.a().b();
                float[] c13 = kVar.c();
                float[] copyOf = Arrays.copyOf(c13, c13.length);
                Intrinsics.g(copyOf, "copyOf(this, size)");
                M = d.l(d.e(b11, c11, copyOf), rgb.M());
            }
            if (!d.f(rgb2.N(), kVar.b())) {
                float[] b12 = androidx.compose.ui.graphics.colorspace.a.f4414b.a().b();
                float[] c14 = kVar.c();
                float[] copyOf2 = Arrays.copyOf(c14, c14.length);
                Intrinsics.g(copyOf2, "copyOf(this, size)");
                G = d.k(d.l(d.e(b12, c12, copyOf2), rgb2.M()));
            }
            if (n.e(i11, n.f4480a.a())) {
                M = d.m(new float[]{c11[0] / c12[0], c11[1] / c12[1], c11[2] / c12[2]}, M);
            }
            return d.l(G, M);
        }

        @Override // androidx.compose.ui.graphics.colorspace.h
        public long a(long j11) {
            float r11 = u1.r(j11);
            float q11 = u1.q(j11);
            float o11 = u1.o(j11);
            float n11 = u1.n(j11);
            float a11 = (float) this.f4459h.E().a(r11);
            float a12 = (float) this.f4459h.E().a(q11);
            float a13 = (float) this.f4459h.E().a(o11);
            float[] fArr = this.f4461j;
            return w1.a((float) this.f4460i.I().a((fArr[0] * a11) + (fArr[3] * a12) + (fArr[6] * a13)), (float) this.f4460i.I().a((fArr[1] * a11) + (fArr[4] * a12) + (fArr[7] * a13)), (float) this.f4460i.I().a((fArr[2] * a11) + (fArr[5] * a12) + (fArr[8] * a13)), n11, this.f4460i);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private h(androidx.compose.ui.graphics.colorspace.c r13, androidx.compose.ui.graphics.colorspace.c r14, int r15) {
        /*
            r12 = this;
            long r0 = r13.e()
            androidx.compose.ui.graphics.colorspace.b$a r2 = androidx.compose.ui.graphics.colorspace.b.f4419a
            long r3 = r2.b()
            boolean r0 = androidx.compose.ui.graphics.colorspace.b.e(r0, r3)
            r1 = 2
            r3 = 0
            if (r0 == 0) goto L1e
            androidx.compose.ui.graphics.colorspace.k r0 = androidx.compose.ui.graphics.colorspace.k.f4463a
            androidx.compose.ui.graphics.colorspace.y r0 = r0.b()
            androidx.compose.ui.graphics.colorspace.c r0 = androidx.compose.ui.graphics.colorspace.d.d(r13, r0, r3, r1, r3)
            r7 = r0
            goto L1f
        L1e:
            r7 = r13
        L1f:
            long r4 = r14.e()
            long r8 = r2.b()
            boolean r0 = androidx.compose.ui.graphics.colorspace.b.e(r4, r8)
            if (r0 == 0) goto L39
            androidx.compose.ui.graphics.colorspace.k r0 = androidx.compose.ui.graphics.colorspace.k.f4463a
            androidx.compose.ui.graphics.colorspace.y r0 = r0.b()
            androidx.compose.ui.graphics.colorspace.c r0 = androidx.compose.ui.graphics.colorspace.d.d(r14, r0, r3, r1, r3)
            r8 = r0
            goto L3a
        L39:
            r8 = r14
        L3a:
            androidx.compose.ui.graphics.colorspace.h$a r0 = androidx.compose.ui.graphics.colorspace.h.f4452g
            float[] r10 = androidx.compose.ui.graphics.colorspace.h.a.a(r0, r13, r14, r15)
            r11 = 0
            r4 = r12
            r5 = r13
            r6 = r14
            r9 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.h.<init>(androidx.compose.ui.graphics.colorspace.c, androidx.compose.ui.graphics.colorspace.c, int):void");
    }

    public /* synthetic */ h(c cVar, c cVar2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, cVar2, i11);
    }

    private h(c cVar, c cVar2, c cVar3, c cVar4, int i11, float[] fArr) {
        this.f4453a = cVar;
        this.f4454b = cVar2;
        this.f4455c = cVar3;
        this.f4456d = cVar4;
        this.f4457e = i11;
        this.f4458f = fArr;
    }

    public /* synthetic */ h(c cVar, c cVar2, c cVar3, c cVar4, int i11, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, cVar2, cVar3, cVar4, i11, fArr);
    }

    public long a(long j11) {
        float r11 = u1.r(j11);
        float q11 = u1.q(j11);
        float o11 = u1.o(j11);
        float n11 = u1.n(j11);
        long h11 = this.f4455c.h(r11, q11, o11);
        float intBitsToFloat = Float.intBitsToFloat((int) (h11 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (h11 & 4294967295L));
        float i11 = this.f4455c.i(r11, q11, o11);
        float[] fArr = this.f4458f;
        if (fArr != null) {
            intBitsToFloat *= fArr[0];
            intBitsToFloat2 *= fArr[1];
            i11 *= fArr[2];
        }
        float f11 = intBitsToFloat;
        return this.f4456d.j(f11, intBitsToFloat2, i11, n11, this.f4454b);
    }
}
