package la;

import android.os.SystemClock;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.p0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class b implements com.google.android.exoplayer2.trackselection.h {

    /* renamed from: a, reason: collision with root package name */
    protected final TrackGroup f68901a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f68902b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f68903c;

    /* renamed from: d, reason: collision with root package name */
    private final int f68904d;

    /* renamed from: e, reason: collision with root package name */
    private final o1[] f68905e;

    /* renamed from: f, reason: collision with root package name */
    private final long[] f68906f;

    /* renamed from: g, reason: collision with root package name */
    private int f68907g;

    public b(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    public b(TrackGroup trackGroup, int[] iArr, int i11) {
        int i12 = 0;
        com.google.android.exoplayer2.util.a.g(iArr.length > 0);
        this.f68904d = i11;
        this.f68901a = (TrackGroup) com.google.android.exoplayer2.util.a.e(trackGroup);
        int length = iArr.length;
        this.f68902b = length;
        this.f68905e = new o1[length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            this.f68905e[i13] = trackGroup.c(iArr[i13]);
        }
        Arrays.sort(this.f68905e, new Comparator() { // from class: la.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i14;
                i14 = b.i((o1) obj, (o1) obj2);
                return i14;
            }
        });
        this.f68903c = new int[this.f68902b];
        while (true) {
            int i14 = this.f68902b;
            if (i12 >= i14) {
                this.f68906f = new long[i14];
                return;
            } else {
                this.f68903c[i12] = trackGroup.d(this.f68905e[i12]);
                i12++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(o1 o1Var, o1 o1Var2) {
        return o1Var2.f25546h - o1Var.f25546h;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public /* synthetic */ void a() {
        k.a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public /* synthetic */ void b(boolean z10) {
        k.b(this, z10);
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public boolean blacklist(int i11, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean e11 = e(i11, elapsedRealtime);
        int i12 = 0;
        while (i12 < this.f68902b && !e11) {
            e11 = (i12 == i11 || e(i12, elapsedRealtime)) ? false : true;
            i12++;
        }
        if (!e11) {
            return false;
        }
        long[] jArr = this.f68906f;
        jArr[i11] = Math.max(jArr[i11], p0.b(elapsedRealtime, j11, Long.MAX_VALUE));
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public /* synthetic */ void c() {
        k.c(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public void disable() {
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public boolean e(int i11, long j11) {
        return this.f68906f[i11] > j11;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public void enable() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f68901a == bVar.f68901a && Arrays.equals(this.f68903c, bVar.f68903c);
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public int evaluateQueueSize(long j11, List list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public /* synthetic */ boolean f(long j11, v9.f fVar, List list) {
        return k.d(this, j11, fVar, list);
    }

    @Override // la.m
    public final int g(o1 o1Var) {
        for (int i11 = 0; i11 < this.f68902b; i11++) {
            if (this.f68905e[i11] == o1Var) {
                return i11;
            }
        }
        return -1;
    }

    @Override // la.m
    public final o1 getFormat(int i11) {
        return this.f68905e[i11];
    }

    @Override // la.m
    public final int getIndexInTrackGroup(int i11) {
        return this.f68903c[i11];
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public final o1 getSelectedFormat() {
        return this.f68905e[getSelectedIndex()];
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public final int getSelectedIndexInTrackGroup() {
        return this.f68903c[getSelectedIndex()];
    }

    @Override // la.m
    public final TrackGroup getTrackGroup() {
        return this.f68901a;
    }

    public int hashCode() {
        if (this.f68907g == 0) {
            this.f68907g = (System.identityHashCode(this.f68901a) * 31) + Arrays.hashCode(this.f68903c);
        }
        return this.f68907g;
    }

    @Override // la.m
    public final int indexOf(int i11) {
        for (int i12 = 0; i12 < this.f68902b; i12++) {
            if (this.f68903c[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Override // la.m
    public final int length() {
        return this.f68903c.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.h
    public void onPlaybackSpeed(float f11) {
    }
}
