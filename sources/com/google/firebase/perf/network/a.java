package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a extends HttpURLConnection {

    /* renamed from: a, reason: collision with root package name */
    private final c f32365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HttpURLConnection httpURLConnection, Timer timer, i iVar) {
        super(httpURLConnection.getURL());
        this.f32365a = new c(httpURLConnection, timer, iVar);
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        this.f32365a.a(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() {
        this.f32365a.b();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.f32365a.c();
    }

    public boolean equals(Object obj) {
        return this.f32365a.equals(obj);
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.f32365a.d();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.f32365a.e();
    }

    @Override // java.net.URLConnection
    public Object getContent() {
        return this.f32365a.f();
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] clsArr) {
        return this.f32365a.g(clsArr);
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        return this.f32365a.h();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.f32365a.i();
    }

    @Override // java.net.URLConnection
    public long getContentLengthLong() {
        return this.f32365a.j();
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        return this.f32365a.k();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.f32365a.l();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.f32365a.m();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.f32365a.n();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.f32365a.o();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f32365a.p();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.f32365a.q();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i11) {
        return this.f32365a.r(i11);
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        return this.f32365a.s(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String str, long j11) {
        return this.f32365a.t(str, j11);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String str, int i11) {
        return this.f32365a.u(str, i11);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i11) {
        return this.f32365a.v(i11);
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldLong(String str, long j11) {
        return this.f32365a.w(str, j11);
    }

    @Override // java.net.URLConnection
    public Map getHeaderFields() {
        return this.f32365a.x();
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.f32365a.y();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() {
        return this.f32365a.z();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.f32365a.A();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.f32365a.B();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() {
        return this.f32365a.C();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() {
        return this.f32365a.D();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.f32365a.E();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.f32365a.F();
    }

    @Override // java.net.URLConnection
    public Map getRequestProperties() {
        return this.f32365a.G();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        return this.f32365a.H(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() {
        return this.f32365a.I();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() {
        return this.f32365a.J();
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.f32365a.K();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.f32365a.L();
    }

    public int hashCode() {
        return this.f32365a.hashCode();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z10) {
        this.f32365a.M(z10);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i11) {
        this.f32365a.N(i11);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i11) {
        this.f32365a.O(i11);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z10) {
        this.f32365a.P(z10);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z10) {
        this.f32365a.Q(z10);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z10) {
        this.f32365a.R(z10);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i11) {
        this.f32365a.S(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j11) {
        this.f32365a.T(j11);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j11) {
        this.f32365a.U(j11);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z10) {
        this.f32365a.V(z10);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i11) {
        this.f32365a.W(i11);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) {
        this.f32365a.X(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        this.f32365a.Y(str, str2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z10) {
        this.f32365a.Z(z10);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.f32365a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.f32365a.b0();
    }
}
