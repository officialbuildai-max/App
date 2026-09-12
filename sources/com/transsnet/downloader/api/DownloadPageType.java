package com.transsnet.downloader.api;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/transsnet/downloader/api/DownloadPageType;", "", "pageName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "DOWNLOAD", "SERIES", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class DownloadPageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DownloadPageType[] $VALUES;
    public static final DownloadPageType DOWNLOAD = new DownloadPageType("DOWNLOAD", 0, "downloadpage");
    public static final DownloadPageType SERIES = new DownloadPageType("SERIES", 1, "download_series");
    private String pageName;

    private static final /* synthetic */ DownloadPageType[] $values() {
        return new DownloadPageType[]{DOWNLOAD, SERIES};
    }

    static {
        DownloadPageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private DownloadPageType(String str, int i11, String str2) {
        this.pageName = str2;
    }

    public static EnumEntries<DownloadPageType> getEntries() {
        return $ENTRIES;
    }

    public static DownloadPageType valueOf(String str) {
        return (DownloadPageType) Enum.valueOf(DownloadPageType.class, str);
    }

    public static DownloadPageType[] values() {
        return (DownloadPageType[]) $VALUES.clone();
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final void setPageName(String str) {
        Intrinsics.h(str, "<set-?>");
        this.pageName = str;
    }
}
