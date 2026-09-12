package ig;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class g extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private final int f65354a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f65355b;

    public g(int i11, boolean z10) {
        this.f65354a = i11;
        this.f65355b = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        int a11 = ((StaggeredGridLayoutManager.b) layoutParams).a();
        RecyclerView.m layoutManager = parent.getLayoutManager();
        Intrinsics.f(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
        int Q = ((StaggeredGridLayoutManager) layoutManager).Q();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (!this.f65355b) {
            int i11 = a11 % 2;
            outRect.left = i11 == 0 ? 0 : this.f65354a / 2;
            outRect.right = i11 == 0 ? this.f65354a / 2 : 0;
            outRect.bottom = this.f65354a;
            return;
        }
        if (a11 == 0) {
            int i12 = this.f65354a;
            outRect.left = i12;
            outRect.right = i12 / 2;
        } else if (a11 == Q - 1) {
            int i13 = this.f65354a;
            outRect.left = i13 / 2;
            outRect.right = i13;
        } else {
            int i14 = this.f65354a;
            outRect.left = i14 / 2;
            outRect.right = i14 / 2;
        }
        if (childAdapterPosition < Q) {
            outRect.top = this.f65354a;
        }
        outRect.bottom = this.f65354a;
    }
}
