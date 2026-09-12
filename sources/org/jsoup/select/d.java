package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.select.NodeFilter;

/* loaded from: classes7.dex */
public abstract class d {
    public static NodeFilter.FilterResult a(NodeFilter nodeFilter, j jVar) {
        j jVar2 = jVar;
        int i11 = 0;
        while (jVar2 != null) {
            NodeFilter.FilterResult b11 = nodeFilter.b(jVar2, i11);
            if (b11 == NodeFilter.FilterResult.STOP) {
                return b11;
            }
            if (b11 != NodeFilter.FilterResult.CONTINUE || jVar2.n() <= 0) {
                while (jVar2.A() == null && i11 > 0) {
                    NodeFilter.FilterResult filterResult = NodeFilter.FilterResult.CONTINUE;
                    if ((b11 == filterResult || b11 == NodeFilter.FilterResult.SKIP_CHILDREN) && (b11 = nodeFilter.a(jVar2, i11)) == NodeFilter.FilterResult.STOP) {
                        return b11;
                    }
                    j J = jVar2.J();
                    i11--;
                    if (b11 == NodeFilter.FilterResult.REMOVE) {
                        jVar2.L();
                    }
                    b11 = filterResult;
                    jVar2 = J;
                }
                if ((b11 == NodeFilter.FilterResult.CONTINUE || b11 == NodeFilter.FilterResult.SKIP_CHILDREN) && (b11 = nodeFilter.a(jVar2, i11)) == NodeFilter.FilterResult.STOP) {
                    return b11;
                }
                if (jVar2 == jVar) {
                    return b11;
                }
                j A = jVar2.A();
                if (b11 == NodeFilter.FilterResult.REMOVE) {
                    jVar2.L();
                }
                jVar2 = A;
            } else {
                jVar2 = jVar2.m(0);
                i11++;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void b(NodeFilter nodeFilter, Elements elements) {
        org.jsoup.helper.d.j(nodeFilter);
        org.jsoup.helper.d.j(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext() && a(nodeFilter, it.next()) != NodeFilter.FilterResult.STOP) {
        }
    }

    public static void c(f10.a aVar, j jVar) {
        j jVar2 = jVar;
        int i11 = 0;
        while (jVar2 != null) {
            aVar.b(jVar2, i11);
            if (jVar2.n() > 0) {
                jVar2 = jVar2.m(0);
                i11++;
            } else {
                while (jVar2.A() == null && i11 > 0) {
                    aVar.a(jVar2, i11);
                    jVar2 = jVar2.J();
                    i11--;
                }
                aVar.a(jVar2, i11);
                if (jVar2 == jVar) {
                    return;
                } else {
                    jVar2 = jVar2.A();
                }
            }
        }
    }

    public static void d(f10.a aVar, Elements elements) {
        org.jsoup.helper.d.j(aVar);
        org.jsoup.helper.d.j(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            c(aVar, it.next());
        }
    }
}
