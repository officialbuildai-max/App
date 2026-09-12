package com.aliyun.utils;

import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class AbsHttpHelper {
    private static final int CONNECTION_TIMEOUT = 10000;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doHttpGet(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            boolean r4 = r4 instanceof java.net.HttpURLConnection     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            if (r4 != 0) goto L15
            return
        L15:
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.String r1 = "GET"
            r4.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.connect()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L45
            java.io.InputStream r0 = r4.getInputStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.handleOKInputStream(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            goto L4c
        L41:
            r1 = move-exception
            goto L6c
        L43:
            r1 = move-exception
            goto L5a
        L45:
            java.io.InputStream r0 = r4.getErrorStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.handleErrorInputStream(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
        L4c:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L51
        L51:
            r4.disconnect()
            goto L6b
        L55:
            r1 = move-exception
            r4 = r0
            goto L6c
        L58:
            r1 = move-exception
            r4 = r0
        L5a:
            java.lang.String r2 = "HttpClientUtil"
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L41
            com.cicada.player.utils.Logger.w(r2, r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.io.IOException -> L68
        L68:
            if (r4 == 0) goto L6b
            goto L51
        L6b:
            return
        L6c:
            if (r0 == 0) goto L71
            r0.close()     // Catch: java.io.IOException -> L71
        L71:
            if (r4 == 0) goto L76
            r4.disconnect()
        L76:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.AbsHttpHelper.doHttpGet(java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doHttpsGet(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            boolean r4 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            if (r4 != 0) goto L15
            return
        L15:
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            java.lang.String r1 = "GET"
            r4.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.connect()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L45
            java.io.InputStream r0 = r4.getInputStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.handleOKInputStream(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            goto L4c
        L41:
            r1 = move-exception
            goto L6c
        L43:
            r1 = move-exception
            goto L5a
        L45:
            java.io.InputStream r0 = r4.getErrorStream()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.handleErrorInputStream(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
        L4c:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.io.IOException -> L51
        L51:
            r4.disconnect()
            goto L6b
        L55:
            r1 = move-exception
            r4 = r0
            goto L6c
        L58:
            r1 = move-exception
            r4 = r0
        L5a:
            java.lang.String r2 = "HttpClientUtil"
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L41
            com.cicada.player.utils.Logger.d(r2, r1)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.io.IOException -> L68
        L68:
            if (r4 == 0) goto L6b
            goto L51
        L6b:
            return
        L6c:
            if (r0 == 0) goto L71
            r0.close()     // Catch: java.io.IOException -> L71
        L71:
            if (r4 == 0) goto L76
            r4.disconnect()
        L76:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aliyun.utils.AbsHttpHelper.doHttpsGet(java.lang.String):void");
    }

    public void doGet(String str) {
        if (str.startsWith("https://")) {
            doHttpsGet(str);
        } else if (str.startsWith("http://")) {
            doHttpGet(str);
        }
    }

    protected abstract void handleErrorInputStream(InputStream inputStream);

    protected abstract void handleOKInputStream(InputStream inputStream);
}
