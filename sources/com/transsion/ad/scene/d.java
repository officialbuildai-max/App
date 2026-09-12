package com.transsion.ad.scene;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.strategy.f;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f42258a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap f42259b = new HashMap();

    private d() {
    }

    private final String a() {
        String simpleName = d.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final JsonObject b(String str) {
        JsonObject asJsonObject;
        String str2;
        JsonObject jsonObject;
        try {
            Result.Companion companion = Result.INSTANCE;
            HashMap hashMap = f42259b;
            if (hashMap.containsKey(str) && (jsonObject = (JsonObject) hashMap.get(str)) != null) {
                return jsonObject;
            }
            JsonArray jsonArray = (JsonArray) o.d(f.f42286a.c().getString("non_ad_scene_config_data", ""), JsonArray.class);
            if (jsonArray != null) {
                for (JsonElement jsonElement : jsonArray) {
                    if (jsonElement != null && (asJsonObject = jsonElement.getAsJsonObject()) != null) {
                        JsonElement jsonElement2 = asJsonObject.get("id");
                        if (jsonElement2 == null || (str2 = jsonElement2.getAsString()) == null) {
                            str2 = "";
                        }
                        f42259b.put(str2, asJsonObject);
                    }
                }
            }
            HashMap hashMap2 = f42259b;
            if (hashMap2.containsKey(str)) {
                return (JsonObject) hashMap2.get(str);
            }
            Result.m1185constructorimpl(Unit.f67184a);
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
            return null;
        }
    }

    public final String c() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(f.f42286a.c().getString("non_ad_scene_config_data", ""));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = null;
        }
        return (String) m1185constructorimpl;
    }

    public final String d() {
        return f.f42286a.c().getString("non_ad_scene_version", "");
    }

    public final boolean e() {
        return !TextUtils.isEmpty(f.f42286a.c().getString("non_ad_scene_config_data", ""));
    }

    public final void f(String assetsString) {
        Intrinsics.h(assetsString, "assetsString");
        f.f42286a.c().putString("non_ad_scene_config_data", assetsString);
        oi.a.c(oi.a.f71145a, a() + " --> setScene4Assets() --> 场景信息保存到MMKV --> success", 0, false, 6, null);
    }

    public final void g(MbAdPlansDto mbAdPlansDto) {
        Intrinsics.h(mbAdPlansDto, "mbAdPlansDto");
        f fVar = f.f42286a;
        String string = fVar.c().getString("non_ad_scene_version", "");
        MbAdPlansBean data = mbAdPlansDto.getData();
        String versionAdScene = data != null ? data.getVersionAdScene() : null;
        if (TextUtils.equals(string, versionAdScene)) {
            oi.a.c(oi.a.f71145a, a() + " --> setSceneConfig() --> 版本号一致，服务端不会下发list 省流量 --> localAdSceneVersion = " + string + " --> newVersion = " + versionAdScene, 0, false, 6, null);
            return;
        }
        fVar.c().putString("non_ad_scene_version", versionAdScene);
        MMKV c11 = fVar.c();
        MbAdPlansBean data2 = mbAdPlansDto.getData();
        c11.putString("non_ad_scene_config_data", data2 != null ? data2.getAdSceneConfigData() : null);
        oi.a.c(oi.a.f71145a, a() + " --> setSceneConfig() --> 场景信息保存到MMKV --> success --> newVersion = " + versionAdScene, 0, false, 6, null);
    }
}
