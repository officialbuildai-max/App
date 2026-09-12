package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k, reason: collision with root package name */
    private static r0 f2175k;

    /* renamed from: l, reason: collision with root package name */
    private static r0 f2176l;

    /* renamed from: a, reason: collision with root package name */
    private final View f2177a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f2178b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2179c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f2180d = new Runnable() { // from class: androidx.appcompat.widget.p0
        @Override // java.lang.Runnable
        public final void run() {
            r0.this.e();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f2181e = new Runnable() { // from class: androidx.appcompat.widget.q0
        @Override // java.lang.Runnable
        public final void run() {
            r0.this.d();
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private int f2182f;

    /* renamed from: g, reason: collision with root package name */
    private int f2183g;

    /* renamed from: h, reason: collision with root package name */
    private s0 f2184h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2185i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2186j;

    private r0(View view, CharSequence charSequence) {
        this.f2177a = view;
        this.f2178b = charSequence;
        this.f2179c = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f2177a.removeCallbacks(this.f2180d);
    }

    private void c() {
        this.f2186j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f2177a.postDelayed(this.f2180d, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(r0 r0Var) {
        r0 r0Var2 = f2175k;
        if (r0Var2 != null) {
            r0Var2.b();
        }
        f2175k = r0Var;
        if (r0Var != null) {
            r0Var.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        r0 r0Var = f2175k;
        if (r0Var != null && r0Var.f2177a == view) {
            g(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new r0(view, charSequence);
            return;
        }
        r0 r0Var2 = f2176l;
        if (r0Var2 != null && r0Var2.f2177a == view) {
            r0Var2.d();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private boolean j(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (!this.f2186j && Math.abs(x10 - this.f2182f) <= this.f2179c && Math.abs(y10 - this.f2183g) <= this.f2179c) {
            return false;
        }
        this.f2182f = x10;
        this.f2183g = y10;
        this.f2186j = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f2176l == this) {
            f2176l = null;
            s0 s0Var = this.f2184h;
            if (s0Var != null) {
                s0Var.c();
                this.f2184h = null;
                c();
                this.f2177a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2175k == this) {
            g(null);
        }
        this.f2177a.removeCallbacks(this.f2181e);
    }

    void i(boolean z10) {
        long longPressTimeout;
        long j11;
        long j12;
        if (this.f2177a.isAttachedToWindow()) {
            g(null);
            r0 r0Var = f2176l;
            if (r0Var != null) {
                r0Var.d();
            }
            f2176l = this;
            this.f2185i = z10;
            s0 s0Var = new s0(this.f2177a.getContext());
            this.f2184h = s0Var;
            s0Var.e(this.f2177a, this.f2182f, this.f2183g, this.f2185i, this.f2178b);
            this.f2177a.addOnAttachStateChangeListener(this);
            if (this.f2185i) {
                j12 = 2500;
            } else {
                if ((ViewCompat.getWindowSystemUiVisibility(this.f2177a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j11 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j11 = MBInterstitialActivity.WEB_LOAD_TIME;
                }
                j12 = j11 - longPressTimeout;
            }
            this.f2177a.removeCallbacks(this.f2181e);
            this.f2177a.postDelayed(this.f2181e, j12);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2184h != null && this.f2185i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2177a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f2177a.isEnabled() && this.f2184h == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f2182f = view.getWidth() / 2;
        this.f2183g = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
