package com.mbridge.msdk.mbbid.out;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.system.NoProGuard;

/* loaded from: classes5.dex */
public class BidResponsed implements NoProGuard {
    public static final String KEY_BID_ID = "bid";
    public static final String KEY_CUR = "cur";
    public static final String KEY_LN = "ln";
    public static final String KEY_PRICE = "price";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_WN = "wn";
    private String bidId;
    private String bidToken;
    private String cur;

    /* renamed from: ln, reason: collision with root package name */
    protected String f36279ln;
    private String price;

    /* renamed from: wn, reason: collision with root package name */
    protected String f36280wn;

    public String getBidId() {
        return this.bidId;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public String getCur() {
        return this.cur;
    }

    public String getLn() {
        return this.f36279ln;
    }

    public String getPrice() {
        return this.price;
    }

    public String getWn() {
        return this.f36280wn;
    }

    public void sendLossNotice(Context context, BidLossCode bidLossCode) {
        if (TextUtils.isEmpty(this.f36279ln) || context == null || bidLossCode == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(this.f36279ln);
        if (this.f36279ln.contains(UrlUtils.QUESTION_MARK)) {
            sb2.append(UrlUtils.AND_MARK);
        } else {
            sb2.append(UrlUtils.QUESTION_MARK);
        }
        sb2.append("reason=");
        sb2.append(bidLossCode.getCurrentCode());
        a.a(context, (CampaignEx) null, "", sb2.toString(), false, false);
    }

    public void sendWinNotice(Context context) {
        if (TextUtils.isEmpty(this.f36280wn) || context == null) {
            return;
        }
        a.a(context, (CampaignEx) null, "", this.f36280wn, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBidId(String str) {
        this.bidId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBidToken(String str) {
        this.bidToken = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCur(String str) {
        this.cur = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPrice(String str) {
        this.price = str;
    }
}
