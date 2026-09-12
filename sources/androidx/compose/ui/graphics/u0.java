package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.s4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class u0 implements Path {

    /* renamed from: b, reason: collision with root package name */
    private final android.graphics.Path f4730b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f4731c;

    /* renamed from: d, reason: collision with root package name */
    private float[] f4732d;

    /* JADX WARN: Multi-variable type inference failed */
    public u0() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public u0(android.graphics.Path path) {
        this.f4730b = path;
    }

    public /* synthetic */ u0(android.graphics.Path path, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new android.graphics.Path() : path);
    }

    private final void q(y.i iVar) {
        if (Float.isNaN(iVar.f()) || Float.isNaN(iVar.i()) || Float.isNaN(iVar.g()) || Float.isNaN(iVar.c())) {
            x0.c("Invalid rectangle, make sure no value is NaN");
        }
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean a() {
        return this.f4730b.isConvex();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void b() {
        this.f4730b.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void c(float f11, float f12) {
        this.f4730b.rMoveTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void close() {
        this.f4730b.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f4730b.rCubicTo(f11, f12, f13, f14, f15, f16);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void e(int i11) {
        this.f4730b.setFillType(q4.d(i11, q4.f4703a.a()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void f(float f11, float f12, float f13, float f14) {
        this.f4730b.quadTo(f11, f12, f13, f14);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void g(float f11, float f12, float f13, float f14) {
        this.f4730b.rQuadTo(f11, f12, f13, f14);
    }

    @Override // androidx.compose.ui.graphics.Path
    public y.i getBounds() {
        if (this.f4731c == null) {
            this.f4731c = new RectF();
        }
        RectF rectF = this.f4731c;
        Intrinsics.e(rectF);
        this.f4730b.computeBounds(rectF, true);
        return new y.i(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.graphics.Path
    public int h() {
        return this.f4730b.getFillType() == Path.FillType.EVEN_ODD ? q4.f4703a.a() : q4.f4703a.b();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void i(y.k kVar, Path.Direction direction) {
        Path.Direction d11;
        if (this.f4731c == null) {
            this.f4731c = new RectF();
        }
        RectF rectF = this.f4731c;
        Intrinsics.e(rectF);
        rectF.set(kVar.e(), kVar.g(), kVar.f(), kVar.a());
        if (this.f4732d == null) {
            this.f4732d = new float[8];
        }
        float[] fArr = this.f4732d;
        Intrinsics.e(fArr);
        fArr[0] = y.a.d(kVar.h());
        fArr[1] = y.a.e(kVar.h());
        fArr[2] = y.a.d(kVar.i());
        fArr[3] = y.a.e(kVar.i());
        fArr[4] = y.a.d(kVar.c());
        fArr[5] = y.a.e(kVar.c());
        fArr[6] = y.a.d(kVar.b());
        fArr[7] = y.a.e(kVar.b());
        android.graphics.Path path = this.f4730b;
        RectF rectF2 = this.f4731c;
        Intrinsics.e(rectF2);
        float[] fArr2 = this.f4732d;
        Intrinsics.e(fArr2);
        d11 = x0.d(direction);
        path.addRoundRect(rectF2, fArr2, d11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean isEmpty() {
        return this.f4730b.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public void j(float f11, float f12) {
        this.f4730b.moveTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void k(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.f4730b.cubicTo(f11, f12, f13, f14, f15, f16);
    }

    @Override // androidx.compose.ui.graphics.Path
    public boolean l(Path path, Path path2, int i11) {
        s4.a aVar = s4.f4713a;
        Path.Op op2 = s4.f(i11, aVar.a()) ? Path.Op.DIFFERENCE : s4.f(i11, aVar.b()) ? Path.Op.INTERSECT : s4.f(i11, aVar.c()) ? Path.Op.REVERSE_DIFFERENCE : s4.f(i11, aVar.d()) ? Path.Op.UNION : Path.Op.XOR;
        android.graphics.Path path3 = this.f4730b;
        if (!(path instanceof u0)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path p11 = ((u0) path).p();
        if (path2 instanceof u0) {
            return path3.op(p11, ((u0) path2).p(), op2);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public void m(float f11, float f12) {
        this.f4730b.rLineTo(f11, f12);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void n(y.i iVar, Path.Direction direction) {
        Path.Direction d11;
        q(iVar);
        if (this.f4731c == null) {
            this.f4731c = new RectF();
        }
        RectF rectF = this.f4731c;
        Intrinsics.e(rectF);
        rectF.set(iVar.f(), iVar.i(), iVar.g(), iVar.c());
        android.graphics.Path path = this.f4730b;
        RectF rectF2 = this.f4731c;
        Intrinsics.e(rectF2);
        d11 = x0.d(direction);
        path.addRect(rectF2, d11);
    }

    @Override // androidx.compose.ui.graphics.Path
    public void o(float f11, float f12) {
        this.f4730b.lineTo(f11, f12);
    }

    public final android.graphics.Path p() {
        return this.f4730b;
    }

    @Override // androidx.compose.ui.graphics.Path
    public void reset() {
        this.f4730b.reset();
    }
}
