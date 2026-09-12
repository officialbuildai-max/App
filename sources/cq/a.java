package cq;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f61007a;

    /* renamed from: b, reason: collision with root package name */
    private int f61008b;

    /* renamed from: c, reason: collision with root package name */
    private int f61009c;

    public a(int i11, int i12, int i13) {
        this.f61009c = i11;
        this.f61008b = i12;
        this.f61007a = i13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        parent.getChildAdapterPosition(view);
        outRect.top = this.f61009c;
        outRect.left = this.f61008b;
        outRect.right = this.f61007a;
    }
}
