package com.transsion.home.hashtag;

import android.app.Application;
import androidx.annotation.Keep;
import androidx.view.LiveData;
import androidx.view.b;
import androidx.view.b0;
import androidx.view.u0;
import bh.b;
import com.blankj.utilcode.util.o;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.gson.annotations.SerializedName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.Utils;
import com.transsion.home.R$string;
import com.transsion.home.bean.RefreshBaseDto;
import com.transsion.home.hashtag.model.HashTagItem;
import com.transsion.home.hashtag.model.HashTagItemType;
import com.transsion.home.hashtag.model.HashTagTab;
import com.transsion.home.net.HashTagListRequest;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
import com.transsion.ugcvideodetail.api.bean.UGCContentList;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoHashTag;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;
import okhttp3.RequestBody;
import ol.a;
import zg.c;

/* loaded from: classes5.dex */
public final class HashTagViewModel extends b {

    /* renamed from: b, reason: collision with root package name */
    private final Application f45572b;

    /* renamed from: c, reason: collision with root package name */
    private final a f45573c;

    /* renamed from: d, reason: collision with root package name */
    private List f45574d;

    /* renamed from: e, reason: collision with root package name */
    private UGCVideoHashTag f45575e;

    /* renamed from: f, reason: collision with root package name */
    private List f45576f;

    /* renamed from: g, reason: collision with root package name */
    private String f45577g;

    /* renamed from: h, reason: collision with root package name */
    private int f45578h;

    /* renamed from: i, reason: collision with root package name */
    private String f45579i;

    /* renamed from: j, reason: collision with root package name */
    private final Map f45580j;

    /* renamed from: k, reason: collision with root package name */
    private final Map f45581k;

    /* renamed from: l, reason: collision with root package name */
    private final Map f45582l;

    /* renamed from: m, reason: collision with root package name */
    private final Map f45583m;

    /* renamed from: n, reason: collision with root package name */
    private final Map f45584n;

    /* renamed from: o, reason: collision with root package name */
    private t1 f45585o;

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", "", "tag", "", CampaignEx.JSON_KEY_TITLE, "tagType", "referId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getTitle", "getTagType", "getReferId", "mapTagType", "t", "toUgcTag", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoHashTag;", "component1", "component2", "component3", "component4", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "hashCode", "", "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final /* data */ class DeeplinkTag {
        public static final int $stable = 0;

        @SerializedName("refer_id")
        private final String referId;

        @SerializedName("tag")
        private final String tag;

        @SerializedName("tag_type")
        private final String tagType;

        @SerializedName(CampaignEx.JSON_KEY_TITLE)
        private final String title;

        public DeeplinkTag() {
            this(null, null, null, null, 15, null);
        }

        public DeeplinkTag(String str, String str2, String str3, String str4) {
            this.tag = str;
            this.title = str2;
            this.tagType = str3;
            this.referId = str4;
        }

        public /* synthetic */ DeeplinkTag(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
        }

