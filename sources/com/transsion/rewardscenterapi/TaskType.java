package com.transsion.rewardscenterapi;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/transsion/rewardscenterapi/TaskType;", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TITLE", "WATCH_AD", "INVITE_USER", "WATCH", "DOWNLOAD_APP", "OPEN_APP", "PLAY_GAME", "DOWNLOAD_MOVIE", "CHECK_IN", "PALM_PAY", "GAME_RES_BROWSE", "GAME_RES_APP_DOWNLOAD", "AD_STAGE_1ST", "AD_STAGE_2ND", "AD_REGULAR_PULL_NEW", "AD_REWARD", "AD_REGULAR_PULL_LIVE", "DADA_STAGE_1ST", "DADA_STAGE_2ND", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class TaskType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TaskType[] $VALUES;
    private final int value;
    public static final TaskType TITLE = new TaskType("TITLE", 0, 0);
    public static final TaskType WATCH_AD = new TaskType("WATCH_AD", 1, 1);
    public static final TaskType INVITE_USER = new TaskType("INVITE_USER", 2, 2);
    public static final TaskType WATCH = new TaskType("WATCH", 3, 3);
    public static final TaskType DOWNLOAD_APP = new TaskType("DOWNLOAD_APP", 4, 4);
    public static final TaskType OPEN_APP = new TaskType("OPEN_APP", 5, 5);
    public static final TaskType PLAY_GAME = new TaskType("PLAY_GAME", 6, 6);
    public static final TaskType DOWNLOAD_MOVIE = new TaskType("DOWNLOAD_MOVIE", 7, 7);
    public static final TaskType CHECK_IN = new TaskType("CHECK_IN", 8, 8);
    public static final TaskType PALM_PAY = new TaskType("PALM_PAY", 9, 10);
    public static final TaskType GAME_RES_BROWSE = new TaskType("GAME_RES_BROWSE", 10, 11);
    public static final TaskType GAME_RES_APP_DOWNLOAD = new TaskType("GAME_RES_APP_DOWNLOAD", 11, 12);
    public static final TaskType AD_STAGE_1ST = new TaskType("AD_STAGE_1ST", 12, 14);
    public static final TaskType AD_STAGE_2ND = new TaskType("AD_STAGE_2ND", 13, 15);
    public static final TaskType AD_REGULAR_PULL_NEW = new TaskType("AD_REGULAR_PULL_NEW", 14, 16);
    public static final TaskType AD_REWARD = new TaskType("AD_REWARD", 15, 17);
    public static final TaskType AD_REGULAR_PULL_LIVE = new TaskType("AD_REGULAR_PULL_LIVE", 16, 18);
    public static final TaskType DADA_STAGE_1ST = new TaskType("DADA_STAGE_1ST", 17, 20);
    public static final TaskType DADA_STAGE_2ND = new TaskType("DADA_STAGE_2ND", 18, 21);

    private static final /* synthetic */ TaskType[] $values() {
        return new TaskType[]{TITLE, WATCH_AD, INVITE_USER, WATCH, DOWNLOAD_APP, OPEN_APP, PLAY_GAME, DOWNLOAD_MOVIE, CHECK_IN, PALM_PAY, GAME_RES_BROWSE, GAME_RES_APP_DOWNLOAD, AD_STAGE_1ST, AD_STAGE_2ND, AD_REGULAR_PULL_NEW, AD_REWARD, AD_REGULAR_PULL_LIVE, DADA_STAGE_1ST, DADA_STAGE_2ND};
    }

    static {
        TaskType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private TaskType(String str, int i11, int i12) {
        this.value = i12;
    }

    public static EnumEntries<TaskType> getEntries() {
        return $ENTRIES;
    }

    public static TaskType valueOf(String str) {
        return (TaskType) Enum.valueOf(TaskType.class, str);
    }

    public static TaskType[] values() {
        return (TaskType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
