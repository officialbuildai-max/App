package androidx.media3.common;

import androidx.media3.common.util.a1;
import androidx.media3.common.v;
import com.google.common.primitives.Longs;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final a[] f10639a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10640b;

    /* loaded from: classes.dex */
    public interface a {
        void a(v.b bVar);

        byte[] getWrappedMetadataBytes();

        r getWrappedMetadataFormat();
    }

    public x(long j11, List list) {
        this(j11, (a[]) list.toArray(new a[0]));
    }

    public x(long j11, a... aVarArr) {
        this.f10640b = j11;
        this.f10639a = aVarArr;
    }

    public x(List list) {
        this((a[]) list.toArray(new a[0]));
    }

    public x(a... aVarArr) {
        this(C.TIME_UNSET, aVarArr);
    }

    public x a(a... aVarArr) {
        return aVarArr.length == 0 ? this : new x(this.f10640b, (a[]) a1.W0(this.f10639a, aVarArr));
    }

    public x b(x xVar) {
        return xVar == null ? this : a(xVar.f10639a);
    }

    public x c(long j11) {
        return this.f10640b == j11 ? this : new x(j11, this.f10639a);
    }

    public a d(int i11) {
        return this.f10639a[i11];
    }

    public int e() {
        return this.f10639a.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return Arrays.equals(this.f10639a, xVar.f10639a) && this.f10640b == xVar.f10640b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f10639a) * 31) + Longs.e(this.f10640b);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("entries=");
        sb2.append(Arrays.toString(this.f10639a));
        if (this.f10640b == C.TIME_UNSET) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + this.f10640b;
        }
        sb2.append(str);
        return sb2.toString();
    }
}
