package yl;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected String f79155a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f79156b;

    /* renamed from: c, reason: collision with root package name */
    protected Map f79157c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    protected boolean f79158d = true;

    /* renamed from: e, reason: collision with root package name */
    protected int f79159e = 10000;

    /* renamed from: f, reason: collision with root package name */
    protected int f79160f = 10000;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f79161g = false;

    /* renamed from: h, reason: collision with root package name */
    protected SSLSocketFactory f79162h;

    /* renamed from: i, reason: collision with root package name */
    protected HostnameVerifier f79163i;

    public b a(int i11) {
        this.f79159e = i11;
        return this;
    }

    public b b(boolean z10) {
        this.f79158d = z10;
        return this;
    }

    public b c(int i11) {
        this.f79160f = i11;
        return this;
    }

    public b d(String str) {
        this.f79155a = str;
        return this;
    }
}
