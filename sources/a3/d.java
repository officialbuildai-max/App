package a3;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.primitives.Floats;

/* loaded from: classes.dex */
public final class d implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f222a;

    /* renamed from: b, reason: collision with root package name */
    public final int f223b;

    public d(float f11, int i11) {
        this.f222a = f11;
        this.f223b = i11;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f222a == dVar.f222a && this.f223b == dVar.f223b;
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
        return ((527 + Floats.a(this.f222a)) * 31) + this.f223b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f222a + ", svcTemporalLayerCount=" + this.f223b;
    }
}
