package com.transsion.videofloat.manager;

import android.R;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.PowerManager;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.R$mipmap;
import com.transsion.videofloat.R$string;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.dialog.VideoFloatPermissionDialog;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes7.dex */
public final class VideoPipManagerImp implements ox.e {

    /* renamed from: v, reason: collision with root package name */
    public static final a f58030v = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private FragmentActivity f58032c;

    /* renamed from: d, reason: collision with root package name */
    private px.a f58033d;

    /* renamed from: e, reason: collision with root package name */
    private PowerManager.WakeLock f58034e;

    /* renamed from: f, reason: collision with root package name */
    private com.transsion.player.orplayer.g f58035f;

    /* renamed from: g, reason: collision with root package name */
    private ORPlayerView f58036g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f58037h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f58038i;

    /* renamed from: j, reason: collision with root package name */
    private ViewGroup f58039j;

    /* renamed from: l, reason: collision with root package name */
    private Rect f58041l;

    /* renamed from: m, reason: collision with root package name */
    private int f58042m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f58043n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f58044o;

    /* renamed from: p, reason: collision with root package name */
    private b f58045p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f58046q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f58047r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f58049t;

    /* renamed from: b, reason: collision with root package name */
    private final String f58031b = VideoPipManagerImp.class.getSimpleName();

    /* renamed from: k, reason: collision with root package name */
    private float f58040k = 16.0f;

