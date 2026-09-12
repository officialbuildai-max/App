package la;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class o implements com.google.android.exoplayer2.k {

    /* renamed from: c, reason: collision with root package name */
    public static final k.a f68918c = new k.a() { // from class: la.n
        @Override // com.google.android.exoplayer2.k.a
        public final com.google.android.exoplayer2.k a(Bundle bundle) {
            o d11;
            d11 = o.d(bundle);
            return d11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final TrackGroup f68919a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f68920b;

    public o(TrackGroup trackGroup, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.f25727a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f68919a = trackGroup;
        this.f68920b = ImmutableList.copyOf((Collection) list);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o d(Bundle bundle) {
        return new o((TrackGroup) TrackGroup.f25726f.a((Bundle) com.google.android.exoplayer2.util.a.e(bundle.getBundle(c(0)))), Ints.c((int[]) com.google.android.exoplayer2.util.a.e(bundle.getIntArray(c(1)))));
    }

    public int b() {
        return this.f68919a.f25729c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f68919a.equals(oVar.f68919a) && this.f68920b.equals(oVar.f68920b);
    }

    public int hashCode() {
        return this.f68919a.hashCode() + (this.f68920b.hashCode() * 31);
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c(0), this.f68919a.toBundle());
        bundle.putIntArray(c(1), Ints.o(this.f68920b));
        return bundle;
    }
}
