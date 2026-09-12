package mp;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f69803a;

    public f(int i11) {
        this.f69803a = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        parent.getChildAdapterPosition(view);
        outRect.top = this.f69803a;
    }
}
