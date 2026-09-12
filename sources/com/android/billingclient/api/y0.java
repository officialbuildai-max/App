package com.android.billingclient.api;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class y0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(JSONObject jSONObject) {
        jSONObject.getInt("commitmentPaymentsCount");
        jSONObject.optInt("subsequentCommitmentPaymentsCount");
    }
}
