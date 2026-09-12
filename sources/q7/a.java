package q7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f73236a;

    /* renamed from: b, reason: collision with root package name */
    public final String f73237b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f73238c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f73239d;

    /* renamed from: e, reason: collision with root package name */
    public final String f73240e;

    /* renamed from: f, reason: collision with root package name */
    public final int f73241f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f73242g;

    /* renamed from: h, reason: collision with root package name */
    public final u7.b f73243h;

    /* renamed from: i, reason: collision with root package name */
    public final x7.b f73244i;

    /* renamed from: j, reason: collision with root package name */
    public final w7.b f73245j;

    /* renamed from: k, reason: collision with root package name */
    public final z7.b f73246k;

    /* renamed from: l, reason: collision with root package name */
    public final y7.b f73247l;

    /* renamed from: m, reason: collision with root package name */
    public final t7.a f73248m;

    /* renamed from: n, reason: collision with root package name */
    private final Map f73249n;

    /* renamed from: o, reason: collision with root package name */
    public final List f73250o;

    /* renamed from: q7.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0920a {

        /* renamed from: a, reason: collision with root package name */
        private int f73251a;

        /* renamed from: b, reason: collision with root package name */
        private String f73252b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f73253c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f73254d;

        /* renamed from: e, reason: collision with root package name */
        private String f73255e;

        /* renamed from: f, reason: collision with root package name */
        private int f73256f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f73257g;

        /* renamed from: h, reason: collision with root package name */
        private u7.b f73258h;

        /* renamed from: i, reason: collision with root package name */
        private x7.b f73259i;

        /* renamed from: j, reason: collision with root package name */
        private w7.b f73260j;

        /* renamed from: k, reason: collision with root package name */
        private z7.b f73261k;

        /* renamed from: l, reason: collision with root package name */
        private y7.b f73262l;

        /* renamed from: m, reason: collision with root package name */
        private t7.a f73263m;

        /* renamed from: n, reason: collision with root package name */
        private Map f73264n;

        /* renamed from: o, reason: collision with root package name */
        private List f73265o;

        public C0920a() {
            this.f73251a = Integer.MIN_VALUE;
            this.f73252b = "X-LOG";
        }

        public C0920a(a aVar) {
            this.f73251a = Integer.MIN_VALUE;
            this.f73252b = "X-LOG";
            this.f73251a = aVar.f73236a;
            this.f73252b = aVar.f73237b;
            this.f73253c = aVar.f73238c;
            this.f73254d = aVar.f73239d;
            this.f73255e = aVar.f73240e;
            this.f73256f = aVar.f73241f;
            this.f73257g = aVar.f73242g;
            this.f73258h = aVar.f73243h;
            this.f73259i = aVar.f73244i;
            this.f73260j = aVar.f73245j;
            this.f73261k = aVar.f73246k;
            this.f73262l = aVar.f73247l;
            this.f73263m = aVar.f73248m;
            if (aVar.f73249n != null) {
                this.f73264n = new HashMap(aVar.f73249n);
            }
            if (aVar.f73250o != null) {
                this.f73265o = new ArrayList(aVar.f73250o);
            }
        }

        private void y() {
            if (this.f73258h == null) {
                this.f73258h = b8.a.h();
            }
            if (this.f73259i == null) {
                this.f73259i = b8.a.n();
            }
            if (this.f73260j == null) {
                this.f73260j = b8.a.l();
            }
            if (this.f73261k == null) {
                this.f73261k = b8.a.k();
            }
            if (this.f73262l == null) {
                this.f73262l = b8.a.j();
            }
            if (this.f73263m == null) {
                this.f73263m = b8.a.c();
            }
            if (this.f73264n == null) {
                this.f73264n = new HashMap(b8.a.a());
            }
        }

        public C0920a A(u7.b bVar) {
            this.f73258h = bVar;
            return this;
        }

        public C0920a B(int i11) {
            this.f73251a = i11;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0920a C(Map map) {
            this.f73264n = map;
            return this;
        }

        public C0920a D(y7.b bVar) {
            this.f73262l = bVar;
            return this;
        }

        public C0920a E(String str) {
            this.f73252b = str;
            return this;
        }

        public C0920a F(z7.b bVar) {
            this.f73261k = bVar;
            return this;
        }

        public C0920a G(w7.b bVar) {
            this.f73260j = bVar;
            return this;
        }

        public C0920a H(x7.b bVar) {
            this.f73259i = bVar;
            return this;
        }

        public C0920a p(a8.a aVar) {
            if (this.f73265o == null) {
                this.f73265o = new ArrayList();
            }
            this.f73265o.add(aVar);
            return this;
        }

        public C0920a q(t7.a aVar) {
            this.f73263m = aVar;
            return this;
        }

        public a r() {
            y();
            return new a(this);
        }

        public C0920a s() {
            this.f73257g = false;
            return this;
        }

        public C0920a t() {
            this.f73254d = false;
            this.f73255e = null;
            this.f73256f = 0;
            return this;
        }

        public C0920a u() {
            this.f73253c = false;
            return this;
        }

        public C0920a v() {
            this.f73257g = true;
            return this;
        }

        public C0920a w(String str, int i11) {
            this.f73254d = true;
            this.f73255e = str;
            this.f73256f = i11;
            return this;
        }

        public C0920a x() {
            this.f73253c = true;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0920a z(List list) {
            this.f73265o = list;
            return this;
        }
    }

    a(C0920a c0920a) {
        this.f73236a = c0920a.f73251a;
        this.f73237b = c0920a.f73252b;
        this.f73238c = c0920a.f73253c;
        this.f73239d = c0920a.f73254d;
        this.f73240e = c0920a.f73255e;
        this.f73241f = c0920a.f73256f;
        this.f73242g = c0920a.f73257g;
        this.f73243h = c0920a.f73258h;
        this.f73244i = c0920a.f73259i;
        this.f73245j = c0920a.f73260j;
        this.f73246k = c0920a.f73261k;
        this.f73247l = c0920a.f73262l;
        this.f73248m = c0920a.f73263m;
        this.f73249n = c0920a.f73264n;
        this.f73250o = c0920a.f73265o;
    }
}
