package pf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;

/* loaded from: classes5.dex */
public abstract class a {
    public static long a(File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                long b11 = b(bufferedInputStream2);
                b.a(bufferedInputStream2);
                return b11;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                b.a(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static long b(InputStream inputStream) {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return crc32.getValue();
            }
            crc32.update(bArr, 0, read);
        }
    }
}
