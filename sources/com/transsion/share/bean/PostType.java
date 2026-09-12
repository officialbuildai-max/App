package com.transsion.share.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/transsion/share/bean/PostType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN_TYPE", "SUBJECT_TYPE", "GROUP_TYPE", "POST_TYPE", "STAFF_TYPE", "SHORT_TV_TYPE", "LIVE_TYPE", "UGC_VIDEO", "UGC_SHORT_TV", "ShareLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class PostType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PostType[] $VALUES;
    private final String value;
    public static final PostType UNKNOWN_TYPE = new PostType("UNKNOWN_TYPE", 0, "UnknownType");
    public static final PostType SUBJECT_TYPE = new PostType("SUBJECT_TYPE", 1, "SubjectType");
    public static final PostType GROUP_TYPE = new PostType("GROUP_TYPE", 2, "GroupType");
    public static final PostType POST_TYPE = new PostType("POST_TYPE", 3, "PostType");
    public static final PostType STAFF_TYPE = new PostType("STAFF_TYPE", 4, "StaffType");
    public static final PostType SHORT_TV_TYPE = new PostType("SHORT_TV_TYPE", 5, "ShortTVType");
    public static final PostType LIVE_TYPE = new PostType("LIVE_TYPE", 6, "Live");
    public static final PostType UGC_VIDEO = new PostType("UGC_VIDEO", 7, "UGCVideo");
    public static final PostType UGC_SHORT_TV = new PostType("UGC_SHORT_TV", 8, "UGCShortTV");

    private static final /* synthetic */ PostType[] $values() {
        return new PostType[]{UNKNOWN_TYPE, SUBJECT_TYPE, GROUP_TYPE, POST_TYPE, STAFF_TYPE, SHORT_TV_TYPE, LIVE_TYPE, UGC_VIDEO, UGC_SHORT_TV};
    }

    static {
        PostType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PostType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<PostType> getEntries() {
        return $ENTRIES;
    }

    public static PostType valueOf(String str) {
        return (PostType) Enum.valueOf(PostType.class, str);
    }

    public static PostType[] values() {
        return (PostType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
