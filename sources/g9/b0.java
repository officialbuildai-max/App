package g9;

/* loaded from: classes4.dex */
public interface b0 {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c0 f63493a;

        /* renamed from: b, reason: collision with root package name */
        public final c0 f63494b;

        public a(c0 c0Var) {
            this(c0Var, c0Var);
        }

        public a(c0 c0Var, c0 c0Var2) {
            this.f63493a = (c0) com.google.android.exoplayer2.util.a.e(c0Var);
            this.f63494b = (c0) com.google.android.exoplayer2.util.a.e(c0Var2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f63493a.equals(aVar.f63493a) && this.f63494b.equals(aVar.f63494b);
        }

        public int hashCode() {
            return (this.f63493a.hashCode() * 31) + this.f63494b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f63493a);
            if (this.f63493a.equals(this.f63494b)) {
                str = "";
            } else {
                str = ", " + this.f63494b;
            }
            sb2.append(str);
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f63495a;

        /* renamed from: b, reason: collision with root package name */
        private final a f63496b;

        public b(long j11) {
            this(j11, 0L);
        }

        public b(long j11, long j12) {
            this.f63495a = j11;
            this.f63496b = new a(j12 == 0 ? c0.f63497c : new c0(0L, j12));
        }

        @Override // g9.b0
        public long getDurationUs() {
            return this.f63495a;
        }

        @Override // g9.b0
        public a getSeekPoints(long j11) {
            return this.f63496b;
        }

        @Override // g9.b0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j11);

    boolean isSeekable();
}
