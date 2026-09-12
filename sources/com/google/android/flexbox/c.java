package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.MarginLayoutParamsCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.flexbox.a f28207a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f28208b;

    /* renamed from: c, reason: collision with root package name */
    int[] f28209c;

    /* renamed from: d, reason: collision with root package name */
    long[] f28210d;

    /* renamed from: e, reason: collision with root package name */
    private long[] f28211e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        List f28212a;

        /* renamed from: b, reason: collision with root package name */
        int f28213b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            this.f28212a = null;
            this.f28213b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.flexbox.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0385c implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        int f28214a;

        /* renamed from: b, reason: collision with root package name */
        int f28215b;

        private C0385c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0385c c0385c) {
            int i11 = this.f28215b;
            int i12 = c0385c.f28215b;
            return i11 != i12 ? i11 - i12 : this.f28214a - c0385c.f28214a;
        }

        public String toString() {
            return "Order{order=" + this.f28215b + ", index=" + this.f28214a + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.android.flexbox.a aVar) {
        this.f28207a = aVar;
    }

    private int A(int i11, FlexItem flexItem, int i12) {
        com.google.android.flexbox.a aVar = this.f28207a;
        int childWidthMeasureSpec = aVar.getChildWidthMeasureSpec(i11, aVar.getPaddingLeft() + this.f28207a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i12, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        return size > flexItem.getMaxWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int B(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    private int C(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    private int D(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    private int E(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    private int F(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int G(FlexItem flexItem, boolean z10) {
        return z10 ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int H(boolean z10) {
        return z10 ? this.f28207a.getPaddingBottom() : this.f28207a.getPaddingEnd();
    }

    private int I(boolean z10) {
        return z10 ? this.f28207a.getPaddingEnd() : this.f28207a.getPaddingBottom();
    }

    private int J(boolean z10) {
        return z10 ? this.f28207a.getPaddingTop() : this.f28207a.getPaddingStart();
    }

    private int K(boolean z10) {
        return z10 ? this.f28207a.getPaddingStart() : this.f28207a.getPaddingTop();
    }

    private int L(View view, boolean z10) {
        return z10 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int M(View view, boolean z10) {
        return z10 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean N(int i11, int i12, com.google.android.flexbox.b bVar) {
        return i11 == i12 - 1 && bVar.c() != 0;
    }

    private boolean P(View view, int i11, int i12, int i13, int i14, FlexItem flexItem, int i15, int i16, int i17) {
        if (this.f28207a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        int maxLine = this.f28207a.getMaxLine();
        if (maxLine != -1 && maxLine <= i17 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f28207a.getDecorationLengthMainAxis(view, i15, i16);
        if (decorationLengthMainAxis > 0) {
            i14 += decorationLengthMainAxis;
        }
        return i12 < i13 + i14;
    }

    private void T(int i11, int i12, com.google.android.flexbox.b bVar, int i13, int i14, boolean z10) {
        int i15;
        int i16;
        int i17;
        int i18 = bVar.f28193e;
        float f11 = bVar.f28199k;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 > i18) {
            return;
        }
        float f13 = (i18 - i13) / f11;
        bVar.f28193e = i14 + bVar.f28194f;
        if (!z10) {
            bVar.f28195g = Integer.MIN_VALUE;
        }
        int i19 = 0;
        boolean z11 = false;
        int i20 = 0;
        float f14 = 0.0f;
        while (i19 < bVar.f28196h) {
            int i21 = bVar.f28203o + i19;
            View reorderedFlexItemAt = this.f28207a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i15 = i18;
                i16 = i19;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f28207a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i15 = i18;
                    int i22 = i19;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f28211e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i21]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f28211e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i21]);
                    }
                    if (this.f28208b[i21] || flexItem.getFlexShrink() <= 0.0f) {
                        i16 = i22;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f13);
                        i16 = i22;
                        if (i16 == bVar.f28196h - 1) {
                            flexShrink += f14;
                            f14 = 0.0f;
                        }
                        int round = Math.round(flexShrink);
                        if (round < flexItem.getMinWidth()) {
                            round = flexItem.getMinWidth();
                            this.f28208b[i21] = true;
                            bVar.f28199k -= flexItem.getFlexShrink();
                            z11 = true;
                        } else {
                            f14 += flexShrink - round;
                            double d11 = f14;
                            if (d11 > 1.0d) {
                                round++;
                                f14 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                round--;
                                f14 += 1.0f;
                            }
                        }
                        int z12 = z(i12, flexItem, bVar.f28201m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, z12);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, makeMeasureSpec, z12, reorderedFlexItemAt);
                        this.f28207a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i20, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f28207a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f28193e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i17 = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f28211e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i21]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f28211e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i21]);
                    }
                    if (this.f28208b[i21] || flexItem.getFlexShrink() <= f12) {
                        i15 = i18;
                        i16 = i19;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f13);
                        if (i19 == bVar.f28196h - 1) {
                            flexShrink2 += f14;
                            f14 = f12;
                        }
                        int round2 = Math.round(flexShrink2);
                        if (round2 < flexItem.getMinHeight()) {
                            round2 = flexItem.getMinHeight();
                            this.f28208b[i21] = true;
                            bVar.f28199k -= flexItem.getFlexShrink();
                            i15 = i18;
                            i16 = i19;
                            z11 = true;
                        } else {
                            f14 += flexShrink2 - round2;
                            i15 = i18;
                            i16 = i19;
                            double d12 = f14;
                            if (d12 > 1.0d) {
                                round2++;
                                f14 -= 1.0f;
                            } else if (d12 < -1.0d) {
                                round2--;
                                f14 += 1.0f;
                            }
                        }
                        int A = A(i11, flexItem, bVar.f28201m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(A, makeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, A, makeMeasureSpec2, reorderedFlexItemAt);
                        this.f28207a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    i17 = Math.max(i20, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f28207a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f28193e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                bVar.f28195g = Math.max(bVar.f28195g, i17);
                i20 = i17;
            }
            i19 = i16 + 1;
            i18 = i15;
            f12 = 0.0f;
        }
        int i23 = i18;
        if (!z11 || i23 == bVar.f28193e) {
            return;
        }
        T(i11, i12, bVar, i13, i14, true);
    }

    private int[] U(int i11, List list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i11];
        Iterator it = list.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            C0385c c0385c = (C0385c) it.next();
            int i13 = c0385c.f28214a;
            iArr[i12] = i13;
            sparseIntArray.append(i13, c0385c.f28215b);
            i12++;
        }
        return iArr;
    }

    private void V(View view, int i11, int i12) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f28207a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f28211e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i12]) : view.getMeasuredHeight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i12, makeMeasureSpec2, makeMeasureSpec, view);
        this.f28207a.updateViewCache(i12, view);
    }

    private void W(View view, int i11, int i12) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i11 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f28207a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f28211e;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i12]) : view.getMeasuredWidth(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i12, makeMeasureSpec, makeMeasureSpec2, view);
        this.f28207a.updateViewCache(i12, view);
    }

    private void Z(int i11, int i12, int i13, View view) {
        long[] jArr = this.f28210d;
        if (jArr != null) {
            jArr[i11] = S(i12, i13);
        }
        long[] jArr2 = this.f28211e;
        if (jArr2 != null) {
            jArr2[i11] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List list, com.google.android.flexbox.b bVar, int i11, int i12) {
        bVar.f28201m = i12;
        this.f28207a.onNewFlexLineAdded(bVar);
        bVar.f28204p = i11;
        list.add(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            com.google.android.flexbox.a r0 = r6.f28207a
            r0.updateViewCache(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.c.i(android.view.View, int):void");
    }

    private List k(List list, int i11, int i12) {
        int i13 = (i11 - i12) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
        bVar.f28195g = i13;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            if (i14 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add((com.google.android.flexbox.b) list.get(i14));
            if (i14 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private List l(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            FlexItem flexItem = (FlexItem) this.f28207a.getFlexItemAt(i12).getLayoutParams();
            C0385c c0385c = new C0385c();
            c0385c.f28215b = flexItem.getOrder();
            c0385c.f28214a = i12;
            arrayList.add(c0385c);
        }
        return arrayList;
    }

    private void r(int i11) {
        boolean[] zArr = this.f28208b;
        if (zArr == null) {
            this.f28208b = new boolean[Math.max(i11, 10)];
        } else if (zArr.length < i11) {
            this.f28208b = new boolean[Math.max(zArr.length * 2, i11)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable a11 = androidx.core.widget.c.a(compoundButton);
        int minimumWidth = a11 == null ? 0 : a11.getMinimumWidth();
        int minimumHeight = a11 != null ? a11.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void w(int i11, int i12, com.google.android.flexbox.b bVar, int i13, int i14, boolean z10) {
        int i15;
        int i16;
        int i17;
        double d11;
        int i18;
        double d12;
        float f11 = bVar.f28198j;
        float f12 = 0.0f;
        if (f11 <= 0.0f || i13 < (i15 = bVar.f28193e)) {
            return;
        }
        float f13 = (i13 - i15) / f11;
        bVar.f28193e = i14 + bVar.f28194f;
        if (!z10) {
            bVar.f28195g = Integer.MIN_VALUE;
        }
        int i19 = 0;
        boolean z11 = false;
        int i20 = 0;
        float f14 = 0.0f;
        while (i19 < bVar.f28196h) {
            int i21 = bVar.f28203o + i19;
            View reorderedFlexItemAt = this.f28207a.getReorderedFlexItemAt(i21);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i16 = i15;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f28207a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i22 = i15;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f28211e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i21]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f28211e;
                    i16 = i22;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i21]);
                    }
                    if (!this.f28208b[i21] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f13);
                        if (i19 == bVar.f28196h - 1) {
                            flexGrow += f14;
                            f14 = 0.0f;
                        }
                        int round = Math.round(flexGrow);
                        if (round > flexItem.getMaxWidth()) {
                            round = flexItem.getMaxWidth();
                            this.f28208b[i21] = true;
                            bVar.f28198j -= flexItem.getFlexGrow();
                            z11 = true;
                        } else {
                            f14 += flexGrow - round;
                            double d13 = f14;
                            if (d13 > 1.0d) {
                                round++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                round--;
                                d11 = d13 + 1.0d;
                            }
                            f14 = (float) d11;
                        }
                        int z12 = z(i12, flexItem, bVar.f28201m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        reorderedFlexItemAt.measure(makeMeasureSpec, z12);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, makeMeasureSpec, z12, reorderedFlexItemAt);
                        this.f28207a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int max = Math.max(i20, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f28207a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f28193e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i17 = max;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f28211e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i21]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f28211e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i21]);
                    }
                    if (this.f28208b[i21] || flexItem.getFlexGrow() <= f12) {
                        i18 = i15;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f13);
                        if (i19 == bVar.f28196h - 1) {
                            flexGrow2 += f14;
                            f14 = f12;
                        }
                        int round2 = Math.round(flexGrow2);
                        if (round2 > flexItem.getMaxHeight()) {
                            round2 = flexItem.getMaxHeight();
                            this.f28208b[i21] = true;
                            bVar.f28198j -= flexItem.getFlexGrow();
                            i18 = i15;
                            z11 = true;
                        } else {
                            f14 += flexGrow2 - round2;
                            i18 = i15;
                            double d14 = f14;
                            if (d14 > 1.0d) {
                                round2++;
                                d12 = d14 - 1.0d;
                            } else if (d14 < -1.0d) {
                                round2--;
                                d12 = d14 + 1.0d;
                            }
                            f14 = (float) d12;
                        }
                        int A = A(i11, flexItem, bVar.f28201m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        reorderedFlexItemAt.measure(A, makeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i21, A, makeMeasureSpec2, reorderedFlexItemAt);
                        this.f28207a.updateViewCache(i21, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    i17 = Math.max(i20, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f28207a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f28193e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i16 = i18;
                }
                bVar.f28195g = Math.max(bVar.f28195g, i17);
                i20 = i17;
            }
            i19++;
            i15 = i16;
            f12 = 0.0f;
        }
        int i23 = i15;
        if (!z11 || i23 == bVar.f28193e) {
            return;
        }
        w(i11, i12, bVar, i13, i14, true);
    }

    private int z(int i11, FlexItem flexItem, int i12) {
        com.google.android.flexbox.a aVar = this.f28207a;
        int childHeightMeasureSpec = aVar.getChildHeightMeasureSpec(i11, aVar.getPaddingTop() + this.f28207a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i12, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        return size > flexItem.getMaxHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f28207a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i11 = 0; i11 < flexItemCount; i11++) {
            View flexItemAt = this.f28207a.getFlexItemAt(i11);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i11)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(View view, com.google.android.flexbox.b bVar, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f28207a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = bVar.f28195g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f28207a.getFlexWrap() == 2) {
                    view.layout(i11, (i12 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop(), i13, (i14 - i15) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i16 = i12 + i15;
                    view.layout(i11, (i16 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i13, i16 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i15 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f28207a.getFlexWrap() != 2) {
                    int i17 = i12 + measuredHeight;
                    view.layout(i11, i17, i13, view.getMeasuredHeight() + i17);
                    return;
                } else {
                    int i18 = i12 - measuredHeight;
                    view.layout(i11, i18, i13, view.getMeasuredHeight() + i18);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f28207a.getFlexWrap() != 2) {
                    int max = Math.max(bVar.f28200l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i11, i12 + max, i13, i14 + max);
                    return;
                } else {
                    int max2 = Math.max((bVar.f28200l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i11, i12 - max2, i13, i14 - max2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f28207a.getFlexWrap() != 2) {
            view.layout(i11, i12 + flexItem.getMarginTop(), i13, i14 + flexItem.getMarginTop());
        } else {
            view.layout(i11, i12 - flexItem.getMarginBottom(), i13, i14 - flexItem.getMarginBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(View view, com.google.android.flexbox.b bVar, boolean z10, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f28207a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i15 = bVar.f28195g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z10) {
                    view.layout((i11 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i12, (i13 - i15) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i14);
                    return;
                } else {
                    view.layout(((i11 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i12, ((i13 + i15) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i14);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i15 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z10) {
                    view.layout(i11 - measuredWidth, i12, i13 - measuredWidth, i14);
                    return;
                } else {
                    view.layout(i11 + measuredWidth, i12, i13 + measuredWidth, i14);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z10) {
            view.layout(i11 - flexItem.getMarginRight(), i12, i13 - flexItem.getMarginRight(), i14);
        } else {
            view.layout(i11 + flexItem.getMarginLeft(), i12, i13 + flexItem.getMarginLeft(), i14);
        }
    }

    long S(int i11, int i12) {
        return (i11 & 4294967295L) | (i12 << 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        Y(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(int i11) {
        View reorderedFlexItemAt;
        if (i11 >= this.f28207a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f28207a.getFlexDirection();
        if (this.f28207a.getAlignItems() != 4) {
            for (com.google.android.flexbox.b bVar : this.f28207a.getFlexLinesInternal()) {
                for (Integer num : bVar.f28202n) {
                    View reorderedFlexItemAt2 = this.f28207a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, bVar.f28195g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, bVar.f28195g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f28209c;
        List flexLinesInternal = this.f28207a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i12 = iArr != null ? iArr[i11] : 0; i12 < size; i12++) {
            com.google.android.flexbox.b bVar2 = (com.google.android.flexbox.b) flexLinesInternal.get(i12);
            int i13 = bVar2.f28196h;
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = bVar2.f28203o + i14;
                if (i14 < this.f28207a.getFlexItemCount() && (reorderedFlexItemAt = this.f28207a.getReorderedFlexItemAt(i15)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, bVar2.f28195g, i15);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, bVar2.f28195g, i15);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(b bVar, int i11, int i12, int i13, int i14, int i15, List list) {
        int i16;
        b bVar2;
        int i17;
        int i18;
        int i19;
        List list2;
        int i20;
        int i21;
        View view;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30 = i11;
        int i31 = i12;
        int i32 = i15;
        boolean isMainAxisDirectionHorizontal = this.f28207a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        List arrayList = list == null ? new ArrayList() : list;
        bVar.f28212a = arrayList;
        int i33 = i32 == -1 ? 1 : 0;
        int K = K(isMainAxisDirectionHorizontal);
        int I = I(isMainAxisDirectionHorizontal);
        int J = J(isMainAxisDirectionHorizontal);
        int H = H(isMainAxisDirectionHorizontal);
        com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
        int i34 = i14;
        bVar3.f28203o = i34;
        int i35 = I + K;
        bVar3.f28193e = i35;
        int flexItemCount = this.f28207a.getFlexItemCount();
        int i36 = i33;
        int i37 = Integer.MIN_VALUE;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            if (i34 >= flexItemCount) {
                i16 = i39;
                bVar2 = bVar;
                break;
            }
            View reorderedFlexItemAt = this.f28207a.getReorderedFlexItemAt(i34);
            if (reorderedFlexItemAt != null) {
                if (reorderedFlexItemAt.getVisibility() != 8) {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        v((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i41 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        bVar3.f28202n.add(Integer.valueOf(i34));
                    }
                    int G = G(flexItem, isMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        G = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (isMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.f28207a.getChildWidthMeasureSpec(i30, i35 + E(flexItem, true) + C(flexItem, true), G);
                        i17 = size;
                        i18 = mode;
                        int childHeightMeasureSpec = this.f28207a.getChildHeightMeasureSpec(i31, J + H + D(flexItem, true) + B(flexItem, true) + i38, F(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        Z(i34, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i19 = childWidthMeasureSpec;
                    } else {
                        i17 = size;
                        i18 = mode;
                        int childWidthMeasureSpec2 = this.f28207a.getChildWidthMeasureSpec(i31, J + H + D(flexItem, false) + B(flexItem, false) + i38, F(flexItem, false));
                        int childHeightMeasureSpec2 = this.f28207a.getChildHeightMeasureSpec(i30, E(flexItem, false) + i35 + C(flexItem, false), G);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        Z(i34, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i19 = childHeightMeasureSpec2;
                    }
                    this.f28207a.updateViewCache(i34, reorderedFlexItemAt);
                    i(reorderedFlexItemAt, i34);
                    i39 = View.combineMeasuredStates(i39, reorderedFlexItemAt.getMeasuredState());
                    int i42 = i38;
                    int i43 = i35;
                    com.google.android.flexbox.b bVar4 = bVar3;
                    int i44 = i34;
                    list2 = arrayList;
                    int i45 = i19;
                    if (P(reorderedFlexItemAt, i18, i17, bVar3.f28193e, C(flexItem, isMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, isMainAxisDirectionHorizontal) + E(flexItem, isMainAxisDirectionHorizontal), flexItem, i44, i40, arrayList.size())) {
                        if (bVar4.c() > 0) {
                            a(list2, bVar4, i44 > 0 ? i44 - 1 : 0, i42);
                            i38 = bVar4.f28195g + i42;
                        } else {
                            i38 = i42;
                        }
                        if (!isMainAxisDirectionHorizontal) {
                            i20 = i12;
                            i21 = i44;
                            view = reorderedFlexItemAt;
                            i22 = -1;
                            if (flexItem.getWidth() == -1) {
                                com.google.android.flexbox.a aVar = this.f28207a;
                                view.measure(aVar.getChildWidthMeasureSpec(i20, aVar.getPaddingLeft() + this.f28207a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i38, flexItem.getWidth()), i45);
                                i(view, i21);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            com.google.android.flexbox.a aVar2 = this.f28207a;
                            i20 = i12;
                            i22 = -1;
                            view = reorderedFlexItemAt;
                            view.measure(i45, aVar2.getChildHeightMeasureSpec(i20, aVar2.getPaddingTop() + this.f28207a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i38, flexItem.getHeight()));
                            i21 = i44;
                            i(view, i21);
                        } else {
                            i20 = i12;
                            i21 = i44;
                            view = reorderedFlexItemAt;
                            i22 = -1;
                        }
                        bVar3 = new com.google.android.flexbox.b();
                        i24 = 1;
                        bVar3.f28196h = 1;
                        i23 = i43;
                        bVar3.f28193e = i23;
                        bVar3.f28203o = i21;
                        i26 = Integer.MIN_VALUE;
                        i25 = 0;
                    } else {
                        i20 = i12;
                        i21 = i44;
                        view = reorderedFlexItemAt;
                        i22 = -1;
                        bVar3 = bVar4;
                        i23 = i43;
                        i24 = 1;
                        bVar3.f28196h++;
                        i25 = i40 + 1;
                        i38 = i42;
                        i26 = i37;
                    }
                    bVar3.f28205q = (bVar3.f28205q ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? i24 : 0);
                    bVar3.f28206r = (bVar3.f28206r ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? i24 : 0);
                    int[] iArr = this.f28209c;
                    if (iArr != null) {
                        iArr[i21] = list2.size();
                    }
                    bVar3.f28193e += M(view, isMainAxisDirectionHorizontal) + E(flexItem, isMainAxisDirectionHorizontal) + C(flexItem, isMainAxisDirectionHorizontal);
                    bVar3.f28198j += flexItem.getFlexGrow();
                    bVar3.f28199k += flexItem.getFlexShrink();
                    this.f28207a.onNewFlexItemAdded(view, i21, i25, bVar3);
                    int max = Math.max(i26, L(view, isMainAxisDirectionHorizontal) + D(flexItem, isMainAxisDirectionHorizontal) + B(flexItem, isMainAxisDirectionHorizontal) + this.f28207a.getDecorationLengthCrossAxis(view));
                    bVar3.f28195g = Math.max(bVar3.f28195g, max);
                    if (isMainAxisDirectionHorizontal) {
                        if (this.f28207a.getFlexWrap() != 2) {
                            bVar3.f28200l = Math.max(bVar3.f28200l, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            bVar3.f28200l = Math.max(bVar3.f28200l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i27 = i41;
                    if (N(i21, i27, bVar3)) {
                        a(list2, bVar3, i21, i38);
                        i38 += bVar3.f28195g;
                    }
                    i28 = i15;
                    if (i28 == i22 || list2.size() <= 0 || ((com.google.android.flexbox.b) list2.get(list2.size() - i24)).f28204p < i28 || i21 < i28 || i36 != 0) {
                        i29 = i13;
                    } else {
                        i38 = -bVar3.a();
                        i29 = i13;
                        i36 = i24;
                    }
                    if (i38 > i29 && i36 != 0) {
                        bVar2 = bVar;
                        i16 = i39;
                        break;
                    }
                    i40 = i25;
                    i37 = max;
                    i30 = i11;
                    i34 = i21 + 1;
                    flexItemCount = i27;
                    i31 = i20;
                    i35 = i23;
                    arrayList = list2;
                    size = i17;
                    mode = i18;
                    i32 = i28;
                } else {
                    bVar3.f28197i++;
                    bVar3.f28196h++;
                    if (N(i34, flexItemCount, bVar3)) {
                        a(arrayList, bVar3, i34, i38);
                    }
                }
            } else if (N(i34, flexItemCount, bVar3)) {
                a(arrayList, bVar3, i34, i38);
            }
            i17 = size;
            i18 = mode;
            i20 = i31;
            i28 = i32;
            i23 = i35;
            list2 = arrayList;
            i27 = flexItemCount;
            i21 = i34;
            i30 = i11;
            i34 = i21 + 1;
            flexItemCount = i27;
            i31 = i20;
            i35 = i23;
            arrayList = list2;
            size = i17;
            mode = i18;
            i32 = i28;
        }
        bVar2.f28213b = i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(b bVar, int i11, int i12) {
        b(bVar, i11, i12, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b bVar, int i11, int i12, int i13, int i14, List list) {
        b(bVar, i11, i12, i13, i14, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(b bVar, int i11, int i12, int i13, int i14, List list) {
        b(bVar, i11, i12, i13, 0, i14, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(b bVar, int i11, int i12) {
        b(bVar, i12, i11, Integer.MAX_VALUE, 0, -1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(b bVar, int i11, int i12, int i13, int i14, List list) {
        b(bVar, i12, i11, i13, i14, -1, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(b bVar, int i11, int i12, int i13, int i14, List list) {
        b(bVar, i12, i11, i13, 0, i14, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(List list, int i11) {
        int i12 = this.f28209c[i11];
        if (i12 == -1) {
            i12 = 0;
        }
        if (list.size() > i12) {
            list.subList(i12, list.size()).clear();
        }
        int[] iArr = this.f28209c;
        int length = iArr.length - 1;
        if (i11 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i11, length, -1);
        }
        long[] jArr = this.f28210d;
        int length2 = jArr.length - 1;
        if (i11 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i11, length2, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f28207a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i11, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f28207a.getFlexItemCount();
        List l11 = l(flexItemCount);
        C0385c c0385c = new C0385c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c0385c.f28215b = 1;
        } else {
            c0385c.f28215b = ((FlexItem) layoutParams).getOrder();
        }
        if (i11 == -1 || i11 == flexItemCount) {
            c0385c.f28214a = flexItemCount;
        } else if (i11 < this.f28207a.getFlexItemCount()) {
            c0385c.f28214a = i11;
            while (i11 < flexItemCount) {
                ((C0385c) l11.get(i11)).f28214a++;
                i11++;
            }
        } else {
            c0385c.f28214a = flexItemCount;
        }
        l11.add(c0385c);
        return U(flexItemCount + 1, l11, sparseIntArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i11, int i12, int i13) {
        int i14;
        int i15;
        int flexDirection = this.f28207a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            i14 = mode;
            i15 = size;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            i14 = View.MeasureSpec.getMode(i11);
            i15 = View.MeasureSpec.getSize(i11);
        }
        List<com.google.android.flexbox.b> flexLinesInternal = this.f28207a.getFlexLinesInternal();
        if (i14 == 1073741824) {
            int sumOfCrossSize = this.f28207a.getSumOfCrossSize() + i13;
            int i16 = 0;
            if (flexLinesInternal.size() == 1) {
                ((com.google.android.flexbox.b) flexLinesInternal.get(0)).f28195g = i15 - i13;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f28207a.getAlignContent();
                if (alignContent == 1) {
                    int i17 = i15 - sumOfCrossSize;
                    com.google.android.flexbox.b bVar = new com.google.android.flexbox.b();
                    bVar.f28195g = i17;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f28207a.setFlexLines(k(flexLinesInternal, i15, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= i15) {
                        return;
                    }
                    float size2 = (i15 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i16 < size3) {
                        arrayList.add((com.google.android.flexbox.b) flexLinesInternal.get(i16));
                        if (i16 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.b bVar2 = new com.google.android.flexbox.b();
                            if (i16 == flexLinesInternal.size() - 2) {
                                bVar2.f28195g = Math.round(f11 + size2);
                                f11 = 0.0f;
                            } else {
                                bVar2.f28195g = Math.round(size2);
                            }
                            int i18 = bVar2.f28195g;
                            f11 += size2 - i18;
                            if (f11 > 1.0f) {
                                bVar2.f28195g = i18 + 1;
                                f11 -= 1.0f;
                            } else if (f11 < -1.0f) {
                                bVar2.f28195g = i18 - 1;
                                f11 += 1.0f;
                            }
                            arrayList.add(bVar2);
                        }
                        i16++;
                    }
                    this.f28207a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= i15) {
                        this.f28207a.setFlexLines(k(flexLinesInternal, i15, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i15 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.b bVar3 = new com.google.android.flexbox.b();
                    bVar3.f28195g = size4;
                    for (com.google.android.flexbox.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.f28207a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < i15) {
                    float size5 = (i15 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f12 = 0.0f;
                    while (i16 < size6) {
                        com.google.android.flexbox.b bVar5 = (com.google.android.flexbox.b) flexLinesInternal.get(i16);
                        float f13 = bVar5.f28195g + size5;
                        if (i16 == flexLinesInternal.size() - 1) {
                            f13 += f12;
                            f12 = 0.0f;
                        }
                        int round = Math.round(f13);
                        f12 += f13 - round;
                        if (f12 > 1.0f) {
                            round++;
                            f12 -= 1.0f;
                        } else if (f12 < -1.0f) {
                            round--;
                            f12 += 1.0f;
                        }
                        bVar5.f28195g = round;
                        i16++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i11, int i12) {
        q(i11, i12, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i11, int i12, int i13) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f28207a.getFlexItemCount());
        if (i13 >= this.f28207a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f28207a.getFlexDirection();
        int flexDirection2 = this.f28207a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i11);
            size = View.MeasureSpec.getSize(i11);
            int largestMainSize = this.f28207a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f28207a.getPaddingLeft();
            paddingRight = this.f28207a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i12);
            size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                size = this.f28207a.getLargestMainSize();
            }
            paddingLeft = this.f28207a.getPaddingTop();
            paddingRight = this.f28207a.getPaddingBottom();
        }
        int i14 = paddingLeft + paddingRight;
        int[] iArr = this.f28209c;
        List flexLinesInternal = this.f28207a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i15 = iArr != null ? iArr[i13] : 0; i15 < size2; i15++) {
            com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) flexLinesInternal.get(i15);
            int i16 = bVar.f28193e;
            if (i16 < size && bVar.f28205q) {
                w(i11, i12, bVar, size, i14, false);
            } else if (i16 > size && bVar.f28206r) {
                T(i11, i12, bVar, size, i14, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i11) {
        int[] iArr = this.f28209c;
        if (iArr == null) {
            this.f28209c = new int[Math.max(i11, 10)];
        } else if (iArr.length < i11) {
            this.f28209c = Arrays.copyOf(this.f28209c, Math.max(iArr.length * 2, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i11) {
        long[] jArr = this.f28210d;
        if (jArr == null) {
            this.f28210d = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.f28210d = Arrays.copyOf(this.f28210d, Math.max(jArr.length * 2, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i11) {
        long[] jArr = this.f28211e;
        if (jArr == null) {
            this.f28211e = new long[Math.max(i11, 10)];
        } else if (jArr.length < i11) {
            this.f28211e = Arrays.copyOf(this.f28211e, Math.max(jArr.length * 2, i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(long j11) {
        return (int) (j11 >> 32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y(long j11) {
        return (int) j11;
    }
}
