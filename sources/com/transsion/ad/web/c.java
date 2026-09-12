package com.transsion.ad.web;

import android.text.TextUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f42511a = new c();

    private c() {
    }

    public final void a(String str, b callback) {
        Object m1185constructorimpl;
        JSONObject jSONObject;
        String optString;
        Intrinsics.h(callback, "callback");
        if (TextUtils.isEmpty(str)) {
            callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "adConfig is empty");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (str == null) {
                str = "{}";
            }
            jSONObject = new JSONObject(str);
            optString = jSONObject.optString("sceneId");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (TextUtils.isEmpty(optString)) {
            callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), "sceneId is empty");
            return;
        }
        int optInt = jSONObject.optInt("adType");
        if (optInt == 3) {
            H5VideoAdProvider.f42506a.h(optString, callback);
        } else if (optInt == 4) {
            H5InterstitialAdProvider.f42502a.f(optString, callback);
        }
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        callback.onAdStateCallback(H5AdStateEnum.MB_H5_AD_STATE_ON_FAIL.getValue(), m1188exceptionOrNullimpl.getMessage());
    }
}
