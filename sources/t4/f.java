package t4;

import android.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final d f76183a;

    public f(d dVar) {
        this.f76183a = dVar;
    }

    private static String b(String str, FileExtension fileExtension, boolean z10) {
        String tempExtension = z10 ? fileExtension.tempExtension() : fileExtension.extension;
        String replaceAll = str.replaceAll("\\W+", "");
        int length = 242 - tempExtension.length();
        if (replaceAll.length() > length) {
            replaceAll = d(replaceAll, length);
        }
        return "lottie_cache_" + replaceAll + tempExtension;
    }

    private File c(String str) {
        File file = new File(e(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(e(), b(str, FileExtension.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    private static String d(String str, int i11) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b11 : digest) {
                sb2.append(String.format("%02x", Byte.valueOf(b11)));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return str.substring(0, i11);
        }
    }

    private File e() {
        File a11 = this.f76183a.a();
        if (a11.isFile()) {
            a11.delete();
        }
        if (!a11.exists()) {
            a11.mkdirs();
        }
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair a(String str) {
        try {
            File c11 = c(str);
            if (c11 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c11);
            FileExtension fileExtension = c11.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : c11.getAbsolutePath().endsWith(".gz") ? FileExtension.GZIP : FileExtension.JSON;
            v4.f.a("Cache hit for " + str + " at " + c11.getAbsolutePath());
            return new Pair(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, FileExtension fileExtension) {
        File file = new File(e(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        v4.f.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        v4.f.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File g(String str, InputStream inputStream, FileExtension fileExtension) {
        File file = new File(e(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } finally {
            inputStream.close();
        }
    }
}
