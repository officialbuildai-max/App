package com.transsion.lib_web.download_render.init;

import gm.i;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final C0629a f46232a = new C0629a(null);

    /* renamed from: b, reason: collision with root package name */
    private static long f46233b = 104857600;

    /* renamed from: c, reason: collision with root package name */
    private static long f46234c = 2592000000L;

    /* renamed from: d, reason: collision with root package name */
    private static long f46235d = 2592000000L;

    /* renamed from: com.transsion.lib_web.download_render.init.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0629a {
        private C0629a() {
        }

        public /* synthetic */ C0629a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(Map map) {
        String str;
        String path;
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = 0;
        Object obj = null;
        for (Map.Entry entry : map.entrySet()) {
            j11 += ((FileInfo) entry.getValue()).getSize();
            if (currentTimeMillis > ((FileInfo) entry.getValue()).getUsedTime()) {
                currentTimeMillis = ((FileInfo) entry.getValue()).getUsedTime();
                obj = entry.getValue();
            }
        }
        if (j11 > f46233b) {
            FileInfo fileInfo = (FileInfo) obj;
            i.f64006a.a("DR_", "<cacheSizeCheck> deleteFile url: " + (fileInfo != null ? fileInfo.getUrl() : null));
            String str2 = "";
            if (fileInfo == null || (str = fileInfo.getUrl()) == null) {
                str = "";
            }
            if (fileInfo != null && (path = fileInfo.getPath()) != null) {
                str2 = path;
            }
            b(str, new File(str2));
            com.transsion.lib_web.download_render.c.f46221a.d(fileInfo != null ? fileInfo.getUrl() : null);
            TypeIntrinsics.d(map).remove(fileInfo != null ? fileInfo.getUrl() : null);
            a(map);
        }
    }

    private final void b(String str, File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Intrinsics.e(file2);
                        b(str, file2);
                        file2.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        file2.delete();
                        Intrinsics.e(absolutePath);
                        int o02 = StringsKt.o0(absolutePath, "https:", 0, false, 6, null);
                        if (o02 != -1) {
                            String substring = absolutePath.substring(o02, absolutePath.length());
                            Intrinsics.g(substring, "substring(...)");
                            com.transsion.lib_web.download_render.c.f46221a.c(str, StringsKt.Q(substring, "https:/", "https://", false, 4, null));
                        }
                    }
                }
            }
            file.delete();
        }
    }

    private final long c(File file) {
        long length;
        long j11 = 0;
        if (!file.exists()) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    Intrinsics.e(file2);
                    length = c(file2);
                } else {
                    length = file2.length();
                }
                j11 += length;
            }
        }
        return j11;
    }

    private final void d(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (System.currentTimeMillis() - ((FileInfo) entry.getValue()).getUsedTime() > f46234c && System.currentTimeMillis() - ((FileInfo) entry.getValue()).getUpgradeTime() > f46235d) {
                i.f64006a.a("DR_", "<validTimeCheck> deleteFile url: " + ((FileInfo) entry.getValue()).getUrl());
                b(((FileInfo) entry.getValue()).getUrl(), new File(((FileInfo) entry.getValue()).getPath()));
                com.transsion.lib_web.download_render.c.f46221a.d(((FileInfo) entry.getValue()).getUrl());
                it.remove();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r9 == null) goto L11;
     */
    @Override // com.transsion.lib_web.download_render.init.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void invoke() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.lib_web.download_render.init.a.invoke():void");
    }
}
