package com.transsnet.downloader.util;

import com.transsion.mb.config.manager.ConfigBean;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f60070a = new k();

    private k() {
    }

    public final boolean a() {
        String value;
        Long x10;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        long j11 = bVar.b().getLong("key_download_st_show_last_time", 0L);
        long j12 = bVar.b().getLong("key_download_st_showed_times", 0L);
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "key_storage_per_total_show_times", false, 2, null);
        long longValue = (d11 == null || (value = d11.getValue()) == null || (x10 = StringsKt.x(value)) == null) ? 3L : x10.longValue();
        return !com.blankj.utilcode.util.c0.f(j11) && (longValue > 0 ? longValue : 3L) > j12;
    }
}
