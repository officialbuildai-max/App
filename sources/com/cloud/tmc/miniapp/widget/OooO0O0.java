package com.cloud.tmc.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class OooO0O0 extends RecyclerView.l {
    public int OooO00o = Color.parseColor("#cccccc");
    public int OooO0O0;
    public boolean OooO0OO;
    public boolean OooO0Oo;
    public Paint OooO0o;
    public int OooO0o0;
    public Bitmap OooO0oO;

    /* loaded from: classes3.dex */
    public static final class OooO00o {
        public int OooO00o;
        public int OooO0O0 = Color.parseColor("#cccccc");
        public int OooO0OO;
        public boolean OooO0Oo;
        public boolean OooO0o0;
    }

    public final boolean OooO00o(int i11, int i12) {
        return (i11 + 1) % i12 == 0;
    }

    public final boolean OooO00o(int i11, int i12, int i13) {
        return i11 / i13 == (i12 - 1) / i13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r8 != (r2.getItemCount() - 1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002e, code lost:
    
        if (r8 != (r2.getItemCount() - 1)) goto L8;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getItemOffsets(android.graphics.Rect r5, android.view.View r6, androidx.recyclerview.widget.RecyclerView r7, androidx.recyclerview.widget.RecyclerView.y r8) {
        /*
            r4 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            int r8 = r4.OooO0o0
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L46
            boolean r8 = r4.OooO0Oo
            if (r8 != 0) goto L30
            int r8 = r7.getChildLayoutPosition(r6)
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r7.getAdapter()
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r2 = r2.getItemCount()
            int r2 = r2 - r0
            if (r8 == r2) goto L35
        L30:
            int r8 = r4.OooO0O0
            r5.set(r1, r1, r1, r8)
        L35:
            boolean r8 = r4.OooO0OO
            if (r8 == 0) goto Lc9
            int r6 = r7.getChildLayoutPosition(r6)
            if (r6 != 0) goto Lc9
            int r6 = r4.OooO0O0
            r5.set(r1, r6, r1, r6)
            goto Lc9
        L46:
            if (r8 != r0) goto L73
            boolean r8 = r4.OooO0Oo
            if (r8 != 0) goto L5e
            int r8 = r7.getChildLayoutPosition(r6)
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r7.getAdapter()
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r2 = r2.getItemCount()
            int r2 = r2 - r0
            if (r8 == r2) goto L63
        L5e:
            int r8 = r4.OooO0O0
            r5.set(r1, r1, r8, r1)
        L63:
            boolean r8 = r4.OooO0OO
            if (r8 == 0) goto Lc9
            int r6 = r7.getChildLayoutPosition(r6)
            if (r6 != 0) goto Lc9
            int r6 = r4.OooO0O0
            r5.set(r6, r1, r6, r1)
            goto Lc9
        L73:
            r2 = 2
            if (r8 != r2) goto Lc9
            androidx.recyclerview.widget.RecyclerView$m r8 = r7.getLayoutManager()
            androidx.recyclerview.widget.GridLayoutManager r8 = (androidx.recyclerview.widget.GridLayoutManager) r8
            kotlin.jvm.internal.Intrinsics.e(r8)
            int r8 = r8.U()
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r7.getAdapter()
            kotlin.jvm.internal.Intrinsics.e(r2)
            int r2 = r2.getItemCount()
            int r3 = r7.getChildLayoutPosition(r6)
            boolean r3 = r4.OooO00o(r3, r2, r8)
            if (r3 == 0) goto La6
            int r3 = r7.getChildLayoutPosition(r6)
            boolean r3 = r4.OooO00o(r3, r8)
            if (r3 == 0) goto La6
            r5.set(r1, r1, r1, r1)
            goto Lc9
        La6:
            int r3 = r7.getChildLayoutPosition(r6)
            boolean r2 = r4.OooO00o(r3, r2, r8)
            if (r2 == 0) goto Lb6
            int r6 = r4.OooO0O0
            r5.set(r1, r1, r6, r1)
            goto Lc9
        Lb6:
            int r6 = r7.getChildLayoutPosition(r6)
            int r6 = r6 + r0
            int r6 = r6 % r8
            if (r6 == 0) goto Lc4
            int r6 = r4.OooO0O0
            r5.set(r1, r1, r6, r6)
            goto Lc9
        Lc4:
            int r6 = r4.OooO0O0
            r5.set(r1, r1, r1, r6)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.OooO0O0.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$y):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDraw(Canvas c11, RecyclerView parent, RecyclerView.y state) {
        int i11;
        Intrinsics.h(c11, "c");
        Intrinsics.h(parent, "parent");
        Intrinsics.h(state, "state");
        Paint paint = this.OooO0o;
        if (paint != null) {
            paint.setColor(this.OooO00o);
        }
        int i12 = this.OooO0o0;
        int i13 = 2;
        int i14 = 0;
        if (i12 == 0) {
            int childCount = parent.getChildCount();
            if (this.OooO0OO) {
                float top = parent.getChildAt(0).getTop() - (this.OooO0O0 / 2);
                float width = parent.getWidth();
                Paint paint2 = this.OooO0o;
                Intrinsics.e(paint2);
                c11.drawLine(0, top, width, top, paint2);
            }
            for (int i15 = 0; i15 < childCount; i15++) {
                if (!this.OooO0Oo && i15 == childCount - 1) {
                    return;
                }
                float bottom = (this.OooO0O0 / 2) + parent.getChildAt(i15).getBottom();
                float width2 = parent.getWidth();
                Paint paint3 = this.OooO0o;
                Intrinsics.e(paint3);
                c11.drawLine(0, bottom, width2, bottom, paint3);
            }
            return;
        }
        if (i12 == 1) {
            int childCount2 = parent.getChildCount();
            if (this.OooO0OO) {
                float left = parent.getChildAt(0).getLeft() - (this.OooO0O0 / 2);
                float height = parent.getHeight();
                Paint paint4 = this.OooO0o;
                Intrinsics.e(paint4);
                c11.drawLine(left, 0, left, height, paint4);
            }
            for (int i16 = 0; i16 < childCount2; i16++) {
                if (!this.OooO0Oo && i16 == childCount2 - 1) {
                    return;
                }
                float right = (this.OooO0O0 / 2) + parent.getChildAt(i16).getRight();
                float height2 = parent.getHeight();
                Paint paint5 = this.OooO0o;
                Intrinsics.e(paint5);
                c11.drawLine(right, 0, right, height2, paint5);
            }
            return;
        }
        if (i12 != 2) {
            return;
        }
        int childCount3 = parent.getChildCount();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) parent.getLayoutManager();
        Intrinsics.e(gridLayoutManager);
        int U = gridLayoutManager.U();
        RecyclerView.Adapter adapter = parent.getAdapter();
        Intrinsics.e(adapter);
        int itemCount = adapter.getItemCount();
        while (i14 < childCount3) {
            View childAt = parent.getChildAt(i14);
            int right2 = (this.OooO0O0 / i13) + childAt.getRight();
            int bottom2 = (this.OooO0O0 / i13) + childAt.getBottom();
            if (OooO00o(i14, itemCount, U)) {
                i11 = bottom2;
            } else {
                float left2 = childAt.getLeft();
                float f11 = bottom2;
                float right3 = childAt.getRight() + this.OooO0O0;
                Paint paint6 = this.OooO0o;
                Intrinsics.e(paint6);
                i11 = bottom2;
                c11.drawLine(left2, f11, right3, f11, paint6);
            }
            if (OooO00o(i14, itemCount, U) && !OooO00o(i14, U)) {
                float f12 = right2;
                float top2 = childAt.getTop();
                float bottom3 = childAt.getBottom();
                Paint paint7 = this.OooO0o;
                Intrinsics.e(paint7);
                c11.drawLine(f12, top2, f12, bottom3, paint7);
            } else if (!OooO00o(i14, U)) {
                float f13 = right2;
                Paint paint8 = this.OooO0o;
                Intrinsics.e(paint8);
                c11.drawLine(f13, childAt.getTop(), f13, i11, paint8);
            }
            i14++;
            i13 = 2;
        }
    }
}
