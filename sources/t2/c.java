package t2;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* loaded from: classes2.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f76124a;

    /* renamed from: b, reason: collision with root package name */
    public final List f76125b;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f76126a;

        /* renamed from: b, reason: collision with root package name */
        public final String f76127b;

        /* renamed from: c, reason: collision with root package name */
        public final long f76128c;

        /* renamed from: d, reason: collision with root package name */
        public final long f76129d;

        public a(String str, String str2, long j11, long j12) {
            this.f76126a = str;
            this.f76127b = str2;
            this.f76128c = j11;
            this.f76129d = j12;
        }
    }

    public c(long j11, List list) {
        this.f76124a = j11;
        this.f76125b = list;
    }

    public a3.a a(long j11) {
        long j12;
        if (this.f76125b.size() < 2) {
            return null;
        }
        long j13 = j11;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        long j17 = -1;
        boolean z10 = false;
        for (int size = this.f76125b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f76125b.get(size);
            boolean equals = MimeTypes.VIDEO_MP4.equals(aVar.f76126a) | z10;
            if (size == 0) {
                j13 -= aVar.f76129d;
                j12 = 0;
            } else {
                j12 = j13 - aVar.f76128c;
            }
            long j18 = j13;
            j13 = j12;
            if (!equals || j13 == j18) {
                z10 = equals;
            } else {
                j17 = j18 - j13;
                j16 = j13;
                z10 = false;
            }
            if (size == 0) {
                j14 = j13;
                j15 = j18;
            }
        }
        if (j16 == -1 || j17 == -1 || j14 == -1 || j15 == -1) {
            return null;
        }
        return new a3.a(j14, j15, this.f76124a, j16, j17);
    }
}
