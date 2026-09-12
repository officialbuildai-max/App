package fg;

import android.content.Context;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.utils.NetworkUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static File f62514b;

    /* renamed from: c, reason: collision with root package name */
    private static File f62515c;

    /* renamed from: d, reason: collision with root package name */
    private static Context f62516d;

    /* renamed from: a, reason: collision with root package name */
    public static final b f62513a = new b();

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f62517e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private static final Comparator f62518f = new Comparator() { // from class: fg.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int c11;
            c11 = b.c((File) obj, (File) obj2);
            return c11;
        }
    };

    private b() {
    }

    private final boolean b(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }

    private final File d(String str) {
        if (f62515c == null) {
            Context context = f62516d;
            f62515c = context == null ? null : context.getCacheDir();
        }
        return new File(f62515c, str);
    }

    private final File e(String str) {
        b(f62514b);
        return new File(f62514b, str);
    }

    public final synchronized File[] f() {
        File file = f62514b;
        if (file == null) {
            return null;
        }
        File[] listFiles = file != null ? file.listFiles() : null;
        if (listFiles != null) {
            Arrays.sort(listFiles, f62518f);
        }
        return listFiles;
    }

    public final void g(Context context) {
        if (context != null && f62517e.compareAndSet(false, true)) {
            f62516d = context;
            f62514b = new File(context.getFilesDir(), "strategy");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void h(java.io.Serializable r12, java.io.File r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = "toFile"
            kotlin.jvm.internal.Intrinsics.h(r13, r0)     // Catch: java.lang.Throwable -> L4f
            if (r12 != 0) goto La
            monitor-exit(r11)
            return
        La:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4f
            r2 = 0
            r3 = 0
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5b
            java.lang.String r5 = r4.toString()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5b
            java.lang.String r4 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.g(r5, r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5b
            java.lang.String r6 = "-"
            java.lang.String r7 = ""
            r9 = 4
            r10 = 0
            r8 = 0
            java.lang.String r4 = kotlin.text.StringsKt.Q(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5b
            java.io.File r4 = r11.d(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5b
            r4.createNewFile()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L58
            r5 = 1
            r4.setReadable(r5)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L58
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L58
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L58
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r2.writeObject(r12)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r2.flush()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r2.close()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L55
            r6.close()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L52
            goto L6b
        L4f:
            r12 = move-exception
            goto Lc9
        L52:
            r12 = move-exception
        L53:
            r2 = r6
            goto L5e
        L55:
            r12 = move-exception
            r5 = r3
            goto L53
        L58:
            r12 = move-exception
        L59:
            r5 = r3
            goto L5e
        L5b:
            r12 = move-exception
            r4 = r2
            goto L59
        L5e:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L4f
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L67
            goto L6b
        L67:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L4f
        L6b:
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L4f
            long r6 = r6 - r0
            if (r5 != 0) goto L73
            goto Lb6
        L73:
            if (r4 != 0) goto L76
            goto L7a
        L76:
            boolean r3 = r4.renameTo(r13)     // Catch: java.lang.Throwable -> L4f
        L7a:
            if (r3 == 0) goto Laf
            gg.b r12 = gg.b.f63690a     // Catch: java.lang.Throwable -> L4f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r0.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = "persist end. file = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4f
            java.io.File r1 = r13.getAbsoluteFile()     // Catch: java.lang.Throwable -> L4f
            r0.append(r1)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r1 = ", size = "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4f
            long r1 = r13.length()     // Catch: java.lang.Throwable -> L4f
            r0.append(r1)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r13 = ", cost= "
            r0.append(r13)     // Catch: java.lang.Throwable -> L4f
            java.lang.Long r13 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L4f
            r0.append(r13)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r13 = r0.toString()     // Catch: java.lang.Throwable -> L4f
            r12.g(r13)     // Catch: java.lang.Throwable -> L4f
            goto Lb6
        Laf:
            gg.b r12 = gg.b.f63690a     // Catch: java.lang.Throwable -> L4f
            java.lang.String r13 = "rename failed."
            r12.c(r13)     // Catch: java.lang.Throwable -> L4f
        Lb6:
            if (r5 == 0) goto Lba
            if (r3 != 0) goto Lc7
        Lba:
            if (r4 != 0) goto Lbd
            goto Lc7
        Lbd:
            r4.delete()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> Lc1
            goto Lc7
        Lc1:
            r12 = move-exception
            gg.b r13 = gg.b.f63690a     // Catch: java.lang.Throwable -> L4f
            r13.e(r12)     // Catch: java.lang.Throwable -> L4f
        Lc7:
            monitor-exit(r11)
            return
        Lc9:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L4f
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: fg.b.h(java.io.Serializable, java.io.File):void");
    }

    public final synchronized void i(Serializable serializable, String filename) {
        Intrinsics.h(serializable, "serializable");
        Intrinsics.h(filename, "filename");
        h(serializable, e(filename));
    }

    public final synchronized void j() {
        File[] f11;
        try {
            f11 = f();
        } finally {
        }
        if (f11 == null) {
            return;
        }
        int length = f11.length;
        int i11 = 1;
        int i12 = 0;
        while (i12 < length) {
            File file = f11[i12];
            i12++;
            if (!file.isDirectory()) {
                if (System.currentTimeMillis() - file.lastModified() > TmcConstants.MINIAPP_TIME_DIFF) {
                    gg.b.f63690a.c(Intrinsics.q("delete expired file: ", file.getAbsoluteFile()));
                    file.delete();
                } else {
                    String name = file.getName();
                    Intrinsics.g(name, "file.name");
                    if (StringsKt.W(name, NetworkUtil.NETWORK_TYPE_WIFI, false, 2, null)) {
                        if (i11 > 10) {
                            gg.b.f63690a.c("delete file: " + file.getAbsoluteFile() + " because max file num is 10");
                            file.delete();
                        }
                        i11++;
                    }
                }
            }
        }
    }

    public final synchronized Object k(File file) {
        Object obj;
        Intrinsics.h(file, "file");
        FileInputStream fileInputStream = null;
        Object obj2 = null;
        if (!file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream2));
                obj2 = objectInputStream.readObject();
                objectInputStream.close();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                gg.b.f63690a.b("restore end. file = " + file.getAbsoluteFile() + ", size = " + file.length() + ", cost = " + currentTimeMillis2);
                fileInputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                Object obj3 = obj2;
                fileInputStream = fileInputStream2;
                obj = obj3;
                th.printStackTrace();
                gg.b.f63690a.c(Intrinsics.q("restore file fail. file = ", file.getAbsoluteFile()));
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        obj2 = obj;
                        return obj2;
                    }
                }
                obj2 = obj;
                return obj2;
            }
        } catch (Throwable th3) {
            th = th3;
            obj = null;
        }
        return obj2;
    }

    public final synchronized Object l(String filename) {
        Intrinsics.h(filename, "filename");
        return k(e(filename));
    }
}
