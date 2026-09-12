package xf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class k {
    public static void a(h hVar, File file, long j11, j jVar) {
        BufferedInputStream bufferedInputStream;
        h hVar2 = new h(hVar);
        hVar2.l(0);
        hVar2.m(file.length());
        hVar2.j(file.length());
        hVar2.k(j11);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            jVar.o(new h(hVar2));
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    jVar.k();
                    bufferedInputStream.close();
                    return;
                }
                jVar.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static void b(i iVar, h hVar, j jVar) {
        InputStream inputStream;
        try {
            inputStream = iVar.m(hVar);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            jVar.o(new h(hVar));
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    jVar.k();
                    inputStream.close();
                    return;
                }
                jVar.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
