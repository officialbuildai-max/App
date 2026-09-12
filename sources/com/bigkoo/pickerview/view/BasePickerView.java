package com.bigkoo.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$style;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class BasePickerView {

    /* renamed from: a, reason: collision with root package name */
    private Context f20029a;

    /* renamed from: b, reason: collision with root package name */
    protected ViewGroup f20030b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f20031c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f20032d;

    /* renamed from: e, reason: collision with root package name */
    protected p5.a f20033e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20034f;

    /* renamed from: g, reason: collision with root package name */
    private Animation f20035g;

    /* renamed from: h, reason: collision with root package name */
    private Animation f20036h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20037i;

    /* renamed from: k, reason: collision with root package name */
    private Dialog f20039k;

    /* renamed from: l, reason: collision with root package name */
    protected View f20040l;

    /* renamed from: j, reason: collision with root package name */
    protected int f20038j = 80;

    /* renamed from: m, reason: collision with root package name */
    private boolean f20041m = true;

    /* renamed from: n, reason: collision with root package name */
    private View.OnKeyListener f20042n = new c();

    /* renamed from: o, reason: collision with root package name */
    private final View.OnTouchListener f20043o = new d();

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasePickerView.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasePickerView.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i11, KeyEvent keyEvent) {
            if (i11 != 4 || keyEvent.getAction() != 0 || !BasePickerView.this.q()) {
                return false;
            }
            BasePickerView.this.f();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            BasePickerView.this.f();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BasePickerView.a(BasePickerView.this);
        }
    }

    public BasePickerView(Context context) {
        this.f20029a = context;
    }

    static /* bridge */ /* synthetic */ q5.b a(BasePickerView basePickerView) {
        basePickerView.getClass();
        return null;
    }

    private void g() {
        Dialog dialog = this.f20039k;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private Animation i() {
        return AnimationUtils.loadAnimation(this.f20029a, r5.c.a(this.f20038j, true));
    }

    private static String j() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int k(Context context) {
        Resources resources;
        int identifier;
        if (!m(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    private Animation l() {
        return AnimationUtils.loadAnimation(this.f20029a, r5.c.a(this.f20038j, false));
    }

    public static boolean m(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z10 = resources.getBoolean(identifier);
        String j11 = j();
        if ("1".equals(j11)) {
            return false;
        }
        if ("0".equals(j11)) {
            return true;
        }
        return z10;
    }

    private void r(View view) {
        this.f20033e.A.addView(view);
        if (this.f20041m) {
            this.f20030b.startAnimation(this.f20036h);
        }
    }

    private void w() {
        Dialog dialog = this.f20039k;
        if (dialog != null) {
            dialog.show();
        }
    }

    public void e() {
        if (this.f20032d != null) {
            Dialog dialog = new Dialog(this.f20029a, R$style.custom_dialog2);
            this.f20039k = dialog;
            dialog.setCancelable(this.f20033e.U);
            this.f20039k.setContentView(this.f20032d);
            Window window = this.f20039k.getWindow();
            if (window != null) {
                window.setWindowAnimations(R$style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f20039k.setOnDismissListener(new e());
        }
    }

    public void f() {
        if (p()) {
            g();
            return;
        }
        if (this.f20034f) {
            return;
        }
        if (this.f20041m) {
            this.f20035g.setAnimationListener(new b());
            this.f20030b.startAnimation(this.f20035g);
        } else {
            h();
        }
        this.f20034f = true;
    }

    public View findViewById(int i11) {
        return this.f20030b.findViewById(i11);
    }

    public void h() {
        this.f20033e.A.post(new Runnable() { // from class: com.bigkoo.pickerview.view.BasePickerView.3
            @Override // java.lang.Runnable
            public void run() {
                BasePickerView basePickerView = BasePickerView.this;
                basePickerView.f20033e.A.removeView(basePickerView.f20031c);
                BasePickerView.this.f20037i = false;
                BasePickerView.this.f20034f = false;
                BasePickerView.a(BasePickerView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        this.f20036h = i();
        this.f20035g = l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f20029a);
        if (p()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R$layout.layout_basepickerview, (ViewGroup) null, false);
            this.f20032d = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f20032d.findViewById(R$id.content_container);
            this.f20030b = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f20032d.setOnClickListener(new a());
        } else {
            p5.a aVar = this.f20033e;
            if (aVar.A == null) {
                aVar.A = (ViewGroup) ((Activity) this.f20029a).getWindow().getDecorView();
            }
            this.f20031c = (ViewGroup) from.inflate(R$layout.layout_basepickerview, this.f20033e.A, false);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.bottomMargin = k(this.f20029a);
            this.f20031c.setLayoutParams(layoutParams2);
            int i11 = this.f20033e.R;
            if (i11 != -1) {
                this.f20031c.setBackgroundColor(i11);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f20031c.findViewById(R$id.content_container);
            this.f20030b = viewGroup3;
            viewGroup3.setLayoutParams(layoutParams);
        }
        t(true);
    }

    public abstract boolean p();

    public boolean q() {
        if (p()) {
            return false;
        }
        return this.f20031c.getParent() != null || this.f20037i;
    }

    public void s() {
        Dialog dialog = this.f20039k;
        if (dialog != null) {
            dialog.setCancelable(this.f20033e.U);
        }
    }

    public void t(boolean z10) {
        ViewGroup viewGroup = p() ? this.f20032d : this.f20031c;
        viewGroup.setFocusable(z10);
        viewGroup.setFocusableInTouchMode(z10);
        if (z10) {
            viewGroup.setOnKeyListener(this.f20042n);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePickerView u(boolean z10) {
        ViewGroup viewGroup = this.f20031c;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R$id.outmost_container);
            if (z10) {
                findViewById.setOnTouchListener(this.f20043o);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void v() {
        if (p()) {
            w();
        } else {
            if (q()) {
                return;
            }
            this.f20037i = true;
            r(this.f20031c);
            this.f20031c.requestFocus();
        }
    }
}
