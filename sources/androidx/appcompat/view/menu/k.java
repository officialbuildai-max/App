package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.l;
import androidx.core.view.GravityCompat;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1582a;

    /* renamed from: b, reason: collision with root package name */
    private final f f1583b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f1584c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1585d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1586e;

    /* renamed from: f, reason: collision with root package name */
    private View f1587f;

    /* renamed from: g, reason: collision with root package name */
    private int f1588g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1589h;

    /* renamed from: i, reason: collision with root package name */
    private l.a f1590i;

    /* renamed from: j, reason: collision with root package name */
    private j f1591j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f1592k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f1593l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            k.this.e();
        }
    }

    public k(Context context, f fVar, View view, boolean z10, int i11) {
        this(context, fVar, view, z10, i11, 0);
    }

    public k(Context context, f fVar, View view, boolean z10, int i11, int i12) {
        this.f1588g = GravityCompat.START;
        this.f1593l = new a();
        this.f1582a = context;
        this.f1583b = fVar;
        this.f1587f = view;
        this.f1584c = z10;
        this.f1585d = i11;
        this.f1586e = i12;
    }

    private j a() {
        Display defaultDisplay = ((WindowManager) this.f1582a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        j cascadingMenuPopup = Math.min(point.x, point.y) >= this.f1582a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f1582a, this.f1587f, this.f1585d, this.f1586e, this.f1584c) : new p(this.f1582a, this.f1583b, this.f1587f, this.f1585d, this.f1586e, this.f1584c);
        cascadingMenuPopup.l(this.f1583b);
        cascadingMenuPopup.v(this.f1593l);
        cascadingMenuPopup.q(this.f1587f);
        cascadingMenuPopup.d(this.f1590i);
        cascadingMenuPopup.s(this.f1589h);
        cascadingMenuPopup.t(this.f1588g);
        return cascadingMenuPopup;
    }

    private void l(int i11, int i12, boolean z10, boolean z11) {
        j c11 = c();
        c11.w(z11);
        if (z10) {
            if ((GravityCompat.getAbsoluteGravity(this.f1588g, this.f1587f.getLayoutDirection()) & 7) == 5) {
                i11 -= this.f1587f.getWidth();
            }
            c11.u(i11);
            c11.x(i12);
            int i13 = (int) ((this.f1582a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c11.r(new Rect(i11 - i13, i12 - i13, i11 + i13, i12 + i13));
        }
        c11.show();
    }

    public void b() {
        if (d()) {
            this.f1591j.dismiss();
        }
    }

    public j c() {
        if (this.f1591j == null) {
            this.f1591j = a();
        }
        return this.f1591j;
    }

    public boolean d() {
        j jVar = this.f1591j;
        return jVar != null && jVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f1591j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1592k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f1587f = view;
    }

    public void g(boolean z10) {
        this.f1589h = z10;
        j jVar = this.f1591j;
        if (jVar != null) {
            jVar.s(z10);
        }
    }

    public void h(int i11) {
        this.f1588g = i11;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1592k = onDismissListener;
    }

    public void j(l.a aVar) {
        this.f1590i = aVar;
        j jVar = this.f1591j;
        if (jVar != null) {
            jVar.d(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f1587f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i11, int i12) {
        if (d()) {
            return true;
        }
        if (this.f1587f == null) {
            return false;
        }
        l(i11, i12, true, true);
        return true;
    }
}
