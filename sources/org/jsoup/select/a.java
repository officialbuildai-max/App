package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;

/* loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.jsoup.select.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0898a implements f10.a {

        /* renamed from: a, reason: collision with root package name */
        private final Element f72011a;

        /* renamed from: b, reason: collision with root package name */
        private final Elements f72012b;

        /* renamed from: c, reason: collision with root package name */
        private final c f72013c;

        C0898a(Element element, Elements elements, c cVar) {
            this.f72011a = element;
            this.f72012b = elements;
            this.f72013c = cVar;
        }

        @Override // f10.a
        public void a(j jVar, int i11) {
        }

        @Override // f10.a
        public void b(j jVar, int i11) {
            if (jVar instanceof Element) {
                Element element = (Element) jVar;
                if (this.f72013c.a(this.f72011a, element)) {
                    this.f72012b.add(element);
                }
            }
        }
    }

    public static Elements a(c cVar, Element element) {
        Elements elements = new Elements();
        d.c(new C0898a(element, elements, cVar), element);
        return elements;
    }
}
