package r3;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    private int f74168f;

    /* renamed from: h, reason: collision with root package name */
    private int f74170h;

    /* renamed from: o, reason: collision with root package name */
    private float f74177o;

    /* renamed from: a, reason: collision with root package name */
    private String f74163a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f74164b = "";

    /* renamed from: c, reason: collision with root package name */
    private Set f74165c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private String f74166d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f74167e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f74169g = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f74171i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f74172j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f74173k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f74174l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f74175m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f74176n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f74178p = -1;

    /* renamed from: q, reason: collision with root package name */
    private boolean f74179q = false;

    private static int B(int i11, String str, String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public c A(boolean z10) {
        this.f74173k = z10 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f74171i) {
            return this.f74170h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f74179q;
    }

    public int c() {
        if (this.f74169g) {
            return this.f74168f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f74167e;
    }

    public float e() {
        return this.f74177o;
    }

    public int f() {
        return this.f74176n;
    }

    public int g() {
        return this.f74178p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f74163a.isEmpty() && this.f74164b.isEmpty() && this.f74165c.isEmpty() && this.f74166d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f74163a, str, 1073741824), this.f74164b, str2, 2), this.f74166d, str3, 4);
        if (B == -1 || !set.containsAll(this.f74165c)) {
            return 0;
        }
        return B + (this.f74165c.size() * 4);
    }

    public int i() {
        int i11 = this.f74174l;
        if (i11 == -1 && this.f74175m == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f74175m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f74171i;
    }

    public boolean k() {
        return this.f74169g;
    }

    public boolean l() {
        return this.f74172j == 1;
    }

    public boolean m() {
        return this.f74173k == 1;
    }

    public c n(int i11) {
        this.f74170h = i11;
        this.f74171i = true;
        return this;
    }

    public c o(boolean z10) {
        this.f74174l = z10 ? 1 : 0;
        return this;
    }

    public c p(boolean z10) {
        this.f74179q = z10;
        return this;
    }

    public c q(int i11) {
        this.f74168f = i11;
        this.f74169g = true;
        return this;
    }

    public c r(String str) {
        this.f74167e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public c s(float f11) {
        this.f74177o = f11;
        return this;
    }

    public c t(int i11) {
        this.f74176n = i11;
        return this;
    }

    public c u(boolean z10) {
        this.f74175m = z10 ? 1 : 0;
        return this;
    }

    public c v(int i11) {
        this.f74178p = i11;
        return this;
    }

    public void w(String[] strArr) {
        this.f74165c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f74163a = str;
    }

    public void y(String str) {
        this.f74164b = str;
    }

    public void z(String str) {
        this.f74166d = str;
    }
}
