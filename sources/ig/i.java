package ig;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class i extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private final int f65361a;

    /* renamed from: b, reason: collision with root package name */
    private final int f65362b;

    public i(int i11, int i12) {
        this.f65361a = i11;
        this.f65362b = i12;
    }

    public /* synthetic */ i(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? -1 : i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        int i11;
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0 && (i11 = this.f65362b) > 0) {
            outRect.top = i11;
        }
        outRect.bottom = this.f65361a;
    }
}
