package u9;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import u9.c;

/* loaded from: classes4.dex */
public final class c implements k {

    /* renamed from: g, reason: collision with root package name */
    public static final c f76812g = new c(null, new a[0], 0, C.TIME_UNSET, 0);

    /* renamed from: h, reason: collision with root package name */
    private static final a f76813h = new a(0).j(0);

    /* renamed from: i, reason: collision with root package name */
    public static final k.a f76814i = new k.a() { // from class: u9.a
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            c b11;
            b11 = c.b(bundle);
            return b11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Object f76815a;

    /* renamed from: b, reason: collision with root package name */
    public final int f76816b;

    /* renamed from: c, reason: collision with root package name */
    public final long f76817c;

    /* renamed from: d, reason: collision with root package name */
    public final long f76818d;

    /* renamed from: e, reason: collision with root package name */
    public final int f76819e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f76820f;

    /* loaded from: classes4.dex */
    public static final class a implements k {

        /* renamed from: h, reason: collision with root package name */
        public static final k.a f76821h = new k.a() { // from class: u9.b
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                c.a d11;
                d11 = c.a.d(bundle);
                return d11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f76822a;

        /* renamed from: b, reason: collision with root package name */
        public final int f76823b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri[] f76824c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f76825d;

        /* renamed from: e, reason: collision with root package name */
        public final long[] f76826e;

        /* renamed from: f, reason: collision with root package name */
        public final long f76827f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f76828g;

        public a(long j11) {
            this(j11, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        private a(long j11, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j12, boolean z10) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.f76822a = j11;
            this.f76823b = i11;
            this.f76825d = iArr;
            this.f76824c = uriArr;
            this.f76826e = jArr;
            this.f76827f = j12;
            this.f76828g = z10;
        }

        private static long[] b(long[] jArr, int i11) {
            int length = jArr.length;
            int max = Math.max(i11, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.TIME_UNSET);
            return copyOf;
        }

        private static int[] c(int[] iArr, int i11) {
            int length = iArr.length;
            int max = Math.max(i11, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a d(Bundle bundle) {
            long j11 = bundle.getLong(h(0));
            int i11 = bundle.getInt(h(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h(2));
            int[] intArray = bundle.getIntArray(h(3));
            long[] longArray = bundle.getLongArray(h(4));
            long j12 = bundle.getLong(h(5));
            boolean z10 = bundle.getBoolean(h(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            return new a(j11, i11, intArray, parcelableArrayList == null ? new Uri[0] : (Uri[]) parcelableArrayList.toArray(new Uri[0]), longArray == null ? new long[0] : longArray, j12, z10);
        }

        private static String h(int i11) {
            return Integer.toString(i11, 36);
        }

        public int e() {
            return f(-1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f76822a == aVar.f76822a && this.f76823b == aVar.f76823b && Arrays.equals(this.f76824c, aVar.f76824c) && Arrays.equals(this.f76825d, aVar.f76825d) && Arrays.equals(this.f76826e, aVar.f76826e) && this.f76827f == aVar.f76827f && this.f76828g == aVar.f76828g;
        }

        public int f(int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.f76825d;
                if (i13 >= iArr.length || this.f76828g || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public boolean g() {
            if (this.f76823b == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.f76823b; i11++) {
                int i12 = this.f76825d[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i11 = this.f76823b * 31;
            long j11 = this.f76822a;
            int hashCode = (((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f76824c)) * 31) + Arrays.hashCode(this.f76825d)) * 31) + Arrays.hashCode(this.f76826e)) * 31;
            long j12 = this.f76827f;
            return ((hashCode + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f76828g ? 1 : 0);
        }

        public boolean i() {
            return this.f76823b == -1 || e() < this.f76823b;
        }

        public a j(int i11) {
            int[] c11 = c(this.f76825d, i11);
            long[] b11 = b(this.f76826e, i11);
            return new a(this.f76822a, i11, c11, (Uri[]) Arrays.copyOf(this.f76824c, i11), b11, this.f76827f, this.f76828g);
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(h(0), this.f76822a);
            bundle.putInt(h(1), this.f76823b);
            bundle.putParcelableArrayList(h(2), new ArrayList<>(Arrays.asList(this.f76824c)));
            bundle.putIntArray(h(3), this.f76825d);
            bundle.putLongArray(h(4), this.f76826e);
            bundle.putLong(h(5), this.f76827f);
            bundle.putBoolean(h(6), this.f76828g);
            return bundle;
        }
    }

    private c(Object obj, a[] aVarArr, long j11, long j12, int i11) {
        this.f76815a = obj;
        this.f76817c = j11;
        this.f76818d = j12;
        this.f76816b = aVarArr.length + i11;
        this.f76820f = aVarArr;
        this.f76819e = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c b(Bundle bundle) {
        a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g(1));
        if (parcelableArrayList == null) {
            aVarArr = new a[0];
        } else {
            a[] aVarArr2 = new a[parcelableArrayList.size()];
            for (int i11 = 0; i11 < parcelableArrayList.size(); i11++) {
                aVarArr2[i11] = (a) a.f76821h.a((Bundle) parcelableArrayList.get(i11));
            }
            aVarArr = aVarArr2;
        }
        return new c(null, aVarArr, bundle.getLong(g(2), 0L), bundle.getLong(g(3), C.TIME_UNSET), bundle.getInt(g(4)));
    }

    private boolean f(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        long j13 = c(i11).f76822a;
        return j13 == Long.MIN_VALUE ? j12 == C.TIME_UNSET || j11 < j12 : j11 < j13;
    }

    private static String g(int i11) {
        return Integer.toString(i11, 36);
    }

    public a c(int i11) {
        int i12 = this.f76819e;
        return i11 < i12 ? f76813h : this.f76820f[i11 - i12];
    }

    public int d(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.f76819e;
        while (i11 < this.f76816b && ((c(i11).f76822a != Long.MIN_VALUE && c(i11).f76822a <= j11) || !c(i11).i())) {
            i11++;
        }
        if (i11 < this.f76816b) {
            return i11;
        }
        return -1;
    }

    public int e(long j11, long j12) {
        int i11 = this.f76816b - 1;
        while (i11 >= 0 && f(j11, j12, i11)) {
            i11--;
        }
        if (i11 < 0 || !c(i11).g()) {
            return -1;
        }
        return i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return p0.c(this.f76815a, cVar.f76815a) && this.f76816b == cVar.f76816b && this.f76817c == cVar.f76817c && this.f76818d == cVar.f76818d && this.f76819e == cVar.f76819e && Arrays.equals(this.f76820f, cVar.f76820f);
    }

    public int hashCode() {
        int i11 = this.f76816b * 31;
        Object obj = this.f76815a;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f76817c)) * 31) + ((int) this.f76818d)) * 31) + this.f76819e) * 31) + Arrays.hashCode(this.f76820f);
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (a aVar : this.f76820f) {
            arrayList.add(aVar.toBundle());
        }
        bundle.putParcelableArrayList(g(1), arrayList);
        bundle.putLong(g(2), this.f76817c);
        bundle.putLong(g(3), this.f76818d);
        bundle.putInt(g(4), this.f76819e);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f76815a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f76817c);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.f76820f.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f76820f[i11].f76822a);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.f76820f[i11].f76825d.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.f76820f[i11].f76825d[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append('R');
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f76820f[i11].f76826e[i12]);
                sb2.append(')');
                if (i12 < this.f76820f[i11].f76825d.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.f76820f.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}
