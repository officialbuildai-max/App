package androidx.datastore.preferences.protobuf;

import com.meituan.android.walle.ChannelReader;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f8852a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    private static final Class f8853b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f8854c;

    static {
        Class e11 = e("java.io.FileOutputStream");
        f8853b = e11;
        f8854c = b(e11);
    }

    private static byte[] a() {
        SoftReference softReference = (SoftReference) f8852a.get();
        if (softReference == null) {
            return null;
        }
        return (byte[]) softReference.get();
    }

    private static long b(Class cls) {
        if (cls == null) {
            return -1L;
        }
        try {
            if (k1.I()) {
                return k1.L(cls.getDeclaredField(ChannelReader.CHANNEL_KEY));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static byte[] c(int i11) {
        int max = Math.max(i11, 1024);
        byte[] a11 = a();
        if (a11 == null || d(max, a11.length)) {
            a11 = new byte[max];
            if (max <= 16384) {
                f(a11);
            }
        }
        return a11;
    }

    private static boolean d(int i11, int i12) {
        return i12 < i11 && ((float) i12) < ((float) i11) * 0.5f;
    }

    private static Class e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void f(byte[] bArr) {
        f8852a.set(new SoftReference(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(ByteBuffer byteBuffer, OutputStream outputStream) {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!h(byteBuffer, outputStream)) {
                byte[] c11 = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), c11.length);
                    byteBuffer.get(c11, 0, min);
                    outputStream.write(c11, 0, min);
                }
            }
            y.c(byteBuffer, position);
        } catch (Throwable th2) {
            y.c(byteBuffer, position);
            throw th2;
        }
    }

    private static boolean h(ByteBuffer byteBuffer, OutputStream outputStream) {
        WritableByteChannel writableByteChannel;
        long j11 = f8854c;
        if (j11 < 0 || !f8853b.isInstance(outputStream)) {
            return false;
        }
        try {
            writableByteChannel = (WritableByteChannel) k1.G(outputStream, j11);
        } catch (ClassCastException unused) {
            writableByteChannel = null;
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
