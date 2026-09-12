package org.mvel2.util;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Function;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private String f72171a;

    /* renamed from: b, reason: collision with root package name */
    private int f72172b;

    /* renamed from: c, reason: collision with root package name */
    private int f72173c;

    /* renamed from: d, reason: collision with root package name */
    private int f72174d;

    /* renamed from: e, reason: collision with root package name */
    private char[] f72175e;

    /* renamed from: f, reason: collision with root package name */
    private ParserContext f72176f;

    /* renamed from: g, reason: collision with root package name */
    private g f72177g;

    public h(String str, int i11, int i12, char[] cArr, int i13, ParserContext parserContext, g gVar) {
        this.f72171a = str;
        this.f72172b = i11;
        this.f72173c = i12;
        this.f72175e = cArr;
        this.f72174d = i13;
        this.f72176f = parserContext;
        this.f72177g = gVar;
    }

    public int a() {
        return this.f72172b;
    }

    public String b() {
        return this.f72171a;
    }

    public Function c() {
        int i11;
        int i12;
        int i13;
        int i14 = this.f72172b;
        int i15 = this.f72173c + i14;
        int j11 = m.j(this.f72175e, i14, i15, this.f72176f);
        this.f72172b = j11;
        char[] cArr = this.f72175e;
        int s02 = m.s0(cArr, j11);
        this.f72172b = s02;
        if (cArr[s02] == '(') {
            i13 = m.e(this.f72175e, s02, i15, '(', this.f72176f);
            int i16 = s02 + 1;
            int i17 = i13 + 1;
            this.f72172b = i17;
            int E0 = m.E0(this.f72175e, i17);
            this.f72172b = E0;
            if (E0 >= i15) {
                throw new CompileException("incomplete statement", this.f72175e, this.f72172b);
            }
            char[] cArr2 = this.f72175e;
            if (cArr2[E0] == '{') {
                i12 = m.e(cArr2, E0, i15, '{', this.f72176f);
                this.f72172b = i12;
                i11 = i16;
                s02 = E0;
            } else {
                i12 = m.i(cArr2, E0, i15, this.f72176f);
                this.f72172b = i12;
                i11 = i16;
                s02 = E0 - 1;
            }
        } else {
            char[] cArr3 = this.f72175e;
            i11 = 0;
            if (cArr3[s02] == '{') {
                i12 = m.e(cArr3, s02, i15, '{', this.f72176f);
                this.f72172b = i12;
            } else {
                i12 = m.i(cArr3, s02, i15, this.f72176f);
                this.f72172b = i12;
                s02--;
            }
            i13 = 0;
        }
        int N0 = m.N0(this.f72175e, s02 + 1);
        int M0 = m.M0(this.f72175e, i14, i12);
        int i18 = this.f72172b + 1;
        this.f72172b = i18;
        if (this.f72177g != null && m.p0(this.f72175e, i18)) {
            this.f72177g.a(new EndOfStatement(this.f72176f));
        }
        return new Function(this.f72171a, this.f72175e, i11, i13 - i11, N0, M0 - N0, this.f72174d, this.f72176f);
    }
}
