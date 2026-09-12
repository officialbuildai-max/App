package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.settings.aa;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class TEQ extends aa {
    static final ArrayList<String> EjP = new ArrayList<>(Arrays.asList("ja", "en", "ko", "zh", "th", "vi", "id", "ru", "ar", "fr", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "it", "es", "hi", "pt", "zh-Hant", "ms", "pl", "tr"));
    private Set<String> HiB;
    public boolean TKC;

    public TEQ(aa.Sj sj2) {
        super("tt_sdk_settings_sr.prop", sj2);
        this.HiB = Collections.synchronizedSet(new HashSet());
    }

    public static Set<String> Sj(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(79:1|(1:371)(2:4|(77:6|7|(1:9)(1:369)|10|(3:12|(1:17)|16)|18|(1:20)|21|(3:23|(1:28)|27)|29|(4:31|(1:33)(1:367)|34|(1:36))(1:368)|37|(1:39)|40|(4:42|(1:44)|45|(1:47))(1:366)|48|(1:52)|53|(1:55)|56|(1:58)|59|(1:61)|62|(1:64)|65|(1:67)|68|(1:70)|71|(1:73)|74|(1:76)|77|(1:79)|80|(1:82)|83|(1:85)|86|(1:88)|89|(1:91)|92|(1:94)|95|(16:97|(2:99|(1:103))|104|(1:106)|107|(1:109)|110|(1:112)|113|(1:115)|116|(1:118)|119|(1:121)|122|(4:124|125|(3:129|(2:132|130)|133)|134))|139|140|(1:142)|143|(14:145|(1:147)(1:177)|148|(1:150)|151|(1:153)|154|(1:156)|157|(1:159)|160|(2:162|(1:164)(1:165))|166|(4:168|(1:172)|(1:174)(1:176)|175))|178|(1:180)|181|(3:183|(1:187)|188)|189|(3:191|(1:195)|196)|197|(3:199|(1:204)|203)|205|(1:207)|208|(32:210|(1:212)|213|(1:215)|216|(1:218)|219|(1:221)|222|(1:224)|225|(1:227)|228|(1:230)|231|(1:233)|234|(1:236)|237|(1:239)|240|(1:242)|243|(1:245)|246|(1:248)|249|(1:251)|252|(1:254)|255|(1:257))|258|(3:281|282|(46:284|(2:286|(1:288))|289|(2:291|(1:293))|294|(1:296)|297|(1:299)|300|(1:302)|303|(1:305)|306|(1:308)|309|(1:314)|315|(1:317)|318|(2:320|(1:322))|323|(1:325)|326|(1:328)|329|(1:331)|332|(1:334)|335|(1:337)|338|(1:340)|341|(1:343)|344|(1:346)|347|(1:349)|350|(1:352)|353|(1:355)|356|(1:358)|359|(1:361)))|260|261|262|263|(1:265)|266|(1:268)|269|(2:271|(1:273)(1:274))|275|276))|370|7|(0)(0)|10|(0)|18|(0)|21|(0)|29|(0)(0)|37|(0)|40|(0)(0)|48|(2:50|52)|53|(0)|56|(0)|59|(0)|62|(0)|65|(0)|68|(0)|71|(0)|74|(0)|77|(0)|80|(0)|83|(0)|86|(0)|89|(0)|92|(0)|95|(0)|139|140|(0)|143|(0)|178|(0)|181|(0)|189|(0)|197|(0)|205|(0)|208|(0)|258|(0)|260|261|262|263|(0)|266|(0)|269|(0)|275|276) */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0795, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0796, code lost:
    
        com.bytedance.sdk.component.utils.sU.sP("SettingsDefaultRepository", "coreSettingJson", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x07e1  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0593 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0071  */
    @Override // com.bytedance.sdk.openadsdk.core.settings.HiB
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(org.json.JSONObject r34) {
        /*
            Method dump skipped, instructions count: 2048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.settings.TEQ.Sj(org.json.JSONObject):void");
    }
}
