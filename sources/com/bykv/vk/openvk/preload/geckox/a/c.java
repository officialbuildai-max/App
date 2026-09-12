package com.bykv.vk.openvk.preload.geckox.a;

import com.bykv.vk.openvk.preload.geckox.utils.f;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    public c(Field field) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(field);
    }

    private static List<File> a(File[] fileArr) {
        long j11;
        ArrayList<File> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File file = null;
        long j12 = -1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file2);
            } else if (name.endsWith("--pending-delete")) {
                a(file2);
            } else {
                try {
                    long parseLong = Long.parseLong(name);
                    if (parseLong > j12) {
                        if (file != null) {
                            try {
                                arrayList2.add(file);
                            } catch (Exception unused) {
                                j12 = parseLong;
                                a(file2);
                            }
                        }
                        file = file2;
                        j12 = parseLong;
                    } else {
                        arrayList2.add(file2);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        for (File file3 : arrayList) {
            String name2 = file3.getName();
            int indexOf = name2.indexOf("--updating");
            if (indexOf == -1) {
                a(file3);
            } else {
                try {
                    j11 = Long.parseLong(name2.substring(0, indexOf));
                } catch (NumberFormatException e11) {
                    e11.printStackTrace();
                    j11 = -1;
                }
                if (j11 <= j12) {
                    a(file3);
                }
            }
        }
        return arrayList2;
    }

    private static void a(final File file) {
        com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
            }
        });
    }

    public static void a(final String str) {
        f.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.c(str);
                } catch (Throwable th2) {
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException("delete old channel version failed，path：" + str, th2));
                }
            }
        });
    }

    public static boolean b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("update.lock");
            com.bykv.vk.openvk.preload.geckox.g.a a11 = com.bykv.vk.openvk.preload.geckox.g.a.a(sb2.toString());
            if (a11 == null) {
                return true;
            }
            try {
                com.bykv.vk.openvk.preload.geckox.g.b a12 = com.bykv.vk.openvk.preload.geckox.g.b.a(str + str2 + "select.lock");
                try {
                    com.bykv.vk.openvk.preload.geckox.utils.b.c(new File(str));
                } catch (Throwable unused) {
                }
                a12.a();
                return true;
            } finally {
                a11.a();
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067 A[Catch: all -> 0x0051, LOOP:0: B:21:0x0061->B:23:0x0067, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:8:0x0034, B:10:0x0044, B:12:0x0047, B:15:0x004c, B:17:0x0056, B:20:0x005d, B:21:0x0061, B:23:0x0067), top: B:7:0x0034, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void c(java.lang.String r4) throws java.lang.Exception {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.String r2 = "update.lock"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.bykv.vk.openvk.preload.geckox.g.a r0 = com.bykv.vk.openvk.preload.geckox.g.a.a(r0)
            if (r0 == 0) goto La3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r2.<init>()     // Catch: java.lang.Throwable -> L92
            r2.append(r4)     // Catch: java.lang.Throwable -> L92
            r2.append(r1)     // Catch: java.lang.Throwable -> L92
            java.lang.String r1 = "select.lock"
            r2.append(r1)     // Catch: java.lang.Throwable -> L92
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L92
            com.bykv.vk.openvk.preload.geckox.g.b r1 = com.bykv.vk.openvk.preload.geckox.g.b.a(r1)     // Catch: java.lang.Throwable -> L92
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L51
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L51
            com.bykv.vk.openvk.preload.geckox.a.c$2 r4 = new com.bykv.vk.openvk.preload.geckox.a.c$2     // Catch: java.lang.Throwable -> L51
            r4.<init>()     // Catch: java.lang.Throwable -> L51
            java.io.File[] r4 = r2.listFiles(r4)     // Catch: java.lang.Throwable -> L51
            if (r4 == 0) goto L53
            int r2 = r4.length     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L53
            int r2 = r4.length     // Catch: java.lang.Throwable -> L51
            r3 = 1
            if (r2 != r3) goto L4c
            goto L53
        L4c:
            java.util.List r4 = a(r4)     // Catch: java.lang.Throwable -> L51
            goto L54
        L51:
            r4 = move-exception
            goto L9b
        L53:
            r4 = 0
        L54:
            if (r4 == 0) goto L94
            boolean r2 = r4.isEmpty()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L5d
            goto L94
        L5d:
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L51
        L61:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Throwable -> L51
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Throwable -> L51
            java.io.File r2 = (java.io.File) r2     // Catch: java.lang.Throwable -> L51
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            r3.<init>()     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L51
            r3.append(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L51
            r3.append(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "using.lock"
            r3.append(r2)     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L51
            com.bykv.vk.openvk.preload.geckox.g.c.c(r2)     // Catch: java.lang.Throwable -> L51
            goto L61
        L8b:
            r1.a()     // Catch: java.lang.Throwable -> L92
            r0.a()
            return
        L92:
            r4 = move-exception
            goto L9f
        L94:
            r1.a()     // Catch: java.lang.Throwable -> L92
            r0.a()
            return
        L9b:
            r1.a()     // Catch: java.lang.Throwable -> L92
            throw r4     // Catch: java.lang.Throwable -> L92
        L9f:
            r0.a()
            throw r4
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.a.c.c(java.lang.String):void");
    }
}
