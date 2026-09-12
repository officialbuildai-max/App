package com.transsion.ad.ps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0012\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0003J\u0013\u0010[\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0011HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010^\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0011HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¢\u0002\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010dJ\u0006\u0010e\u001a\u00020\u000bJ\u0013\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010iHÖ\u0003J\t\u0010j\u001a\u00020\u000bHÖ\u0001J\t\u0010k\u001a\u00020\u0003HÖ\u0001J\u0016\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b\n\u0010.\"\u0004\b/\u00100R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b@\u0010.\"\u0004\bA\u00100R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R$\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010;\"\u0004\bE\u0010=R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010!R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001f\"\u0004\bK\u0010!R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001f\"\u0004\bM\u0010!¨\u0006q"}, d2 = {"Lcom/transsion/ad/ps/model/ItemDetail;", "Landroid/os/Parcelable;", "downloadCount", "", "iconUrl", "img0", "img1", "img2", "img3", "img4", "isOffer", "", "itemID", "lan", "name", "packageName", "safeTagList", "", "Lcom/transsion/ad/ps/model/SafeTag;", "tagList", "Lcom/transsion/ad/ps/model/Tag;", "safetyStyle", "score", "screenshotMode", "simpleDescription", "sourceSize", "star", "versionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDownloadCount", "()Ljava/lang/String;", "setDownloadCount", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getImg0", "setImg0", "getImg1", "setImg1", "getImg2", "setImg2", "getImg3", "setImg3", "getImg4", "setImg4", "()Ljava/lang/Integer;", "setOffer", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getItemID", "setItemID", "getLan", "setLan", "getName", "setName", "getPackageName", "setPackageName", "getSafeTagList", "()Ljava/util/List;", "setSafeTagList", "(Ljava/util/List;)V", "getTagList", "setTagList", "getSafetyStyle", "setSafetyStyle", "getScore", "setScore", "getScreenshotMode", "setScreenshotMode", "getSimpleDescription", "setSimpleDescription", "getSourceSize", "setSourceSize", "getStar", "setStar", "getVersionCode", "setVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/transsion/ad/ps/model/ItemDetail;", "describeContents", "equals", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final /* data */ class ItemDetail implements Parcelable {
    public static final Parcelable.Creator<ItemDetail> CREATOR = new a();
    private String downloadCount;
    private String iconUrl;
    private String img0;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private Integer isOffer;
    private String itemID;
    private String lan;
    private String name;
    private String packageName;
    private List<SafeTag> safeTagList;
    private Integer safetyStyle;
    private String score;
    private List<Integer> screenshotMode;
    private String simpleDescription;
    private String sourceSize;
    private String star;
    private List<Tag> tagList;
    private String versionCode;

    /* loaded from: classes5.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ItemDetail createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            int i11;
            SafeTag createFromParcel;
            ArrayList arrayList2;
            ArrayList arrayList3;
            int i12;
            Tag createFromParcel2;
            ArrayList arrayList4;
            int i13;
            Integer valueOf;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(readInt);
                int i14 = 0;
                while (i14 != readInt) {
                    if (parcel.readInt() == 0) {
                        i11 = readInt;
                        createFromParcel = null;
                    } else {
                        i11 = readInt;
                        createFromParcel = SafeTag.CREATOR.createFromParcel(parcel);
                    }
                    arrayList5.add(createFromParcel);
                    i14++;
                    readInt = i11;
                }
                arrayList = arrayList5;
            }
            if (parcel.readInt() == 0) {
                arrayList2 = arrayList;
                arrayList3 = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(readInt2);
                arrayList2 = arrayList;
                int i15 = 0;
                while (i15 != readInt2) {
                    if (parcel.readInt() == 0) {
                        i12 = readInt2;
                        createFromParcel2 = null;
                    } else {
                        i12 = readInt2;
                        createFromParcel2 = Tag.CREATOR.createFromParcel(parcel);
                    }
                    arrayList6.add(createFromParcel2);
                    i15++;
                    readInt2 = i12;
                }
                arrayList3 = arrayList6;
            }
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString12 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList7 = new ArrayList(readInt3);
                int i16 = 0;
                while (i16 != readInt3) {
                    if (parcel.readInt() == 0) {
                        i13 = readInt3;
                        valueOf = null;
                    } else {
                        i13 = readInt3;
                        valueOf = Integer.valueOf(parcel.readInt());
                    }
                    arrayList7.add(valueOf);
                    i16++;
                    readInt3 = i13;
                }
                arrayList4 = arrayList7;
            }
            return new ItemDetail(readString, readString2, readString3, readString4, readString5, readString6, readString7, valueOf2, readString8, readString9, readString10, readString11, arrayList2, arrayList3, valueOf3, readString12, arrayList4, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ItemDetail[] newArray(int i11) {
            return new ItemDetail[i11];
        }
    }

    public ItemDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, String str8, String str9, String str10, String str11, List<SafeTag> list, List<Tag> list2, Integer num2, String str12, List<Integer> list3, String str13, String str14, String str15, String str16) {
        this.downloadCount = str;
        this.iconUrl = str2;
        this.img0 = str3;
        this.img1 = str4;
        this.img2 = str5;
        this.img3 = str6;
        this.img4 = str7;
        this.isOffer = num;
        this.itemID = str8;
        this.lan = str9;
        this.name = str10;
        this.packageName = str11;
        this.safeTagList = list;
        this.tagList = list2;
        this.safetyStyle = num2;
        this.score = str12;
        this.screenshotMode = list3;
        this.simpleDescription = str13;
        this.sourceSize = str14;
        this.star = str15;
        this.versionCode = str16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLan() {
        return this.lan;
    }

    /* renamed from: component11, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final List<SafeTag> component13() {
        return this.safeTagList;
    }

    public final List<Tag> component14() {
        return this.tagList;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getSafetyStyle() {
        return this.safetyStyle;
    }

    /* renamed from: component16, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    public final List<Integer> component17() {
        return this.screenshotMode;
    }

    /* renamed from: component18, reason: from getter */
    public final String getSimpleDescription() {
        return this.simpleDescription;
    }

    /* renamed from: component19, reason: from getter */
    public final String getSourceSize() {
        return this.sourceSize;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component20, reason: from getter */
    public final String getStar() {
        return this.star;
    }

    /* renamed from: component21, reason: from getter */
    public final String getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImg0() {
        return this.img0;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImg1() {
        return this.img1;
    }

    /* renamed from: component5, reason: from getter */
    public final String getImg2() {
        return this.img2;
    }

    /* renamed from: component6, reason: from getter */
    public final String getImg3() {
        return this.img3;
    }

    /* renamed from: component7, reason: from getter */
    public final String getImg4() {
        return this.img4;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getIsOffer() {
        return this.isOffer;
    }

    /* renamed from: component9, reason: from getter */
    public final String getItemID() {
        return this.itemID;
    }

    public final ItemDetail copy(String downloadCount, String iconUrl, String img0, String img1, String img2, String img3, String img4, Integer isOffer, String itemID, String lan, String name, String packageName, List<SafeTag> safeTagList, List<Tag> tagList, Integer safetyStyle, String score, List<Integer> screenshotMode, String simpleDescription, String sourceSize, String star, String versionCode) {
        return new ItemDetail(downloadCount, iconUrl, img0, img1, img2, img3, img4, isOffer, itemID, lan, name, packageName, safeTagList, tagList, safetyStyle, score, screenshotMode, simpleDescription, sourceSize, star, versionCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemDetail)) {
            return false;
        }
        ItemDetail itemDetail = (ItemDetail) other;
        return Intrinsics.c(this.downloadCount, itemDetail.downloadCount) && Intrinsics.c(this.iconUrl, itemDetail.iconUrl) && Intrinsics.c(this.img0, itemDetail.img0) && Intrinsics.c(this.img1, itemDetail.img1) && Intrinsics.c(this.img2, itemDetail.img2) && Intrinsics.c(this.img3, itemDetail.img3) && Intrinsics.c(this.img4, itemDetail.img4) && Intrinsics.c(this.isOffer, itemDetail.isOffer) && Intrinsics.c(this.itemID, itemDetail.itemID) && Intrinsics.c(this.lan, itemDetail.lan) && Intrinsics.c(this.name, itemDetail.name) && Intrinsics.c(this.packageName, itemDetail.packageName) && Intrinsics.c(this.safeTagList, itemDetail.safeTagList) && Intrinsics.c(this.tagList, itemDetail.tagList) && Intrinsics.c(this.safetyStyle, itemDetail.safetyStyle) && Intrinsics.c(this.score, itemDetail.score) && Intrinsics.c(this.screenshotMode, itemDetail.screenshotMode) && Intrinsics.c(this.simpleDescription, itemDetail.simpleDescription) && Intrinsics.c(this.sourceSize, itemDetail.sourceSize) && Intrinsics.c(this.star, itemDetail.star) && Intrinsics.c(this.versionCode, itemDetail.versionCode);
    }

    public final String getDownloadCount() {
        return this.downloadCount;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getImg0() {
        return this.img0;
    }

    public final String getImg1() {
        return this.img1;
    }

    public final String getImg2() {
        return this.img2;
    }

    public final String getImg3() {
        return this.img3;
    }

    public final String getImg4() {
        return this.img4;
    }

    public final String getItemID() {
        return this.itemID;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<SafeTag> getSafeTagList() {
        return this.safeTagList;
    }

    public final Integer getSafetyStyle() {
        return this.safetyStyle;
    }

    public final String getScore() {
        return this.score;
    }

    public final List<Integer> getScreenshotMode() {
        return this.screenshotMode;
    }

    public final String getSimpleDescription() {
        return this.simpleDescription;
    }

    public final String getSourceSize() {
        return this.sourceSize;
    }

    public final String getStar() {
        return this.star;
    }

    public final List<Tag> getTagList() {
        return this.tagList;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        String str = this.downloadCount;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.iconUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.img0;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.img1;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.img2;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.img3;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.img4;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.isOffer;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        String str8 = this.itemID;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lan;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.name;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.packageName;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<SafeTag> list = this.safeTagList;
        int hashCode13 = (hashCode12 + (list == null ? 0 : list.hashCode())) * 31;
        List<Tag> list2 = this.tagList;
        int hashCode14 = (hashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.safetyStyle;
        int hashCode15 = (hashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str12 = this.score;
        int hashCode16 = (hashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        List<Integer> list3 = this.screenshotMode;
        int hashCode17 = (hashCode16 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str13 = this.simpleDescription;
        int hashCode18 = (hashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.sourceSize;
        int hashCode19 = (hashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.star;
        int hashCode20 = (hashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.versionCode;
        return hashCode20 + (str16 != null ? str16.hashCode() : 0);
    }

    public final Integer isOffer() {
        return this.isOffer;
    }

    public final void setDownloadCount(String str) {
        this.downloadCount = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setImg0(String str) {
        this.img0 = str;
    }

    public final void setImg1(String str) {
        this.img1 = str;
    }

    public final void setImg2(String str) {
        this.img2 = str;
    }

    public final void setImg3(String str) {
        this.img3 = str;
    }

    public final void setImg4(String str) {
        this.img4 = str;
    }

    public final void setItemID(String str) {
        this.itemID = str;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOffer(Integer num) {
        this.isOffer = num;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setSafeTagList(List<SafeTag> list) {
        this.safeTagList = list;
    }

    public final void setSafetyStyle(Integer num) {
        this.safetyStyle = num;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public final void setScreenshotMode(List<Integer> list) {
        this.screenshotMode = list;
    }

    public final void setSimpleDescription(String str) {
        this.simpleDescription = str;
    }

    public final void setSourceSize(String str) {
        this.sourceSize = str;
    }

    public final void setStar(String str) {
        this.star = str;
    }

    public final void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    public final void setVersionCode(String str) {
        this.versionCode = str;
    }

    public String toString() {
        return "ItemDetail(downloadCount=" + this.downloadCount + ", iconUrl=" + this.iconUrl + ", img0=" + this.img0 + ", img1=" + this.img1 + ", img2=" + this.img2 + ", img3=" + this.img3 + ", img4=" + this.img4 + ", isOffer=" + this.isOffer + ", itemID=" + this.itemID + ", lan=" + this.lan + ", name=" + this.name + ", packageName=" + this.packageName + ", safeTagList=" + this.safeTagList + ", tagList=" + this.tagList + ", safetyStyle=" + this.safetyStyle + ", score=" + this.score + ", screenshotMode=" + this.screenshotMode + ", simpleDescription=" + this.simpleDescription + ", sourceSize=" + this.sourceSize + ", star=" + this.star + ", versionCode=" + this.versionCode + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.downloadCount);
        dest.writeString(this.iconUrl);
        dest.writeString(this.img0);
        dest.writeString(this.img1);
        dest.writeString(this.img2);
        dest.writeString(this.img3);
        dest.writeString(this.img4);
        Integer num = this.isOffer;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeString(this.itemID);
        dest.writeString(this.lan);
        dest.writeString(this.name);
        dest.writeString(this.packageName);
        List<SafeTag> list = this.safeTagList;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            for (SafeTag safeTag : list) {
                if (safeTag == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    safeTag.writeToParcel(dest, flags);
                }
            }
        }
        List<Tag> list2 = this.tagList;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            for (Tag tag : list2) {
                if (tag == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    tag.writeToParcel(dest, flags);
                }
            }
        }
        Integer num2 = this.safetyStyle;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.score);
        List<Integer> list3 = this.screenshotMode;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            for (Integer num3 : list3) {
                if (num3 == null) {
                    dest.writeInt(0);
                } else {
                    dest.writeInt(1);
                    dest.writeInt(num3.intValue());
                }
            }
        }
        dest.writeString(this.simpleDescription);
        dest.writeString(this.sourceSize);
        dest.writeString(this.star);
        dest.writeString(this.versionCode);
    }
}
