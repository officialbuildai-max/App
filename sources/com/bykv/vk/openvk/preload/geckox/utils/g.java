package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes2.dex */
public final class g {
    public static Long a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.utils.g.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        Long l11 = null;
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                try {
                    Long valueOf = Long.valueOf(file2.getName());
                    long longValue = valueOf.longValue();
                    if (l11 == null || longValue > l11.longValue()) {
                        l11 = valueOf;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return l11;
    }
}
