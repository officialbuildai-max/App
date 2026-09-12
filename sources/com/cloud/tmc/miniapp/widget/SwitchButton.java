package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.cloud.tmc.miniapp.R;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class SwitchButton extends View {
    public final float OooO;
    public final AccelerateInterpolator OooO00o;
    public final Paint OooO0O0;
    public final Path OooO0OO;
    public final Path OooO0Oo;
    public float OooO0o;
    public final RectF OooO0o0;
    public float OooO0oO;
    public RadialGradient OooO0oo;
    public final float OooOO0;
    public int OooOO0O;
    public int OooOO0o;
    public boolean OooOOO;
    public boolean OooOOO0;
    public boolean OooOOOO;
    public int OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public int OooOOoo;
    public float OooOo;
    public OooO00o OooOo0;
    public int OooOo00;
    public float OooOo0O;
    public float OooOo0o;
    public float OooOoO;
    public float OooOoO0;
    public float OooOoOO;
    public float OooOoo;
    public float OooOoo0;
    public float OooOooO;
    public float OooOooo;
    public float Oooo0;
    public float Oooo000;
    public float Oooo00O;
    public float Oooo00o;
    public float Oooo0O0;

    /* loaded from: classes3.dex */
    public interface OooO00o {
        void OooO00o(SwitchButton switchButton, boolean z10);
    }

    /* loaded from: classes3.dex */
    public static final class SavedState extends View.BaseSavedState {

        @JvmField
        public static final Parcelable.Creator<SavedState> CREATOR = new OooO00o();
        public boolean OooO00o;

        /* loaded from: classes3.dex */
        public static final class OooO00o implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in2) {
                Intrinsics.h(in2, "in");
                return new SavedState(in2);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.OooO00o = 1 == parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int i11) {
            Intrinsics.h(out, "out");
            super.writeToParcel(out, i11);
            out.writeInt(this.OooO00o ? 1 : 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.h(context, "context");
        this.OooO00o = new AccelerateInterpolator(2.0f);
        this.OooO0O0 = new Paint();
        this.OooO0OO = new Path();
        this.OooO0Oo = new Path();
        this.OooO0o0 = new RectF();
        this.OooO = 0.68f;
        this.OooOO0 = 0.1f;
        this.OooOOOo = Color.parseColor("#0081FF");
        this.OooOOo0 = Color.parseColor("#0081FF");
        Color.parseColor("#C2C6CE");
        this.OooOOo = Color.parseColor("#BFBFBF");
        this.OooOo00 = Color.parseColor("#333333");
        setLayerType(1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        Intrinsics.g(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.SwitchButton)");
        this.OooOOOO = obtainStyledAttributes.getBoolean(R.styleable.SwitchButton_android_checked, this.OooOOOO);
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.SwitchButton_android_enabled, isEnabled()));
        int i13 = this.OooOOOO ? 3 : 1;
        this.OooOO0o = i13;
        this.OooOO0O = i13;
        this.OooOOoo = androidx.core.content.b.getColor(context, R.color.mini_color_switch_off_bg);
        this.OooOOOo = androidx.core.content.b.getColor(context, R.color.mini_color_primary);
        this.OooOOo0 = androidx.core.content.b.getColor(context, R.color.mini_color_primary);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ SwitchButton(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static void OooO00o(SwitchButton switchButton, boolean z10, boolean z11, boolean z12, int i11) {
        OooO00o oooO00o;
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        int i12 = z10 ? 3 : 1;
        int i13 = switchButton.OooOO0o;
        if (i12 == i13) {
            return;
        }
        if ((i12 == 3 && (i13 == 1 || i13 == 2)) || (i12 == 1 && (i13 == 3 || i13 == 4))) {
            switchButton.OooO0o = z12 ? 1.0f : 0.0f;
        }
        switchButton.OooO0oO = z12 ? 1.0f : 0.0f;
        boolean z13 = switchButton.OooOOOO;
        if (!z13 && i12 == 3) {
            switchButton.OooOOOO = true;
        } else if (z13 && i12 == 1) {
            switchButton.OooOOOO = false;
        }
        switchButton.OooOO0O = i13;
        switchButton.OooOO0o = i12;
        switchButton.postInvalidate();
        if (!z11 || (oooO00o = switchButton.OooOo0) == null) {
            return;
        }
        oooO00o.OooO00o(switchButton, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.SwitchButton.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (getResources().getDimension(R.dimen.mini_dp_56) + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + ((int) (View.MeasureSpec.getSize(i11) * this.OooO)), 1073741824);
        }
        setMeasuredDimension(i11, i12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.f(parcelable, "null cannot be cast to non-null type com.cloud.tmc.miniapp.widget.SwitchButton.SavedState");
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z10 = savedState.OooO00o;
        this.OooOOOO = z10;
        this.OooOO0o = z10 ? 3 : 1;
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.OooO00o = this.OooOOOO;
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSizeChanged(int r12, int r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.SwitchButton.onSizeChanged(int, int, int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i11;
        Intrinsics.h(event, "event");
        super.onTouchEvent(event);
        if (isEnabled() && (((i11 = this.OooOO0o) == 3 || i11 == 1) && this.OooO0o * this.OooO0oO == 0.0f && event.getAction() == 1)) {
            int i12 = this.OooOO0o;
            this.OooOO0O = i12;
            this.OooO0oO = 1.0f;
            if (i12 == 1) {
                OooO00o(this, true, false, false, 4);
                OooO00o oooO00o = this.OooOo0;
                if (oooO00o != null) {
                    oooO00o.OooO00o(this, true);
                }
            } else if (i12 == 3) {
                OooO00o(this, false, false, false, 4);
                OooO00o oooO00o2 = this.OooOo0;
                if (oooO00o2 != null) {
                    oooO00o2.OooO00o(this, false);
                }
            }
        }
        return true;
    }

    public final void setChecked(boolean z10) {
        OooO00o(this, z10, true, false, 4);
    }

    public final void setOnCheckedChangeListener(OooO00o oooO00o) {
        this.OooOo0 = oooO00o;
    }

    public final void setShadow(boolean z10) {
        this.OooOOO = z10;
        invalidate();
    }
}
