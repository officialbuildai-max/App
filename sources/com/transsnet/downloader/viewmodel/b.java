package com.transsnet.downloader.viewmodel;

import com.transsion.baselib.db.download.DownloadBean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f60210a;

    /* renamed from: b, reason: collision with root package name */
    private final String f60211b;

    /* renamed from: c, reason: collision with root package name */
    private final DownloadBean f60212c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f60213d;

    public b(int i11, String formatSize, DownloadBean downloadBean, boolean z10) {
        Intrinsics.h(formatSize, "formatSize");
        Intrinsics.h(downloadBean, "downloadBean");
        this.f60210a = i11;
        this.f60211b = formatSize;
        this.f60212c = downloadBean;
        this.f60213d = z10;
    }

    public final int a() {
        return this.f60210a;
    }

    public final DownloadBean b() {
        return this.f60212c;
    }

    public final String c() {
        return this.f60211b;
    }

    public final boolean d() {
        return this.f60213d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f60210a == bVar.f60210a && Intrinsics.c(this.f60211b, bVar.f60211b) && Intrinsics.c(this.f60212c, bVar.f60212c) && this.f60213d == bVar.f60213d;
    }

    public int hashCode() {
        return (((((this.f60210a * 31) + this.f60211b.hashCode()) * 31) + this.f60212c.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f60213d);
    }

    public String toString() {
        return "Download2ResultContent(count=" + this.f60210a + ", formatSize=" + this.f60211b + ", downloadBean=" + this.f60212c + ", isCancel=" + this.f60213d + ")";
    }
}
