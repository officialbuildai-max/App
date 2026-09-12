package com.vungle.ads.internal.util;

import android.os.Build;
import android.webkit.URLUtil;
import com.vungle.ads.AssetFailedToDeleteError;
import com.vungle.ads.internal.util.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;

/* loaded from: classes7.dex */
public final class g {
    public static final g INSTANCE = new g();
    private static a objectInputStreamProvider = new a() { // from class: com.vungle.ads.internal.util.f
        @Override // com.vungle.ads.internal.util.g.a
        public final ObjectInputStream provideObjectInputStream(InputStream inputStream) {
            ObjectInputStream m1099objectInputStreamProvider$lambda0;
            m1099objectInputStreamProvider$lambda0 = g.m1099objectInputStreamProvider$lambda0(inputStream);
            return m1099objectInputStreamProvider$lambda0;
        }
    };
    private static final String TAG = g.class.getSimpleName();
    private static final List<Class<?>> allowedClasses = CollectionsKt.o(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);

    /* loaded from: classes7.dex */
    public interface a {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    private g() {
    }

    @JvmStatic
    public static final void delete(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (file.delete()) {
                        return;
                    }
                    o.a aVar = o.Companion;
                    String TAG2 = TAG;
                    Intrinsics.g(TAG2, "TAG");
                    aVar.d(TAG2, "Failed to delete file: " + file);
                }
            } catch (Exception e11) {
                o.a aVar2 = o.Companion;
                String TAG3 = TAG;
                Intrinsics.g(TAG3, "TAG");
                aVar2.e(TAG3, "Failed to delete file: " + e11.getLocalizedMessage());
            }
        }
    }

    @JvmStatic
    public static final void deleteAndLogIfFailed(File file) {
        Path path;
        Intrinsics.h(file, "file");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                path = file.toPath();
                Files.delete(path);
            } else if (!file.delete()) {
                new AssetFailedToDeleteError("Cannot delete " + file.getName()).logErrorNoReturnValue$vungle_ads_release();
            }
        } catch (Exception e11) {
            new AssetFailedToDeleteError("Failed to delete " + file.getName() + " with error :" + e11.getMessage()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    @JvmStatic
    public static final void deleteContents(File folder) {
        Intrinsics.h(folder, "folder");
        File[] listFiles = folder.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            delete(file);
        }
    }

    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }

    private final String getIndentString(int i11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("|  ");
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "sb.toString()");
        return sb3;
    }

    public static /* synthetic */ String guessFileName$default(g gVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return gVar.guessFileName(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: objectInputStreamProvider$lambda-0, reason: not valid java name */
    public static final ObjectInputStream m1099objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new r(inputStream, allowedClasses);
    }

    @JvmStatic
    public static final void printDirectoryTree(File file) {
    }

    private final void printDirectoryTree(File file, int i11, StringBuilder sb2) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        sb2.append(getIndentString(i11));
        sb2.append("+--");
        sb2.append(file.getName());
        sb2.append("/\n");
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                printDirectoryTree(file2, i11 + 1, sb2);
            } else {
                Intrinsics.g(file2, "file");
                printFile(file2, i11 + 1, sb2);
            }
        }
    }

    private final void printFile(File file, int i11, StringBuilder sb2) {
        sb2.append(getIndentString(i11));
        sb2.append("+--");
        sb2.append(file.getName());
        sb2.append('\n');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0028: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:47:0x0028 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.vungle.ads.internal.util.g] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.vungle.ads.internal.util.g] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.vungle.ads.internal.util.g$a] */
    @JvmStatic
    public static final <T> T readSerializable(File file) {
        Closeable closeable;
        ObjectInputStream objectInputStream;
        Closeable closeable2;
        Intrinsics.h(file, "file");
        ?? exists = file.exists();
        Closeable closeable3 = null;
        try {
            if (exists == 0) {
                return null;
            }
            try {
                exists = new FileInputStream(file);
            } catch (IOException e11) {
                e = e11;
                exists = 0;
                objectInputStream = null;
            } catch (ClassNotFoundException e12) {
                e = e12;
                exists = 0;
                objectInputStream = null;
            } catch (Exception e13) {
                e = e13;
                exists = 0;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                exists = 0;
            }
            try {
                objectInputStream = objectInputStreamProvider.provideObjectInputStream(exists);
                try {
                    T t11 = (T) objectInputStream.readObject();
                    ?? r02 = INSTANCE;
                    r02.closeQuietly(objectInputStream);
                    r02.closeQuietly(exists);
                    return t11;
                } catch (IOException e14) {
                    e = e14;
                    o.a aVar = o.Companion;
                    String TAG2 = TAG;
                    Intrinsics.g(TAG2, "TAG");
                    aVar.e(TAG2, "IOException: " + e.getMessage());
                    closeable2 = exists;
                    g gVar = INSTANCE;
                    gVar.closeQuietly(objectInputStream);
                    gVar.closeQuietly(closeable2);
                    try {
                        delete(file);
                    } catch (IOException unused) {
                    }
                    return null;
                } catch (ClassNotFoundException e15) {
                    e = e15;
                    o.a aVar2 = o.Companion;
                    String TAG3 = TAG;
                    Intrinsics.g(TAG3, "TAG");
                    aVar2.e(TAG3, "ClassNotFoundException: " + e.getMessage());
                    closeable2 = exists;
                    g gVar2 = INSTANCE;
                    gVar2.closeQuietly(objectInputStream);
                    gVar2.closeQuietly(closeable2);
                    delete(file);
                    return null;
                } catch (Exception e16) {
                    e = e16;
                    o.a aVar3 = o.Companion;
                    String TAG4 = TAG;
                    Intrinsics.g(TAG4, "TAG");
                    aVar3.e(TAG4, "cannot read serializable " + e.getMessage());
                    closeable2 = exists;
                    g gVar22 = INSTANCE;
                    gVar22.closeQuietly(objectInputStream);
                    gVar22.closeQuietly(closeable2);
                    delete(file);
                    return null;
                }
            } catch (IOException e17) {
                e = e17;
                objectInputStream = null;
            } catch (ClassNotFoundException e18) {
                e = e18;
                objectInputStream = null;
            } catch (Exception e19) {
                e = e19;
                objectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                ?? r03 = INSTANCE;
                r03.closeQuietly(closeable3);
                r03.closeQuietly(exists);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable3 = closeable;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v15, types: [com.vungle.ads.internal.util.g] */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.vungle.ads.internal.util.g] */
    @JvmStatic
    public static final void writeSerializable(File file, Serializable serializable) {
        FileOutputStream fileOutputStream;
        ?? r42;
        Intrinsics.h(file, "file");
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e11) {
            e = e11;
            r42 = 0;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            r42 = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e12) {
            e = e12;
            r42 = 0;
        } catch (Throwable th3) {
            th = th3;
            g gVar = INSTANCE;
            gVar.closeQuietly(fileOutputStream2);
            gVar.closeQuietly(fileOutputStream);
            throw th;
        }
        try {
            r42.writeObject(serializable);
            r42.reset();
            ?? r52 = INSTANCE;
            r52.closeQuietly(r42);
            r52.closeQuietly(fileOutputStream);
        } catch (IOException e13) {
            e = e13;
            fileOutputStream2 = fileOutputStream;
            r42 = r42;
            try {
                o.a aVar = o.Companion;
                String TAG2 = TAG;
                Intrinsics.g(TAG2, "TAG");
                aVar.e(TAG2, String.valueOf(e.getMessage()));
                ?? r53 = INSTANCE;
                r53.closeQuietly(r42);
                r53.closeQuietly(fileOutputStream2);
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileOutputStream2;
                fileOutputStream2 = r42;
                g gVar2 = INSTANCE;
                gVar2.closeQuietly(fileOutputStream2);
                gVar2.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream2 = r42;
            g gVar22 = INSTANCE;
            gVar22.closeQuietly(fileOutputStream2);
            gVar22.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    public final a getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    public final String guessFileName(String url, String str) {
        Intrinsics.h(url, "url");
        String guessFileName = URLUtil.guessFileName(url, null, str);
        Intrinsics.g(guessFileName, "guessFileName(url, null, ext)");
        return guessFileName;
    }

    public final boolean isValidUrl(String str) {
        return (str == null || str.length() == 0 || HttpUrl.INSTANCE.parse(str) == null) ? false : true;
    }

    public final String readString(File file) {
        Intrinsics.h(file, "file");
        if (!file.exists()) {
            return null;
        }
        try {
            return FilesKt.i(file, null, 1, null);
        } catch (IOException e11) {
            o.a aVar = o.Companion;
            String TAG2 = TAG;
            Intrinsics.g(TAG2, "TAG");
            aVar.e(TAG2, "IOException: " + e11.getMessage());
            return null;
        } catch (Exception e12) {
            o.a aVar2 = o.Companion;
            String TAG3 = TAG;
            Intrinsics.g(TAG3, "TAG");
            aVar2.e(TAG3, "cannot read string " + e12.getMessage());
            return null;
        }
    }

    public final void setObjectInputStreamProvider(a aVar) {
        Intrinsics.h(aVar, "<set-?>");
        objectInputStreamProvider = aVar;
    }

    public final long size(File file) {
        long j11 = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (!(listFiles.length == 0)) {
                for (File file2 : listFiles) {
                    j11 += size(file2);
                }
            }
        }
        return j11;
    }

    public final void writeString(File file, String str) {
        Intrinsics.h(file, "file");
        if (str == null) {
            return;
        }
        try {
            FilesKt.k(file, str, Charsets.UTF_8);
        } catch (IOException e11) {
            o.a aVar = o.Companion;
            String TAG2 = TAG;
            Intrinsics.g(TAG2, "TAG");
            aVar.e(TAG2, String.valueOf(e11.getMessage()));
        }
    }
}
