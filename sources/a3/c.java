package a3;

import a3.c;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.collect.h2;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f217a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final Comparator f218d = new Comparator() { // from class: a3.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b11;
                b11 = c.a.b((c.a) obj, (c.a) obj2);
                return b11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f219a;

        /* renamed from: b, reason: collision with root package name */
        public final long f220b;

        /* renamed from: c, reason: collision with root package name */
        public final int f221c;

        public a(long j11, long j12, int i11) {
            androidx.media3.common.util.a.a(j11 < j12);
            this.f219a = j11;
            this.f220b = j12;
            this.f221c = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(a aVar, a aVar2) {
            return h2.k().e(aVar.f219a, aVar2.f219a).e(aVar.f220b, aVar2.f220b).d(aVar.f221c, aVar2.f221c).j();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f219a == aVar.f219a && this.f220b == aVar.f220b && this.f221c == aVar.f221c;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f219a), Long.valueOf(this.f220b), Integer.valueOf(this.f221c));
        }

        public String toString() {
            return a1.G("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.f219a), Long.valueOf(this.f220b), Integer.valueOf(this.f221c));
        }
    }

    public c(List list) {
        this.f217a = list;
        androidx.media3.common.util.a.a(!b(list));
    }

    private static boolean b(List list) {
        if (list.isEmpty()) {
            return false;
        }
        long j11 = ((a) list.get(0)).f220b;
        for (int i11 = 1; i11 < list.size(); i11++) {
            if (((a) list.get(i11)).f219a < j11) {
                return true;
            }
            j11 = ((a) list.get(i11)).f220b;
        }
        return false;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f217a.equals(((c) obj).f217a);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public int hashCode() {
        return this.f217a.hashCode();
    }

    public String toString() {
        return "SlowMotion: segments=" + this.f217a;
    }
}
