package com.google.firebase.perf.network;

import android.os.Build;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;
import uc.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private static final sc.a f32368f = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f32369a;

    /* renamed from: b, reason: collision with root package name */
    private final i f32370b;

    /* renamed from: c, reason: collision with root package name */
    private long f32371c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f32372d = -1;

    /* renamed from: e, reason: collision with root package name */
    private final Timer f32373e;

    public c(HttpURLConnection httpURLConnection, Timer timer, i iVar) {
        this.f32369a = httpURLConnection;
        this.f32370b = iVar;
        this.f32373e = timer;
        iVar.q(httpURLConnection.getURL().toString());
    }

    private void a0() {
        if (this.f32371c == -1) {
            this.f32373e.reset();
            long micros = this.f32373e.getMicros();
            this.f32371c = micros;
            this.f32370b.k(micros);
        }
        String F = F();
        if (F != null) {
            this.f32370b.f(F);
        } else if (o()) {
            this.f32370b.f("POST");
        } else {
            this.f32370b.f("GET");
        }
    }

    public boolean A() {
        return this.f32369a.getInstanceFollowRedirects();
    }

    public long B() {
        a0();
        return this.f32369a.getLastModified();
    }

    public OutputStream C() {
        try {
            OutputStream outputStream = this.f32369a.getOutputStream();
            return outputStream != null ? new uc.b(outputStream, this.f32370b, this.f32373e) : outputStream;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public Permission D() {
        try {
            return this.f32369a.getPermission();
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public int E() {
        return this.f32369a.getReadTimeout();
    }

    public String F() {
        return this.f32369a.getRequestMethod();
    }

    public Map G() {
        return this.f32369a.getRequestProperties();
    }

    public String H(String str) {
        return this.f32369a.getRequestProperty(str);
    }

    public int I() {
        a0();
        if (this.f32372d == -1) {
            long durationMicros = this.f32373e.getDurationMicros();
            this.f32372d = durationMicros;
            this.f32370b.p(durationMicros);
        }
        try {
            int responseCode = this.f32369a.getResponseCode();
            this.f32370b.g(responseCode);
            return responseCode;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public String J() {
        a0();
        if (this.f32372d == -1) {
            long durationMicros = this.f32373e.getDurationMicros();
            this.f32372d = durationMicros;
            this.f32370b.p(durationMicros);
        }
        try {
            String responseMessage = this.f32369a.getResponseMessage();
            this.f32370b.g(this.f32369a.getResponseCode());
            return responseMessage;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public URL K() {
        return this.f32369a.getURL();
    }

    public boolean L() {
        return this.f32369a.getUseCaches();
    }

    public void M(boolean z10) {
        this.f32369a.setAllowUserInteraction(z10);
    }

    public void N(int i11) {
        this.f32369a.setChunkedStreamingMode(i11);
    }

    public void O(int i11) {
        this.f32369a.setConnectTimeout(i11);
    }

    public void P(boolean z10) {
        this.f32369a.setDefaultUseCaches(z10);
    }

    public void Q(boolean z10) {
        this.f32369a.setDoInput(z10);
    }

    public void R(boolean z10) {
        this.f32369a.setDoOutput(z10);
    }

    public void S(int i11) {
        this.f32369a.setFixedLengthStreamingMode(i11);
    }

    public void T(long j11) {
        this.f32369a.setFixedLengthStreamingMode(j11);
    }

    public void U(long j11) {
        this.f32369a.setIfModifiedSince(j11);
    }

    public void V(boolean z10) {
        this.f32369a.setInstanceFollowRedirects(z10);
    }

    public void W(int i11) {
        this.f32369a.setReadTimeout(i11);
    }

    public void X(String str) {
        this.f32369a.setRequestMethod(str);
    }

    public void Y(String str, String str2) {
        if ("User-Agent".equalsIgnoreCase(str)) {
            this.f32370b.r(str2);
        }
        this.f32369a.setRequestProperty(str, str2);
    }

    public void Z(boolean z10) {
        this.f32369a.setUseCaches(z10);
    }

    public void a(String str, String str2) {
        this.f32369a.addRequestProperty(str, str2);
    }

    public void b() {
        if (this.f32371c == -1) {
            this.f32373e.reset();
            long micros = this.f32373e.getMicros();
            this.f32371c = micros;
            this.f32370b.k(micros);
        }
        try {
            this.f32369a.connect();
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public boolean b0() {
        return this.f32369a.usingProxy();
    }

    public void c() {
        this.f32370b.o(this.f32373e.getDurationMicros());
        this.f32370b.a();
        this.f32369a.disconnect();
    }

    public boolean d() {
        return this.f32369a.getAllowUserInteraction();
    }

    public int e() {
        return this.f32369a.getConnectTimeout();
    }

    public boolean equals(Object obj) {
        return this.f32369a.equals(obj);
    }

    public Object f() {
        a0();
        this.f32370b.g(this.f32369a.getResponseCode());
        try {
            Object content = this.f32369a.getContent();
            if (content instanceof InputStream) {
                this.f32370b.l(this.f32369a.getContentType());
                return new uc.a((InputStream) content, this.f32370b, this.f32373e);
            }
            this.f32370b.l(this.f32369a.getContentType());
            this.f32370b.m(this.f32369a.getContentLength());
            this.f32370b.o(this.f32373e.getDurationMicros());
            this.f32370b.a();
            return content;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public Object g(Class[] clsArr) {
        a0();
        this.f32370b.g(this.f32369a.getResponseCode());
        try {
            Object content = this.f32369a.getContent(clsArr);
            if (content instanceof InputStream) {
                this.f32370b.l(this.f32369a.getContentType());
                return new uc.a((InputStream) content, this.f32370b, this.f32373e);
            }
            this.f32370b.l(this.f32369a.getContentType());
            this.f32370b.m(this.f32369a.getContentLength());
            this.f32370b.o(this.f32373e.getDurationMicros());
            this.f32370b.a();
            return content;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }

    public String h() {
        a0();
        return this.f32369a.getContentEncoding();
    }

    public int hashCode() {
        return this.f32369a.hashCode();
    }

    public int i() {
        a0();
        return this.f32369a.getContentLength();
    }

    public long j() {
        long contentLengthLong;
        a0();
        if (Build.VERSION.SDK_INT < 24) {
            return 0L;
        }
        contentLengthLong = this.f32369a.getContentLengthLong();
        return contentLengthLong;
    }

    public String k() {
        a0();
        return this.f32369a.getContentType();
    }

    public long l() {
        a0();
        return this.f32369a.getDate();
    }

    public boolean m() {
        return this.f32369a.getDefaultUseCaches();
    }

    public boolean n() {
        return this.f32369a.getDoInput();
    }

    public boolean o() {
        return this.f32369a.getDoOutput();
    }

    public InputStream p() {
        a0();
        try {
            this.f32370b.g(this.f32369a.getResponseCode());
        } catch (IOException unused) {
            f32368f.a("IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.f32369a.getErrorStream();
        return errorStream != null ? new uc.a(errorStream, this.f32370b, this.f32373e) : errorStream;
    }

    public long q() {
        a0();
        return this.f32369a.getExpiration();
    }

    public String r(int i11) {
        a0();
        return this.f32369a.getHeaderField(i11);
    }

    public String s(String str) {
        a0();
        return this.f32369a.getHeaderField(str);
    }

    public long t(String str, long j11) {
        a0();
        return this.f32369a.getHeaderFieldDate(str, j11);
    }

    public String toString() {
        return this.f32369a.toString();
    }

    public int u(String str, int i11) {
        a0();
        return this.f32369a.getHeaderFieldInt(str, i11);
    }

    public String v(int i11) {
        a0();
        return this.f32369a.getHeaderFieldKey(i11);
    }

    public long w(String str, long j11) {
        long headerFieldLong;
        a0();
        if (Build.VERSION.SDK_INT < 24) {
            return 0L;
        }
        headerFieldLong = this.f32369a.getHeaderFieldLong(str, j11);
        return headerFieldLong;
    }

    public Map x() {
        a0();
        return this.f32369a.getHeaderFields();
    }

    public long y() {
        return this.f32369a.getIfModifiedSince();
    }

    public InputStream z() {
        a0();
        this.f32370b.g(this.f32369a.getResponseCode());
        this.f32370b.l(this.f32369a.getContentType());
        try {
            InputStream inputStream = this.f32369a.getInputStream();
            return inputStream != null ? new uc.a(inputStream, this.f32370b, this.f32373e) : inputStream;
        } catch (IOException e11) {
            this.f32370b.o(this.f32373e.getDurationMicros());
            f.d(this.f32370b);
            throw e11;
        }
    }
}
