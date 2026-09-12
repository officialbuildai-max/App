package com.transsion.baseui.activity;

import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.h2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.font.p;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeSavedStateRegistryOwner;
import androidx.view.ViewTreeViewModelStoreOwner;
import com.blankj.utilcode.util.a0;
import com.google.android.material.card.MaterialCardView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.R$mipmap;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import nh.m;
import nh.n;
import o0.x;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b'\u0018\u0000 1*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u00012B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00028\u0000H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H$¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0007H\u0014¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\fH\u0016¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\u0007H\u0007¢\u0006\u0004\b*\u0010+R\"\u0010,\u001a\u00028\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/transsion/baseui/activity/BaseCommonActivity;", "Lg4/a;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lnh/n;", "<init>", "()V", "", "X", "Landroid/view/View;", "W", "()Landroid/view/View;", "", "getClassTag", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "intercept", "(Landroid/content/Context;Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getViewBinding", "()Lg4/a;", "setView", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "onConnected", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onDisconnected", "onResume", "onPause", "finish", "onDestroy", "", "isMonitorNetworkState", "()Z", "getPageName", "EnterHomeView", "(Landroidx/compose/runtime/i;I)V", "mViewBinding", "Lg4/a;", "getMViewBinding", "setMViewBinding", "(Lg4/a;)V", "Companion", "a", "BaseUI_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class BaseCommonActivity<T extends g4.a> extends AppCompatActivity implements n {
    public static final String EXTRA_SHOW_HOME_BUTTON = "show_enter_home";
    public static final String TAG = "BaseCommonActivity";
    public T mViewBinding;
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Function2 {
        b() {
        }

        public final void a(androidx.compose.runtime.i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-541145127, i11, -1, "com.transsion.baseui.activity.BaseCommonActivity.getEnterHomeView.<anonymous>.<anonymous> (BaseCommonActivity.kt:205)");
            }
            BaseCommonActivity.this.EnterHomeView(iVar, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(BaseCommonActivity baseCommonActivity) {
        if (com.transsion.baseui.util.c.f43558a.a(R$mipmap.ic_tab_home, 2000L)) {
            return Unit.f67184a;
        }
        Navigator.x(TheRouter.c("/main/tab").F("tabIndex", 0), baseCommonActivity, null, 2, null);
        hj.i iVar = hj.i.f64628a;
        String pageName = baseCommonActivity.getPageName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "deeplink_enter_home_click");
        Unit unit = Unit.f67184a;
        iVar.p(pageName, hashMap);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(BaseCommonActivity baseCommonActivity, int i11, androidx.compose.runtime.i iVar, int i12) {
        baseCommonActivity.EnterHomeView(iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }

    private final View W() {
        ComposeView composeView = new ComposeView(this, null, 0, 6, null);
        ViewTreeLifecycleOwner.b(composeView, this);
        ViewTreeViewModelStoreOwner.b(composeView, this);
        ViewTreeSavedStateRegistryOwner.b(composeView, this);
        composeView.setContent(androidx.compose.runtime.internal.b.b(-541145127, true, new b()));
        return composeView;
    }

    private final void X() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            layoutParams.y = a0.a(120.0f);
            layoutParams.flags = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
            layoutParams.format = -3;
            getWindowManager().addView(W(), layoutParams);
            hj.i iVar = hj.i.f64628a;
            String pageName = getPageName();
            HashMap hashMap = new HashMap();
            hashMap.put("event_type", "deeplink_enter_home_browse");
            Unit unit = Unit.f67184a;
            iVar.D(pageName, hashMap);
        }
    }

    public final void EnterHomeView(androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i g11 = iVar.g(976578532);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(this) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 3) == 2 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(976578532, i12, -1, "com.transsion.baseui.activity.BaseCommonActivity.EnterHomeView (BaseCommonActivity.kt:213)");
            }
            Painter c11 = i0.e.c(R$mipmap.ic_tab_home, g11, 0);
            b.c h11 = androidx.compose.ui.b.f4162a.h();
            f.a aVar = androidx.compose.ui.f.f4253a;
            float f11 = 0;
            float f12 = 20;
            androidx.compose.ui.f a11 = BackgroundKt.a(SizeKt.e(aVar, o0.i.g(36)), i0.b.a(R$color.bg_01_70_reverse, g11, 0), q.g.d(o0.i.g(f11), o0.i.g(f12), o0.i.g(f12), o0.i.g(f11)));
            g11.P(1849434622);
            Object y10 = g11.y();
            i.a aVar2 = androidx.compose.runtime.i.f3811a;
            if (y10 == aVar2.a()) {
                y10 = p.h.a();
                g11.p(y10);
            }
            p.i iVar3 = (p.i) y10;
            g11.K();
            g11.P(5004770);
            boolean A = g11.A(this);
            Object y11 = g11.y();
            if (A || y11 == aVar2.a()) {
                y11 = new Function0() { // from class: com.transsion.baseui.activity.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit U;
                        U = BaseCommonActivity.U(BaseCommonActivity.this);
                        return U;
                    }
                };
                g11.p(y11);
            }
            g11.K();
            androidx.compose.ui.f b11 = ClickableKt.b(a11, iVar3, null, false, null, null, (Function0) y11, 28, null);
            g11.x(693286680);
            t b12 = androidx.compose.foundation.layout.a0.b(androidx.compose.foundation.layout.b.f2911a.c(), h11, g11, 48);
            g11.x(-1323940314);
            int a12 = androidx.compose.runtime.g.a(g11, 0);
            s n11 = g11.n();
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a13 = companion.a();
            Function3 a14 = LayoutKt.a(b11);
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a13);
            } else {
                g11.o();
            }
            androidx.compose.runtime.i a15 = f3.a(g11);
            f3.b(a15, b12, companion.c());
            f3.b(a15, n11, companion.e());
            Function2 b13 = companion.b();
            if (a15.e() || !Intrinsics.c(a15.y(), Integer.valueOf(a12))) {
                a15.p(Integer.valueOf(a12));
                a15.k(Integer.valueOf(a12), b13);
            }
            a14.invoke(h2.a(h2.b(g11)), g11, 0);
            g11.x(2058660585);
            d0 d0Var = d0.f2924a;
            e0.a(SizeKt.l(aVar, o0.i.g(8)), g11, 6);
            ImageKt.a(c11, null, SizeKt.j(aVar, o0.i.g(18)), null, null, 0.0f, v1.a.b(androidx.compose.ui.graphics.v1.f4750b, i0.b.a(R$color.bg_01, g11, 0), 0, 2, null), g11, 432, 56);
            e0.a(SizeKt.l(aVar, o0.i.g(4)), g11, 6);
            TextKt.a(i0.h.a(R$string.tab_home, g11, 0), null, i0.b.a(R$color.bg_01, g11, 0), x.c(14), null, p.f6224b.c(), androidx.compose.ui.text.font.h.f6199b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, g11, 199680, 0, 130962);
            iVar2 = g11;
            e0.a(SizeKt.l(aVar, o0.i.g(12)), iVar2, 6);
            iVar2.N();
            iVar2.r();
            iVar2.N();
            iVar2.N();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: com.transsion.baseui.activity.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit V;
                    V = BaseCommonActivity.V(BaseCommonActivity.this, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return V;
                }
            });
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (getIntent().getBooleanExtra(EXTRA_SHOW_HOME_BUTTON, false)) {
            finishAffinity();
        }
        super.finish();
    }

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final T getMViewBinding() {
        T t11 = this.mViewBinding;
        if (t11 != null) {
            return t11;
        }
        Intrinsics.z("mViewBinding");
        return null;
    }

    public String getPageName() {
        return "";
    }

    public abstract g4.a getViewBinding();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:3:0x0001, B:7:0x0006, B:9:0x0014, B:15:0x0027, B:17:0x003a, B:19:0x0040, B:20:0x0046, B:22:0x004c, B:24:0x005b, B:26:0x0061, B:27:0x0067, B:29:0x0085, B:32:0x008a, B:39:0x0096, B:40:0x009d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void intercept(android.content.Context r9, android.os.Bundle r10) {
        /*
            r8 = this;
            r0 = 1
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1f
            if (r10 != 0) goto L6
            return
        L6:
            ih.b r1 = ih.b.f65364a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = r1.n()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = "9"
            boolean r2 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r2 != 0) goto L22
            java.lang.String r2 = "10"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L1d
            goto L22
        L1d:
            r1 = 0
            goto L23
        L1f:
            r9 = move-exception
            goto La4
        L22:
            r1 = r0
        L23:
            if (r9 == 0) goto L9d
            if (r1 == 0) goto L9d
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r10.setClassLoader(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = "androidx.lifecycle.BundlableSavedStateRegistry.key"
            android.os.Bundle r10 = r10.getBundle(r1)     // Catch: java.lang.Throwable -> L1f
            if (r10 == 0) goto L96
            java.util.Set r1 = r10.keySet()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L96
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L1f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L46:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L96
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r3 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r4 = r3 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            r5 = 0
            if (r4 == 0) goto L5e
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L1f
            goto L5f
        L5e:
            r3 = r5
        L5f:
            if (r3 == 0) goto L66
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            goto L67
        L66:
            r3 = r5
        L67:
            lg.a$a r4 = lg.a.f68962a     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r6.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = "BaseCommonActivity --> intercept() --> classLoader = "
            r6.append(r7)     // Catch: java.lang.Throwable -> L1f
            r6.append(r3)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L1f
            r4.j(r3, r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = r10.get(r2)     // Catch: java.lang.Throwable -> L1f
            boolean r3 = r2 instanceof android.os.Bundle     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L88
            r5 = r2
            android.os.Bundle r5 = (android.os.Bundle) r5     // Catch: java.lang.Throwable -> L1f
        L88:
            if (r5 == 0) goto L46
            java.lang.Class r2 = r9.getClass()     // Catch: java.lang.Throwable -> L1f
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Throwable -> L1f
            r5.setClassLoader(r2)     // Catch: java.lang.Throwable -> L1f
            goto L46
        L96:
            lg.a$a r9 = lg.a.f68962a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r10 = "BaseCommonActivity --> intercept() --> 当前系统版本9、10 替换BootClassLoader -- ClassLoader"
            r9.j(r10, r0)     // Catch: java.lang.Throwable -> L1f
        L9d:
            kotlin.Unit r9 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)     // Catch: java.lang.Throwable -> L1f
            goto Lae
        La4:
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE
            java.lang.Object r9 = kotlin.ResultKt.a(r9)
            java.lang.Object r9 = kotlin.Result.m1185constructorimpl(r9)
        Lae:
            java.lang.Throwable r9 = kotlin.Result.m1188exceptionOrNullimpl(r9)
            if (r9 != 0) goto Lb5
            goto Lcb
        Lb5:
            lg.a$a r10 = lg.a.f68962a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "BaseCommonActivity --> intercept() --> it = "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r10.j(r9, r0)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.activity.BaseCommonActivity.intercept(android.content.Context, android.os.Bundle):void");
    }

    public boolean isMonitorNetworkState() {
        return true;
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        intercept(this, savedInstanceState);
        super.onCreate(savedInstanceState);
        if (isMonitorNetworkState()) {
            m.f70597a.l(this);
        }
        setMViewBinding(getViewBinding());
        setView();
        X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isMonitorNetworkState()) {
            m.f70597a.m(this);
        }
        k.f(null, this, 1, null);
    }

    @Override // nh.n
    public void onDisconnected() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        k.k(null, this, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Intent launchIntentForPackage;
        try {
            super.onResume();
            k.o(null, this, 1, null);
        } catch (IllegalArgumentException unused) {
            if (isTaskRoot()) {
                String simpleName = getClass().getSimpleName();
                Intrinsics.g(simpleName, "getSimpleName(...)");
                if (StringsKt.c0(simpleName, "MainActivity", false, 2, null) && (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName())) != null) {
                    launchIntentForPackage.addFlags(268468224);
                    startActivity(launchIntentForPackage);
                }
            }
            finish();
        }
    }

    public final void setMViewBinding(T t11) {
        Intrinsics.h(t11, "<set-?>");
        this.mViewBinding = t11;
    }

    protected abstract void setView();
}
