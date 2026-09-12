package q9;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.l0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public interface i0 {

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f73434a;

        /* renamed from: b, reason: collision with root package name */
        public final int f73435b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f73436c;

        public a(String str, int i11, byte[] bArr) {
            this.f73434a = str;
            this.f73435b = i11;
            this.f73436c = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f73437a;

        /* renamed from: b, reason: collision with root package name */
        public final String f73438b;

        /* renamed from: c, reason: collision with root package name */
        public final List f73439c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f73440d;

        public b(int i11, String str, List list, byte[] bArr) {
            this.f73437a = i11;
            this.f73438b = str;
            this.f73439c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f73440d = bArr;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        i0 a(int i11, b bVar);

        SparseArray createInitialPayloadReaders();
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f73441a;

        /* renamed from: b, reason: collision with root package name */
        private final int f73442b;

        /* renamed from: c, reason: collision with root package name */
        private final int f73443c;

        /* renamed from: d, reason: collision with root package name */
        private int f73444d;

        /* renamed from: e, reason: collision with root package name */
        private String f73445e;

        public d(int i11, int i12) {
            this(Integer.MIN_VALUE, i11, i12);
        }

        public d(int i11, int i12, int i13) {
            String str;
            if (i11 != Integer.MIN_VALUE) {
                str = i11 + "/";
            } else {
                str = "";
            }
            this.f73441a = str;
            this.f73442b = i12;
            this.f73443c = i13;
            this.f73444d = Integer.MIN_VALUE;
            this.f73445e = "";
        }

        private void d() {
            if (this.f73444d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i11 = this.f73444d;
            this.f73444d = i11 == Integer.MIN_VALUE ? this.f73442b : i11 + this.f73443c;
            this.f73445e = this.f73441a + this.f73444d;
        }

        public String b() {
            d();
            return this.f73445e;
        }

        public int c() {
            d();
            return this.f73444d;
        }
    }

    void a(com.google.android.exoplayer2.util.d0 d0Var, int i11);

    void b(l0 l0Var, g9.n nVar, d dVar);

    void seek();
}
