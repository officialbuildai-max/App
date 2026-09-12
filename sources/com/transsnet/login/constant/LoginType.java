package com.transsnet.login.constant;

import com.cloud.tmc.miniutils.constant.PermissionConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsnet/login/constant/LoginType;", "", "<init>", "(Ljava/lang/String;I)V", PermissionConstants.PHONE, "EMAIL", "Login_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class LoginType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoginType[] $VALUES;
    public static final LoginType PHONE = new LoginType(PermissionConstants.PHONE, 0);
    public static final LoginType EMAIL = new LoginType("EMAIL", 1);

    private static final /* synthetic */ LoginType[] $values() {
        return new LoginType[]{PHONE, EMAIL};
    }

    static {
        LoginType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LoginType(String str, int i11) {
    }

    public static EnumEntries<LoginType> getEntries() {
        return $ENTRIES;
    }

    public static LoginType valueOf(String str) {
        return (LoginType) Enum.valueOf(LoginType.class, str);
    }

    public static LoginType[] values() {
        return (LoginType[]) $VALUES.clone();
    }
}
