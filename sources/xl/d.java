package xl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f78443a = Charset.forName(C.ASCII_NAME);

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f78444b;

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f78445c;

    static {
        Charset.forName("UTF-8");
        f78444b = "0123456789abcdef".toCharArray();
        f78445c = new char[64];
    }

    public static String a(byte[] bArr) {
        String str;
        char[] cArr = f78445c;
        synchronized (cArr) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                try {
                    byte b11 = bArr[i11];
                    int i12 = i11 * 2;
                    char[] cArr2 = f78444b;
                    cArr[i12] = cArr2[(b11 & 255) >>> 4];
                    cArr[i12 + 1] = cArr2[b11 & 15];
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            str = new String(cArr);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static void c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                c(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
