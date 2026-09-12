package com.cloud.h5update.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f21392a = new m();

    private m() {
    }

    /* JADX WARN: Finally extract failed */
    public final void a(File file, String dstDir) {
        Intrinsics.h(dstDir, "dstDir");
        File file2 = new File(dstDir);
        if (!file2.exists() || !file2.isDirectory()) {
            file2.mkdirs();
        }
        String dstCanonicalPath = file2.getCanonicalPath();
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            Intrinsics.g(entries, "zipFile.entries()");
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Intrinsics.g(nextElement, "zipEntrys.nextElement()");
                ZipEntry zipEntry = nextElement;
                String zipEntryName = zipEntry.getName();
                Intrinsics.g(zipEntryName, "zipEntryName");
                if (!StringsKt.c0(zipEntryName, "../", false, 2, null)) {
                    File file3 = new File(dstDir + File.separator + zipEntryName);
                    String tmpCanonicalPath = file3.getCanonicalPath();
                    Intrinsics.g(tmpCanonicalPath, "tmpCanonicalPath");
                    Intrinsics.g(dstCanonicalPath, "dstCanonicalPath");
                    if (StringsKt.W(tmpCanonicalPath, dstCanonicalPath, false, 2, null)) {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!zipEntry.isDirectory()) {
                            FileOutputStream fileOutputStream = new FileOutputStream(file3);
                            try {
                                InputStream inputStream = zipFile.getInputStream(zipEntry);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                    }
                                    fileOutputStream.flush();
                                    Unit unit = Unit.f67184a;
                                    CloseableKt.a(inputStream, null);
                                    CloseableKt.a(fileOutputStream, null);
                                } finally {
                                }
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    CloseableKt.a(fileOutputStream, th2);
                                    throw th3;
                                }
                            }
                        } else if (!file3.exists()) {
                            file3.mkdirs();
                        }
                    } else {
                        continue;
                    }
                }
            }
            Unit unit2 = Unit.f67184a;
            CloseableKt.a(zipFile, null);
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                CloseableKt.a(zipFile, th4);
                throw th5;
            }
        }
    }
}
