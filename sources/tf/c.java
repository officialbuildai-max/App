package tf;

import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
public class c {
    public static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, String str, boolean z10) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < 2 && !z11) {
            i11++;
            ShareTinkerLog.i("Tinker.BasePatchInternal", "try Extracting " + file.getPath(), new Object[0]);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
            try {
                if (ShareTinkerInternals.isNewerOrEqualThanVersion(33, true)) {
                    file.setReadOnly();
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                pf.b.a(bufferedOutputStream);
                pf.b.a(bufferedInputStream);
                z11 = str != null ? z10 ? SharePatchFileUtil.verifyDexFileMd5(file, str) : SharePatchFileUtil.verifyFileMd5(file, str) : true;
                ShareTinkerLog.i("Tinker.BasePatchInternal", "isExtractionSuccessful: %b", Boolean.valueOf(z11));
                if (!z11 && (!file.delete() || file.exists())) {
                    ShareTinkerLog.e("Tinker.BasePatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                pf.b.a(bufferedOutputStream2);
                pf.b.a(bufferedInputStream);
                throw th;
            }
        }
        return z11;
    }

    public static int b(int i11) {
        if (i11 == 3) {
            return -3;
        }
        if (i11 == 5) {
            return -4;
        }
        return i11 == 6 ? -8 : 0;
    }
}
