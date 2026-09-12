package androidx.media3.container;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;

/* loaded from: classes2.dex */
public final class c implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f10664a;

    public c(int i11) {
        this.f10664a = i11;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f10664a == ((c) obj).f10664a;
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
        return this.f10664a;
    }

    public String toString() {
        return "Mp4AlternateGroup: " + this.f10664a;
    }
}
