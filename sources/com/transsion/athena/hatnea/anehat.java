package com.transsion.athena.hatnea;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.hatnea.aatnhe;
import com.transsion.gslb.GslbSdk;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class anehat {

    /* renamed from: a, reason: collision with root package name */
    private static SSLSocketFactory f42817a;

    private static com.transsion.athena.anateh.athena a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new com.transsion.athena.anateh.athena(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ehanat<aatnhe> a(long j11, byte[] bArr, int i11, com.transsion.athena.config.data.model.aethna aethnaVar) {
        URL url;
        HttpURLConnection httpURLConnection;
        byte[] bArr2;
        SSLContext a11;
        ehanat<aatnhe> ehanatVar = new ehanat<>(2, new aatnhe("sdk_error"));
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                url = new URL(GslbSdk.getDomain(aethnaVar.f42638a, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (f42817a == null && (a11 = com.transsion.athena.ehanat.athena.a()) != null) {
                    f42817a = a11.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = f42817a;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.f42759a);
                }
            }
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            if (aethnaVar.f42640c * 1024 <= bArr.length) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                httpURLConnection.setRequestProperty("zip", "1");
                bArr2 = com.transsion.athena.config.data.model.anehat.b(bArr);
            } else {
                httpURLConnection.setRequestProperty("Accept-Encoding", "text/example");
                httpURLConnection.setRequestProperty("zip", "0");
                bArr2 = bArr;
            }
            httpURLConnection.setRequestProperty("fixed", "1");
            httpURLConnection.setRequestProperty("record-id", j11 + "");
            httpURLConnection.setRequestProperty("count", i11 + "");
            httpURLConnection.setRequestProperty("ver", "3.1.1.4");
            TidConfigBean b11 = com.transsion.athena.aethna.athena.c().b(j11);
            if (b11 == null) {
                com.transsion.athena.taaneh.aethna.a("requestByPost TidConfigBean " + j11 + " is missing, maybe cancelled");
                ehanatVar.f42831b.f42810d = "tid not found";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            b11.getTidConfig().getClass();
            com.transsion.athena.anateh.athena a12 = a((byte[]) aethnaVar.f42639b.second);
            if (a12 == null) {
                ehanatVar.f42831b.f42810d = "encrypt error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            byte[] bytes = Base64.encodeToString(a12.b(bArr2), 2).getBytes();
            if (bytes == null) {
                com.transsion.athena.taaneh.aethna.b("requestByPost buffer is null");
                ehanatVar.f42831b.f42810d = "base64 error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            String a13 = com.transsion.athena.config.data.model.anehat.a(bytes);
            if (TextUtils.isEmpty(a13)) {
                httpURLConnection.setRequestProperty("md5", "error");
            } else {
                httpURLConnection.setRequestProperty("md5", a13);
            }
            httpURLConnection.setRequestProperty("encrypt-level", String.valueOf(3));
            httpURLConnection.setRequestProperty("encrypt-index", String.valueOf(((Integer) aethnaVar.f42639b.first).intValue() + 1));
            com.transsion.athena.taaneh.aethna.c(url + " tid = " + j11 + " count = " + i11);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                ehanat<aatnhe> ehanatVar2 = new ehanat<>(-1, new aatnhe("rc_" + com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream())));
                httpURLConnection.disconnect();
                return ehanatVar2;
            }
            String a14 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            com.transsion.athena.taaneh.aethna.c(String.format(Locale.ENGLISH, "post tid: %s response: %s", Long.valueOf(j11), a14));
            if (TextUtils.isEmpty(a14)) {
                ehanat<aatnhe> ehanatVar3 = new ehanat<>(-1, new aatnhe("rc_" + i11));
                httpURLConnection.disconnect();
                return ehanatVar3;
            }
            int optInt = new JSONObject(a14).optInt("code");
            if (optInt == 0) {
                ehanat<aatnhe> ehanatVar4 = new ehanat<>(0, new aatnhe());
                httpURLConnection.disconnect();
                return ehanatVar4;
            }
            ehanat<aatnhe> ehanatVar5 = new ehanat<>(-1, new aatnhe("rc_" + optInt));
            httpURLConnection.disconnect();
            return ehanatVar5;
        } catch (Exception e12) {
            e = e12;
            httpURLConnection2 = httpURLConnection;
            if (e instanceof UnknownHostException) {
                com.transsion.athena.taaneh.aethna.b(e.getMessage());
            } else {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return new ehanat<>(-1, new aatnhe());
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
    
        if (r4 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.transsion.athena.hatnea.ehanat<java.lang.Long> a(java.lang.String r4) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L69
            boolean r0 = r4 instanceof javax.net.ssl.HttpsURLConnection     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            if (r0 == 0) goto L3e
            javax.net.ssl.SSLSocketFactory r0 = com.transsion.athena.hatnea.anehat.f42817a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            if (r0 != 0) goto L2c
            javax.net.ssl.SSLContext r0 = com.transsion.athena.ehanat.athena.a()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            if (r0 == 0) goto L2c
            javax.net.ssl.SSLSocketFactory r0 = r0.getSocketFactory()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            com.transsion.athena.hatnea.anehat.f42817a = r0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            goto L2c
        L27:
            r0 = move-exception
            goto L92
        L2a:
            r0 = move-exception
            goto L6d
        L2c:
            javax.net.ssl.SSLSocketFactory r0 = com.transsion.athena.hatnea.anehat.f42817a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            if (r0 == 0) goto L3e
            r1 = r4
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r1.setSSLSocketFactory(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r0 = r4
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            com.transsion.athena.ehanat.athena$aethna r1 = com.transsion.athena.ehanat.athena.f42759a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r0.setHostnameVerifier(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
        L3e:
            r0 = 10000(0x2710, float:1.4013E-41)
            r4.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r4.setConnectTimeout(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            int r0 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L82
            r1 = 400(0x190, float:5.6E-43)
            if (r0 >= r1) goto L82
            com.transsion.athena.hatnea.ehanat r0 = new com.transsion.athena.hatnea.ehanat     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            long r1 = r4.getDate()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r2 = 0
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            r4.disconnect()
            return r0
        L64:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L92
        L69:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
        L6d:
            boolean r1 = r0 instanceof java.net.UnknownHostException     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L79
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L27
            com.transsion.athena.taaneh.aethna.b(r0)     // Catch: java.lang.Throwable -> L27
            goto L80
        L79:
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch: java.lang.Throwable -> L27
            com.transsion.athena.taaneh.aethna.b(r0)     // Catch: java.lang.Throwable -> L27
        L80:
            if (r4 == 0) goto L85
        L82:
            r4.disconnect()
        L85:
            com.transsion.athena.hatnea.ehanat r4 = new com.transsion.athena.hatnea.ehanat
            r0 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r1 = -1
            r4.<init>(r1, r0)
            return r4
        L92:
            if (r4 == 0) goto L97
            r4.disconnect()
        L97:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.hatnea.anehat.a(java.lang.String):com.transsion.athena.hatnea.ehanat");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ehanat<String> a(String str, String str2, long j11) {
        ehanat<String> ehanatVar;
        HttpURLConnection httpURLConnection;
        com.transsion.athena.anateh.athena athenaVar;
        String str3;
        URL url;
        SSLContext a11;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                String c11 = com.transsion.athena.config.data.model.anehat.c(keyGenerator.generateKey().getEncoded());
                athenaVar = new com.transsion.athena.anateh.athena(c11.getBytes());
                byte[] a12 = athenaVar.a(str2);
                str3 = Base64.encodeToString(a12, 2) + "," + Base64.encodeToString(new nq.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNrm4jErOdstd1P5L1X/\nCGSS6NKf4glPrFbTM97aE9ZKGUiMALIV8W7FClAgLZdtTZkL5XEQdbX4RB/C6edc\nnN2ifla6sVu23y78FMiL6smp9ayE7Y3gSEfB3md4nvEUpyRUu4wYLIf9nVR36okK\nGCerxYdLtDbJ69Rux4lgE5C9a6qLfV6BzjJYONk/vQhGQYT6qes+TFtXV0hvF8UM\nDG+0GfA3MiQue/Ny8uIPBykDPS1dcIADzVos2fXs/o2aFTrkdVjiX8irwYBze69K\nzFx18H12iZ9gG1VztMbHetvImBoXeCOwjTc5RnGIz+Hya96pxJLK2DcSlAaHEs1H\nOQIDAQAB").d(c11), 2);
                url = new URL(GslbSdk.getDomain(str, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (f42817a == null && (a11 = com.transsion.athena.ehanat.athena.a()) != null) {
                        f42817a = a11.getSocketFactory();
                    }
                    SSLSocketFactory sSLSocketFactory = f42817a;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.f42759a);
                    }
                }
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(str3.length()));
                httpURLConnection.setRequestProperty("encrypt-level", "2");
                httpURLConnection.setRequestProperty("ver", String.valueOf(j11));
                httpURLConnection.setRequestProperty("vn", "1");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                printWriter.write(str3);
                printWriter.flush();
                printWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", url);
                    jSONObject.put("params", str2);
                    jSONObject.put("version", j11);
                    jSONObject.put("code", responseCode);
                    com.transsion.athena.taaneh.aethna.c("--> request config:%s", jSONObject.toString());
                } catch (Exception e12) {
                    com.transsion.athena.taaneh.aethna.b("print request config exception:%s", e12.getMessage());
                }
                if (responseCode == 200) {
                    String a13 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
                    if (TextUtils.equals("{}", a13)) {
                        ehanatVar = new ehanat<>(1, null);
                    } else if (TextUtils.isEmpty(a13)) {
                        ehanatVar = new ehanat<>(-1, null);
                    } else {
                        ehanatVar = new ehanat<>(0, str.contains("secret") ? new String(athenaVar.a(Base64.decode(a13, 2)), StandardCharsets.UTF_8) : new String(com.transsion.athena.config.data.model.anehat.d(athenaVar.a(Base64.decode(a13, 2))), StandardCharsets.UTF_8));
                    }
                } else {
                    ehanatVar = new ehanat<>(-1, com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream()));
                }
            } catch (Exception e13) {
                e = e13;
                httpURLConnection2 = httpURLConnection;
                ehanat<String> ehanatVar2 = new ehanat<>(-1, e.getMessage());
                if (httpURLConnection2 == null) {
                    return ehanatVar2;
                }
                ehanatVar = ehanatVar2;
                httpURLConnection = httpURLConnection2;
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            httpURLConnection.disconnect();
            return ehanatVar;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ehanat<String> a(String str, String str2, long j11, int i11) {
        ehanat<String> ehanatVar;
        HttpURLConnection httpURLConnection;
        URL url;
        byte[] bytes;
        Pair<Integer, byte[]> i12;
        com.transsion.athena.anateh.athena a11;
        SSLContext a12;
        HttpURLConnection httpURLConnection2 = null;
        ehanat<String> ehanatVar2 = new ehanat<>(-1, null);
        try {
            try {
                url = new URL(GslbSdk.getDomain(str, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                try {
                    try {
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            if (f42817a == null && (a12 = com.transsion.athena.ehanat.athena.a()) != null) {
                                f42817a = a12.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = f42817a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.f42759a);
                            }
                        }
                        bytes = str2.getBytes();
                        i12 = com.transsion.athena.aethna.athena.c().i();
                        a11 = a((byte[]) i12.second);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    httpURLConnection2 = httpURLConnection;
                    ehanat<String> ehanatVar3 = new ehanat<>(-1, e.getMessage());
                    if (httpURLConnection2 == null) {
                        return ehanatVar3;
                    }
                    ehanatVar = ehanatVar3;
                    httpURLConnection = httpURLConnection2;
                    httpURLConnection.disconnect();
                    return ehanatVar;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
        }
        if (a11 == null) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return ehanatVar2;
        }
        byte[] bytes2 = Base64.encodeToString(a11.b(bytes), 2).getBytes();
        httpURLConnection.setRequestProperty("index", String.valueOf(((Integer) i12.first).intValue() + 1));
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes2.length));
        httpURLConnection.setRequestProperty("ver", String.valueOf(j11));
        httpURLConnection.setRequestProperty("vn", "1");
        httpURLConnection.setRequestProperty("app", String.valueOf(i11));
        httpURLConnection.setRequestProperty("model", Build.MODEL);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bytes2);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", url);
            jSONObject.put("params", str2);
            jSONObject.put("version", j11);
            jSONObject.put("code", responseCode);
            com.transsion.athena.taaneh.aethna.c("--> request config:%s", jSONObject.toString());
        } catch (Exception e13) {
            com.transsion.athena.taaneh.aethna.b("print request config exception:%s", e13.getMessage());
        }
        if (responseCode == 200) {
            String a13 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            ehanatVar = TextUtils.equals("{}", a13) ? new ehanat<>(1, null) : TextUtils.isEmpty(a13) ? new ehanat<>(-1, null) : new ehanat<>(0, new String(com.transsion.athena.config.data.model.anehat.d(Base64.decode(a13, 2)), StandardCharsets.UTF_8));
        } else {
            ehanatVar = new ehanat<>(-1, com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream()));
        }
        httpURLConnection.disconnect();
        return ehanatVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ehanat<aatnhe> a(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        SSLContext a11;
        ehanat<aatnhe> ehanatVar = new ehanat<>(2, new aatnhe("sdk_error"));
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (f42817a == null && (a11 = com.transsion.athena.ehanat.athena.a()) != null) {
                    f42817a = a11.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = f42817a;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.f42759a);
                }
            }
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            int length = bArr.length;
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            httpURLConnection.setRequestProperty("zip", "1");
            byte[] b11 = com.transsion.athena.config.data.model.anehat.b(bArr);
            httpURLConnection.setRequestProperty("fixed", "1");
            httpURLConnection.setRequestProperty("count", String.valueOf(list.size()));
            httpURLConnection.setRequestProperty("appids", com.transsion.athena.config.data.model.anehat.a(list, "_"));
            httpURLConnection.setRequestProperty("ver", "3.1.1.4");
            httpURLConnection.setRequestProperty("uuid", str2);
            httpURLConnection.setRequestProperty("dupid", str3);
            Pair<Integer, byte[]> i12 = com.transsion.athena.aethna.athena.c().i();
            com.transsion.athena.anateh.athena a12 = a((byte[]) i12.second);
            if (a12 == null) {
                ehanatVar.f42831b.f42810d = "encrypt error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            byte[] bytes = Base64.encodeToString(a12.b(b11), 2).getBytes();
            if (bytes == null) {
                com.transsion.athena.taaneh.aethna.b("requestByPost buffer is null");
                ehanatVar.f42831b.f42810d = "base64 error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            httpURLConnection.setRequestProperty("encrypt-level", "3");
            httpURLConnection.setRequestProperty("encrypt-index", String.valueOf(((Integer) i12.first).intValue() + 1));
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                ehanat<aatnhe> ehanatVar2 = new ehanat<>(-1, new aatnhe("rc_" + com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream())));
                httpURLConnection.disconnect();
                return ehanatVar2;
            }
            String a13 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            if (TextUtils.isEmpty(a13)) {
                ehanat<aatnhe> ehanatVar3 = new ehanat<>(-1, new aatnhe("rc_" + i11));
                httpURLConnection.disconnect();
                return ehanatVar3;
            }
            JSONObject jSONObject = new JSONObject(a13);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message", "");
            aatnhe aatnheVar = new aatnhe();
            aatnheVar.f42807a = optInt;
            aatnheVar.f42808b = optString;
            if (optInt != 0) {
                aatnheVar.f42810d = "rc_" + optInt;
                ehanat<aatnhe> ehanatVar4 = new ehanat<>(-1, aatnheVar);
                httpURLConnection.disconnect();
                return ehanatVar4;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("app");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    long j11 = optJSONObject.getJSONObject(next).getLong("ver");
                    int i13 = optJSONObject.getJSONObject(next).getInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                    if (i13 != 0) {
                        aatnhe.athena athenaVar = new aatnhe.athena(Integer.parseInt(next), i13, j11);
                        if (aatnheVar.f42809c == null) {
                            aatnheVar.f42809c = new ArrayList();
                        }
                        aatnheVar.f42809c.add(athenaVar);
                    }
                }
            }
            ehanat<aatnhe> ehanatVar5 = new ehanat<>(0, aatnheVar);
            httpURLConnection.disconnect();
            return ehanatVar5;
        } catch (Exception e12) {
            e = e12;
            httpURLConnection2 = httpURLConnection;
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return new ehanat<>(-1, new aatnhe());
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
