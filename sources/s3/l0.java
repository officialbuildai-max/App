package s3;

import android.util.SparseArray;
import androidx.media3.common.util.p0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public interface l0 {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f75164a;

        /* renamed from: b, reason: collision with root package name */
        public final int f75165b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f75166c;

        public a(String str, int i11, byte[] bArr) {
            this.f75164a = str;
            this.f75165b = i11;
            this.f75166c = bArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f75167a;

        /* renamed from: b, reason: collision with root package name */
        public final String f75168b;

        /* renamed from: c, reason: collision with root package name */
        public final int f75169c;

        /* renamed from: d, reason: collision with root package name */
        public final List f75170d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f75171e;

        public b(int i11, String str, int i12, List list, byte[] bArr) {
            this.f75167a = i11;
            this.f75168b = str;
            this.f75169c = i12;
            this.f75170d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f75171e = bArr;
        }

        public int a() {
            int i11 = this.f75169c;
            if (i11 != 2) {
                return i11 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        l0 a(int i11, b bVar);

        SparseArray createInitialPayloadReaders();
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f75172a;

        /* renamed from: b, reason: collision with root package name */
        private final int f75173b;

        /* renamed from: c, reason: collision with root package name */
        private final int f75174c;

        /* renamed from: d, reason: collision with root package name */
        private int f75175d;

        /* renamed from: e, reason: collision with root package name */
        private String f75176e;

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
            this.f75172a = str;
            this.f75173b = i12;
            this.f75174c = i13;
            this.f75175d = Integer.MIN_VALUE;
            this.f75176e = "";
        }

        private void d() {
            if (this.f75175d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i11 = this.f75175d;
            this.f75175d = i11 == Integer.MIN_VALUE ? this.f75173b : i11 + this.f75174c;
            this.f75176e = this.f75172a + this.f75175d;
        }

        public String b() {
            d();
            return this.f75176e;
        }

        public int c() {
            d();
            return this.f75175d;
        }
    }

    void a(androidx.media3.common.util.j0 j0Var, int i11);

    void b(p0 p0Var, l2.t tVar, d dVar);

    void seek();
}
