package m4;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.x;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.p0;

/* loaded from: classes2.dex */
public class i extends a {
    private final n4.a A;
    private n4.q B;

    /* renamed from: r, reason: collision with root package name */
    private final String f69358r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f69359s;

    /* renamed from: t, reason: collision with root package name */
    private final x f69360t;

    /* renamed from: u, reason: collision with root package name */
    private final x f69361u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f69362v;

    /* renamed from: w, reason: collision with root package name */
    private final GradientType f69363w;

    /* renamed from: x, reason: collision with root package name */
    private final int f69364x;

    /* renamed from: y, reason: collision with root package name */
    private final n4.a f69365y;

    /* renamed from: z, reason: collision with root package name */
    private final n4.a f69366z;

    public i(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(lottieDrawable, aVar, aVar2.b().toPaintCap(), aVar2.g().toPaintJoin(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.f69360t = new x();
        this.f69361u = new x();
        this.f69362v = new RectF();
        this.f69358r = aVar2.j();
        this.f69363w = aVar2.f();
        this.f69359s = aVar2.n();
        this.f69364x = (int) (lottieDrawable.O().d() / 32.0f);
        n4.a a11 = aVar2.e().a();
        this.f69365y = a11;
        a11.a(this);
        aVar.i(a11);
        n4.a a12 = aVar2.l().a();
        this.f69366z = a12;
        a12.a(this);
        aVar.i(a12);
        n4.a a13 = aVar2.d().a();
        this.A = a13;
        a13.a(this);
        aVar.i(a13);
    }

    private int[] j(int[] iArr) {
        n4.q qVar = this.B;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i11 = 0;
            if (iArr.length == numArr.length) {
                while (i11 < iArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i11 < numArr.length) {
                    iArr[i11] = numArr[i11].intValue();
                    i11++;
                }
            }
        }
        return iArr;
    }

    private int k() {
        int round = Math.round(this.f69366z.f() * this.f69364x);
        int round2 = Math.round(this.A.f() * this.f69364x);
        int round3 = Math.round(this.f69365y.f() * this.f69364x);
        int i11 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i11 = i11 * 31 * round2;
        }
        return round3 != 0 ? i11 * 31 * round3 : i11;
    }

    private LinearGradient l() {
        long k11 = k();
        LinearGradient linearGradient = (LinearGradient) this.f69360t.e(k11);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f69366z.h();
        PointF pointF2 = (PointF) this.A.h();
        r4.d dVar = (r4.d) this.f69365y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, j(dVar.d()), dVar.e(), Shader.TileMode.CLAMP);
        this.f69360t.k(k11, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient m() {
        long k11 = k();
        RadialGradient radialGradient = (RadialGradient) this.f69361u.e(k11);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f69366z.h();
        PointF pointF2 = (PointF) this.A.h();
        r4.d dVar = (r4.d) this.f69365y.h();
        int[] j11 = j(dVar.d());
        float[] e11 = dVar.e();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), j11, e11, Shader.TileMode.CLAMP);
        this.f69361u.k(k11, radialGradient2);
        return radialGradient2;
    }

    @Override // m4.a, p4.e
    public void b(Object obj, w4.c cVar) {
        super.b(obj, cVar);
        if (obj == p0.L) {
            n4.q qVar = this.B;
            if (qVar != null) {
                this.f69290f.H(qVar);
            }
            if (cVar == null) {
                this.B = null;
                return;
            }
            n4.q qVar2 = new n4.q(cVar);
            this.B = qVar2;
            qVar2.a(this);
            this.f69290f.i(this.B);
        }
    }

    @Override // m4.c
    public String getName() {
        return this.f69358r;
    }

    @Override // m4.a, m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        if (this.f69359s) {
            return;
        }
        f(this.f69362v, matrix, false);
        Shader l11 = this.f69363w == GradientType.LINEAR ? l() : m();
        l11.setLocalMatrix(matrix);
        this.f69293i.setShader(l11);
        super.h(canvas, matrix, i11);
    }
}
