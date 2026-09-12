package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.integration.net.UrlKt;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f40210a;

    /* renamed from: c, reason: collision with root package name */
    private Context f40212c;

    /* renamed from: d, reason: collision with root package name */
    private int f40213d;

    /* renamed from: e, reason: collision with root package name */
    private int f40214e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f40215f;

    /* renamed from: b, reason: collision with root package name */
    private HttpURLConnection f40211b = null;

    /* renamed from: g, reason: collision with root package name */
    private int f40216g = -1;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f40217h = null;

    /* renamed from: i, reason: collision with root package name */
    private int f40218i = 10000;

    /* renamed from: j, reason: collision with root package name */
    private int f40219j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f40220k = 2;

    /* renamed from: l, reason: collision with root package name */
    private boolean f40221l = true;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f40222m = new a();

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j0.this.c() || j0.this.f40219j >= j0.this.f40220k) {
                return;
            }
            j0.c(j0.this);
            o0.a(this);
        }
    }

    public j0(Context context) {
        this.f40212c = context;
    }

    private void a(int i11) throws ProtocolException {
        this.f40211b.setRequestMethod(i11 != 1 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? i11 != 6 ? "GET" : "TRACE" : "HEAD" : "DELETE" : "PUT" : "POST");
    }

    public static synchronized void a(String str) {
        synchronized (j0.class) {
            if (!TextUtils.isEmpty(str) && !str.equals(f40210a)) {
                f40210a = str;
            }
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private void b() {
        Object obj;
        if (this.f40211b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f40210a)) {
                jSONObject.put("ipv6", f40210a);
            }
            if (!TextUtils.isEmpty(com.pgl.ssdk.ces.b.f())) {
                jSONObject.put(UrlKt.KEY_MINI_GAID, com.pgl.ssdk.ces.b.f());
            }
            jSONObject.put(TtmlNode.TAG_REGION, k0.a());
            Pair<Integer, String> a11 = n0.a(jSONObject.toString());
            if (a11 == null || (obj = a11.first) == null || a11.second == null) {
                return;
            }
            this.f40211b.addRequestProperty("cypher", String.valueOf(obj));
            this.f40211b.addRequestProperty("transfer-param", (String) a11.second);
        } catch (Exception unused) {
        }
    }

    private void b(int i11) {
        String str = i11 != 1 ? i11 != 2 ? "" : OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : "application/json; charset=utf-8";
        if (!str.isEmpty()) {
            this.f40211b.addRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        }
        String b11 = k0.b();
        if (b11 != null) {
            this.f40211b.addRequestProperty("x-pangle-target-idc", b11);
        }
        b();
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.f40211b.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9");
                return;
            }
            this.f40211b.addRequestProperty("Accept-Language", Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
        } catch (Throwable unused) {
        }
    }

    private void b(int i11, int i12, byte[] bArr) {
        this.f40213d = i11;
        this.f40214e = i12;
        this.f40215f = bArr;
    }

    static /* synthetic */ int c(j0 j0Var) {
        int i11 = j0Var.f40219j;
        j0Var.f40219j = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bb, code lost:
    
        if (r0 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c5, code lost:
    
        a(r5.f40216g, r5.f40217h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        r0 = r5.f40211b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ce, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d0, code lost:
    
        r0.disconnect();
        r5.f40211b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c2, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
    
        if (r0 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c() {
        /*
            r5 = this;
            java.lang.String r0 = "https://"
            r1 = 0
            r2 = 0
            android.content.Context r3 = r5.f40212c     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r3 = com.pgl.ssdk.k0.a(r3)     // Catch: java.lang.Throwable -> Ld6
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Ld6
            if (r4 == 0) goto L1f
            android.content.Context r0 = r5.f40212c     // Catch: java.lang.Throwable -> Ld6
            com.pgl.ssdk.k0.b(r0)     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = r5.f40211b
            if (r0 == 0) goto L1e
            r0.disconnect()
            r5.f40211b = r2
        L1e:
            return r1
        L1f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld6
            r4.<init>()     // Catch: java.lang.Throwable -> Ld6
            r4.append(r3)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r3 = r5.a()     // Catch: java.lang.Throwable -> Ld6
            r4.append(r3)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> Ld6
            boolean r4 = r3.startsWith(r0)     // Catch: java.lang.Throwable -> Ld6
            if (r4 != 0) goto L44
            java.lang.String r4 = "http://"
            boolean r4 = r3.startsWith(r4)     // Catch: java.lang.Throwable -> Ld6
            if (r4 != 0) goto L44
            java.lang.String r3 = r0.concat(r3)     // Catch: java.lang.Throwable -> Ld6
        L44:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> Ld6
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Ld6
            boolean r3 = r5.f40221l     // Catch: java.lang.Throwable -> Ld6
            if (r3 == 0) goto L5e
            java.net.Proxy r3 = java.net.Proxy.NO_PROXY     // Catch: java.lang.Throwable -> Ld6
            java.net.URLConnection r0 = r0.openConnection(r3)     // Catch: java.lang.Throwable -> Ld6
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch: java.lang.Throwable -> Ld6
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> Ld6
            r5.f40211b = r0     // Catch: java.lang.Throwable -> Ld6
            goto L6c
        L5e:
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> Ld6
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch: java.lang.Throwable -> Ld6
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Throwable -> Ld6
            r5.f40211b = r0     // Catch: java.lang.Throwable -> Ld6
        L6c:
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Ld6
            int r3 = r5.f40218i     // Catch: java.lang.Throwable -> Ld6
            r0.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Ld6
            int r3 = r5.f40218i     // Catch: java.lang.Throwable -> Ld6
            r0.setReadTimeout(r3)     // Catch: java.lang.Throwable -> Ld6
            int r0 = r5.f40213d     // Catch: java.lang.Throwable -> Ld6
            r5.a(r0)     // Catch: java.lang.Throwable -> Ld6
            int r0 = r5.f40214e     // Catch: java.lang.Throwable -> Ld6
            r5.b(r0)     // Catch: java.lang.Throwable -> Ld6
            byte[] r0 = r5.f40215f     // Catch: java.lang.Throwable -> Ld6
            r3 = 1
            if (r0 == 0) goto La2
            int r0 = r0.length     // Catch: java.lang.Throwable -> Ld6
            if (r0 <= 0) goto La2
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Ld6
            r0.setDoOutput(r3)     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Ld6
            java.io.OutputStream r0 = r0.getOutputStream()     // Catch: java.lang.Throwable -> Ld6
            byte[] r4 = r5.f40215f     // Catch: java.lang.Throwable -> Ld6
            r0.write(r4)     // Catch: java.lang.Throwable -> Ld6
            r0.flush()     // Catch: java.lang.Throwable -> Ld6
            r0.close()     // Catch: java.lang.Throwable -> Ld6
        La2:
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Ld6
            r0.connect()     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Lbe
            int r0 = r0.getResponseCode()     // Catch: java.lang.Throwable -> Lbe
            r5.f40216g = r0     // Catch: java.lang.Throwable -> Lbe
            java.net.HttpURLConnection r0 = r5.f40211b     // Catch: java.lang.Throwable -> Lbe
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> Lbe
            byte[] r4 = r5.a(r0)     // Catch: java.lang.Throwable -> Lbf
            r5.f40217h = r4     // Catch: java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lc5
            goto Lc2
        Lbe:
            r0 = r2
        Lbf:
            if (r0 != 0) goto Lc2
            goto Lc5
        Lc2:
            r0.close()     // Catch: java.lang.Throwable -> Ld6
        Lc5:
            int r0 = r5.f40216g     // Catch: java.lang.Throwable -> Ld6
            byte[] r4 = r5.f40217h     // Catch: java.lang.Throwable -> Ld6
            r5.a(r0, r4)     // Catch: java.lang.Throwable -> Ld6
            java.net.HttpURLConnection r0 = r5.f40211b
            if (r0 == 0) goto Ld5
            r0.disconnect()
            r5.f40211b = r2
        Ld5:
            return r3
        Ld6:
            java.net.HttpURLConnection r0 = r5.f40211b
            if (r0 == 0) goto Ldf
            r0.disconnect()
            r5.f40211b = r2
        Ldf:
            android.content.Context r0 = r5.f40212c
            com.pgl.ssdk.k0.b(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.j0.c():boolean");
    }

    abstract String a();

    public void a(int i11, int i12, byte[] bArr) {
        b(i11, i12, bArr);
        o0.a(this.f40222m);
    }

    abstract void a(int i11, byte[] bArr);
}
