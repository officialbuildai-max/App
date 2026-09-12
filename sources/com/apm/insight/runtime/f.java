package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.l.c;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.event.EventConstants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f19880a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, Long> f19881b;

    /* renamed from: c, reason: collision with root package name */
    private int f19882c;

    /* renamed from: d, reason: collision with root package name */
    private int f19883d;

    public f(Context context) {
        this.f19881b = null;
        this.f19882c = 50;
        this.f19883d = 100;
        this.f19880a = context;
        this.f19881b = b();
        this.f19882c = a.a(this.f19882c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.f19883d = a.a(this.f19883d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> b() {
        JSONArray a11;
        File h11 = com.apm.insight.l.j.h(this.f19880a);
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put(EventConstants.KEY_TIME, Long.valueOf(System.currentTimeMillis()));
        try {
            a11 = com.apm.insight.l.f.a(h11.getAbsolutePath());
        } catch (IOException unused) {
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
        if (com.apm.insight.a.a(a11)) {
            return hashMap;
        }
        Long decode = Long.decode(a11.optString(0, null));
        if (System.currentTimeMillis() - decode.longValue() > 86400000) {
            File g11 = com.apm.insight.l.j.g(this.f19880a);
            h11.renameTo(new File(g11, String.valueOf(System.currentTimeMillis())));
            String[] list = g11.list();
            if (list != null && list.length > 5) {
                Arrays.sort(list);
                new File(g11, list[0]).delete();
            }
            return hashMap;
        }
        hashMap.put(EventConstants.KEY_TIME, decode);
        for (int i11 = 1; i11 < a11.length(); i11++) {
            String[] split = a11.optString(i11, "").split(" ");
            if (split.length == 2) {
                hashMap.put(split[0], Long.decode(split[1]));
            }
        }
        return hashMap;
    }

    public final void a() {
        HashMap<String, Long> hashMap = this.f19881b;
        Long remove = hashMap.remove(EventConstants.KEY_TIME);
        if (remove == null) {
            com.apm.insight.c.a();
            j.a(new RuntimeException("err times, no time"), "NPTH_CATCH");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(remove);
        sb2.append('\n');
        for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append(' ');
            sb2.append(entry.getValue());
            sb2.append('\n');
        }
        try {
            com.apm.insight.l.f.a(com.apm.insight.l.j.h(this.f19880a), sb2.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            str = "default";
        }
        return c.AnonymousClass1.a(this.f19881b, str, 1L).longValue() < ((long) this.f19882c) && c.AnonymousClass1.a(this.f19881b, IntegrationConstants.NAVIGATION_BAR_ALL_ACTION, 1L).longValue() < ((long) this.f19883d);
    }
}
