package com.cloud.hisavana.sdk;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.cloud.hisavana.sdk.common.bean.PreloadH5Entry;
import com.cloud.hisavana.sdk.common.widget.webview.ActionWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class k4 {

    /* renamed from: a, reason: collision with root package name */
    public static final k4 f22682a = new k4();

    /* renamed from: b, reason: collision with root package name */
    private static final String f22683b = "05MCJTA6GF3qZyZcN5Kwag==";

    /* renamed from: c, reason: collision with root package name */
    private static final String f22684c = "WebViewPreloader";

    /* renamed from: d, reason: collision with root package name */
    private static final List f22685d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedHashMap f22686e = new LinkedHashMap(1, 0.75f, true);

    /* renamed from: f, reason: collision with root package name */
    private static long f22687f;

    private k4() {
    }

    private final PreloadH5Entry d(Context context, AdsDTO adsDTO) {
        ActionWebView actionWebView = new ActionWebView(new MutableContextWrapper(context.getApplicationContext()));
        e4.b().d(f22684c, "createNewPreloadEntry, webView is " + actionWebView);
        return new PreloadH5Entry(actionWebView, adsDTO, null, 0, null, 0L, null, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
    }

    private final void g(WebView webView, Context context) {
        Context context2 = webView.getContext();
        MutableContextWrapper mutableContextWrapper = context2 instanceof MutableContextWrapper ? (MutableContextWrapper) context2 : null;
        if (mutableContextWrapper == null) {
            return;
        }
        mutableContextWrapper.setBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PreloadH5Entry preloadH5Entry, Context context) {
        Intrinsics.h(preloadH5Entry, "$preloadH5Entry");
        Intrinsics.h(context, "$context");
        try {
            f22685d.remove(preloadH5Entry);
            ViewParent parent = preloadH5Entry.getWebView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(preloadH5Entry.getWebView());
            }
            Context context2 = preloadH5Entry.getWebView().getContext();
            MutableContextWrapper mutableContextWrapper = context2 instanceof MutableContextWrapper ? (MutableContextWrapper) context2 : null;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(context.getApplicationContext());
            }
            preloadH5Entry.release();
        } catch (Throwable th2) {
            e4.b().w(f22684c, "release error: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AdsDTO adsDTO, Context context) {
        Intrinsics.h(adsDTO, "$adsDTO");
        Intrinsics.h(context, "$context");
        try {
            com.cloud.hisavana.sdk.common.util.b bVar = com.cloud.hisavana.sdk.common.util.b.f22230a;
            if (!bVar.g(adsDTO)) {
                e4.b().w(f22684c, "preload: offline ad or default ad not available");
                return;
            }
            if (!NetStateManager.checkNetworkState(false)) {
                e4.b().w(f22684c, "preload: network not available");
                return;
            }
            if (!bVar.h(adsDTO.getRealLandUrl())) {
                e4.b().w(f22684c, "preload: invalid url " + adsDTO.getRealLandUrl());
                return;
            }
            LinkedHashMap linkedHashMap = f22686e;
            if (linkedHashMap.containsKey(adsDTO.getUuid())) {
                e4.b().d(f22684c, "preload: uuid " + adsDTO.getUuid() + " is preloading");
                return;
            }
            int size = f22685d.size() + linkedHashMap.size();
            long currentTimeMillis = System.currentTimeMillis();
            e4.b().d(f22684c, "preload: start to load uuid " + adsDTO.getUuid() + ", currentTotal " + size + ", url is " + adsDTO.getRealLandUrl());
            if (size < 1) {
                PreloadH5Entry d11 = f22682a.d(context, adsDTO);
                String uuid = adsDTO.getUuid();
                Intrinsics.g(uuid, "getUuid(...)");
                linkedHashMap.put(uuid, d11);
                d11.load();
                return;
            }
            if (linkedHashMap.isEmpty()) {
                return;
            }
            if (currentTimeMillis - f22687f < 2000) {
                if (adsDTO.getPreloadStatus() < 2) {
                    adsDTO.setPreloadStatus(2);
                    return;
                }
                return;
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            if (it.hasNext()) {
                PreloadH5Entry preloadH5Entry = (PreloadH5Entry) ((Map.Entry) it.next()).getValue();
                it.remove();
                AdsDTO adsDTO2 = preloadH5Entry.getAdsDTO();
                if (adsDTO2 != null) {
                    adsDTO2.setPreloadStatus(7);
                }
                preloadH5Entry.release();
                PreloadH5Entry d12 = f22682a.d(context, adsDTO);
                String uuid2 = adsDTO.getUuid();
                Intrinsics.g(uuid2, "getUuid(...)");
                linkedHashMap.put(uuid2, d12);
                d12.load();
                f22687f = currentTimeMillis;
            }
        } catch (Throwable th2) {
            e4.b().w(f22684c, "preload error: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String str) {
        PreloadH5Entry preloadH5Entry;
        if (str == null || (preloadH5Entry = (PreloadH5Entry) f22686e.remove(str)) == null) {
            return;
        }
        preloadH5Entry.release();
    }

    public final PreloadH5Entry e(Context context, AdsDTO adsDTO, PreloadH5Entry.PreloadCallback callback) {
        boolean z10;
        PreloadH5Entry d11;
        Intrinsics.h(context, "context");
        Intrinsics.h(adsDTO, "adsDTO");
        Intrinsics.h(callback, "callback");
        try {
            String realLandUrl = adsDTO.getRealLandUrl();
            LinkedHashMap linkedHashMap = f22686e;
            PreloadH5Entry preloadH5Entry = (PreloadH5Entry) linkedHashMap.remove(adsDTO.getUuid());
            if (preloadH5Entry == null) {
                z10 = true;
                if (f22685d.size() + linkedHashMap.size() < 1) {
                    d11 = d(context, adsDTO);
                } else if (linkedHashMap.isEmpty()) {
                    d11 = d(context, adsDTO);
                } else {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    PreloadH5Entry preloadH5Entry2 = (PreloadH5Entry) ((Map.Entry) it.next()).getValue();
                    it.remove();
                    preloadH5Entry2.release();
                    d11 = d(context, adsDTO);
                }
                preloadH5Entry = d11;
            } else {
                adsDTO.setPreloadStatus(6);
                z10 = false;
            }
            f22685d.add(preloadH5Entry);
            g(preloadH5Entry.getWebView(), context);
            preloadH5Entry.setCallback(callback);
            if (!com.cloud.hisavana.sdk.common.util.b.f22230a.h(realLandUrl)) {
                adsDTO.setPreloadStatus(8);
                preloadH5Entry.setOverrideUrl(realLandUrl);
            } else if (z10) {
                preloadH5Entry.load();
            }
            return preloadH5Entry;
        } catch (Throwable th2) {
            e4.b().w(f22684c, "getPreloadH5Entry error: " + th2.getMessage());
            return null;
        }
    }

    public final void f(final Context context, final PreloadH5Entry preloadH5Entry) {
        Intrinsics.h(context, "context");
        Intrinsics.h(preloadH5Entry, "preloadH5Entry");
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.h4
            @Override // java.lang.Runnable
            public final void run() {
                k4.h(PreloadH5Entry.this, context);
            }
        });
    }

    public final void j(final String str) {
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.i4
            @Override // java.lang.Runnable
            public final void run() {
                k4.m(str);
            }
        });
    }

    public final boolean k(AdsDTO adsDTO) {
        Intrinsics.h(adsDTO, "adsDTO");
        try {
            Integer dspType = adsDTO.getDspType();
            if (dspType != null && dspType.intValue() == 1 && !adsDTO.isOfflineAd() && adsDTO.getSource() != 4 && adsDTO.getPreloadEnable().booleanValue()) {
                com.cloud.hisavana.sdk.common.util.b bVar = com.cloud.hisavana.sdk.common.util.b.f22230a;
                if (!bVar.h(adsDTO.getClickUrl())) {
                    e4.b().w(f22684c, "clickurl is invalid: " + adsDTO.getClickUrl());
                    return false;
                }
                if (!bVar.f(adsDTO)) {
                    e4.b().w(f22684c, "ad is not landing page conversion, ad id is " + adsDTO.getAdCreativeId());
                    return false;
                }
                com.cloud.hisavana.sdk.common.util.r rVar = com.cloud.hisavana.sdk.common.util.r.f22275a;
                String l11 = rVar.l(adsDTO.getClickUrl(), "d");
                if (l11 != null && l11.length() != 0) {
                    String h11 = rVar.h(l11, f22683b);
                    e4.b().d(f22684c, "current ad realLandUrl is " + h11);
                    adsDTO.setRealLandUrl(h11);
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            e4.b().w(f22684c, "checkAdPreloadEnableAndGetRealLandurl error: " + th2.getMessage());
            return false;
        }
    }

    public final void l(final Context context, final AdsDTO adsDTO) {
        Intrinsics.h(context, "context");
        Intrinsics.h(adsDTO, "adsDTO");
        HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.j4
            @Override // java.lang.Runnable
            public final void run() {
                k4.i(AdsDTO.this, context);
            }
        });
    }
}
