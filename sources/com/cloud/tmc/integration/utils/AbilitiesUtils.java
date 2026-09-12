package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.AbilityConfig;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\bH\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/cloud/tmc/integration/utils/AbilitiesUtils;", "", "()V", "DEFAULT_LATEST_BLACK_LIST", "", "", "KEY_ABILITY_APPID", "REQUEST_TIME_INTERVAL", "", "TAG", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "defaultConfig", "getDefaultConfig", "()Ljava/lang/String;", "getAbilitiesConfig", "Ljava/util/ArrayList;", "Lcom/cloud/tmc/integration/model/AbilityConfig;", "Lkotlin/collections/ArrayList;", "getAbilityEnableStatus", "", "appId", "ability", "isAllowRequest", "lastRequestTime", "saveAbilitiesConfig", "", "data", "updateMMKVConfig", "updateRequestTime", "Ability", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AbilitiesUtils {
    private static final String KEY_ABILITY_APPID = "miniSdkAbilities";
    private static final long REQUEST_TIME_INTERVAL = 604800000;
    private static final String TAG = "AbilitiesUtils";
    public static final AbilitiesUtils INSTANCE = new AbilitiesUtils();
    private static final List<String> DEFAULT_LATEST_BLACK_LIST = CollectionsKt.q(MiniAppConfigHelper.DEFAULT_MINI_FEEDBACK_ID, TmcConstants.SETTING_MINIAPP_ID);
    private static final String defaultConfig = "[{\n\t\"miniappId\": \"1000886706715795456\",\n\t\"miniappName\": \"小程序中心\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": true\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": true\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000083312531542016\",\n\t\"miniappName\": \"记事本\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000391591855976448\",\n\t\"miniappName\": \"MiniApp Setting\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"feedback\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"permission\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_url\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_friends\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"message\",\n\t\t\"enable\": false\n\t}]\n}, {\n\t\"miniappId\": \"1000497027976413184\",\n\t\"miniappName\": \"SharpNews\",\n\t\"abilities\": [{\n\t\t\"ability\": \"refresh\",\n\t\t\"enable\": false\n\t}]\n},{\n\t\"miniappId\": \"1000550440273772544\",\n\t\"miniappName\": \"反馈小程序\",\n\t\"abilities\": [{\n\t\t\"ability\": \"title_bar_add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_favorites\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"add_home\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"latest_use\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"feedback\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"permission\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_url\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"share_friends\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"title_bar_share\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"shareGroup\",\n\t\t\"enable\": false\n\t}, {\n\t\t\"ability\": \"message\",\n\t\t\"enable\": false\n\t}]\n}]";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/cloud/tmc/integration/utils/AbilitiesUtils$Ability;", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    /* loaded from: classes3.dex */
    public @interface Ability {
    }

    private AbilitiesUtils() {
    }

    private final Context getContext() {
        Context applicationContext = ((IApplicationContextGetter) TmcProxy.get(IApplicationContextGetter.class)).getApplicationContext();
        Intrinsics.g(applicationContext, "get(IApplicationContextG….java).applicationContext");
        return applicationContext;
    }

    private final long lastRequestTime() {
        return ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getLong(getContext(), "miniSdkAbilities", TmcConstants.MENU_KEY_ABILITY_CONFIG_UPDATE_DATE);
    }

    private final void updateMMKVConfig(String data) {
        try {
            Object fromJson = GsonUtils.fromJson(data, new TypeToken<ArrayList<AbilityConfig>>() { // from class: com.cloud.tmc.integration.utils.AbilitiesUtils$updateMMKVConfig$abilitiesConfigList$1
            }.getType());
            Intrinsics.g(fromJson, "fromJson(data, object : …bilityConfig>>() {}.type)");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((ArrayList) fromJson).iterator();
            while (it.hasNext()) {
                AbilityConfig abilityConfig = (AbilityConfig) it.next();
                ArrayList<AbilityConfig.Ability> abilities = abilityConfig.getAbilities();
                if (abilities != null) {
                    for (AbilityConfig.Ability ability : abilities) {
                        if (Intrinsics.c(ability.getAbility(), TmcConstants.MENU_KEY_ADD_FAVORITES) && Intrinsics.c(ability.getEnable(), Boolean.FALSE)) {
                            arrayList.add(abilityConfig.getMiniappId());
                        } else if (Intrinsics.c(ability.getAbility(), TmcConstants.MENU_KEY_LATEST_USE) && Intrinsics.c(ability.getEnable(), Boolean.FALSE)) {
                            arrayList2.add(abilityConfig.getMiniappId());
                        }
                    }
                }
            }
            LatestUseUtils.removeList(arrayList2);
        } catch (Throwable th2) {
            TmcLogger.e("updateMMKVConfig failed!", th2);
        }
    }

    private final void updateRequestTime() {
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putLong(getContext(), "miniSdkAbilities", TmcConstants.MENU_KEY_ABILITY_CONFIG_UPDATE_DATE, System.currentTimeMillis());
    }

    public final ArrayList<AbilityConfig> getAbilitiesConfig() {
        String string = ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).getString(getContext(), "miniSdkAbilities", TmcConstants.MENU_KEY_ABILITY_CONFIG);
        if (string == null) {
            string = defaultConfig;
        }
        Intrinsics.g(string, "TmcProxy.get(KVStoragePr…         ?: defaultConfig");
        try {
            Object fromJson = GsonUtils.fromJson(string, new TypeToken<ArrayList<AbilityConfig>>() { // from class: com.cloud.tmc.integration.utils.AbilitiesUtils$getAbilitiesConfig$1
            }.getType());
            Intrinsics.g(fromJson, "{\n            GsonUtils.…e\n            )\n        }");
            return (ArrayList) fromJson;
        } catch (Exception e11) {
            TmcLogger.e("Failed to parse menu config", e11);
            return new ArrayList<>();
        }
    }

    public final boolean getAbilityEnableStatus(String appId, String ability) {
        Object obj;
        Object obj2;
        ArrayList<AbilityConfig.Ability> abilities;
        Boolean enable;
        Intrinsics.h(appId, "appId");
        Intrinsics.h(ability, "ability");
        ArrayList<AbilityConfig> abilitiesConfig = getAbilitiesConfig();
        if (abilitiesConfig.isEmpty() && Intrinsics.c(ability, TmcConstants.MENU_KEY_LATEST_USE)) {
            return !DEFAULT_LATEST_BLACK_LIST.contains(appId);
        }
        Iterator<T> it = abilitiesConfig.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (Intrinsics.c(((AbilityConfig) obj2).getMiniappId(), appId)) {
                break;
            }
        }
        AbilityConfig abilityConfig = (AbilityConfig) obj2;
        if (abilityConfig == null || (abilities = abilityConfig.getAbilities()) == null) {
            return true;
        }
        Iterator<T> it2 = abilities.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.c(((AbilityConfig.Ability) next).getAbility(), ability)) {
                obj = next;
                break;
            }
        }
        AbilityConfig.Ability ability2 = (AbilityConfig.Ability) obj;
        if (ability2 == null || (enable = ability2.getEnable()) == null) {
            return true;
        }
        return enable.booleanValue();
    }

    public final String getDefaultConfig() {
        return defaultConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isAllowRequest() {
        /*
            r6 = this;
            long r0 = r6.lastRequestTime()
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L23
            boolean r0 = com.cloud.tmc.kernel.utils.AppDynamicBuildConfig.isAppDebugAble()
            if (r0 == 0) goto L19
            r0 = 120000(0x1d4c0, double:5.9288E-319)
            goto L1c
        L19:
            r0 = 604800000(0x240c8400, double:2.988109026E-315)
        L1c:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L21
            goto L23
        L21:
            r0 = 0
            goto L24
        L23:
            r0 = 1
        L24:
            if (r0 != 0) goto L4c
            long r4 = com.cloud.tmc.miniutils.util.TimeUtils.getNowMills()
            long r1 = r4 - r2
            r3 = 5
            java.lang.String r1 = com.cloud.tmc.miniutils.util.TimeUtils.getFitTimeSpan(r4, r1, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "It has only been "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " since the last update or check, which does not meet the 7 days update policy"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "AbilitiesUtils"
            com.cloud.tmc.kernel.log.TmcLogger.d(r2, r1)
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.AbilitiesUtils.isAllowRequest():boolean");
    }

    public final void saveAbilitiesConfig(String data) {
        Intrinsics.h(data, "data");
        ((KVStorageProxy) TmcProxy.get(KVStorageProxy.class)).putString(getContext(), "miniSdkAbilities", TmcConstants.MENU_KEY_ABILITY_CONFIG, data);
        updateRequestTime();
        updateMMKVConfig(data);
    }
}
