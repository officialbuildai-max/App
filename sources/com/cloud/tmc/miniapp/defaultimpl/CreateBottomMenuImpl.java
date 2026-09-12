package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Activity;
import com.cloud.tmc.integration.model.AbilityConfig;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.AbilitiesUtils;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.dialog.OooOOO0;
import com.cloud.tmc.miniapp.point.CreateBottomMenuPoint;
import com.cloud.tmc.miniapp.ui.MiniAppActivity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CreateBottomMenuImpl implements CreateBottomMenuPoint {
    public static final OooO00o Companion = new OooO00o();

    /* loaded from: classes3.dex */
    public static final class OooO00o {
    }

    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint
    public void buildBottomDialog(Activity activity, OooOOO0 builder) {
        ArrayList<AbilityConfig.Ability> abilities;
        String ability;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(builder, "builder");
        if (activity instanceof MiniAppActivity) {
            App app = ((MiniAppActivity) activity).getMActivityHelper().getApp();
            Object obj = null;
            String appId = app != null ? app.getAppId() : null;
            if (appId == null) {
                return;
            }
            Intrinsics.g(appId, "activity.mActivityHelper.app?.appId ?: return");
            Iterator<T> it = AbilitiesUtils.INSTANCE.getAbilitiesConfig().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.c(((AbilityConfig) next).getMiniappId(), appId)) {
                    obj = next;
                    break;
                }
            }
            AbilityConfig abilityConfig = (AbilityConfig) obj;
            if (abilityConfig != null && (abilities = abilityConfig.getAbilities()) != null) {
                for (AbilityConfig.Ability ability2 : abilities) {
                    if (!Intrinsics.c(ability2.getEnable(), Boolean.TRUE) && (ability = ability2.getAbility()) != null) {
                        int hashCode = ability.hashCode();
                        if (hashCode != -517618225) {
                            if (hashCode != -321864378) {
                                if (hashCode != -191501435) {
                                    if (hashCode == 954925063 && ability.equals("message")) {
                                        builder.OooO00o(ability);
                                    }
                                } else if (ability.equals(TmcConstants.MENU_KEY_FEEDBACK)) {
                                    builder.OooO00o(ability);
                                }
                            } else if (ability.equals("refreshApp")) {
                                builder.OooO00o(ability);
                            }
                        } else if (ability.equals(TmcConstants.MENU_KEY_PERMISSION)) {
                            builder.OooO00o(ability);
                        }
                    }
                }
            }
            builder.OooO0o.notifyDataSetChanged();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onFinalized() {
        TmcLogger.i("CreateBottomMenuImpl", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.Extension
    public void onInitialized() {
        TmcLogger.i("CreateBottomMenuImpl", "onInitialized");
    }

    @Override // com.cloud.tmc.miniapp.point.CreateBottomMenuPoint
    public void requestBottomAbilityConfig() {
        MiniRequestUtils.requestAbilityConfig();
    }
}
