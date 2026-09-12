package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* loaded from: classes7.dex */
public abstract class c {

    /* loaded from: classes7.dex */
    public static final class a extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    /* loaded from: classes7.dex */
    public static final class a0 extends o {
        public a0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        protected int b(Element element, Element element2) {
            return element2.I().o0().size() - element2.v0();
        }

        @Override // org.jsoup.select.c.o
        protected String c() {
            return "nth-last-child";
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72016a;

        public b(String str) {
            this.f72016a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72016a);
        }

        public String toString() {
            return String.format("[%s]", this.f72016a);
        }
    }

    /* loaded from: classes7.dex */
    public static class b0 extends o {
        public b0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        protected int b(Element element, Element element2) {
            Elements o02 = element2.I().o0();
            int i11 = 0;
            for (int v02 = element2.v0(); v02 < o02.size(); v02++) {
                if (o02.get(v02).T0().equals(element2.T0())) {
                    i11++;
                }
            }
            return i11;
        }

        @Override // org.jsoup.select.c.o
        protected String c() {
            return "nth-last-of-type";
        }
    }

    /* renamed from: org.jsoup.select.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0900c extends c {

        /* renamed from: a, reason: collision with root package name */
        String f72017a;

        /* renamed from: b, reason: collision with root package name */
        String f72018b;

