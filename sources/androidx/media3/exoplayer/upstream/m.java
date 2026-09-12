package androidx.media3.exoplayer.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface m {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13086a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13087b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13088c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13089d;

        public a(int i11, int i12, int i13, int i14) {
            this.f13086a = i11;
            this.f13087b = i12;
            this.f13088c = i13;
            this.f13089d = i14;
        }

        public boolean a(int i11) {
            if (i11 == 1) {
                if (this.f13086a - this.f13087b <= 1) {
                    return false;
                }
            } else if (this.f13088c - this.f13089d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f13090a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13091b;

        public b(int i11, long j11) {
            androidx.media3.common.util.a.a(j11 >= 0);
            this.f13090a = i11;
            this.f13091b = j11;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final g2.i f13092a;

        /* renamed from: b, reason: collision with root package name */
        public final g2.j f13093b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f13094c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13095d;

        public c(g2.i iVar, g2.j jVar, IOException iOException, int i11) {
            this.f13092a = iVar;
            this.f13093b = jVar;
            this.f13094c = iOException;
            this.f13095d = i11;
        }
    }

    int a(int i11);

    void b(long j11);

    long c(c cVar);

    b d(a aVar, c cVar);
}
