package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o1;
import e9.u1;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface AudioSink {

    /* loaded from: classes3.dex */
    public static final class ConfigurationException extends Exception {
        public final o1 format;

        public ConfigurationException(String str, o1 o1Var) {
            super(str);
            this.format = o1Var;
        }

        public ConfigurationException(Throwable th2, o1 o1Var) {
            super(th2);
            this.format = o1Var;
        }
    }

    /* loaded from: classes3.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;
        public final o1 format;
        public final boolean isRecoverable;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public InitializationException(int r3, int r4, int r5, int r6, com.google.android.exoplayer2.o1 r7, boolean r8, @androidx.annotation.Nullable java.lang.Exception r9) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "AudioTrack init failed "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.String r1 = "Config("
                r0.append(r1)
                r0.append(r4)
                java.lang.String r4 = ", "
                r0.append(r4)
                r0.append(r5)
                r0.append(r4)
                r0.append(r6)
                java.lang.String r4 = ")"
                r0.append(r4)
                if (r8 == 0) goto L32
                java.lang.String r4 = " (recoverable)"
                goto L34
            L32:
                java.lang.String r4 = ""
            L34:
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r2.<init>(r4, r9)
                r2.audioTrackState = r3
                r2.isRecoverable = r8
                r2.format = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.AudioSink.InitializationException.<init>(int, int, int, int, com.google.android.exoplayer2.o1, boolean, java.lang.Exception):void");
        }
    }

    /* loaded from: classes3.dex */
    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long actualPresentationTimeUs;
        public final long expectedPresentationTimeUs;

        public UnexpectedDiscontinuityException(long j11, long j12) {
            super("Unexpected audio track timestamp discontinuity: expected " + j12 + ", got " + j11);
            this.actualPresentationTimeUs = j11;
            this.expectedPresentationTimeUs = j12;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;
        public final o1 format;
        public final boolean isRecoverable;

        public WriteException(int i11, o1 o1Var, boolean z10) {
            super("AudioTrack write failed: " + i11);
            this.isRecoverable = z10;
            this.errorCode = i11;
            this.format = o1Var;
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(Exception exc);

        void b(long j11);

        void c();

        void d();

        void onPositionDiscontinuity();

        void onSkipSilenceEnabledChanged(boolean z10);

        void onUnderrun(int i11, long j11, long j12);
    }

    boolean a(o1 o1Var);

    void b(n2 n2Var);

    boolean c(ByteBuffer byteBuffer, long j11, int i11);

    void d();

    void disableTunneling();

    void e(boolean z10);

    void f(e eVar);

    void flush();

    void g(a aVar);

    long getCurrentPositionUs(boolean z10);

    n2 getPlaybackParameters();

    int h(o1 o1Var);

    void handleDiscontinuity();

    boolean hasPendingData();

    void i();

    boolean isEnded();

    void j(u uVar);

    void k(u1 u1Var);

    void l(o1 o1Var, int i11, int[] iArr);

    void pause();

    void play();

    void playToEndOfStream();

    void reset();

    void setAudioSessionId(int i11);

    void setVolume(float f11);
}
