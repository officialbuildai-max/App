package ig;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f65336a;

    /* renamed from: b, reason: collision with root package name */
    private int f65337b;

    /* renamed from: c, reason: collision with root package name */
    private int f65338c;

    /* renamed from: d, reason: collision with root package name */
    private int f65339d;

    public a(int i11, int i12, int i13, int i14) {
        this.f65336a = i11;
        this.f65337b = i12;
        this.f65338c = i13;
        this.f65339d = i14;
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
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int U = gridLayoutManager.U();
            if (gridLayoutManager.getOrientation() != 1) {
                if (gridLayoutManager.getOrientation() == 0) {
                    int i11 = this.f65337b;
                    outRect.top = i11 / 2;
                    outRect.bottom = i11 / 2;
                    int i12 = ((itemCount + U) - 1) / U;
                    int i13 = childAdapterPosition / U;
                    if (i13 == 0) {
                        outRect.left = this.f65338c;
                        outRect.right = this.f65336a / 2;
                        return;
                    } else if (i13 == i12 - 1) {
                        outRect.left = this.f65336a / 2;
                        outRect.right = this.f65339d;
                        return;
                    } else {
                        int i14 = this.f65336a;
                        outRect.left = i14 / 2;
                        outRect.right = i14 / 2;
                        return;
                    }
                }
                return;
            }
            int i15 = this.f65336a;
            outRect.left = i15 / 2;
            outRect.right = i15 / 2;
            if ((adapter instanceof BaseQuickAdapter) && ((BaseQuickAdapter) adapter).s0()) {
                if (childAdapterPosition == 0) {
                    outRect.left = 0;
                    outRect.right = 0;
                    outRect.top = 0;
                    outRect.bottom = this.f65337b / 2;
                    return;
                }
                childAdapterPosition--;
            }
            int i16 = ((itemCount + U) - 1) / U;
            int i17 = childAdapterPosition / U;
            if (i17 == 0) {
                outRect.top = this.f65338c;
                outRect.bottom = this.f65337b / 2;
            } else if (i17 == i16 - 1) {
                outRect.top = this.f65337b / 2;
                outRect.bottom = this.f65339d;
            } else {
                int i18 = this.f65337b;
                outRect.top = i18 / 2;
                outRect.bottom = i18 / 2;
            }
        }
    }
}
