package q00;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;

/* loaded from: classes7.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f73166a = new byte[4096];

    public static int a(InputStream inputStream, byte[] bArr) {
        return b(inputStream, bArr, 0, bArr.length);
    }

    public static int b(InputStream inputStream, byte[] bArr, int i11, int i12) {
        if (i12 < 0 || i11 < 0 || i12 + i11 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = 0;
        while (i13 != i12) {
            int read = inputStream.read(bArr, i11 + i13, i12 - i13);
            if (read == -1) {
                break;
            }
            i13 += read;
        }
        return i13;
    }

    public static long c(InputStream inputStream, long j11) {
        int b11;
        long j12 = j11;
        while (j12 > 0) {
            long skip = inputStream.skip(j12);
            if (skip == 0) {
                break;
            }
            j12 -= skip;
        }
        while (j12 > 0 && (b11 = b(inputStream, f73166a, 0, (int) Math.min(j12, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM))) >= 1) {
            j12 -= b11;
        }
        return j11 - j12;
    }
}
