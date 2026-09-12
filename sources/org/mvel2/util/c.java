package org.mvel2.util;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static final Object[] f72159h = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    private char[] f72160a;

    /* renamed from: b, reason: collision with root package name */
    private int f72161b;

    /* renamed from: c, reason: collision with root package name */
    private int f72162c;

    /* renamed from: d, reason: collision with root package name */
    private int f72163d;

    /* renamed from: e, reason: collision with root package name */
    private int f72164e;

    /* renamed from: f, reason: collision with root package name */
    private Class f72165f;

    /* renamed from: g, reason: collision with root package name */
    private ParserContext f72166g;

    public c() {
    }

    public c(int i11) {
        this.f72164e = i11;
    }

    private boolean b() {
        ParserContext parserContext = this.f72166g;
        return parserContext != null && parserContext.isStrongTyping();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0156 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object c(boolean r22) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.c.c(boolean):java.lang.Object");
    }

    private void f(int i11, int i12) {
        if (this.f72165f == null) {
            m.I0(this.f72160a, i11, i12, this.f72166g);
            return;
        }
        Class knownEgressType = ((ExecutableStatement) m.I0(this.f72160a, i11, i12, this.f72166g)).getKnownEgressType();
        if (knownEgressType == null || p.f(this.f72165f, knownEgressType)) {
            return;
        }
        if (b() || !org.mvel2.b.a(knownEgressType, this.f72165f)) {
            throw new CompileException("expected type: " + this.f72165f.getName() + "; but found: " + knownEgressType.getName(), this.f72160a, this.f72161b);
        }
    }

    public int a() {
        return this.f72161b;
    }

    public Object d(char[] cArr, int i11, int i12, boolean z10, Class cls, ParserContext parserContext) {
        if (cls != null) {
            this.f72165f = m.I(cls);
        }
        this.f72160a = cArr;
        this.f72163d = i12 + i11;
        while (i11 < this.f72163d && m.q0(cArr[i11])) {
            i11++;
        }
        this.f72161b = i11;
        this.f72162c = i11;
        this.f72166g = parserContext;
        return c(z10);
    }

    public Object e(char[] cArr, int i11, int i12, boolean z10, ParserContext parserContext) {
        this.f72160a = cArr;
        this.f72166g = parserContext;
        this.f72163d = i12 + i11;
        while (i11 < this.f72163d && m.q0(cArr[i11])) {
            i11++;
        }
        this.f72161b = i11;
        this.f72162c = i11;
        return c(z10);
    }
}
