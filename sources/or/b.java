package or;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f71231a;

    /* renamed from: b, reason: collision with root package name */
    private int f71232b;

    /* renamed from: c, reason: collision with root package name */
    private int f71233c;

    /* renamed from: d, reason: collision with root package name */
    private int f71234d;

    public b(int i11, int i12, int i13, int i14) {
        this.f71231a = i11;
        this.f71232b = i12;
        this.f71233c = i13;
        this.f71234d = i14;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.m layoutManager = parent.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).Q();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                int a11 = ((StaggeredGridLayoutManager.b) layoutParams).a();
                if (childAdapterPosition == 0) {
                    outRect.left = 0;
                    outRect.right = 0;
                    return;
                }
                outRect.bottom = a0.a(16.0f);
                if (a11 == 0) {
                    outRect.left = this.f71231a;
                    outRect.right = this.f71232b;
                    return;
                } else {
                    outRect.left = this.f71232b;
                    outRect.right = this.f71231a;
                    return;
                }
            }
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int U = gridLayoutManager.U();
        int e11 = gridLayoutManager.Y().e(childAdapterPosition, U);
        boolean z10 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (e11 == 0) {
            if (z10) {
                outRect.left = this.f71232b;
                outRect.right = this.f71231a;
            } else {
                outRect.left = this.f71231a;
                outRect.right = this.f71232b;
            }
        } else if (e11 != U - 1) {
            int i11 = this.f71232b;
            outRect.left = i11;
            outRect.right = i11;
        } else if (z10) {
            outRect.left = this.f71231a;
            outRect.right = this.f71232b;
        } else {
            outRect.left = this.f71232b;
            outRect.right = this.f71231a;
        }
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if ((adapter instanceof BaseQuickAdapter) && ((BaseQuickAdapter) adapter).s0()) {
            if (childAdapterPosition == 0) {
                outRect.left = 0;
                outRect.right = 0;
                outRect.top = 0;
                outRect.bottom = this.f71234d / 2;
                return;
            }
            childAdapterPosition--;
        }
        int i12 = (itemCount / U) + (itemCount % U != 0 ? 1 : 0);
        int i13 = childAdapterPosition / U;
        if (i13 == 0) {
            outRect.top = 0;
            outRect.bottom = this.f71234d / 2;
        } else if (i13 == i12 - 1) {
            outRect.top = this.f71233c / 2;
            outRect.bottom = 0;
        } else {
            outRect.top = this.f71233c / 2;
            outRect.bottom = this.f71234d / 2;
        }
    }
}
