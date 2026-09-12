package com.transsion.videofloat.manager;

import android.app.Application;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tencent.mmkv.MMKV;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.videofloat.R$mipmap;
import com.transsion.videofloat.R$string;
import com.transsion.videofloat.dialog.VideoFloatPermissionDialog;
import com.transsion.videofloat.view.VideoFloatView;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.List;
import ko.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import ox.b;

/* loaded from: classes7.dex */
public final class i implements ox.b {

    /* renamed from: b, reason: collision with root package name */
    private VideoFloatView f58098b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f58099c;

    /* loaded from: classes7.dex */
    public static final class a implements sx.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sx.a f58100a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f58101b;

        a(sx.a aVar, i iVar) {
            this.f58100a = aVar;
            this.f58101b = iVar;
        }

        @Override // sx.a
        public boolean a(px.a aVar) {
            sx.a aVar2 = this.f58100a;
            if (aVar2 != null) {
                return aVar2.a(aVar);
            }
            return false;
        }

        @Override // sx.a
        public void b(px.a aVar) {
            if (aVar != null) {
                i iVar = this.f58101b;
                String r11 = aVar.r();
                UGCVideo v11 = aVar.v();
                iVar.q(r11, v11 != null ? v11.getUgcVideoId() : null, aVar.h(), aVar.e());
            }
            sx.a aVar2 = this.f58100a;
            if (aVar2 != null) {
                aVar2.b(aVar);
            }
        }

