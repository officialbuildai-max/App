package com.facebook.biddingkit.logging;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private int f24191a;

    /* renamed from: b, reason: collision with root package name */
    private int f24192b;

    /* renamed from: c, reason: collision with root package name */
    private String f24193c;

    public i(String str) {
        this.f24191a = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.f24192b = 60000;
        this.f24193c = "https://www.facebook.com/audiencenetwork/bidding_kit_logging";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(RequestParameters.SUBRESOURCE_LOGGING);
            if (optJSONObject != null) {
                if (optJSONObject.has("cycle_separation_ms")) {
                    this.f24191a = optJSONObject.getInt("cycle_separation_ms");
                }
                if (optJSONObject.has("network_wait_on_failure_ms")) {
                    this.f24192b = optJSONObject.getInt("network_wait_on_failure_ms");
                }
                if (optJSONObject.has("dispatcher_url")) {
                    this.f24193c = optJSONObject.getString("dispatcher_url");
                }
            }
        } catch (JSONException e11) {
            b.d("LoggingConfig", "Failed to parse configuration.", e11);
        }
    }

    public int a() {
        return this.f24191a;
    }

    public String b() {
        return this.f24193c;
    }

    public int c() {
        return this.f24192b;
    }
}
