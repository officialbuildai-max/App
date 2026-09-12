package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.o1;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface l {

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final m f25446a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f25447b;

        /* renamed from: c, reason: collision with root package name */
        public final o1 f25448c;

        /* renamed from: d, reason: collision with root package name */
        public final Surface f25449d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaCrypto f25450e;

        /* renamed from: f, reason: collision with root package name */
        public final int f25451f;

        private a(m mVar, MediaFormat mediaFormat, o1 o1Var, Surface surface, MediaCrypto mediaCrypto, int i11) {
            this.f25446a = mVar;
            this.f25447b = mediaFormat;
            this.f25448c = o1Var;
            this.f25449d = surface;
            this.f25450e = mediaCrypto;
            this.f25451f = i11;
        }

        public static a a(m mVar, MediaFormat mediaFormat, o1 o1Var, MediaCrypto mediaCrypto) {
            return new a(mVar, mediaFormat, o1Var, null, mediaCrypto, 0);
        }

        public static a b(m mVar, MediaFormat mediaFormat, o1 o1Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(mVar, mediaFormat, o1Var, surface, mediaCrypto, 0);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        l a(a aVar);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(l lVar, long j11, long j12);
    }

    void a(int i11, int i12, int i13, long j11, int i14);

    void b(Bundle bundle);

    MediaFormat c();

    ByteBuffer d(int i11);

    void e(Surface surface);

    void f(int i11, int i12, com.google.android.exoplayer2.decoder.c cVar, long j11, int i13);

    void flush();

    boolean g();

    void h(int i11, long j11);

    int i();

    int j(MediaCodec.BufferInfo bufferInfo);

    void k(int i11, boolean z10);

    ByteBuffer l(int i11);

    void m(c cVar, Handler handler);

    void release();

    void setVideoScalingMode(int i11);
}
