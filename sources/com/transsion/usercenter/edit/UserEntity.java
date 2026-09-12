package com.transsion.usercenter.edit;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.annotations.SerializedName;
import com.transsnet.loginapi.bean.C0720;
import com.transsnet.loginapi.bean.C0721;
import com.transsnet.loginapi.bean.C0723;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010=\u001a\u000200J\u0006\u0010>\u001a\u000200R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u001cR \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\u001cR \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\u001cR \u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\u001cR \u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\u001cR \u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\u001cR\"\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b5\u00101\"\u0004\b6\u00103R \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\u001cR\u001e\u0010:\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\u001cR\u001a\u0010?\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u001c¨\u0006B"}, d2 = {"Lcom/transsion/usercenter/edit/UserEntity;", "Ljava/io/Serializable;", "<init>", "()V", "FEMALE", "", "getFEMALE", "()Ljava/lang/String;", "MALE", "getMALE", "videos", "", "getVideos", "()I", "setVideos", "(I)V", "likes", "getLikes", "setLikes", "following", "getFollowing", "setFollowing", "follower", "getFollower", "setFollower", "name", "getName", "setName", "(Ljava/lang/String;)V", "sex", "getSex", "setSex", "birthday", "getBirthday", "setBirthday", "city", "getCity", "setCity", PlaceTypes.COUNTRY, "getCountry", "setCountry", "age", "getAge", "setAge", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "isFollowHe", "", "()Ljava/lang/Boolean;", "setFollowHe", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFollowMe", "setFollowMe", "userId", "getUserId", "setUserId", "receiveLikes", "getReceiveLikes", "setReceiveLikes", "isFemale", "isMale", "tokenUpload", "getTokenUpload", "setTokenUpload", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class UserEntity implements Serializable {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f57short = {1395, 1174, 2708, 2696, 2696, 2700, 2703, 2758, 2771, 2771, 2709, 2711, 2770, 2709, 2705, 2717, 2715, 2713, 2711, 2709, 2696, 2770, 2709, 2707, 2771, 2692, 2711, 2763, 2717, 2706, 2719, 2703, 2764, 2757, 2771, 2766, 2764, 2766, 2761, 2764, 2757, 2765, 2761, 2723, 2766, 2765, 2765, 2757, 2764, 2761, 2770, 2700, 2706, 2715, 2755, 2697, 2700, 2712, 2717, 2696, 2713, 2712, 2749, 2696, 2753, 2765, 2763, 2761, 2763, 2757, 2760, 2761, 2757, 2763, 2760, 2762, 2767, 2760, 2441, 2502, 2512, 2497, 2456, 2442, 2443, 1695, 1744, 1734, 1751, 1678, 1692, 1693};

    @SerializedName("age")
    private String age;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("city")
    private String city;

    @SerializedName(PlaceTypes.COUNTRY)
    private String country;

    @SerializedName("follower")
    private int follower;

    @SerializedName("following")
    private int following;

    @SerializedName("is_follow_he")
    private Boolean isFollowHe;

    @SerializedName("is_follow_me")
    private Boolean isFollowMe;

    @SerializedName("likes")
    private int likes;

    @SerializedName(alternate = {"user_name"}, value = "name")
    private String name;

    @SerializedName("sex")
    private String sex;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("videos")
    private int videos;
    private final String FEMALE = C0721.m969(f57short, 0, 1, 1333);
    private final String MALE = C0721.m969(f57short, 1, 1, 1243);

    @SerializedName("receive_likes")
    private String receiveLikes = "";
    private String tokenUpload = "";

    public final String getAge() {
        return this.age;
    }

    public final String getAvatarUrl() {
        String str = this.avatarUrl;
        return C0720.m966(f57short, 2, 76, 2812);
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getFEMALE() {
        return this.FEMALE;
    }

    public final int getFollower() {
        return this.follower;
    }

    public final int getFollowing() {
        return this.following;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final String getMALE() {
        return this.MALE;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReceiveLikes() {
        return this.receiveLikes;
    }

    public final String getSex() {
        return this.sex;
    }

    public final String getTokenUpload() {
        return this.tokenUpload;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getVideos() {
        return this.videos;
    }

    public final boolean isFemale() {
        return Intrinsics.c(this.FEMALE, this.sex);
    }

    public final Boolean isFollowHe() {
        return this.isFollowHe;
    }

    public final Boolean isFollowMe() {
        return this.isFollowMe;
    }

    public final boolean isMale() {
        return Intrinsics.c(this.MALE, this.sex);
    }

    public final void setAge(String str) {
        this.age = str;
    }

    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setFollowHe(Boolean bool) {
        this.isFollowHe = bool;
    }

    public final void setFollowMe(Boolean bool) {
        this.isFollowMe = bool;
    }

    public final void setFollower(int i11) {
        this.follower = i11;
    }

    public final void setFollowing(int i11) {
        this.following = i11;
    }

    public final void setLikes(int i11) {
        this.likes = i11;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setReceiveLikes(String str) {
        Intrinsics.h(str, C0709.m958(f57short, 78, 7, 2485));
        this.receiveLikes = str;
    }

    public final void setSex(String str) {
        this.sex = str;
    }

    public final void setTokenUpload(String str) {
        Intrinsics.h(str, C0723.m975(f57short, 85, 7, 1699));
        this.tokenUpload = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setVideos(int i11) {
        this.videos = i11;
    }
}
