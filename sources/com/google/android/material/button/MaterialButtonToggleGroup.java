package com.google.android.material.button;

import ab.n;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    private static final int f28551k = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a, reason: collision with root package name */
    private final List f28552a;

    /* renamed from: b, reason: collision with root package name */
    private final d f28553b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f28554c;

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f28555d;

    /* renamed from: e, reason: collision with root package name */
    private Integer[] f28556e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28557f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28558g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f28559h;

    /* renamed from: i, reason: collision with root package name */
    private final int f28560i;

    /* renamed from: j, reason: collision with root package name */
    private Set f28561j;

    /* loaded from: classes4.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.g(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: e, reason: collision with root package name */
        private static final ab.d f28563e = new ab.a(0.0f);

        /* renamed from: a, reason: collision with root package name */
        ab.d f28564a;

        /* renamed from: b, reason: collision with root package name */
        ab.d f28565b;

        /* renamed from: c, reason: collision with root package name */
        ab.d f28566c;

        /* renamed from: d, reason: collision with root package name */
        ab.d f28567d;

        b(ab.d dVar, ab.d dVar2, ab.d dVar3, ab.d dVar4) {
            this.f28564a = dVar;
            this.f28565b = dVar3;
            this.f28566c = dVar4;
            this.f28567d = dVar2;
        }

        public static b a(b bVar) {
            ab.d dVar = f28563e;
            return new b(dVar, bVar.f28567d, dVar, bVar.f28566c);
        }

        public static b b(b bVar, View view) {
            return f0.p(view) ? c(bVar) : d(bVar);
        }

        public static b c(b bVar) {
            ab.d dVar = bVar.f28564a;
            ab.d dVar2 = bVar.f28567d;
            ab.d dVar3 = f28563e;
            return new b(dVar, dVar2, dVar3, dVar3);
        }

        public static b d(b bVar) {
            ab.d dVar = f28563e;
            return new b(dVar, dVar, bVar.f28565b, bVar.f28566c);
        }

        public static b e(b bVar, View view) {
            return f0.p(view) ? d(bVar) : c(bVar);
        }

        public static b f(b bVar) {
            ab.d dVar = bVar.f28564a;
            ab.d dVar2 = f28563e;
            return new b(dVar, dVar2, bVar.f28565b, dVar2);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i11, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d implements MaterialButton.b {
        private d() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f28551k
            android.content.Context r7 = bb.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f28552a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$d r7 = new com.google.android.material.button.MaterialButtonToggleGroup$d
            r0 = 0
            r7.<init>()
            r6.f28553b = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f28554c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.f28555d = r7
            r7 = 0
            r6.f28557f = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f28561j = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.b0.i(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f28560i = r9
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f28559h = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_android_enabled
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void b() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i11 = firstVisibleChildIndex + 1; i11 < getChildCount(); i11++) {
            MaterialButton f11 = f(i11);
            int min = Math.min(f11.getStrokeWidth(), f(i11 - 1).getStrokeWidth());
            LinearLayout.LayoutParams c11 = c(f11);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(c11, 0);
                MarginLayoutParamsCompat.setMarginStart(c11, -min);
                c11.topMargin = 0;
            } else {
                c11.bottomMargin = 0;
                c11.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(c11, 0);
            }
            f11.setLayoutParams(c11);
        }
        k(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void d(int i11, boolean z10) {
        if (i11 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i11);
            return;
        }
        HashSet hashSet = new HashSet(this.f28561j);
        if (z10 && !hashSet.contains(Integer.valueOf(i11))) {
            if (this.f28558g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i11));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i11))) {
                return;
            }
            if (!this.f28559h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i11));
            }
        }
        n(hashSet);
    }

    private void e(int i11, boolean z10) {
        Iterator it = this.f28554c.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(this, i11, z10);
        }
    }

    private MaterialButton f(int i11) {
        return (MaterialButton) getChildAt(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == view) {
                return i11;
            }
            if ((getChildAt(i12) instanceof MaterialButton) && i(i12)) {
                i11++;
            }
        }
        return -1;
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i(i11)) {
                return i11;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (i(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i11 = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if ((getChildAt(i12) instanceof MaterialButton) && i(i12)) {
                i11++;
            }
        }
        return i11;
    }

    private b h(int i11, int i12, int i13) {
        b bVar = (b) this.f28552a.get(i11);
        if (i12 == i13) {
            return bVar;
        }
        boolean z10 = getOrientation() == 0;
        if (i11 == i12) {
            return z10 ? b.e(bVar, this) : b.f(bVar);
        }
        if (i11 == i13) {
            return z10 ? b.b(bVar, this) : b.a(bVar);
        }
        return null;
    }

    private boolean i(int i11) {
        return getChildAt(i11).getVisibility() != 8;
    }

    private void k(int i11) {
        if (getChildCount() == 0 || i11 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) f(i11).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void l(int i11, boolean z10) {
        View findViewById = findViewById(i11);
        if (findViewById instanceof MaterialButton) {
            this.f28557f = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.f28557f = false;
        }
    }

    private static void m(n.b bVar, b bVar2) {
        if (bVar2 == null) {
            bVar.o(0.0f);
        } else {
            bVar.I(bVar2.f28564a).x(bVar2.f28567d).N(bVar2.f28565b).C(bVar2.f28566c);
        }
    }

    private void n(Set set) {
        Set set2 = this.f28561j;
        this.f28561j = new HashSet(set);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            int id2 = f(i11).getId();
            l(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                e(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    private void o() {
        TreeMap treeMap = new TreeMap(this.f28555d);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            treeMap.put(f(i11), Integer.valueOf(i11));
        }
        this.f28556e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void q() {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            f(i11).setA11yClassName((this.f28558g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f28553b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addOnButtonCheckedListener(@NonNull c cVar) {
        this.f28554c.add(cVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i11, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        d(materialButton.getId(), materialButton.isChecked());
        n shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f28552a.add(new b(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.setAccessibilityDelegate(materialButton, new a());
    }

    public void check(int i11) {
        d(i11, true);
    }

    public void clearChecked() {
        n(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.f28554c.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        o();
        super.dispatchDraw(canvas);
    }

    public int getCheckedButtonId() {
        if (!this.f28558g || this.f28561j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f28561j.iterator().next()).intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            int id2 = f(i11).getId();
            if (this.f28561j.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i11, int i12) {
        Integer[] numArr = this.f28556e;
        if (numArr != null && i12 < numArr.length) {
            return numArr[i12].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i12;
    }

    public boolean isSelectionRequired() {
        return this.f28559h;
    }

    public boolean isSingleSelection() {
        return this.f28558g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MaterialButton materialButton, boolean z10) {
        if (this.f28557f) {
            return;
        }
        d(materialButton.getId(), z10);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i11 = this.f28560i;
        if (i11 != -1) {
            n(Collections.singleton(Integer.valueOf(i11)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        p();
        b();
        super.onMeasure(i11, i12);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f28552a.remove(indexOfChild);
        }
        p();
        b();
    }

    void p() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i11 = 0; i11 < childCount; i11++) {
            MaterialButton f11 = f(i11);
            if (f11.getVisibility() != 8) {
                n.b v11 = f11.getShapeAppearanceModel().v();
                m(v11, h(i11, firstVisibleChildIndex, lastVisibleChildIndex));
                f11.setShapeAppearanceModel(v11.m());
            }
        }
    }

    public void removeOnButtonCheckedListener(@NonNull c cVar) {
        this.f28554c.remove(cVar);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            f(i11).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f28559h = z10;
    }

    public void setSingleSelection(int i11) {
        setSingleSelection(getResources().getBoolean(i11));
    }

    public void setSingleSelection(boolean z10) {
        if (this.f28558g != z10) {
            this.f28558g = z10;
            clearChecked();
        }
        q();
    }

    public void uncheck(int i11) {
        d(i11, false);
    }
}
