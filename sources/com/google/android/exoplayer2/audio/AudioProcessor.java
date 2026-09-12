package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f24583a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes3.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        public UnhandledAudioFormatException(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f24584e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f24585a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24586b;

        /* renamed from: c, reason: collision with root package name */
        public final int f24587c;

        /* renamed from: d, reason: collision with root package name */
        public final int f24588d;

        public a(int i11, int i12, int i13) {
            this.f24585a = i11;
            this.f24586b = i12;
            this.f24587c = i13;
            this.f24588d = p0.u0(i13) ? p0.e0(i13, i12) : -1;
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f24585a + ", channelCount=" + this.f24586b + ", encoding=" + this.f24587c + ']';
        }
    }

    a a(a aVar);

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
