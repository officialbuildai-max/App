package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Comparable {

    /* renamed from: t, reason: collision with root package name */
    static String[] f7478t = {RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.core.motion.utils.c f7479a;

    /* renamed from: c, reason: collision with root package name */
    float f7481c;

    /* renamed from: d, reason: collision with root package name */
    float f7482d;

    /* renamed from: e, reason: collision with root package name */
    float f7483e;

    /* renamed from: f, reason: collision with root package name */
    float f7484f;

    /* renamed from: g, reason: collision with root package name */
    float f7485g;

    /* renamed from: h, reason: collision with root package name */
    float f7486h;

    /* renamed from: k, reason: collision with root package name */
    int f7489k;

    /* renamed from: l, reason: collision with root package name */
    int f7490l;

    /* renamed from: m, reason: collision with root package name */
    float f7491m;

    /* renamed from: n, reason: collision with root package name */
    m f7492n;

    /* renamed from: o, reason: collision with root package name */
    LinkedHashMap f7493o;

    /* renamed from: p, reason: collision with root package name */
    int f7494p;

    /* renamed from: q, reason: collision with root package name */
    int f7495q;

    /* renamed from: r, reason: collision with root package name */
    double[] f7496r;

    /* renamed from: s, reason: collision with root package name */
    double[] f7497s;

    /* renamed from: b, reason: collision with root package name */
    int f7480b = 0;

    /* renamed from: i, reason: collision with root package name */
    float f7487i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    float f7488j = Float.NaN;

    public o() {
        int i11 = d.f7324f;
        this.f7489k = i11;
        this.f7490l = i11;
        this.f7491m = Float.NaN;
        this.f7492n = null;
        this.f7493o = new LinkedHashMap();
        this.f7494p = 0;
        this.f7496r = new double[18];
        this.f7497s = new double[18];
    }

    public o(int i11, int i12, h hVar, o oVar, o oVar2) {
        int i13 = d.f7324f;
        this.f7489k = i13;
        this.f7490l = i13;
        this.f7491m = Float.NaN;
        this.f7492n = null;
        this.f7493o = new LinkedHashMap();
        this.f7494p = 0;
        this.f7496r = new double[18];
        this.f7497s = new double[18];
        if (oVar.f7490l != d.f7324f) {
            o(i11, i12, hVar, oVar, oVar2);
            return;
        }
        int i14 = hVar.f7380q;
        if (i14 == 1) {
            n(hVar, oVar, oVar2);
        } else if (i14 != 2) {
            m(hVar, oVar, oVar2);
        } else {
            p(i11, i12, hVar, oVar, oVar2);
        }
    }

    private boolean d(float f11, float f12) {
        return (Float.isNaN(f11) || Float.isNaN(f12)) ? Float.isNaN(f11) != Float.isNaN(f12) : Math.abs(f11 - f12) > 1.0E-6f;
    }

    public void a(b.a aVar) {
        this.f7479a = androidx.constraintlayout.core.motion.utils.c.c(aVar.f7841d.f7906d);
        b.c cVar = aVar.f7841d;
        this.f7489k = cVar.f7907e;
        this.f7490l = cVar.f7904b;
        this.f7487i = cVar.f7911i;
        this.f7480b = cVar.f7908f;
        this.f7495q = cVar.f7905c;
        this.f7488j = aVar.f7840c.f7921e;
        this.f7491m = aVar.f7842e.D;
        for (String str : aVar.f7844g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) aVar.f7844g.get(str);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.f7493o.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        return Float.compare(this.f7482d, oVar.f7482d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(o oVar, boolean[] zArr, String[] strArr, boolean z10) {
        boolean d11 = d(this.f7483e, oVar.f7483e);
        boolean d12 = d(this.f7484f, oVar.f7484f);
        zArr[0] = zArr[0] | d(this.f7482d, oVar.f7482d);
        boolean z11 = d11 | d12 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | d(this.f7485g, oVar.f7485g);
        zArr[4] = d(this.f7486h, oVar.f7486h) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(double[] dArr, int[] iArr) {
        float[] fArr = {this.f7482d, this.f7483e, this.f7484f, this.f7485g, this.f7486h, this.f7487i};
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < 6) {
                dArr[i11] = fArr[r2];
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d11, int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f7483e;
        float f12 = this.f7484f;
        float f13 = this.f7485g;
        float f14 = this.f7486h;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        m mVar = this.f7492n;
        if (mVar != null) {
            float[] fArr2 = new float[2];
            mVar.i(d11, fArr2, new float[2]);
            float f16 = fArr2[0];
            float f17 = fArr2[1];
            double d12 = f16;
            double d13 = f11;
            double d14 = f12;
            f11 = (float) ((d12 + (Math.sin(d14) * d13)) - (f13 / 2.0f));
            f12 = (float) ((f17 - (d13 * Math.cos(d14))) - (f14 / 2.0f));
        }
        fArr[i11] = f11 + (f13 / 2.0f) + 0.0f;
        fArr[i11 + 1] = f12 + (f14 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(double d11, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f11;
        float f12 = this.f7483e;
        float f13 = this.f7484f;
        float f14 = this.f7485g;
        float f15 = this.f7486h;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f20 = (float) dArr[i11];
            float f21 = (float) dArr2[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f12 = f20;
                f16 = f21;
            } else if (i12 == 2) {
                f13 = f20;
                f18 = f21;
            } else if (i12 == 3) {
                f14 = f20;
                f17 = f21;
            } else if (i12 == 4) {
                f15 = f20;
                f19 = f21;
            }
        }
        float f22 = 2.0f;
        float f23 = (f17 / 2.0f) + f16;
        float f24 = (f19 / 2.0f) + f18;
        m mVar = this.f7492n;
        if (mVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            mVar.i(d11, fArr3, fArr4);
            float f25 = fArr3[0];
            float f26 = fArr3[1];
            float f27 = fArr4[0];
            float f28 = fArr4[1];
            double d12 = f12;
            double d13 = f13;
            f11 = f14;
            float sin = (float) ((f25 + (Math.sin(d13) * d12)) - (f14 / 2.0f));
            float cos = (float) ((f26 - (d12 * Math.cos(d13))) - (f15 / 2.0f));
            double d14 = f16;
            double d15 = f18;
            float sin2 = (float) (f27 + (Math.sin(d13) * d14) + (Math.cos(d13) * d15));
            f24 = (float) ((f28 - (d14 * Math.cos(d13))) + (Math.sin(d13) * d15));
            f23 = sin2;
            f12 = sin;
            f13 = cos;
            f22 = 2.0f;
        } else {
            f11 = f14;
        }
        fArr[0] = f12 + (f11 / f22) + 0.0f;
        fArr[1] = f13 + (f15 / f22) + 0.0f;
        fArr2[0] = f23;
        fArr2[1] = f24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(String str, double[] dArr, int i11) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7493o.get(str);
        int i12 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i11] = constraintAttribute.e();
            return 1;
        }
        int h11 = constraintAttribute.h();
        constraintAttribute.f(new float[h11]);
        while (i12 < h11) {
            dArr[i11] = r2[i12];
            i12++;
            i11++;
        }
        return h11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(String str) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f7493o.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f7483e;
        float f12 = this.f7484f;
        float f13 = this.f7485g;
        float f14 = this.f7486h;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        m mVar = this.f7492n;
        if (mVar != null) {
            float j11 = mVar.j();
            float k11 = this.f7492n.k();
            double d11 = f11;
            double d12 = f12;
            float sin = (float) ((j11 + (Math.sin(d12) * d11)) - (f13 / 2.0f));
            f12 = (float) ((k11 - (d11 * Math.cos(d12))) - (f14 / 2.0f));
            f11 = sin;
        }
        float f16 = f13 + f11;
        float f17 = f14 + f12;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i11] = f11 + 0.0f;
        fArr[i11 + 1] = f12 + 0.0f;
        fArr[i11 + 2] = f16 + 0.0f;
        fArr[i11 + 3] = f12 + 0.0f;
        fArr[i11 + 4] = f16 + 0.0f;
        fArr[i11 + 5] = f17 + 0.0f;
        fArr[i11 + 6] = f11 + 0.0f;
        fArr[i11 + 7] = f17 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(String str) {
        return this.f7493o.containsKey(str);
    }

    void m(h hVar, o oVar, o oVar2) {
        float f11 = hVar.f7325a / 100.0f;
        this.f7481c = f11;
        this.f7480b = hVar.f7373j;
        float f12 = Float.isNaN(hVar.f7374k) ? f11 : hVar.f7374k;
        float f13 = Float.isNaN(hVar.f7375l) ? f11 : hVar.f7375l;
        float f14 = oVar2.f7485g;
        float f15 = oVar.f7485g;
        float f16 = oVar2.f7486h;
        float f17 = oVar.f7486h;
        this.f7482d = this.f7481c;
        float f18 = oVar.f7483e;
        float f19 = oVar.f7484f;
        float f20 = (oVar2.f7483e + (f14 / 2.0f)) - ((f15 / 2.0f) + f18);
        float f21 = (oVar2.f7484f + (f16 / 2.0f)) - (f19 + (f17 / 2.0f));
        float f22 = ((f14 - f15) * f12) / 2.0f;
        this.f7483e = (int) ((f18 + (f20 * f11)) - f22);
        float f23 = ((f16 - f17) * f13) / 2.0f;
        this.f7484f = (int) ((f19 + (f21 * f11)) - f23);
        this.f7485g = (int) (f15 + r9);
        this.f7486h = (int) (f17 + r12);
        float f24 = Float.isNaN(hVar.f7376m) ? f11 : hVar.f7376m;
        float f25 = Float.isNaN(hVar.f7379p) ? 0.0f : hVar.f7379p;
        if (!Float.isNaN(hVar.f7377n)) {
            f11 = hVar.f7377n;
        }
        float f26 = Float.isNaN(hVar.f7378o) ? 0.0f : hVar.f7378o;
        this.f7494p = 0;
        this.f7483e = (int) (((oVar.f7483e + (f24 * f20)) + (f26 * f21)) - f22);
        this.f7484f = (int) (((oVar.f7484f + (f20 * f25)) + (f21 * f11)) - f23);
        this.f7479a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f7371h);
        this.f7489k = hVar.f7372i;
    }

    void n(h hVar, o oVar, o oVar2) {
        float f11 = hVar.f7325a / 100.0f;
        this.f7481c = f11;
        this.f7480b = hVar.f7373j;
        float f12 = Float.isNaN(hVar.f7374k) ? f11 : hVar.f7374k;
        float f13 = Float.isNaN(hVar.f7375l) ? f11 : hVar.f7375l;
        float f14 = oVar2.f7485g - oVar.f7485g;
        float f15 = oVar2.f7486h - oVar.f7486h;
        this.f7482d = this.f7481c;
        if (!Float.isNaN(hVar.f7376m)) {
            f11 = hVar.f7376m;
        }
        float f16 = oVar.f7483e;
        float f17 = oVar.f7485g;
        float f18 = oVar.f7484f;
        float f19 = oVar.f7486h;
        float f20 = (oVar2.f7483e + (oVar2.f7485g / 2.0f)) - ((f17 / 2.0f) + f16);
        float f21 = (oVar2.f7484f + (oVar2.f7486h / 2.0f)) - ((f19 / 2.0f) + f18);
        float f22 = f20 * f11;
        float f23 = (f14 * f12) / 2.0f;
        this.f7483e = (int) ((f16 + f22) - f23);
        float f24 = f11 * f21;
        float f25 = (f15 * f13) / 2.0f;
        this.f7484f = (int) ((f18 + f24) - f25);
        this.f7485g = (int) (f17 + r7);
        this.f7486h = (int) (f19 + r8);
        float f26 = Float.isNaN(hVar.f7377n) ? 0.0f : hVar.f7377n;
        this.f7494p = 1;
        float f27 = (int) ((oVar.f7483e + f22) - f23);
        float f28 = (int) ((oVar.f7484f + f24) - f25);
        this.f7483e = f27 + ((-f21) * f26);
        this.f7484f = f28 + (f20 * f26);
        this.f7490l = this.f7490l;
        this.f7479a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f7371h);
        this.f7489k = hVar.f7372i;
    }

    void o(int i11, int i12, h hVar, o oVar, o oVar2) {
        float min;
        float f11;
        float f12 = hVar.f7325a / 100.0f;
        this.f7481c = f12;
        this.f7480b = hVar.f7373j;
        this.f7494p = hVar.f7380q;
        float f13 = Float.isNaN(hVar.f7374k) ? f12 : hVar.f7374k;
        float f14 = Float.isNaN(hVar.f7375l) ? f12 : hVar.f7375l;
        float f15 = oVar2.f7485g;
        float f16 = oVar.f7485g;
        float f17 = oVar2.f7486h;
        float f18 = oVar.f7486h;
        this.f7482d = this.f7481c;
        this.f7485g = (int) (f16 + ((f15 - f16) * f13));
        this.f7486h = (int) (f18 + ((f17 - f18) * f14));
        int i13 = hVar.f7380q;
        if (i13 == 1) {
            float f19 = Float.isNaN(hVar.f7376m) ? f12 : hVar.f7376m;
            float f20 = oVar2.f7483e;
            float f21 = oVar.f7483e;
            this.f7483e = (f19 * (f20 - f21)) + f21;
            if (!Float.isNaN(hVar.f7377n)) {
                f12 = hVar.f7377n;
            }
            float f22 = oVar2.f7484f;
            float f23 = oVar.f7484f;
            this.f7484f = (f12 * (f22 - f23)) + f23;
        } else if (i13 != 2) {
            float f24 = Float.isNaN(hVar.f7376m) ? f12 : hVar.f7376m;
            float f25 = oVar2.f7483e;
            float f26 = oVar.f7483e;
            this.f7483e = (f24 * (f25 - f26)) + f26;
            if (!Float.isNaN(hVar.f7377n)) {
                f12 = hVar.f7377n;
            }
            float f27 = oVar2.f7484f;
            float f28 = oVar.f7484f;
            this.f7484f = (f12 * (f27 - f28)) + f28;
        } else {
            if (Float.isNaN(hVar.f7376m)) {
                float f29 = oVar2.f7483e;
                float f30 = oVar.f7483e;
                min = ((f29 - f30) * f12) + f30;
            } else {
                min = Math.min(f14, f13) * hVar.f7376m;
            }
            this.f7483e = min;
            if (Float.isNaN(hVar.f7377n)) {
                float f31 = oVar2.f7484f;
                float f32 = oVar.f7484f;
                f11 = (f12 * (f31 - f32)) + f32;
            } else {
                f11 = hVar.f7377n;
            }
            this.f7484f = f11;
        }
        this.f7490l = oVar.f7490l;
        this.f7479a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f7371h);
        this.f7489k = hVar.f7372i;
    }

    void p(int i11, int i12, h hVar, o oVar, o oVar2) {
        float f11 = hVar.f7325a / 100.0f;
        this.f7481c = f11;
        this.f7480b = hVar.f7373j;
        float f12 = Float.isNaN(hVar.f7374k) ? f11 : hVar.f7374k;
        float f13 = Float.isNaN(hVar.f7375l) ? f11 : hVar.f7375l;
        float f14 = oVar2.f7485g;
        float f15 = oVar.f7485g;
        float f16 = oVar2.f7486h;
        float f17 = oVar.f7486h;
        this.f7482d = this.f7481c;
        float f18 = oVar.f7483e;
        float f19 = oVar.f7484f;
        float f20 = oVar2.f7483e + (f14 / 2.0f);
        float f21 = oVar2.f7484f + (f16 / 2.0f);
        float f22 = (f14 - f15) * f12;
        this.f7483e = (int) ((f18 + ((f20 - ((f15 / 2.0f) + f18)) * f11)) - (f22 / 2.0f));
        float f23 = (f16 - f17) * f13;
        this.f7484f = (int) ((f19 + ((f21 - (f19 + (f17 / 2.0f))) * f11)) - (f23 / 2.0f));
        this.f7485g = (int) (f15 + f22);
        this.f7486h = (int) (f17 + f23);
        this.f7494p = 2;
        if (!Float.isNaN(hVar.f7376m)) {
            this.f7483e = (int) (hVar.f7376m * ((int) (i11 - this.f7485g)));
        }
        if (!Float.isNaN(hVar.f7377n)) {
            this.f7484f = (int) (hVar.f7377n * ((int) (i12 - this.f7486h)));
        }
        this.f7490l = this.f7490l;
        this.f7479a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f7371h);
        this.f7489k = hVar.f7372i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f11, float f12, float f13, float f14) {
        this.f7483e = f11;
        this.f7484f = f12;
        this.f7485g = f13;
        this.f7486h = f14;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f11, float f12, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f17 = (float) dArr[i11];
            double d11 = dArr2[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f13 = f17;
            } else if (i12 == 2) {
                f15 = f17;
            } else if (i12 == 3) {
                f14 = f17;
            } else if (i12 == 4) {
                f16 = f17;
            }
        }
        float f18 = f13 - ((0.0f * f14) / 2.0f);
        float f19 = f15 - ((0.0f * f16) / 2.0f);
        fArr[0] = (f18 * (1.0f - f11)) + (((f14 * 1.0f) + f18) * f11) + 0.0f;
        fArr[1] = (f19 * (1.0f - f12)) + (((f16 * 1.0f) + f19) * f12) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void s(float f11, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f12;
        float f13;
        float f14 = this.f7483e;
        float f15 = this.f7484f;
        float f16 = this.f7485g;
        float f17 = this.f7486h;
        if (iArr.length != 0 && this.f7496r.length <= iArr[iArr.length - 1]) {
            int i11 = iArr[iArr.length - 1] + 1;
            this.f7496r = new double[i11];
            this.f7497s = new double[i11];
        }
        Arrays.fill(this.f7496r, Double.NaN);
        for (int i12 = 0; i12 < iArr.length; i12++) {
            double[] dArr4 = this.f7496r;
            int i13 = iArr[i12];
            dArr4[i13] = dArr[i12];
            this.f7497s[i13] = dArr2[i12];
        }
        float f18 = Float.NaN;
        int i14 = 0;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        while (true) {
            double[] dArr5 = this.f7496r;
            if (i14 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i14]) && (dArr3 == null || dArr3[i14] == 0.0d)) {
                f13 = f18;
            } else {
                double d11 = dArr3 != null ? dArr3[i14] : 0.0d;
                if (!Double.isNaN(this.f7496r[i14])) {
                    d11 = this.f7496r[i14] + d11;
                }
                f13 = f18;
                float f23 = (float) d11;
                float f24 = (float) this.f7497s[i14];
                if (i14 == 1) {
                    f18 = f13;
                    f19 = f24;
                    f14 = f23;
                } else if (i14 == 2) {
                    f18 = f13;
                    f20 = f24;
                    f15 = f23;
                } else if (i14 == 3) {
                    f18 = f13;
                    f21 = f24;
                    f16 = f23;
                } else if (i14 == 4) {
                    f18 = f13;
                    f22 = f24;
                    f17 = f23;
                } else if (i14 == 5) {
                    f18 = f23;
                }
                i14++;
            }
            f18 = f13;
            i14++;
        }
        float f25 = f18;
        m mVar = this.f7492n;
        if (mVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            mVar.i(f11, fArr, fArr2);
            float f26 = fArr[0];
            float f27 = fArr[1];
            float f28 = fArr2[0];
            float f29 = fArr2[1];
            double d12 = f14;
            double d13 = f15;
            float sin = (float) ((f26 + (Math.sin(d13) * d12)) - (f16 / 2.0f));
            f12 = f17;
            float cos = (float) ((f27 - (Math.cos(d13) * d12)) - (f17 / 2.0f));
            double d14 = f19;
            double d15 = f20;
            float sin2 = (float) (f28 + (Math.sin(d13) * d14) + (Math.cos(d13) * d12 * d15));
            float cos2 = (float) ((f29 - (d14 * Math.cos(d13))) + (d12 * Math.sin(d13) * d15));
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f25)) {
                view.setRotation((float) (f25 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f14 = sin;
            f15 = cos;
        } else {
            f12 = f17;
            if (!Float.isNaN(f25)) {
                view.setRotation((float) (0.0f + f25 + Math.toDegrees(Math.atan2(f20 + (f22 / 2.0f), f19 + (f21 / 2.0f)))));
            }
        }
        if (view instanceof c) {
            ((c) view).layout(f14, f15, f16 + f14, f15 + f12);
            return;
        }
        float f30 = f14 + 0.5f;
        int i15 = (int) f30;
        float f31 = f15 + 0.5f;
        int i16 = (int) f31;
        int i17 = (int) (f30 + f16);
        int i18 = (int) (f31 + f12);
        int i19 = i17 - i15;
        int i20 = i18 - i16;
        if (i19 != view.getMeasuredWidth() || i20 != view.getMeasuredHeight() || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
        }
        view.layout(i15, i16, i17, i18);
    }

    public void t(m mVar, o oVar) {
        double d11 = ((this.f7483e + (this.f7485g / 2.0f)) - oVar.f7483e) - (oVar.f7485g / 2.0f);
        double d12 = ((this.f7484f + (this.f7486h / 2.0f)) - oVar.f7484f) - (oVar.f7486h / 2.0f);
        this.f7492n = mVar;
        this.f7483e = (float) Math.hypot(d12, d11);
        if (Float.isNaN(this.f7491m)) {
            this.f7484f = (float) (Math.atan2(d12, d11) + 1.5707963267948966d);
        } else {
            this.f7484f = (float) Math.toRadians(this.f7491m);
        }
    }
}
