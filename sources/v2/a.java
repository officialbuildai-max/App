package v2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;

/* loaded from: classes2.dex */
public final class a implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f77138a;

    /* renamed from: b, reason: collision with root package name */
    public final String f77139b;

    public a(int i11, String str) {
        this.f77138a = i11;
        this.f77139b = str;
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ void a(v.b bVar) {
        w.c(this, bVar);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return w.a(this);
    }

    @Override // androidx.media3.common.x.a
    public /* synthetic */ r getWrappedMetadataFormat() {
        return w.b(this);
    }

    public String toString() {
        return "Ait(controlCode=" + this.f77138a + ",url=" + this.f77139b + ")";
    }
}
