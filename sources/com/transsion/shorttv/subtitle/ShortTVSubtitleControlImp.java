package com.transsion.shorttv.subtitle;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.view.c0;
import androidx.view.v;
import androidx.view.v0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.subtitle.manager.b;
import com.transsion.shorttv.utils.h;
import com.transsion.shorttv.viewmodel.ShortTvViewModel;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import hj.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import js.e;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import lg.a;
import ms.k0;

/* loaded from: classes6.dex */
public final class ShortTVSubtitleControlImp implements com.transsion.shorttv.subtitle.a, vs.a {

    /* renamed from: b, reason: collision with root package name */
    private final FragmentActivity f53113b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f53114c;

    /* renamed from: d, reason: collision with root package name */
    private final ShortTvViewModel f53115d;

    /* renamed from: e, reason: collision with root package name */
    private final e f53116e;

    /* renamed from: f, reason: collision with root package name */
    private final String f53117f;

    /* renamed from: g, reason: collision with root package name */
    private final String f53118g;

    /* renamed from: h, reason: collision with root package name */
    private final ws.a f53119h;

    /* renamed from: i, reason: collision with root package name */
    private Function1 f53120i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f53121j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f53122k;

    /* renamed from: l, reason: collision with root package name */
    private long f53123l;

    /* renamed from: m, reason: collision with root package name */
    private float f53124m;

    /* renamed from: n, reason: collision with root package name */
    private final ShortTVSubtitleControlImp$downloadListener$1 f53125n;

    /* loaded from: classes6.dex */
    public static final class a implements i5.a {
        a() {
        }

        @Override // i5.a
        public long getCurrentPosition() {
            return ShortTVSubtitleControlImp.this.f53123l;
        }

        @Override // i5.a
        public Float getSpeed() {
            return Float.valueOf(ShortTVSubtitleControlImp.this.f53124m);
        }

        @Override // i5.a
        public boolean isPlaying() {
            return ShortTVSubtitleControlImp.this.f53122k;
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f53127a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f53127a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f53127a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f53127a.invoke(obj);
        }
    }

