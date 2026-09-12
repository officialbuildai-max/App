package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/* loaded from: classes7.dex */
public abstract class j implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    j f71885a;

    /* renamed from: b, reason: collision with root package name */
    int f71886b;

    /* loaded from: classes7.dex */
    class a implements f10.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f71887a;

        a(String str) {
            this.f71887a = str;
        }

        @Override // f10.a
        public void a(j jVar, int i11) {
        }

        @Override // f10.a
        public void b(j jVar, int i11) {
            jVar.s(this.f71887a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b implements f10.a {

        /* renamed from: a, reason: collision with root package name */
        private Appendable f71889a;

        /* renamed from: b, reason: collision with root package name */
        private Document.OutputSettings f71890b;

        b(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f71889a = appendable;
            this.f71890b = outputSettings;
            outputSettings.k();
        }

        @Override // f10.a
        public void a(j jVar, int i11) {
            if (jVar.B().equals("#text")) {
                return;
            }
            try {
                jVar.G(this.f71889a, i11, this.f71890b);
            } catch (IOException e11) {
                throw new SerializationException(e11);
            }
        }

        @Override // f10.a
        public void b(j jVar, int i11) {
            try {
                jVar.F(this.f71889a, i11, this.f71890b);
            } catch (IOException e11) {
                throw new SerializationException(e11);
            }
        }
    }

    private void K(int i11) {
        List t11 = t();
        while (i11 < t11.size()) {
            ((j) t11.get(i11)).U(i11);
            i11++;
        }
    }

    private void d(int i11, String str) {
        org.jsoup.helper.d.j(str);
        org.jsoup.helper.d.j(this.f71885a);
        List d11 = org.jsoup.parser.e.d(str, I() instanceof Element ? (Element) I() : null, j());
        this.f71885a.b(i11, (j[]) d11.toArray(new j[d11.size()]));
    }

    private Element u(Element element) {
        Elements o02 = element.o0();
        return o02.size() > 0 ? u(o02.get(0)) : element;
    }

    public j A() {
        j jVar = this.f71885a;
        if (jVar == null) {
            return null;
        }
        List t11 = jVar.t();
        int i11 = this.f71886b + 1;
        if (t11.size() > i11) {
            return (j) t11.get(i11);
        }
        return null;
    }

    public abstract String B();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
    }

    public String D() {
        StringBuilder sb2 = new StringBuilder(128);
        E(sb2);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(Appendable appendable) {
        org.jsoup.select.d.c(new b(appendable, v()), this);
    }

    abstract void F(Appendable appendable, int i11, Document.OutputSettings outputSettings);

    abstract void G(Appendable appendable, int i11, Document.OutputSettings outputSettings);

    public Document H() {
        j R = R();
        if (R instanceof Document) {
            return (Document) R;
        }
        return null;
    }

    public j I() {
        return this.f71885a;
    }

    public final j J() {
        return this.f71885a;
    }

    public void L() {
        org.jsoup.helper.d.j(this.f71885a);
        this.f71885a.N(this);
    }

    public j M(String str) {
        org.jsoup.helper.d.j(str);
        i().B(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(j jVar) {
        org.jsoup.helper.d.d(jVar.f71885a == this);
        int i11 = jVar.f71886b;
        t().remove(i11);
        K(i11);
        jVar.f71885a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(j jVar) {
        jVar.T(this);
    }

    protected void P(j jVar, j jVar2) {
        org.jsoup.helper.d.d(jVar.f71885a == this);
        org.jsoup.helper.d.j(jVar2);
        j jVar3 = jVar2.f71885a;
        if (jVar3 != null) {
            jVar3.N(jVar2);
        }
        int i11 = jVar.f71886b;
        t().set(i11, jVar2);
        jVar2.f71885a = this;
        jVar2.U(i11);
        jVar.f71885a = null;
    }

    public void Q(j jVar) {
        org.jsoup.helper.d.j(jVar);
        org.jsoup.helper.d.j(this.f71885a);
        this.f71885a.P(this, jVar);
    }

    public j R() {
        j jVar = this;
        while (true) {
            j jVar2 = jVar.f71885a;
            if (jVar2 == null) {
                return jVar;
            }
            jVar = jVar2;
        }
    }

    public void S(String str) {
        org.jsoup.helper.d.j(str);
        X(new a(str));
    }

    protected void T(j jVar) {
        org.jsoup.helper.d.j(jVar);
        j jVar2 = this.f71885a;
        if (jVar2 != null) {
            jVar2.N(this);
        }
        this.f71885a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U(int i11) {
        this.f71886b = i11;
    }

    public int V() {
        return this.f71886b;
    }

    public List W() {
        j jVar = this.f71885a;
        if (jVar == null) {
            return Collections.emptyList();
        }
        List<j> t11 = jVar.t();
        ArrayList arrayList = new ArrayList(t11.size() - 1);
        for (j jVar2 : t11) {
            if (jVar2 != this) {
                arrayList.add(jVar2);
            }
        }
        return arrayList;
    }

    public j X(f10.a aVar) {
        org.jsoup.helper.d.j(aVar);
        org.jsoup.select.d.c(aVar, this);
        return this;
    }

    public j Y() {
        org.jsoup.helper.d.j(this.f71885a);
        List t11 = t();
        j jVar = t11.size() > 0 ? (j) t11.get(0) : null;
        this.f71885a.b(this.f71886b, p());
        L();
        return jVar;
    }

    public j Z(String str) {
        org.jsoup.helper.d.h(str);
        List d11 = org.jsoup.parser.e.d(str, I() instanceof Element ? (Element) I() : null, j());
        j jVar = (j) d11.get(0);
        if (jVar == null || !(jVar instanceof Element)) {
            return null;
        }
        Element element = (Element) jVar;
        Element u11 = u(element);
        this.f71885a.P(this, element);
        u11.c(this);
        if (d11.size() > 0) {
            for (int i11 = 0; i11 < d11.size(); i11++) {
                j jVar2 = (j) d11.get(i11);
                jVar2.f71885a.N(jVar2);
                element.g0(jVar2);
            }
        }
        return this;
    }

    public String a(String str) {
        org.jsoup.helper.d.h(str);
        return !w(str) ? "" : org.jsoup.helper.c.m(j(), f(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i11, j... jVarArr) {
        org.jsoup.helper.d.f(jVarArr);
        List t11 = t();
        for (j jVar : jVarArr) {
            O(jVar);
        }
        t11.addAll(i11, Arrays.asList(jVarArr));
        K(i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(j... jVarArr) {
        List t11 = t();
        for (j jVar : jVarArr) {
            O(jVar);
            t11.add(jVar);
            jVar.U(t11.size() - 1);
        }
    }

    public j e(String str) {
        d(this.f71886b + 1, str);
        return this;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String f(String str) {
        org.jsoup.helper.d.j(str);
        if (!x()) {
            return "";
        }
        String o11 = i().o(str);
        return o11.length() > 0 ? o11 : str.startsWith("abs:") ? a(str.substring(4)) : "";
    }

    public j g(String str, String str2) {
        i().y(str, str2);
        return this;
    }

    public abstract org.jsoup.nodes.b i();

    public abstract String j();

    public j k(String str) {
        d(this.f71886b, str);
        return this;
    }

    public j l(j jVar) {
        org.jsoup.helper.d.j(jVar);
        org.jsoup.helper.d.j(this.f71885a);
        this.f71885a.b(this.f71886b, jVar);
        return this;
    }

    public j m(int i11) {
        return (j) t().get(i11);
    }

    public abstract int n();

    public List o() {
        return Collections.unmodifiableList(t());
    }

    protected j[] p() {
        return (j[]) t().toArray(new j[n()]);
    }

    @Override // 
    /* renamed from: q */
    public j s0() {
        j r11 = r(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(r11);
        while (!linkedList.isEmpty()) {
            j jVar = (j) linkedList.remove();
            int n11 = jVar.n();
            for (int i11 = 0; i11 < n11; i11++) {
                List t11 = jVar.t();
                j r12 = ((j) t11.get(i11)).r(jVar);
                t11.set(i11, r12);
                linkedList.add(r12);
            }
        }
        return r11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j r(j jVar) {
        try {
            j jVar2 = (j) super.clone();
            jVar2.f71885a = jVar;
            jVar2.f71886b = jVar == null ? 0 : this.f71886b;
            return jVar2;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    protected abstract void s(String str);

    protected abstract List t();

    public String toString() {
        return D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document.OutputSettings v() {
        Document H = H();
        if (H == null) {
            H = new Document("");
        }
        return H.g1();
    }

    public boolean w(String str) {
        org.jsoup.helper.d.j(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (i().q(substring) && !a(substring).equals("")) {
                return true;
            }
        }
        return i().q(str);
    }

    protected abstract boolean x();

    public boolean y() {
        return this.f71885a != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
        appendable.append('\n').append(org.jsoup.helper.c.l(i11 * outputSettings.i()));
    }
}
