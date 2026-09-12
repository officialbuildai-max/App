package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.util.Comparator;

/* loaded from: classes7.dex */
public abstract class ZipFile implements Closeable {

    /* renamed from: org.apache.commons.compress.archivers.zip.ZipFile$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements Comparator<ZipArchiveEntry> {
        final /* synthetic */ ZipFile this$0;

        AnonymousClass2(ZipFile zipFile) {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ZipArchiveEntry zipArchiveEntry, ZipArchiveEntry zipArchiveEntry2) {
            android.support.v4.media.session.c.a(zipArchiveEntry);
            android.support.v4.media.session.c.a(zipArchiveEntry2);
            return compare2((ZipArchiveEntry) null, (ZipArchiveEntry) null);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ZipArchiveEntry zipArchiveEntry, ZipArchiveEntry zipArchiveEntry2) {
            return zipArchiveEntry == zipArchiveEntry2 ? 0 : 1;
        }
    }
}
