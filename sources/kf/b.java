package kf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class b {
    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static final boolean b(InputStream inputStream, byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int read = inputStream.read(bArr, i11 + i13, i12 - i13);
            if (read < 0) {
                return false;
            }
            i13 += read;
        }
        return true;
    }
}
