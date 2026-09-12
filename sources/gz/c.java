package gz;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f64161a = new c();

    private c() {
    }

    private final boolean i(File file, File file2, boolean z10) {
        String name;
        if (!file.exists()) {
            a.C0856a.l(lg.a.f68962a, "FileUtil", "ZIP文件不存在: " + file.getAbsolutePath(), false, 4, null);
            return false;
        }
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                while (nextEntry != null) {
                    if (nextEntry.isDirectory()) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        if (z10) {
                            String name2 = nextEntry.getName();
                            Intrinsics.g(name2, "getName(...)");
                            name = StringsKt.f1(name2, "/", null, 2, null);
                        } else {
                            name = nextEntry.getName();
                        }
                        File file3 = new File(file2, name);
                        String canonicalPath = file3.getCanonicalPath();
                        Intrinsics.g(canonicalPath, "getCanonicalPath(...)");
                        String canonicalPath2 = file2.getCanonicalPath();
                        Intrinsics.g(canonicalPath2, "getCanonicalPath(...)");
                        if (StringsKt.W(canonicalPath, canonicalPath2, false, 2, null)) {
                            File parentFile = file3.getParentFile();
                            if (parentFile != null) {
                                parentFile.mkdirs();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                Unit unit = Unit.f67184a;
                                CloseableKt.a(fileOutputStream, null);
                                a.C0856a.f(lg.a.f68962a, "FileUtil", "解压文件: " + file3.getAbsolutePath(), false, 4, null);
                                zipInputStream.closeEntry();
                                nextEntry = zipInputStream.getNextEntry();
                            } finally {
                            }
                        } else {
                            a.C0856a.l(lg.a.f68962a, "FileUtil", "非法的ZIP条目路径: " + nextEntry.getName(), false, 4, null);
                            zipInputStream.closeEntry();
                            nextEntry = zipInputStream.getNextEntry();
                        }
                    }
                }
                Unit unit2 = Unit.f67184a;
                CloseableKt.a(zipInputStream, null);
                a.C0856a.f(lg.a.f68962a, "FileUtil", "ZIP解压成功: " + file.getAbsolutePath() + " -> " + file2.getAbsolutePath(), false, 4, null);
                return true;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(zipInputStream, th2);
                    throw th3;
                }
            }
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "FileUtil", "ZIP解压失败: " + e11.getMessage(), e11, false, 8, null);
            return false;
        }
    }

    public final boolean a(File dir) {
        Intrinsics.h(dir, "dir");
        try {
            if (dir.exists()) {
                return FilesKt.v(dir);
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean b(File file) {
        Intrinsics.h(file, "file");
        try {
            if (file.exists()) {
                return file.delete();
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean c(File file) {
        Intrinsics.h(file, "file");
        return file.exists() && file.isFile() && file.length() > 0;
    }

    public final File d(Context context, int i11) {
        Intrinsics.h(context, "context");
        File file = new File(e(context), "zip_" + i11);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File e(Context context) {
        Intrinsics.h(context, "context");
        File file = new File(context.getFilesDir(), "dynamic_so");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File f(Context context, String zipUrl) {
        Intrinsics.h(context, "context");
        Intrinsics.h(zipUrl, "zipUrl");
        File g11 = g(context);
        String str = null;
        String f12 = StringsKt.f1(zipUrl, "/", null, 2, null);
        if (!StringsKt.q0(f12) && StringsKt.G(f12, ".zip", false, 2, null)) {
            str = f12;
        }
        if (str == null) {
            str = zipUrl.hashCode() + ".zip";
        }
        return new File(g11, str);
    }

    public final File g(Context context) {
        Intrinsics.h(context, "context");
        File file = new File(context.getFilesDir(), "dynamic_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final boolean h(File zipFile, File targetDir) {
        Intrinsics.h(zipFile, "zipFile");
        Intrinsics.h(targetDir, "targetDir");
        return i(zipFile, targetDir, true);
    }
}
