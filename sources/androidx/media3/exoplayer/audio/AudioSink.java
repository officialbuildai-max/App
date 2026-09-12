package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import y1.f4;

/* loaded from: classes2.dex */
public interface AudioSink {

    /* loaded from: classes2.dex */
    public static final class ConfigurationException extends Exception {
        public final androidx.media3.common.r format;

        public ConfigurationException(String str, androidx.media3.common.r rVar) {
            super(str);
            this.format = rVar;
        }

        public ConfigurationException(Throwable th2, androidx.media3.common.r rVar) {
            super(th2);
            this.format = rVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final androidx.media3.common.r format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public InitializationException(int r8, int r9, int r10, int r11, androidx.media3.common.r r12, boolean r13, @androidx.annotation.Nullable java.lang.Exception r14) {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r2 = "Config("
                r0.append(r2)
                r0.append(r9)
                java.lang.String r9 = ", "
                r0.append(r9)
                r0.append(r10)
                r0.append(r9)
                r0.append(r11)
                java.lang.String r9 = ")"
                r0.append(r9)
                r0.append(r1)
                r0.append(r12)
                if (r13 == 0) goto L38
                java.lang.String r9 = " (recoverable)"
                goto L3a
            L38:
                java.lang.String r9 = ""
            L3a:
                r0.append(r9)
                java.lang.String r2 = r0.toString()
                r1 = r7
                r3 = r8
                r4 = r12
                r5 = r13
                r6 = r14
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.AudioSink.InitializationException.<init>(int, int, int, int, androidx.media3.common.r, boolean, java.lang.Exception):void");
        }

        public InitializationException(String str, int i11, androidx.media3.common.r rVar, boolean z10, @Nullable Throwable th2) {
            super(str, th2);
            this.audioTrackState = i11;
            this.isRecoverable = z10;
            this.format = rVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j11, long j12) {
            super("Unexpected audio track timestamp discontinuity: expected " + j12 + ", got " + j11);
            this.actualPresentationTimeUs = j11;
            this.expectedPresentationTimeUs = j12;
        }
    }

    /* loaded from: classes2.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final androidx.media3.common.r format;
        public final boolean isRecoverable;

        public WriteException(int i11, androidx.media3.common.r rVar, boolean z10) {
            super("AudioTrack write failed: " + i11);
            this.isRecoverable = z10;
            this.errorCode = i11;
            this.format = rVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11083a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11084b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11085c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11086d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f11087e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11088f;

        public a(int i11, int i12, int i13, boolean z10, boolean z11, int i14) {
            this.f11083a = i11;
            this.f11084b = i12;
            this.f11085c = i13;
            this.f11086d = z10;
            this.f11087e = z11;
            this.f11088f = i14;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Exception exc);

        void b(long j11);

        void c();

        void d();

        void e();

        void f();

        void j(a aVar);

        void k(a aVar);

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z10);

        void onUnderrun(int i11, long j11, long j12);
    }

    boolean a(androidx.media3.common.r rVar);

    void b(androidx.media3.common.z zVar);

    boolean c(ByteBuffer byteBuffer, long j11, int i11);

    void d();

    void disableTunneling();

    void e(boolean z10);

    void f(androidx.media3.common.c cVar);

    void flush();

    k g(androidx.media3.common.r rVar);

    long getCurrentPositionUs(boolean z10);

    androidx.media3.common.z getPlaybackParameters();

    void h(AudioDeviceInfo audioDeviceInfo);

    void handleDiscontinuity();

    boolean hasPendingData();

    long i();

    boolean isEnded();

    void j(b bVar);

    void k(int i11);

    void l(androidx.media3.common.r rVar, int i11, int[] iArr);

    void m(int i11, int i12);

    void n(long j11);

    int o(androidx.media3.common.r rVar);

    void p(f4 f4Var);

    void pause();

    void play();

    void playToEndOfStream();

    void q(androidx.media3.common.f fVar);

    void r(androidx.media3.common.util.i iVar);

    void release();

    void reset();

    void setAudioSessionId(int i11);

    void setVolume(float f11);
}
