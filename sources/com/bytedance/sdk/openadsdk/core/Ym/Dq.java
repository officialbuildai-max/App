package com.bytedance.sdk.openadsdk.core.Ym;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class Dq {
    @NonNull
    public static Jcg Sj(@NonNull View view, @NonNull Set<TEQ> set) {
        AdSession Sj = Sj(CreativeType.VIDEO, set, Owner.NATIVE);
        return new uA(Sj, AdEvents.createAdEvents(Sj), view, MediaEvents.createMediaEvents(Sj));
    }

    public static Jcg Sj(WebView webView) {
        Partner Sj = HiB.Sj();
        if (Sj == null) {
            throw new IllegalArgumentException("Parameter 'partner' may not be null.");
        }
        AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(Sj, webView, "", ""));
        return new Jcg(createAdSession, AdEvents.createAdEvents(createAdSession), webView);
    }

    private static AdSession Sj(CreativeType creativeType, Set<TEQ> set, Owner owner) {
        List<VerificationScriptResource> Sj = Sj(set);
        Sj.isEmpty();
        Partner Sj2 = HiB.Sj();
        if (Sj2 == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(Sj2, HiB.sP(), Sj, "", ""));
    }

    private static List<VerificationScriptResource> Sj(Set<TEQ> set) {
        ArrayList arrayList = new ArrayList();
        for (TEQ teq : set) {
            if (!TextUtils.isEmpty(teq.Sj()) && !TextUtils.isEmpty(teq.sP())) {
                arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(teq.Sj(), teq.TKC(), teq.sP()));
            }
            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(teq.TKC()));
        }
        return arrayList;
    }
}
