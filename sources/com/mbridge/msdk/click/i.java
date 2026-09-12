package com.mbridge.msdk.click;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: f, reason: collision with root package name */
    private static final String f34387f = "i";

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f34388a;

    /* renamed from: b, reason: collision with root package name */
    private String f34389b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34390c = true;

    /* renamed from: d, reason: collision with root package name */
    private final int f34391d = 3145728;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f34392e;

    public i() {
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        this.f34388a = d11;
        if (d11 == null) {
            this.f34388a = com.mbridge.msdk.setting.h.b().a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036 A[Catch: all -> 0x000f, TryCatch #5 {all -> 0x000f, blocks: (B:41:0x0008, B:4:0x0013, B:8:0x0032, B:10:0x0036, B:11:0x0043), top: B:40:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e A[Catch: Exception -> 0x002f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:35:0x002b, B:13:0x004e), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(java.io.InputStream r4, boolean r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto L13
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r5.<init>(r4)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r4 = r5
            goto L13
        Lf:
            r4 = move-exception
            goto L60
        L11:
            r4 = move-exception
            goto L32
        L13:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
            r5.<init>(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
        L1d:
            java.lang.String r4 = r5.readLine()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r4 == 0) goto L2b
            r0.append(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            goto L1d
        L27:
            r4 = move-exception
            goto L61
        L29:
            r4 = move-exception
            goto L31
        L2b:
            r5.close()     // Catch: java.lang.Exception -> L2f
            goto L5b
        L2f:
            r4 = move-exception
            goto L52
        L31:
            r1 = r5
        L32:
            com.mbridge.msdk.click.entity.a r5 = r3.f34392e     // Catch: java.lang.Throwable -> Lf
            if (r5 != 0) goto L43
            com.mbridge.msdk.click.entity.a r5 = new com.mbridge.msdk.click.entity.a     // Catch: java.lang.Throwable -> Lf
            r5.<init>()     // Catch: java.lang.Throwable -> Lf
            r3.f34392e = r5     // Catch: java.lang.Throwable -> Lf
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf
            r5.f34372h = r2     // Catch: java.lang.Throwable -> Lf
        L43:
            java.lang.String r5 = com.mbridge.msdk.click.i.f34387f     // Catch: java.lang.Throwable -> Lf
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> Lf
            com.mbridge.msdk.foundation.tools.o0.b(r5, r4)     // Catch: java.lang.Throwable -> Lf
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.lang.Exception -> L2f
            goto L5b
        L52:
            java.lang.String r5 = com.mbridge.msdk.click.i.f34387f
            java.lang.String r4 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.o0.b(r5, r4)
        L5b:
            java.lang.String r4 = r0.toString()
            return r4
        L60:
            r5 = r1
        L61:
            if (r5 == 0) goto L71
            r5.close()     // Catch: java.lang.Exception -> L67
            goto L71
        L67:
            r5 = move-exception
            java.lang.String r0 = com.mbridge.msdk.click.i.f34387f
            java.lang.String r5 = r5.getMessage()
            com.mbridge.msdk.foundation.tools.o0.b(r0, r5)
        L71:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.i.a(java.io.InputStream, boolean):java.lang.String");
    }

    public com.mbridge.msdk.click.entity.a a(String str, boolean z10, boolean z11, CampaignEx campaignEx) {
        HttpsURLConnection httpsURLConnection;
        int i11;
        HttpsURLConnection httpsURLConnection2 = null;
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String replace = str.replace(" ", "%20");
        this.f34392e = new com.mbridge.msdk.click.entity.a();
        try {
            httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(replace).openConnection()));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            httpsURLConnection.setHostnameVerifier(new MBridgeHostnameVerifier(replace));
            httpsURLConnection.setRequestMethod("GET");
            if ((!z10 && !z11) || campaignEx == null) {
                httpsURLConnection.setRequestProperty("User-Agent", k0.i());
            }
            if (z10 && campaignEx != null && campaignEx.getcUA() == 1) {
                httpsURLConnection.setRequestProperty("User-Agent", k0.i());
            }
            if (z11 && campaignEx != null && campaignEx.getImpUA() == 1) {
                httpsURLConnection.setRequestProperty("User-Agent", k0.i());
            }
            httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (this.f34388a.I0() && !TextUtils.isEmpty(this.f34389b)) {
                httpsURLConnection.setRequestProperty(RequestParameters.SUBRESOURCE_REFERER, this.f34389b);
            }
            httpsURLConnection.setConnectTimeout(60000);
            httpsURLConnection.setReadTimeout(60000);
            httpsURLConnection.setInstanceFollowRedirects(false);
            httpsURLConnection.connect();
            this.f34392e.f34365a = httpsURLConnection.getHeaderField(HttpHeaders.LOCATION);
            this.f34392e.f34368d = httpsURLConnection.getHeaderField("Referer");
            this.f34392e.f34370f = httpsURLConnection.getResponseCode();
            this.f34392e.f34366b = httpsURLConnection.getContentType();
            this.f34392e.f34369e = httpsURLConnection.getContentLength();
            this.f34392e.f34367c = httpsURLConnection.getContentEncoding();
            boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.f34392e.f34367c);
            com.mbridge.msdk.click.entity.a aVar = this.f34392e;
            if (aVar.f34370f == 200 && this.f34390c && (i11 = aVar.f34369e) > 0 && i11 < 3145728 && !TextUtils.isEmpty(replace)) {
                try {
                    String a11 = a(httpsURLConnection.getInputStream(), equalsIgnoreCase);
                    if (!TextUtils.isEmpty(a11)) {
                        byte[] bytes = a11.getBytes();
                        if (bytes.length > 0 && bytes.length < 3145728) {
                            this.f34392e.f34371g = a11.trim();
                        }
                    }
                } catch (Throwable th3) {
                    o0.b(f34387f, th3.getMessage());
                }
            }
            this.f34389b = replace;
            httpsURLConnection.disconnect();
            return this.f34392e;
        } catch (Throwable th4) {
            th = th4;
            httpsURLConnection2 = httpsURLConnection;
            try {
                this.f34392e.f34372h = th.getMessage();
                return this.f34392e;
            } finally {
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
            }
        }
    }
}
