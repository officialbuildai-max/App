package com.transsion.pushapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/transsion/pushapi/NoticePermissionFrom;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_START", "DOWNLOAD_RES", "PLAY_MUSIC", "DETAIL_NO_RES", "WANT_TO_SEE", "PushApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class NoticePermissionFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NoticePermissionFrom[] $VALUES;
    private final String value;
    public static final NoticePermissionFrom APP_START = new NoticePermissionFrom("APP_START", 0, "cold_start");
    public static final NoticePermissionFrom DOWNLOAD_RES = new NoticePermissionFrom("DOWNLOAD_RES", 1, "download_res");
    public static final NoticePermissionFrom PLAY_MUSIC = new NoticePermissionFrom("PLAY_MUSIC", 2, "play_music");
    public static final NoticePermissionFrom DETAIL_NO_RES = new NoticePermissionFrom("DETAIL_NO_RES", 3, "subject_detail_no_res");
    public static final NoticePermissionFrom WANT_TO_SEE = new NoticePermissionFrom("WANT_TO_SEE", 4, "want_to_see");

    private static final /* synthetic */ NoticePermissionFrom[] $values() {
        return new NoticePermissionFrom[]{APP_START, DOWNLOAD_RES, PLAY_MUSIC, DETAIL_NO_RES, WANT_TO_SEE};
    }

    static {
        NoticePermissionFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private NoticePermissionFrom(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<NoticePermissionFrom> getEntries() {
        return $ENTRIES;
    }

    public static NoticePermissionFrom valueOf(String str) {
        return (NoticePermissionFrom) Enum.valueOf(NoticePermissionFrom.class, str);
    }

    public static NoticePermissionFrom[] values() {
        return (NoticePermissionFrom[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
