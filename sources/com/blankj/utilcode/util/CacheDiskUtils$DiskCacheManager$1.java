package com.blankj.utilcode.util;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
class CacheDiskUtils$DiskCacheManager$1 implements Runnable {
    final /* synthetic */ e this$0;
    final /* synthetic */ File val$cacheDir;

    /* loaded from: classes2.dex */
    class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("cdu_");
        }
    }

    CacheDiskUtils$DiskCacheManager$1(e eVar, File file) {
        this.val$cacheDir = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] listFiles = this.val$cacheDir.listFiles(new a());
        if (listFiles != null) {
            int i11 = 0;
            int i12 = 0;
            for (File file : listFiles) {
                i11 = (int) (i11 + file.length());
                i12++;
                e.a(null).put(file, Long.valueOf(file.lastModified()));
            }
            e.b(null).getAndAdd(i11);
            e.c(null).getAndAdd(i12);
        }
    }
}
