package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.internal.f0;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f28856a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f28857b;

    /* loaded from: classes4.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f28856a = x.s();
        if (MaterialDatePicker.m0(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.f28857b = MaterialDatePicker.o0(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    private void a(int i11, Rect rect) {
        if (i11 == 33) {
            setSelection(getAdapter().m());
        } else if (i11 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i11, rect);
        }
    }

    private View c(int i11) {
        return getChildAt(i11 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l11, Long l12, Long l13, Long l14) {
        return l11 == null || l12 == null || l13 == null || l14 == null || l13.longValue() > l12.longValue() || l14.longValue() < l11.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public m getAdapter2() {
        return (m) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int a11;
        int d11;
        int a12;
        int d12;
        int width;
        int i11;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        m adapter = getAdapter();
        DateSelector dateSelector = adapter.f28948b;
        b bVar = adapter.f28950d;
        int max = Math.max(adapter.b(), getFirstVisiblePosition());
        int min = Math.min(adapter.m(), getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<androidx.core.util.e> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            androidx.core.util.e next = it.next();
            Object obj = next.f8347a;
            if (obj == null) {
                materialCalendarGridView = this;
            } else if (next.f8348b != null) {
                Long l11 = (Long) obj;
                long longValue = l11.longValue();
                Long l12 = (Long) next.f8348b;
                long longValue2 = l12.longValue();
                if (!e(item, item2, l11, l12)) {
                    boolean p11 = f0.p(this);
                    if (longValue < item.longValue()) {
                        d11 = adapter.h(max) ? 0 : !p11 ? materialCalendarGridView.c(max - 1).getRight() : materialCalendarGridView.c(max - 1).getLeft();
                        a11 = max;
                    } else {
                        materialCalendarGridView.f28856a.setTimeInMillis(longValue);
                        a11 = adapter.a(materialCalendarGridView.f28856a.get(5));
                        d11 = d(materialCalendarGridView.c(a11));
                    }
                    if (longValue2 > item2.longValue()) {
                        d12 = adapter.i(min) ? getWidth() : !p11 ? materialCalendarGridView.c(min).getRight() : materialCalendarGridView.c(min).getLeft();
                        a12 = min;
                    } else {
                        materialCalendarGridView.f28856a.setTimeInMillis(longValue2);
                        a12 = adapter.a(materialCalendarGridView.f28856a.get(5));
                        d12 = d(materialCalendarGridView.c(a12));
                    }
                    int itemId = (int) adapter.getItemId(a11);
                    int i12 = max;
                    int i13 = min;
                    int itemId2 = (int) adapter.getItemId(a12);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View c11 = materialCalendarGridView.c(numColumns);
                        int top = c11.getTop() + bVar.f28918a.c();
                        m mVar = adapter;
                        int bottom = c11.getBottom() - bVar.f28918a.b();
                        if (p11) {
                            int i14 = a12 > numColumns2 ? 0 : d12;
                            width = numColumns > a11 ? getWidth() : d11;
                            i11 = i14;
                        } else {
                            i11 = numColumns > a11 ? 0 : d11;
                            width = a12 > numColumns2 ? getWidth() : d12;
                        }
                        canvas.drawRect(i11, top, width, bottom, bVar.f28925h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        adapter = mVar;
                    }
                    materialCalendarGridView = this;
                    max = i12;
                    min = i13;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z10, int i11, Rect rect) {
        if (z10) {
            a(i11, rect);
        } else {
            super.onFocusChanged(false, i11, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (!super.onKeyDown(i11, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i11) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i11, int i12) {
        if (!this.f28857b) {
            super.onMeasure(i11, i12);
            return;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof m)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), m.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i11) {
        if (i11 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i11);
        }
    }
}
