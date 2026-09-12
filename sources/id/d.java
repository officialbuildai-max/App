package id;

import java.util.List;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f65284a;

    /* renamed from: b, reason: collision with root package name */
    private int f65285b;

    /* renamed from: c, reason: collision with root package name */
    private final String f65286c;

    /* renamed from: d, reason: collision with root package name */
    private final List f65287d;

    /* renamed from: e, reason: collision with root package name */
    private final String f65288e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f65289f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f65290g;

    /* renamed from: h, reason: collision with root package name */
    private Object f65291h;

    /* renamed from: i, reason: collision with root package name */
    private final int f65292i;

    /* renamed from: j, reason: collision with root package name */
    private final int f65293j;

    /* renamed from: k, reason: collision with root package name */
    private final int f65294k;

    public d(byte[] bArr, String str, List list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public d(byte[] bArr, String str, List list, String str2, int i11) {
        this(bArr, str, list, str2, -1, -1, i11);
    }

    public d(byte[] bArr, String str, List list, String str2, int i11, int i12, int i13) {
        this.f65284a = bArr;
        this.f65285b = bArr == null ? 0 : bArr.length * 8;
        this.f65286c = str;
        this.f65287d = list;
        this.f65288e = str2;
        this.f65292i = i12;
        this.f65293j = i11;
        this.f65294k = i13;
    }

    public List a() {
        return this.f65287d;
    }

    public String b() {
        return this.f65288e;
    }

    public Integer c() {
        return this.f65290g;
    }

    public Integer d() {
        return this.f65289f;
    }

    public int e() {
        return this.f65285b;
    }

    public Object f() {
        return this.f65291h;
    }

    public byte[] g() {
        return this.f65284a;
    }

    public int h() {
        return this.f65292i;
    }

    public int i() {
        return this.f65293j;
    }

    public int j() {
        return this.f65294k;
    }

    public String k() {
        return this.f65286c;
    }

    public boolean l() {
        return this.f65292i >= 0 && this.f65293j >= 0;
    }

    public void m(Integer num) {
        this.f65290g = num;
    }

    public void n(Integer num) {
        this.f65289f = num;
    }

    public void o(int i11) {
        this.f65285b = i11;
    }

    public void p(Object obj) {
        this.f65291h = obj;
    }
}
