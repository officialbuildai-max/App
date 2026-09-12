package org.jsoup.select;

import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.gslb.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.parser.g;
import org.jsoup.select.Selector;
import org.jsoup.select.b;
import org.jsoup.select.c;
import org.jsoup.select.f;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f72034d = {",", ">", "+", "~", " "};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f72035e = {UrlUtils.EQUAL_MARK, "!=", "^=", "$=", "*=", "~="};

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f72036f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f72037g = Pattern.compile("([+-])?(\\d+)");

    /* renamed from: a, reason: collision with root package name */
    private g f72038a;

    /* renamed from: b, reason: collision with root package name */
    private String f72039b;

    /* renamed from: c, reason: collision with root package name */
    private List f72040c = new ArrayList();

    private e(String str) {
        this.f72039b = str;
        this.f72038a = new g(str);
    }

    private void a() {
        this.f72040c.add(new c.a());
    }

    private void b() {
        g gVar = new g(this.f72038a.a('[', ']'));
        String h11 = gVar.h(f72035e);
        org.jsoup.helper.d.h(h11);
        gVar.i();
        if (gVar.j()) {
            if (h11.startsWith("^")) {
                this.f72040c.add(new c.d(h11.substring(1)));
                return;
            } else {
                this.f72040c.add(new c.b(h11));
                return;
            }
        }
        if (gVar.k(UrlUtils.EQUAL_MARK)) {
            this.f72040c.add(new c.e(h11, gVar.q()));
            return;
        }
        if (gVar.k("!=")) {
            this.f72040c.add(new c.i(h11, gVar.q()));
            return;
        }
        if (gVar.k("^=")) {
            this.f72040c.add(new c.j(h11, gVar.q()));
            return;
        }
        if (gVar.k("$=")) {
            this.f72040c.add(new c.g(h11, gVar.q()));
        } else if (gVar.k("*=")) {
            this.f72040c.add(new c.f(h11, gVar.q()));
        } else {
            if (!gVar.k("~=")) {
                throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f72039b, gVar.q());
            }
            this.f72040c.add(new c.h(h11, Pattern.compile(gVar.q())));
        }
    }

    private void c() {
        String e11 = this.f72038a.e();
        org.jsoup.helper.d.h(e11);
        this.f72040c.add(new c.k(e11.trim()));
    }

    private void d() {
        String e11 = this.f72038a.e();
        org.jsoup.helper.d.h(e11);
        this.f72040c.add(new c.p(e11));
    }

    private void e() {
        String f11 = this.f72038a.f();
        org.jsoup.helper.d.h(f11);
        if (f11.startsWith("*|")) {
            this.f72040c.add(new b.C0899b(new c.j0(e10.b.b(f11)), new c.k0(e10.b.b(f11.replace("*|", ":")))));
            return;
        }
        if (f11.contains("|")) {
            f11 = f11.replace("|", ":");
        }
        this.f72040c.add(new c.j0(f11.trim()));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(char r11) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.e.f(char):void");
    }

    private int g() {
        String trim = this.f72038a.b(")").trim();
        org.jsoup.helper.d.e(org.jsoup.helper.c.g(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private String h() {
        StringBuilder sb2 = new StringBuilder();
        while (!this.f72038a.j()) {
            if (this.f72038a.l("(")) {
                sb2.append("(");
                sb2.append(this.f72038a.a('(', ')'));
                sb2.append(")");
            } else if (this.f72038a.l("[")) {
                sb2.append("[");
                sb2.append(this.f72038a.a('[', ']'));
                sb2.append("]");
            } else {
                if (this.f72038a.n(f72034d)) {
                    break;
                }
                sb2.append(this.f72038a.c());
            }
        }
        return sb2.toString();
    }

    private void i(boolean z10) {
        this.f72038a.d(z10 ? ":containsOwn" : ":contains");
        String s11 = g.s(this.f72038a.a('(', ')'));
        org.jsoup.helper.d.i(s11, ":contains(text) query must not be empty");
        if (z10) {
            this.f72040c.add(new c.m(s11));
        } else {
            this.f72040c.add(new c.n(s11));
        }
    }

    private void j() {
        this.f72038a.d(":containsData");
        String s11 = g.s(this.f72038a.a('(', ')'));
        org.jsoup.helper.d.i(s11, ":containsData(text) query must not be empty");
        this.f72040c.add(new c.l(s11));
    }

    private void k(boolean z10, boolean z11) {
        int parseInt;
        String b11 = e10.b.b(this.f72038a.b(")"));
        Matcher matcher = f72036f.matcher(b11);
        Matcher matcher2 = f72037g.matcher(b11);
        if ("odd".equals(b11)) {
            r0 = 2;
            parseInt = 1;
        } else if ("even".equals(b11)) {
            parseInt = 0;
            r0 = 2;
        } else if (matcher.matches()) {
            int parseInt2 = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
            parseInt = matcher.group(4) != null ? Integer.parseInt(matcher.group(4).replaceFirst("^\\+", "")) : 0;
            r0 = parseInt2;
        } else {
            if (!matcher2.matches()) {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", b11);
            }
            parseInt = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
        }
        if (z11) {
            if (z10) {
                this.f72040c.add(new c.b0(r0, parseInt));
                return;
            } else {
                this.f72040c.add(new c.c0(r0, parseInt));
                return;
            }
        }
        if (z10) {
            this.f72040c.add(new c.a0(r0, parseInt));
        } else {
            this.f72040c.add(new c.z(r0, parseInt));
        }
    }

    private void l() {
        if (this.f72038a.k(Utils.SEPARATOR)) {
            d();
            return;
        }
        if (this.f72038a.k(".")) {
            c();
            return;
        }
        if (this.f72038a.p() || this.f72038a.l("*|")) {
            e();
            return;
        }
        if (this.f72038a.l("[")) {
            b();
            return;
        }
        if (this.f72038a.k("*")) {
            a();
            return;
        }
        if (this.f72038a.k(":lt(")) {
            p();
            return;
        }
        if (this.f72038a.k(":gt(")) {
            o();
            return;
        }
        if (this.f72038a.k(":eq(")) {
            n();
            return;
        }
        if (this.f72038a.l(":has(")) {
            m();
            return;
        }
        if (this.f72038a.l(":contains(")) {
            i(false);
            return;
        }
        if (this.f72038a.l(":containsOwn(")) {
            i(true);
            return;
        }
        if (this.f72038a.l(":containsData(")) {
            j();
            return;
        }
        if (this.f72038a.l(":matches(")) {
            q(false);
            return;
        }
        if (this.f72038a.l(":matchesOwn(")) {
            q(true);
            return;
        }
        if (this.f72038a.l(":not(")) {
            r();
            return;
        }
        if (this.f72038a.k(":nth-child(")) {
            k(false, false);
            return;
        }
        if (this.f72038a.k(":nth-last-child(")) {
            k(true, false);
            return;
        }
        if (this.f72038a.k(":nth-of-type(")) {
            k(false, true);
            return;
        }
        if (this.f72038a.k(":nth-last-of-type(")) {
            k(true, true);
            return;
        }
        if (this.f72038a.k(":first-child")) {
            this.f72040c.add(new c.v());
            return;
        }
        if (this.f72038a.k(":last-child")) {
            this.f72040c.add(new c.x());
            return;
        }
        if (this.f72038a.k(":first-of-type")) {
            this.f72040c.add(new c.w());
            return;
        }
        if (this.f72038a.k(":last-of-type")) {
            this.f72040c.add(new c.y());
            return;
        }
        if (this.f72038a.k(":only-child")) {
            this.f72040c.add(new c.d0());
            return;
        }
        if (this.f72038a.k(":only-of-type")) {
            this.f72040c.add(new c.e0());
            return;
        }
        if (this.f72038a.k(":empty")) {
            this.f72040c.add(new c.u());
        } else if (this.f72038a.k(":root")) {
            this.f72040c.add(new c.f0());
        } else {
            if (!this.f72038a.k(":matchText")) {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f72039b, this.f72038a.q());
            }
            this.f72040c.add(new c.g0());
        }
    }

    private void m() {
        this.f72038a.d(":has");
        String a11 = this.f72038a.a('(', ')');
        org.jsoup.helper.d.i(a11, ":has(el) subselect must not be empty");
        this.f72040c.add(new f.a(t(a11)));
    }

    private void n() {
        this.f72040c.add(new c.q(g()));
    }

    private void o() {
        this.f72040c.add(new c.s(g()));
    }

    private void p() {
        this.f72040c.add(new c.t(g()));
    }

    private void q(boolean z10) {
        this.f72038a.d(z10 ? ":matchesOwn" : ":matches");
        String a11 = this.f72038a.a('(', ')');
        org.jsoup.helper.d.i(a11, ":matches(regex) query must not be empty");
        if (z10) {
            this.f72040c.add(new c.i0(Pattern.compile(a11)));
        } else {
            this.f72040c.add(new c.h0(Pattern.compile(a11)));
        }
    }

    private void r() {
        this.f72038a.d(":not");
        String a11 = this.f72038a.a('(', ')');
        org.jsoup.helper.d.i(a11, ":not(selector) subselect must not be empty");
        this.f72040c.add(new f.d(t(a11)));
    }

    public static c t(String str) {
        try {
            return new e(str).s();
        } catch (IllegalArgumentException e11) {
            throw new Selector.SelectorParseException(e11.getMessage(), new Object[0]);
        }
    }

    c s() {
        this.f72038a.i();
        if (this.f72038a.n(f72034d)) {
            this.f72040c.add(new f.g());
            f(this.f72038a.c());
        } else {
            l();
        }
        while (!this.f72038a.j()) {
            boolean i11 = this.f72038a.i();
            if (this.f72038a.n(f72034d)) {
                f(this.f72038a.c());
            } else if (i11) {
                f(' ');
            } else {
                l();
            }
        }
        return this.f72040c.size() == 1 ? (c) this.f72040c.get(0) : new b.a(this.f72040c);
    }
}
