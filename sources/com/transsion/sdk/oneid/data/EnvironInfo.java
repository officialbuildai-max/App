package com.transsion.sdk.oneid.data;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class EnvironInfo extends OneBaseInfo implements Serializable {
    public String lang;

    /* renamed from: tz, reason: collision with root package name */
    public String f51973tz;

    @SuppressLint({"DefaultLocale"})
    public EnvironInfo(Context context) {
        this.f51973tz = "";
        this.lang = "";
        try {
            this.f51973tz = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError unused) {
            this.f51973tz = "GMT+00:00";
        }
        if ("GMT".equals(this.f51973tz)) {
            this.f51973tz = "GMT+00:00";
        }
        this.lang = Locale.getDefault().getLanguage();
    }
}
