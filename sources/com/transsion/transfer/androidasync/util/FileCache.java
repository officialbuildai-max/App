package com.transsion.transfer.androidasync.util;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes6.dex */
public abstract class FileCache {

    /* renamed from: com.transsion.transfer.androidasync.util.FileCache$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Comparator<File> {
        final /* synthetic */ FileCache this$0;

        AnonymousClass1(FileCache fileCache) {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified < lastModified2) {
                return -1;
            }
            return lastModified2 > lastModified ? 1 : 0;
        }
    }

    /* renamed from: com.transsion.transfer.androidasync.util.FileCache$2, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 extends Thread {
        final /* synthetic */ FileCache this$0;

        AnonymousClass2(FileCache fileCache) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}
