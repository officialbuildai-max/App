package com.transsnet.downloader.util;

import com.tencent.mmkv.MMKV;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class d0 {

    /* renamed from: c, reason: collision with root package name */
    private static int f60051c;

    /* renamed from: d, reason: collision with root package name */
    private static int f60052d;

    /* renamed from: a, reason: collision with root package name */
    public static final d0 f60049a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f60050b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.c0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV f11;
            f11 = d0.f();
            return f11;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final int f60053e = 20;

    /* renamed from: f, reason: collision with root package name */
    private static final int f60054f = 3;

    /* renamed from: g, reason: collision with root package name */
    private static CopyOnWriteArrayList f60055g = new CopyOnWriteArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static final androidx.view.b0 f60056h = new androidx.view.b0();

    private d0() {
    }

    private final int b() {
        int i11;
        String value;
        if (f60051c <= 0) {
            try {
                ConfigBean c11 = sm.f.f75530c.a().c("shorts_unlock_config", true);
                i11 = (c11 == null || (value = c11.getValue()) == null) ? f60053e : new JSONObject(value).optInt("maxUnlockCount");
            } catch (Exception unused) {
                i11 = f60053e;
            }
            f60051c = i11;
        }
        return f60051c;
    }

    private final MMKV d() {
        return (MMKV) f60050b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV f() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final int c(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        return d().getInt(subjectId, b());
    }

    public final int e() {
        int i11;
        String value;
        if (f60052d <= 0) {
            try {
                ConfigBean c11 = sm.f.f75530c.a().c("shorts_unlock_config", true);
                i11 = (c11 == null || (value = c11.getValue()) == null) ? f60054f : new JSONObject(value).optInt("perUnlockCount");
            } catch (Exception unused) {
                i11 = f60054f;
            }
            f60052d = i11;
        }
        return f60052d;
    }

    public final void g(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        d().putInt(subjectId, i11);
        Iterator it = f60055g.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
        }
    }
}
