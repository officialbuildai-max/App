package gm;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.transsion.lib_web.cache.TWebViewAdCacheManager;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f64010a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final Handler f64011b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private static final Map f64012c = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f64013d = true;

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(WebView webView, String str) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.lib_web.cache.a.f46196a.d(webView);
            TWebViewAdCacheManager.f46190a.h(webView);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Exception e11) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e11));
        } catch (LinkageError e12) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e12));
        }
        try {
            ViewParent parent = webView.getParent();
            Unit unit = null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(webView);
                unit = Unit.f67184a;
            }
            Result.m1185constructorimpl(unit);
        } catch (Exception e13) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e13));
        } catch (LinkageError e14) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e14));
        }
        try {
            webView.destroy();
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Exception e15) {
            Result.Companion companion6 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(e15));
        } catch (LinkageError e16) {
            Result.Companion companion7 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(e16));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            i.f64006a.d("WebViewRenderProcessGuard --> destroy failed, owner = " + str + ", error = " + m1188exceptionOrNullimpl.getMessage());
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function0 function0) {
        function0.invoke();
    }

    private final void h(RenderProcessGoneDetail renderProcessGoneDetail, String str) {
        Object m1185constructorimpl;
        String str2;
        String str3;
        int rendererPriorityAtExit;
        boolean didCrash;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(Build.VERSION.SDK_INT >= 26 ? WebView.getCurrentWebViewPackage() : null);
        } catch (Exception e11) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(e11));
        } catch (LinkageError e12) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(e12));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        PackageInfo packageInfo = (PackageInfo) m1185constructorimpl;
        Pair a11 = TuplesKt.a("owner", str);
        if (renderProcessGoneDetail != null) {
            didCrash = renderProcessGoneDetail.didCrash();
            str2 = Boolean.valueOf(didCrash).toString();
        } else {
            str2 = null;
        }
        Pair a12 = TuplesKt.a("did_crash", str2);
        if (renderProcessGoneDetail != null) {
            rendererPriorityAtExit = renderProcessGoneDetail.rendererPriorityAtExit();
            str3 = Integer.valueOf(rendererPriorityAtExit).toString();
        } else {
            str3 = null;
        }
        Map m11 = MapsKt.m(a11, a12, TuplesKt.a("renderer_priority", str3), TuplesKt.a("webview_package", packageInfo != null ? packageInfo.packageName : null), TuplesKt.a("webview_version", packageInfo != null ? packageInfo.versionName : null));
        try {
            hj.i.f64628a.s("web", "app_perf", m11);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Exception e13) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e13));
        } catch (LinkageError e14) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e14));
        }
        i.f64006a.d("WebViewRenderProcessGuard --> renderer gone, params = " + m11);
    }

    public final boolean c(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail, final String owner) {
        boolean z10;
        Intrinsics.h(owner, "owner");
        f64013d = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            f64010a.h(renderProcessGoneDetail, owner);
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Exception e11) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e11));
        } catch (LinkageError e12) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(e12));
        }
        if (webView == null) {
            i.f64006a.d("WebViewRenderProcessGuard --> renderer gone, webView is null, owner = " + owner);
            return true;
        }
        Map destroyedWebViews = f64012c;
        Intrinsics.g(destroyedWebViews, "destroyedWebViews");
        synchronized (destroyedWebViews) {
            z10 = destroyedWebViews.put(webView, Boolean.TRUE) == null;
        }
        if (z10) {
            final Function0 function0 = new Function0() { // from class: gm.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit d11;
                    d11 = n.d(webView, owner);
                    return d11;
                }
            };
            if (Intrinsics.c(Looper.myLooper(), Looper.getMainLooper())) {
                function0.invoke();
            } else {
                f64011b.post(new Runnable() { // from class: gm.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.e(Function0.this);
                    }
                });
            }
            return true;
        }
        i.f64006a.e("WebViewRenderProcessGuard --> WebView already destroyed, owner = " + owner);
        return true;
    }

    public final boolean f(WebView webView) {
        return webView != null && f64012c.containsKey(webView);
    }

    public final boolean g() {
        return f64013d;
    }
}
