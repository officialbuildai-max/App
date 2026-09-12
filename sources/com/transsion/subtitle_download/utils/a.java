package com.transsion.subtitle_download.utils;

import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f55166a = new a();

    private a() {
    }

    public final boolean a(String zipFilePath, String destFilePath) {
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        Intrinsics.h(zipFilePath, "zipFilePath");
        Intrinsics.h(destFilePath, "destFilePath");
        byte[] bArr = new byte[1024];
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(destFilePath);
            try {
                fileInputStream = new FileInputStream(zipFilePath);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream);
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                b.f55167a.b("GzipUti --> unGzip() --> " + Log.getStackTraceString(th));
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                        return false;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream == null) {
                                    return false;
                                }
                                fileInputStream.close();
                                return false;
                            } catch (Throwable th5) {
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable th6) {
                                        th6.printStackTrace();
                                        throw th5;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th5;
                            }
                        }
                    }
                    gZIPInputStream.close();
                    fileOutputStream2.close();
                    fileInputStream.close();
                    return true;
                } catch (Throwable th7) {
                    th = th7;
                    gZIPInputStream = null;
                }
            } catch (Throwable th8) {
                th = th8;
                gZIPInputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
            gZIPInputStream = null;
            fileInputStream = null;
        }
    }
}
