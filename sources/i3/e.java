package i3;

import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableList f65019a;

    /* renamed from: b, reason: collision with root package name */
    public final long f65020b;

    /* renamed from: c, reason: collision with root package name */
    public final long f65021c;

    /* renamed from: d, reason: collision with root package name */
    public final long f65022d;

    public e(List list, long j11, long j12) {
        this.f65019a = ImmutableList.copyOf((Collection) list);
        this.f65020b = j11;
        this.f65021c = j12;
        long j13 = C.TIME_UNSET;
        if (j11 != C.TIME_UNSET && j12 != C.TIME_UNSET) {
            j13 = j11 + j12;
        }
        this.f65022d = j13;
    }
}
