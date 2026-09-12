package j2;

import android.os.SystemClock;
import androidx.media3.common.util.a1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c implements z {

    /* renamed from: a, reason: collision with root package name */
    protected final androidx.media3.common.f0 f65866a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f65867b;

    /* renamed from: c, reason: collision with root package name */
    protected final int[] f65868c;

    /* renamed from: d, reason: collision with root package name */
    private final int f65869d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.media3.common.r[] f65870e;

    /* renamed from: f, reason: collision with root package name */
    private final long[] f65871f;

    /* renamed from: g, reason: collision with root package name */
    private int f65872g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f65873h;

    public c(androidx.media3.common.f0 f0Var, int... iArr) {
        this(f0Var, iArr, 0);
    }

    public c(androidx.media3.common.f0 f0Var, int[] iArr, int i11) {
        androidx.media3.common.util.a.g(iArr.length > 0);
        this.f65869d = i11;
        this.f65866a = (androidx.media3.common.f0) androidx.media3.common.util.a.e(f0Var);
        int length = iArr.length;
        this.f65867b = length;
        this.f65870e = new androidx.media3.common.r[length];
        for (int i12 = 0; i12 < iArr.length; i12++) {
            this.f65870e[i12] = f0Var.a(iArr[i12]);
        }
        Arrays.sort(this.f65870e, new Comparator() { // from class: j2.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int j11;
                j11 = c.j((androidx.media3.common.r) obj, (androidx.media3.common.r) obj2);
                return j11;
            }
        });
        this.f65868c = new int[this.f65867b];
        int i13 = 0;
        while (true) {
            int i14 = this.f65867b;
            if (i13 >= i14) {
                this.f65871f = new long[i14];
                this.f65873h = false;
                return;
            } else {
                this.f65868c[i13] = f0Var.b(this.f65870e[i13]);
                i13++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(androidx.media3.common.r rVar, androidx.media3.common.r rVar2) {
        return rVar2.f10238j - rVar.f10238j;
    }

    @Override // j2.z
    public /* synthetic */ void a() {
        y.a(this);
    }

    @Override // j2.z
    public void b(boolean z10) {
        this.f65873h = z10;
    }

    @Override // j2.z
    public /* synthetic */ void c() {
        y.b(this);
    }

    @Override // j2.z
    public boolean d(int i11, long j11) {
        return this.f65871f[i11] > j11;
    }

    @Override // j2.z
    public void disable() {
    }

    @Override // j2.z
    public void enable() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f65866a.equals(cVar.f65866a) && Arrays.equals(this.f65868c, cVar.f65868c);
    }

    @Override // j2.z
    public int evaluateQueueSize(long j11, List list) {
        return list.size();
    }

    @Override // j2.c0
    public final int f(androidx.media3.common.r rVar) {
        for (int i11 = 0; i11 < this.f65867b; i11++) {
            if (this.f65870e[i11] == rVar) {
                return i11;
            }
        }
        return -1;
    }

    @Override // j2.z
    public boolean g(int i11, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean d11 = d(i11, elapsedRealtime);
        int i12 = 0;
        while (i12 < this.f65867b && !d11) {
            d11 = (i12 == i11 || d(i12, elapsedRealtime)) ? false : true;
            i12++;
        }
        if (!d11) {
            return false;
        }
        long[] jArr = this.f65871f;
        jArr[i11] = Math.max(jArr[i11], a1.c(elapsedRealtime, j11, Long.MAX_VALUE));
        return true;
    }

    @Override // j2.c0
    public final androidx.media3.common.r getFormat(int i11) {
        return this.f65870e[i11];
    }

    @Override // j2.c0
    public final int getIndexInTrackGroup(int i11) {
        return this.f65868c[i11];
    }

    @Override // j2.z
    public final androidx.media3.common.r getSelectedFormat() {
        return this.f65870e[getSelectedIndex()];
    }

    @Override // j2.z
    public final int getSelectedIndexInTrackGroup() {
        return this.f65868c[getSelectedIndex()];
    }

    @Override // j2.c0
    public final androidx.media3.common.f0 getTrackGroup() {
        return this.f65866a;
    }

    @Override // j2.z
    public /* synthetic */ boolean h(long j11, h2.e eVar, List list) {
        return y.c(this, j11, eVar, list);
    }

    public int hashCode() {
        if (this.f65872g == 0) {
            this.f65872g = (System.identityHashCode(this.f65866a) * 31) + Arrays.hashCode(this.f65868c);
        }
        return this.f65872g;
    }

    @Override // j2.c0
    public final int indexOf(int i11) {
        for (int i12 = 0; i12 < this.f65867b; i12++) {
            if (this.f65868c[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Override // j2.c0
    public final int length() {
        return this.f65868c.length;
    }

    @Override // j2.z
    public void onPlaybackSpeed(float f11) {
    }
}
