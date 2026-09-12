package k8;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f66803a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map f66804b;

    static {
        HashMap hashMap = new HashMap();
        f66803a = hashMap;
        HashMap hashMap2 = new HashMap();
        f66804b = hashMap2;
        hashMap.put("FACEBOOK_BIDDER", "facebook");
        hashMap2.put("facebook", "FACEBOOK_BIDDER");
        hashMap.put("APPLOVIN_BIDDER", "applovin");
        hashMap2.put("applovin", "APPLOVIN_BIDDER");
        hashMap.put("TAPJOY_BIDDER", "tapjoy");
        hashMap2.put("tapjoy", "TAPJOY_BIDDER");
    }

    public static boolean a(String str) {
        return "FACEBOOK_BIDDER".equals(str) || "APPLOVIN_BIDDER".equals(str) || "TAPJOY_BIDDER".equals(str) || "CHARTBOOST_BIDDER".equals(str);
    }
}
