package gf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class d {
    public static byte[] a(InputStream inputStream) {
        return b(inputStream, 32768);
    }

    public static byte[] b(InputStream inputStream, int i11) {
        if (i11 <= 0) {
            i11 = 32768;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
