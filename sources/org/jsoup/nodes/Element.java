package org.jsoup.nodes;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.jsoup.select.c;

/* loaded from: classes7.dex */
public class Element extends j {

    /* renamed from: h, reason: collision with root package name */
    private static final List f71859h = Collections.emptyList();

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f71860i = Pattern.compile("\\s+");

    /* renamed from: c, reason: collision with root package name */
    private org.jsoup.parser.f f71861c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference f71862d;

    /* renamed from: e, reason: collision with root package name */
    List f71863e;

    /* renamed from: f, reason: collision with root package name */
    private b f71864f;

    /* renamed from: g, reason: collision with root package name */
    private String f71865g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class NodeList extends ChangeNotifyingArrayList<j> {
        private final Element owner;

        NodeList(Element element, int i11) {
            super(i11);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements f10.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StringBuilder f71866a;

        a(StringBuilder sb2) {
            this.f71866a = sb2;
        }

        @Override // f10.a
        public void a(j jVar, int i11) {
            if ((jVar instanceof Element) && ((Element) jVar).H0() && (jVar.A() instanceof l) && !l.e0(this.f71866a)) {
                this.f71866a.append(' ');
            }
        }

        @Override // f10.a
        public void b(j jVar, int i11) {
            if (jVar instanceof l) {
                Element.h0(this.f71866a, (l) jVar);
            } else if (jVar instanceof Element) {
                Element element = (Element) jVar;
                if (this.f71866a.length() > 0) {
                    if ((element.H0() || element.f71861c.b().equals(TtmlNode.TAG_BR)) && !l.e0(this.f71866a)) {
                        this.f71866a.append(' ');
                    }
                }
            }
        }
    }

    public Element(org.jsoup.parser.f fVar, String str) {
        this(fVar, str, null);
    }

    public Element(org.jsoup.parser.f fVar, String str, b bVar) {
        org.jsoup.helper.d.j(fVar);
        org.jsoup.helper.d.j(str);
        this.f71863e = f71859h;
        this.f71865g = str;
        this.f71864f = bVar;
        this.f71861c = fVar;
    }

    private void D0(StringBuilder sb2) {
        Iterator it = this.f71863e.iterator();
        while (it.hasNext()) {
            ((j) it.next()).E(sb2);
        }
    }

    private static int F0(Element element, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11) == element) {
                return i11;
            }
        }
        return 0;
    }

    private void K0(StringBuilder sb2) {
        for (j jVar : this.f71863e) {
            if (jVar instanceof l) {
                h0(sb2, (l) jVar);
            } else if (jVar instanceof Element) {
                i0((Element) jVar, sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean O0(j jVar) {
        if (jVar != null && (jVar instanceof Element)) {
            Element element = (Element) jVar;
            int i11 = 0;
            while (!element.f71861c.h()) {
                element = element.I();
                i11++;
                if (i11 < 6 && element != null) {
                }
            }
            return true;
        }
        return false;
    }

    private static void c0(Element element, Elements elements) {
        Element I = element.I();
        if (I == null || I.U0().equals("#root")) {
            return;
        }
        elements.add(I);
        c0(I, elements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h0(StringBuilder sb2, l lVar) {
        String c02 = lVar.c0();
        if (O0(lVar.f71885a) || (lVar instanceof d)) {
            sb2.append(c02);
        } else {
            org.jsoup.helper.c.a(sb2, c02, l.e0(sb2));
        }
    }

    private static void i0(Element element, StringBuilder sb2) {
        if (!element.f71861c.b().equals(TtmlNode.TAG_BR) || l.e0(sb2)) {
            return;
        }
        sb2.append(" ");
    }

    private List n0() {
        List list;
        WeakReference weakReference = this.f71862d;
        if (weakReference != null && (list = (List) weakReference.get()) != null) {
            return list;
        }
        int size = this.f71863e.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            j jVar = (j) this.f71863e.get(i11);
            if (jVar instanceof Element) {
                arrayList.add((Element) jVar);
            }
        }
        this.f71862d = new WeakReference(arrayList);
        return arrayList;
    }

    public boolean A0() {
        for (j jVar : this.f71863e) {
            if (jVar instanceof l) {
                if (!((l) jVar).d0()) {
                    return true;
                }
            } else if ((jVar instanceof Element) && ((Element) jVar).A0()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jsoup.nodes.j
    public String B() {
        return this.f71861c.b();
    }

    public String B0() {
        StringBuilder o11 = org.jsoup.helper.c.o();
        D0(o11);
        boolean l11 = v().l();
        String sb2 = o11.toString();
        return l11 ? sb2.trim() : sb2;
    }

    @Override // org.jsoup.nodes.j
    void C() {
        super.C();
        this.f71862d = null;
    }

    public Element C0(String str) {
        w0();
        f0(str);
        return this;
    }

    public String E0() {
        return i().o("id");
    }

    @Override // org.jsoup.nodes.j
    void F(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
        if (outputSettings.l() && (this.f71861c.a() || ((I() != null && I().T0().a()) || outputSettings.j()))) {
            if (!(appendable instanceof StringBuilder)) {
                z(appendable, i11, outputSettings);
            } else if (((StringBuilder) appendable).length() > 0) {
                z(appendable, i11, outputSettings);
            }
        }
        appendable.append('<').append(U0());
        b bVar = this.f71864f;
        if (bVar != null) {
            bVar.s(appendable, outputSettings);
        }
        if (!this.f71863e.isEmpty() || !this.f71861c.g()) {
            appendable.append('>');
        } else if (outputSettings.m() == Document.OutputSettings.Syntax.html && this.f71861c.d()) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    @Override // org.jsoup.nodes.j
    void G(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
        if (this.f71863e.isEmpty() && this.f71861c.g()) {
            return;
        }
        if (outputSettings.l() && !this.f71863e.isEmpty() && (this.f71861c.a() || (outputSettings.j() && (this.f71863e.size() > 1 || (this.f71863e.size() == 1 && !(this.f71863e.get(0) instanceof l)))))) {
            z(appendable, i11, outputSettings);
        }
        appendable.append("</").append(U0()).append('>');
    }

    public boolean G0(org.jsoup.select.c cVar) {
        return cVar.a((Element) R(), this);
    }

    public boolean H0() {
        return this.f71861c.c();
    }

    public Element I0() {
        if (this.f71885a == null) {
            return null;
        }
        List n02 = I().n0();
        int F0 = F0(this, n02);
        org.jsoup.helper.d.j(Integer.valueOf(F0));
        int i11 = F0 + 1;
        if (n02.size() > i11) {
            return (Element) n02.get(i11);
        }
        return null;
    }

    public String J0() {
        StringBuilder sb2 = new StringBuilder();
        K0(sb2);
        return sb2.toString().trim();
    }

    @Override // org.jsoup.nodes.j
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public final Element I() {
        return (Element) this.f71885a;
    }

    public Elements M0() {
        Elements elements = new Elements();
        c0(this, elements);
        return elements;
    }

    public Element N0(String str) {
        org.jsoup.helper.d.j(str);
        List d11 = org.jsoup.parser.e.d(str, this, j());
        b(0, (j[]) d11.toArray(new j[d11.size()]));
        return this;
    }

    public Element P0() {
        if (this.f71885a == null) {
            return null;
        }
        List n02 = I().n0();
        int F0 = F0(this, n02);
        org.jsoup.helper.d.j(Integer.valueOf(F0));
        if (F0 > 0) {
            return (Element) n02.get(F0 - 1);
        }
        return null;
    }

    public Element Q0(String str) {
        org.jsoup.helper.d.j(str);
        Set q02 = q0();
        q02.remove(str);
        r0(q02);
        return this;
    }

    public Elements R0(String str) {
        return Selector.c(str, this);
    }

    public Elements S0() {
        if (this.f71885a == null) {
            return new Elements(0);
        }
        List<Element> n02 = I().n0();
        Elements elements = new Elements(n02.size() - 1);
        for (Element element : n02) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public org.jsoup.parser.f T0() {
        return this.f71861c;
    }

    public String U0() {
        return this.f71861c.b();
    }

    public Element V0(String str) {
        org.jsoup.helper.d.i(str, "Tag name must not be empty.");
        this.f71861c = org.jsoup.parser.f.l(str, org.jsoup.parser.d.f71955d);
        return this;
    }

    public String W0() {
        StringBuilder sb2 = new StringBuilder();
        org.jsoup.select.d.c(new a(sb2), this);
        return sb2.toString().trim();
    }

    public Element X0(String str) {
        org.jsoup.helper.d.j(str);
        w0();
        g0(new l(str));
        return this;
    }

    public List Y0() {
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.f71863e) {
            if (jVar instanceof l) {
                arrayList.add((l) jVar);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element Z0(String str) {
        org.jsoup.helper.d.j(str);
        Set q02 = q0();
        if (q02.contains(str)) {
            q02.remove(str);
        } else {
            q02.add(str);
        }
        r0(q02);
        return this;
    }

    public String a1() {
        return U0().equals("textarea") ? W0() : f(AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    public Element b1(String str) {
        if (U0().equals("textarea")) {
            X0(str);
        } else {
            j0(AppMeasurementSdk.ConditionalUserProperty.VALUE, str);
        }
        return this;
    }

    public Element c1(String str) {
        return (Element) super.Z(str);
    }

    public Element d0(String str) {
        org.jsoup.helper.d.j(str);
        Set q02 = q0();
        q02.add(str);
        r0(q02);
        return this;
    }

    public Element e0(String str) {
        return (Element) super.e(str);
    }

    public Element f0(String str) {
        org.jsoup.helper.d.j(str);
        List d11 = org.jsoup.parser.e.d(str, this, j());
        c((j[]) d11.toArray(new j[d11.size()]));
        return this;
    }

    public Element g0(j jVar) {
        org.jsoup.helper.d.j(jVar);
        O(jVar);
        t();
        this.f71863e.add(jVar);
        jVar.U(this.f71863e.size() - 1);
        return this;
    }

    @Override // org.jsoup.nodes.j
    public b i() {
        if (!x()) {
            this.f71864f = new b();
        }
        return this.f71864f;
    }

    @Override // org.jsoup.nodes.j
    public String j() {
        return this.f71865g;
    }

    public Element j0(String str, String str2) {
        super.g(str, str2);
        return this;
    }

    public Element k0(String str) {
        return (Element) super.k(str);
    }

    public Element l0(j jVar) {
        return (Element) super.l(jVar);
    }

    public Element m0(int i11) {
        return (Element) n0().get(i11);
    }

    @Override // org.jsoup.nodes.j
    public int n() {
        return this.f71863e.size();
    }

    public Elements o0() {
        return new Elements((List<Element>) n0());
    }

    public String p0() {
        return f("class").trim();
    }

    public Set q0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(f71860i.split(p0())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element r0(Set set) {
        org.jsoup.helper.d.j(set);
        if (set.isEmpty()) {
            i().A("class");
        } else {
            i().w("class", org.jsoup.helper.c.i(set, " "));
        }
        return this;
    }

    @Override // org.jsoup.nodes.j
    protected void s(String str) {
        this.f71865g = str;
    }

    @Override // org.jsoup.nodes.j
    public Element s0() {
        return (Element) super.s0();
    }

    @Override // org.jsoup.nodes.j
    protected List t() {
        if (this.f71863e == f71859h) {
            this.f71863e = new NodeList(this, 4);
        }
        return this.f71863e;
    }

    public String t0() {
        StringBuilder sb2 = new StringBuilder();
        for (j jVar : this.f71863e) {
            if (jVar instanceof f) {
                sb2.append(((f) jVar).c0());
            } else if (jVar instanceof e) {
                sb2.append(((e) jVar).c0());
            } else if (jVar instanceof Element) {
                sb2.append(((Element) jVar).t0());
            } else if (jVar instanceof d) {
                sb2.append(((d) jVar).c0());
            }
        }
        return sb2.toString();
    }

    @Override // org.jsoup.nodes.j
    public String toString() {
        return D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.j
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public Element r(j jVar) {
        Element element = (Element) super.r(jVar);
        b bVar = this.f71864f;
        element.f71864f = bVar != null ? bVar.clone() : null;
        element.f71865g = this.f71865g;
        NodeList nodeList = new NodeList(element, this.f71863e.size());
        element.f71863e = nodeList;
        nodeList.addAll(this.f71863e);
        return element;
    }

    public int v0() {
        if (I() == null) {
            return 0;
        }
        return F0(this, I().n0());
    }

    public Element w0() {
        this.f71863e.clear();
        return this;
    }

    @Override // org.jsoup.nodes.j
    protected boolean x() {
        return this.f71864f != null;
    }

    public Elements x0() {
        return org.jsoup.select.a.a(new c.a(), this);
    }

    public Elements y0(String str) {
        org.jsoup.helper.d.h(str);
        return org.jsoup.select.a.a(new c.j0(e10.b.b(str)), this);
    }

    public boolean z0(String str) {
        String o11 = i().o("class");
        int length = o11.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(o11);
            }
            boolean z10 = false;
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (Character.isWhitespace(o11.charAt(i12))) {
                    if (!z10) {
                        continue;
                    } else {
                        if (i12 - i11 == length2 && o11.regionMatches(true, i11, str, 0, length2)) {
                            return true;
                        }
                        z10 = false;
                    }
                } else if (!z10) {
                    i11 = i12;
                    z10 = true;
                }
            }
            if (z10 && length - i11 == length2) {
                return o11.regionMatches(true, i11, str, 0, length2);
            }
        }
        return false;
    }
}
