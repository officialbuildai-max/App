package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class h extends RecyclerView.x {

    /* renamed from: k, reason: collision with root package name */
    protected PointF f14471k;

    /* renamed from: l, reason: collision with root package name */
    private final DisplayMetrics f14472l;

    /* renamed from: n, reason: collision with root package name */
    private float f14474n;

    /* renamed from: i, reason: collision with root package name */
    protected final LinearInterpolator f14469i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    protected final DecelerateInterpolator f14470j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    private boolean f14473m = false;

    /* renamed from: o, reason: collision with root package name */
    protected int f14475o = 0;

    /* renamed from: p, reason: collision with root package name */
    protected int f14476p = 0;

    public h(Context context) {
        this.f14472l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f14473m) {
            this.f14474n = v(this.f14472l);
            this.f14473m = true;
        }
        return this.f14474n;
    }

    private int y(int i11, int i12) {
        int i13 = i11 - i12;
        if (i11 * i13 <= 0) {
            return 0;
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int B() {
        PointF pointF = this.f14471k;
        if (pointF != null) {
            float f11 = pointF.y;
            if (f11 != 0.0f) {
                return f11 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.x.a aVar) {
        PointF a11 = a(f());
        if (a11 == null || (a11.x == 0.0f && a11.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a11);
        this.f14471k = a11;
        this.f14475o = (int) (a11.x * 10000.0f);
        this.f14476p = (int) (a11.y * 10000.0f);
        aVar.d((int) (this.f14475o * 1.2f), (int) (this.f14476p * 1.2f), (int) (x(10000) * 1.2f), this.f14469i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void l(int i11, int i12, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f14475o = y(this.f14475o, i11);
        int y10 = y(this.f14476p, i12);
        this.f14476p = y10;
        if (this.f14475o == 0 && y10 == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void n() {
        this.f14476p = 0;
        this.f14475o = 0;
        this.f14471k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void o(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        int t11 = t(view, z());
        int u11 = u(view, B());
        int w11 = w((int) Math.sqrt((t11 * t11) + (u11 * u11)));
        if (w11 > 0) {
            aVar.d(-t11, -u11, w11, this.f14470j);
        }
    }

    public int s(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == -1) {
            return i13 - i11;
        }
        if (i15 != 0) {
            if (i15 == 1) {
                return i14 - i12;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i16 = i13 - i11;
        if (i16 > 0) {
            return i16;
        }
        int i17 = i14 - i12;
        if (i17 < 0) {
            return i17;
        }
        return 0;
    }

    public int t(View view, int i11) {
        RecyclerView.m e11 = e();
        if (e11 == null || !e11.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return s(e11.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, e11.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, e11.getPaddingLeft(), e11.getWidth() - e11.getPaddingRight(), i11);
    }

    public int u(View view, int i11) {
        RecyclerView.m e11 = e();
        if (e11 == null || !e11.canScrollVertically()) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        return s(e11.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, e11.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin, e11.getPaddingTop(), e11.getHeight() - e11.getPaddingBottom(), i11);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(int i11) {
        return (int) Math.ceil(x(i11) / 0.3356d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x(int i11) {
        return (int) Math.ceil(Math.abs(i11) * A());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int z() {
        PointF pointF = this.f14471k;
        if (pointF != null) {
            float f11 = pointF.x;
            if (f11 != 0.0f) {
                return f11 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