        @Override // sx.a
        public void c(px.a aVar) {
            String k11;
            this.f58101b.f58099c = false;
            sx.a aVar2 = this.f58100a;
            if (aVar2 != null) {
                aVar2.c(aVar);
            }
            this.f58101b.f58098b = null;
            if (aVar == null || (k11 = aVar.k()) == null) {
                return;
            }
            a0.f58056a.e(k11);
        }
    }

    private final void n(FragmentActivity fragmentActivity, boolean z10, String str, String str2, String str3, String str4) {
        if (p()) {
            return;
        }
        w(this, fragmentActivity, z10, str, str2, str3, str4, null, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, i iVar, px.a aVar, boolean z10, sx.a aVar2, boolean z11) {
        if (z11) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            iVar.u(aVar, z10, aVar2);
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        return Unit.f67184a;
    }

    private final boolean p() {
        return Settings.canDrawOverlays(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("subject_id", str);
        }
        if (str4 != null) {
            hashMap.put("ops", str4);
        }
        if (str2 != null) {
            hashMap.put("ugc_video_id", str2);
        }
        hashMap.put("opt_type", "float_back_page");
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "float");
        hj.i.f64628a.p(str3, hashMap);
    }

    private final void r(boolean z10, String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("subject_id", str);
        }
        if (str2 != null) {
            hashMap.put("ugc_video_id", str2);
        }
        if (str4 != null) {
            hashMap.put("ops", str4);
        }
        hashMap.put("opt_type", z10 ? "allow" : "cancel");
        hashMap.put(WebConstants.PAGE_FROM, str3);
        hj.i.f64628a.p(ox.b.f72314a.d(), hashMap);
    }

    private final void s(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("subject_id", str);
        }
        if (str2 != null) {
            hashMap.put("ugc_video_id", str2);
        }
        if (str4 != null) {
            hashMap.put("ops", str4);
        }
        hashMap.put(WebConstants.PAGE_FROM, str3);
        hj.i.f64628a.r(ox.b.f72314a.d(), hashMap);
    }

    private final void t(boolean z10, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_permission", String.valueOf(z11));
        hashMap.put(EventConstants.KEY_ACTION, z10 ? "click" : "auto");
        hj.i.f64628a.s("float_opt", "app_perf", hashMap);
    }

    private final void u(px.a aVar, boolean z10, sx.a aVar2) {
        b.C0906b.a(this, false, 1, null);
        if (this.f58098b == null) {
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            this.f58098b = new VideoFloatView(a11);
        }
        VideoFloatView videoFloatView = this.f58098b;
        if (videoFloatView != null) {
            a.C0856a.f(lg.a.f68962a, "VideoFloat", "showFloat", false, 4, null);
            a0.f58056a.a(aVar.k(), aVar.f());
            this.f58099c = true;
            videoFloatView.addToWindow(z10, aVar);
            videoFloatView.setVideoFloatListener(new a(aVar2, this));
        }
    }

    private final void v(FragmentActivity fragmentActivity, final boolean z10, final String str, final String str2, final String str3, final String str4, final Function1 function1) {
        ye.c.f79116a.e(fragmentActivity).b("android.permission.SYSTEM_ALERT_WINDOW").b().c(new ze.b() { // from class: com.transsion.videofloat.manager.e
            @Override // ze.b
            public final void a(cf.f fVar, List list, boolean z11, boolean z12) {
                i.x(z10, this, str2, str3, str, str4, fVar, list, z11, z12);
            }
        }).d(new ze.a() { // from class: com.transsion.videofloat.manager.f
            @Override // ze.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                i.y(i.this, str2, str3, str, str4, baseDialog, bool, permissionDialogClickType);
            }
        }).a(new ze.c() { // from class: com.transsion.videofloat.manager.g
            @Override // ze.c
            public final void a(boolean z11, List list, List list2) {
                i.z(i.this, function1, z11, list, list2);
            }
        });
    }

    static /* synthetic */ void w(i iVar, FragmentActivity fragmentActivity, boolean z10, String str, String str2, String str3, String str4, Function1 function1, int i11, Object obj) {
        iVar.v(fragmentActivity, z10, str, str2, str3, str4, (i11 & 64) != 0 ? null : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(boolean z10, i iVar, String str, String str2, String str3, String str4, cf.f scope, List deniedList, boolean z11, boolean z12) {
        Intrinsics.h(scope, "scope");
        Intrinsics.h(deniedList, "deniedList");
        if (!z11) {
            a.C0856a.f(lg.a.f68962a, "VideoFloat", "请求权限之后，", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "请求权限前，提示弹窗，isFullLand：" + z10, false, 4, null);
        if (z10) {
            scope.d(new VideoFloatPermissionDialog(false, deniedList));
        } else {
            scope.e(deniedList, new bf.a(null, Utils.a().getString(R$string.video_float_tips_v2), Utils.a().getString(R$string.video_float_enable), Integer.valueOf(R$mipmap.video_float_ic_permission_img), Integer.valueOf(R$color.white_20), 1, null));
        }
        iVar.s(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(i iVar, String str, String str2, String str3, String str4, BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
        iVar.r(permissionDialogClickType == PermissionDialogClickType.POSITIVE, str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(i iVar, Function1 function1, boolean z10, List grantedList, List deniedList) {
        Intrinsics.h(grantedList, "grantedList");
        Intrinsics.h(deniedList, "deniedList");
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "请求权限结果:" + z10, false, 4, null);
        iVar.t(true, z10);
        if (z10) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @Override // ox.b
    public boolean b(String tag) {
        px.a floatBean;
        Intrinsics.h(tag, "tag");
        VideoFloatView videoFloatView = this.f58098b;
        if (videoFloatView == null || (floatBean = videoFloatView.getFloatBean()) == null) {
            return false;
        }
        return Intrinsics.c(tag, floatBean.r() + floatBean.q() + floatBean.c());
    }

    @Override // ox.b
    public boolean c(com.transsion.player.orplayer.g gVar) {
        boolean c11;
        a.C0856a c0856a = lg.a.f68962a;
        boolean z10 = this.f58099c;
        VideoFloatView videoFloatView = this.f58098b;
        a.C0856a.f(c0856a, "VideoFloat", "1-isEnterFloat：" + z10 + ", " + (videoFloatView != null ? videoFloatView.getOrPlayer() : null) + ", " + gVar + " ", false, 4, null);
        if (!this.f58099c) {
            return false;
        }
        VideoFloatView videoFloatView2 = this.f58098b;
        if ((videoFloatView2 != null ? videoFloatView2.getOrPlayer() : null) == null) {
            c11 = false;
        } else {
            VideoFloatView videoFloatView3 = this.f58098b;
            c11 = Intrinsics.c(videoFloatView3 != null ? videoFloatView3.getOrPlayer() : null, gVar);
        }
        return c11;
    }

    @Override // ox.b
    public void d() {
        t(false, p());
    }

    @Override // ox.b
    public void e(FragmentActivity activity, String str, String str2, String pageName, String str3) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(pageName, "pageName");
        Function0 p11 = l0.f67091a.p();
        if ((p11 == null || !((Boolean) p11.invoke()).booleanValue()) && !ox.e.f72320a.b().c()) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            MMKV b11 = bVar.b();
            b.a aVar = ox.b.f72314a;
            if (b11.getBoolean(aVar.b(), false) || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            bVar.b().putBoolean(aVar.b(), true);
            n(activity, false, pageName, str, str2, str3);
        }
    }

    @Override // ox.b
    public void f(boolean z10) {
        if (!z10) {
            a0.f58056a.d();
        }
        this.f58099c = false;
        VideoFloatView videoFloatView = this.f58098b;
        if (videoFloatView != null) {
            videoFloatView.removeFromWindow();
        }
        this.f58098b = null;
    }

    @Override // ox.b
    public void g(FragmentActivity activity, final px.a floatBean, final boolean z10, boolean z11, final Function1 function1, final sx.a aVar) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(floatBean, "floatBean");
        Function0 p11 = l0.f67091a.p();
        if (p11 == null || !((Boolean) p11.invoke()).booleanValue()) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            lg.a.f68962a.c("VideoFloat", "单播放器 禁用pip功能", true);
            return;
        }
        floatBean.D(z10);
        if (p()) {
            a.C0856a.f(lg.a.f68962a, "VideoFloat", "checkShowFloatView--has permission showFloat", false, 4, null);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            u(floatBean, z10, aVar);
            return;
        }
        lg.a.f68962a.c("VideoFloat", "checkShowFloatView no permission proactive:" + z10, true);
        if (!z10) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        } else {
            String h11 = floatBean.h();
            String r11 = floatBean.r();
            UGCVideo v11 = floatBean.v();
            v(activity, z11, h11, r11, v11 != null ? v11.getUgcVideoId() : null, floatBean.e(), new Function1() { // from class: com.transsion.videofloat.manager.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o11;
                    o11 = i.o(Function1.this, this, floatBean, z10, aVar, ((Boolean) obj).booleanValue());
                    return o11;
                }
            });
        }
    }

    @Override // ox.b
    public boolean isPlaying() {
        VideoFloatView videoFloatView;
        if (this.f58099c && (videoFloatView = this.f58098b) != null) {
            return videoFloatView.isPlaying();
        }
        return false;
    }
}
