package com.warkiz.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private ArrowView f60907c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f60908d;

    /* renamed from: e, reason: collision with root package name */
    private PopupWindow f60909e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f60910f;

    /* renamed from: g, reason: collision with root package name */
    private int f60911g;

    /* renamed from: h, reason: collision with root package name */
    private int f60912h;

    /* renamed from: i, reason: collision with root package name */
    private Context f60913i;

    /* renamed from: j, reason: collision with root package name */
    private int f60914j;

    /* renamed from: k, reason: collision with root package name */
    private IndicatorSeekBar f60915k;

    /* renamed from: l, reason: collision with root package name */
    private View f60916l;

    /* renamed from: m, reason: collision with root package name */
    private View f60917m;

    /* renamed from: n, reason: collision with root package name */
    private View f60918n;

    /* renamed from: o, reason: collision with root package name */
    private float f60919o;

    /* renamed from: p, reason: collision with root package name */
    private int f60920p;

    /* renamed from: b, reason: collision with root package name */
    private int[] f60906b = new int[2];

    /* renamed from: a, reason: collision with root package name */
    private final int f60905a = e();

    public d(Context context, IndicatorSeekBar indicatorSeekBar, int i11, int i12, int i13, int i14, View view, View view2) {
        this.f60913i = context;
        this.f60915k = indicatorSeekBar;
        this.f60912h = i11;
        this.f60914j = i12;
        this.f60917m = view;
        this.f60918n = view2;
        this.f60919o = i13;
        this.f60920p = i14;
        this.f60911g = g.a(this.f60913i, 2.0f);
        h();
    }

    private void a(float f11) {
        int i11 = this.f60914j;
        if (i11 == 4 || i11 == 1) {
            return;
        }
        if (c() + f11 < this.f60909e.getContentView().getMeasuredWidth() / 2) {
            k(this.f60907c, -((int) (((this.f60909e.getContentView().getMeasuredWidth() / 2) - r0) - f11)), -1, -1, -1);
        } else if ((this.f60905a - r0) - f11 < this.f60909e.getContentView().getMeasuredWidth() / 2) {
            k(this.f60907c, (int) ((this.f60909e.getContentView().getMeasuredWidth() / 2) - ((this.f60905a - r0) - f11)), -1, -1, -1);
        } else {
            k(this.f60907c, 0, 0, 0, 0);
        }
    }

    private GradientDrawable b() {
        GradientDrawable gradientDrawable = this.f60914j == 2 ? (GradientDrawable) this.f60913i.getResources().getDrawable(R$drawable.isb_indicator_rounded_corners) : (GradientDrawable) this.f60913i.getResources().getDrawable(R$drawable.isb_indicator_square_corners);
        gradientDrawable.setColor(this.f60912h);
        return gradientDrawable;
    }

    private int c() {
        this.f60915k.getLocationOnScreen(this.f60906b);
        return this.f60906b[0];
    }

    private int e() {
        WindowManager windowManager = (WindowManager) this.f60913i.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private void h() {
        View findViewById;
        int i11 = this.f60914j;
        if (i11 == 4) {
            View view = this.f60917m;
            if (view == null) {
                throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
            }
            this.f60916l = view;
            int identifier = this.f60913i.getResources().getIdentifier("isb_progress", "id", this.f60913i.getApplicationContext().getPackageName());
            if (identifier <= 0 || (findViewById = this.f60916l.findViewById(identifier)) == null) {
                return;
            }
            if (!(findViewById instanceof TextView)) {
                throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
            }
            TextView textView = (TextView) findViewById;
            this.f60908d = textView;
            textView.setText(this.f60915k.getIndicatorTextString());
            this.f60908d.setTextSize(g.b(this.f60913i, this.f60919o));
            this.f60908d.setTextColor(this.f60920p);
            return;
        }
        if (i11 == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.f60913i, this.f60919o, this.f60920p, this.f60912h, "1000");
            this.f60916l = circleBubbleView;
            circleBubbleView.setProgress(this.f60915k.getIndicatorTextString());
            return;
        }
        View inflate = View.inflate(this.f60913i, R$layout.isb_indicator, null);
        this.f60916l = inflate;
        this.f60910f = (LinearLayout) inflate.findViewById(R$id.indicator_container);
        ArrowView arrowView = (ArrowView) this.f60916l.findViewById(R$id.indicator_arrow);
        this.f60907c = arrowView;
        arrowView.setColor(this.f60912h);
        TextView textView2 = (TextView) this.f60916l.findViewById(R$id.isb_progress);
        this.f60908d = textView2;
        textView2.setText(this.f60915k.getIndicatorTextString());
        this.f60908d.setTextSize(g.b(this.f60913i, this.f60919o));
        this.f60908d.setTextColor(this.f60920p);
        this.f60910f.setBackground(b());
        if (this.f60918n != null) {
            int identifier2 = this.f60913i.getResources().getIdentifier("isb_progress", "id", this.f60913i.getApplicationContext().getPackageName());
            View view2 = this.f60918n;
            if (identifier2 <= 0) {
                m(view2);
                return;
            }
            View findViewById2 = view2.findViewById(identifier2);
            if (findViewById2 == null || !(findViewById2 instanceof TextView)) {
                m(view2);
            } else {
                n(view2, (TextView) findViewById2);
            }
        }
    }

    private void k(View view, int i11, int i12, int i13, int i14) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i11 == -1) {
                i11 = marginLayoutParams.leftMargin;
            }
            if (i12 == -1) {
                i12 = marginLayoutParams.topMargin;
            }
            if (i13 == -1) {
                i13 = marginLayoutParams.rightMargin;
            }
            if (i14 == -1) {
                i14 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i11, i12, i13, i14);
            view.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d() {
        return this.f60916l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        PopupWindow popupWindow = this.f60909e;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        View view;
        if (this.f60909e != null || this.f60914j == 0 || (view = this.f60916l) == null) {
            return;
        }
        view.measure(0, 0);
        this.f60909e = new PopupWindow(this.f60916l, -2, -2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        PopupWindow popupWindow = this.f60909e;
        return popupWindow != null && popupWindow.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        String indicatorTextString = this.f60915k.getIndicatorTextString();
        View view = this.f60916l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.f60908d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        View view = this.f60916l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(str);
            return;
        }
        TextView textView = this.f60908d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void m(View view) {
        n(view, null);
    }

    public void n(View view, TextView textView) {
        this.f60908d = textView;
        this.f60910f.removeAllViews();
        view.setBackground(b());
        this.f60910f.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f11) {
        if (this.f60915k.isEnabled() && this.f60915k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.f60909e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.f60909e.showAsDropDown(this.f60915k, (int) (f11 - (r0.getContentView().getMeasuredWidth() / 2.0f)), -(((this.f60915k.getMeasuredHeight() + this.f60909e.getContentView().getMeasuredHeight()) - this.f60915k.getPaddingTop()) + this.f60911g));
                a(f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f11) {
        if (this.f60915k.isEnabled() && this.f60915k.getVisibility() == 0) {
            j();
            PopupWindow popupWindow = this.f60909e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.f60909e.update(this.f60915k, (int) (f11 - (r2.getContentView().getMeasuredWidth() / 2)), -(((this.f60915k.getMeasuredHeight() + this.f60909e.getContentView().getMeasuredHeight()) - this.f60915k.getPaddingTop()) + this.f60911g), -1, -1);
                a(f11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i11) {
        k(this.f60907c, i11, -1, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i11) {
        k(this.f60916l, i11, -1, -1, -1);
    }
}
