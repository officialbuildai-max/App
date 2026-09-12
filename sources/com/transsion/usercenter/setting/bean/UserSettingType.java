package com.transsion.usercenter.setting.bean;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/transsion/usercenter/setting/bean/UserSettingType;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE", "WATCH_OPTION", "FEEDBACK", "ABOUT_US", "LANGUAGE", "PRIVACY_POLICY", "USER_AGREEMENT", "LOGOUT", "INVITATION", "DEBUG", "NOTIFICATION", "DOWNLOAD_SWITCH", "PIP_SWITCH", "FAMILY_MODE", "AUTOPLAY", "PRIVACY_DATA_SETTING", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UserSettingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserSettingType[] $VALUES;
    public static final UserSettingType UPDATE = new UserSettingType("UPDATE", 0);
    public static final UserSettingType WATCH_OPTION = new UserSettingType("WATCH_OPTION", 1);
    public static final UserSettingType FEEDBACK = new UserSettingType("FEEDBACK", 2);
    public static final UserSettingType ABOUT_US = new UserSettingType("ABOUT_US", 3);
    public static final UserSettingType LANGUAGE = new UserSettingType("LANGUAGE", 4);
    public static final UserSettingType PRIVACY_POLICY = new UserSettingType("PRIVACY_POLICY", 5);
    public static final UserSettingType USER_AGREEMENT = new UserSettingType("USER_AGREEMENT", 6);
    public static final UserSettingType LOGOUT = new UserSettingType("LOGOUT", 7);
    public static final UserSettingType INVITATION = new UserSettingType("INVITATION", 8);
    public static final UserSettingType DEBUG = new UserSettingType("DEBUG", 9);
    public static final UserSettingType NOTIFICATION = new UserSettingType("NOTIFICATION", 10);
    public static final UserSettingType DOWNLOAD_SWITCH = new UserSettingType("DOWNLOAD_SWITCH", 11);
    public static final UserSettingType PIP_SWITCH = new UserSettingType("PIP_SWITCH", 12);
    public static final UserSettingType FAMILY_MODE = new UserSettingType("FAMILY_MODE", 13);
    public static final UserSettingType AUTOPLAY = new UserSettingType("AUTOPLAY", 14);
    public static final UserSettingType PRIVACY_DATA_SETTING = new UserSettingType("PRIVACY_DATA_SETTING", 15);

    private static final /* synthetic */ UserSettingType[] $values() {
        return new UserSettingType[]{UPDATE, WATCH_OPTION, FEEDBACK, ABOUT_US, LANGUAGE, PRIVACY_POLICY, USER_AGREEMENT, LOGOUT, INVITATION, DEBUG, NOTIFICATION, DOWNLOAD_SWITCH, PIP_SWITCH, FAMILY_MODE, AUTOPLAY, PRIVACY_DATA_SETTING};
    }

    static {
        UserSettingType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private UserSettingType(String str, int i11) {
    }

    public static EnumEntries<UserSettingType> getEntries() {
        return $ENTRIES;
    }

    public static UserSettingType valueOf(String str) {
        return (UserSettingType) Enum.valueOf(UserSettingType.class, str);
    }

    public static UserSettingType[] values() {
        return (UserSettingType[]) $VALUES.clone();
    }
}
