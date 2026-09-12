package com.bytedance.sdk.openadsdk.core.TEQ.sP;

import android.content.Context;
import com.cloud.tmc.kernel.constants.TmcConstants;

/* loaded from: classes3.dex */
public class TKC extends com.bytedance.adsdk.ugeno.uA.TKC.Sj {
    public TKC(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.uA.TKC.Sj
    public String Jcg(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -282781070:
                if (str.equals("unmuted")) {
                    c11 = 0;
                    break;
                }
                break;
            case -191501435:
                if (str.equals(TmcConstants.MENU_KEY_FEEDBACK)) {
                    c11 = 1;
                    break;
                }
                break;
            case -84569050:
                if (str.equals("right_arrow")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3327403:
                if (str.equals("logo")) {
                    c11 = 3;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c11 = 4;
                    break;
                }
                break;
            case 104264043:
                if (str.equals("muted")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return "tt_reward_full_unmute";
            case 1:
                return "tt_reward_full_feedback";
            case 2:
                return "tt_skip_btn";
            case 3:
                return "tt_ad_logo";
            case 4:
                return "tt_close_btn";
            case 5:
                return "tt_reward_full_mute";
            default:
                return null;
        }
    }
}
