package com.mbridge.msdk.mbnative.cache;

import com.mbridge.msdk.out.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, b<String, List<Campaign>>> f36290a = new HashMap();

    public static b<String, List<Campaign>> a(int i11) {
        if (f36290a.containsKey(Integer.valueOf(i11))) {
            return f36290a.get(Integer.valueOf(i11));
        }
        a aVar = new a(i11);
        f36290a.put(Integer.valueOf(i11), aVar);
        return aVar;
    }
}
