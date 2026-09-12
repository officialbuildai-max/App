package com.transsion.member;

import com.transsion.member.i;
import com.transsion.memberapi.MemberFeatureData;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f46612a = new g();

    private g() {
    }

    public final List a(List list) {
        if (list == null) {
            list = CollectionsKt.l();
        }
        ArrayList arrayList = new ArrayList();
        for (MemberFeatureData memberFeatureData : list) {
            String featureIcon = memberFeatureData.getFeatureIcon();
            h hVar = null;
            String obj = featureIcon != null ? StringsKt.n1(featureIcon).toString() : null;
            String str = obj == null ? "" : obj;
            String featureName = memberFeatureData.getFeatureName();
            String obj2 = featureName != null ? StringsKt.n1(featureName).toString() : null;
            String str2 = obj2 == null ? "" : obj2;
            if (str.length() != 0 && str2.length() != 0) {
                String featureLink = memberFeatureData.getFeatureLink();
                String str3 = featureLink == null ? "" : featureLink;
                i.a aVar = i.f46634a;
                hVar = new h(str, str2, str3, aVar.a(memberFeatureData.getBasic()), aVar.a(memberFeatureData.getPro()));
            }
            if (hVar != null) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }
}
