package org.jsoup.parser;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.transsion.gslb.Utils;
import java.util.Arrays;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: r, reason: collision with root package name */
    private static final char[] f71981r;

    /* renamed from: s, reason: collision with root package name */
    static final int[] f71982s = {8364, 129, 8218, TTAdConstant.AD_ID_IS_NULL_CODE, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* renamed from: a, reason: collision with root package name */
    private final a f71983a;

    /* renamed from: b, reason: collision with root package name */
    private final ParseErrorList f71984b;

    /* renamed from: d, reason: collision with root package name */
    private Token f71986d;

    /* renamed from: i, reason: collision with root package name */
    Token.i f71991i;

    /* renamed from: o, reason: collision with root package name */
    private String f71997o;

    /* renamed from: c, reason: collision with root package name */
    private TokeniserState f71985c = TokeniserState.Data;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71987e = false;

    /* renamed from: f, reason: collision with root package name */
    private String f71988f = null;

    /* renamed from: g, reason: collision with root package name */
    private StringBuilder f71989g = new StringBuilder(1024);

    /* renamed from: h, reason: collision with root package name */
    StringBuilder f71990h = new StringBuilder(1024);

    /* renamed from: j, reason: collision with root package name */
    Token.h f71992j = new Token.h();

    /* renamed from: k, reason: collision with root package name */
    Token.g f71993k = new Token.g();

    /* renamed from: l, reason: collision with root package name */
    Token.c f71994l = new Token.c();

    /* renamed from: m, reason: collision with root package name */
    Token.e f71995m = new Token.e();

    /* renamed from: n, reason: collision with root package name */
    Token.d f71996n = new Token.d();

    /* renamed from: p, reason: collision with root package name */
    private final int[] f71998p = new int[1];

    /* renamed from: q, reason: collision with root package name */
    private final int[] f71999q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        f71981r = cArr;
        Arrays.sort(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, ParseErrorList parseErrorList) {
        this.f71983a = aVar;
        this.f71984b = parseErrorList;
    }

    private void c(String str) {
        if (this.f71984b.canAddError()) {
            this.f71984b.add(new c(this.f71983a.F(), "Invalid character reference: %s", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TokeniserState tokeniserState) {
        this.f71983a.a();
        this.f71985c = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f71997o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d(Character ch2, boolean z10) {
        int i11;
        if (this.f71983a.r()) {
            return null;
        }
        if ((ch2 != null && ch2.charValue() == this.f71983a.q()) || this.f71983a.z(f71981r)) {
            return null;
        }
        int[] iArr = this.f71998p;
        this.f71983a.t();
        if (this.f71983a.u(Utils.SEPARATOR)) {
            boolean v11 = this.f71983a.v("X");
            a aVar = this.f71983a;
            String g11 = v11 ? aVar.g() : aVar.f();
            if (g11.length() == 0) {
                c("numeric reference with no numerals");
                this.f71983a.H();
                return null;
            }
            if (!this.f71983a.u(";")) {
                c("missing semicolon");
            }
            try {
                i11 = Integer.valueOf(g11, v11 ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                i11 = -1;
            }
            if (i11 == -1 || ((i11 >= 55296 && i11 <= 57343) || i11 > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (i11 >= 128) {
                int[] iArr2 = f71982s;
                if (i11 < iArr2.length + 128) {
                    c("character is not a valid unicode code point");
                    i11 = iArr2[i11 - 128];
                }
            }
            iArr[0] = i11;
            return iArr;
        }
        String i12 = this.f71983a.i();
        boolean w11 = this.f71983a.w(';');
        if (!Entities.f(i12) && (!Entities.g(i12) || !w11)) {
            this.f71983a.H();
            if (w11) {
                c(String.format("invalid named referenece '%s'", i12));
            }
            return null;
        }
        if (z10 && (this.f71983a.C() || this.f71983a.A() || this.f71983a.y('=', '-', '_'))) {
            this.f71983a.H();
            return null;
        }
        if (!this.f71983a.u(";")) {
            c("missing semicolon");
        }
        int d11 = Entities.d(i12, this.f71999q);
        if (d11 == 1) {
            iArr[0] = this.f71999q[0];
            return iArr;
        }
        if (d11 == 2) {
            return this.f71999q;
        }
        org.jsoup.helper.d.a("Unexpected characters returned for " + i12);
        return this.f71999q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f71996n.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f71995m.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token.i g(boolean z10) {
        Token.i m11 = z10 ? this.f71992j.m() : this.f71993k.m();
        this.f71991i = m11;
        return m11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Token.n(this.f71990h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(char c11) {
        j(String.valueOf(c11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(String str) {
        if (this.f71988f == null) {
            this.f71988f = str;
            return;
        }
        if (this.f71989g.length() == 0) {
            this.f71989g.append(this.f71988f);
        }
        this.f71989g.append(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Token token) {
        org.jsoup.helper.d.c(this.f71987e, "There is an unread token pending!");
        this.f71986d = token;
        this.f71987e = true;
        Token.TokenType tokenType = token.f71910a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f71997o = ((Token.h) token).f71919b;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.g) token).f71927j == null) {
                return;
            }
            q("Attributes incorrectly present on end tag");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int[] iArr) {
        j(new String(iArr, 0, iArr.length));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        k(this.f71996n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        k(this.f71995m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f71991i.x();
        k(this.f71991i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(TokeniserState tokeniserState) {
        if (this.f71984b.canAddError()) {
            this.f71984b.add(new c(this.f71983a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        if (this.f71984b.canAddError()) {
            this.f71984b.add(new c(this.f71983a.F(), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TokeniserState tokeniserState) {
        if (this.f71984b.canAddError()) {
            this.f71984b.add(new c(this.f71983a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f71983a.q()), tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f71997o != null && this.f71991i.A().equalsIgnoreCase(this.f71997o);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token t() {
        while (!this.f71987e) {
            this.f71985c.read(this, this.f71983a);
        }
        if (this.f71989g.length() > 0) {
            String sb2 = this.f71989g.toString();
            StringBuilder sb3 = this.f71989g;
            sb3.delete(0, sb3.length());
            this.f71988f = null;
            return this.f71994l.p(sb2);
        }
        String str = this.f71988f;
        if (str == null) {
            this.f71987e = false;
            return this.f71986d;
        }
        Token.c p11 = this.f71994l.p(str);
        this.f71988f = null;
        return p11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(TokeniserState tokeniserState) {
        this.f71985c = tokeniserState;
    }
}
