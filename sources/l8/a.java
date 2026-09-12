package l8;

import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.facebook.biddingkit.http.client.HttpMethod;
import com.facebook.biddingkit.http.client.HttpRequestException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private Set f68864d;

    /* renamed from: e, reason: collision with root package name */
    private Set f68865e;

    /* renamed from: a, reason: collision with root package name */
    protected int f68861a = 2000;

    /* renamed from: b, reason: collision with root package name */
    protected int f68862b = 8000;

    /* renamed from: c, reason: collision with root package name */
    protected String f68863c = "UTF-8";

    /* renamed from: f, reason: collision with root package name */
    private int f68866f = 3;

    /* renamed from: g, reason: collision with root package name */
    private boolean f68867g = false;

    /* renamed from: h, reason: collision with root package name */
    private Map f68868h = new TreeMap();

    private void a(HttpURLConnection httpURLConnection) {
        for (String str : this.f68868h.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f68868h.get(str));
        }
        httpURLConnection.setRequestProperty("Accept-Charset", this.f68863c);
    }

    private int d(int i11) {
        return (i11 <= 1 || i11 > 20) ? i11 : d(i11 - 1) + d(i11 - 2);
    }

    private byte[] n(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Type inference failed for: r4v0, types: [l8.a] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected l8.e b(java.lang.String r5, com.facebook.biddingkit.http.client.HttpMethod r6, java.lang.String r7, byte[] r8) {
        /*
            r4 = this;
            java.lang.String r0 = "AndroidHttpClient"
            r1 = 0
            r2 = 0
            r4.f68867g = r1     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            java.net.HttpURLConnection r5 = r4.i(r5)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r4.k(r5, r6, r7)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            r4.a(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            r5.connect()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            r6 = 1
            r4.f68867g = r6     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            java.util.Set r7 = r4.f68865e     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r7 == 0) goto L28
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r7 != 0) goto L28
            r7 = r6
            goto L29
        L22:
            r6 = move-exception
            r2 = r5
            goto L99
        L26:
            r6 = move-exception
            goto L70
        L28:
            r7 = r1
        L29:
            java.util.Set r3 = r4.f68864d     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r3 == 0) goto L34
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r3 != 0) goto L34
            r1 = r6
        L34:
            boolean r6 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r6 == 0) goto L4d
            if (r7 != 0) goto L3c
            if (r1 == 0) goto L4d
        L3c:
            r6 = r5
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L47
            java.util.Set r7 = r4.f68865e     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L47
            java.util.Set r1 = r4.f68864d     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L47
            l8.f.b(r6, r7, r1)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L47
            goto L4d
        L47:
            r6 = move-exception
            java.lang.String r7 = "Unable to validate SSL certificates: "
            android.util.Log.e(r0, r7, r6)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
        L4d:
            boolean r6 = r5.getDoOutput()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r6 == 0) goto L58
            if (r8 == 0) goto L58
            r4.t(r5, r8)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
        L58:
            boolean r6 = r5.getDoInput()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            if (r6 == 0) goto L63
            l8.e r6 = r4.m(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            goto L68
        L63:
            l8.e r6 = new l8.e     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
            r6.<init>(r5, r2)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L26
        L68:
            r5.disconnect()
            return r6
        L6c:
            r6 = move-exception
            goto L99
        L6e:
            r6 = move-exception
            r5 = r2
        L70:
            l8.e r7 = r4.l(r5)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L93
            if (r7 == 0) goto L82
            int r8 = r7.a()     // Catch: java.lang.Throwable -> L22
            if (r8 <= 0) goto L82
            if (r5 == 0) goto L81
            r5.disconnect()
        L81:
            return r7
        L82:
            com.facebook.biddingkit.http.client.HttpRequestException r8 = new com.facebook.biddingkit.http.client.HttpRequestException     // Catch: java.lang.Throwable -> L22
            r8.<init>(r6, r7)     // Catch: java.lang.Throwable -> L22
            throw r8     // Catch: java.lang.Throwable -> L22
        L88:
            java.lang.String r7 = "Failed http method: "
            android.util.Log.e(r0, r7, r6)     // Catch: java.lang.Throwable -> L93
            com.facebook.biddingkit.http.client.HttpRequestException r7 = new com.facebook.biddingkit.http.client.HttpRequestException     // Catch: java.lang.Throwable -> L22
            r7.<init>(r6, r2)     // Catch: java.lang.Throwable -> L22
            throw r7     // Catch: java.lang.Throwable -> L22
        L93:
            com.facebook.biddingkit.http.client.HttpRequestException r7 = new com.facebook.biddingkit.http.client.HttpRequestException     // Catch: java.lang.Throwable -> L22
            r7.<init>(r6, r2)     // Catch: java.lang.Throwable -> L22
            throw r7     // Catch: java.lang.Throwable -> L22
        L99:
            if (r2 == 0) goto L9e
            r2.disconnect()
        L9e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.a.b(java.lang.String, com.facebook.biddingkit.http.client.HttpMethod, java.lang.String, byte[]):l8.e");
    }

    public e c(d dVar) {
        try {
            return s(dVar);
        } catch (HttpRequestException e11) {
            Log.e("AndroidHttpClient", "Unable to send request and got a HttpRequestException: ", e11);
            return null;
        } catch (Exception e12) {
            Log.e("AndroidHttpClient", "Unable to send request and got a RuntimeException: ", new HttpRequestException(e12, null));
            return null;
        }
    }

    public e e(String str, Map map) {
        return c(new b(str, map));
    }

    protected int f(int i11) {
        return d(i11 + 2) * 1000;
    }

    public boolean g(HttpRequestException httpRequestException) {
        e httpResponse = httpRequestException.getHttpResponse();
        return httpResponse != null && httpResponse.a() > 0;
    }

    protected boolean h(Throwable th2, long j11) {
        long currentTimeMillis = (System.currentTimeMillis() - j11) + 10;
        return this.f68867g ? currentTimeMillis >= ((long) this.f68862b) : currentTimeMillis >= ((long) this.f68861a);
    }

    protected HttpURLConnection i(String str) {
        try {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException(str + " is not a valid URL", e11);
        }
    }

    public e j(String str, String str2, byte[] bArr) {
        return c(new c(str, null, str2, bArr));
    }

    protected void k(HttpURLConnection httpURLConnection, HttpMethod httpMethod, String str) {
        httpURLConnection.setConnectTimeout(this.f68861a);
        httpURLConnection.setReadTimeout(this.f68862b);
        httpURLConnection.setRequestMethod(httpMethod.getMethodName());
        httpURLConnection.setDoOutput(httpMethod.getDoOutput());
        httpURLConnection.setDoInput(httpMethod.getDoInput());
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        }
    }

    protected e l(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        byte[] n11 = null;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    n11 = n(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = errorStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, n11);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    protected e m(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        byte[] n11 = null;
        try {
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    n11 = n(inputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            e eVar = new e(httpURLConnection, n11);
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
            }
            return eVar;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void o(int i11) {
        this.f68861a = i11;
    }

    public void p(Set set) {
        this.f68865e = set;
    }

    public void q(Set set) {
        this.f68864d = set;
    }

    public void r(int i11) {
        this.f68862b = i11;
    }

    public e s(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        e eVar = null;
        for (int i11 = 0; i11 < this.f68866f; i11++) {
            try {
                o(f(i11));
                currentTimeMillis = System.currentTimeMillis();
                eVar = b(dVar.d(), dVar.c(), dVar.b(), dVar.a());
            } catch (HttpRequestException e11) {
                if (h(e11, currentTimeMillis) && i11 < this.f68866f - 1) {
                    continue;
                } else {
                    if (!g(e11) || i11 >= this.f68866f - 1) {
                        Log.e("AndroidHttpClient", "Unable to send request: ", e11);
                        break;
                    }
                    try {
                        Thread.sleep(this.f68861a);
                    } catch (InterruptedException e12) {
                        Log.e("AndroidHttpClient", "App is stopping: ", e12);
                    }
                }
            }
            if (eVar != null) {
                return eVar;
            }
        }
        return eVar;
    }

    protected int t(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream;
        try {
            outputStream = httpURLConnection.getOutputStream();
            if (outputStream != null) {
                try {
                    outputStream.write(bArr);
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            return responseCode;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }
}
