package com.transsion.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class j {

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f46129f = "0123456789ABCDEF".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    private boolean f46133d;

    /* renamed from: e, reason: collision with root package name */
    private String f46134e;

    /* renamed from: b, reason: collision with root package name */
    private final Map f46131b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List f46132c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.json.b.p f46130a = new com.transsion.json.b.p(w.a());

    public j a(boolean z10) {
        this.f46133d = z10;
        return this;
    }

    public j b(String... strArr) {
        for (String str : strArr) {
            e(str);
        }
        return this;
    }

    public String c(Object obj) {
        return d(obj, t.SHALLOW, new s(new StringBuilder()));
    }

    protected String d(Object obj, t tVar, p pVar) {
        h q11 = h.q();
        q11.k(this.f46134e);
        q11.m(this.f46133d);
        q11.g(pVar);
        q11.h(tVar);
        q11.e(this.f46130a);
        q11.l(this.f46131b);
        q11.s(this.f46132c);
        try {
            String y10 = q11.y();
            if (y10 != null && !y10.trim().equals("")) {
                q11.H();
                q11.u(y10);
                q11.j(obj);
                q11.D();
                String obj2 = q11.v().toString();
                h.c();
                return obj2;
            }
            q11.j(obj);
            String obj22 = q11.v().toString();
            h.c();
            return obj22;
        } catch (Throwable th2) {
            h.c();
            throw th2;
        }
    }

    protected void e(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            r rVar = new r(str.substring(0, lastIndexOf), true);
            if (!rVar.c()) {
                this.f46132c.add(rVar);
            }
        }
        this.f46132c.add(new r(str, false));
    }
}