        public AbstractC0900c(String str, String str2) {
            org.jsoup.helper.d.h(str);
            org.jsoup.helper.d.h(str2);
            this.f72017a = e10.b.b(str);
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.f72018b = e10.b.b(str2);
        }
    }

    /* loaded from: classes7.dex */
    public static class c0 extends o {
        public c0(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        protected int b(Element element, Element element2) {
            Iterator<Element> it = element2.I().o0().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Element next = it.next();
                if (next.T0().equals(element2.T0())) {
                    i11++;
                }
                if (next == element2) {
                    break;
                }
            }
            return i11;
        }

        @Override // org.jsoup.select.c.o
        protected String c() {
            return "nth-of-type";
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72019a;

        public d(String str) {
            org.jsoup.helper.d.h(str);
            this.f72019a = e10.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Iterator it = element2.i().f().iterator();
            while (it.hasNext()) {
                if (e10.b.a(((org.jsoup.nodes.a) it.next()).getKey()).startsWith(this.f72019a)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", this.f72019a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I = element2.I();
            return (I == null || (I instanceof Document) || element2.S0().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends AbstractC0900c {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72017a) && this.f72018b.equalsIgnoreCase(element2.f(this.f72017a).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", this.f72017a, this.f72018b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I = element2.I();
            if (I == null || (I instanceof Document)) {
                return false;
            }
            Iterator<Element> it = I.o0().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                if (it.next().T0().equals(element2.T0())) {
                    i11++;
                }
            }
            return i11 == 1;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    /* loaded from: classes7.dex */
    public static final class f extends AbstractC0900c {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72017a) && e10.b.a(element2.f(this.f72017a)).contains(this.f72018b);
        }

        public String toString() {
            return String.format("[%s*=%s]", this.f72017a, this.f72018b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class f0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.m0(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    /* loaded from: classes7.dex */
    public static final class g extends AbstractC0900c {
        public g(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72017a) && e10.b.a(element2.f(this.f72017a)).endsWith(this.f72018b);
        }

        public String toString() {
            return String.format("[%s$=%s]", this.f72017a, this.f72018b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g0 extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            if (element2 instanceof org.jsoup.nodes.k) {
                return true;
            }
            for (org.jsoup.nodes.j jVar : element2.Y0()) {
                org.jsoup.nodes.k kVar = new org.jsoup.nodes.k(org.jsoup.parser.f.k(element2.U0()), element2.j(), element2.i());
                jVar.Q(kVar);
                kVar.g0(jVar);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    /* loaded from: classes7.dex */
    public static final class h extends c {

        /* renamed from: a, reason: collision with root package name */
        String f72020a;

        /* renamed from: b, reason: collision with root package name */
        Pattern f72021b;

        public h(String str, Pattern pattern) {
            this.f72020a = e10.b.b(str);
            this.f72021b = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72020a) && this.f72021b.matcher(element2.f(this.f72020a)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", this.f72020a, this.f72021b.toString());
        }
    }

    /* loaded from: classes7.dex */
    public static final class h0 extends c {

        /* renamed from: a, reason: collision with root package name */
        private Pattern f72022a;

        public h0(Pattern pattern) {
            this.f72022a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f72022a.matcher(element2.W0()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", this.f72022a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class i extends AbstractC0900c {
        public i(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return !this.f72018b.equalsIgnoreCase(element2.f(this.f72017a));
        }

        public String toString() {
            return String.format("[%s!=%s]", this.f72017a, this.f72018b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class i0 extends c {

        /* renamed from: a, reason: collision with root package name */
        private Pattern f72023a;

        public i0(Pattern pattern) {
            this.f72023a = pattern;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f72023a.matcher(element2.J0()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", this.f72023a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class j extends AbstractC0900c {
        public j(String str, String str2) {
            super(str, str2);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.w(this.f72017a) && e10.b.a(element2.f(this.f72017a)).startsWith(this.f72018b);
        }

        public String toString() {
            return String.format("[%s^=%s]", this.f72017a, this.f72018b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class j0 extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72024a;

        public j0(String str) {
            this.f72024a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.U0().equalsIgnoreCase(this.f72024a);
        }

        public String toString() {
            return String.format("%s", this.f72024a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class k extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72025a;

        public k(String str) {
            this.f72025a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.z0(this.f72025a);
        }

        public String toString() {
            return String.format(".%s", this.f72025a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class k0 extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72026a;

        public k0(String str) {
            this.f72026a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.U0().endsWith(this.f72026a);
        }

        public String toString() {
            return String.format("%s", this.f72026a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class l extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72027a;

        public l(String str) {
            this.f72027a = e10.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e10.b.a(element2.t0()).contains(this.f72027a);
        }

        public String toString() {
            return String.format(":containsData(%s)", this.f72027a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class m extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72028a;

        public m(String str) {
            this.f72028a = e10.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e10.b.a(element2.J0()).contains(this.f72028a);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", this.f72028a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class n extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72029a;

        public n(String str) {
            this.f72029a = e10.b.a(str);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return e10.b.a(element2.W0()).contains(this.f72029a);
        }

        public String toString() {
            return String.format(":contains(%s)", this.f72029a);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class o extends c {

        /* renamed from: a, reason: collision with root package name */
        protected final int f72030a;

        /* renamed from: b, reason: collision with root package name */
        protected final int f72031b;

        public o(int i11, int i12) {
            this.f72030a = i11;
            this.f72031b = i12;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I = element2.I();
            if (I == null || (I instanceof Document)) {
                return false;
            }
            int b11 = b(element, element2);
            int i11 = this.f72030a;
            if (i11 == 0) {
                return b11 == this.f72031b;
            }
            int i12 = this.f72031b;
            return (b11 - i12) * i11 >= 0 && (b11 - i12) % i11 == 0;
        }

        protected abstract int b(Element element, Element element2);

        protected abstract String c();

        public String toString() {
            return this.f72030a == 0 ? String.format(":%s(%d)", c(), Integer.valueOf(this.f72031b)) : this.f72031b == 0 ? String.format(":%s(%dn)", c(), Integer.valueOf(this.f72030a)) : String.format(":%s(%dn%+d)", c(), Integer.valueOf(this.f72030a), Integer.valueOf(this.f72031b));
        }
    }

    /* loaded from: classes7.dex */
    public static final class p extends c {

        /* renamed from: a, reason: collision with root package name */
        private String f72032a;

        public p(String str) {
            this.f72032a = str;
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return this.f72032a.equals(element2.E0());
        }

        public String toString() {
            return String.format("#%s", this.f72032a);
        }
    }

    /* loaded from: classes7.dex */
    public static final class q extends r {
        public q(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.v0() == this.f72033a;
        }

        public String toString() {
            return String.format(":eq(%d)", Integer.valueOf(this.f72033a));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class r extends c {

        /* renamed from: a, reason: collision with root package name */
        int f72033a;

        public r(int i11) {
            this.f72033a = i11;
        }
    }

    /* loaded from: classes7.dex */
    public static final class s extends r {
        public s(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element2.v0() > this.f72033a;
        }

        public String toString() {
            return String.format(":gt(%d)", Integer.valueOf(this.f72033a));
        }
    }

    /* loaded from: classes7.dex */
    public static final class t extends r {
        public t(int i11) {
            super(i11);
        }

        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            return element != element2 && element2.v0() < this.f72033a;
        }

        public String toString() {
            return String.format(":lt(%d)", Integer.valueOf(this.f72033a));
        }
    }

    /* loaded from: classes7.dex */
    public static final class u extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            for (org.jsoup.nodes.j jVar : element2.o()) {
                if (!(jVar instanceof org.jsoup.nodes.e) && !(jVar instanceof org.jsoup.nodes.m) && !(jVar instanceof org.jsoup.nodes.g)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    /* loaded from: classes7.dex */
    public static final class v extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I = element2.I();
            return (I == null || (I instanceof Document) || element2.v0() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    /* loaded from: classes7.dex */
    public static final class w extends c0 {
        public w() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":first-of-type";
        }
    }

    /* loaded from: classes7.dex */
    public static final class x extends c {
        @Override // org.jsoup.select.c
        public boolean a(Element element, Element element2) {
            Element I = element2.I();
            return (I == null || (I instanceof Document) || element2.v0() != I.o0().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    /* loaded from: classes7.dex */
    public static final class y extends b0 {
        public y() {
            super(0, 1);
        }

        @Override // org.jsoup.select.c.o
        public String toString() {
            return ":last-of-type";
        }
    }

    /* loaded from: classes7.dex */
    public static final class z extends o {
        public z(int i11, int i12) {
            super(i11, i12);
        }

        @Override // org.jsoup.select.c.o
        protected int b(Element element, Element element2) {
            return element2.v0() + 1;
        }

        @Override // org.jsoup.select.c.o
        protected String c() {
            return "nth-child";
        }
    }

    public abstract boolean a(Element element, Element element2);
}
