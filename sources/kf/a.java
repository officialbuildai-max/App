package kf;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes5.dex */
public class a {
    public static int a(InputStream inputStream, InputStream inputStream2, File file) {
        if (inputStream == null) {
            return 3;
        }
        if (file == null) {
            return 4;
        }
        if (inputStream2 == null) {
            return 2;
        }
        byte[] a11 = b.a(inputStream);
        byte[] a12 = b.a(inputStream2);
        byte[] b11 = b(a11, a11.length, a12, a12.length, 0);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(b11);
            fileOutputStream.close();
            return 1;
        } catch (Throwable th2) {
            fileOutputStream.close();
            throw th2;
        }
    }

    public static byte[] b(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        int i14;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2, 0, i12));
        dataInputStream.skip(8L);
        long readLong = dataInputStream.readLong();
        long readLong2 = dataInputStream.readLong();
        int readLong3 = (int) dataInputStream.readLong();
        dataInputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2, 0, i12);
        byteArrayInputStream.skip(32L);
        DataInputStream dataInputStream2 = new DataInputStream(new GZIPInputStream(byteArrayInputStream));
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr2, 0, i12);
        byteArrayInputStream2.skip(readLong + 32);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
        ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr2, 0, i12);
        byteArrayInputStream3.skip(readLong2 + readLong + 32);
        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(byteArrayInputStream3);
        byte[] bArr3 = new byte[readLong3];
        int[] iArr = new int[3];
        int i15 = 0;
        int i16 = 0;
        while (i15 < readLong3) {
            for (int i17 = 0; i17 <= 2; i17++) {
                iArr[i17] = dataInputStream2.readInt();
            }
            int i18 = iArr[0];
            if (i15 + i18 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            if (!b.b(gZIPInputStream, bArr3, i15, i18)) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            int i19 = 0;
            while (true) {
                i14 = iArr[0];
                if (i19 >= i14) {
                    break;
                }
                int i20 = i16 + i19;
                if (i20 >= 0 && i20 < i11) {
                    int i21 = i15 + i19;
                    bArr3[i21] = (byte) (bArr3[i21] + bArr[i20]);
                }
                i19++;
            }
            int i22 = i15 + i14;
            int i23 = i16 + i14;
            int i24 = iArr[1];
            if (i22 + i24 > readLong3) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            if (!b.b(gZIPInputStream2, bArr3, i22, i24)) {
                throw new IOException("Corrupt by wrong patch file.");
            }
            i15 = i22 + iArr[1];
            i16 = i23 + iArr[2];
        }
        dataInputStream2.close();
        gZIPInputStream.close();
        gZIPInputStream2.close();
        return bArr3;
    }
}
