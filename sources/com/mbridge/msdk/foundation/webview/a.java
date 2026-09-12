package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.ArrayList;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class a implements BrowserView.e {

    /* renamed from: o, reason: collision with root package name */
    private static String f35926o = "a";

    /* renamed from: a, reason: collision with root package name */
    private int f35927a;

    /* renamed from: c, reason: collision with root package name */
    private String f35929c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f35930d;

    /* renamed from: e, reason: collision with root package name */
    private BaseTrackingListener f35931e;

    /* renamed from: f, reason: collision with root package name */
    private BrowserView f35932f;

    /* renamed from: g, reason: collision with root package name */
    private CampaignEx f35933g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.click.a f35934h;

    /* renamed from: i, reason: collision with root package name */
    private Context f35935i;

    /* renamed from: k, reason: collision with root package name */
    private JumpLoaderResult f35937k;

    /* renamed from: n, reason: collision with root package name */
    private long f35940n;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35928b = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f35938l = false;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f35939m = new RunnableC0497a();

    /* renamed from: j, reason: collision with root package name */
    private Handler f35936j = new Handler(Looper.getMainLooper());

    /* renamed from: com.mbridge.msdk.foundation.webview.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0497a implements Runnable {
        RunnableC0497a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.b(a.f35926o, "webview js！超时上限：" + a.this.f35927a + "ms");
            if (a.this.f35934h != null && a.this.f35937k != null) {
                a.this.f35937k.setSuccess(false);
                a.this.f35937k.setUrl(a.this.f35929c);
                a.this.f35937k.setType(2);
                a.this.f35937k.setExceptionMsg("linktype 8 time out");
                a.this.f35934h.a(a.this.f35937k, a.this.f35933g, 1, false);
            }
            a aVar = a.this;
            if (aVar.d(null, aVar.f35929c) && !a.this.f35938l) {
                a.this.f35938l = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f35935i, a.this.f35929c, a.this.f35933g);
            }
            if (a.this.f35931e != null) {
                a.this.f35931e.onFinishRedirection(a.this.f35933g, a.this.f35929c);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35942a;

        b(String str) {
            this.f35942a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f35934h != null && a.this.f35937k != null) {
                a.this.f35937k.setSuccess(true);
                a.this.f35937k.setUrl(this.f35942a);
                a.this.f35937k.setType(2);
                a.this.f35934h.a(a.this.f35937k, a.this.f35933g, 1, true);
            }
            if (a.this.f35931e != null) {
                a.this.f35931e.onFinishRedirection(a.this.f35933g, this.f35942a);
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35944a;

        c(String str) {
            this.f35944a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f35931e != null) {
                a.this.f35931e.onFinishRedirection(a.this.f35933g, this.f35944a);
            }
            if (a.this.f35934h == null || a.this.f35937k == null) {
                return;
            }
            a.this.f35937k.setSuccess(true);
            a.this.f35937k.setUrl(this.f35944a);
            a.this.f35937k.setType(2);
            a.this.f35934h.a(a.this.f35937k, a.this.f35933g, 1, true);
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35946a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f35947b;

        d(String str, String str2) {
            this.f35946a = str;
            this.f35947b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f35931e != null) {
                a.this.f35931e.onFinishRedirection(a.this.f35933g, this.f35946a);
            }
            if (a.this.f35934h == null || a.this.f35937k == null) {
                return;
            }
            a.this.f35937k.setSuccess(false);
            a.this.f35937k.setUrl(this.f35946a);
            a.this.f35937k.setType(2);
            a.this.f35937k.setExceptionMsg(this.f35947b);
            a.this.f35934h.a(a.this.f35937k, a.this.f35933g, 1, true);
        }
    }

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f35927a = 10000;
        this.f35937k = null;
        this.f35935i = context;
        this.f35933g = campaignEx;
        this.f35932f = browserView;
        this.f35931e = baseTrackingListener;
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        d11 = d11 == null ? h.b().a() : d11;
        this.f35934h = aVar;
        this.f35937k = new JumpLoaderResult();
        this.f35927a = (int) d11.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context == null) {
            return;
        }
        if (campaignEx != null) {
            campaignEx.getCurrentLocalRid();
        }
        try {
            int i11 = MBCommonActivity.f34090e;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.webview.b.f35949a.put(str, this.f35932f);
            if (s0.a.d(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace(MiniAppConfigHelper.DEFAULT_JUMP_STORE_DEEPLINK, "");
            }
            intent.putExtra("url", str);
            o0.c("url", "webview url = " + str);
            intent.setFlags(805306368);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            s0.a(context, str, this.f35931e, campaignEx, new ArrayList());
        }
    }

    private void c() {
        this.f35936j.removeCallbacks(this.f35939m);
    }

    private void d() {
        this.f35936j.postDelayed(this.f35939m, this.f35927a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.f35935i.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                                return false;
                            }
                        }
                    } catch (Throwable th2) {
                        o0.b(f35926o, th2.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http")) {
                                if (!parse2.getScheme().equals("https")) {
                                    str = stringExtra;
                                }
                            }
                            return true;
                        }
                    } catch (Throwable th3) {
                        o0.b(f35926o, th3.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(this.f35935i, str)) {
                    o0.b(f35926o, "openDeepLink");
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            o0.b(f35926o, th4.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f35935i.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setFlags(ASTNode.DEOP);
                            this.f35935i.startActivity(parseUri);
                            this.f35938l = true;
                            return true;
                        }
                    } catch (Throwable th2) {
                        o0.b(f35926o, th2.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http") && !parse2.getScheme().equals("https")) {
                                str = stringExtra;
                            }
                            webView.loadUrl(stringExtra);
                            return false;
                        }
                    } catch (Throwable th3) {
                        o0.b(f35926o, th3.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(this.f35935i, str)) {
                    o0.b(f35926o, "openDeepLink");
                    this.f35938l = true;
                    return true;
                }
            }
            return false;
        } catch (Throwable th4) {
            o0.b(f35926o, th4.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a() {
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, int i11, String str, String str2) {
        o0.d(f35926o, str);
        c();
        com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new d(str2, str));
        if (!d(webView, str2) || this.f35938l) {
            return;
        }
        this.f35938l = true;
        a(this.f35935i, str2, this.f35933g);
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, String str) {
        o0.b(f35926o, "onPageFinished1  " + str);
        if (this.f35928b) {
            this.f35940n = 0L;
            this.f35928b = false;
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new c(str));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c();
            Uri parse = Uri.parse(str);
            if ((parse.getScheme().equals("http") || parse.getScheme().equals("https")) && !this.f35938l) {
                this.f35938l = true;
                a(this.f35935i, str, this.f35933g);
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, String str, Bitmap bitmap) {
        if (this.f35940n == 0) {
            this.f35940n = System.currentTimeMillis();
            if (!this.f35930d) {
                this.f35930d = true;
                d();
            }
            this.f35938l = false;
        }
        this.f35929c = str;
        this.f35928b = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public boolean b(WebView webView, String str) {
        o0.b(f35926o, "shouldOverrideUrlLoading1  " + str);
        this.f35928b = false;
        if (s0.a.b(str) && s0.a.a(this.f35935i, str, null)) {
            this.f35938l = true;
        }
        boolean e11 = e(webView, str);
        if (e11) {
            this.f35940n = 0L;
            this.f35928b = false;
            c();
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new b(str));
        }
        return e11;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void c(WebView webView, String str) {
        if (this.f35940n == 0) {
            this.f35940n = System.currentTimeMillis();
            if (!this.f35930d) {
                this.f35930d = true;
                d();
            }
        }
        this.f35929c = str;
        this.f35928b = true;
    }
}
