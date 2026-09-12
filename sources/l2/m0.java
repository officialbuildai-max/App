package l2;

/* loaded from: classes2.dex */
public interface m0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final n0 f68767a;

        /* renamed from: b, reason: collision with root package name */
        public final n0 f68768b;

        public a(n0 n0Var) {
            this(n0Var, n0Var);
        }

        public a(n0 n0Var, n0 n0Var2) {
            this.f68767a = (n0) androidx.media3.common.util.a.e(n0Var);
            this.f68768b = (n0) androidx.media3.common.util.a.e(n0Var2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f68767a.equals(aVar.f68767a) && this.f68768b.equals(aVar.f68768b);
        }

        public int hashCode() {
            return (this.f68767a.hashCode() * 31) + this.f68768b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f68767a);
            if (this.f68767a.equals(this.f68768b)) {
                str = "";
            } else {
                str = ", " + this.f68768b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f68769a;

        /* renamed from: b, reason: collision with root package name */
        private final a f68770b;

        public b(long j11) {
            this(j11, 0L);
        }

        public b(long j11, long j12) {
            this.f68769a = j11;
            this.f68770b = new a(j12 == 0 ? n0.f68772c : new n0(0L, j12));
        }

        @Override // l2.m0
        public long getDurationUs() {
            return this.f68769a;
        }

        @Override // l2.m0
        public a getSeekPoints(long j11) {
            return this.f68770b;
        }

        @Override // l2.m0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j11);

    boolean isSeekable();
}
