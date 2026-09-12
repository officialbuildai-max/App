package ha;

import ba.i;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
final class b implements i {

    /* renamed from: a, reason: collision with root package name */
    private final ba.b[] f64533a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f64534b;

    public b(ba.b[] bVarArr, long[] jArr) {
        this.f64533a = bVarArr;
        this.f64534b = jArr;
    }

    @Override // ba.i
    public List getCues(long j11) {
        ba.b bVar;
        int i11 = p0.i(this.f64534b, j11, true, false);
        return (i11 == -1 || (bVar = this.f64533a[i11]) == ba.b.f16331r) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // ba.i
    public long getEventTime(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 >= 0);
        com.google.android.exoplayer2.util.a.a(i11 < this.f64534b.length);
        return this.f64534b[i11];
    }

    @Override // ba.i
    public int getEventTimeCount() {
        return this.f64534b.length;
    }

    @Override // ba.i
    public int getNextEventTimeIndex(long j11) {
        int e11 = p0.e(this.f64534b, j11, false, false);
        if (e11 < this.f64534b.length) {
            return e11;
        }
        return -1;
    }
}
