package com.transsion.postdetail.ui.interceptor;

import ak.k;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.RouteItem;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.l;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.shorttv.factory.i;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import java.io.File;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import ox.e;

/* loaded from: classes.dex */
public final class LocalVideoDetailInterceptor {

    /* renamed from: a, reason: collision with root package name */
    public static final a f49926a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f49927b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.interceptor.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LocalVideoDetailInterceptor g11;
            g11 = LocalVideoDetailInterceptor.g();
            return g11;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalVideoDetailInterceptor a() {
            return (LocalVideoDetailInterceptor) LocalVideoDetailInterceptor.f49927b.getValue();
        }
    }

    private final boolean f(String str, String str2) {
        if (str == null) {
            File file = new File(str2);
            if (file.exists() && file.length() > 0) {
                return true;
            }
        } else {
            if (StringsKt.W(str2, "content", false, 2, null)) {
                k1.a g11 = k1.a.g(Utils.a(), Uri.parse(str2));
                if (g11 != null) {
                    return g11.e();
                }
                return true;
            }
            File file2 = new File(str2);
            if (file2.exists() && file2.length() > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalVideoDetailInterceptor g() {
        return new LocalVideoDetailInterceptor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(RouteItem routeItem, bg.b bVar) {
        try {
            if (routeItem.getExtras().getInt("subject_type", -1) == SubjectType.SHORT_TV.getValue()) {
                k.p(k.b(TheRouter.c(ls.a.f69157a.b()), routeItem.getExtras()));
                xj.b.a(bVar);
            } else {
                a.C0856a.l(lg.a.f68962a, "VideoFloat", LocalVideoDetailInterceptor.class.getSimpleName() + " open page ----2", false, 4, null);
                bVar.a(routeItem);
            }
        } catch (Throwable unused) {
            bVar.a(routeItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rs.a j() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tt.a k() {
        return new com.transsion.postdetail.shorttv.factory.a();
    }

    public final void i(RouteItem postcard, bg.b callback) {
        String path;
        Intrinsics.h(postcard, "postcard");
        Intrinsics.h(callback, "callback");
        if (Intrinsics.c(postcard.getPath(), "/ugc_video/detail") || Intrinsics.c(postcard.getPath(), "/ugc_video/local_detail") || Intrinsics.c(postcard.getPath(), "/ugc_shorts/detail")) {
            e.b.a(e.f72320a.b(), false, 1, null);
        }
        if (!Intrinsics.c(postcard.getPath(), "/video/detail")) {
            if (!Intrinsics.c(postcard.getPath(), ls.a.f69157a.b())) {
                callback.a(postcard);
                return;
            }
            lr.c.f69154a.a(new Function0() { // from class: com.transsion.postdetail.ui.interceptor.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    rs.a j11;
                    j11 = LocalVideoDetailInterceptor.j();
                    return j11;
                }
            });
            ys.a.f79179a.a(new Function0() { // from class: com.transsion.postdetail.ui.interceptor.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    tt.a k11;
                    k11 = LocalVideoDetailInterceptor.k();
                    return k11;
                }
            });
            e.b.a(e.f72320a.b(), false, 1, null);
            Bundle extras = postcard.getExtras();
            Serializable serializable = extras.getSerializable("item_object");
            Subject subject = serializable instanceof Subject ? (Subject) serializable : null;
            String string = subject == null ? extras.getString("id") : subject.getSubjectId();
            int i11 = extras.getInt("ep");
            int i12 = extras.getInt("extra_series_position", -1);
            if (string == null) {
                callback.a(postcard);
                return;
            }
            DownloadBean x10 = DownloadEsHelper.f59542m.a().x(string, i11);
            if ((x10 != null ? x10.getPath() : null) == null || !x10.isCompleted()) {
                callback.a(postcard);
                return;
            }
            String resourceId = x10.getResourceId();
            String path2 = x10.getPath();
            Intrinsics.e(path2);
            if (f(resourceId, path2)) {
                callback.a(postcard);
                return;
            }
            Activity o11 = l.f43413a.o();
            if (o11 == null || o11.isDestroyed() || o11.isFinishing()) {
                return;
            }
            LocalVideoNotExistUtil.f60027a.v(o11, x10, i12);
            return;
        }
        e.b.a(e.f72320a.b(), false, 1, null);
        Bundle extras2 = postcard.getExtras();
        String string2 = extras2.getString("extra_url");
        String string3 = extras2.getString("extra_subject_id");
        if (string3 == null) {
            string3 = "";
        }
        String string4 = extras2.getString("extra_local_path");
        String string5 = extras2.getString("extra_resource_id");
        boolean z10 = extras2.getBoolean("extra_is_series");
        int i13 = extras2.getInt("extra_series_position", -1);
        boolean z11 = extras2.getBoolean("extra_completed", true);
        if (extras2.getBoolean("extra_from_deeplink", false)) {
            callback.a(postcard);
            return;
        }
        if (string5 != null) {
            DownloadBean q11 = DownloadEsHelper.f59542m.a().q(string5);
            if (q11 != null && (path = q11.getPath()) != null) {
                string4 = path;
            }
            extras2.putString("extra_local_path", string4);
        }
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("Download_LocalVideoDetailInterceptor", "isDownloadCompleted  = " + z11 + "， path = " + string4, true);
        boolean z12 = (string2 == null || StringsKt.W(string2, "http", false, 2, null) || string3.length() != 0) ? false : true;
        if (string4 == null || string4.length() <= 0) {
            a.C0856a.f(c0856a, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, ", false, 4, null);
            Activity o12 = l.f43413a.o();
            if (o12 == null || o12.isDestroyed() || o12.isFinishing()) {
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f60027a;
            Intrinsics.e(string5);
            localVideoNotExistUtil.w(o12, string5, string4, z10, i13);
            return;
        }
        boolean f11 = f(string5, string4);
        if (!z11) {
            a.C0856a.f(c0856a, "Download_LocalVideoDetailInterceptor", "downloading play, open page", false, 4, null);
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new LocalVideoDetailInterceptor$process$1(string5, this, postcard, callback, string3, null), 3, null);
            return;
        }
        if (f11) {
            a.C0856a.f(c0856a, "Download_LocalVideoDetailInterceptor", "open page", false, 4, null);
            h(postcard, callback);
            return;
        }
        a.C0856a.f(c0856a, "Download_LocalVideoDetailInterceptor", "file is error, show error dialog, c, isOutside = " + z12, false, 4, null);
        if (z12) {
            uh.b.f76876a.d(R$string.download_no_local_file_tips);
            return;
        }
        Activity o13 = l.f43413a.o();
        if (o13 == null || o13.isDestroyed() || o13.isFinishing()) {
            return;
        }
        LocalVideoNotExistUtil localVideoNotExistUtil2 = LocalVideoNotExistUtil.f60027a;
        Intrinsics.e(string5);
        localVideoNotExistUtil2.w(o13, string5, string4, z10, i13);
    }
}
