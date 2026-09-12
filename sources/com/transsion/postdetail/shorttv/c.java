package com.transsion.postdetail.shorttv;

import ak.t;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.therouter.router.RouteItem;
import com.transsion.moviedetailapi.SubjectType;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ox.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f49254a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f49255b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c c11;
            c11 = c.c();
            return c11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return (c) c.f49255b.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c c() {
        return new c();
    }

    public final void d(RouteItem postcard, bg.b callback) {
        Object obj;
        Object m1185constructorimpl;
        Intrinsics.h(postcard, "postcard");
        Intrinsics.h(callback, "callback");
        Iterator it = com.transsion.baselib.report.l.f43413a.m().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String localClassName = ((Activity) obj).getLocalClassName();
            Intrinsics.g(localClassName, "getLocalClassName(...)");
            if (StringsKt.c0(localClassName, "MainActivity", false, 2, null)) {
                break;
            }
        }
        Activity activity = (Activity) obj;
        if (activity == null) {
            activity = com.transsion.baselib.report.l.f43413a.o();
        }
        if (!Intrinsics.c(postcard.getPath(), "/movie/detail")) {
            if (!Intrinsics.c(postcard.getPath(), "/video/detail")) {
                callback.a(postcard);
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                if (postcard.getExtras().getInt("subject_type", SubjectType.MOVIE.getValue()) == SubjectType.MUSIC.getValue()) {
                    if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                        Navigator.x(ak.k.b(TheRouter.c("/playvideo/music_detail"), postcard.getExtras()), activity, null, 2, null);
                    }
                    xj.b.a(callback);
                } else {
                    callback.a(postcard);
                }
                m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) == null) {
                return;
            }
            callback.a(postcard);
            return;
        }
        try {
            Bundle extras = postcard.getExtras();
            extras.putLong("ts_enter", SystemClock.elapsedRealtime());
            int i11 = extras.getInt("subject_type", SubjectType.MOVIE.getValue());
            boolean z10 = extras.getBoolean("without_intercept", false);
            e.b.a(ox.e.f72320a.b(), false, 1, null);
            if (!z10 && i11 == SubjectType.SHORT_TV.getValue()) {
                if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                    Navigator.x(ak.k.b(TheRouter.c(ls.a.f69157a.b()), postcard.getExtras()), activity, null, 2, null);
                }
                xj.b.a(callback);
                return;
            }
            if (i11 != SubjectType.MUSIC.getValue()) {
                if (!t.f727a.b()) {
                    callback.a(postcard);
                    return;
                }
                if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                    Navigator.x(ak.k.b(TheRouter.c("/playvideo/detail"), postcard.getExtras()), activity, null, 2, null);
                }
                xj.b.a(callback);
                return;
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                postcard.getExtras().putBoolean("is_music_liked_fragment", extras.getBoolean("is_music_liked_fragment"));
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th3));
            }
            if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
                Navigator.x(ak.k.b(TheRouter.c("/playvideo/music_detail"), postcard.getExtras()), activity, null, 2, null);
            }
            xj.b.a(callback);
        } catch (Exception unused) {
            callback.a(postcard);
        }
    }
}
