package ka;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    private int f66816f;

    /* renamed from: h, reason: collision with root package name */
    private int f66818h;

    /* renamed from: o, reason: collision with root package name */
    private float f66825o;

    /* renamed from: a, reason: collision with root package name */
    private String f66811a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f66812b = "";

    /* renamed from: c, reason: collision with root package name */
    private Set f66813c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private String f66814d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f66815e = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f66817g = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f66819i = false;

    /* renamed from: j, reason: collision with root package name */
    private int f66820j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f66821k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f66822l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f66823m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f66824n = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f66826p = -1;

    /* renamed from: q, reason: collision with root package name */
    private boolean f66827q = false;

    private static int B(int i11, String str, String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public d A(boolean z10) {
        this.f66821k = z10 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f66819i) {
            return this.f66818h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f66827q;
    }

    public int c() {
        if (this.f66817g) {
            return this.f66816f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public String d() {
        return this.f66815e;
    }

    public float e() {
        return this.f66825o;
    }

    public int f() {
        return this.f66824n;
    }

    public int g() {
        return this.f66826p;
    }

    public int h(String str, String str2, Set set, String str3) {
        if (this.f66811a.isEmpty() && this.f66812b.isEmpty() && this.f66813c.isEmpty() && this.f66814d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f66811a, str, 1073741824), this.f66812b, str2, 2), this.f66814d, str3, 4);
        if (B == -1 || !set.containsAll(this.f66813c)) {
            return 0;
        }
        return B + (this.f66813c.size() * 4);
    }

    public int i() {
        int i11 = this.f66822l;
        if (i11 == -1 && this.f66823m == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.f66823m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f66819i;
    }

    public boolean k() {
        return this.f66817g;
    }

    public boolean l() {
        return this.f66820j == 1;
    }

    public boolean m() {
        return this.f66821k == 1;
    }

    public d n(int i11) {
        this.f66818h = i11;
        this.f66819i = true;
        return this;
    }

    public d o(boolean z10) {
        this.f66822l = z10 ? 1 : 0;
        return this;
    }

    public d p(boolean z10) {
        this.f66827q = z10;
        return this;
    }

    public d q(int i11) {
        this.f66816f = i11;
        this.f66817g = true;
        return this;
    }

    public d r(String str) {
        this.f66815e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public d s(float f11) {
        this.f66825o = f11;
        return this;
    }

    public d t(int i11) {
        this.f66824n = i11;
        return this;
    }

    public d u(boolean z10) {
        this.f66823m = z10 ? 1 : 0;
        return this;
    }

    public d v(int i11) {
        this.f66826p = i11;
        return this;
    }

    public void w(String[] strArr) {
        this.f66813c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f66811a = str;
    }

    public void y(String str) {
        this.f66812b = str;
    }

    public void z(String str) {
        this.f66814d = str;
    }
}
