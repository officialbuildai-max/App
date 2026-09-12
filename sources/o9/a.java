package o9;

import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f70870a;

    /* renamed from: o9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0886a extends a {

        /* renamed from: b, reason: collision with root package name */
        public final long f70871b;

        /* renamed from: c, reason: collision with root package name */
        public final List f70872c;

        /* renamed from: d, reason: collision with root package name */
        public final List f70873d;

        public C0886a(int i11, long j11) {
            super(i11);
            this.f70871b = j11;
            this.f70872c = new ArrayList();
            this.f70873d = new ArrayList();
        }

        public void d(C0886a c0886a) {
            this.f70873d.add(c0886a);
        }

        public void e(b bVar) {
            this.f70872c.add(bVar);
        }

        public C0886a f(int i11) {
            int size = this.f70873d.size();
            for (int i12 = 0; i12 < size; i12++) {
                C0886a c0886a = (C0886a) this.f70873d.get(i12);
                if (c0886a.f70870a == i11) {
                    return c0886a;
                }
            }
            return null;
        }

        public b g(int i11) {
            int size = this.f70872c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b bVar = (b) this.f70872c.get(i12);
                if (bVar.f70870a == i11) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // o9.a
        public String toString() {
            return a.a(this.f70870a) + " leaves: " + Arrays.toString(this.f70872c.toArray()) + " containers: " + Arrays.toString(this.f70873d.toArray());
        }
    }

    /* loaded from: classes4.dex */
    static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final d0 f70874b;

        public b(int i11, d0 d0Var) {
            super(i11);
            this.f70874b = d0Var;
        }
    }

    public a(int i11) {
        this.f70870a = i11;
    }

    public static String a(int i11) {
        return "" + ((char) ((i11 >> 24) & 255)) + ((char) ((i11 >> 16) & 255)) + ((char) ((i11 >> 8) & 255)) + ((char) (i11 & 255));
    }

    public static int b(int i11) {
        return i11 & 16777215;
    }

    public static int c(int i11) {
        return (i11 >> 24) & 255;
    }

    public String toString() {
        return a(this.f70870a);
    }
}
