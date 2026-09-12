package i3;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public interface s {

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f65046a = new C0813a();

        /* renamed from: i3.s$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0813a implements a {
            C0813a() {
            }

            @Override // i3.s.a
            public boolean a(androidx.media3.common.r rVar) {
                return false;
            }

            @Override // i3.s.a
            public int b(androidx.media3.common.r rVar) {
                return 1;
            }

            @Override // i3.s.a
            public s c(androidx.media3.common.r rVar) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        }

        boolean a(androidx.media3.common.r rVar);

        int b(androidx.media3.common.r rVar);

        s c(androidx.media3.common.r rVar);
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        private static final b f65047c = new b(C.TIME_UNSET, false);

        /* renamed from: a, reason: collision with root package name */
        public final long f65048a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f65049b;

        private b(long j11, boolean z10) {
            this.f65048a = j11;
            this.f65049b = z10;
        }

        public static b b() {
            return f65047c;
        }

        public static b c(long j11) {
            return new b(j11, true);
        }
    }

    void a(byte[] bArr, int i11, int i12, b bVar, androidx.media3.common.util.m mVar);

    k b(byte[] bArr, int i11, int i12);

    int c();

    void reset();
}
