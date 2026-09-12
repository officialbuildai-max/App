package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface t {

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final w f12330a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f12331b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.media3.common.r f12332c;

        /* renamed from: d, reason: collision with root package name */
        public final Surface f12333d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaCrypto f12334e;

        /* renamed from: f, reason: collision with root package name */
        public final p f12335f;

        private a(w wVar, MediaFormat mediaFormat, androidx.media3.common.r rVar, Surface surface, MediaCrypto mediaCrypto, p pVar) {
            this.f12330a = wVar;
            this.f12331b = mediaFormat;
            this.f12332c = rVar;
            this.f12333d = surface;
            this.f12334e = mediaCrypto;
            this.f12335f = pVar;
        }

        public static a a(w wVar, MediaFormat mediaFormat, androidx.media3.common.r rVar, MediaCrypto mediaCrypto, p pVar) {
            return new a(wVar, mediaFormat, rVar, null, mediaCrypto, pVar);
        }

        public static a b(w wVar, MediaFormat mediaFormat, androidx.media3.common.r rVar, Surface surface, MediaCrypto mediaCrypto) {
            return new a(wVar, mediaFormat, rVar, surface, mediaCrypto, null);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f12336a = new k();

        t a(a aVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(t tVar, long j11, long j12);
    }

    void a(int i11, int i12, int i13, long j11, int i14);

    void b(Bundle bundle);

    MediaFormat c();

    ByteBuffer d(int i11);

    void e(Surface surface);

    void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13);

    void flush();

    boolean g();

    void h(int i11, long j11);

    int i();

    int j(MediaCodec.BufferInfo bufferInfo);

    void k(int i11, boolean z10);

    ByteBuffer l(int i11);

    boolean m(c cVar);

    void n(d dVar, Handler handler);

    void o();

    void release();

    void setVideoScalingMode(int i11);
}
