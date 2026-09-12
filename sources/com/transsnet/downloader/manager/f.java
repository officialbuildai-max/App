package com.transsnet.downloader.manager;

import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.c0;
import com.tencent.mmkv.MMKV;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    private static final int f59608h = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final a f59601a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f59602b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.manager.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            f i11;
            i11 = f.i();
            return i11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final String f59603c = "key_next_dl_type";

    /* renamed from: d, reason: collision with root package name */
    private static final String f59604d = "key_last_download_time";

    /* renamed from: e, reason: collision with root package name */
    private static final String f59605e = "key_today_downloaded_times";

    /* renamed from: f, reason: collision with root package name */
    private static final int f59606f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f59607g = 2;

    /* renamed from: i, reason: collision with root package name */
    private static final int f59609i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final int f59610j = 2;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return (f) f.f59602b.getValue();
        }

        public final String b() {
            return f.f59604d;
        }

        public final int c() {
            return f.f59606f;
        }

        public final int d() {
            return f.f59607g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f i() {
        return new f();
    }

    public final int f() {
        return f59608h;
    }

    public final void g() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (!c0.f(bVar.b().getLong(f59604d, 0L))) {
            bVar.b().putInt(f59605e, 1);
            return;
        }
        MMKV b11 = bVar.b();
        String str = f59605e;
        bVar.b().putInt(str, b11.getInt(str, 0) + 1);
    }

    public final void h() {
        f();
    }

    public final void j(FragmentActivity activity, Subject subject, Function0 function0) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(subject, "subject");
        if (f() != f59608h || function0 == null) {
            return;
        }
        function0.invoke();
    }
}
