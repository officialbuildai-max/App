package com.transsion.moviedetailapi.bean;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/transsion/moviedetailapi/bean/MediaType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT", "IMAGE", "IMAGE_SINGLE", "AUDIO", "VIDEO", "GIF", "SUBJECT_DETAIL_NATIVE_AD", "POST_DETAIL_FOR_YOU_NATIVE_AD", "CONTENT_ALL", "ROOM_LIST", "ROOM_CACHE_LIST_START", "ROOM_CACHE_LIST_END", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class MediaType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MediaType[] $VALUES;
    private final String value;
    public static final MediaType TEXT = new MediaType("TEXT", 0, "NONE");
    public static final MediaType IMAGE = new MediaType("IMAGE", 1, "IMAGE");
    public static final MediaType IMAGE_SINGLE = new MediaType("IMAGE_SINGLE", 2, "IMAGE_SINGLE");
    public static final MediaType AUDIO = new MediaType("AUDIO", 3, "AUDIO");
    public static final MediaType VIDEO = new MediaType("VIDEO", 4, "VIDEO");
    public static final MediaType GIF = new MediaType("GIF", 5, "GIF");
    public static final MediaType SUBJECT_DETAIL_NATIVE_AD = new MediaType("SUBJECT_DETAIL_NATIVE_AD", 6, "SUBJECT_DETAIL_NATIVE_AD");
    public static final MediaType POST_DETAIL_FOR_YOU_NATIVE_AD = new MediaType("POST_DETAIL_FOR_YOU_NATIVE_AD", 7, "POST_DETAIL_FOR_YOU_NATIVE_AD");
    public static final MediaType CONTENT_ALL = new MediaType("CONTENT_ALL", 8, "CONTENT_ALL");
    public static final MediaType ROOM_LIST = new MediaType("ROOM_LIST", 9, "ROOM_LIST");
    public static final MediaType ROOM_CACHE_LIST_START = new MediaType("ROOM_CACHE_LIST_START", 10, "ROOM_CACHE_LIST_START");
    public static final MediaType ROOM_CACHE_LIST_END = new MediaType("ROOM_CACHE_LIST_END", 11, "ROOM_CACHE_LIST_END");

    private static final /* synthetic */ MediaType[] $values() {
        return new MediaType[]{TEXT, IMAGE, IMAGE_SINGLE, AUDIO, VIDEO, GIF, SUBJECT_DETAIL_NATIVE_AD, POST_DETAIL_FOR_YOU_NATIVE_AD, CONTENT_ALL, ROOM_LIST, ROOM_CACHE_LIST_START, ROOM_CACHE_LIST_END};
    }

    static {
        MediaType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private MediaType(String str, int i11, String str2) {
        this.value = str2;
    }

    public static EnumEntries<MediaType> getEntries() {
        return $ENTRIES;
    }

    public static MediaType valueOf(String str) {
        return (MediaType) Enum.valueOf(MediaType.class, str);
    }

    public static MediaType[] values() {
        return (MediaType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
