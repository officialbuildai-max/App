package ig;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class h extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f65356a;

    /* renamed from: b, reason: collision with root package name */
    private int f65357b;

    /* renamed from: c, reason: collision with root package name */
    private float f65358c;

    /* renamed from: d, reason: collision with root package name */
    private float f65359d;

    /* renamed from: e, reason: collision with root package name */
    private float f65360e;

    public h(int i11, int i12) {
        this.f65356a = i11;
        if (i12 > 1) {
            int a11 = a0.a(((i12 - 1) * 8) + 24.0f) / i12;
            float a12 = a0.a(12.0f);
            this.f65359d = a12;
            float f11 = a11;
            this.f65358c = f11 - a12;
            this.f65360e = f11 / 2.0f;
        }
    }

    public final void d(int i11) {
        this.f65357b = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
            outRect.bottom = 0;
        } else if (this.f65357b != 0 && (Intrinsics.c(view.getTag(), "TrendingTitle") || Intrinsics.c(view.getTag(), "UGCFeedsBig"))) {
            outRect.bottom = this.f65357b;
        } else if (Intrinsics.c(view.getTag(), "TrendingMargin")) {
            outRect.bottom = 0;
        } else {
            outRect.bottom = this.f65356a;
        }
        RecyclerView.m layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int U = gridLayoutManager.U();
            int f11 = gridLayoutManager.Y().f(childAdapterPosition);
            int e11 = gridLayoutManager.Y().e(childAdapterPosition, U);
            if (f11 == U) {
                return;
            }
            float f12 = this.f65359d;
            if (f12 > 0.0f) {
                if (e11 == 0) {
                    outRect.left = (int) f12;
                    outRect.right = (int) this.f65358c;
                } else if (e11 == U - f11) {
                    outRect.left = (int) this.f65358c;
                    outRect.right = (int) f12;
                } else {
                    float f13 = this.f65360e;
                    outRect.left = (int) f13;
                    outRect.right = (int) f13;
                }
                outRect.bottom = this.f65357b;
            }
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                int i11 = outRect.left;
                outRect.left = outRect.right;
                outRect.right = i11;
            }
        }
    }
}
