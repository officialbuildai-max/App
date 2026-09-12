package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

/* loaded from: classes7.dex */
abstract class f extends org.jsoup.select.c {

    /* renamed from: a, reason: collision with root package name */
    org.jsoup.select.c f72041a;

    /* loaded from: classes7.dex */
    static class a extends f {
        public a(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Iterator<Element> it = element2.x0().iterator();
            while (it.hasNext()) {
                Element next = it.next();
                if (next != element2 && this.f72041a.a(element, next)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.f72041a);
        }
    }

    /* loaded from: classes7.dex */
    static class b extends f {
        public b(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I;
            return (element == element2 || (I = element2.I()) == null || !this.f72041a.a(element, I)) ? false : true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.f72041a);
        }
    }

    /* loaded from: classes7.dex */
    static class c extends f {
        public c(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element P0;
            return (element == element2 || (P0 = element2.P0()) == null || !this.f72041a.a(element, P0)) ? false : true;
        }

        public String toString() {
            return String.format(":prev%s", this.f72041a);
        }
    }

    /* loaded from: classes7.dex */
    static class d extends f {
        public d(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return !this.f72041a.a(element, element2);
        }

        public String toString() {
            return String.format(":not%s", this.f72041a);
        }
    }

    /* loaded from: classes7.dex */
    static class e extends f {
        public e(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element I = element2.I(); !this.f72041a.a(element, I); I = I.I()) {
                if (I == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", this.f72041a);
        }
    }

    /* renamed from: org.jsoup.select.f$f, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0901f extends f {
        public C0901f(org.jsoup.select.c cVar) {
            this.f72041a = cVar;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element P0 = element2.P0(); P0 != null; P0 = P0.P0()) {
                if (this.f72041a.a(element, P0)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", this.f72041a);
        }
    }

    /* loaded from: classes7.dex */
    static class g extends org.jsoup.select.c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element == element2;
        }
    }

    f() {
    }
}
