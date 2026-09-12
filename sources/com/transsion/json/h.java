package com.transsion.json;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes.dex */
public class h {

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadLocal f46113n = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f46114a;

    /* renamed from: b, reason: collision with root package name */
    private p f46115b;

    /* renamed from: f, reason: collision with root package name */
    private com.transsion.json.b.p f46119f;

    /* renamed from: g, reason: collision with root package name */
    private Map f46120g;

    /* renamed from: h, reason: collision with root package name */
    private List f46121h;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46126m;

    /* renamed from: c, reason: collision with root package name */
    private boolean f46116c = false;

    /* renamed from: d, reason: collision with root package name */
    private final Stack f46117d = new Stack();

    /* renamed from: e, reason: collision with root package name */
    private int f46118e = 0;

    /* renamed from: i, reason: collision with root package name */
    private t f46122i = t.SHALLOW;

    /* renamed from: j, reason: collision with root package name */
    private f f46123j = new f(Collections.EMPTY_SET);

    /* renamed from: k, reason: collision with root package name */
    private final LinkedList f46124k = new LinkedList();

    /* renamed from: l, reason: collision with root package name */
    private final q f46125l = new q();

    /* loaded from: classes.dex */
    static class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h initialValue() {
            return new h();
        }
    }

    private void I() {
        if (this.f46126m) {
            this.f46115b.a(",");
            if (this.f46116c) {
                this.f46115b.a("\n");
            }
            this.f46126m = false;
        }
    }

    private void J() {
        this.f46126m = false;
    }

    private com.transsion.json.b.n K() {
        return (com.transsion.json.b.n) this.f46120g.get(this.f46125l);
    }

    public static void c() {
        f46113n.remove();
    }

    private void d(char c11) {
        this.f46115b.a("\\u");
        int i11 = 0;
        int i12 = c11;
        while (i11 < 4) {
            this.f46115b.a(String.valueOf(j.f46129f[(61440 & i12) >> 12]));
            i11++;
            i12 <<= 4;
        }
    }

    private com.transsion.json.b.n p(Object obj) {
        return this.f46119f.a(obj);
    }

    public static h q() {
        return (h) f46113n.get();
    }

    public u A() {
        if (this.f46117d.isEmpty()) {
            return null;
        }
        return (u) this.f46117d.peek();
    }

    public void B() {
        this.f46117d.pop();
    }

    public void C() {
        J();
        if (this.f46116c) {
            this.f46115b.a("\n");
            this.f46118e -= 4;
            F();
        }
        this.f46115b.a("]");
        B();
    }

    public void D() {
        J();
        if (this.f46116c) {
            this.f46115b.a("\n");
            this.f46118e -= 4;
            F();
        }
        this.f46115b.a("}");
        B();
    }

    public void E() {
        this.f46126m = true;
    }

    public void F() {
        for (int i11 = 0; i11 < this.f46118e; i11++) {
            this.f46115b.a(" ");
        }
    }

    public u G() {
        u A;
        I();
        if (this.f46116c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        u uVar = new u(com.transsion.json.a.ARRAY);
        i(uVar);
        this.f46115b.a("[");
        if (this.f46116c) {
            this.f46118e += 4;
            this.f46115b.a("\n");
        }
        return uVar;
    }

    public u H() {
        u A;
        I();
        if (this.f46116c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        u uVar = new u(com.transsion.json.a.OBJECT);
        i(uVar);
        this.f46115b.a("{");
        if (this.f46116c) {
            this.f46118e += 4;
            this.f46115b.a("\n");
        }
        return uVar;
    }

    public com.transsion.json.b.n a(d dVar, Object obj) {
        com.transsion.json.b.n K = K();
        if (K != null) {
            return K;
        }
        if (dVar != null) {
            K = dVar.j();
        }
        return K == null ? p(obj) : K;
    }

    protected r b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar.b(this.f46125l)) {
                return rVar;
            }
        }
        return null;
    }

    public void e(com.transsion.json.b.p pVar) {
        this.f46119f = pVar;
    }

    public void f(f fVar) {
        this.f46123j = fVar;
    }

    public void g(p pVar) {
        this.f46115b = pVar;
    }

    public void h(t tVar) {
        this.f46122i = tVar;
    }

    public void i(u uVar) {
        this.f46117d.push(uVar);
    }

    public void j(Object obj) {
        com.transsion.json.b.n K = K();
        if (K == null) {
            K = p(obj);
        }
        K.a(obj);
    }

    public void k(String str) {
        this.f46114a = str;
    }

    public void l(Map map) {
        this.f46120g = map;
    }

    public void m(boolean z10) {
        this.f46116c = z10;
    }

    public boolean n(d dVar) {
        r b11 = b(this.f46121h);
        if (b11 != null) {
            return b11.a();
        }
        Boolean l11 = dVar.l();
        if (l11 != null) {
            return l11.booleanValue();
        }
        if (dVar.o().booleanValue()) {
            return false;
        }
        if (this.f46122i != t.SHALLOW) {
            return true;
        }
        Class h11 = dVar.h();
        return (h11.isArray() || Iterable.class.isAssignableFrom(h11) || Map.class.isAssignableFrom(h11)) ? false : true;
    }

    public boolean o(String str, Object obj) {
        r b11 = b(this.f46121h);
        if (b11 != null) {
            return b11.a();
        }
        String y10 = ((h) f46113n.get()).y();
        if (obj == null) {
            return true;
        }
        t tVar = this.f46122i;
        t tVar2 = t.SHALLOW;
        if ((tVar != tVar2 || y10 == null || this.f46125l.c() <= 1) && !(this.f46122i == tVar2 && y10 == null)) {
            return true;
        }
        Class<?> cls = obj.getClass();
        return (cls.isArray() || Iterable.class.isAssignableFrom(cls)) ? false : true;
    }

    public void r(String str) {
        I();
        u A = A();
        if (A != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.f46115b.a(str);
    }

    public void s(List list) {
        this.f46121h = list;
    }

    public LinkedList t() {
        return this.f46124k;
    }

    public void u(String str) {
        I();
        if (this.f46116c) {
            F();
        }
        if (str != null) {
            w(str);
        } else {
            r("null");
        }
        this.f46115b.a(":");
        if (this.f46116c) {
            this.f46115b.a(" ");
        }
    }

    public p v() {
        return this.f46115b;
    }

    public void w(String str) {
        u A;
        I();
        if (this.f46116c && (A = A()) != null && A.c() == com.transsion.json.a.ARRAY) {
            F();
        }
        this.f46115b.a("\"");
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '\"') {
                i11 = this.f46115b.b(str, i11, i12, "\\u0022");
            } else if (charAt == '&') {
                i11 = this.f46115b.b(str, i11, i12, "\\u0026");
            } else if (charAt == '\'') {
                i11 = this.f46115b.b(str, i11, i12, "\\u0027");
            } else if (charAt == '<') {
                i11 = this.f46115b.b(str, i11, i12, "\\u003c");
            } else if (charAt == '>') {
                i11 = this.f46115b.b(str, i11, i12, "\\u003e");
            } else if (charAt == '\\') {
                i11 = this.f46115b.b(str, i11, i12, "\\\\");
            } else if (charAt == '\b') {
                i11 = this.f46115b.b(str, i11, i12, "\\b");
            } else if (charAt == '\f') {
                i11 = this.f46115b.b(str, i11, i12, "\\f");
            } else if (charAt == '\n') {
                i11 = this.f46115b.b(str, i11, i12, "\\n");
            } else if (charAt == '\r') {
                i11 = this.f46115b.b(str, i11, i12, "\\r");
            } else if (charAt == '\t') {
                i11 = this.f46115b.b(str, i11, i12, "\\t");
            } else if (Character.isISOControl(charAt)) {
                i11 = this.f46115b.a(str, i11, i12) + 1;
                d(charAt);
            }
        }
        if (i11 < str.length()) {
            this.f46115b.a(str, i11, str.length());
        }
        this.f46115b.a("\"");
    }

    public q x() {
        return this.f46125l;
    }

    public String y() {
        return this.f46114a;
    }

    public f z() {
        return this.f46123j;
    }
}
