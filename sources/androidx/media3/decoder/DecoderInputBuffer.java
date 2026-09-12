package androidx.media3.decoder;

import androidx.media3.common.r;
import androidx.media3.common.u;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DecoderInputBuffer extends a {

    /* renamed from: a, reason: collision with root package name */
    public r f10998a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10999b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f11000c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11001d;

    /* renamed from: e, reason: collision with root package name */
    public long f11002e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f11003f;

    /* renamed from: g, reason: collision with root package name */
    private final int f11004g;

    /* renamed from: h, reason: collision with root package name */
    private final int f11005h;

    /* loaded from: classes2.dex */
    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i11, int i12) {
            super("Buffer too small (" + i11 + " < " + i12 + ")");
            this.currentCapacity = i11;
            this.requiredCapacity = i12;
        }
    }

    static {
        u.a("media3.decoder");
    }

    public DecoderInputBuffer(int i11) {
        this(i11, 0);
    }

    public DecoderInputBuffer(int i11, int i12) {
        this.f10999b = new c();
        this.f11004g = i11;
        this.f11005h = i12;
    }

    private ByteBuffer a(int i11) {
        int i12 = this.f11004g;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.f11000c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    public static DecoderInputBuffer f() {
        return new DecoderInputBuffer(0);
    }

    public void b(int i11) {
        int i12 = i11 + this.f11005h;
        ByteBuffer byteBuffer = this.f11000c;
        if (byteBuffer == null) {
            this.f11000c = a(i12);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i13 = i12 + position;
        if (capacity >= i13) {
            this.f11000c = byteBuffer;
            return;
        }
        ByteBuffer a11 = a(i13);
        a11.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            a11.put(byteBuffer);
        }
        this.f11000c = a11;
    }

    @Override // androidx.media3.decoder.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f11000c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f11003f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f11001d = false;
    }

    public final void d() {
        ByteBuffer byteBuffer = this.f11000c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f11003f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean e() {
        return getFlag(1073741824);
    }

    public void g(int i11) {
        ByteBuffer byteBuffer = this.f11003f;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f11003f = ByteBuffer.allocate(i11);
        } else {
            this.f11003f.clear();
        }
    }
}
