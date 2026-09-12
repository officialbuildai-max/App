package androidx.recyclerview.widget;

import androidx.collection.x;

/* loaded from: classes2.dex */
interface s {

    /* loaded from: classes2.dex */
    public static class a implements s {

        /* renamed from: a, reason: collision with root package name */
        long f14497a = 0;

        /* renamed from: androidx.recyclerview.widget.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0120a implements d {

            /* renamed from: a, reason: collision with root package name */
            private final x f14498a = new x();

            C0120a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j11) {
                Long l11 = (Long) this.f14498a.e(j11);
                if (l11 == null) {
                    l11 = Long.valueOf(a.this.b());
                    this.f14498a.k(j11, l11);
                }
                return l11.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return new C0120a();
        }

        long b() {
            long j11 = this.f14497a;
            this.f14497a = 1 + j11;
            return j11;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements s {

        /* renamed from: a, reason: collision with root package name */
        private final d f14500a = new a();

        /* loaded from: classes2.dex */
        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j11) {
                return -1L;
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return this.f14500a;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements s {

        /* renamed from: a, reason: collision with root package name */
        private final d f14502a = new a();

        /* loaded from: classes2.dex */
        class a implements d {
            a() {
            }

            @Override // androidx.recyclerview.widget.s.d
            public long a(long j11) {
                return j11;
            }
        }

        @Override // androidx.recyclerview.widget.s
        public d a() {
            return this.f14502a;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        long a(long j11);
    }

    d a();
}
