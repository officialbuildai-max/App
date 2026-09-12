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
public final class TWebViewAdCacheManager {

    /* renamed from: a, reason: collision with root package name */
    public static final TWebViewAdCacheManager f46190a = new TWebViewAdCacheManager();

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f46191b = "";

    /* renamed from: c, reason: collision with root package name */
    private static volatile BridgeWebView f46192c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f46193d;

    private TWebViewAdCacheManager() {
    }

    private final BridgeWebView c(Context context) {
        try {
            return b.f46199a.b(context);
        } catch (Exception e11) {
            b.f46199a.g("createWebViewSafely() --> WebView 创建失败: " + e11.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str) {
        BridgeWebView bridgeWebView = f46192c;
        if (bridgeWebView != null) {
            bridgeWebView.setTag(-1001, String.valueOf(System.currentTimeMillis()));
            bridgeWebView.stopLoading();
            bridgeWebView.clearHistory();
            bridgeWebView.clearCache(true);
            bridgeWebView.loadUrl(TmcConstants.LOAD_BASE_DATA_URL);
            bridgeWebView.loadUrl(str);
            b bVar = b.f46199a;
            bVar.g("preloadInternal() --> 创建新对象加入缓存池 --> 预加载埋点 --> url = " + str);
            bVar.h(str, "preload");
            bridgeWebView.setTag(-1001, Boolean.TRUE);
            f46191b = str;
        }
    }

    public final void d(BridgeWebView bridgeWebView) {
        b.f46199a.g("destroy webview curWebview = " + f46192c + " ## desWeb = " + bridgeWebView);
        if (n.f64010a.f(bridgeWebView)) {
            if (bridgeWebView == null) {
                return;
            }
            h(bridgeWebView);
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$1
            if (r0 == 0) goto L13
            r0 = r5
            com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$1 r0 = (com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$1 r0 = new com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L6c
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            gm.n r5 = gm.n.f64010a
            com.github.lzyzsd.jsbridge.BridgeWebView r2 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            boolean r5 = r5.f(r2)
            if (r5 == 0) goto L49
            com.github.lzyzsd.jsbridge.BridgeWebView r5 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            java.lang.String r0 = "webview 已失效"
            if (r5 != 0) goto L45
            return r0
        L45:
            r4.h(r5)
            return r0
        L49:
            com.github.lzyzsd.jsbridge.BridgeWebView r5 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            if (r5 != 0) goto L50
            java.lang.String r5 = "webview 没有预热"
            return r5
        L50:
            java.lang.String r5 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46191b
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L5b
            java.lang.String r5 = "webview url为空"
            return r5
        L5b:
            com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$2 r5 = new com.transsion.lib_web.cache.TWebViewAdCacheManager$getAdStatus$2
            r2 = 0
            r5.<init>(r2)
            r0.label = r3
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.e(r2, r5, r0)
            if (r5 != r1) goto L6c
            return r1
        L6c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L72
            java.lang.String r5 = "超时还没回来"
        L72:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.cache.TWebViewAdCacheManager.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final BridgeWebView f(String url, Context context) {
        Intrinsics.h(url, "url");
        b.f46199a.g("getWebView() preload --> url = " + url + "  ## mCurrentH5Url = " + f46191b);
        if (n.f64010a.f(f46192c)) {
            BridgeWebView bridgeWebView = f46192c;
            if (bridgeWebView == null) {
                return null;
            }
            h(bridgeWebView);
        }
        if (Build.VERSION.SDK_INT >= 36) {
            if (context == null) {
                return null;
            }
            return c(context);
        }
        if (f46192c == null) {
            if (context == null) {
                context = Utils.a().getApplicationContext();
            }
            Intrinsics.e(context);
            BridgeWebView c11 = c(context);
            if (c11 == null) {
                return null;
            }
            f46192c = c11;
        }
        if (!i(url)) {
            g(url);
        }
        f46193d = true;
        return f46192c;
    }

    public final void h(WebView webView) {
        Intrinsics.h(webView, "webView");
        if (f46192c == webView) {
            f46192c = null;
            f46191b = null;
            f46193d = false;
            b.f46199a.g("invalidate() --> 清空失效的广告缓存 WebView");
        }
    }

    public final boolean i(String url) {
        Intrinsics.h(url, "url");
        return Build.VERSION.SDK_INT < 36 && TextUtils.equals(url, f46191b);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$1
            if (r0 == 0) goto L13
            r0 = r10
            com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$1 r0 = (com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$1 r0 = new com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.b(r10)
            goto Ldb
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.b(r10)
            goto Lc6
        L3b:
            kotlin.ResultKt.b(r10)
            gm.n r10 = gm.n.f64010a
            com.github.lzyzsd.jsbridge.BridgeWebView r2 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            boolean r10 = r10.f(r2)
            if (r10 == 0) goto L59
            com.github.lzyzsd.jsbridge.BridgeWebView r9 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            if (r9 != 0) goto L51
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        L51:
            r8.h(r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        L59:
            int r10 = android.os.Build.VERSION.SDK_INT
            r2 = 36
            if (r10 < r2) goto L6b
            com.transsion.lib_web.cache.b r9 = com.transsion.lib_web.cache.b.f46199a
            java.lang.String r10 = "isWebviewLoaded API 36+，因为 WebView 无法创建，所以这里返回取决于是否需要加载"
            r9.g(r10)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r9
        L6b:
            com.transsion.lib_web.cache.b r10 = com.transsion.lib_web.cache.b.f46199a
            java.lang.String r2 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46191b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isWebviewLoaded url = "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r7 = " ## mCurrentH5Url = "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r10.g(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 == 0) goto L96
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        L96:
            com.github.lzyzsd.jsbridge.BridgeWebView r2 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46192c
            if (r2 != 0) goto La4
            java.lang.String r9 = "isWebviewLoaded mCurrentWebView = null"
            r10.g(r9)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        La4:
            java.lang.String r2 = com.transsion.lib_web.cache.TWebViewAdCacheManager.f46191b
            boolean r2 = kotlin.jvm.internal.Intrinsics.c(r9, r2)
            r6 = 0
            if (r2 != 0) goto Lcb
            java.lang.String r2 = "isWebviewLoaded mCurrentWebView != url"
            r10.g(r2)
            if (r9 == 0) goto Lc6
            kotlinx.coroutines.a2 r10 = kotlinx.coroutines.y0.c()
            com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$2$1 r2 = new com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$2$1
            r2.<init>(r9, r6)
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.i.g(r10, r2, r0)
            if (r9 != r1) goto Lc6
            return r1
        Lc6:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        Lcb:
            com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$3 r9 = new com.transsion.lib_web.cache.TWebViewAdCacheManager$isWebviewLoaded$3
            r9.<init>(r6)
            r0.label = r3
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.e(r2, r9, r0)
            if (r10 != r1) goto Ldb
            return r1
        Ldb:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            if (r10 == 0) goto Le3
            boolean r5 = r10.booleanValue()
        Le3:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.cache.TWebViewAdCacheManager.j(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void k(String url) {
        Intrinsics.h(url, "url");
        b bVar = b.f46199a;
        bVar.g("preload() --> url = " + url + "  ## mCurrentH5Url = " + f46191b);
        if (!n.f64010a.g()) {
            bVar.g("preload() --> renderer 异常后当前进程关闭预加载");
            return;
        }
        if (TextUtils.equals(url, f46191b)) {
            bVar.g("preload() --> 正在缓存的地址，无需重复创建 --> url = " + url);
            return;
        }
        if (Build.VERSION.SDK_INT >= 36) {
            bVar.g("preload() --> API 36+，跳过 WebView 预创建 --> url = " + url);
            return;
        }
        if (f46193d) {
            bVar.g("preload() --> WebView 使用中，仅记录目标 URL，待归还后再加载 --> url = " + url);
            return;
        }
        if (f46192c == null) {
            Context applicationContext = Utils.a().getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            BridgeWebView c11 = c(applicationContext);
            if (c11 == null) {
                bVar.g("preload() --> 设备缺少 WebView 实现，跳过预加载 --> url = " + url);
                return;
            }
            f46192c = c11;
            bVar.g("preloadInternal() --> 不存在创建新的对象");
        }
        g(url);
    }

    public final void l(BridgeWebView webView, String url) {
        Intrinsics.h(webView, "webView");
        Intrinsics.h(url, "url");
        if (n.f64010a.f(webView)) {
            h(webView);
            return;
        }
        if (Build.VERSION.SDK_INT >= 36) {
            d(webView);
            return;
        }
        ViewParent parent = webView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        f46193d = false;
        b bVar = b.f46199a;
        bVar.g("recycle() --> WebView 归还缓存池 --> url = " + url);
        String str = f46191b;
        if (TextUtils.equals(str, url) || str == null || str.length() == 0) {
            bVar.g("recycle() --> 检测到待加载 URL 一致 mCurrentWebView = " + f46192c);
            return;
        }
        bVar.g("recycle() --> 检测到待加载 URL，补触 preload --> url = " + str);
        g(str);
    }
}