        public static /* synthetic */ DeeplinkTag copy$default(DeeplinkTag deeplinkTag, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = deeplinkTag.tag;
            }
            if ((i11 & 2) != 0) {
                str2 = deeplinkTag.title;
            }
            if ((i11 & 4) != 0) {
                str3 = deeplinkTag.tagType;
            }
            if ((i11 & 8) != 0) {
                str4 = deeplinkTag.referId;
            }
            return deeplinkTag.copy(str, str2, str3, str4);
        }

        private final String mapTagType(String t11) {
            if (t11 == null) {
                return t11;
            }
            switch (t11.hashCode()) {
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    return !t11.equals("1") ? t11 : "TAG_GENRE";
                case 50:
                    return !t11.equals("2") ? t11 : "TAG_COUNTRY";
                case AD_REWARD_USER_VALUE:
                    return !t11.equals("3") ? t11 : "TAG_YEAR";
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    return !t11.equals("4") ? t11 : "TAG_STAFF";
                default:
                    return t11;
            }
        }

        /* renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTagType() {
            return this.tagType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getReferId() {
            return this.referId;
        }

        public final DeeplinkTag copy(String tag, String title, String tagType, String referId) {
            return new DeeplinkTag(tag, title, tagType, referId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeeplinkTag)) {
                return false;
            }
            DeeplinkTag deeplinkTag = (DeeplinkTag) other;
            return Intrinsics.c(this.tag, deeplinkTag.tag) && Intrinsics.c(this.title, deeplinkTag.title) && Intrinsics.c(this.tagType, deeplinkTag.tagType) && Intrinsics.c(this.referId, deeplinkTag.referId);
        }

        public final String getReferId() {
            return this.referId;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getTagType() {
            return this.tagType;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.tag;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.tagType;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.referId;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "DeeplinkTag(tag=" + this.tag + ", title=" + this.title + ", tagType=" + this.tagType + ", referId=" + this.referId + ")";
        }

        public final UGCVideoHashTag toUgcTag() {
            String str;
            String str2 = this.title;
            if (str2 == null || str2.length() == 0) {
                String str3 = this.tag;
                if (str3 == null) {
                    str3 = "";
                }
                str = Utils.SEPARATOR + str3;
            } else {
                str = this.title;
            }
            return new UGCVideoHashTag(this.tag, str, mapTagType(this.tagType), this.referId, null);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/transsion/home/hashtag/HashTagViewModel$HashtagPayload;", "", NativeComponentConstants.KEY_COMPONENT_TYPE, "", "mainHashtag", "Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", "subHashtag", "", "<init>", "(Ljava/lang/String;Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getMainHashtag", "()Lcom/transsion/home/hashtag/HashTagViewModel$DeeplinkTag;", "getSubHashtag", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "hashCode", "", "toString", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes5.dex */
    public static final /* data */ class HashtagPayload {
        public static final int $stable = 8;

        @SerializedName("main_hashtag")
        private final DeeplinkTag mainHashtag;

        @SerializedName("sub_hashtag")
        private final List<DeeplinkTag> subHashtag;

        @SerializedName(NativeComponentConstants.KEY_COMPONENT_TYPE)
        private final String type;

        public HashtagPayload() {
            this(null, null, null, 7, null);
        }

        public HashtagPayload(String str, DeeplinkTag deeplinkTag, List<DeeplinkTag> list) {
            this.type = str;
            this.mainHashtag = deeplinkTag;
            this.subHashtag = list;
        }

        public /* synthetic */ HashtagPayload(String str, DeeplinkTag deeplinkTag, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : deeplinkTag, (i11 & 4) != 0 ? null : list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HashtagPayload copy$default(HashtagPayload hashtagPayload, String str, DeeplinkTag deeplinkTag, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = hashtagPayload.type;
            }
            if ((i11 & 2) != 0) {
                deeplinkTag = hashtagPayload.mainHashtag;
            }
            if ((i11 & 4) != 0) {
                list = hashtagPayload.subHashtag;
            }
            return hashtagPayload.copy(str, deeplinkTag, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final DeeplinkTag getMainHashtag() {
            return this.mainHashtag;
        }

        public final List<DeeplinkTag> component3() {
            return this.subHashtag;
        }

        public final HashtagPayload copy(String type, DeeplinkTag mainHashtag, List<DeeplinkTag> subHashtag) {
            return new HashtagPayload(type, mainHashtag, subHashtag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HashtagPayload)) {
                return false;
            }
            HashtagPayload hashtagPayload = (HashtagPayload) other;
            return Intrinsics.c(this.type, hashtagPayload.type) && Intrinsics.c(this.mainHashtag, hashtagPayload.mainHashtag) && Intrinsics.c(this.subHashtag, hashtagPayload.subHashtag);
        }

        public final DeeplinkTag getMainHashtag() {
            return this.mainHashtag;
        }

        public final List<DeeplinkTag> getSubHashtag() {
            return this.subHashtag;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.type;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            DeeplinkTag deeplinkTag = this.mainHashtag;
            int hashCode2 = (hashCode + (deeplinkTag == null ? 0 : deeplinkTag.hashCode())) * 31;
            List<DeeplinkTag> list = this.subHashtag;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "HashtagPayload(type=" + this.type + ", mainHashtag=" + this.mainHashtag + ", subHashtag=" + this.subHashtag + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45572b = application;
        this.f45573c = (a) c.f79537e.a().h(a.class);
        this.f45574d = CollectionsKt.l();
        this.f45577g = "ForYou";
        this.f45580j = new LinkedHashMap();
        this.f45581k = new LinkedHashMap();
        this.f45582l = new LinkedHashMap();
        this.f45583m = new LinkedHashMap();
        this.f45584n = new LinkedHashMap();
    }

    private final List h(Set set, boolean z10) {
        List list;
        if (!z10 || (list = this.f45576f) == null || list.isEmpty()) {
            return null;
        }
        return CollectionsKt.e(new HashTagItem(HashTagItemType.TAGS, this.f45576f, CollectionsKt.R0(set), null, null, null, 56, null));
    }

    private final List i(List list, Set set, boolean z10) {
        if (!z10) {
            return list;
        }
        List c11 = CollectionsKt.c();
        List list2 = this.f45576f;
        if (list2 != null && !list2.isEmpty()) {
            c11.add(new HashTagItem(HashTagItemType.TAGS, this.f45576f, CollectionsKt.R0(set), null, null, null, 56, null));
            a.C0856a c0856a = lg.a.f68962a;
            List list3 = this.f45576f;
            Integer valueOf = list3 != null ? Integer.valueOf(list3.size()) : null;
            a.C0856a.f(c0856a, "HashTagViewModel", "buildFinalData: insert tags item, tags size=" + valueOf + ", selected size=" + set.size(), false, 4, null);
        }
        c11.addAll(list);
        return CollectionsKt.a(c11);
    }

    private final List j(Set set) {
        List c11 = CollectionsKt.c();
        UGCVideoHashTag uGCVideoHashTag = this.f45575e;
        if (uGCVideoHashTag != null) {
            c11.add(uGCVideoHashTag);
        }
        Set set2 = set;
        if (!set2.isEmpty()) {
            c11.addAll(set2);
        }
        return CollectionsKt.a(c11);
    }

    private final HashTagItem k(UGCContent uGCContent) {
        if (Intrinsics.c(uGCContent.getTopicType(), "UGC_VIDEO")) {
            UGCVideo video = uGCContent.getVideo();
            if (video != null) {
                return new HashTagItem(HashTagItemType.HASHTAG_CARD, null, null, video, null, null, 54, null);
            }
            return null;
        }
        a.C0856a.z(lg.a.f68962a, "HashTagViewModel", "convertToHashTagItem: unknown or unsupported content type=" + uGCContent.getTopicType(), false, 4, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestBody l(String str, int i11, Set set) {
        String j11 = o.j(new HashTagListRequest(i11, 20, j(set), this.f45579i, this.f45578h, str));
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "createRequestBody: request=" + j11, false, 4, null);
        b.a aVar = bh.b.f16553a;
        Intrinsics.e(j11);
        return aVar.a(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, Set set, boolean z10, String str2, String str3) {
        Map map = this.f45583m;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0(null);
            map.put(str, obj);
        }
        b0 b0Var = (b0) obj;
        List h11 = h(set, z10);
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "handleError: errorMsg=" + str2 + ", errorCode=" + str3 + ", errorData size=" + (h11 != null ? Integer.valueOf(h11.size()) : null), false, 4, null);
        b0Var.n(new RefreshBaseDto(str2, str3, h11, "", z10));
        if (z10) {
            Map map2 = this.f45584n;
            Object obj2 = map2.get(str);
            if (obj2 == null) {
                obj2 = new b0(Boolean.FALSE);
                map2.put(str, obj2);
            }
            ((b0) obj2).n(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, int i11, Set set, boolean z10, BaseDto baseDto) {
        if (Intrinsics.c(baseDto.getCode(), "0") && baseDto.getData() != null) {
            p(str, i11, set, z10, (UGCContentList) baseDto.getData());
            return;
        }
        lg.a.f68962a.i("HashTagViewModel", "loadHashTagList failed: code=" + baseDto.getCode() + ", msg=" + baseDto.getMsg(), true);
        String msg = baseDto.getMsg();
        if (msg == null) {
            msg = "";
        }
        String str2 = msg;
        String code = baseDto.getCode();
        if (code == null) {
            code = TmcConstants.COLD_OPEN_TYPE;
        }
        n(str, set, z10, str2, code);
    }

    private final void p(String str, int i11, Set set, boolean z10, UGCContentList uGCContentList) {
        List<UGCContent> l11;
        Pager pager;
        Boolean hasMore;
        if (uGCContentList == null || (l11 = uGCContentList.getItems()) == null) {
            l11 = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = l11.iterator();
        while (it.hasNext()) {
            HashTagItem k11 = k((UGCContent) it.next());
            if (k11 != null) {
                arrayList.add(k11);
            }
        }
        boolean booleanValue = (uGCContentList == null || (pager = uGCContentList.getPager()) == null || (hasMore = pager.getHasMore()) == null) ? false : hasMore.booleanValue();
        this.f45582l.put(str, Boolean.valueOf(booleanValue));
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "HashTagViewModel", "loadHashTagList success, tabSort=" + str + ", page=" + i11 + ", size=" + arrayList.size() + ", hasMore=" + booleanValue, false, 4, null);
        List i12 = i(arrayList, set, z10);
        int size = i12.size();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("loadHashTagList: finalData size=");
        sb2.append(size);
        a.C0856a.f(c0856a, "HashTagViewModel", sb2.toString(), false, 4, null);
        Map map = this.f45583m;
        Object obj = map.get(str);
        if (obj == null) {
            obj = new b0(null);
            map.put(str, obj);
        }
        ((b0) obj).n(new RefreshBaseDto("", "0", i12, "", z10));
        if (z10) {
            Map map2 = this.f45584n;
            Object obj2 = map2.get(str);
            if (obj2 == null) {
                obj2 = new b0(Boolean.FALSE);
                map2.put(str, obj2);
            }
            ((b0) obj2).n(Boolean.FALSE);
        }
    }

    private final void t(String str, boolean z10) {
        Integer num = (Integer) this.f45581k.get(str);
        int intValue = num != null ? num.intValue() : 1;
        Set set = (Set) this.f45580j.get(str);
        if (set == null) {
            set = new LinkedHashSet();
        }
        Set set2 = set;
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "loadHashTagList: start, tabSort=" + str + ", page=" + intValue + ", isRefresh=" + z10 + ", selectedTags=" + set2.size(), false, 4, null);
        k.d(u0.a(this), y0.b(), null, new HashTagViewModel$loadHashTagList$1(this, str, intValue, set2, z10, null), 2, null);
    }

    private final void z(String str) {
        List l11;
        Map map = this.f45583m;
        Object obj = map.get(str);
        HashTagItem hashTagItem = null;
        if (obj == null) {
            obj = new b0(null);
            map.put(str, obj);
        }
        b0 b0Var = (b0) obj;
        RefreshBaseDto refreshBaseDto = (RefreshBaseDto) b0Var.f();
        if (refreshBaseDto == null || (l11 = (List) refreshBaseDto.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        Iterable iterable = (Set) this.f45580j.get(str);
        if (iterable == null) {
            iterable = new LinkedHashSet();
        }
        List list = this.f45576f;
        if (list != null && !list.isEmpty()) {
            hashTagItem = new HashTagItem(HashTagItemType.TAGS, this.f45576f, CollectionsKt.R0(iterable), null, null, null, 56, null);
        }
        if (hashTagItem != null) {
            List list2 = l11;
            if (list2.isEmpty() || ((HashTagItem) l11.get(0)).getType() != HashTagItemType.TAGS) {
                List c11 = CollectionsKt.c();
                c11.add(hashTagItem);
                c11.addAll(list2);
                l11 = CollectionsKt.a(c11);
            } else {
                List c12 = CollectionsKt.c();
                c12.add(hashTagItem);
                c12.addAll(CollectionsKt.d0(l11, 1));
                l11 = CollectionsKt.a(c12);
            }
        }
        b0Var.n(new RefreshBaseDto("", "0", l11, "", true));
    }

    public final void A(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        this.f45581k.put(tabSort, 1);
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "refresh: tabSort=" + tabSort + ", reset page to 1", false, 4, null);
        Map map = this.f45584n;
        Object obj = map.get(tabSort);
        if (obj == null) {
            obj = new b0(Boolean.FALSE);
            map.put(tabSort, obj);
        }
        ((b0) obj).n(Boolean.TRUE);
        t(tabSort, true);
    }

    public final List m() {
        return this.f45574d;
    }

    public final boolean q(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        Boolean bool = (Boolean) this.f45582l.get(tabSort);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void r(UGCVideoHashTag uGCVideoHashTag, List list, int i11, String str) {
        ArrayList arrayList;
        this.f45575e = uGCVideoHashTag;
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                String title = ((UGCVideoHashTag) obj).getTitle();
                if (!(title == null || title.length() == 0)) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        this.f45576f = arrayList;
        this.f45578h = i11;
        this.f45579i = str;
        this.f45577g = "ForYou";
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "init: hashTag=" + (uGCVideoHashTag != null ? uGCVideoHashTag.getTitle() : null) + ", hashTags size=" + (list != null ? Integer.valueOf(list.size()) : null) + ", tabId=" + i11 + ", ugcVideoId=" + str, false, 4, null);
        String string = this.f45572b.getString(R$string.item_tab_hash_tag_for_you);
        Intrinsics.g(string, "getString(...)");
        HashTagTab hashTagTab = new HashTagTab("ForYou", string, true);
        String string2 = this.f45572b.getString(R$string.item_tab_hash_tag_most_viewed);
        Intrinsics.g(string2, "getString(...)");
        HashTagTab hashTagTab2 = new HashTagTab("MostViewed", string2, false, 4, null);
        String string3 = this.f45572b.getString(R$string.item_tab_hash_tag_new);
        Intrinsics.g(string3, "getString(...)");
        List o11 = CollectionsKt.o(hashTagTab, hashTagTab2, new HashTagTab("New", string3, false, 4, null));
        this.f45574d = o11;
        Iterator it = o11.iterator();
        while (it.hasNext()) {
            this.f45580j.put(((HashTagTab) it.next()).getId(), new LinkedHashSet());
        }
    }

    public final LiveData s(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        Map map = this.f45583m;
        Object obj = map.get(tabSort);
        if (obj == null) {
            obj = new b0(null);
            map.put(tabSort, obj);
        }
        return (LiveData) obj;
    }

    public final void u(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        if (!q(tabSort)) {
            a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "loadMore: no more data, tabSort=" + tabSort, false, 4, null);
            return;
        }
        Integer num = (Integer) this.f45581k.get(tabSort);
        int intValue = (num != null ? num.intValue() : 1) + 1;
        this.f45581k.put(tabSort, Integer.valueOf(intValue));
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "loadMore: tabSort=" + tabSort + ", page=" + intValue, false, 4, null);
        t(tabSort, false);
    }

    public final LiveData v(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        Map map = this.f45584n;
        Object obj = map.get(tabSort);
        if (obj == null) {
            obj = new b0(Boolean.FALSE);
            map.put(tabSort, obj);
        }
        return (LiveData) obj;
    }

    public final void w(String tabSort) {
        Intrinsics.h(tabSort, "tabSort");
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTabSelected: tabSort=" + tabSort + ", previous=" + this.f45577g, false, 4, null);
        List<HashTagTab> list = this.f45574d;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (HashTagTab hashTagTab : list) {
            arrayList.add(HashTagTab.copy$default(hashTagTab, null, null, Intrinsics.c(hashTagTab.getId(), tabSort), 3, null));
        }
        this.f45574d = arrayList;
        this.f45577g = tabSort;
        Map map = this.f45583m;
        Object obj = map.get(tabSort);
        if (obj == null) {
            obj = new b0(null);
            map.put(tabSort, obj);
        }
        RefreshBaseDto refreshBaseDto = (RefreshBaseDto) ((b0) obj).f();
        List list2 = refreshBaseDto != null ? (List) refreshBaseDto.getData() : null;
        List list3 = list2;
        if (list3 != null && !list3.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTabSelected: data exists, size=" + list2.size(), false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTabSelected: no data, start loading", false, 4, null);
        Map map2 = this.f45584n;
        Object obj2 = map2.get(tabSort);
        if (obj2 == null) {
            obj2 = new b0(Boolean.FALSE);
            map2.put(tabSort, obj2);
        }
        ((b0) obj2).n(Boolean.TRUE);
        A(tabSort);
    }

    public final void x(UGCVideoHashTag tag) {
        Object obj;
        t1 d11;
        Intrinsics.h(tag, "tag");
        Set set = (Set) this.f45580j.get(this.f45577g);
        if (set == null) {
            set = new LinkedHashSet();
        }
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.c(((UGCVideoHashTag) obj).getTag(), tag.getTag())) {
                    break;
                }
            }
        }
        UGCVideoHashTag uGCVideoHashTag = (UGCVideoHashTag) obj;
        if (uGCVideoHashTag != null) {
            set.remove(uGCVideoHashTag);
            a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTagClicked: unselect tag=" + tag.getTag() + ", tabSort=" + this.f45577g + ", current selected=" + set.size(), false, 4, null);
        } else {
            set.add(tag);
            a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTagClicked: select tag=" + tag.getTag() + ", tabSort=" + this.f45577g + ", current selected=" + set.size(), false, 4, null);
        }
        this.f45580j.put(this.f45577g, set);
        z(this.f45577g);
        t1 t1Var = this.f45585o;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "onTagClicked: cancel previous debounce job, will refresh after 700ms", false, 4, null);
        d11 = k.d(u0.a(this), null, null, new HashTagViewModel$onTagClicked$1(this, null), 3, null);
        this.f45585o = d11;
    }

    public final Pair y(String raw) {
        Object m1185constructorimpl;
        ArrayList arrayList;
        List<DeeplinkTag> subHashtag;
        DeeplinkTag mainHashtag;
        Intrinsics.h(raw, "raw");
        try {
            Result.Companion companion = Result.INSTANCE;
            HashtagPayload hashtagPayload = (HashtagPayload) o.f().fromJson(raw, HashtagPayload.class);
            UGCVideoHashTag ugcTag = (hashtagPayload == null || (mainHashtag = hashtagPayload.getMainHashtag()) == null) ? null : mainHashtag.toUgcTag();
            if (hashtagPayload == null || (subHashtag = hashtagPayload.getSubHashtag()) == null) {
                arrayList = null;
            } else {
                List<DeeplinkTag> list = subHashtag;
                arrayList = new ArrayList(CollectionsKt.v(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DeeplinkTag) it.next()).toUgcTag());
                }
            }
            a.C0856a.f(lg.a.f68962a, "HashTagViewModel", "parse hashtag json success: main=" + (ugcTag != null ? ugcTag.getTitle() : null) + ", subs=" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null), false, 4, null);
            m1185constructorimpl = Result.m1185constructorimpl(new Pair(ugcTag, arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            lg.a.f68962a.i("HashTagViewModel", "parse hashtag json failed: " + m1188exceptionOrNullimpl.getMessage(), true);
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        Pair pair = (Pair) m1185constructorimpl;
        return pair == null ? new Pair(null, null) : pair;
    }
}
