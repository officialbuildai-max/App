package com.tn.tranpay;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b \b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0001KB\u0083\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001cJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001cJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001cJ\u0010\u0010%\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b'\u0010&J\u008e\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u001cJ\u0010\u0010+\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b+\u0010\u001aJ\u001a\u0010.\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00100\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u00103R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00100\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u00103R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00100\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u00103R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u00103R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u00100\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u00103R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00100\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u00103R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00100\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u00103R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00100\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u00103R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00100\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u00103R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010D\u001a\u0004\bE\u0010&\"\u0004\bF\u0010GR\"\u0010\u000e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010D\u001a\u0004\bH\u0010&\"\u0004\bI\u0010G¨\u0006L"}, d2 = {"Lcom/tn/tranpay/BillingParams;", "Landroid/os/Parcelable;", "", "txnId", RewardPlus.AMOUNT, "orderId", "orderDesc", "currency", "referenceNo", "memo", TmcConstants.KEY_LANGUAGE, "cpFrontPage", "", "shouldOpenCpFrontPage", "payByLocalCurrency", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "()Z", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/tn/tranpay/BillingParams;", "toString", "hashCode", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTxnId", "setTxnId", "(Ljava/lang/String;)V", "getAmount", "setAmount", "getOrderId", "setOrderId", "getOrderDesc", "setOrderDesc", "getCurrency", "setCurrency", "getReferenceNo", "setReferenceNo", "getMemo", "setMemo", "getLanguage", "setLanguage", "getCpFrontPage", "setCpFrontPage", "Z", "getShouldOpenCpFrontPage", "setShouldOpenCpFrontPage", "(Z)V", "getPayByLocalCurrency", "setPayByLocalCurrency", "CREATOR", "a", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes4.dex */
public final /* data */ class BillingParams implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String amount;
    private String cpFrontPage;
    private String currency;
    private String language;
    private String memo;
    private String orderDesc;
    private String orderId;
    private boolean payByLocalCurrency;
    private String referenceNo;
    private boolean shouldOpenCpFrontPage;
    private String txnId;

    /* renamed from: com.tn.tranpay.BillingParams$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion implements Parcelable.Creator {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BillingParams createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new BillingParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BillingParams[] newArray(int i11) {
            return new BillingParams[i11];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BillingParams(android.os.Parcel r14) {
        /*
            r13 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.h(r14, r0)
            java.lang.String r2 = r14.readString()
            if (r2 == 0) goto L4a
            java.lang.String r0 = "requireNotNull(parcel.re… \"txnId cannot be null\" }"
            kotlin.jvm.internal.Intrinsics.g(r2, r0)
            java.lang.String r3 = r14.readString()
            java.lang.String r4 = r14.readString()
            java.lang.String r5 = r14.readString()
            java.lang.String r6 = r14.readString()
            java.lang.String r7 = r14.readString()
            java.lang.String r8 = r14.readString()
            java.lang.String r9 = r14.readString()
            java.lang.String r10 = r14.readString()
            byte r0 = r14.readByte()
            r1 = 0
            r11 = 1
            if (r0 == 0) goto L3a
            r0 = r11
            goto L3b
        L3a:
            r0 = r1
        L3b:
            byte r14 = r14.readByte()
            if (r14 == 0) goto L43
            r12 = r11
            goto L44
        L43:
            r12 = r1
        L44:
            r1 = r13
            r11 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        L4a:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "txnId cannot be null"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.BillingParams.<init>(android.os.Parcel):void");
    }

    public BillingParams(String txnId, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z10, boolean z11) {
        Intrinsics.h(txnId, "txnId");
        this.txnId = txnId;
        this.amount = str;
        this.orderId = str2;
        this.orderDesc = str3;
        this.currency = str4;
        this.referenceNo = str5;
        this.memo = str6;
        this.language = str7;
        this.cpFrontPage = str8;
        this.shouldOpenCpFrontPage = z10;
        this.payByLocalCurrency = z11;
    }

    public /* synthetic */ BillingParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z10, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) == 0 ? str9 : null, (i11 & 512) != 0 ? true : z10, (i11 & 1024) != 0 ? false : z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTxnId() {
        return this.txnId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getShouldOpenCpFrontPage() {
        return this.shouldOpenCpFrontPage;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOrderDesc() {
        return this.orderDesc;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCurrency() {
        return this.currency;
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
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final BillingParams copy(String txnId, String amount, String orderId, String orderDesc, String currency, String referenceNo, String memo, String language, String cpFrontPage, boolean shouldOpenCpFrontPage, boolean payByLocalCurrency) {
        Intrinsics.h(txnId, "txnId");
        return new BillingParams(txnId, amount, orderId, orderDesc, currency, referenceNo, memo, language, cpFrontPage, shouldOpenCpFrontPage, payByLocalCurrency);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BillingParams)) {
            return false;
        }
        BillingParams billingParams = (BillingParams) other;
        return Intrinsics.c(this.txnId, billingParams.txnId) && Intrinsics.c(this.amount, billingParams.amount) && Intrinsics.c(this.orderId, billingParams.orderId) && Intrinsics.c(this.orderDesc, billingParams.orderDesc) && Intrinsics.c(this.currency, billingParams.currency) && Intrinsics.c(this.referenceNo, billingParams.referenceNo) && Intrinsics.c(this.memo, billingParams.memo) && Intrinsics.c(this.language, billingParams.language) && Intrinsics.c(this.cpFrontPage, billingParams.cpFrontPage) && this.shouldOpenCpFrontPage == billingParams.shouldOpenCpFrontPage && this.payByLocalCurrency == billingParams.payByLocalCurrency;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getOrderDesc() {
        return this.orderDesc;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final boolean getPayByLocalCurrency() {
        return this.payByLocalCurrency;
    }

    public final String getReferenceNo() {
        return this.referenceNo;
    }

    public final boolean getShouldOpenCpFrontPage() {
        return this.shouldOpenCpFrontPage;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.txnId.hashCode() * 31;
        String str = this.amount;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.orderId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderDesc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.currency;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.referenceNo;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.memo;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.language;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.cpFrontPage;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z10 = this.shouldOpenCpFrontPage;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode9 + i11) * 31;
        boolean z11 = this.payByLocalCurrency;
        return i12 + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setOrderDesc(String str) {
        this.orderDesc = str;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final void setPayByLocalCurrency(boolean z10) {
        this.payByLocalCurrency = z10;
    }

    public final void setReferenceNo(String str) {
        this.referenceNo = str;
    }

    public final void setShouldOpenCpFrontPage(boolean z10) {
        this.shouldOpenCpFrontPage = z10;
    }

    public final void setTxnId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.txnId = str;
    }

    public String toString() {
        return "BillingParams(txnId=" + this.txnId + ", amount=" + this.amount + ", orderId=" + this.orderId + ", orderDesc=" + this.orderDesc + ", currency=" + this.currency + ", referenceNo=" + this.referenceNo + ", memo=" + this.memo + ", language=" + this.language + ", cpFrontPage=" + this.cpFrontPage + ", shouldOpenCpFrontPage=" + this.shouldOpenCpFrontPage + ", payByLocalCurrency=" + this.payByLocalCurrency + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.h(parcel, "parcel");
        parcel.writeString(this.txnId);
        parcel.writeString(this.amount);
        parcel.writeString(this.orderId);
        parcel.writeString(this.orderDesc);
        parcel.writeString(this.referenceNo);
        parcel.writeString(this.currency);
        parcel.writeString(this.memo);
        parcel.writeString(this.language);
        parcel.writeString(this.cpFrontPage);
        parcel.writeByte(this.shouldOpenCpFrontPage ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.payByLocalCurrency ? (byte) 1 : (byte) 0);
    }
}
