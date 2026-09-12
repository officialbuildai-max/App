package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1815a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1816b;

    /* renamed from: c, reason: collision with root package name */
    private int f1817c;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1817c = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.ButtonBarLayout, attributeSet, obtainStyledAttributes, 0, 0);
        this.f1815a = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1815a);
        }
    }

    private int a(int i11) {
        int childCount = getChildCount();
        while (i11 < childCount) {
            if (getChildAt(i11).getVisibility() == 0) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    private boolean b() {
        return this.f1816b;
    }

    private void setStacked(boolean z10) {
        if (this.f1816b != z10) {
            if (!z10 || this.f1815a) {
                this.f1816b = z10;
                setOrientation(z10 ? 1 : 0);
                setGravity(z10 ? GravityCompat.END : 80);
                View findViewById = findViewById(R$id.spacer);
                if (findViewById != null) {
                    findViewById.setVisibility(z10 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        int i13;
        boolean z10;
        int size = View.MeasureSpec.getSize(i11);
        int i14 = 0;
        if (this.f1815a) {
            if (size > this.f1817c && b()) {
                setStacked(false);
            }
            this.f1817c = size;
        }
        if (b() || View.MeasureSpec.getMode(i11) != 1073741824) {
            i13 = i11;
            z10 = false;
        } else {
            i13 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z10 = true;
        }
        super.onMeasure(i13, i12);
        if (this.f1815a && !b() && (getMeasuredWidthAndState() & ViewCompat.MEASURED_STATE_MASK) == 16777216) {
            setStacked(true);
            z10 = true;
        }
        if (z10) {
            super.onMeasure(i11, i12);
        }
        int a11 = a(0);
        if (a11 >= 0) {
            View childAt = getChildAt(a11);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int a12 = a(a11 + 1);
                if (a12 >= 0) {
                    paddingTop += getChildAt(a12).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i14 = paddingTop;
            } else {
                i14 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != i14) {
            setMinimumHeight(i14);
            if (i12 == 0) {
                super.onMeasure(i11, i12);
            }
        }
    }

    public void setAllowStacking(boolean z10) {
        if (this.f1815a != z10) {
            this.f1815a = z10;
            if (!z10 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
