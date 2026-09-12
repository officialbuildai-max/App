package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.common.Scopes;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import com.transsion.usercenter.edit.C0709;
import com.transsnet.loginapi.bean.C0720;
import com.transsnet.loginapi.bean.C0721;
import com.transsnet.loginapi.bean.C0723;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0001AB\u009d\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0018J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0016JÄ\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00101\u001a\u0004\b2\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b3\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b4\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b5\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b6\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b7\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u00101\u001a\u0004\b8\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b9\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b:\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b;\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b<\u0010\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b=\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b>\u0010\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b?\u0010\u0016¨\u0006B"}, d2 = {"Lcom/transsion/usercenter/profile/bean/BffUserInfo;", "", "", "userId", "", "userType", "username", "nickname", "avatar", "gender", "birthday", "age", PlaceTypes.COUNTRY, "province", "city", "cc", "phone", "email", Scopes.PROFILE, "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/transsion/usercenter/profile/bean/BffUserInfo;", "toString", "hashCode", "()I", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUserId", "Ljava/lang/Integer;", "getUserType", "getUsername", "getNickname", "getAvatar", "getGender", "getBirthday", "getAge", "getCountry", "getProvince", "getCity", "getCc", "getPhone", "getEmail", "getProfile", "Companion", "a", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final /* data */ class BffUserInfo {
    public static final int USER_TYPE_FORMAL = 1;
    public static final int USER_TYPE_GUEST = 0;
    public static final int USER_TYPE_MOCK = 2;

    @SerializedName("age")
    private final Integer age;

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("birthday")
    private final String birthday;

    @SerializedName("cc")
    private final String cc;

    @SerializedName("city")
    private final String city;

    @SerializedName(PlaceTypes.COUNTRY)
    private final String country;

    @SerializedName("mail")
    private final String email;

    @SerializedName("gender")
    private final Integer gender;

    @SerializedName("nickname")
    private final String nickname;

    @SerializedName("phone")
    private final String phone;

    @SerializedName(Scopes.PROFILE)
    private final String profile;

    @SerializedName("province")
    private final String province;

    @SerializedName("userId")
    private final String userId;

    @SerializedName("userType")
    private final Integer userType;

    @SerializedName("username")
    private final String username;

    /* renamed from: short, reason: not valid java name */
    private static final short[] f59short = {1608, 1620, 1620, 1616, 1619, 1562, 1551, 1551, 1609, 1611, 1550, 1609, 1613, 1601, 1607, 1605, 1611, 1609, 1620, 1550, 1609, 1615, 1551, 1624, 1611, 1559, 1601, 1614, 1603, 1619, 1552, 1561, 1551, 1554, 1552, 1554, 1557, 1552, 1561, 1553, 1557, 1663, 1554, 1553, 1553, 1561, 1552, 1557, 1550, 1616, 1614, 1607, 1567, 1621, 1616, 1604, 1601, 1620, 1605, 1604, 1633, 1620, 1565, 1553, 1559, 1557, 1559, 1561, 1556, 1557, 1561, 1559, 1556, 1558, 1555, 1556, 1861, 1895, 1900, 1832, 1866, 1905, 1832, 1856, 1897, 1894, 1904, 1904, 1905, 1861, 1895, 1900, 1906, 1832, -8395, -9357, 2593, 2563, 2568, 2636, 2606, 2581, 2636, 2596, 2573, 2562, 2580, 2580, 2581, 2593, 2563, 2568, 2582, -11695, -10729, 2435, 2471, 2471, 2452, 2482, 2468, 2483, 2440, 2479, 2471, 2478, 2537, 2484, 2482, 2468, 2483, 2440, 2469, 2556, 943, 931, 1014, 1008, 998, 1009, 983, 1018, 1011, 998, 958, 1056, 1068, 1145, 1151, 1129, 1150, 1122, 1133, 1121, 1129, 1073, 2184, 2180, 2250, 2253, 2247, 2255, 2250, 2245, 2249, 2241, 2201, 386, 398, 463, 472, 463, 474, 463, 476, 403, 2874, 2870, 2929, 2931, 2936, 2930, 2931, 2916, 2859, 629, 633, 571, 560, 555, 557, 561, 573, 568, 544, 612, 376, 372, 309, 307, 305, 361, 2506, 2502, 2437, 2441, 2451, 2440, 2450, 2452, 2463, 2523, 1869, 1857, 1809, 1811, 1806, 1815, 1800, 1807, 1794, 1796, 1884, 1585, 1597, 1662, 1652, 1641, 1636, 1568, 1712, 1724, 1791, 1791, 1697, 911, 899, 979, 971, 972, 973, 966, 926, 597, 601, 540, 532, 536, 528, 533, 580, 2082, 2094, 2174, 2172, 2145, 2152, 2151, 2146, 2155, 2099, 1705};

    public BffUserInfo(String str, Integer num, String str2, String str3, String str4, Integer num2, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.userId = str;
        this.userType = num;
        this.username = str2;
        this.nickname = str3;
        this.avatar = str4;
        this.gender = num2;
        this.birthday = str5;
        this.age = num3;
        this.country = str6;
        this.province = str7;
        this.city = str8;
        this.cc = str9;
        this.phone = str10;
        this.email = str11;
        this.profile = str12;
    }

    public final String component1() {
        return this.userId;
    }

    public final String component10() {
        return this.province;
    }

    public final String component11() {
        return this.city;
    }

    public final String component12() {
        return this.cc;
    }

    public final String component13() {
        return this.phone;
    }

    public final String component14() {
        return this.email;
    }

    public final String component15() {
        return this.profile;
    }

    public final Integer component2() {
        return this.userType;
    }

    public final String component3() {
        return this.username;
    }

    public final String component4() {
        return this.nickname;
    }

    public final String component5() {
        return this.avatar;
    }

    public final Integer component6() {
        return this.gender;
    }

    public final String component7() {
        return this.birthday;
    }

    public final Integer component8() {
        return this.age;
    }

    public final String component9() {
        return this.country;
    }

    public final BffUserInfo copy(String userId, Integer userType, String username, String nickname, String avatar, Integer gender, String birthday, Integer age, String country, String province, String city, String cc2, String phone, String email, String profile) {
        return new BffUserInfo(userId, userType, username, nickname, avatar, gender, birthday, age, country, province, city, cc2, phone, email, profile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BffUserInfo)) {
            return false;
        }
        BffUserInfo bffUserInfo = (BffUserInfo) other;
        return Intrinsics.c(this.userId, bffUserInfo.userId) && Intrinsics.c(this.userType, bffUserInfo.userType) && Intrinsics.c(this.username, bffUserInfo.username) && Intrinsics.c(this.nickname, bffUserInfo.nickname) && Intrinsics.c(this.avatar, bffUserInfo.avatar) && Intrinsics.c(this.gender, bffUserInfo.gender) && Intrinsics.c(this.birthday, bffUserInfo.birthday) && Intrinsics.c(this.age, bffUserInfo.age) && Intrinsics.c(this.country, bffUserInfo.country) && Intrinsics.c(this.province, bffUserInfo.province) && Intrinsics.c(this.city, bffUserInfo.city) && Intrinsics.c(this.cc, bffUserInfo.cc) && Intrinsics.c(this.phone, bffUserInfo.phone) && Intrinsics.c(this.email, bffUserInfo.email) && Intrinsics.c(this.profile, bffUserInfo.profile);
    }

    public final Integer getAge() {
        return this.age;
    }

    public final String getAvatar() {
        String str = this.avatar;
        return C0720.m966(f59short, 0, 76, 1568);
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCc() {
        return this.cc;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final String getNickname() {
        String str = this.nickname;
        return C0720.m966(f59short, 76, 20, 1800);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getProfile() {
        return this.profile;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Integer getUserType() {
        return this.userType;
    }

    public final String getUsername() {
        String str = this.username;
        return C0721.m969(f59short, 96, 19, 2668);
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.userType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.username;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.gender;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.birthday;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.age;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str6 = this.country;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.province;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.city;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.cc;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.phone;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.email;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.profile;
        return hashCode14 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        return C0721.m969(f59short, Sdk$SDKError.Reason.INVALID_INDEX_URL_VALUE, 19, 2497) + this.userId + C0723.m975(f59short, 134, 11, 899) + this.userType + C0721.m969(f59short, 145, 11, 1036) + this.username + C0709.m958(f59short, 156, 11, 2212) + this.nickname + C0720.m966(f59short, 167, 9, 430) + this.avatar + C0709.m958(f59short, 176, 9, 2838) + this.gender + C0721.m969(f59short, 185, 11, PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY) + this.birthday + C0721.m969(f59short, 196, 6, 340) + this.age + C0720.m966(f59short, Sdk$SDKError.Reason.AD_CONSUMED_VALUE, 10, 2534) + this.country + C0723.m975(f59short, Sdk$SDKError.Reason.PLACEMENT_SLEEP_VALUE, 11, 1889) + this.province + C0723.m975(f59short, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 7, 1565) + this.city + C0721.m969(f59short, 230, 5, 1692) + this.cc + C0709.m958(f59short, 235, 8, 931) + this.phone + C0723.m975(f59short, 243, 8, 633) + this.email + C0709.m958(f59short, 251, 10, 2062) + this.profile + C0720.m966(f59short, 261, 1, 1664);
    }
}
