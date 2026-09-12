package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"Jz\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000202R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006="}, d2 = {"Lcom/transsion/payment/lib/bean/PrePayInfo;", "Landroid/os/Parcelable;", "orderId", "", "skuId", "currency", BidResponsed.KEY_PRICE, TrackingKey.DESCRIPTION, "referenceNo", "memo", "cpFrontPage", "payByLocalCurrency", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "getSkuId", "setSkuId", "getCurrency", "setCurrency", "getPrice", "setPrice", "getDescription", "setDescription", "getReferenceNo", "setReferenceNo", "getMemo", "setMemo", "getCpFrontPage", "setCpFrontPage", "getPayByLocalCurrency", "()Ljava/lang/Boolean;", "setPayByLocalCurrency", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/transsion/payment/lib/bean/PrePayInfo;", "describeContents", "", "equals", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "LibPayment_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final /* data */ class PrePayInfo implements Parcelable {
    public static final Parcelable.Creator<PrePayInfo> CREATOR = new a();
    private String cpFrontPage;
    private String currency;
    private String description;
    private String memo;
    private String orderId;
    private Boolean payByLocalCurrency;
    private String price;
    private String referenceNo;
    private String skuId;

    /* loaded from: classes6.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PrePayInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PrePayInfo(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, valueOf);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PrePayInfo[] newArray(int i11) {
            return new PrePayInfo[i11];
        }
    }

    public PrePayInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool) {
        this.orderId = str;
        this.skuId = str2;
        this.currency = str3;
        this.price = str4;
        this.description = str5;
        this.referenceNo = str6;
        this.memo = str7;
        this.cpFrontPage = str8;
        this.payByLocalCurrency = bool;
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSkuId() {
        return this.skuId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReferenceNo() {
        return this.referenceNo;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMemo() {
        return this.memo;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final PrePayInfo copy(String orderId, String skuId, String currency, String price, String description, String referenceNo, String memo, String cpFrontPage, Boolean payByLocalCurrency) {
        return new PrePayInfo(orderId, skuId, currency, price, description, referenceNo, memo, cpFrontPage, payByLocalCurrency);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PrePayInfo)) {
            return false;
        }
        PrePayInfo prePayInfo = (PrePayInfo) other;
        return Intrinsics.c(this.orderId, prePayInfo.orderId) && Intrinsics.c(this.skuId, prePayInfo.skuId) && Intrinsics.c(this.currency, prePayInfo.currency) && Intrinsics.c(this.price, prePayInfo.price) && Intrinsics.c(this.description, prePayInfo.description) && Intrinsics.c(this.referenceNo, prePayInfo.referenceNo) && Intrinsics.c(this.memo, prePayInfo.memo) && Intrinsics.c(this.cpFrontPage, prePayInfo.cpFrontPage) && Intrinsics.c(this.payByLocalCurrency, prePayInfo.payByLocalCurrency);
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getReferenceNo() {
        return this.referenceNo;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.orderId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.skuId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currency;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.price;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.referenceNo;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.memo;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cpFrontPage;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.payByLocalCurrency;
        return hashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayByLocalCurrency(Boolean bool) {
        this.payByLocalCurrency = bool;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final void setReferenceNo(String str) {
        this.referenceNo = str;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public String toString() {
        return "PrePayInfo(orderId=" + this.orderId + ", skuId=" + this.skuId + ", currency=" + this.currency + ", price=" + this.price + ", description=" + this.description + ", referenceNo=" + this.referenceNo + ", memo=" + this.memo + ", cpFrontPage=" + this.cpFrontPage + ", payByLocalCurrency=" + this.payByLocalCurrency + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int i11;
        Intrinsics.h(dest, "dest");
        dest.writeString(this.orderId);
        dest.writeString(this.skuId);
        dest.writeString(this.currency);
        dest.writeString(this.price);
        dest.writeString(this.description);
        dest.writeString(this.referenceNo);
        dest.writeString(this.memo);
        dest.writeString(this.cpFrontPage);
        Boolean bool = this.payByLocalCurrency;
        if (bool == null) {
            i11 = 0;
        } else {
            dest.writeInt(1);
            i11 = bool.booleanValue();
        }
        dest.writeInt(i11);
    }
}