    public ShortTVSubtitleControlImp(FragmentActivity activity, k0 viewBinding, ShortTvViewModel shortTvViewModel, e epItem, String str) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(viewBinding, "viewBinding");
        Intrinsics.h(epItem, "epItem");
        this.f53113b = activity;
        this.f53114c = viewBinding;
        this.f53115d = shortTvViewModel;
        this.f53116e = epItem;
        this.f53117f = str;
        this.f53118g = "ShortTVSubtitleCtr";
        ws.a aVar = (ws.a) new v0(activity).a(ws.a.class);
        this.f53119h = aVar;
        this.f53122k = true;
        this.f53124m = 1.0f;
        ShortTVSubtitleControlImp$downloadListener$1 shortTVSubtitleControlImp$downloadListener$1 = new ShortTVSubtitleControlImp$downloadListener$1(this);
        this.f53125n = shortTVSubtitleControlImp$downloadListener$1;
        aVar.b();
        aVar.e().j(activity, new b(new Function1() { // from class: com.transsion.shorttv.subtitle.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = ShortTVSubtitleControlImp.k(ShortTVSubtitleControlImp.this, (ts.b) obj);
                return k11;
            }
        }));
        b.a aVar2 = com.transsion.shorttv.subtitle.manager.b.f53144a;
        aVar2.b().b(shortTVSubtitleControlImp$downloadListener$1);
        aVar2.b().e(this);
        z(viewBinding.K);
    }

    private final void A(boolean z10) {
        a.C0856a.g(lg.a.f68962a, this.f53118g + " --> onSubtitleSwitchClick() --> turnOn = " + z10 + " --> 字幕开关状态变化", false, 2, null);
        if (z10) {
            E();
        } else {
            x();
        }
        this.f53119h.f().q(Boolean.valueOf(!z10));
    }

    private final void B(ts.b bVar) {
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", this.f53116e.e());
        ShortTVItem d11 = this.f53116e.d();
        if (d11 == null || (str = d11.getId()) == null) {
            str = "";
        }
        hashMap.put("mini_id", str);
        ShortTVItem d12 = this.f53116e.d();
        hashMap.put("se", String.valueOf(d12 != null ? Integer.valueOf(d12.getSe()) : null));
        hashMap.put("ep", String.valueOf(this.f53116e.c()));
        ShortTVItem d13 = this.f53116e.d();
        if (d13 == null || (str2 = d13.getVideoId()) == null) {
            str2 = "";
        }
        hashMap.put("video_id", str2);
        hashMap.put("opt_type", "subtitle_select");
        String ops = bVar.a().getOps();
        if (ops != null) {
            hashMap.put("ops", ops);
        }
        hashMap.put("name", bVar.a().getName());
        String lan = bVar.a().getLan();
        if (lan == null) {
            lan = "";
        }
        hashMap.put("lan", lan);
        String lanName = bVar.a().getLanName();
        hashMap.put("lan_name", lanName != null ? lanName : "");
        i.f64628a.p("minitv_play", hashMap);
    }

    private final void C() {
        this.f53119h.d().q(null);
        this.f53119h.e().q(null);
        this.f53114c.K.reset();
        a.C0856a.g(lg.a.f68962a, this.f53118g + " --> reset() --> 重置资源", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(boolean z10) {
    }

    private final void E() {
        this.f53114c.K.turnOff(false);
        FrameLayout flSubtitle = this.f53114c.f69964f;
        Intrinsics.g(flSubtitle, "flSubtitle");
        yr.b.e(flSubtitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ShortTVSubtitleControlImp shortTVSubtitleControlImp, ts.b bVar) {
        if (bVar == null) {
            return Unit.f67184a;
        }
        if (bVar.c()) {
            fs.b.f62582a.d(R$string.short_tv_subtitle_turn_off_toast);
        }
        shortTVSubtitleControlImp.A(!bVar.c());
        if (!bVar.c()) {
            shortTVSubtitleControlImp.h(bVar);
        }
        return Unit.f67184a;
    }

    private final void x() {
        this.f53114c.K.turnOff(true);
        FrameLayout flSubtitle = this.f53114c.f69964f;
        Intrinsics.g(flSubtitle, "flSubtitle");
        yr.b.b(flSubtitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021c A[LOOP:1: B:51:0x0216->B:53:0x021c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.util.List r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 757
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.subtitle.ShortTVSubtitleControlImp.y(java.util.List, java.lang.String):void");
    }

    private final void z(SimpleSubtitleView simpleSubtitleView) {
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgColor(Utils.a().getResources().getColor(R$color.short_tv_black_80));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.setBgdRadius(yr.a.a(8));
        }
        if (simpleSubtitleView != null) {
            simpleSubtitleView.initSubtitle(new a(), false);
            return;
        }
        a.C0856a.g(lg.a.f68962a, this.f53118g + " --> vdSubtitle --> initSubtitle() --> null", false, 2, null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void a(Function1 function1) {
        this.f53120i = function1;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void b(Function1 function1) {
        this.f53121j = function1;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void c(boolean z10) {
        this.f53122k = z10;
        if (z10) {
            this.f53114c.K.resume();
        } else {
            this.f53114c.K.pause();
        }
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void d(long j11) {
        this.f53123l = j11;
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void e() {
        k.d(v.a(this.f53113b), null, null, new ShortTVSubtitleControlImp$checkSubtitle$1(this, null), 3, null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void f() {
        x();
        List list = (List) this.f53119h.d().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ts.b) it.next()).f(false);
            }
        }
        this.f53119h.f().q(Boolean.TRUE);
        h.f53707a.d().putString("k_subtitle_language", "off");
        com.transsion.subtitle_download.utils.d.f55168a.b().putString("k_subtitle_select_lan", "off");
        if (lr.a.f69143a.c()) {
            return;
        }
        fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_subtitles_off));
    }

    @Override // vs.a
    public void g(boolean z10) {
        a.C0856a.g(lg.a.f68962a, this.f53118g + " --> checkResult --> " + z10, false, 2, null);
        Function1 function1 = this.f53120i;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void h(ts.b bVar) {
        SubtitleDownloadTable a11;
        SubtitleDownloadTable a12;
        Long delay;
        SubtitleDownloadTable a13;
        SubtitleDownloadTable a14;
        SubtitleDownloadTable a15;
        SubtitleDownloadTable a16;
        String path;
        SubtitleDownloadTable a17;
        List<ts.b> list = (List) this.f53119h.d().f();
        if (list != null) {
            for (ts.b bVar2 : list) {
                bVar2.f(Intrinsics.c(bVar2.a().getId(), (bVar == null || (a17 = bVar.a()) == null) ? null : a17.getId()));
            }
        }
        Function1 function1 = this.f53121j;
        if (function1 != null) {
            function1.invoke(bVar);
        }
        if (bVar != null && (a16 = bVar.a()) != null && (path = a16.getPath()) != null) {
            E();
            this.f53114c.K.selectSubtitle(path, us.a.b(bVar), new i5.b() { // from class: com.transsion.shorttv.subtitle.c
                @Override // i5.b
                public final void a(boolean z10) {
                    ShortTVSubtitleControlImp.D(z10);
                }
            });
        }
        lg.a.f68962a.c("short_tv_subtitle", "selectSubtitle delayDuration:" + ((bVar == null || (a15 = bVar.a()) == null) ? null : a15.getDelay()) + ", name:" + ((bVar == null || (a14 = bVar.a()) == null) ? null : a14.getLanName()) + ", isAutoDownload:" + ((bVar == null || (a13 = bVar.a()) == null) ? null : Boolean.valueOf(a13.getIsAutoDownload())), true);
        if (bVar != null && (a12 = bVar.a()) != null && (delay = a12.getDelay()) != null) {
            this.f53114c.K.subtitleDelay(delay.longValue());
        }
        if (bVar != null && (a11 = bVar.a()) != null) {
            if (!a11.getIsAutoDownload()) {
                h.f53707a.d().putString("k_subtitle_language", a11.getLanName());
                com.transsion.subtitle_download.utils.d.f55168a.b().putString("k_subtitle_select_lan", a11.getLan());
            }
            if (!lr.a.f69143a.c()) {
                fs.b.f62582a.e(Utils.a().getString(R$string.short_tv_subtitle_enable_toast, a11.getName()));
            }
        }
        if (bVar != null) {
            B(bVar);
        }
        k.d(v.a(this.f53113b), null, null, new ShortTVSubtitleControlImp$selectSubtitle$6(bVar, this, null), 3, null);
    }

    @Override // com.transsion.shorttv.subtitle.a
    public void onDestroy() {
        C();
        FrameLayout flSubtitle = this.f53114c.f69964f;
        Intrinsics.g(flSubtitle, "flSubtitle");
        yr.b.b(flSubtitle);
        this.f53114c.K.stop();
        this.f53114c.K.destroy();
        b.a aVar = com.transsion.shorttv.subtitle.manager.b.f53144a;
        aVar.b().f(this);
        aVar.b().c(this.f53125n);
        a.C0856a.g(lg.a.f68962a, this.f53118g + " --> onDestroy()", false, 2, null);
    }
}
