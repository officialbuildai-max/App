package ab;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes4.dex */
class s extends r {

    /* renamed from: f, reason: collision with root package name */
    private boolean f677f = false;

    /* renamed from: g, reason: collision with root package name */
    private float f678g = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            s sVar = s.this;
            if (sVar.f674c == null || sVar.f675d.isEmpty()) {
                return;
            }
            s sVar2 = s.this;
            RectF rectF = sVar2.f675d;
            outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, sVar2.f678g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(View view) {
        n(view);
    }

    private float m() {
        RectF rectF;
        n nVar = this.f674c;
        if (nVar == null || (rectF = this.f675d) == null) {
            return 0.0f;
        }
        return nVar.f607f.a(rectF);
    }

    private void n(View view) {
        view.setOutlineProvider(new a());
    }

    private boolean o() {
        n nVar;
        if (this.f675d.isEmpty() || (nVar = this.f674c) == null) {
            return false;
        }
        return nVar.u(this.f675d);
    }

    private boolean p() {
        n nVar;
        if (!this.f675d.isEmpty() && (nVar = this.f674c) != null && this.f673b && !nVar.u(this.f675d) && q(this.f674c)) {
            float a11 = this.f674c.r().a(this.f675d);
            float a12 = this.f674c.t().a(this.f675d);
            float a13 = this.f674c.j().a(this.f675d);
            float a14 = this.f674c.l().a(this.f675d);
            if (a11 == 0.0f && a13 == 0.0f && a12 == a14) {
                RectF rectF = this.f675d;
                rectF.set(rectF.left - a12, rectF.top, rectF.right, rectF.bottom);
                this.f678g = a12;
                return true;
            }
            if (a11 == 0.0f && a12 == 0.0f && a13 == a14) {
                RectF rectF2 = this.f675d;
                rectF2.set(rectF2.left, rectF2.top - a13, rectF2.right, rectF2.bottom);
                this.f678g = a13;
                return true;
            }
            if (a12 == 0.0f && a14 == 0.0f && a11 == a13) {
                RectF rectF3 = this.f675d;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + a11, rectF3.bottom);
                this.f678g = a11;
                return true;
            }
            if (a13 == 0.0f && a14 == 0.0f && a11 == a12) {
                RectF rectF4 = this.f675d;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + a11);
                this.f678g = a11;
                return true;
            }
        }
        return false;
    }

    private static boolean q(n nVar) {
        return (nVar.q() instanceof m) && (nVar.s() instanceof m) && (nVar.i() instanceof m) && (nVar.k() instanceof m);
    }

    @Override // ab.r
    void b(View view) {
        this.f678g = m();
        this.f677f = o() || p();
        view.setClipToOutline(!j());
        if (j()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // ab.r
    boolean j() {
        return !this.f677f || this.f672a;
    }
}