    /* renamed from: s, reason: collision with root package name */
    private final VideoPipManagerImp$pipActionReceiver$1 f58048s = new BroadcastReceiver() { // from class: com.transsion.videofloat.manager.VideoPipManagerImp$pipActionReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            a.C0856a c0856a = lg.a.f68962a;
            str = VideoPipManagerImp.this.f58031b;
            a.C0856a.v(c0856a, "VideoFloat-pip", str + " --pipActionReceiver action:" + (intent != null ? intent.getAction() : null), false, 4, null);
            if (intent == null || !Intrinsics.c(intent.getAction(), "pip_action_control")) {
                return;
            }
            int intExtra = intent.getIntExtra("control_type", 0);
            str2 = VideoPipManagerImp.this.f58031b;
            a.C0856a.r(c0856a, "VideoFloat-pip", new String[]{str2 + " --pipActionReceiver controlType:" + intExtra}, false, 4, null);
            if (intExtra == 1) {
                VideoPipManagerImp.this.M();
            } else if (intExtra == 2) {
                VideoPipManagerImp.this.H(true);
            } else {
                if (intExtra != 3) {
                    return;
                }
                VideoPipManagerImp.this.H(false);
            }
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private boolean f58050u = true;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public final class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f58051a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f58052b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VideoPipManagerImp f58053c;

        public b(VideoPipManagerImp videoPipManagerImp, Function1 callback) {
            Intrinsics.h(callback, "callback");
            this.f58053c = videoPipManagerImp;
            this.f58051a = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.h(context, "context");
            Intrinsics.h(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        this.f58052b = true;
                        this.f58051a.invoke(Boolean.TRUE);
                        a.C0856a.f(lg.a.f68962a, "CommonInfo", "Screen off", false, 4, null);
                        return;
                    }
                    return;
                }
                if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    this.f58052b = false;
                    this.f58051a.invoke(Boolean.FALSE);
                    a.C0856a.f(lg.a.f68962a, "CommonInfo", "User present", false, 4, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58054a;

        static {
            int[] iArr = new int[FloatActionType.values().length];
            try {
                iArr[FloatActionType.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatActionType.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatActionType.HOME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f58054a = iArr;
        }
    }

    private final RemoteAction D(Context context, int i11, int i12, int i13, int i14) {
        n.a();
        return m.a(Icon.createWithResource(context, i11), Utils.a().getString(i12), Utils.a().getString(i12), PendingIntent.getBroadcast(context, i13, new Intent("pip_action_control").putExtra("control_type", i14), 67108864));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(VideoPipManagerImp videoPipManagerImp, FragmentActivity fragmentActivity, px.a aVar, FloatActionType floatActionType, boolean z10) {
        if (z10) {
            videoPipManagerImp.F(fragmentActivity, aVar, floatActionType);
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void F(androidx.fragment.app.FragmentActivity r10, px.a r11, com.transsion.videofloat.bean.FloatActionType r12) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videofloat.manager.VideoPipManagerImp.F(androidx.fragment.app.FragmentActivity, px.a, com.transsion.videofloat.bean.FloatActionType):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        KeyEventDispatcher.Component component = this.f58032c;
        if (component instanceof com.transsion.videofloat.manager.c) {
            Intrinsics.f(component, "null cannot be cast to non-null type com.transsion.videofloat.manager.IVideoPipView");
            ((com.transsion.videofloat.manager.c) component).j();
        }
        PowerManager.WakeLock wakeLock = this.f58034e;
        if (wakeLock != null) {
            wakeLock.release();
        }
        this.f58034e = null;
        FragmentActivity fragmentActivity = this.f58032c;
        if (fragmentActivity != null) {
            fragmentActivity.finish();
        }
        this.f58032c = null;
        this.f58044o = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(boolean z10) {
        long g11;
        lg.a.f68962a.u("VideoFloat-pip", this.f58031b + " -- forward :" + z10, true);
        if (z10) {
            com.transsion.player.orplayer.g gVar = this.f58035f;
            long currentPosition = (gVar != null ? gVar.getCurrentPosition() : 0L) + 10000;
            com.transsion.player.orplayer.g gVar2 = this.f58035f;
            g11 = RangesKt.j(currentPosition, gVar2 != null ? gVar2.getDuration() : 0L);
        } else {
            com.transsion.player.orplayer.g gVar3 = this.f58035f;
            g11 = RangesKt.g(0L, (gVar3 != null ? gVar3.getCurrentPosition() : 0L) - 10000);
        }
        com.transsion.player.orplayer.g gVar4 = this.f58035f;
        if (gVar4 != null) {
            gVar4.seekTo(g11);
        }
    }

    private final List I(FragmentActivity fragmentActivity, boolean z10) {
        RemoteAction[] remoteActionArr = new RemoteAction[3];
        remoteActionArr[0] = D(fragmentActivity, R$mipmap.video_float_ic_backward, R$string.video_pip_action_rewind, 13, 3);
        remoteActionArr[1] = z10 ? D(fragmentActivity, R$mipmap.video_float_ic_pause, R$string.video_pip_action_play, 11, 1) : D(fragmentActivity, R$mipmap.video_float_ic_play, R$string.video_pip_action_pause, 11, 1);
        remoteActionArr[2] = D(fragmentActivity, R$mipmap.video_float_ic_forward, R$string.video_pip_action_fast_forword, 12, 2);
        return CollectionsKt.o(remoteActionArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r2.k(r3).totalMem > (1073741824 * r0)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean J() {
        /*
            r9 = this;
            boolean r0 = r9.f58049t
            if (r0 != 0) goto L48
            sm.f$a r0 = sm.f.f75530c
            sm.f r0 = r0.a()
            r1 = 2
            r2 = 0
            java.lang.String r3 = "sa_pip_enable_memory"
            r4 = 0
            com.transsion.mb.config.manager.ConfigBean r0 = sm.f.d(r0, r3, r4, r1, r2)
            if (r0 == 0) goto L26
            java.lang.String r0 = r0.getValue()
            if (r0 == 0) goto L26
            java.lang.Integer r0 = kotlin.text.StringsKt.v(r0)
            if (r0 == 0) goto L26
            int r0 = r0.intValue()
            goto L27
        L26:
            r0 = 4
        L27:
            r1 = 1
            if (r0 <= 0) goto L45
            ih.b r2 = ih.b.f65364a
            android.app.Application r3 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r5)
            android.app.ActivityManager$MemoryInfo r2 = r2.k(r3)
            long r2 = r2.totalMem
            double r2 = (double) r2
            r5 = 1073741824(0x40000000, float:2.0)
            double r5 = (double) r5
            double r7 = (double) r0
            double r5 = r5 * r7
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 <= 0) goto L46
        L45:
            r4 = r1
        L46:
            r9.f58050u = r4
        L48:
            boolean r0 = r9.f58050u
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videofloat.manager.VideoPipManagerImp.J():boolean");
    }

    private final void K(FragmentActivity fragmentActivity) {
        View childAt;
        Unit unit;
        this.f58047r = false;
        if (this.f58043n) {
            return;
        }
        com.transsion.player.orplayer.g gVar = this.f58035f;
        if (gVar != null) {
            gVar.play();
        }
        this.f58043n = true;
        FrameLayout frameLayout = (FrameLayout) fragmentActivity.findViewById(R.id.content);
        R();
        if (this.f58036g == null) {
            lg.a.f68962a.i("VideoFloat-pip", "onEnterPip playerView is null", true);
            return;
        }
        Q(fragmentActivity);
        try {
            Result.Companion companion = Result.INSTANCE;
            lg.a.f68962a.c("VideoFloat-pip", "onEnterPip childCount：" + frameLayout.getChildCount(), true);
            View childAt2 = frameLayout.getChildAt(0);
            if (childAt2 != null) {
                jg.c.g(childAt2);
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        frameLayout.addView(this.f58036g, new FrameLayout.LayoutParams(-1, -1));
        ViewGroup viewGroup = this.f58037h;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            this.f58042m = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup viewGroup2 = this.f58037h;
                if (viewGroup2 != null && (childAt = viewGroup2.getChildAt(i11)) != null) {
                    SimpleSubtitleView simpleSubtitleView = childAt instanceof SimpleSubtitleView ? (SimpleSubtitleView) childAt : null;
                    if (simpleSubtitleView != null) {
                        this.f58040k = com.blankj.utilcode.util.a0.c(simpleSubtitleView.getTextSize());
                        this.f58041l = new Rect(simpleSubtitleView.getPaddingLeft(), simpleSubtitleView.getPaddingTop(), simpleSubtitleView.getPaddingRight(), simpleSubtitleView.getPaddingBottom());
                        ViewGroup.LayoutParams layoutParams2 = simpleSubtitleView.getLayoutParams();
                        layoutParams2.width = -1;
                        simpleSubtitleView.setLayoutParams(layoutParams2);
                        if (i11 == 1) {
                            simpleSubtitleView.setTextSize(0.0f);
                            simpleSubtitleView.setPadding(0, 0, 0, 0);
                        } else {
                            simpleSubtitleView.setTextSize(12.0f);
                            int a11 = com.blankj.utilcode.util.a0.a(6.0f);
                            simpleSubtitleView.setPadding(a11, 0, a11, a11);
                        }
                    }
                }
            }
        }
        ViewGroup viewGroup3 = this.f58037h;
        if (viewGroup3 != null) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 81;
            frameLayout.addView(viewGroup3, layoutParams3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.videofloat.manager.VideoPipManagerImp.L():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        com.transsion.player.orplayer.g gVar;
        a.C0856a c0856a = lg.a.f68962a;
        String str = this.f58031b;
        com.transsion.player.orplayer.g gVar2 = this.f58035f;
        c0856a.u("VideoFloat-pip", str + " --onPlayOrPauseClick isPlaying:" + (gVar2 != null ? Boolean.valueOf(gVar2.isPlaying()) : null), true);
        com.transsion.player.orplayer.g gVar3 = this.f58035f;
        if (gVar3 != null && gVar3.isPlaying()) {
            this.f58046q = true;
            com.transsion.player.orplayer.g gVar4 = this.f58035f;
            if (gVar4 != null) {
                gVar4.pause();
                return;
            }
            return;
        }
        com.transsion.player.orplayer.g gVar5 = this.f58035f;
        if (gVar5 != null && gVar5.isComplete() && (gVar = this.f58035f) != null) {
            gVar.seekTo(0L);
        }
        this.f58046q = false;
        com.transsion.player.orplayer.g gVar6 = this.f58035f;
        if (gVar6 != null) {
            gVar6.play();
        }
    }

    private final void N() {
        try {
            Result.Companion companion = Result.INSTANCE;
            a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", this.f58031b + " start--registerReceiver", false, 4, null);
            Result.m1185constructorimpl(Build.VERSION.SDK_INT >= 33 ? Utils.a().registerReceiver(this.f58048s, new IntentFilter("pip_action_control"), 2) : Utils.a().registerReceiver(this.f58048s, new IntentFilter("pip_action_control")));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        O();
    }

    private final void O() {
        this.f58045p = new b(this, new Function1() { // from class: com.transsion.videofloat.manager.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P;
                P = VideoPipManagerImp.P(VideoPipManagerImp.this, ((Boolean) obj).booleanValue());
                return P;
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(Build.VERSION.SDK_INT >= 33 ? Utils.a().registerReceiver(this.f58045p, intentFilter, 2) : Utils.a().registerReceiver(this.f58045p, intentFilter));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(VideoPipManagerImp videoPipManagerImp, boolean z10) {
        com.transsion.player.orplayer.g gVar;
        if (z10) {
            com.transsion.player.orplayer.g gVar2 = videoPipManagerImp.f58035f;
            if (gVar2 != null) {
                gVar2.pause();
            }
        } else if (!videoPipManagerImp.f58046q && (gVar = videoPipManagerImp.f58035f) != null) {
            gVar.play();
        }
        return Unit.f67184a;
    }

    private final void Q(FragmentActivity fragmentActivity) {
        try {
            Result.Companion companion = Result.INSTANCE;
            List<Fragment> y02 = fragmentActivity.getSupportFragmentManager().y0();
            Intrinsics.g(y02, "getFragments(...)");
            for (Fragment fragment : y02) {
                if (fragment instanceof DialogFragment) {
                    ((DialogFragment) fragment).dismissAllowingStateLoss();
                }
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final void R() {
        ORPlayerView oRPlayerView = this.f58036g;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f58036g);
        }
        ViewGroup viewGroup2 = this.f58037h;
        Object parent2 = viewGroup2 != null ? viewGroup2.getParent() : null;
        ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
        if (viewGroup3 != null) {
            viewGroup3.removeView(this.f58037h);
        }
    }

    private final void S(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", str);
        hashMap.put(EventConstants.KEY_ACTION, "float_back_page");
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "pip_float_back");
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hj.i.f64628a.p(str3, hashMap);
    }

    private final void T(boolean z10, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", str);
        hashMap.put(EventConstants.KEY_ACTION, z10 ? "allow" : "cancel");
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "pip_permission_dialog");
        hashMap.put(WebConstants.PAGE_FROM, str3);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hj.i.f64628a.p("pip_permission_dialog_pip", hashMap);
    }

    private final void U(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", str);
        hashMap.put(WebConstants.PAGE_FROM, str3);
        hashMap.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "pip_permission_dialog");
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hj.i.f64628a.s("pip_permission_dialog_pip", "dialog_show", hashMap);
    }

    private final void V(boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("has_permission", String.valueOf(z10));
        hj.i.f64628a.s("pip_opt", "app_perf", hashMap);
    }

    private final void W(FragmentActivity fragmentActivity, final boolean z10, final String str, final String str2, final Function1 function1) {
        ye.c.f79116a.e(fragmentActivity).b("android.permission.PICTURE_IN_PICTURE").b().c(new ze.b() { // from class: com.transsion.videofloat.manager.w
            @Override // ze.b
            public final void a(cf.f fVar, List list, boolean z11, boolean z12) {
                VideoPipManagerImp.X(z10, this, str2, str, fVar, list, z11, z12);
            }
        }).d(new ze.a() { // from class: com.transsion.videofloat.manager.x
            @Override // ze.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                VideoPipManagerImp.Y(VideoPipManagerImp.this, str2, str, baseDialog, bool, permissionDialogClickType);
            }
        }).a(new ze.c() { // from class: com.transsion.videofloat.manager.y
            @Override // ze.c
            public final void a(boolean z11, List list, List list2) {
                VideoPipManagerImp.Z(VideoPipManagerImp.this, function1, z11, list, list2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(boolean z10, VideoPipManagerImp videoPipManagerImp, String str, String str2, cf.f scope, List deniedList, boolean z11, boolean z12) {
        Intrinsics.h(scope, "scope");
        Intrinsics.h(deniedList, "deniedList");
        if (!z11) {
            a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "pip 请求权限之后，", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "VideoFloat", "pip 请求权限前，提示弹窗，isFullLand：" + z10, false, 4, null);
        if (z10) {
            scope.d(new VideoFloatPermissionDialog(true, deniedList));
        } else {
            scope.e(deniedList, new bf.a(null, Utils.a().getString(R$string.video_float_tips_pip), Utils.a().getString(R$string.video_float_enable), Integer.valueOf(R$mipmap.video_float_ic_permission_img), Integer.valueOf(R$color.white_20), 1, null));
        }
        px.a aVar = videoPipManagerImp.f58033d;
        videoPipManagerImp.U(str, aVar != null ? aVar.e() : null, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(VideoPipManagerImp videoPipManagerImp, String str, String str2, BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
        boolean z10 = permissionDialogClickType == PermissionDialogClickType.POSITIVE;
        px.a aVar = videoPipManagerImp.f58033d;
        videoPipManagerImp.T(z10, str, aVar != null ? aVar.e() : null, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(VideoPipManagerImp videoPipManagerImp, Function1 function1, boolean z10, List grantedList, List deniedList) {
        Intrinsics.h(grantedList, "grantedList");
        Intrinsics.h(deniedList, "deniedList");
        a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "pip 请求权限结果:" + z10, false, 4, null);
        videoPipManagerImp.V(z10);
        if (z10) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @Override // ox.e
    public PictureInPictureParams a(FragmentActivity activity, boolean z10, boolean z11, ViewGroup viewGroup) {
        PictureInPictureParams build;
        Intrinsics.h(activity, "activity");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return null;
        }
        if (this.f58047r && !z11) {
            a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", this.f58031b + " updatePictureInPictureParams isEntering return", false, 4, null);
            return null;
        }
        a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", this.f58031b + " updatePictureInPictureParams AutoEnterEnabled:" + z11 + "}", false, 4, null);
        Rational rational = new Rational(z10 ? 9 : 16, z10 ? 16 : 9);
        PictureInPictureParams.Builder a11 = l.a();
        a11.setAspectRatio(rational);
        a11.setActions(I(activity, z11));
        if (viewGroup != null) {
            Rect rect = new Rect();
            viewGroup.getGlobalVisibleRect(rect);
            a11.setSourceRectHint(rect);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            a11.setAutoEnterEnabled(z11);
        }
        build = a11.build();
        try {
            activity.setPictureInPictureParams(build);
        } catch (Throwable unused) {
        }
        return build;
    }

    @Override // ox.e
    public boolean b(String tag) {
        Intrinsics.h(tag, "tag");
        px.a aVar = this.f58033d;
        if (aVar == null) {
            return false;
        }
        return Intrinsics.c(tag, aVar.r() + aVar.q() + aVar.c());
    }

    @Override // ox.e
    public boolean c() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        boolean hasSystemFeature = Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        boolean J = J();
        lg.a.f68962a.u("VideoFloat-pip", this.f58031b + " --hasPipFeature:" + hasSystemFeature + ", isMemoryEnable:" + J + " ", true);
        return hasSystemFeature && J;
    }

    @Override // ox.e
    public void d(boolean z10) {
        Object m1185constructorimpl;
        t1 d11;
        try {
            Result.Companion companion = Result.INSTANCE;
            d11 = kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new VideoPipManagerImp$closePip$1$1(this, z10, null), 3, null);
            m1185constructorimpl = Result.m1185constructorimpl(d11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            lg.a.f68962a.i("VideoFloat-pip", "closePip error:" + m1188exceptionOrNullimpl, true);
        }
    }

    @Override // ox.e
    public void e() {
        boolean hasSystemFeature = Build.VERSION.SDK_INT >= 26 ? Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture") : true;
        HashMap hashMap = new HashMap();
        hashMap.put("pip_opt", String.valueOf(hasSystemFeature));
        hashMap.put("pip_enable", String.valueOf(c()));
        hj.i.f64628a.s("pip", "app_perf", hashMap);
    }

    @Override // ox.e
    public boolean f(com.transsion.player.orplayer.g gVar) {
        a.C0856a.v(lg.a.f68962a, "VideoFloat-pip", "2-isEnterPip：" + this.f58043n + ", " + this.f58035f + ", " + gVar + " ", false, 4, null);
        if (!this.f58043n) {
            return false;
        }
        com.transsion.player.orplayer.g gVar2 = this.f58035f;
        return gVar2 == null ? false : Intrinsics.c(gVar2, gVar);
    }

    @Override // ox.e
    public boolean g() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Utils.a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
        }
        return true;
    }

    @Override // ox.e
    public void h(FragmentActivity activity, px.a bean) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(bean, "bean");
        this.f58032c = activity;
        this.f58033d = bean;
        N();
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.p("VideoFloat-pip", new String[]{">=android12  " + this.f58031b + " =====updateData---, isPlaying:" + bean.f().isPlaying() + ", isSetData:" + this.f58044o}, true);
        this.f58037h = bean.u();
        if (!this.f58044o) {
            this.f58044o = true;
            ViewGroup u11 = bean.u();
            ViewParent parent = u11 != null ? u11.getParent() : null;
            this.f58038i = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            ViewParent parent2 = bean.l().getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            this.f58039j = viewGroup;
            c0856a.c("VideoFloat-pip", ">=android12  " + this.f58031b + " =====updateData---, playerOriginalContainer:" + viewGroup, true);
        }
        this.f58035f = bean.f();
        this.f58036g = bean.l();
    }

    @Override // ox.e
    public void i(FragmentActivity fragmentActivity) {
        FragmentActivity fragmentActivity2;
        if (fragmentActivity == null || (fragmentActivity2 = this.f58032c) == null || Intrinsics.c(fragmentActivity, fragmentActivity2)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                a.C0856a.r(lg.a.f68962a, "VideoFloat-pip", new String[]{this.f58031b + " --unregisterReceiver"}, false, 4, null);
                Utils.a().unregisterReceiver(this.f58048s);
                Utils.a().unregisterReceiver(this.f58045p);
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    @Override // ox.e
    public boolean isPlaying() {
        com.transsion.player.orplayer.g gVar;
        if (this.f58043n && (gVar = this.f58035f) != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    @Override // ox.e
    public boolean j() {
        return this.f58043n;
    }

    @Override // ox.e
    public void k(final FragmentActivity activity, final px.a bean, final FloatActionType actionType, boolean z10) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(bean, "bean");
        Intrinsics.h(actionType, "actionType");
        this.f58047r = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return;
        }
        if (i11 >= 31 && actionType == FloatActionType.HOME) {
            this.f58047r = false;
            lg.a.f68962a.p("VideoFloat-pip", new String[]{">=android12，触发home键，使用自动模式，不使用home键监听"}, true);
            return;
        }
        if (ye.c.f79116a.c(activity)) {
            F(activity, bean, actionType);
            return;
        }
        lg.a.f68962a.c("VideoFloat-pip", "画中画 没权限", true);
        int i12 = c.f58054a[actionType.ordinal()];
        if (i12 == 1) {
            W(activity, z10, bean.h(), bean.r(), new Function1() { // from class: com.transsion.videofloat.manager.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit E;
                    E = VideoPipManagerImp.E(VideoPipManagerImp.this, activity, bean, actionType, ((Boolean) obj).booleanValue());
                    return E;
                }
            });
        } else if (i12 == 2) {
            activity.finish();
        } else if (i12 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        this.f58047r = false;
    }

    @Override // ox.e
    public void onPipModeChanged(boolean z10) {
        FragmentActivity fragmentActivity = this.f58032c;
        if (fragmentActivity == null || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            a.C0856a.l(lg.a.f68962a, "CommonInfo", "onPipModeChanged, activity:" + fragmentActivity + " isFinishing:" + (fragmentActivity != null ? Boolean.valueOf(fragmentActivity.isFinishing()) : null) + ", " + (fragmentActivity != null ? Boolean.valueOf(fragmentActivity.isDestroyed()) : null), false, 4, null);
            return;
        }
        lg.a.f68962a.p("VideoFloat-pip", new String[]{"onPipModeChanged " + this.f58031b + ", activity:" + fragmentActivity.getClass().getSimpleName() + " onPictureInPictureModeChanged 2， isInPipMode:" + z10}, true);
        if (z10) {
            K(fragmentActivity);
            try {
                Result.Companion companion = Result.INSTANCE;
                PowerManager powerManager = (PowerManager) fragmentActivity.getSystemService("power");
                PowerManager.WakeLock newWakeLock = powerManager != null ? powerManager.newWakeLock(26, "MB::PlayerPip") : null;
                this.f58034e = newWakeLock;
                if (newWakeLock != null) {
                    newWakeLock.acquire();
                    r1 = Unit.f67184a;
                }
                Result.m1185constructorimpl(r1);
                return;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
                return;
            }
        }
        ORPlayerView oRPlayerView = this.f58036g;
        if (oRPlayerView != null) {
            oRPlayerView.getKeepScreenOn();
        }
        L();
        try {
            Result.Companion companion3 = Result.INSTANCE;
            PowerManager.WakeLock wakeLock = this.f58034e;
            if (wakeLock != null) {
                wakeLock.release();
            }
            this.f58034e = null;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th3));
        }
    }
}
