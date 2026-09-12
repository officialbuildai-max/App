package com.transsion.postdetail.shorttv;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.baselib.db.video.ShortTvFavoriteState;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class ShortTvPlayListViewModel extends androidx.view.b {

    /* renamed from: n, reason: collision with root package name */
    public static final a f49229n = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final com.transsion.postdetail.shorttv.a f49230b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f49231c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f49232d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f49233e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f49234f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f49235g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f49236h;

    /* renamed from: i, reason: collision with root package name */
    private final b0 f49237i;

    /* renamed from: j, reason: collision with root package name */
    private final b0 f49238j;

    /* renamed from: k, reason: collision with root package name */
    private final b0 f49239k;

    /* renamed from: l, reason: collision with root package name */
    private final b0 f49240l;

    /* renamed from: m, reason: collision with root package name */
    private final HashMap f49241m;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvPlayListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f49230b = (com.transsion.postdetail.shorttv.a) zg.c.f79537e.a().h(com.transsion.postdetail.shorttv.a.class);
        this.f49231c = new b0();
        this.f49232d = new b0();
        this.f49233e = new b0();
        this.f49234f = new b0();
        this.f49235g = new b0();
        this.f49236h = new b0();
        this.f49237i = new b0();
        this.f49238j = new b0();
        this.f49239k = new b0();
        this.f49240l = new b0();
        this.f49241m = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        ShortTvFavoriteState shortTvFavoriteState = new ShortTvFavoriteState();
        shortTvFavoriteState.setFavoriteNum(shortTVFavInfo.getFavoriteNum());
        shortTvFavoriteState.setHasFavorite(shortTVFavInfo.getHasFavorite());
        shortTvFavoriteState.setFavoriteTime(shortTVFavInfo.getFavoriteTime());
        String subjectId = subject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        shortTvFavoriteState.setSubjectId(subjectId);
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvPlayListViewModel$updateFavorite$1$1(this, shortTvFavoriteState, null), 3, null);
    }

    public final void d(Subject subject) {
        ShortTVFavInfo shortTVFavInfo;
        if (subject == null || (shortTVFavInfo = subject.getShortTVFavInfo()) == null) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ShortTvPlayListViewModel$favorite$1(subject, shortTVFavInfo.getHasFavorite(), this, shortTVFavInfo, null), 3, null);
    }

    public final b0 e() {
        return this.f49234f;
    }

    public final b0 f() {
        return this.f49235g;
    }

    public final com.transsion.postdetail.shorttv.a g() {
        return this.f49230b;
    }

    public final b0 h() {
        return this.f49231c;
    }

    public final void i(String type) {
        Intrinsics.h(type, "type");
        this.f49237i.q(type);
    }

    public final void j() {
        this.f49237i.q("ad_cancel");
    }
}
