package qc;

import rc.d;
import rc.e;
import rc.f;
import rc.g;
import rc.h;

/* loaded from: classes5.dex */
public abstract class a {

    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private rc.a f73663a;

        private b() {
        }

        public qc.b a() {
            hz.b.a(this.f73663a, rc.a.class);
            return new c(this.f73663a);
        }

        public b b(rc.a aVar) {
            this.f73663a = (rc.a) hz.b.b(aVar);
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class c implements qc.b {

        /* renamed from: a, reason: collision with root package name */
        private final c f73664a;

        /* renamed from: b, reason: collision with root package name */
        private uz.a f73665b;

        /* renamed from: c, reason: collision with root package name */
        private uz.a f73666c;

        /* renamed from: d, reason: collision with root package name */
        private uz.a f73667d;

        /* renamed from: e, reason: collision with root package name */
        private uz.a f73668e;

        /* renamed from: f, reason: collision with root package name */
        private uz.a f73669f;

        /* renamed from: g, reason: collision with root package name */
        private uz.a f73670g;

        /* renamed from: h, reason: collision with root package name */
        private uz.a f73671h;

        /* renamed from: i, reason: collision with root package name */
        private uz.a f73672i;

        private c(rc.a aVar) {
            this.f73664a = this;
            b(aVar);
        }

        private void b(rc.a aVar) {
            this.f73665b = rc.c.a(aVar);
            this.f73666c = e.a(aVar);
            this.f73667d = d.a(aVar);
            this.f73668e = h.a(aVar);
            this.f73669f = f.a(aVar);
            this.f73670g = rc.b.a(aVar);
            g a11 = g.a(aVar);
            this.f73671h = a11;
            this.f73672i = hz.a.a(pc.g.a(this.f73665b, this.f73666c, this.f73667d, this.f73668e, this.f73669f, this.f73670g, a11));
        }

        @Override // qc.b
        public pc.e a() {
            return (pc.e) this.f73672i.get();
        }
    }

    public static b a() {
        return new b();
    }
}
