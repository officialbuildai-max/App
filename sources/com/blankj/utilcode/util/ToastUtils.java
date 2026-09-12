package com.blankj.utilcode.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.R$id;
import com.blankj.utilcode.R$layout;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.miniapp.utils.toast.ToastStrategy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class ToastUtils {

    /* renamed from: l, reason: collision with root package name */
    private static final ToastUtils f20130l = n();

    /* renamed from: m, reason: collision with root package name */
    private static WeakReference f20131m;

    /* renamed from: a, reason: collision with root package name */
    private String f20132a;

    /* renamed from: b, reason: collision with root package name */
    private int f20133b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f20134c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f20135d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f20136e = -16777217;

    /* renamed from: f, reason: collision with root package name */
    private int f20137f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f20138g = -16777217;

    /* renamed from: h, reason: collision with root package name */
    private int f20139h = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20140i = false;

    /* renamed from: j, reason: collision with root package name */
    private Drawable[] f20141j = new Drawable[4];

    /* renamed from: k, reason: collision with root package name */
    private boolean f20142k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ActivityToast extends a {

        /* renamed from: f, reason: collision with root package name */
        private static int f20143f;

        /* renamed from: d, reason: collision with root package name */
        private Utils.a f20144d;

        /* renamed from: e, reason: collision with root package name */
        private b f20145e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends Utils.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f20146a;

            a(int i11) {
                this.f20146a = i11;
            }

            @Override // com.blankj.utilcode.util.Utils.a
            public void a(Activity activity) {
                if (ActivityToast.this.i()) {
                    ActivityToast.this.l(activity, this.f20146a, false);
                }
            }
        }

        ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i() {
            return this.f20144d != null;
        }

        private void j() {
            a aVar = new a(f20143f);
            this.f20144d = aVar;
            e0.a(aVar);
        }

        private b k(int i11) {
            c cVar = new c(this.f20152b);
            cVar.f20151a = this.f20151a;
            cVar.a(i11);
            return cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(Activity activity, int i11, boolean z10) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.f20151a.getGravity();
                layoutParams.bottomMargin = this.f20151a.getYOffset() + e0.p();
                layoutParams.topMargin = this.f20151a.getYOffset() + e0.s();
                layoutParams.leftMargin = this.f20151a.getXOffset();
                View d11 = d(i11);
                if (z10) {
                    d11.setAlpha(0.0f);
                    d11.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(d11, layoutParams);
            }
        }

        private b m(Activity activity, int i11) {
            WindowManagerToast windowManagerToast = new WindowManagerToast(this.f20152b, activity.getWindowManager(), 99);
            windowManagerToast.f20153c = d(-1);
            windowManagerToast.f20151a = this.f20151a;
            windowManagerToast.a(i11);
            return windowManagerToast;
        }

        private void n() {
            e0.I(this.f20144d);
            this.f20144d = null;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            if (this.f20151a == null) {
                return;
            }
            if (!e0.x()) {
                this.f20145e = k(i11);
                return;
            }
            boolean z10 = false;
            for (Activity activity : e0.h()) {
                if (e0.w(activity)) {
                    if (z10) {
                        l(activity, f20143f, true);
                    } else {
                        this.f20145e = m(activity, i11);
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                this.f20145e = k(i11);
                return;
            }
            j();
            e0.K(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ActivityToast.this.cancel();
                }
            }, i11 == 0 ? 2000L : ToastStrategy.LONG_DURATION_TIMEOUT);
            f20143f++;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            Window window;
            if (i()) {
                n();
                for (Activity activity : e0.h()) {
                    if (e0.w(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("TAG_TOAST");
                        sb2.append(f20143f - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb2.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            b bVar = this.f20145e;
            if (bVar != null) {
                bVar.cancel();
                this.f20145e = null;
            }
            super.cancel();
        }
    }

    /* loaded from: classes2.dex */
    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {

        /* renamed from: a, reason: collision with root package name */
        private static final int f20148a = e0.d(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i11, int i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(e0.i() - f20148a, Integer.MIN_VALUE), i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowManagerToast extends a {

        /* renamed from: d, reason: collision with root package name */
        private WindowManager f20149d;

        /* renamed from: e, reason: collision with root package name */
        private WindowManager.LayoutParams f20150e;

        WindowManagerToast(ToastUtils toastUtils, int i11) {
            super(toastUtils);
            this.f20150e = new WindowManager.LayoutParams();
            this.f20149d = (WindowManager) Utils.a().getSystemService("window");
            this.f20150e.type = i11;
        }

        WindowManagerToast(ToastUtils toastUtils, WindowManager windowManager, int i11) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f20150e = layoutParams;
            this.f20149d = windowManager;
            layoutParams.type = i11;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            if (this.f20151a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.f20150e;
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.f20150e;
            layoutParams2.flags = 152;
            layoutParams2.packageName = Utils.a().getPackageName();
            this.f20150e.gravity = this.f20151a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.f20150e;
            int i12 = layoutParams3.gravity;
            if ((i12 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i12 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.f20151a.getXOffset();
            this.f20150e.y = this.f20151a.getYOffset();
            this.f20150e.horizontalMargin = this.f20151a.getHorizontalMargin();
            this.f20150e.verticalMargin = this.f20151a.getVerticalMargin();
            try {
                WindowManager windowManager = this.f20149d;
                if (windowManager != null) {
                    windowManager.addView(this.f20153c, this.f20150e);
                }
            } catch (Exception unused) {
            }
            e0.K(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            }, i11 == 0 ? 2000L : ToastStrategy.LONG_DURATION_TIMEOUT);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.a, com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            try {
                WindowManager windowManager = this.f20149d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.f20153c);
                    this.f20149d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class a implements b {

        /* renamed from: a, reason: collision with root package name */
        protected Toast f20151a = new Toast(Utils.a());

        /* renamed from: b, reason: collision with root package name */
        protected ToastUtils f20152b;

        /* renamed from: c, reason: collision with root package name */
        protected View f20153c;

        a(ToastUtils toastUtils) {
            this.f20152b = toastUtils;
            if (toastUtils.f20133b == -1 && this.f20152b.f20134c == -1 && this.f20152b.f20135d == -1) {
                return;
            }
            this.f20151a.setGravity(this.f20152b.f20133b, this.f20152b.f20134c, this.f20152b.f20135d);
        }

        private void e() {
            if (e0.B()) {
                b(d(-1));
            }
        }

        private void f(TextView textView) {
            if (this.f20152b.f20137f != -1) {
                this.f20153c.setBackgroundResource(this.f20152b.f20137f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.f20152b.f20136e != -16777217) {
                Drawable background = this.f20153c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f20152b.f20136e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.f20152b.f20136e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.f20152b.f20136e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.f20153c.setBackgroundColor(this.f20152b.f20136e);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void b(View view) {
            this.f20153c = view;
            this.f20151a.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void c(CharSequence charSequence) {
            View t11 = this.f20152b.t(charSequence);
            if (t11 != null) {
                b(t11);
                e();
                return;
            }
            View view = this.f20151a.getView();
            this.f20153c = view;
            if (view == null || view.findViewById(R.id.message) == null) {
                b(e0.F(R$layout.utils_toast_view));
            }
            TextView textView = (TextView) this.f20153c.findViewById(R.id.message);
            textView.setText(charSequence);
            if (this.f20152b.f20138g != -16777217) {
                textView.setTextColor(this.f20152b.f20138g);
            }
            if (this.f20152b.f20139h != -1) {
                textView.setTextSize(this.f20152b.f20139h);
            }
            f(textView);
            e();
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void cancel() {
            Toast toast = this.f20151a;
            if (toast != null) {
                toast.cancel();
            }
            this.f20151a = null;
            this.f20153c = null;
        }

        View d(int i11) {
            Bitmap M = e0.M(this.f20153c);
            ImageView imageView = new ImageView(Utils.a());
            imageView.setTag("TAG_TOAST" + i11);
            imageView.setImageBitmap(M);
            return imageView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i11);

        void b(View view);

        void c(CharSequence charSequence);

        void cancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends a {

        /* loaded from: classes2.dex */
        static class a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            private Handler f20154a;

            a(Handler handler) {
                this.f20154a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                try {
                    this.f20154a.dispatchMessage(message);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                this.f20154a.handleMessage(message);
            }
        }

        c(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.f20151a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.b
        public void a(int i11) {
            Toast toast = this.f20151a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i11);
            this.f20151a.show();
        }
    }

    public static void l() {
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                if (ToastUtils.f20131m != null) {
                    b bVar = (b) ToastUtils.f20131m.get();
                    if (bVar != null) {
                        bVar.cancel();
                    }
                    WeakReference unused = ToastUtils.f20131m = null;
                }
            }
        });
    }

    private static CharSequence m(CharSequence charSequence) {
        return charSequence == null ? "toast null" : charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    public static ToastUtils n() {
        return new ToastUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b o(ToastUtils toastUtils) {
        if (!toastUtils.f20142k && androidx.core.app.t.d(Utils.a()).a() && !e0.z()) {
            return new c(toastUtils);
        }
        int i11 = Build.VERSION.SDK_INT;
        return i11 < 25 ? new WindowManagerToast(toastUtils, 2005) : e0.z() ? i11 >= 26 ? new WindowManagerToast(toastUtils, 2038) : new WindowManagerToast(toastUtils, 2002) : new ActivityToast(toastUtils);
    }

    private static void p(final View view, final CharSequence charSequence, final int i11, ToastUtils toastUtils) {
        e0.J(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.l();
                b o11 = ToastUtils.o(ToastUtils.this);
                WeakReference unused = ToastUtils.f20131m = new WeakReference(o11);
                View view2 = view;
                if (view2 != null) {
                    o11.b(view2);
                } else {
                    o11.c(charSequence);
                }
                o11.a(i11);
            }
        });
    }

    private static void q(CharSequence charSequence, int i11, ToastUtils toastUtils) {
        p(null, m(charSequence), i11, toastUtils);
    }

    public static void r(int i11) {
        q(e0.t(i11), 0, f20130l);
    }

    public static void s(String str, Object... objArr) {
        q(e0.g(str, objArr), 0, f20130l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View t(CharSequence charSequence) {
        if (!"dark".equals(this.f20132a) && !"light".equals(this.f20132a)) {
            Drawable[] drawableArr = this.f20141j;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View F = e0.F(R$layout.utils_toast_view);
        TextView textView = (TextView) F.findViewById(R.id.message);
        if ("dark".equals(this.f20132a)) {
            ((GradientDrawable) F.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.f20141j[0] != null) {
            View findViewById = F.findViewById(R$id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, this.f20141j[0]);
            findViewById.setVisibility(0);
        }
        if (this.f20141j[1] != null) {
            View findViewById2 = F.findViewById(R$id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, this.f20141j[1]);
            findViewById2.setVisibility(0);
        }
        if (this.f20141j[2] != null) {
            View findViewById3 = F.findViewById(R$id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, this.f20141j[2]);
            findViewById3.setVisibility(0);
        }
        if (this.f20141j[3] != null) {
            View findViewById4 = F.findViewById(R$id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, this.f20141j[3]);
            findViewById4.setVisibility(0);
        }
        return F;
    }
}
