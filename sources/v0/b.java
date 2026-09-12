package v0;

import androidx.constraintlayout.core.motion.utils.j;
import androidx.constraintlayout.core.motion.utils.l;
import androidx.constraintlayout.core.motion.utils.m;
import androidx.constraintlayout.motion.widget.n;

/* loaded from: classes2.dex */
public class b extends n {

    /* renamed from: a, reason: collision with root package name */
    private m f77091a;

    /* renamed from: b, reason: collision with root package name */
    private j f77092b;

    /* renamed from: c, reason: collision with root package name */
    private l f77093c;

    public b() {
        m mVar = new m();
        this.f77091a = mVar;
        this.f77093c = mVar;
    }

    @Override // androidx.constraintlayout.motion.widget.n
    public float a() {
        return this.f77093c.a();
    }

    public void b(float f11, float f12, float f13, float f14, float f15, float f16) {
        m mVar = this.f77091a;
        this.f77093c = mVar;
        mVar.c(f11, f12, f13, f14, f15, f16);
    }

    public boolean c() {
        return this.f77093c.isStopped();
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        if (this.f77092b == null) {
            this.f77092b = new j();
        }
        j jVar = this.f77092b;
        this.f77093c = jVar;
        jVar.c(f11, f12, f13, f14, f15, f16, f17, i11);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        return this.f77093c.getInterpolation(f11);
    }
}
