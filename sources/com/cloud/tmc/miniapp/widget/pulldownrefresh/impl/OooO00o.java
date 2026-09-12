package com.cloud.tmc.miniapp.widget.pulldownrefresh.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class OooO00o implements com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooO0o, com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO00o, ValueAnimator.AnimatorUpdateListener {
    public View OooO00o;
    public View OooO0O0;
    public View OooO0OO;
    public View OooO0Oo;
    public View OooO0o0;
    public int OooO0o = 0;
    public boolean OooO0oO = true;
    public boolean OooO0oo = true;
    public OooO0o OooO = new OooO0o();

    public OooO00o(@NonNull View view) {
        this.OooO0OO = view;
        this.OooO0O0 = view;
        this.OooO00o = view;
    }

    public ValueAnimator.AnimatorUpdateListener OooO00o(int i11) {
        View view = this.OooO0OO;
        if (view == null || i11 == 0) {
            return null;
        }
        if ((i11 >= 0 || !com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(view, 1)) && (i11 <= 0 || !com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(this.OooO0OO, -1))) {
            return null;
        }
        this.OooO0o = i11;
        return this;
    }

    public View OooO00o(View view, PointF pointF, View view2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View OooO00o = OooO00o(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return OooO00o;
                }
            }
        }
        return view2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO00o(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            r3 = -1
            if (r7 == r3) goto L21
            android.view.View r4 = r5.OooO0O0
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L21
            if (r6 <= 0) goto L16
            float r4 = (float) r6
            r7.setTranslationY(r4)
            r7 = r0
            goto L22
        L16:
            float r4 = r7.getTranslationY()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L21
            r7.setTranslationY(r1)
        L21:
            r7 = r2
        L22:
            if (r8 == r3) goto L3e
            android.view.View r3 = r5.OooO0O0
            android.view.View r8 = r3.findViewById(r8)
            if (r8 == 0) goto L3e
            if (r6 >= 0) goto L33
            float r7 = (float) r6
            r8.setTranslationY(r7)
            goto L3f
        L33:
            float r0 = r8.getTranslationY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3e
            r8.setTranslationY(r1)
        L3e:
            r0 = r7
        L3f:
            if (r0 != 0) goto L48
            android.view.View r7 = r5.OooO0O0
            float r8 = (float) r6
            r7.setTranslationY(r8)
            goto L4d
        L48:
            android.view.View r7 = r5.OooO0O0
            r7.setTranslationY(r1)
        L4d:
            android.view.View r7 = r5.OooO0Oo
            if (r7 == 0) goto L59
            int r8 = java.lang.Math.max(r2, r6)
            float r8 = (float) r8
            r7.setTranslationY(r8)
        L59:
            android.view.View r7 = r5.OooO0o0
            if (r7 == 0) goto L65
            int r6 = java.lang.Math.min(r2, r6)
            float r6 = (float) r6
            r7.setTranslationY(r6)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.impl.OooO00o.OooO00o(int, int, int):void");
    }

    public void OooO00o(OooOOO0 oooOOO0, View view, View view2) {
        View view3 = this.OooO00o;
        boolean isInEditMode = view3.isInEditMode();
        View view4 = null;
        while (true) {
            if (view4 != null && (!(view4 instanceof NestedScrollingParent) || (view4 instanceof NestedScrollingChild))) {
                break;
            }
            boolean z10 = view4 == null;
            LinkedList linkedList = new LinkedList();
            linkedList.add(view3);
            View view5 = null;
            while (linkedList.size() > 0 && view5 == null) {
                View view6 = (View) linkedList.poll();
                if (view6 != null) {
                    if ((z10 || view6 != view3) && com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(view6)) {
                        view5 = view6;
                    } else if (view6 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view6;
                        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                            linkedList.add(viewGroup.getChildAt(i11));
                        }
                    }
                }
            }
            if (view5 != null) {
                view3 = view5;
            }
            if (view3 == view4) {
                break;
            }
            if (!isInEditMode) {
                try {
                    if (view3 instanceof CoordinatorLayout) {
                        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.setNestedScrollingEnabled(false);
                        ViewGroup viewGroup2 = (ViewGroup) view3;
                        for (int childCount = viewGroup2.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = viewGroup2.getChildAt(childCount);
                            if (childAt instanceof AppBarLayout) {
                                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.g) new com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO00o(this));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            view4 = view3;
        }
        if (view4 != null) {
            this.OooO0OO = view4;
        }
        if (view == null && view2 == null) {
            return;
        }
        this.OooO0Oo = view;
        this.OooO0o0 = view2;
        FrameLayout frameLayout = new FrameLayout(this.OooO00o.getContext());
        OooO00o.OooOo oooOo = (OooO00o.OooOo) oooOOO0;
        int indexOfChild = com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().indexOfChild(this.OooO00o);
        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().removeView(this.OooO00o);
        ViewExtKt.removeSelf(this.OooO00o);
        frameLayout.addView(this.OooO00o, 0, new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams layoutParams = this.OooO00o.getLayoutParams();
        ViewExtKt.removeSelf(frameLayout);
        com.cloud.tmc.miniapp.widget.pulldownrefresh.OooO00o.this.getLayout().addView(frameLayout, indexOfChild, layoutParams);
        this.OooO00o = frameLayout;
        if (view != null) {
            view.setTag("fixed-top");
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup3 = (ViewGroup) view.getParent();
            int indexOfChild2 = viewGroup3.indexOfChild(view);
            viewGroup3.removeView(view);
            layoutParams2.height = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0OO(view);
            viewGroup3.addView(new Space(this.OooO00o.getContext()), indexOfChild2, layoutParams2);
            frameLayout.addView(view, 1, layoutParams2);
        }
        if (view2 != null) {
            view2.setTag("fixed-bottom");
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
            int indexOfChild3 = viewGroup4.indexOfChild(view2);
            viewGroup4.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0OO(view2);
            viewGroup4.addView(new Space(this.OooO00o.getContext()), indexOfChild3, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams4);
        }
    }

    public boolean OooO00o() {
        return this.OooO0oo && this.OooO.OooO00o(this.OooO00o);
    }

    public boolean OooO0O0() {
        return this.OooO0oO && this.OooO.OooO0O0(this.OooO00o);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.OooO0o) * this.OooO0OO.getScaleY();
            View view = this.OooO0OO;
            if (view instanceof AbsListView) {
                float f11 = com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO0O0;
                ((AbsListView) view).scrollListBy((int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.OooO0o = intValue;
    }
}
