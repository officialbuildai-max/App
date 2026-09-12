package androidx.media3.exoplayer.hls;

import android.util.SparseArray;
import androidx.media3.common.util.p0;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f12079a = new SparseArray();

    public p0 a(int i11) {
        p0 p0Var = (p0) this.f12079a.get(i11);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(9223372036854775806L);
        this.f12079a.put(i11, p0Var2);
        return p0Var2;
    }

    public void b() {
        this.f12079a.clear();
    }
}
