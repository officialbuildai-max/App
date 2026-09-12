package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class g extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f30173a;

    /* renamed from: b, reason: collision with root package name */
    private int f30174b;

    /* renamed from: c, reason: collision with root package name */
    private ab.i f30175c;

    public g(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, i());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i11, 0);
        this.f30174b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f30173a = new Runnable() { // from class: com.google.android.material.timepicker.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.n();
            }
        };
        obtainStyledAttributes.recycle();
    }

    private void h(List list, androidx.constraintlayout.widget.b bVar, int i11) {
        Iterator it = list.iterator();
        float f11 = 0.0f;
        while (it.hasNext()) {
            bVar.u(((View) it.next()).getId(), R$id.circle_center, i11, f11);
            f11 += 360.0f / list.size();
        }
    }

    private Drawable i() {
        ab.i iVar = new ab.i();
        this.f30175c = iVar;
        iVar.b0(new ab.l(0.5f));
        this.f30175c.d0(ColorStateList.valueOf(-1));
        return this.f30175c;
    }

    private static boolean m(View view) {
        return "skip".equals(view.getTag());
    }

    private void o() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f30173a);
            handler.post(this.f30173a);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        o();
    }

    int j(int i11) {
        return i11 == 2 ? Math.round(this.f30174b * 0.66f) : this.f30174b;
    }

    public int k() {
        return this.f30174b;
    }

    public void l(int i11) {
        this.f30174b = i11;
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.q(this);
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getId() != R$id.circle_center && !m(childAt)) {
                int i12 = (Integer) childAt.getTag(R$id.material_clock_level);
                if (i12 == null) {
                    i12 = 1;
                }
                if (!hashMap.containsKey(i12)) {
                    hashMap.put(i12, new ArrayList());
                }
                ((List) hashMap.get(i12)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            h((List) entry.getValue(), bVar, j(((Integer) entry.getKey()).intValue()));
        }
        bVar.i(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        o();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i11) {
        this.f30175c.d0(ColorStateList.valueOf(i11));
    }
}
