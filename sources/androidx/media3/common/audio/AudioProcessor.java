package androidx.media3.common.audio;

import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f9897a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes2.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        public final a inputAudioFormat;

        public UnhandledAudioFormatException(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public UnhandledAudioFormatException(String str, a aVar) {
            super(str + " " + aVar);
            this.inputAudioFormat = aVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f9898e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f9899a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9900b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9901c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9902d;

        public a(int i11, int i12, int i13) {
            this.f9899a = i11;
            this.f9900b = i12;
            this.f9901c = i13;
            this.f9902d = a1.G0(i13) ? a1.k0(i13, i12) : -1;
        }

        public a(r rVar) {
            this(rVar.F, rVar.E, rVar.G);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9899a == aVar.f9899a && this.f9900b == aVar.f9900b && this.f9901c == aVar.f9901c;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f9899a), Integer.valueOf(this.f9900b), Integer.valueOf(this.f9901c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f9899a + ", channelCount=" + this.f9900b + ", encoding=" + this.f9901c + ']';
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
