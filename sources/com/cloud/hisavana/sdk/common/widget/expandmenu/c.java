package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.appcompat.R$style;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.h;

/* loaded from: classes3.dex */
public abstract class c {

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdExpandMenuContentView f22336a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f22337b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f22338c;

        a(AdExpandMenuContentView adExpandMenuContentView, View view, boolean z10) {
            this.f22336a = adExpandMenuContentView;
            this.f22337b = view;
            this.f22338c = z10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            c.d(this.f22336a, this.f22337b, this.f22338c);
            this.f22336a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(AdExpandMenuContentView adExpandMenuContentView, View view, boolean z10) {
        View findViewById = adExpandMenuContentView.findViewById(R$id.arrow_up);
        View findViewById2 = adExpandMenuContentView.findViewById(R$id.arrow_down);
        int[] iArr = new int[2];
        adExpandMenuContentView.getLocationInWindow(iArr);
        int i11 = iArr[0];
        view.getLocationInWindow(iArr);
        int i12 = iArr[0];
        int a11 = h.a(210.0f);
        int a12 = h.a(11.0f);
        int a13 = h.a(8.0f);
        int min = Math.min((a11 - a12) - a13, Math.max(a13, ((i12 - i11) + (view.getWidth() / 2)) - (findViewById.getWidth() / 2)));
        ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).setMarginStart(min);
        ((RelativeLayout.LayoutParams) findViewById2.getLayoutParams()).setMarginStart(min);
        findViewById.setVisibility(z10 ? 8 : 0);
        findViewById2.setVisibility(z10 ? 0 : 8);
        adExpandMenuContentView.requestLayout();
    }

    private static int[] e(View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int g11 = h.g();
        int f11 = h.f();
        int i11 = 0;
        int min = Math.min((g11 - view2.getMeasuredWidth()) - h.a(4.0f), Math.max(h.a(4.0f), ((iArr[0] + view.getWidth()) - view2.getMeasuredWidth()) + h.a(8.0f)));
        int height = iArr[1] + view.getHeight();
        if (view2.getMeasuredHeight() + height + h.a(20.0f) > f11) {
            height = iArr[1] - view2.getMeasuredHeight();
            i11 = 1;
        }
        return new int[]{min, height, i11};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(PopupWindow popupWindow) {
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(PopupWindow popupWindow, AdExpandMenuContentView.d dVar, AdExpandMenuItemView.Type type) {
        f(popupWindow);
        if (dVar != null) {
            dVar.a(type);
        }
    }

    public static PopupWindow i(View view, String str, final AdExpandMenuContentView.d dVar) {
        if (view == null) {
            return null;
        }
        try {
            FrameLayout frameLayout = new FrameLayout(e.a());
            frameLayout.setBackgroundColor(Color.parseColor("#33000000"));
            AdExpandMenuContentView adExpandMenuContentView = new AdExpandMenuContentView(e.a());
            adExpandMenuContentView.setAdvertiserName(str);
            adExpandMenuContentView.measure(View.MeasureSpec.makeMeasureSpec(h.a(210.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            frameLayout.addView(adExpandMenuContentView, new FrameLayout.LayoutParams(adExpandMenuContentView.getMeasuredWidth(), adExpandMenuContentView.getMeasuredHeight()));
            final PopupWindow popupWindow = new PopupWindow((View) frameLayout, -1, -1, false);
            popupWindow.setBackgroundDrawable(new ColorDrawable());
            popupWindow.setAnimationStyle(R$style.Animation_AppCompat_Dialog);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(true);
            popupWindow.setClippingEnabled(true);
            if (Build.VERSION.SDK_INT >= 29) {
                popupWindow.setIsClippedToScreen(true);
            }
            popupWindow.update();
            int[] e11 = e(view, adExpandMenuContentView);
            boolean z10 = e11[2] == 1;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.widget.expandmenu.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.f(popupWindow);
                }
            });
            adExpandMenuContentView.getViewTreeObserver().addOnGlobalLayoutListener(new a(adExpandMenuContentView, view, z10));
            adExpandMenuContentView.setListener(new AdExpandMenuContentView.d() { // from class: com.cloud.hisavana.sdk.common.widget.expandmenu.b
                @Override // com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView.d
                public final void a(AdExpandMenuItemView.Type type) {
                    c.h(popupWindow, dVar, type);
                }
            });
            int i11 = e11[0];
            int i12 = e11[1];
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adExpandMenuContentView.getLayoutParams();
            layoutParams.setMarginStart(i11);
            layoutParams.topMargin = i12;
            adExpandMenuContentView.setLayoutParams(layoutParams);
            popupWindow.showAtLocation(view, 0, 0, 0);
            return popupWindow;
        } catch (Exception unused) {
            e4.b().w("AdExpandMenu", "Failed to show adexpandmenu.");
            return null;
        }
    }
}
