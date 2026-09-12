package androidx.media3.container;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import com.google.common.primitives.Floats;

/* loaded from: classes2.dex */
public final class e implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final float f10670a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10671b;

    public e(float f11, float f12) {
        androidx.media3.common.util.a.b(f11 >= -90.0f && f11 <= 90.0f && f12 >= -180.0f && f12 <= 180.0f, "Invalid latitude or longitude");
        this.f10670a = f11;
        this.f10671b = f12;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f10670a == eVar.f10670a && this.f10671b == eVar.f10671b;
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
        return ((527 + Floats.a(this.f10670a)) * 31) + Floats.a(this.f10671b);
    }

    public String toString() {
        return "xyz: latitude=" + this.f10670a + ", longitude=" + this.f10671b;
    }
}
