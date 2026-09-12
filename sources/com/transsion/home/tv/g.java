package com.transsion.home.tv;

import androidx.view.b0;
import androidx.view.t0;
import com.transsion.home.tv.bean.Pager;
import com.transsion.home.tv.bean.StreamItem;
import com.transsion.home.tv.bean.TvChannelItem;
import com.transsion.home.tv.bean.TvChannelListDataBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class g extends t0 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f45741f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f45742g = 8;

    /* renamed from: d, reason: collision with root package name */
    private String f45746d;

    /* renamed from: a, reason: collision with root package name */
    private final b0 f45743a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private final b0 f45744b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private boolean f45745c = true;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f45747e = LazyKt.b(new Function0() { // from class: com.transsion.home.tv.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ql.a m11;
            m11 = g.m();
            return m11;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f45749e;

        b(String str) {
            this.f45749e = str;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("TvLiveDetailViewModel", "fetchChannelList failed code=" + str + " msg=" + str2, true);
            g.this.f().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TvChannelListDataBean tvChannelListDataBean) {
            Pager pager;
            List<TvChannelItem> items;
            Pager pager2;
            Pager pager3;
            Boolean bool = null;
            g.this.f45746d = (!((tvChannelListDataBean == null || (pager3 = tvChannelListDataBean.getPager()) == null) ? false : Intrinsics.c(pager3.getHasMore(), Boolean.TRUE)) || (pager2 = tvChannelListDataBean.getPager()) == null) ? null : pager2.getNextPage();
            a.C0856a c0856a = lg.a.f68962a;
            String str = this.f45749e;
            Integer valueOf = (tvChannelListDataBean == null || (items = tvChannelListDataBean.getItems()) == null) ? null : Integer.valueOf(items.size());
            if (tvChannelListDataBean != null && (pager = tvChannelListDataBean.getPager()) != null) {
                bool = pager.getHasMore();
            }
            c0856a.c("TvLiveDetailViewModel", "fetchChannelList success page=" + str + " size=" + valueOf + " hasMore=" + bool, false);
            g.this.f().q(tvChannelListDataBean);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f45750d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f45751e;

        c(String str, g gVar) {
            this.f45750d = str;
            this.f45751e = gVar;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            lg.a.f68962a.i("TvLiveDetailViewModel", "loadChannelDetail failed code=" + str + " msg=" + str2, true);
            this.f45751e.e().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(TvChannelItem tvChannelItem) {
            List<StreamItem> streams;
            StreamItem streamItem;
            lg.a.f68962a.c("TvLiveDetailViewModel", "loadChannelDetail success channelId=" + this.f45750d + " url=" + ((tvChannelItem == null || (streams = tvChannelItem.getStreams()) == null || (streamItem = (StreamItem) CollectionsKt.k0(streams)) == null) ? null : streamItem.getUrl()), false);
            this.f45751e.e().q(tvChannelItem);
        }
    }

    private final void d(String str, String str2) {
        g().d(str2, 20, str).f(sg.d.f75472a.c()).subscribe(new b(str2));
    }

    private final ql.a g() {
        return (ql.a) this.f45747e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ql.a m() {
        return (ql.a) zg.c.f79537e.a().h(ql.a.class);
    }

    public final b0 e() {
        return this.f45743a;
    }

    public final b0 f() {
        return this.f45744b;
    }

    public final boolean h() {
        String str = this.f45746d;
        return !(str == null || str.length() == 0);
    }

    public final boolean i() {
        return this.f45745c;
    }

    public final void j(String channelId) {
        Intrinsics.h(channelId, "channelId");
        g().b(channelId).f(sg.d.f75472a.c()).subscribe(new c(channelId, this));
    }

    public final void k(String countryCode) {
        Intrinsics.h(countryCode, "countryCode");
        String str = this.f45746d;
        if (str == null || str.length() == 0) {
            lg.a.f68962a.x("TvLiveDetailViewModel", "loadMoreChannelList: nextPage is null, stop", false);
        } else {
            this.f45745c = false;
            d(countryCode, str);
        }
    }

    public final void l(String countryCode) {
        Intrinsics.h(countryCode, "countryCode");
        this.f45745c = true;
        this.f45746d = null;
        d(countryCode, "1");
    }
}
