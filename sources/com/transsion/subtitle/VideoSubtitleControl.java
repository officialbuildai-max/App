package com.transsion.subtitle;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.subtitle.dialog.SubtitleMainDialog2;
import com.transsion.subtitle.h;
import com.transsion.subtitle.helper.LocalVideoUiType;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import hu.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class VideoSubtitleControl {
    private final Lazy A;
    private Map B;
    private final b C;
    private final VideoSubtitleControl$downloadListener$1 D;
    private long E;
    private final Set F;
    private boolean G;
    private String H;
    private final c I;

    /* renamed from: a */
    private final FragmentActivity f54824a;

    /* renamed from: b */
    private final String f54825b;

    /* renamed from: c */
    private float f54826c;

    /* renamed from: d */
    private List f54827d;

    /* renamed from: e */
    private final Function1 f54828e;

    /* renamed from: f */
    private final Function2 f54829f;

    /* renamed from: g */
    private final Function3 f54830g;

    /* renamed from: h */
    private final Function1 f54831h;

    /* renamed from: i */
    private final Function1 f54832i;

    /* renamed from: j */
    private final Function1 f54833j;

    /* renamed from: k */
    private final Function2 f54834k;

    /* renamed from: l */
    private List f54835l;

    /* renamed from: m */
    private boolean f54836m;

    /* renamed from: n */
    private long f54837n;

    /* renamed from: o */
    private boolean f54838o;

    /* renamed from: p */
    private DownloadBean f54839p;

    /* renamed from: q */
    private com.transsion.subtitle.helper.f f54840q;

    /* renamed from: r */
    private LocalVideoUiType f54841r;

    /* renamed from: s */
    private final n0 f54842s;

    /* renamed from: t */
    private Map f54843t;

    /* renamed from: u */
    private ViewGroup f54844u;

    /* renamed from: v */
    private final Map f54845v;

    /* renamed from: w */
    private final Map f54846w;

    /* renamed from: x */
    private Function1 f54847x;

    /* renamed from: y */
    private Map f54848y;

    /* renamed from: z */
    private Map f54849z;

    /* loaded from: classes6.dex */
    public static final class a implements i5.a {
        a() {
        }

        @Override // i5.a
        public long getCurrentPosition() {
            return VideoSubtitleControl.this.f54837n;
        }

        @Override // i5.a
        public Float getSpeed() {
            return Float.valueOf(VideoSubtitleControl.this.f54826c);
        }

        @Override // i5.a
        public boolean isPlaying() {
            return VideoSubtitleControl.this.L();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements hu.c {
        b() {
        }

        @Override // hu.c
        public void J(boolean z10, DownloadBean bean) {
            Intrinsics.h(bean, "bean");
            String resourceId = bean.getResourceId();
            DownloadBean downloadBean = VideoSubtitleControl.this.f54839p;
            if (Intrinsics.c(resourceId, downloadBean != null ? downloadBean.getResourceId() : null) && z10 && VideoSubtitleControl.this.f54835l.isEmpty()) {
                com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> -------- 检测到有字幕但是在下载中");
            }
        }

        @Override // hu.c
        public void g(eu.a aVar) {
            c.a.b(this, aVar);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements hu.b {
        c() {
        }

        @Override // hu.b
        public SimpleSubtitleView a() {
            return (SimpleSubtitleView) VideoSubtitleControl.this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
        }

        @Override // hu.b
        public void b(boolean z10) {
            VideoSubtitleControl.this.Q(z10);
            VideoSubtitleControl.this.X(null, z10);
        }

        @Override // hu.b
        public void c(String msg) {
            Intrinsics.h(msg, "msg");
            Function1 function1 = VideoSubtitleControl.this.f54833j;
            if (function1 != null) {
                function1.invoke(msg);
            }
        }

        @Override // hu.b
        public void d(eu.a aVar, long j11) {
            if (aVar != null) {
                VideoSubtitleControl.this.Y(aVar);
            }
            String a11 = aVar != null ? aVar.a() : null;
            if (a11 != null) {
                int hashCode = a11.hashCode();
                if (hashCode != 0) {
                    if (hashCode != 50770) {
                        if (hashCode == 51560 && a11.equals("2nd")) {
                            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) VideoSubtitleControl.this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
                            if (simpleSubtitleView != null) {
                                simpleSubtitleView.subtitleDelay(j11);
                                return;
                            }
                            return;
                        }
                    } else if (a11.equals("1st")) {
                        SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) VideoSubtitleControl.this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
                        if (simpleSubtitleView2 != null) {
                            simpleSubtitleView2.subtitleDelay(j11);
                            return;
                        }
                        return;
                    }
                } else if (a11.equals("")) {
                    SimpleSubtitleView simpleSubtitleView3 = (SimpleSubtitleView) VideoSubtitleControl.this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
                    if (simpleSubtitleView3 != null) {
                        simpleSubtitleView3.subtitleDelay(j11);
                        return;
                    }
                    return;
                }
            }
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> onSubtitleDelay() --> 异常");
        }

        @Override // hu.b
        public SimpleSubtitleView e() {
            return (SimpleSubtitleView) VideoSubtitleControl.this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
        }

        @Override // hu.b
        public void f(boolean z10) {
            VideoSubtitleControl.this.G = z10;
            VideoSubtitleControl.this.V(z10);
        }

        @Override // hu.b
        public boolean g() {
            return VideoSubtitleControl.this.G;
        }

        @Override // hu.b
        public ViewGroup getSubtitleViewGroup() {
            return VideoSubtitleControl.this.f54844u;
        }

        @Override // hu.b
        public void h(DubsInfo info) {
            Intrinsics.h(info, "info");
            VideoSubtitleControl.this.f54831h.invoke(info);
        }

        @Override // hu.b
        public com.transsion.subtitle.helper.f i() {
            return VideoSubtitleControl.this.f54840q;
        }

        @Override // hu.b
        public List j() {
            return VideoSubtitleControl.this.f54835l;
        }

        @Override // hu.b
        public void k(eu.a aVar, eu.a aVar2, boolean z10, eu.a aVar3) {
            String str;
            SubtitleDownloadTable b11;
            SubtitleDownloadTable b12;
            SubtitleDownloadTable b13;
            SubtitleDownloadTable b14;
            String lan;
            SubtitleDownloadTable b15;
            SubtitleDownloadTable b16;
            SubtitleDownloadTable b17;
            SubtitleDownloadTable b18;
            VideoSubtitleControl.this.G = z10;
            String str2 = null;
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.this.getClass().getSimpleName() + " --> onSubtitleSelect() --> isOpenBilingual = " + z10 + " --> top = " + ((aVar == null || (b18 = aVar.b()) == null) ? null : b18.getName()) + " --> bottom = " + ((aVar2 == null || (b17 = aVar2.b()) == null) ? null : b17.getName()) + " --> selected = " + ((aVar3 == null || (b16 = aVar3.b()) == null) ? null : b16.getName()));
            Function3 function3 = VideoSubtitleControl.this.f54830g;
            String str3 = "";
            if (aVar == null || (b15 = aVar.b()) == null || (str = b15.getLanName()) == null) {
                str = "";
            }
            if (aVar != null && (b14 = aVar.b()) != null && (lan = b14.getLan()) != null) {
                str3 = lan;
            }
            function3.invoke(str, str3, Integer.valueOf((aVar == null || (b13 = aVar.b()) == null) ? 1 : b13.getType()));
            Function2 function2 = VideoSubtitleControl.this.f54834k;
            String lan2 = (aVar == null || (b12 = aVar.b()) == null) ? null : b12.getLan();
            if (aVar2 != null && (b11 = aVar2.b()) != null) {
                str2 = b11.getLan();
            }
            function2.invoke(lan2, str2);
            VideoSubtitleControl videoSubtitleControl = VideoSubtitleControl.this;
            videoSubtitleControl.f0(aVar, (SimpleSubtitleView) videoSubtitleControl.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), true);
            VideoSubtitleControl videoSubtitleControl2 = VideoSubtitleControl.this;
            videoSubtitleControl2.f0(aVar2, (SimpleSubtitleView) videoSubtitleControl2.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT), false);
            VideoSubtitleControl.this.F.clear();
            if (aVar != null) {
                VideoSubtitleControl.this.F.add(aVar);
            }
            if (aVar2 != null) {
                VideoSubtitleControl.this.F.add(aVar2);
            }
            VideoSubtitleControl.this.W(aVar3);
        }

        @Override // hu.b
        public boolean l() {
            int i11 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("subtitle_options_position", 10);
            com.transsion.subtitle.helper.f fVar = VideoSubtitleControl.this.f54840q;
            if (fVar != null) {
                fVar.j(VideoSubtitleControl.this.f54841r, VideoSubtitleControl.this.f54844u, i11);
            }
            return !Intrinsics.c(VideoSubtitleControl.this.H, BucketVersioningConfiguration.OFF);
        }
    }

    public VideoSubtitleControl(FragmentActivity activity, String str, float f11, List dubs, Function1 loadingCallback, Function2 controlCallback, Function3 subtitleSelected, Function1 audioSelected, Function1 setSublistData, Function1 function1, Function2 subtitleSelectedBilingual) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(dubs, "dubs");
        Intrinsics.h(loadingCallback, "loadingCallback");
        Intrinsics.h(controlCallback, "controlCallback");
        Intrinsics.h(subtitleSelected, "subtitleSelected");
        Intrinsics.h(audioSelected, "audioSelected");
        Intrinsics.h(setSublistData, "setSublistData");
        Intrinsics.h(subtitleSelectedBilingual, "subtitleSelectedBilingual");
        this.f54824a = activity;
        this.f54825b = str;
        this.f54826c = f11;
        this.f54827d = dubs;
        this.f54828e = loadingCallback;
        this.f54829f = controlCallback;
        this.f54830g = subtitleSelected;
        this.f54831h = audioSelected;
        this.f54832i = setSublistData;
        this.f54833j = function1;
        this.f54834k = subtitleSelectedBilingual;
        this.f54835l = new ArrayList();
        this.f54841r = LocalVideoUiType.MIDDLE;
        this.f54842s = o0.a(y0.c());
        this.f54843t = new LinkedHashMap();
        this.f54845v = new LinkedHashMap();
        this.f54846w = new LinkedHashMap();
        this.f54848y = new LinkedHashMap();
        this.f54849z = new LinkedHashMap();
        this.A = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoDetailPlayDao u02;
                u02 = VideoSubtitleControl.u0();
                return u02;
            }
        });
        this.B = new LinkedHashMap();
        b bVar = new b();
        this.C = bVar;
        VideoSubtitleControl$downloadListener$1 videoSubtitleControl$downloadListener$1 = new VideoSubtitleControl$downloadListener$1(this);
        this.D = videoSubtitleControl$downloadListener$1;
        this.f54840q = new com.transsion.subtitle.helper.f(activity);
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> init{} --> VideoSubtitleControl --> 创建了");
        h.a aVar = h.f55010a;
        aVar.b().b(videoSubtitleControl$downloadListener$1);
        aVar.b().d(bVar);
        this.F = new LinkedHashSet();
        this.H = "";
        this.I = new c();
    }

    public /* synthetic */ VideoSubtitleControl(FragmentActivity fragmentActivity, String str, float f11, List list, Function1 function1, Function2 function2, Function3 function3, Function1 function12, Function1 function13, Function1 function14, Function2 function22, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, str, f11, (i11 & 8) != 0 ? CollectionsKt.l() : list, function1, function2, function3, function12, function13, (i11 & 512) != 0 ? null : function14, function22);
    }

    public final VideoDetailPlayDao H() {
        return (VideoDetailPlayDao) this.A.getValue();
    }

    private final void I() {
        for (Map.Entry entry : this.f54843t.entrySet()) {
            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView != null) {
                simpleSubtitleView.turnOff(true);
            }
            SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void J() {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.VideoSubtitleControl.J():void");
    }

    private final void K(SimpleSubtitleView simpleSubtitleView) {
        if (simpleSubtitleView != null) {
            simpleSubtitleView.initSubtitle(new a(), false);
            return;
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> vdSubtitle --> initSubtitle() --> null");
    }

    private final boolean M() {
        Iterator it = this.f54835l.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            if (!((eu.a) it.next()).b().isInner()) {
                i11++;
            }
        }
        return i11 > 1;
    }

    public final void Q(boolean z10) {
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> onSubtitleSwitchClick() --> turnOn = " + z10 + " --> 字幕开关状态变化");
        if (z10) {
            this.H = "";
            n0();
        } else {
            this.H = BucketVersioningConfiguration.OFF;
            I();
        }
        if (!z10) {
            this.f54830g.invoke(BucketVersioningConfiguration.OFF, BucketVersioningConfiguration.OFF, 0);
        } else if (!this.F.isEmpty()) {
            eu.a aVar = (eu.a) CollectionsKt.h0(this.F);
            Function3 function3 = this.f54830g;
            String lanName = aVar.b().getLanName();
            if (lanName == null) {
                lanName = "";
            }
            String lan = aVar.b().getLan();
            function3.invoke(lanName, lan != null ? lan : "", Integer.valueOf(aVar.b().getType()));
        }
        if (z10 && M()) {
            o0();
        }
    }

    public final void V(boolean z10) {
        String str = this.f54825b;
        if (str == null || str.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("bilingual", String.valueOf(z10));
        hj.i.f64628a.p(this.f54825b, linkedHashMap);
    }

    public final void W(eu.a aVar) {
        String str;
        String str2;
        String str3 = this.f54825b;
        if (str3 == null || str3.length() == 0 || aVar == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f54839p;
        if (downloadBean == null || (str = downloadBean.getSubjectId()) == null) {
            str = "";
        }
        linkedHashMap.put("subject_id", str);
        DownloadBean downloadBean2 = this.f54839p;
        if (downloadBean2 == null || (str2 = downloadBean2.getResourceId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("resource_id", str2);
        if (aVar.b().getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(aVar.b().getEp()));
        }
        if (aVar.b().getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(aVar.b().getSe()));
        }
        String lan = aVar.b().getLan();
        if (lan == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        String lanName = aVar.b().getLanName();
        linkedHashMap.put("lan_name", lanName != null ? lanName : "");
        linkedHashMap.put("id", aVar.b().getId());
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(aVar.b().getType()));
        linkedHashMap.put("switch_type", "subtitle_select");
        hj.i.f64628a.s(this.f54825b, "subtitle_switch", linkedHashMap);
    }

    public final void X(eu.a aVar, boolean z10) {
        String str;
        String str2;
        String str3;
        String str4;
        SubtitleDownloadTable b11;
        SubtitleDownloadTable b12;
        String id2;
        SubtitleDownloadTable b13;
        SubtitleDownloadTable b14;
        SubtitleDownloadTable b15;
        SubtitleDownloadTable b16;
        SubtitleDownloadTable b17;
        SubtitleDownloadTable b18;
        String str5 = this.f54825b;
        if (str5 == null || str5.length() == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f54839p;
        String str6 = "";
        if (downloadBean == null || (str = downloadBean.getSubjectId()) == null) {
            str = "";
        }
        linkedHashMap.put("subject_id", str);
        DownloadBean downloadBean2 = this.f54839p;
        if (downloadBean2 == null || (str2 = downloadBean2.getResourceId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("resource_id", str2);
        int i11 = 0;
        Integer num = null;
        if (((aVar == null || (b18 = aVar.b()) == null) ? 0 : b18.getEp()) > 0) {
            linkedHashMap.put("ep", String.valueOf((aVar == null || (b17 = aVar.b()) == null) ? null : Integer.valueOf(b17.getEp())));
        }
        if (aVar != null && (b16 = aVar.b()) != null) {
            i11 = b16.getSe();
        }
        if (i11 > 0) {
            linkedHashMap.put("se", String.valueOf((aVar == null || (b15 = aVar.b()) == null) ? null : Integer.valueOf(b15.getSe())));
        }
        if (aVar == null || (b14 = aVar.b()) == null || (str3 = b14.getLan()) == null) {
            str3 = "";
        }
        linkedHashMap.put("lan", str3);
        if (aVar == null || (b13 = aVar.b()) == null || (str4 = b13.getLanName()) == null) {
            str4 = "";
        }
        linkedHashMap.put("lan_name", str4);
        if (aVar != null && (b12 = aVar.b()) != null && (id2 = b12.getId()) != null) {
            str6 = id2;
        }
        linkedHashMap.put("id", str6);
        if (aVar != null && (b11 = aVar.b()) != null) {
            num = Integer.valueOf(b11.getType());
        }
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(num));
        linkedHashMap.put("result", z10 ? "1" : "0");
        hj.i.f64628a.s(this.f54825b, "subtitle_switch", linkedHashMap);
    }

    public final void Y(eu.a aVar) {
        String str;
        String str2;
        String str3;
        if (this.B.containsKey(aVar.b().getId()) || (str = this.f54825b) == null || str.length() == 0) {
            return;
        }
        this.B.put(aVar.b().getId(), "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean downloadBean = this.f54839p;
        if (downloadBean == null || (str2 = downloadBean.getSubjectId()) == null) {
            str2 = "";
        }
        linkedHashMap.put("subject_id", str2);
        DownloadBean downloadBean2 = this.f54839p;
        if (downloadBean2 == null || (str3 = downloadBean2.getResourceId()) == null) {
            str3 = "";
        }
        linkedHashMap.put("resource_id", str3);
        if (aVar.b().getEp() > 0) {
            linkedHashMap.put("ep", String.valueOf(aVar.b().getEp()));
        }
        if (aVar.b().getSe() > 0) {
            linkedHashMap.put("se", String.valueOf(aVar.b().getSe()));
        }
        String lan = aVar.b().getLan();
        if (lan == null) {
            lan = "";
        }
        linkedHashMap.put("lan", lan);
        String lanName = aVar.b().getLanName();
        linkedHashMap.put("lan_name", lanName != null ? lanName : "");
        linkedHashMap.put("id", aVar.b().getId());
        linkedHashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, String.valueOf(aVar.b().getType()));
        hj.i.f64628a.s(this.f54825b, "subtitle_sync", linkedHashMap);
    }

    public final void a0(eu.a aVar) {
        SubtitleDownloadTable b11;
        SubtitleDownloadTable b12;
        SubtitleDownloadTable b13;
        SubtitleDownloadTable b14;
        if (aVar != null && (b14 = aVar.b()) != null && b14.isInner()) {
            com.transsion.baselib.report.launch.b.f43424a.b().putString("k_subtitle_language", aVar.b().getLanName());
        }
        com.transsion.subtitle.a aVar2 = com.transsion.subtitle.a.f54861a;
        String simpleName = VideoSubtitleControl.class.getSimpleName();
        DownloadBean downloadBean = this.f54839p;
        aVar2.a(simpleName + " --> saveSelectedFlag() --> saveSelectId = " + (downloadBean != null ? downloadBean.getSubjectId() : null) + " -- id = " + ((aVar == null || (b13 = aVar.b()) == null) ? null : b13.getId()));
        DownloadBean downloadBean2 = this.f54839p;
        if (downloadBean2 != null) {
            downloadBean2.setSubtitleSelectId((aVar == null || (b12 = aVar.b()) == null) ? null : b12.getId());
        }
        Function1 function1 = this.f54847x;
        if (function1 != null) {
            function1.invoke((aVar == null || (b11 = aVar.b()) == null) ? null : b11.getId());
        }
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new VideoSubtitleControl$saveSelectedFlag$1(this, aVar, null), 3, null);
    }

    public static final void c0(VideoSubtitleControl videoSubtitleControl, View view) {
        Iterator it = videoSubtitleControl.f54849z.entrySet().iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) ((Map.Entry) it.next()).getValue();
            Intrinsics.e(view);
            function1.invoke(view);
        }
        videoSubtitleControl.o0();
    }

    public final void f0(final eu.a aVar, final SimpleSubtitleView simpleSubtitleView, final boolean z10) {
        String str;
        SubtitleDownloadTable b11;
        if (aVar == null || (b11 = aVar.b()) == null || (str = b11.getId()) == null) {
            str = "";
        }
        this.H = str;
        if (aVar == null) {
            if (simpleSubtitleView != null) {
                simpleSubtitleView.turnOff(true);
                simpleSubtitleView.setVisibility(8);
            }
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> " + (z10 ? "topBean" : "bottomBean") + " == null --> isTop = " + z10 + " --> view.hashCode = " + (simpleSubtitleView != null ? simpleSubtitleView.hashCode() : 0));
            return;
        }
        if (simpleSubtitleView == null) {
            com.transsion.subtitle.a.f54861a.b(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> subtitleView ==null --> isTop = " + z10);
            return;
        }
        simpleSubtitleView.setVisibility(0);
        String path = aVar.b().getPath();
        if (path == null) {
            path = "";
        }
        simpleSubtitleView.setSubtitlePath(path, com.transsion.subtitle.helper.e.b(aVar));
        String path2 = aVar.b().getPath();
        simpleSubtitleView.selectSubtitle(path2 != null ? path2 : "", com.transsion.subtitle.helper.e.b(aVar), new i5.b() { // from class: com.transsion.subtitle.e
            @Override // i5.b
            public final void a(boolean z11) {
                VideoSubtitleControl.g0(VideoSubtitleControl.this, simpleSubtitleView, aVar, z10, simpleSubtitleView, z11);
            }
        });
        Function1 function1 = this.f54847x;
        if (function1 != null) {
            function1.invoke(aVar.b().getId());
        }
    }

    public static final void g0(VideoSubtitleControl videoSubtitleControl, SimpleSubtitleView simpleSubtitleView, eu.a aVar, boolean z10, SimpleSubtitleView simpleSubtitleView2, boolean z11) {
        videoSubtitleControl.f54828e.invoke(Boolean.FALSE);
        simpleSubtitleView.turnOff(false);
        simpleSubtitleView.refreshImmediately();
        h.f55010a.b().g(aVar);
        Long delay = aVar.b().getDelay();
        if (delay != null) {
            simpleSubtitleView.subtitleDelay(delay.longValue());
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitle() --> refreshImmediately() --> 展示字幕 --> bean.dbBean.name = " + aVar.b().getName() + " --> isTop = " + z10 + "  --> view.hashCode = " + simpleSubtitleView2.hashCode() + " -- path = " + aVar.b().getPath());
    }

    public static /* synthetic */ void m0(VideoSubtitleControl videoSubtitleControl, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        videoSubtitleControl.l0(z10, z11);
    }

    private final void n0() {
        int i11 = 0;
        for (Object obj : this.F) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            eu.a aVar = (eu.a) obj;
            if (i11 == 0) {
                f0(aVar, (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), true);
            } else if (i11 == 1) {
                f0(aVar, (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT), false);
            }
            i11 = i12;
        }
    }

    private final void o0() {
        if (this.f54835l.isEmpty()) {
            l0(false, true);
            return;
        }
        FragmentActivity fragmentActivity = this.f54824a;
        SubtitleMainDialog2.Companion companion = SubtitleMainDialog2.INSTANCE;
        boolean z10 = this.f54841r == LocalVideoUiType.LAND;
        boolean c11 = Intrinsics.c(this.H, BucketVersioningConfiguration.OFF);
        List list = this.f54835l;
        List list2 = this.f54827d;
        DownloadBean downloadBean = this.f54839p;
        LocalVideoUiType localVideoUiType = this.f54841r;
        com.transsion.subtitle.helper.f fVar = this.f54840q;
        SubtitleMainDialog2 b11 = companion.b(z10, c11, list, list2, downloadBean, localVideoUiType, Integer.valueOf(fVar != null ? fVar.h(localVideoUiType) : y.c()), this.f54825b);
        b11.F0(this.I);
        b11.J0(new Function1() { // from class: com.transsion.subtitle.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p02;
                p02 = VideoSubtitleControl.p0(VideoSubtitleControl.this, (eu.a) obj);
                return p02;
            }
        });
        b11.k0(fragmentActivity, "fragment_subtitle_main_dialog");
    }

    public static final Unit p0(VideoSubtitleControl videoSubtitleControl, eu.a bean) {
        Intrinsics.h(bean, "bean");
        videoSubtitleControl.q0(bean);
        return Unit.f67184a;
    }

    private final void q0(eu.a aVar) {
        String string;
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 搜索字幕选中 --> 直接设置使用 --> isOpenBilingual = " + this.G);
        String str = "";
        if (this.G) {
            for (eu.a aVar2 : this.f54835l) {
                if (aVar2.f() && TextUtils.equals(aVar2.a(), "1st")) {
                    aVar2.l(false);
                    aVar2.g("");
                    com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 这里默认替换 1st --> it.isSelect = false");
                }
            }
            for (eu.a aVar3 : this.f54835l) {
                if (Intrinsics.c(aVar3.b().getId(), aVar.b().getId())) {
                    aVar3.l(true);
                    aVar3.g("1st");
                    com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 这里默认替换 1st --> it.isSelect = true");
                }
            }
        } else {
            for (eu.a aVar4 : this.f54835l) {
                if (aVar4.f()) {
                    aVar4.l(false);
                }
            }
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 能从搜索选中回调，一定在字幕列表里面了");
            for (eu.a aVar5 : this.f54835l) {
                if (Intrinsics.c(aVar.b().getId(), aVar5.b().getId())) {
                    aVar5.l(true);
                }
            }
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 找到ID相同的哪个设置 选中");
        }
        f0(aVar, (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), true);
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> subtitleSelectFromSearch() --> 设置字幕 --> bean.id = " + aVar.b().getId());
        Function1 function1 = this.f54833j;
        if (function1 != null) {
            Application a11 = Utils.a();
            if (a11 != null && (string = a11.getString(R$string.subtitle_switch_toast)) != null) {
                str = string;
            }
            function1.invoke(str);
        }
    }

    public static final VideoDetailPlayDao u0() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).D1();
    }

    public final void F(LocalVideoUiType uitType, Function2 switchCallback, Function1 settingCallback) {
        Intrinsics.h(uitType, "uitType");
        Intrinsics.h(switchCallback, "switchCallback");
        Intrinsics.h(settingCallback, "settingCallback");
        this.f54848y.put(uitType, switchCallback);
        this.f54849z.put(uitType, settingCallback);
    }

    public final Map G() {
        return new LinkedHashMap();
    }

    public final boolean L() {
        return this.f54838o;
    }

    public final void N() {
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> onDestroy()");
        for (Map.Entry entry : this.f54843t.entrySet()) {
            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView != null) {
                simpleSubtitleView.stop();
            }
            SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView2 != null) {
                simpleSubtitleView2.destroy();
            }
        }
        if (this.f54836m) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Iterator it = this.f54845v.entrySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) ((Map.Entry) it.next()).getValue()).entrySet().iterator();
                    while (it2.hasNext()) {
                        SimpleSubtitleView simpleSubtitleView3 = (SimpleSubtitleView) ((Map.Entry) it2.next()).getValue();
                        if (simpleSubtitleView3 != null) {
                            simpleSubtitleView3.destroy();
                        }
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        this.f54843t.clear();
        this.f54848y.clear();
        this.f54849z.clear();
        h.a aVar = h.f55010a;
        aVar.b().c(this.D);
        aVar.b().f(this.C);
        aVar.b().reset();
    }

    public final void O(eu.a bean) {
        Intrinsics.h(bean, "bean");
        com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f54861a;
        aVar.a(VideoSubtitleControl.class.getSimpleName() + " --> onDetailPageSubtitleSelect--> " + bean.b().getLan() + ", " + bean.b().getLanName() + ", " + bean.d());
        if (bean.d()) {
            this.I.k(bean, null, false, bean);
            return;
        }
        if (!nh.m.f70597a.e()) {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        bean.b().setStatus(2);
        bean.b().setSetImmediately(true);
        String simpleName = VideoSubtitleControl.class.getSimpleName();
        DownloadBean downloadBean = this.f54839p;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        aVar.a(simpleName + " --> DetailPage downloadSubtitle() --> 内置字幕列表，下载字幕，name = " + totalTitleName + ", subtype = " + bean.b().getType() + ",\"  download subtitleName = " + bean.b().getSubtitleName() + ", subResourceId = " + bean.b().getResourceId() + "~");
        h.f55010a.b().h(bean);
    }

    public final void P(LocalVideoUiType type) {
        SimpleSubtitleView simpleSubtitleView;
        Intrinsics.h(type, "type");
        this.f54841r = type;
        if (this.f54836m) {
            Map map = (Map) this.f54845v.get(type);
            if (map == null) {
                map = new LinkedHashMap();
            }
            this.f54843t = map;
            this.f54844u = (ViewGroup) this.f54846w.get(this.f54841r);
            com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> onLocalUiChanged() --> currentUiType = " + this.f54841r + " --> subtitleSelectList.size = " + this.F.size());
            for (eu.a aVar : this.F) {
                boolean z10 = true;
                if (this.G) {
                    String a11 = aVar.a();
                    int hashCode = a11.hashCode();
                    if (hashCode != 0) {
                        if (hashCode != 50770) {
                            if (hashCode == 51560 && a11.equals("2nd")) {
                                simpleSubtitleView = (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT);
                                z10 = false;
                            }
                        } else if (a11.equals("1st")) {
                            simpleSubtitleView = (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
                        }
                        simpleSubtitleView = null;
                        z10 = false;
                    } else {
                        if (a11.equals("")) {
                            simpleSubtitleView = (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP);
                        }
                        simpleSubtitleView = null;
                        z10 = false;
                    }
                    f0(aVar, simpleSubtitleView, z10);
                } else {
                    f0(aVar, (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), true);
                }
            }
        }
        com.transsion.subtitle.helper.f fVar = this.f54840q;
        if (fVar != null) {
            fVar.i((SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_TOP), (SimpleSubtitleView) this.f54843t.get(IntegrationConstants.TAB_BAR_POSITION_DEFAULT), type, this.f54844u);
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> onLocalUiChanged() --> 页面切换刷新字幕位置信息");
    }

    public final void R() {
        Iterator it = this.f54843t.entrySet().iterator();
        while (it.hasNext()) {
            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) ((Map.Entry) it.next()).getValue();
            if (simpleSubtitleView != null) {
                simpleSubtitleView.pause();
            }
        }
    }

    public final void S(long j11) {
        this.E = j11;
    }

    public final void T() {
        Iterator it = this.f54843t.entrySet().iterator();
        while (it.hasNext()) {
            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) ((Map.Entry) it.next()).getValue();
            if (simpleSubtitleView != null) {
                simpleSubtitleView.resume();
            }
        }
    }

    public final void U() {
    }

    public final void Z() {
        this.H = "";
        this.f54835l.clear();
        for (Map.Entry entry : this.f54843t.entrySet()) {
            SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView != null) {
                simpleSubtitleView.reset();
            }
            SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) entry.getValue();
            if (simpleSubtitleView2 != null) {
                jg.c.g(simpleSubtitleView2);
            }
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> reset() --> 重置资源");
        h.f55010a.b().reset();
    }

    public final void b0(LocalVideoUiType uiType, TextView textView, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ViewGroup viewGroup, boolean z10) {
        Intrinsics.h(uiType, "uiType");
        this.f54836m = z10;
        this.f54844u = viewGroup;
        this.f54843t.put(IntegrationConstants.TAB_BAR_POSITION_TOP, simpleSubtitleView);
        this.f54843t.put(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, simpleSubtitleView2);
        if (z10) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(IntegrationConstants.TAB_BAR_POSITION_TOP, simpleSubtitleView);
            linkedHashMap.put(IntegrationConstants.TAB_BAR_POSITION_DEFAULT, simpleSubtitleView2);
            this.f54845v.put(uiType, linkedHashMap);
            this.f54846w.put(uiType, this.f54844u);
        }
        h.f55010a.b().reset();
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subtitle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoSubtitleControl.c0(VideoSubtitleControl.this, view);
                }
            });
        }
        if (simpleSubtitleView != null) {
            K(simpleSubtitleView);
        }
        if (simpleSubtitleView2 != null) {
            K(simpleSubtitleView2);
        }
        com.transsion.subtitle.helper.f fVar = this.f54840q;
        if (fVar != null) {
            fVar.i(simpleSubtitleView, simpleSubtitleView2, uiType, viewGroup);
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> setData() --> uiType = " + uiType + " --> END");
    }

    public final void d0(boolean z10) {
        this.f54838o = z10;
    }

    public final void e0(Function1 function1) {
        this.f54847x = function1;
    }

    public final void h0(List list) {
        Z();
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            if (this.f54835l.isEmpty()) {
                com.transsion.subtitle.a aVar = com.transsion.subtitle.a.f54861a;
                String simpleName = VideoSubtitleControl.class.getSimpleName();
                DownloadBean downloadBean = this.f54839p;
                aVar.a(simpleName + " --> setSubtitleDataList() --> 无字幕 --> subtitleResId:" + (downloadBean != null ? downloadBean.getSubtitleResId() : null));
                return;
            }
            return;
        }
        com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitleDataList() --> 当前可用字幕数量 -- size = " + list.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            eu.a aVar2 = (eu.a) listIterator.next();
            aVar2.l(false);
            if (linkedHashMap.containsKey(aVar2.b().getId()) && linkedHashMap.containsValue(aVar2.b().getName())) {
                com.transsion.subtitle.a.f54861a.a(VideoSubtitleControl.class.getSimpleName() + " --> setSubtitleDataList() --> Repeated，remove~  name = " + aVar2.b().getName());
                listIterator.remove();
            } else {
                linkedHashMap.put(aVar2.b().getId(), aVar2.b().getName());
            }
        }
        if (list.size() > 1) {
            CollectionsKt.A(list, new Comparator() { // from class: com.transsion.subtitle.VideoSubtitleControl$setSubtitleDataList$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    return ComparisonsKt.d(Integer.valueOf(((eu.a) t11).b().getType()), Integer.valueOf(((eu.a) t12).b().getType()));
                }
            });
        }
        this.f54835l.clear();
        this.f54835l.addAll(list);
        this.f54832i.invoke(this.f54835l);
        J();
    }

    public final void i0(hu.a callback) {
        Intrinsics.h(callback, "callback");
    }

    public final void j0(DownloadBean downloadBean) {
        this.f54839p = downloadBean;
    }

    public final void k0(Function1 callback) {
        Intrinsics.h(callback, "callback");
    }

    public final void l0(boolean z10, boolean z11) {
        String value;
        Boolean m12;
        ConfigBean c11 = sm.f.f75530c.a().c("sa_show_no_subtitle_tips", true);
        if ((!((c11 == null || (value = c11.getValue()) == null || (m12 = StringsKt.m1(value)) == null) ? false : m12.booleanValue()) && !z11) || this.f54824a.isDestroyed() || this.f54824a.isFinishing()) {
            return;
        }
        FragmentActivity fragmentActivity = this.f54824a;
        SubtitleMainDialog2 a11 = SubtitleMainDialog2.INSTANCE.a(this.f54841r == LocalVideoUiType.LAND, z10, this.f54827d, this.f54839p, this.f54825b);
        a11.k0(fragmentActivity, "fragment_subtitle_main_dialog");
        a11.F0(this.I);
    }

    public final void r0(List dubs) {
        Intrinsics.h(dubs, "dubs");
        this.f54827d = dubs;
    }

    public final void s0(long j11) {
        this.f54837n = j11;
    }

    public final void t0(float f11) {
        this.f54826c = f11;
    }
}
