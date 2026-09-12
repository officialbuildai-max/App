package a3;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.primitives.Longs;

/* loaded from: classes.dex */
public final class a implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f212a;

    /* renamed from: b, reason: collision with root package name */
    public final long f213b;

    /* renamed from: c, reason: collision with root package name */
    public final long f214c;

    /* renamed from: d, reason: collision with root package name */
    public final long f215d;

    /* renamed from: e, reason: collision with root package name */
    public final long f216e;

    public a(long j11, long j12, long j13, long j14, long j15) {
        this.f212a = j11;
        this.f213b = j12;
        this.f214c = j13;
        this.f215d = j14;
        this.f216e = j15;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f212a == aVar.f212a && this.f213b == aVar.f213b && this.f214c == aVar.f214c && this.f215d == aVar.f215d && this.f216e == aVar.f216e;
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
        return ((((((((527 + Longs.e(this.f212a)) * 31) + Longs.e(this.f213b)) * 31) + Longs.e(this.f214c)) * 31) + Longs.e(this.f215d)) * 31) + Longs.e(this.f216e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f212a + ", photoSize=" + this.f213b + ", photoPresentationTimestampUs=" + this.f214c + ", videoStartPosition=" + this.f215d + ", videoSize=" + this.f216e;
    }
}
