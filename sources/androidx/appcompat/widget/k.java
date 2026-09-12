package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
class k extends PopupWindow {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f2122b = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f2123a;

    public k(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        a(context, attributeSet, i11, i12);
    }

    private void a(Context context, AttributeSet attributeSet, int i11, int i12) {
        j0 v11 = j0.v(context, attributeSet, R$styleable.PopupWindow, i11, i12);
        if (v11.s(R$styleable.PopupWindow_overlapAnchor)) {
            b(v11.a(R$styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(v11.g(R$styleable.PopupWindow_android_popupBackground));
        v11.x();
    }

    private void b(boolean z10) {
        if (f2122b) {
            this.f2123a = z10;
        } else {
            androidx.core.widget.l.a(this, z10);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i11, int i12) {
        if (f2122b && this.f2123a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i11, int i12, int i13) {
        if (f2122b && this.f2123a) {
            i12 -= view.getHeight();
        }
        super.showAsDropDown(view, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i11, int i12, int i13, int i14) {
        if (f2122b && this.f2123a) {
            i12 -= view.getHeight();
        }
        super.update(view, i11, i12, i13, i14);
    }
}
