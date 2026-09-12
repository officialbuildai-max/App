package com.google.android.flexbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes3.dex */
public class d extends RecyclerView.l {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f28216c = {R.attr.listDivider};

    /* renamed from: a, reason: collision with root package name */
    private Drawable f28217a;

    /* renamed from: b, reason: collision with root package name */
    private int f28218b;

    public d(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f28216c);
        this.f28217a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        l(3);
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i11;
        int i12;
        int i13;
        if (g()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = recyclerView.getChildAt(i14);
                RecyclerView.n nVar = (RecyclerView.n) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                    top = this.f28217a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                    intrinsicHeight = top - this.f28217a.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    right = childAt.getRight();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                } else if (flexboxLayoutManager.Q()) {
                    i12 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + this.f28217a.getIntrinsicWidth(), right2);
                    i13 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    this.f28217a.setBounds(i13, intrinsicHeight, i12, top);
                    this.f28217a.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin) - this.f28217a.getIntrinsicWidth(), left2);
                    right = childAt.getRight();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                }
                int i15 = left;
                i12 = right + i11;
                i13 = i15;
                this.f28217a.setBounds(i13, intrinsicHeight, i12, top);
                this.f28217a.draw(canvas);
            }
        }
    }

    private void e(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i11;
        int i12;
        if (h()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = recyclerView.getChildAt(i13);
                RecyclerView.n nVar = (RecyclerView.n) childAt.getLayoutParams();
                if (flexboxLayoutManager.Q()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
                    left = this.f28217a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
                    intrinsicWidth = left - this.f28217a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                    bottom = childAt.getBottom();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + this.f28217a.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin;
                    i12 = min;
                    this.f28217a.setBounds(intrinsicWidth, max, left, i12);
                    this.f28217a.draw(canvas);
                } else {
                    max = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) nVar).topMargin) - this.f28217a.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i11 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
                }
                i12 = bottom + i11;
                this.f28217a.setBounds(intrinsicWidth, max, left, i12);
                this.f28217a.draw(canvas);
            }
        }
    }

    private boolean f(int i11, List list, FlexboxLayoutManager flexboxLayoutManager) {
        int N = flexboxLayoutManager.N(i11);
        if ((N == -1 || N >= flexboxLayoutManager.getFlexLinesInternal().size() || ((b) flexboxLayoutManager.getFlexLinesInternal().get(N)).f28203o != i11) && i11 != 0) {
            return list.size() != 0 && ((b) list.get(list.size() - 1)).f28204p == i11 - 1;
        }
        return true;
    }

    private boolean g() {
        return (this.f28218b & 1) > 0;
    }

    private boolean h() {
        return (this.f28218b & 2) > 0;
    }

    private void j(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List list) {
        if (list.size() == 0 || flexboxLayoutManager.N(i11) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (g()) {
                rect.top = this.f28217a.getIntrinsicHeight();
                rect.bottom = 0;
                return;
            } else {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
        }
        if (h()) {
            if (flexboxLayoutManager.Q()) {
                rect.right = this.f28217a.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.f28217a.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    private void k(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List list, int i12) {
        if (f(i11, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!h()) {
                rect.left = 0;
                rect.right = 0;
                return;
            } else if (flexboxLayoutManager.Q()) {
                rect.right = this.f28217a.getIntrinsicWidth();
                rect.left = 0;
                return;
            } else {
                rect.left = this.f28217a.getIntrinsicWidth();
                rect.right = 0;
                return;
            }
        }
        if (!g()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i12 == 3) {
            rect.bottom = this.f28217a.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.f28217a.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!g() && !h()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List M = flexboxLayoutManager.M();
        k(rect, childAdapterPosition, flexboxLayoutManager, M, flexboxLayoutManager.getFlexDirection());
        j(rect, childAdapterPosition, flexboxLayoutManager, M);
    }

    public void i(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f28217a = drawable;
    }

    public void l(int i11) {
        this.f28218b = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        d(canvas, recyclerView);
        e(canvas, recyclerView);
    }
}
