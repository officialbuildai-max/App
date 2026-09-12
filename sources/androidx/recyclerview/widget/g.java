package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    int f14461b;

    /* renamed from: c, reason: collision with root package name */
    int f14462c;

    /* renamed from: d, reason: collision with root package name */
    int f14463d;

    /* renamed from: e, reason: collision with root package name */
    int f14464e;

    /* renamed from: h, reason: collision with root package name */
    boolean f14467h;

    /* renamed from: i, reason: collision with root package name */
    boolean f14468i;

    /* renamed from: a, reason: collision with root package name */
    boolean f14460a = true;

    /* renamed from: f, reason: collision with root package name */
    int f14465f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f14466g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.y yVar) {
        int i11 = this.f14462c;
        return i11 >= 0 && i11 < yVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.t tVar) {
        View o11 = tVar.o(this.f14462c);
        this.f14462c += this.f14463d;
        return o11;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f14461b + ", mCurrentPosition=" + this.f14462c + ", mItemDirection=" + this.f14463d + ", mLayoutDirection=" + this.f14464e + ", mStartLine=" + this.f14465f + ", mEndLine=" + this.f14466g + '}';
    }
}
