package ig;

import android.graphics.Rect;
import android.view.View;
import androidx.core.text.v;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.a0;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class f extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private final float f65351a;

    /* renamed from: b, reason: collision with root package name */
    private final float f65352b;

    /* renamed from: c, reason: collision with root package name */
    private final float f65353c;

    public f() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public f(float f11, float f12, float f13) {
        this.f65351a = f11;
        this.f65352b = f12;
        this.f65353c = f13;
    }

    public /* synthetic */ f(float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12, (i11 & 4) != 0 ? 0.0f : f13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
        Intrinsics.h(outRect, "outRect");
        Intrinsics.h(view, "view");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            float f11 = this.f65351a;
            if (f11 > 0.0f) {
                outRect.left = a0.a(f11);
            }
            float f12 = this.f65352b;
            if (f12 > 0.0f) {
                outRect.top = a0.a(f12);
            }
        }
        int b11 = state.b() - 1;
        float f13 = this.f65353c;
        if (f13 > 0.0f && this.f65351a > 0.0f) {
            if (childAdapterPosition == 0) {
                outRect.left = a0.a(f13);
            }
            if (childAdapterPosition == b11) {
                outRect.right = a0.a(this.f65353c);
            }
        }
        float f14 = this.f65353c;
        if (f14 > 0.0f && this.f65352b > 0.0f) {
            if (childAdapterPosition == 0) {
                outRect.top = a0.a(f14);
            }
            if (childAdapterPosition == b11) {
                outRect.bottom = a0.a(this.f65353c);
            }
        }
        if (v.a(Locale.getDefault()) == 1) {
            int i11 = outRect.left;
            outRect.left = outRect.right;
            outRect.right = i11;
        }
    }
}
