package y2;

import androidx.media3.common.r;
import androidx.media3.common.v;
import androidx.media3.common.w;
import androidx.media3.common.x;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c implements x.a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f78943a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78944b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78945c;

    public c(byte[] bArr, String str, String str2) {
        this.f78943a = bArr;
        this.f78944b = str;
        this.f78945c = str2;
    }

    @Override // androidx.media3.common.x.a
    public void a(v.b bVar) {
        String str = this.f78944b;
        if (str != null) {
            bVar.p0(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f78943a, ((c) obj).f78943a);
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
        return Arrays.hashCode(this.f78943a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f78944b, this.f78945c, Integer.valueOf(this.f78943a.length));
    }
}
