package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f35679a = new HashMap();

    public Map<String, String> a() {
        return this.f35679a;
    }

    public void a(e eVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (eVar == null || (map = eVar.f35679a) == null || (map2 = this.f35679a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            if (!(obj instanceof String)) {
                this.f35679a.put(str, obj + "");
            } else if (!TextUtils.isEmpty((String) obj)) {
                this.f35679a.put(str, (String) obj);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public boolean a(String str) {
        return this.f35679a.containsKey(str);
    }

    public Object b(String str) {
        return this.f35679a.get(str);
    }

    public void c(String str) {
        if (this.f35679a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f35679a.remove(str);
    }
}
