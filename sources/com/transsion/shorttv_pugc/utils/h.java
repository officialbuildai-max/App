package com.transsion.shorttv_pugc.utils;

import androidx.view.b0;
import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    private static int f54502d;

    /* renamed from: e, reason: collision with root package name */
    private static int f54503e;

    /* renamed from: i, reason: collision with root package name */
    private static st.b f54507i;

    /* renamed from: a, reason: collision with root package name */
    public static final h f54499a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f54500b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.utils.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV i11;
            i11 = h.i();
            return i11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f54501c = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.utils.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV j11;
            j11 = h.j();
            return j11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static final int f54504f = 20;

    /* renamed from: g, reason: collision with root package name */
    private static final int f54505g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static CopyOnWriteArrayList f54506h = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    private static final b0 f54508j = new b0();

    private h() {
    }

    private final st.b c() {
        st.b bVar = f54507i;
        if (bVar == null) {
            tt.a b11 = ys.a.f79179a.b();
            bVar = b11 != null ? b11.h() : null;
            f54507i = bVar;
        }
        return bVar;
    }

    private final int d() {
        int i11;
        String a11;
        if (f54502d <= 0) {
            try {
                st.b c11 = c();
                i11 = (c11 == null || (a11 = c11.a()) == null) ? f54504f : new JSONObject(a11).optInt("maxUnlockCount");
            } catch (Exception unused) {
                i11 = f54504f;
            }
            f54502d = i11;
        }
        return f54502d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV j() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final int e(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        return f().getInt(subjectId, d());
    }

    public final MMKV f() {
        return (MMKV) f54500b.getValue();
    }

    public final MMKV g() {
        return (MMKV) f54501c.getValue();
    }

    public final int h() {
        int i11;
        String a11;
        if (f54503e <= 0) {
            try {
                st.b c11 = c();
                i11 = (c11 == null || (a11 = c11.a()) == null) ? f54505g : new JSONObject(a11).optInt("perUnlockCount");
            } catch (Exception unused) {
                i11 = f54505g;
            }
            f54503e = i11;
        }
        return f54503e;
    }

    public final void k(String subjectId, int i11) {
        Intrinsics.h(subjectId, "subjectId");
        f().putInt(subjectId, i11);
        Iterator it = f54506h.iterator();
        while (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
        }
    }
}
