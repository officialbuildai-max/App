package ab;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import pa.a;

/* loaded from: classes4.dex */
public abstract class r {

    /* renamed from: c, reason: collision with root package name */
    n f674c;

    /* renamed from: a, reason: collision with root package name */
    boolean f672a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f673b = false;

    /* renamed from: d, reason: collision with root package name */
    RectF f675d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    final Path f676e = new Path();

    public static r a(View view) {
        return Build.VERSION.SDK_INT >= 33 ? new t(view) : new s(view);
    }

    private boolean d() {
        RectF rectF = this.f675d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void k() {
        if (!d() || this.f674c == null) {
            return;
        }
        o.k().e(this.f674c, 1.0f, this.f675d, this.f676e);
    }

    abstract void b(View view);

    public boolean c() {
        return this.f672a;
    }

    public void e(Canvas canvas, a.InterfaceC0910a interfaceC0910a) {
        if (!j() || this.f676e.isEmpty()) {
            interfaceC0910a.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f676e);
        interfaceC0910a.a(canvas);
        canvas.restore();
    }

    public void f(View view, RectF rectF) {
        this.f675d = rectF;
        k();
        b(view);
    }

    public void g(View view, n nVar) {
        this.f674c = nVar;
        k();
        b(view);
    }

    public void h(View view, boolean z10) {
        if (z10 != this.f672a) {
            this.f672a = z10;
            b(view);
        }
    }

    public void i(View view, boolean z10) {
        this.f673b = z10;
        b(view);
    }

    abstract boolean j();
}
