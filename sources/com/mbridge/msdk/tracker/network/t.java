package com.mbridge.msdk.tracker.network;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.v;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class t<T> implements Comparable<t<T>> {

    /* renamed from: a, reason: collision with root package name */
    private c f38675a;

    /* renamed from: b, reason: collision with root package name */
    private String f38676b;

    /* renamed from: c, reason: collision with root package name */
    private volatile p f38677c;

    /* renamed from: d, reason: collision with root package name */
    private long f38678d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f38679e;

    /* renamed from: f, reason: collision with root package name */
    private int f38680f;

    /* renamed from: g, reason: collision with root package name */
    private final String f38681g;

    /* renamed from: h, reason: collision with root package name */
    private final int f38682h;

    /* renamed from: i, reason: collision with root package name */
    private final String f38683i;

    /* renamed from: j, reason: collision with root package name */
    private final int f38684j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f38685k;

    /* renamed from: l, reason: collision with root package name */
    private v.a f38686l;

    /* renamed from: m, reason: collision with root package name */
    private Integer f38687m;

    /* renamed from: n, reason: collision with root package name */
    private u f38688n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f38689o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f38690p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f38691q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f38692r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f38693s;

    /* renamed from: t, reason: collision with root package name */
    private x f38694t;

    /* renamed from: u, reason: collision with root package name */
    private b.a f38695u;

    /* renamed from: v, reason: collision with root package name */
    private long f38696v;

    /* loaded from: classes5.dex */
    public enum a {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public t(int i11, String str) {
        this(i11, str, 0);
    }

    public t(int i11, String str, int i12) {
        this(i11, str, i12, "un_known");
    }

    public t(int i11, String str, int i12, String str2) {
        this.f38685k = new Object();
        this.f38689o = false;
        this.f38690p = false;
        this.f38691q = false;
        this.f38692r = false;
        this.f38693s = false;
        this.f38695u = null;
        this.f38696v = 0L;
        this.f38680f = i11;
        this.f38681g = str;
        this.f38682h = i12;
        this.f38683i = str2;
        a((x) new e());
        this.f38684j = b(str);
        this.f38678d = SystemClock.elapsedRealtime();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            int i11 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i11++;
                if (entry.getKey() != null) {
                    sb2.append(URLEncoder.encode(entry.getKey(), str));
                    sb2.append('=');
                    sb2.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str));
                    if (i11 <= map.size() - 1) {
                        sb2.append('&');
                    }
                }
            }
            return sb2.toString().getBytes(str);
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("Encoding not supported: " + str, e11);
        }
    }

    private static int b(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public final boolean A() {
        return this.f38693s;
    }

    public final boolean B() {
        return this.f38692r;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(t<T> tVar) {
        a l11 = l();
        a l12 = tVar.l();
        return l11 == l12 ? this.f38687m.intValue() - tVar.f38687m.intValue() : l12.ordinal() - l11.ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t<?> a(u uVar) {
        this.f38688n = uVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t<?> a(x xVar) {
        this.f38694t = xVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> a(boolean z10) {
        this.f38689o = z10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract v<T> a(q qVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i11) {
        u uVar = this.f38688n;
        if (uVar != null) {
            uVar.a(this, i11);
        }
    }

    public void a(p pVar) {
        this.f38677c = pVar;
    }

    public void a(v.a aVar) {
        this.f38686l = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v<?> vVar) {
        synchronized (this.f38685k) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(T t11);

    public void a(String str) {
    }

    public void a(String str, String str2) {
        if (this.f38679e == null) {
            this.f38679e = new HashMap();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.f38679e.put(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> b(int i11) {
        this.f38687m = Integer.valueOf(i11);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> b(boolean z10) {
        this.f38693s = z10;
        return this;
    }

    public void b(b0 b0Var) {
        v.a aVar;
        synchronized (this.f38685k) {
            aVar = this.f38686l;
        }
        if (aVar != null) {
            aVar.a(b0Var);
        }
    }

    public byte[] b() {
        Map<String, String> i11 = i();
        if (i11 == null || i11.size() <= 0) {
            this.f38696v = 0L;
            return null;
        }
        byte[] a11 = a(i11, j());
        this.f38696v = a11.length;
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b0 c(b0 b0Var) {
        return b0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t<?> c(boolean z10) {
        this.f38692r = z10;
        return this;
    }

    public String c() {
        return "application/x-www-form-urlencoded; charset=" + j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        u uVar = this.f38688n;
        if (uVar != null) {
            uVar.c(this);
        }
    }

    public b.a d() {
        return this.f38695u;
    }

    public String d(String str) {
        if (this.f38679e != null && !TextUtils.isEmpty(str)) {
            try {
                return this.f38679e.get(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public String e() {
        if (!TextUtils.isEmpty(this.f38676b)) {
            return this.f38676b;
        }
        if (this.f38675a == null) {
            this.f38675a = new com.mbridge.msdk.tracker.network.toolbox.e();
        }
        String a11 = this.f38675a.a(this);
        this.f38676b = a11;
        return a11;
    }

    public Map<String, String> f() {
        return Collections.emptyMap();
    }

    public int g() {
        return this.f38680f;
    }

    public p h() {
        return this.f38677c;
    }

    protected Map<String, String> i() {
        return null;
    }

    protected String j() {
        return "UTF-8";
    }

    public int k() {
        return this.f38682h;
    }

    public a l() {
        return a.NORMAL;
    }

    public long m() {
        return this.f38696v;
    }

    public long n() {
        return SystemClock.elapsedRealtime() - this.f38678d;
    }

    public x o() {
        return this.f38694t;
    }

    public String p() {
        return this.f38683i;
    }

    public final int q() {
        x o11 = o();
        if (o11 == null) {
            return 30000;
        }
        return o11.b();
    }

    public final long r() {
        x o11 = o();
        if (o11 == null) {
            return 30000L;
        }
        long a11 = o11.a();
        if (a11 < 0) {
            return 30000L;
        }
        return a11;
    }

    public int s() {
        return this.f38684j;
    }

    public String t() {
        return this.f38681g;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(s());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(v() ? "[X] " : "[ ] ");
        sb2.append(t());
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(l());
        sb2.append(" ");
        sb2.append(this.f38687m);
        return sb2.toString();
    }

    public boolean u() {
        boolean z10;
        synchronized (this.f38685k) {
            z10 = this.f38691q;
        }
        return z10;
    }

    public boolean v() {
        boolean z10;
        synchronized (this.f38685k) {
            z10 = this.f38690p;
        }
        return z10;
    }

    public void w() {
        synchronized (this.f38685k) {
            this.f38691q = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        synchronized (this.f38685k) {
        }
    }

    public boolean y() {
        return true;
    }

    public final boolean z() {
        return this.f38689o;
    }
}
