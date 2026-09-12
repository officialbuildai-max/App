package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.gson.annotations.SerializedName;
import com.transsion.usercenter.edit.C0709;
import com.transsnet.loginapi.bean.C0720;
import com.transsnet.loginapi.bean.C0723;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/transsion/moviedetailapi/bean/User;", "Ljava/io/Serializable;", "avatar", "", "nickname", "userId", "username", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getNickname", "setNickname", "getUserId", "setUserId", "getUsername", "setUsername", "component1", "component2", "component3", "component4", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "", "toString", "MovieDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final /* data */ class User implements Serializable {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f46short = {1191, 1211, 1211, 1215, 1212, 1269, 1248, 1248, 1190, 1188, 1249, 1190, 1186, 1198, 1192, 1194, 1188, 1190, 1211, 1249, 1190, 1184, 1248, 1207, 1188, 1272, 1198, 1185, 1196, 1212, 1279, 1270, 1248, 1277, 1279, 1277, 1274, 1279, 1270, 1278, 1274, 1168, 1277, 1278, 1278, 1270, 1279, 1274, 1249, 1215, 1185, 1192, 1264, 1210, 1215, 1195, 1198, 1211, 1194, 1195, 1166, 1211, 1266, 1278, 1272, 1274, 1272, 1270, 1275, 1274, 1270, 1272, 1275, 1273, 1276, 1275, 1420, 1450, 1468, 1451, 1521, 1464, 1455, 1464, 1453, 1464, 1451, 1508, 2473, 2469, 2539, 2540, 2534, 2542, 2539, 2532, 2536, 2528, 2488, 2567, 2571, 2654, 2648, 2638, 2649, 2658, 2639, 2582, 2138, 2134, 2051, 2053, 2067, 2052, 2072, 2071, 2075, 2067, 2123, 1468};

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("userId")
    private String userId;

    @SerializedName("username")
    private String username;

    public User(String str, String str2, String str3, String str4) {
        this.avatar = str;
        this.nickname = str2;
        this.userId = str3;
        this.username = str4;
    }

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = user.avatar;
        }
        if ((i11 & 2) != 0) {
            str2 = user.nickname;
        }
        if ((i11 & 4) != 0) {
            str3 = user.userId;
        }
        if ((i11 & 8) != 0) {
            str4 = user.username;
        }
        return user.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.username;
    }

    public final User copy(String avatar, String nickname, String userId, String username) {
        return new User(avatar, nickname, userId, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.c(this.avatar, user.avatar) && Intrinsics.c(this.nickname, user.nickname) && Intrinsics.c(this.userId, user.userId) && Intrinsics.c(this.username, user.username);
    }

    public final String getAvatar() {
        String str = this.avatar;
        return C0720.m966(f46short, 0, 76, 1231);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickname;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.username;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        return C0723.m975(f46short, 76, 12, 1497) + this.avatar + C0720.m966(f46short, 88, 11, 2437) + this.nickname + C0709.m958(f46short, 99, 9, 2603) + this.userId + C0709.m958(f46short, TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY, 11, 2166) + this.username + C0720.m966(f46short, Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 1, 1429);
    }
}
