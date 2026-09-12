package org.jsoup.parser;

import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.l;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;

/* loaded from: classes7.dex */
public class b extends i {

    /* renamed from: k, reason: collision with root package name */
    private HtmlTreeBuilderState f71939k;

    /* renamed from: l, reason: collision with root package name */
    private HtmlTreeBuilderState f71940l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f71941m;

    /* renamed from: n, reason: collision with root package name */
    private Element f71942n;

    /* renamed from: o, reason: collision with root package name */
    private org.jsoup.nodes.h f71943o;

    /* renamed from: p, reason: collision with root package name */
    private Element f71944p;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList f71945q;

    /* renamed from: r, reason: collision with root package name */
    private List f71946r;

    /* renamed from: s, reason: collision with root package name */
    private Token.g f71947s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f71948t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f71949u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f71950v;

    /* renamed from: w, reason: collision with root package name */
    private String[] f71951w = {null};

    /* renamed from: x, reason: collision with root package name */
    static final String[] f71936x = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};

    /* renamed from: y, reason: collision with root package name */
    static final String[] f71937y = {"ol", "ul"};

    /* renamed from: z, reason: collision with root package name */
    static final String[] f71938z = {"button"};
    static final String[] A = {"html", "table"};
    static final String[] B = {"optgroup", "option"};
    static final String[] C = {"dd", "dt", "li", "optgroup", "option", TtmlNode.TAG_P, "rp", "rt"};
    static final String[] D = {PlaceTypes.ADDRESS, "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", TtmlNode.TAG_BODY, TtmlNode.TAG_BR, "button", "caption", TtmlNode.CENTER, "col", "colgroup", "command", "dd", "details", OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_DIR, TtmlNode.TAG_DIV, "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", TtmlNode.TAG_HEAD, "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", TtmlNode.TAG_P, "param", "plaintext", OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE, "script", "section", "select", TtmlNode.TAG_STYLE, "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", CampaignEx.JSON_KEY_TITLE, "tr", "ul", "wbr", "xmp"};

    private boolean I(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.f71951w;
        strArr3[0] = str;
        return J(strArr3, strArr, strArr2);
    }

    private boolean J(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f72003d.size();
        int i11 = size - 1;
        int i12 = i11 > 100 ? size - 101 : 0;
        while (i11 >= i12) {
            String B2 = ((Element) this.f72003d.get(i11)).B();
            if (org.jsoup.helper.c.c(B2, strArr)) {
                return true;
            }
            if (org.jsoup.helper.c.c(B2, strArr2)) {
                return false;
            }
            if (strArr3 != null && org.jsoup.helper.c.c(B2, strArr3)) {
                return false;
            }
            i11--;
        }
        return false;
    }

    private void T(org.jsoup.nodes.j jVar) {
        org.jsoup.nodes.h hVar;
        if (this.f72003d.size() == 0) {
            this.f72002c.g0(jVar);
        } else if (X()) {
            R(jVar);
        } else {
            a().g0(jVar);
        }
        if (jVar instanceof Element) {
            Element element = (Element) jVar;
            if (!element.T0().e() || (hVar = this.f71943o) == null) {
                return;
            }
            hVar.d1(element);
        }
    }

    private boolean W(ArrayList arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((Element) arrayList.get(size)) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean a0(Element element, Element element2) {
        return element.B().equals(element2.B()) && element.i().equals(element2.i());
    }

    private void l(String... strArr) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f72003d.get(size);
            if (org.jsoup.helper.c.b(element.B(), strArr) || element.B().equals("html")) {
                return;
            }
            this.f72003d.remove(size);
        }
    }

    private void v0(ArrayList arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        org.jsoup.helper.d.d(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List A() {
        return this.f71946r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A0(Element element) {
        this.f71942n = element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList B() {
        return this.f72003d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState B0() {
        return this.f71939k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(String str) {
        return F(str, f71938z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C0(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f71939k = htmlTreeBuilderState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(String str) {
        return F(str, f71937y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(String str) {
        return F(str, null);
    }

    boolean F(String str, String[] strArr) {
        return I(str, f71936x, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G(String[] strArr) {
        return J(strArr, f71936x, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H(String str) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            String B2 = ((Element) this.f72003d.get(size)).B();
            if (B2.equals(str)) {
                return true;
            }
            if (!org.jsoup.helper.c.c(B2, B)) {
                return false;
            }
        }
        org.jsoup.helper.d.a("Should not be reachable");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K(String str) {
        return I(str, A, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element L(Token.h hVar) {
        if (!hVar.z()) {
            Element element = new Element(f.l(hVar.A(), this.f72007h), this.f72004e, this.f72007h.a(hVar.f71927j));
            M(element);
            return element;
        }
        Element P = P(hVar);
        this.f72003d.add(P);
        this.f72001b.u(TokeniserState.Data);
        this.f72001b.k(this.f71947s.m().B(P.U0()));
        return P;
    }

    void M(Element element) {
        T(element);
        this.f72003d.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(Token.c cVar) {
        String U0 = a().U0();
        String q11 = cVar.q();
        a().g0(cVar.f() ? new org.jsoup.nodes.d(q11) : (U0.equals("script") || U0.equals(TtmlNode.TAG_STYLE)) ? new org.jsoup.nodes.f(q11) : new l(q11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(Token.d dVar) {
        T(new org.jsoup.nodes.e(dVar.p()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element P(Token.h hVar) {
        f l11 = f.l(hVar.A(), this.f72007h);
        Element element = new Element(l11, this.f72004e, hVar.f71927j);
        T(element);
        if (hVar.z()) {
            if (!l11.f()) {
                l11.j();
            } else if (!l11.d()) {
                this.f72001b.q("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public org.jsoup.nodes.h Q(Token.h hVar, boolean z10) {
        org.jsoup.nodes.h hVar2 = new org.jsoup.nodes.h(f.l(hVar.A(), this.f72007h), this.f72004e, hVar.f71927j);
        y0(hVar2);
        T(hVar2);
        if (z10) {
            this.f72003d.add(hVar2);
        }
        return hVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(org.jsoup.nodes.j jVar) {
        Element element;
        Element y10 = y("table");
        boolean z10 = false;
        if (y10 == null) {
            element = (Element) this.f72003d.get(0);
        } else if (y10.I() != null) {
            element = y10.I();
            z10 = true;
        } else {
            element = j(y10);
        }
        if (!z10) {
            element.g0(jVar);
        } else {
            org.jsoup.helper.d.j(y10);
            y10.l0(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.f71945q.add(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(Element element, Element element2) {
        int lastIndexOf = this.f72003d.lastIndexOf(element);
        org.jsoup.helper.d.d(lastIndexOf != -1);
        this.f72003d.add(lastIndexOf + 1, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element V(String str) {
        Element element = new Element(f.l(str, this.f72007h), this.f72004e);
        M(element);
        return element;
    }

    boolean X() {
        return this.f71949u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Y() {
        return this.f71950v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(Element element) {
        return W(this.f71945q, element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.parser.i
    public d b() {
        return d.f71954c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b0(Element element) {
        return org.jsoup.helper.c.c(element.B(), D);
    }

    @Override // org.jsoup.parser.i
    protected void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        super.c(reader, str, parseErrorList, dVar);
        this.f71939k = HtmlTreeBuilderState.Initial;
        this.f71940l = null;
        this.f71941m = false;
        this.f71942n = null;
        this.f71943o = null;
        this.f71944p = null;
        this.f71945q = new ArrayList();
        this.f71946r = new ArrayList();
        this.f71947s = new Token.g();
        this.f71948t = true;
        this.f71949u = false;
        this.f71950v = false;
    }

    Element c0() {
        if (this.f71945q.size() <= 0) {
            return null;
        }
        return (Element) this.f71945q.get(r0.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0() {
        this.f71940l = this.f71939k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.parser.i
    public boolean e(Token token) {
        this.f72005f = token;
        return this.f71939k.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(Element element) {
        if (this.f71941m) {
            return;
        }
        String a11 = element.a("href");
        if (a11.length() != 0) {
            this.f72004e = a11;
            this.f71941m = true;
            this.f72002c.S(a11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        this.f71946r = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g0(Element element) {
        return W(this.f72003d, element);
    }

    @Override // org.jsoup.parser.i
    public /* bridge */ /* synthetic */ boolean h(String str, org.jsoup.nodes.b bVar) {
        return super.h(str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState h0() {
        return this.f71940l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List i0(String str, Element element, String str2, ParseErrorList parseErrorList, d dVar) {
        Element element2;
        this.f71939k = HtmlTreeBuilderState.Initial;
        c(new StringReader(str), str2, parseErrorList, dVar);
        this.f71944p = element;
        this.f71950v = true;
        if (element != null) {
            if (element.H() != null) {
                this.f72002c.i1(element.H().h1());
            }
            String U0 = element.U0();
            if (org.jsoup.helper.c.b(U0, CampaignEx.JSON_KEY_TITLE, "textarea")) {
                this.f72001b.u(TokeniserState.Rcdata);
            } else if (org.jsoup.helper.c.b(U0, "iframe", "noembed", "noframes", TtmlNode.TAG_STYLE, "xmp")) {
                this.f72001b.u(TokeniserState.Rawtext);
            } else if (U0.equals("script")) {
                this.f72001b.u(TokeniserState.ScriptData);
            } else if (U0.equals("noscript")) {
                this.f72001b.u(TokeniserState.Data);
            } else if (U0.equals("plaintext")) {
                this.f72001b.u(TokeniserState.Data);
            } else {
                this.f72001b.u(TokeniserState.Data);
            }
            element2 = new Element(f.l("html", dVar), str2);
            this.f72002c.g0(element2);
            this.f72003d.add(element2);
            x0();
            Elements M0 = element.M0();
            M0.add(0, element);
            Iterator<Element> it = M0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element next = it.next();
                if (next instanceof org.jsoup.nodes.h) {
                    this.f71943o = (org.jsoup.nodes.h) next;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        i();
        return element != null ? element2.o() : this.f72002c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element j(Element element) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            if (((Element) this.f72003d.get(size)) == element) {
                return (Element) this.f72003d.get(size - 1);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element j0() {
        return (Element) this.f72003d.remove(this.f72003d.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        while (!this.f71945q.isEmpty() && t0() != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0(String str) {
        for (int size = this.f72003d.size() - 1; size >= 0 && !((Element) this.f72003d.get(size)).B().equals(str); size--) {
            this.f72003d.remove(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l0(String str) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f72003d.get(size);
            this.f72003d.remove(size);
            if (element.B().equals(str)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        l("tbody", "tfoot", "thead", "template");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(String... strArr) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f72003d.get(size);
            this.f72003d.remove(size);
            if (org.jsoup.helper.c.c(element.B(), strArr)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        l("table");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n0(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f72005f = token;
        return htmlTreeBuilderState.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        l("tr", "template");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(Element element) {
        this.f72003d.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f72006g.canAddError()) {
            this.f72006g.add(new c(this.f72000a.F(), "Unexpected token [%s] when in state [%s]", this.f72005f.o(), htmlTreeBuilderState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(Element element) {
        int size = this.f71945q.size() - 1;
        int i11 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = (Element) this.f71945q.get(size);
                if (element2 == null) {
                    break;
                }
                if (a0(element, element2)) {
                    i11++;
                }
                if (i11 == 3) {
                    this.f71945q.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.f71945q.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z10) {
        this.f71948t = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        Element c02 = c0();
        if (c02 == null || g0(c02)) {
            return;
        }
        boolean z10 = true;
        int size = this.f71945q.size() - 1;
        int i11 = size;
        while (i11 != 0) {
            i11--;
            c02 = (Element) this.f71945q.get(i11);
            if (c02 == null || g0(c02)) {
                z10 = false;
                break;
            }
        }
        while (true) {
            if (!z10) {
                i11++;
                c02 = (Element) this.f71945q.get(i11);
            }
            org.jsoup.helper.d.j(c02);
            Element V = V(c02.B());
            V.i().e(c02.i());
            this.f71945q.set(i11, V);
            if (i11 == size) {
                return;
            } else {
                z10 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f71948t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r0(Element element) {
        for (int size = this.f71945q.size() - 1; size >= 0; size--) {
            if (((Element) this.f71945q.get(size)) == element) {
                this.f71945q.remove(size);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        t(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s0(Element element) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            if (((Element) this.f72003d.get(size)) == element) {
                this.f72003d.remove(size);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str) {
        while (str != null && !a().B().equals(str) && org.jsoup.helper.c.c(a().B(), C)) {
            j0();
        }
    }

    Element t0() {
        int size = this.f71945q.size();
        if (size > 0) {
            return (Element) this.f71945q.remove(size - 1);
        }
        return null;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f72005f + ", state=" + this.f71939k + ", currentElement=" + a() + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element u(String str) {
        for (int size = this.f71945q.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f71945q.get(size);
            if (element == null) {
                return null;
            }
            if (element.B().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0(Element element, Element element2) {
        v0(this.f71945q, element, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        return this.f72004e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document w() {
        return this.f72002c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w0(Element element, Element element2) {
        v0(this.f72003d, element, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public org.jsoup.nodes.h x() {
        return this.f71943o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0() {
        boolean z10 = false;
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f72003d.get(size);
            if (size == 0) {
                element = this.f71944p;
                z10 = true;
            }
            String B2 = element.B();
            if ("select".equals(B2)) {
                C0(HtmlTreeBuilderState.InSelect);
                return;
            }
            if ("td".equals(B2) || ("th".equals(B2) && !z10)) {
                C0(HtmlTreeBuilderState.InCell);
                return;
            }
            if ("tr".equals(B2)) {
                C0(HtmlTreeBuilderState.InRow);
                return;
            }
            if ("tbody".equals(B2) || "thead".equals(B2) || "tfoot".equals(B2)) {
                C0(HtmlTreeBuilderState.InTableBody);
                return;
            }
            if ("caption".equals(B2)) {
                C0(HtmlTreeBuilderState.InCaption);
                return;
            }
            if ("colgroup".equals(B2)) {
                C0(HtmlTreeBuilderState.InColumnGroup);
                return;
            }
            if ("table".equals(B2)) {
                C0(HtmlTreeBuilderState.InTable);
                return;
            }
            if (TtmlNode.TAG_HEAD.equals(B2)) {
                C0(HtmlTreeBuilderState.InBody);
                return;
            }
            if (TtmlNode.TAG_BODY.equals(B2)) {
                C0(HtmlTreeBuilderState.InBody);
                return;
            }
            if ("frameset".equals(B2)) {
                C0(HtmlTreeBuilderState.InFrameset);
                return;
            } else if ("html".equals(B2)) {
                C0(HtmlTreeBuilderState.BeforeHead);
                return;
            } else {
                if (z10) {
                    C0(HtmlTreeBuilderState.InBody);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element y(String str) {
        for (int size = this.f72003d.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f72003d.get(size);
            if (element.B().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y0(org.jsoup.nodes.h hVar) {
        this.f71943o = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element z() {
        return this.f71942n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z0(boolean z10) {
        this.f71949u = z10;
    }
}
