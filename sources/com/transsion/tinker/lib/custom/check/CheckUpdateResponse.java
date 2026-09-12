package com.transsion.tinker.lib.custom.check;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
/* loaded from: classes6.dex */
public final class CheckUpdateResponse {

    @SerializedName("code")
    public int code;

    @SerializedName("data")
    public BffCheckUpdateData data;

    @SerializedName("message")
    public String message;
}
