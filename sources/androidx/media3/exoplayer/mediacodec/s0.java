package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s0 implements v {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f12329a;

    public s0(MediaCodec mediaCodec) {
        this.f12329a = mediaCodec;
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void a(int i11, int i12, int i13, long j11, int i14) {
        this.f12329a.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void b(Bundle bundle) {
        this.f12329a.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void c() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void f(int i11, int i12, androidx.media3.decoder.c cVar, long j11, int i13) {
        this.f12329a.queueSecureInputBuffer(i11, i12, cVar.a(), j11, i13);
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void flush() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void shutdown() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.v
    public void start() {
    }
}
