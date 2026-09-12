package com.transsion.videofloat.manager;

import android.app.Application;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class VideoFloatSubtitleControl {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleSubtitleView f58021a;

    /* renamed from: b, reason: collision with root package name */
    private final px.a f58022b;

    /* renamed from: c, reason: collision with root package name */
    private final String f58023c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f58024d;

    /* renamed from: e, reason: collision with root package name */
    private long f58025e;

    /* renamed from: f, reason: collision with root package name */
    private float f58026f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f58027g;

    /* renamed from: h, reason: collision with root package name */
    private final Lazy f58028h;

    /* loaded from: classes7.dex */
    public static final class a implements i5.a {
        a() {
        }

        @Override // i5.a
        public long getCurrentPosition() {
            return VideoFloatSubtitleControl.this.k();
        }

        @Override // i5.a
        public Float getSpeed() {
            return Float.valueOf(VideoFloatSubtitleControl.this.m());
        }

        @Override // i5.a
        public boolean isPlaying() {
            return VideoFloatSubtitleControl.this.p();
        }
    }

    public VideoFloatSubtitleControl(SimpleSubtitleView subtitleView, px.a floatBean) {
        Intrinsics.h(subtitleView, "subtitleView");
        Intrinsics.h(floatBean, "floatBean");
        this.f58021a = subtitleView;
        this.f58022b = floatBean;
        this.f58023c = "VideoFloatSubtitle";
        this.f58024d = true;
        this.f58026f = 1.0f;
        this.f58027g = LazyKt.b(new Function0() { // from class: com.transsion.videofloat.manager.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailPlayDao x10;
                x10 = VideoFloatSubtitleControl.x();
                return x10;
            }
        });
        this.f58028h = LazyKt.b(new Function0() { // from class: com.transsion.videofloat.manager.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                lj.c i11;
                i11 = VideoFloatSubtitleControl.i();
                return i11;
            }
        });
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lj.c i() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).p1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final lj.c j() {
        return (lj.c) this.f58028h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoDetailPlayDao l() {
        return (VideoDetailPlayDao) this.f58027g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, List list) {
        SubtitleDownloadTable b11;
        SubtitleDownloadTable b12;
        SubtitleDownloadTable b13;
        Long delay;
        SubtitleDownloadTable b14;
        String path;
        Locale a11 = com.transsion.subtitle.helper.e.a();
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.u(this.f58023c, "------------------cur  language = " + a11.getLanguage() + "， country = " + a11.getCountry(), true);
        String str2 = "";
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("k_subtitle_language", "");
        a.C0856a.f(c0856a, this.f58023c, "initDefaultSubtitle savedDiffId = " + str + "， savedLan = " + string, false, 4, null);
        Iterator it = list.iterator();
        String str3 = null;
        eu.a aVar = null;
        eu.a aVar2 = null;
        while (it.hasNext()) {
            eu.a aVar3 = (eu.a) it.next();
            if (aVar3.d()) {
                if (Intrinsics.c(aVar3.b().getLan(), "en")) {
                    aVar = aVar3;
                }
                if ((str == null || str.length() == 0) && Intrinsics.c(aVar3.b().getLanAbbr(), a11.getLanguage())) {
                    str2 = aVar3.b().getId();
                    lg.a.f68962a.c(this.f58023c, "111 phone set def language = " + str2, true);
                } else if (Intrinsics.c(aVar3.b().getId(), str)) {
                    str2 = aVar3.b().getId();
                    lg.a.f68962a.c(this.f58023c, "222 saved flag = " + str2, true);
                } else if (str == null || str.length() == 0) {
                    if (Intrinsics.c(aVar3.b().getLanName(), string)) {
                        str2 = aVar3.b().getId();
                        lg.a.f68962a.c(this.f58023c, "555 local set savedLan = " + string, true);
                    }
                }
                aVar2 = aVar3;
            }
        }
        if (str2.length() == 0) {
            if (aVar != null && aVar.d()) {
                str2 = aVar.b().getId();
                lg.a.f68962a.c(this.f58023c, "333 english set def language = " + str2, true);
            } else if (!list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        aVar = aVar2;
                        break;
                    }
                    eu.a aVar4 = (eu.a) it2.next();
                    if (aVar4.d()) {
                        str2 = aVar4.b().getId();
                        aVar = aVar4;
                        break;
                    }
                }
                if (str2.length() == 0) {
                    lg.a.f68962a.c(this.f58023c, "没有对应的语言，不设置，需要用户手动设置或当前下载后自动设置上", true);
                    return;
                }
            }
            if (aVar != null && (b14 = aVar.b()) != null && (path = b14.getPath()) != null) {
                this.f58021a.setDefaultSubtitle(path);
            }
            if (aVar != null && (b13 = aVar.b()) != null && (delay = b13.getDelay()) != null) {
                long longValue = delay.longValue();
                lg.a.f68962a.c(this.f58023c, "default delayDuration = " + longValue, true);
                this.f58021a.subtitleDelay(longValue);
            }
            a.C0856a c0856a2 = lg.a.f68962a;
            String str4 = this.f58023c;
            String name = (aVar != null || (b12 = aVar.b()) == null) ? null : b12.getName();
            if (aVar != null && (b11 = aVar.b()) != null) {
                str3 = b11.getPath();
            }
            c0856a2.c(str4, "default select subtitle defDiffId = " + str2 + ", name= " + name + "，path:" + str3, true);
        }
        aVar = aVar2;
        if (aVar != null) {
            this.f58021a.setDefaultSubtitle(path);
        }
        if (aVar != null) {
            long longValue2 = delay.longValue();
            lg.a.f68962a.c(this.f58023c, "default delayDuration = " + longValue2, true);
            this.f58021a.subtitleDelay(longValue2);
        }
        a.C0856a c0856a22 = lg.a.f68962a;
        String str42 = this.f58023c;
        if (aVar != null) {
        }
        if (aVar != null) {
            str3 = b11.getPath();
        }
        c0856a22.c(str42, "default select subtitle defDiffId = " + str2 + ", name= " + name + "，path:" + str3, true);
    }

    private final void o() {
        if (this.f58022b.x()) {
            this.f58021a.initSubtitle(new a(), false);
            kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new VideoFloatSubtitleControl$initSubtitle$2(this, null), 3, null);
            return;
        }
        lg.a.f68962a.c(this.f58023c, "float subtitle----intercept， " + this.f58022b.i(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List list) {
        String path;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            eu.a aVar = (eu.a) it.next();
            if (aVar.d() && (path = aVar.b().getPath()) != null) {
                this.f58021a.setSubtitlePath(path, com.transsion.subtitle.helper.e.b(aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoDetailPlayDao x() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    public final long k() {
        return this.f58025e;
    }

    public final float m() {
        return this.f58026f;
    }

    public final boolean p() {
        return this.f58024d;
    }

    public final void q() {
        if (this.f58022b.x()) {
            this.f58021a.pause();
        }
    }

    public final void r() {
        if (this.f58022b.x()) {
            this.f58021a.stop();
            this.f58021a.destroy();
        }
    }

    public final void s() {
        if (this.f58022b.x()) {
            this.f58021a.resume();
        }
    }

    public final void u(long j11) {
        this.f58025e = j11;
    }

    public final void v(boolean z10) {
        this.f58024d = z10;
    }

    public final void w(float f11) {
        this.f58026f = f11;
    }
}
