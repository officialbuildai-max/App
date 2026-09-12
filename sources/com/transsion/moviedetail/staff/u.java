package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class u extends RecyclerView.l {

    /* renamed from: a, reason: collision with root package name */
    private int f47386a;

    /* renamed from: b, reason: collision with root package name */
    private int f47387b;

    /* renamed from: c, reason: collision with root package name */
    private int f47388c;

    /* renamed from: d, reason: collision with root package name */
    private int f47389d;

    /* renamed from: e, reason: collision with root package name */
    private final int f47390e;

    public u(int i11, int i12, int i13, int i14, int i15) {
        this.f47386a = i11;
        this.f47387b = i12;
        this.f47388c = i13;
        this.f47389d = i14;
        this.f47390e = i15;
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
        boolean z10 = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        if (layoutManager instanceof GridLayoutManager) {
            int i11 = this.f47390e;
            if (i11 <= 0) {
                i11 = 1;
            }
            int i12 = childAdapterPosition % i11;
            RecyclerView.Adapter adapter = parent.getAdapter();
            Intrinsics.f(adapter, "null cannot be cast to non-null type com.transsion.moviedetail.staff.MovieStaffAdapter");
            int itemViewType = ((s) adapter).getItemViewType(childAdapterPosition);
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    outRect.left = 0;
                    outRect.right = 0;
                } else {
                    int i13 = this.f47386a;
                    outRect.left = i13;
                    outRect.right = i13;
                }
            } else if (z10) {
                if (i12 == 0) {
                    outRect.right = this.f47386a;
                    outRect.left = this.f47387b;
                } else if (i12 == this.f47390e - 1) {
                    outRect.right = this.f47387b;
                    outRect.left = this.f47386a;
                } else {
                    int i14 = this.f47387b;
                    outRect.left = i14;
                    outRect.right = i14;
                }
            } else if (i12 == 0) {
                outRect.left = this.f47386a;
                outRect.right = this.f47387b;
            } else if (i12 == this.f47390e - 1) {
                outRect.left = this.f47387b;
                outRect.right = this.f47386a;
            } else {
                int i15 = this.f47387b;
                outRect.left = i15;
                outRect.right = i15;
            }
            outRect.bottom = this.f47389d;
        }
    }
}
