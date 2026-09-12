package com.google.firebase.perf.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ConfigurationConstants$LogSourceName extends u {

    /* renamed from: a, reason: collision with root package name */
    private static ConfigurationConstants$LogSourceName f32279a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map f32280b = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants$LogSourceName.1
        {
            put(461L, "FIREPERF_AUTOPUSH");
            put(462L, "FIREPERF");
            put(675L, "FIREPERF_INTERNAL_LOW");
            put(676L, "FIREPERF_INTERNAL_HIGH");
        }
    });

    private ConfigurationConstants$LogSourceName() {
    }

    public static synchronized ConfigurationConstants$LogSourceName e() {
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName;
        synchronized (ConfigurationConstants$LogSourceName.class) {
            try {
                if (f32279a == null) {
                    f32279a = new ConfigurationConstants$LogSourceName();
                }
                configurationConstants$LogSourceName = f32279a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return configurationConstants$LogSourceName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f(long j11) {
        return (String) f32280b.get(Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(long j11) {
        return f32280b.containsKey(Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String a() {
        return "com.google.firebase.perf.LogSourceName";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.u
    public String c() {
        return "fpr_log_source";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return pc.a.f72532c;
    }
}
