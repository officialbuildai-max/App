package l9;

import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f68887a;

    /* renamed from: b, reason: collision with root package name */
    public final List f68888b;

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f68889a;

        /* renamed from: b, reason: collision with root package name */
        public final String f68890b;

        /* renamed from: c, reason: collision with root package name */
        public final long f68891c;

        /* renamed from: d, reason: collision with root package name */
        public final long f68892d;

        public a(String str, String str2, long j11, long j12) {
            this.f68889a = str;
            this.f68890b = str2;
            this.f68891c = j11;
            this.f68892d = j12;
        }
    }

    public b(long j11, List list) {
        this.f68887a = j11;
        this.f68888b = list;
    }

    public MotionPhotoMetadata a(long j11) {
        long j12;
        if (this.f68888b.size() < 2) {
            return null;
        }
        long j13 = j11;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        long j17 = -1;
        boolean z10 = false;
        for (int size = this.f68888b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.f68888b.get(size);
            boolean equals = MimeTypes.VIDEO_MP4.equals(aVar.f68889a) | z10;
            if (size == 0) {
                j13 -= aVar.f68892d;
                j12 = 0;
            } else {
                j12 = j13 - aVar.f68891c;
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
        return new MotionPhotoMetadata(j14, j15, this.f68887a, j16, j17);
    }
}
