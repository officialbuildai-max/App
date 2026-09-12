package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class HttpClientHelper {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String TAG = "HttpClientHelper";
    private static ExecutorService sThreadCachePool = Executors.newCachedThreadPool();
    private String mUrl;
    private URLConnection urlConnection = null;
    private String mReferer = null;
    private int mNetworkTimeout = 10000;
    private String mHttpProxy = null;
    private String mUserAgent = null;
    private String[] mCustomHeaders = null;

    public HttpClientHelper(String str) {
        this.mUrl = str;
    }

    private InputStream getErrorStream() {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getErrorStream();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getErrorStream();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #1 {Exception -> 0x0056, blocks: (B:10:0x003e, B:14:0x0043), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.URLConnection getHttpUrlConnection(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.mHttpProxy     // Catch: java.lang.Exception -> L57
            if (r1 == 0) goto L21
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L21
            java.lang.String r2 = r4.mHttpProxy     // Catch: java.lang.Exception -> L21
            r1.<init>(r2)     // Catch: java.lang.Exception -> L21
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch: java.lang.Exception -> L21
            java.lang.String r3 = r1.getHost()     // Catch: java.lang.Exception -> L21
            int r1 = r1.getPort()     // Catch: java.lang.Exception -> L21
            r2.<init>(r3, r1)     // Catch: java.lang.Exception -> L21
            java.net.Proxy r1 = new java.net.Proxy     // Catch: java.lang.Exception -> L21
            java.net.Proxy$Type r3 = java.net.Proxy.Type.HTTP     // Catch: java.lang.Exception -> L21
            r1.<init>(r3, r2)     // Catch: java.lang.Exception -> L21
            goto L22
        L21:
            r1 = r0
        L22:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> L57
            r2.<init>(r5)     // Catch: java.lang.Exception -> L57
            if (r1 == 0) goto L34
            java.net.URLConnection r5 = r2.openConnection(r1)     // Catch: java.lang.Exception -> L57
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch: java.lang.Exception -> L57
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch: java.lang.Exception -> L57
            goto L3e
        L34:
            java.net.URLConnection r5 = r2.openConnection()     // Catch: java.lang.Exception -> L57
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch: java.lang.Exception -> L57
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch: java.lang.Exception -> L57
        L3e:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch: java.lang.Exception -> L56
            if (r1 != 0) goto L43
            return r0
        L43:
            r0 = r5
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch: java.lang.Exception -> L56
            int r1 = r4.mNetworkTimeout     // Catch: java.lang.Exception -> L56
            r0.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L56
            int r1 = r4.mNetworkTimeout     // Catch: java.lang.Exception -> L56
            r0.setReadTimeout(r1)     // Catch: java.lang.Exception -> L56
            goto L58
        L56:
            r0 = r5
        L57:
            r5 = r0
        L58:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.HttpClientHelper.getHttpUrlConnection(java.lang.String):java.net.URLConnection");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #1 {Exception -> 0x0056, blocks: (B:10:0x003e, B:14:0x0043), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.URLConnection getHttpsUrlConnection(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.mHttpProxy     // Catch: java.lang.Exception -> L57
            if (r1 == 0) goto L21
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L21
            java.lang.String r2 = r4.mHttpProxy     // Catch: java.lang.Exception -> L21
            r1.<init>(r2)     // Catch: java.lang.Exception -> L21
            java.net.InetSocketAddress r2 = new java.net.InetSocketAddress     // Catch: java.lang.Exception -> L21
            java.lang.String r3 = r1.getHost()     // Catch: java.lang.Exception -> L21
            int r1 = r1.getPort()     // Catch: java.lang.Exception -> L21
            r2.<init>(r3, r1)     // Catch: java.lang.Exception -> L21
            java.net.Proxy r1 = new java.net.Proxy     // Catch: java.lang.Exception -> L21
            java.net.Proxy$Type r3 = java.net.Proxy.Type.HTTP     // Catch: java.lang.Exception -> L21
            r1.<init>(r3, r2)     // Catch: java.lang.Exception -> L21
            goto L22
        L21:
            r1 = r0
        L22:
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Exception -> L57
            r2.<init>(r5)     // Catch: java.lang.Exception -> L57
            if (r1 == 0) goto L34
            java.net.URLConnection r5 = r2.openConnection(r1)     // Catch: java.lang.Exception -> L57
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch: java.lang.Exception -> L57
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch: java.lang.Exception -> L57
            goto L3e
        L34:
            java.net.URLConnection r5 = r2.openConnection()     // Catch: java.lang.Exception -> L57
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch: java.lang.Exception -> L57
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch: java.lang.Exception -> L57
        L3e:
            boolean r1 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch: java.lang.Exception -> L56
            if (r1 != 0) goto L43
            return r0
        L43:
            r0 = r5
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch: java.lang.Exception -> L56
            int r1 = r4.mNetworkTimeout     // Catch: java.lang.Exception -> L56
            r0.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L56
            int r1 = r4.mNetworkTimeout     // Catch: java.lang.Exception -> L56
            r0.setReadTimeout(r1)     // Catch: java.lang.Exception -> L56
            goto L58
        L56:
            r0 = r5
        L57:
            r5 = r0
        L58:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.HttpClientHelper.getHttpsUrlConnection(java.lang.String):java.net.URLConnection");
    }

    private int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getResponseCode();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
    
        ((java.net.HttpURLConnection) r7).disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008a, code lost:
    
        if (r7 != null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2 A[Catch: IOException -> 0x00b5, TRY_LEAVE, TryCatch #3 {IOException -> 0x00b5, blocks: (B:43:0x00ad, B:36:0x00b2), top: B:42:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] post(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = r7
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L1e
            r4 = r3
            goto L1f
        L1e:
            r4 = r2
        L1f:
            r1.setDoOutput(r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1.setDoInput(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r3 = 10000(0x2710, float:1.4013E-41)
            r1.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            if (r8 == 0) goto L49
            int r3 = r8.length     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1.setFixedLengthStreamingMode(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1.connect()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r3.write(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r3.close()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            goto L4c
        L41:
            r8 = move-exception
            r3 = r0
            goto L99
        L45:
            r8 = r0
        L46:
            r3 = r8
            goto Lab
        L49:
            r1.connect()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
        L4c:
            int r8 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 != r3) goto L8a
            java.io.InputStream r8 = r1.getInputStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L88
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L88
            r3.<init>()     // Catch: java.lang.Throwable -> L83 java.lang.Exception -> L88
        L61:
            int r4 = r8.read(r1)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> Lab
            r5 = -1
            if (r4 == r5) goto L71
            r3.write(r1, r2, r4)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> Lab
            goto L61
        L6c:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto L99
        L71:
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> Lab
            r8.close()     // Catch: java.io.IOException -> L7b
            r3.close()     // Catch: java.io.IOException -> L7b
        L7b:
            if (r7 == 0) goto L82
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            r7.disconnect()
        L82:
            return r0
        L83:
            r1 = move-exception
            r3 = r0
            r0 = r8
            r8 = r1
            goto L99
        L88:
            r3 = r0
            goto Lab
        L8a:
            if (r7 == 0) goto Lb8
        L8c:
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            r7.disconnect()
            goto Lb8
        L92:
            r8 = move-exception
            r7 = r0
            r3 = r7
            goto L99
        L96:
            r7 = r0
            r8 = r7
            goto L46
        L99:
            if (r0 == 0) goto L9e
            r0.close()     // Catch: java.io.IOException -> La3
        L9e:
            if (r3 == 0) goto La3
            r3.close()     // Catch: java.io.IOException -> La3
        La3:
            if (r7 == 0) goto Laa
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7
            r7.disconnect()
        Laa:
            throw r8
        Lab:
            if (r8 == 0) goto Lb0
            r8.close()     // Catch: java.io.IOException -> Lb5
        Lb0:
            if (r3 == 0) goto Lb5
            r3.close()     // Catch: java.io.IOException -> Lb5
        Lb5:
            if (r7 == 0) goto Lb8
            goto L8c
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.HttpClientHelper.post(java.lang.String, byte[]):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0159 A[Catch: IOException -> 0x0161, TryCatch #13 {IOException -> 0x0161, blocks: (B:79:0x0154, B:64:0x0159, B:66:0x015e), top: B:78:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015e A[Catch: IOException -> 0x0161, TRY_LEAVE, TryCatch #13 {IOException -> 0x0161, blocks: (B:79:0x0154, B:64:0x0159, B:66:0x015e), top: B:78:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0180 A[Catch: IOException -> 0x0188, TryCatch #8 {IOException -> 0x0188, blocks: (B:105:0x017b, B:87:0x0180, B:89:0x0185), top: B:104:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0185 A[Catch: IOException -> 0x0188, TRY_LEAVE, TryCatch #8 {IOException -> 0x0188, blocks: (B:105:0x017b, B:87:0x0180, B:89:0x0185), top: B:104:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018c  */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String doGet() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.HttpClientHelper.doGet():java.lang.String");
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }

    public void setHttpProxy(String str) {
        this.mHttpProxy = str;
    }

    public void setRefer(String str) {
        this.mReferer = str;
    }

    public void setTimeout(int i11) {
        this.mNetworkTimeout = i11;
    }

    public void setUerAgent(String str) {
        this.mUserAgent = str;
    }

    public void stop() {
        Logger.d(TAG, "HttpClientHelper stop().... urlConnection = " + this.urlConnection);
        if (this.urlConnection != null) {
            sThreadCachePool.execute(new Runnable() { // from class: com.aliyun.utils.HttpClientHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (HttpClientHelper.this.urlConnection instanceof HttpsURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpsURLConnection.disconnect ");
                            ((HttpsURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        } else if (HttpClientHelper.this.urlConnection instanceof HttpURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpURLConnection.disconnect ");
                            ((HttpURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        }
                    } catch (Exception e11) {
                        Logger.e(HttpClientHelper.TAG, e11.getMessage());
                    }
                }
            });
        }
    }
}
