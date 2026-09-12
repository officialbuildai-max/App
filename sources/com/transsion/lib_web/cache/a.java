package com.transsion.lib_web.cache;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import gm.n;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f46196a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static String f46197b = "";

    /* renamed from: c, reason: collision with root package name */
    private static BridgeWebView f46198c;

    private a() {
    }

    private final BridgeWebView a(Context context) {
        try {
            return b.f46199a.b(context);
        } catch (Exception e11) {
            b.f46199a.g("createWebViewSafely() --> WebView 创建失败: " + e11.getMessage());
            return null;
        }
    }

    public final void b(BridgeWebView bridgeWebView) {
        if (n.f64010a.f(bridgeWebView)) {
            if (bridgeWebView == null) {
                return;
            }
            d(bridgeWebView);
        } else if (bridgeWebView != null) {
            ViewParent parent = bridgeWebView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(bridgeWebView);
            }
            bridgeWebView.stopLoading();
            bridgeWebView.clearHistory();
            bridgeWebView.clearCache(true);
            bridgeWebView.loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
            bridgeWebView.destroy();
        }
    }

    public final BridgeWebView c(String url, Context context) {
        Intrinsics.h(url, "url");
        if (n.f64010a.f(f46198c)) {
            BridgeWebView bridgeWebView = f46198c;
            if (bridgeWebView == null) {
                return null;
            }
            d(bridgeWebView);
        }
        if (!e(url)) {
            b.f46199a.g("get() --> 没有缓存，直接创建一个新的 --> url = " + url);
            if (context == null) {
                context = Utils.a().getApplicationContext();
            }
            Intrinsics.e(context);
            return a(context);
        }
        BridgeWebView bridgeWebView2 = f46198c;
        f46198c = null;
        f46197b = null;
        b.f46199a.g("get() --> 缓存命中，直接复用 --> url = " + url);
        if (bridgeWebView2 != null) {
            return bridgeWebView2;
        }
        if (context == null) {
            context = Utils.a().getApplicationContext();
        }
        Intrinsics.e(context);
        return a(context);
    }

    public final void d(WebView webView) {
        Intrinsics.h(webView, "webView");
        if (f46198c == webView) {
            f46198c = null;
            f46197b = null;
            b.f46199a.g("invalidate() --> 清空失效的普通缓存 WebView");
        }
    }

    public final boolean e(String url) {
        Intrinsics.h(url, "url");
        return TextUtils.equals(url, f46197b);
    }

    public final void f(String url) {
        Intrinsics.h(url, "url");
        if (!n.f64010a.g()) {
            b.f46199a.g("preload() --> renderer 异常后当前进程关闭预加载");
            return;
        }
        if (TextUtils.equals(url, f46197b)) {
            b.f46199a.g("preload() --> 正在缓存的地址，无需重复创建 --> url = " + url);
            return;
        }
        f46197b = url;
        if (Build.VERSION.SDK_INT >= 36) {
            b.f46199a.g("preload() --> API 36+，跳过 WebView 预创建 --> url = " + url);
            return;
        }
        if (f46198c == null) {
            Context applicationContext = Utils.a().getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            BridgeWebView a11 = a(applicationContext);
            if (a11 == null) {
                b.f46199a.g("preload() --> 设备缺少 WebView 实现，跳过预加载 --> url = " + url);
                return;
            }
            f46198c = a11;
            b.f46199a.g("preloadInternal() --> 不存在创建新的对象");
        }
        BridgeWebView bridgeWebView = f46198c;
        if (bridgeWebView != null) {
            bridgeWebView.setTag(-1001, String.valueOf(System.currentTimeMillis()));
            bridgeWebView.stopLoading();
            bridgeWebView.clearHistory();
            bridgeWebView.clearCache(true);
            bridgeWebView.loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
            bridgeWebView.loadUrl(url);
            b bVar = b.f46199a;
            bVar.g("preloadInternal() --> 创建新对象加入缓存池 --> 预加载埋点 --> url = " + url);
            bVar.h(url, "preload");
            bridgeWebView.setTag(-1001, Boolean.TRUE);
        }
    }
}
