package com.transsnet.loginapi.bean;

import androidx.annotation.Keep;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import com.transsion.usercenter.edit.C0709;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b#\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001c\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\t¨\u0006:"}, d2 = {"Lcom/transsnet/loginapi/bean/UserInfo;", "Ljava/io/Serializable;", "<init>", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "token", "getToken", "setToken", "username", "getUsername", "setUsername", "nickname", "getNickname", "setNickname", "avatar", "getAvatar", "setAvatar", "gender", "", "getGender", "()I", "setGender", "(I)V", "birthday", "getBirthday", "setBirthday", "age", "getAge", "setAge", PlaceTypes.COUNTRY, "getCountry", "setCountry", "province", "getProvince", "setProvince", "cc", "getCc", "setCc", "userType", "getUserType", "setUserType", "pcc", "getPcc", "setPcc", "shortId", "getShortId", "setShortId", "phone", "getPhone", "setPhone", "email", "getEmail", "setEmail", "LoginApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public class UserInfo implements Serializable {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f60short = {801, 829, 829, 825, 826, 883, 870, 870, 800, 802, 871, 800, 804, 808, 814, 812, 802, 800, 829, 871, 800, 806, 870, 817, 802, 894, 808, 807, 810, 826, 889, 880, 870, 891, 889, 891, 892, 889, 880, 888, 892, 790, 891, 888, 888, 880, 889, 892, 871, 825, 807, 814, 886, 828, 825, 813, 808, 829, 812, 813, 776, 829, 884, 888, 894, 892, 894, 880, 893, 892, 880, 894, 893, 895, 890, 893, 1728, 1762, 1769, 1709, 1743, 1780, 1709, 1733, 1772, 1763, 1781, 1781, 1780, 1728, 1762, 1769, 1783, -8528, -9482, 1384, 1354, 1345, 1285, 1383, 1372, 1285, 1389, 1348, 1355, 1373, 1373, 1372, 1384, 1354, 1345, 1375, -8936, -9890};

    @SerializedName("age")
    private int age;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("cc")
    private String cc;

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;
    private String email;

    @SerializedName("gender")
    private int gender;

    @SerializedName("nickname")
    private String nickname;
    private String pcc;

    @SerializedName("phone")
    private String phone;

    @SerializedName("province")
    private String province;

    @SerializedName("short_id")
    private String shortId;
    private String token;

    @SerializedName("userId")
    private String userId;
    private int userType;

    @SerializedName("username")
    private String username;

    public final int getAge() {
        return this.age;
    }

    public final String getAvatar() {
        String str = this.avatar;
        return C0723.m975(f60short, 0, 76, 841);
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCc() {
        return this.cc;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getNickname() {
        String str = this.nickname;
        return C0709.m958(f60short, 76, 19, 1677);
    }

    public final String getPcc() {
        return this.pcc;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getProvince() {
        return this.province;
    }

    public final String getShortId() {
        return this.shortId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUsername() {
        String str = this.username;
        return C0709.m958(f60short, 95, 19, 1317);
    }

    public final void setAge(int i11) {
        this.age = i11;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public final void setCc(String str) {
        this.cc = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final void setGender(int i11) {
        this.gender = i11;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setPcc(String str) {
        this.pcc = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setProvince(String str) {
        this.province = str;
    }

    public final void setShortId(String str) {
        this.shortId = str;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserType(int i11) {
        this.userType = i11;
    }

    public final void setUsername(String str) {
        this.username = str;
    }
}
