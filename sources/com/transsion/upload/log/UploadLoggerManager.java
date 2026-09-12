package com.transsion.upload.log;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.blankj.utilcode.util.w;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import cw.a;
import cw.b;
import cw.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class UploadLoggerManager {

    /* renamed from: a */
    public static final UploadLoggerManager f56759a = new UploadLoggerManager();

    private UploadLoggerManager() {
    }

    public final void c(String str, String str2) {
        try {
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str);
            if (file2.exists()) {
                b c11 = c.f61054a.c();
                String b11 = c11 != null ? c11.b() : null;
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        file3.delete();
                        if (!Intrinsics.c(file3.getName(), b11)) {
                            file3.delete();
                        }
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void d() {
        /*
            r11 = this;
            cw.c r0 = cw.c.f61054a
            cw.b r0 = r0.c()
            if (r0 == 0) goto Lce
            java.util.List r0 = r0.c()
            if (r0 == 0) goto Lce
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L14:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lce
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()
            if (r2 == 0) goto L14
            java.lang.String r3 = "getApp()"
            kotlin.jvm.internal.Intrinsics.g(r2, r3)
            r3 = 0
            java.io.File r2 = r2.getDatabasePath(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            boolean r4 = r2.exists()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r4 == 0) goto Laa
            cw.c r4 = cw.c.f61054a     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            cw.b r4 = r4.c()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r4 == 0) goto L4b
            java.lang.String r4 = r4.d()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            goto L4c
        L43:
            r0 = move-exception
            r2 = r3
            goto Lc3
        L47:
            r1 = move-exception
            r2 = r3
            goto Lb7
        L4b:
            r4 = r3
        L4c:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            boolean r6 = r5.exists()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            if (r6 != 0) goto L5a
            r5.mkdirs()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
        L5a:
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r5]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.lang.String r8 = java.io.File.separator     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r9.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r9.append(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r9.append(r8)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r9.append(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.lang.String r1 = r9.toString()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L47
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r4.<init>(r7)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
            r2.<init>(r4)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La4
        L8b:
            r3 = 0
            int r4 = r1.read(r6, r3, r5)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r7 = -1
            if (r4 == r7) goto L9f
            r2.write(r6, r3, r4)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            goto L8b
        L97:
            r0 = move-exception
        L98:
            r3 = r1
            goto Lc3
        L9a:
            r3 = move-exception
            r10 = r3
            r3 = r1
            r1 = r10
            goto Lb7
        L9f:
            r3 = r1
            goto Lab
        La1:
            r0 = move-exception
            r2 = r3
            goto L98
        La4:
            r2 = move-exception
            r10 = r3
            r3 = r1
            r1 = r2
            r2 = r10
            goto Lb7
        Laa:
            r2 = r3
        Lab:
            if (r3 == 0) goto Lb0
            r3.close()
        Lb0:
            if (r2 == 0) goto L14
        Lb2:
            r2.close()
            goto L14
        Lb7:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lc2
            if (r3 == 0) goto Lbf
            r3.close()
        Lbf:
            if (r2 == 0) goto L14
            goto Lb2
        Lc2:
            r0 = move-exception
        Lc3:
            if (r3 == 0) goto Lc8
            r3.close()
        Lc8:
            if (r2 == 0) goto Lcd
            r2.close()
        Lcd:
            throw r0
        Lce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.upload.log.UploadLoggerManager.d():void");
    }

    private final void e() {
        if (Utils.a() == null) {
            return;
        }
        PrintWriter printWriter = null;
        try {
            UploadLoggerManager uploadLoggerManager = f56759a;
            String f11 = uploadLoggerManager.f();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("headerInfo ");
            sb2.append(f11);
            b c11 = c.f61054a.c();
            String d11 = c11 != null ? c11.d() : null;
            File file = new File(d11);
            if (!file.exists()) {
                file.mkdirs();
            }
            Date date = new Date(System.currentTimeMillis());
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
            PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(new File(d11 + File.separator + "deviceInfo" + format + ".txt"), true)));
            try {
                printWriter2.println(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss", Locale.getDefault()).format(date));
                printWriter2.println("headerInfo = " + f11);
                uploadLoggerManager.j(printWriter2);
                printWriter2.close();
            } catch (Throwable th2) {
                th = th2;
                printWriter = printWriter2;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private final String f() {
        try {
            Result.Companion companion = Result.INSTANCE;
            b c11 = c.f61054a.c();
            if (c11 != null) {
                return c11.a();
            }
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            if (Result.m1188exceptionOrNullimpl(Result.m1185constructorimpl(ResultKt.a(th2))) != null) {
                return null;
            }
            throw new KotlinNothingValueException();
        }
    }

    private final ActivityManager.MemoryInfo h(Context context) {
        Object systemService = context.getSystemService("activity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    private final void j(PrintWriter printWriter) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp()");
            ActivityManager.MemoryInfo h11 = h(a11);
            String b11 = i.b(h11.totalMem, 2);
            String b12 = i.b(h11.availMem, 2);
            String b13 = i.b(h11.threshold, 2);
            String a12 = i.a(w.b());
            String a13 = i.a(w.a());
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (printWriter != null) {
                printWriter.println("memoryInfo totalMem=" + b11 + " availMem=" + b12 + " threshold=" + b13 + " totalSize=" + a12 + " availableSize=" + a13 + " coreSize=" + availableProcessors);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Integer.valueOf(Log.d("UploadLoggerManager", "memoryInfo totalMem=" + b11 + " availMem=" + b12 + " threshold=" + b13 + " totalSize=" + a12 + " availableSize=" + a13 + " coreSize=" + availableProcessors)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Result.m1188exceptionOrNullimpl(m1185constructorimpl);
    }

    public static /* synthetic */ void l(UploadLoggerManager uploadLoggerManager, a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar = null;
        }
        uploadLoggerManager.k(aVar);
    }

    public final void m(String str, String str2, String str3, a aVar, String str4, Function1 function1) {
        k.d(o0.a(y0.b()), null, null, new UploadLoggerManager$reportUploadLogsResult$1(str, str4, aVar, str2, function1, str3, null), 3, null);
    }

    private final void n() {
        k.d(o0.a(y0.b()), null, null, new UploadLoggerManager$requestConfig$1(null), 3, null);
    }

    public final void g() {
        b c11 = c.f61054a.c();
        if (c11 == null || !c11.i()) {
            return;
        }
        n();
    }

    public final synchronized void i(final a aVar) {
        String path;
        try {
            try {
                b c11 = c.f61054a.c();
                final String d11 = c11 != null ? c11.d() : null;
                File parentFile = new File(d11).getParentFile();
                if (parentFile != null && (path = parentFile.getPath()) != null) {
                    final String str = path + File.separator + "logger.zip";
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    ew.b.f62156a.a(d11, str, new Function1<Boolean, Unit>() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return Unit.f67184a;
                        }

                        public final void invoke(boolean z10) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("logger compress result=");
                            sb2.append(z10);
                            if (!z10) {
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    a.C0748a.a(aVar2, d11, "压缩失败", "", null, 8, null);
                                    return;
                                }
                                return;
                            }
                            c cVar = c.f61054a;
                            final String str2 = str;
                            UploadFileType uploadFileType = UploadFileType.OBJECT_NAME_LOGGER;
                            final a aVar3 = aVar;
                            final String str3 = d11;
                            cVar.f(str2, uploadFileType, false, new a() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1.1
                                @Override // cw.a
                                public void a(String localFilePath, long j11, long j12) {
                                    Intrinsics.h(localFilePath, "localFilePath");
                                    a aVar4 = a.this;
                                    if (aVar4 != null) {
                                        aVar4.a(localFilePath, j11, j12);
                                    }
                                }

                                @Override // cw.a
                                public void b(String localFilePath, final String url, String bucket) {
                                    Intrinsics.h(localFilePath, "localFilePath");
                                    Intrinsics.h(url, "url");
                                    Intrinsics.h(bucket, "bucket");
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("upload file success url=");
                                    sb3.append(url);
                                    UploadLoggerManager uploadLoggerManager = UploadLoggerManager.f56759a;
                                    String str4 = str3;
                                    String str5 = str2;
                                    final a aVar4 = a.this;
                                    uploadLoggerManager.m(url, str4, str5, aVar4, bucket, new Function1<String, Unit>() { // from class: com.transsion.upload.log.UploadLoggerManager$packLoggerFile$1$1$1$onSuccess$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((String) obj);
                                            return Unit.f67184a;
                                        }

                                        public final void invoke(String logId) {
                                            Intrinsics.h(logId, "logId");
                                            a aVar5 = a.this;
                                            if (aVar5 != null) {
                                                aVar5.b(logId, url, "");
                                            }
                                        }
                                    });
                                }

                                @Override // cw.a
                                public void c(String str4, String str5, String str6, UploadTstTokenStorageType uploadTstTokenStorageType) {
                                    a aVar4 = a.this;
                                    if (aVar4 != null) {
                                        aVar4.c(str4, str5, str6, uploadTstTokenStorageType);
                                    }
                                }
                            });
                        }
                    });
                }
            } catch (Exception unused) {
                if (aVar != null) {
                    a.C0748a.a(aVar, "", "packLoggerFile() 异常", "", null, 8, null);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void k(a aVar) {
        try {
            d();
            e();
            i(aVar);
        } catch (Exception unused) {
            if (aVar != null) {
                a.C0748a.a(aVar, "", "", "", null, 8, null);
            }
        }
    }
}
