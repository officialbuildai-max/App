package pf;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
public final class b {
    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (obj instanceof AutoCloseable) {
                ((AutoCloseable) obj).close();
            } else if (obj instanceof ZipFile) {
                ((ZipFile) obj).close();
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }
}
