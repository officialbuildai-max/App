package com.transsion.shorttv_pugc.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.d;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.push.PushConstants;
import com.transsion.shorttv_pugc.base.dialog.BaseDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ds.e;
import hj.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/shorttv_pugc/base/dialog/BaseDialog;", "Landroidx/fragment/app/DialogFragment;", "Lds/e;", "<init>", "()V", "", "contentLayoutId", "(I)V", "", "d0", "Landroid/content/Context;", "context", "b0", "(Landroid/content/Context;)I", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", PushConstants.PUSH_SERVICE_TYPE_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", TmcConstants.NAVIGATION_ON_START, "onResume", "onPause", "onDestroy", "c0", "()Ljava/lang/String;", "Lhj/b;", "a", "Lkotlin/Lazy;", "getLogViewConfig", "()Lhj/b;", "logViewConfig", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public abstract class BaseDialog extends DialogFragment implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy logViewConfig;

    public BaseDialog() {
        this.logViewConfig = LazyKt.b(new Function0() { // from class: at.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                hj.b g02;
                g02 = BaseDialog.g0(BaseDialog.this);
                return g02;
            }
        });
    }

    public BaseDialog(int i11) {
        super(i11);
        this.logViewConfig = LazyKt.b(new Function0() { // from class: at.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                hj.b g02;
                g02 = BaseDialog.g0(BaseDialog.this);
                return g02;
            }
        });
    }

    private final int b0(Context context) {
        try {
            return d.a();
        } catch (Exception unused) {
            int i11 = 0;
            try {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                if (identifier > 0) {
                    i11 = resources.getDimensionPixelSize(identifier);
                }
            } catch (Exception unused2) {
            }
            return i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d0() {
        /*
            r11 = this;
            android.app.Dialog r0 = r11.getDialog()
            if (r0 == 0) goto Lc8
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto Le
            goto Lc8
        Le:
            android.view.View r0 = r0.getDecorView()
            if (r0 != 0) goto L15
            return
        L15:
            android.view.View r1 = r11.getView()
            if (r1 != 0) goto L1c
            return
        L1c:
            android.content.Context r2 = r11.requireContext()
            java.lang.String r3 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
            int r2 = r11.b0(r2)
            boolean r3 = r1 instanceof android.view.ViewGroup
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L56
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r6.setFitsSystemWindows(r5)
            android.graphics.drawable.Drawable r7 = r6.getBackground()
            if (r7 != 0) goto L56
            int r7 = r6.getChildCount()
            if (r7 <= 0) goto L46
            android.view.View r7 = r6.getChildAt(r5)
            goto L47
        L46:
            r7 = r4
        L47:
            if (r7 == 0) goto L53
            android.graphics.drawable.Drawable r7 = r7.getBackground()
            if (r7 == 0) goto L53
            r6.setBackground(r7)
            goto L56
        L53:
            r1.setBackgroundColor(r5)
        L56:
            at.c r6 = new at.c
            r6.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r0, r6)
            if (r2 <= 0) goto Lbb
            if (r3 == 0) goto L78
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int r7 = r6.getChildCount()
            if (r7 <= 0) goto L78
            android.view.View r6 = r6.getChildAt(r5)
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L76
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            goto L7d
        L76:
            r6 = r4
            goto L7d
        L78:
            if (r3 == 0) goto L76
            r6 = r1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
        L7d:
            if (r6 == 0) goto L9c
            int r7 = r6.getPaddingLeft()
            int r8 = r6.getPaddingTop()
            int r9 = r6.getPaddingRight()
            int r10 = r6.getPaddingBottom()
            if (r10 >= r2) goto L92
            goto L93
        L92:
            r2 = r10
        L93:
            int r10 = r6.getPaddingBottom()
            if (r10 == r2) goto L9c
            r6.setPadding(r7, r8, r9, r2)
        L9c:
            if (r3 == 0) goto Lbb
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.graphics.drawable.Drawable r2 = r1.getBackground()
            if (r2 != 0) goto Lbb
            int r2 = r1.getChildCount()
            if (r2 <= 0) goto Lb0
            android.view.View r4 = r1.getChildAt(r5)
        Lb0:
            if (r4 == 0) goto Lbb
            android.graphics.drawable.Drawable r2 = r4.getBackground()
            if (r2 == 0) goto Lbb
            r1.setBackground(r2)
        Lbb:
            androidx.core.view.ViewCompat.requestApplyInsets(r0)
            at.d r1 = new at.d
            r1.<init>()
            r2 = 100
            r0.postDelayed(r1, r2)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.base.dialog.BaseDialog.d0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.core.view.WindowInsetsCompat e0(int r4, android.view.View r5, android.view.View r6, androidx.core.view.WindowInsetsCompat r7) {
        /*
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            java.lang.String r0 = "insets"
            kotlin.jvm.internal.Intrinsics.h(r7, r0)
            int r0 = androidx.core.view.WindowInsetsCompat.Type.navigationBars()
            z0.c r0 = r7.getInsets(r0)
            java.lang.String r1 = "getInsets(...)"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            int r2 = androidx.core.view.WindowInsetsCompat.Type.systemGestures()
            z0.c r2 = r7.getInsets(r2)
            kotlin.jvm.internal.Intrinsics.g(r2, r1)
            int r0 = r0.f79251d
            r1 = 0
            if (r0 <= 0) goto L29
        L27:
            r4 = r0
            goto L32
        L29:
            int r0 = r2.f79251d
            if (r0 <= 0) goto L2e
            goto L27
        L2e:
            if (r4 <= 0) goto L31
            goto L32
        L31:
            r4 = r1
        L32:
            r6.setPadding(r1, r1, r1, r1)
            if (r4 <= 0) goto L75
            boolean r6 = r5 instanceof android.view.ViewGroup
            r0 = 0
            if (r6 == 0) goto L51
            r2 = r5
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r3 = r2.getChildCount()
            if (r3 <= 0) goto L51
            android.view.View r5 = r2.getChildAt(r1)
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L56
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L56
        L51:
            if (r6 == 0) goto L56
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L56:
            if (r0 == 0) goto L75
            int r5 = r0.getPaddingLeft()
            int r6 = r0.getPaddingTop()
            int r1 = r0.getPaddingRight()
            int r2 = r0.getPaddingBottom()
            if (r2 >= r4) goto L6b
            goto L6c
        L6b:
            r4 = r2
        L6c:
            int r2 = r0.getPaddingBottom()
            if (r2 == r4) goto L75
            r0.setPadding(r5, r6, r1, r4)
        L75:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.base.dialog.BaseDialog.e0(int, android.view.View, android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(View view) {
        ViewCompat.requestApplyInsets(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b g0(BaseDialog baseDialog) {
        return baseDialog.newLogViewConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(BaseDialog baseDialog) {
        baseDialog.d0();
    }

    public String c0() {
        return null;
    }

    @Override // ds.e
    public b getLogViewConfig() {
        return (b) this.logViewConfig.getValue();
    }

    public b newLogViewConfig() {
        return e.a.a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        at.e.f16206a.a(c0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        e.a.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e.a.c(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Dialog dialog;
        Window window;
        super.onStart();
        if (Build.VERSION.SDK_INT < 35 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setNavigationBarColor(0);
        window.setStatusBarColor(0);
        window.getDecorView().post(new Runnable() { // from class: at.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseDialog.h0(BaseDialog.this);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String tag) {
        Intrinsics.h(manager, "manager");
        try {
            manager.g0();
            if (!isAdded() && manager.k0(tag) == null) {
                super.show(manager, tag);
                at.e.f16206a.b(c0());
            }
        } catch (IllegalStateException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }
}
