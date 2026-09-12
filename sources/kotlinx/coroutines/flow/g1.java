package kotlinx.coroutines.flow;

/* loaded from: classes7.dex */
public interface g1 {

    /* renamed from: a */
    public static final a f67906a = a.f67907a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a */
        static final /* synthetic */ a f67907a = new a();

        /* renamed from: b */
        private static final g1 f67908b = new h1();

        /* renamed from: c */
        private static final g1 f67909c = new StartedLazily();

        private a() {
        }

        public static /* synthetic */ g1 b(a aVar, long j11, long j12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            if ((i11 & 2) != 0) {
                j12 = Long.MAX_VALUE;
            }
            return aVar.a(j11, j12);
        }

        public final g1 a(long j11, long j12) {
            return new StartedWhileSubscribed(j11, j12);
        }

        public final g1 c() {
            return f67908b;
        }

        public final g1 d() {
            return f67909c;
        }
    }

    b a(i1 i1Var);
}
