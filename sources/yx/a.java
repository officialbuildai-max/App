package yx;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.transsion.ad.bidding.base.v;
import com.transsion.ad.ps.activate.PSActivateManager;
import com.transsion.ad.ps.activate.PsActivateBean;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.MemberSource;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import org.json.JSONObject;
import ti.p;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79208a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static PsActivateBean f79209b;

    /* renamed from: yx.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class C1000a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f79210a;

        static {
            int[] iArr = new int[MemberSource.values().length];
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_TIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f79210a = iArr;
        }
    }

    private a() {
    }

    private final boolean c(Activity activity) {
        if (v.f41947a.b()) {
            a.C0856a.g(lg.a.f68962a, "ActivateAdManager --> canShow(" + activity.getClass().getSimpleName() + ") --> 当前Activity广告正在展示", false, 2, null);
            return false;
        }
        if (i()) {
            a.C0856a.g(lg.a.f68962a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 配置已关闭", false, 2, null);
            return false;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("activate_show_date", "");
        String c11 = p.f76389a.c();
        if (!TextUtils.equals(string, c11)) {
            bVar.b().putInt("activate_show_times", 0);
            a.C0856a.g(lg.a.f68962a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 新的一天重置次数 --> curDate = " + c11 + " --> lastShowDate = " + string, false, 2, null);
        }
        int i11 = bVar.b().getInt("activate_show_times", 0);
        int h11 = h();
        if (i11 >= h11) {
            a.C0856a.g(lg.a.f68962a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 展示次数已达上限 --> showTimes = " + i11 + " --> limit = " + h11, false, 2, null);
            return false;
        }
        long g11 = g();
        long j11 = bVar.b().getLong("activate_show_timestamp", 0L);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j12 = elapsedRealtime - j11;
        if (j12 >= g11) {
            return true;
        }
        a.C0856a.g(lg.a.f68962a, f() + " --> canShow(" + activity.getClass().getSimpleName() + ") --> 展示间隔未到 --> lastShowTimestamp = " + j11 + " --> cur = " + elapsedRealtime + " --> interval = " + g11 + " --> gap = " + j12, false, 2, null);
        return false;
    }

    private final String f() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final SpannableStringBuilder a(Context context, String rawTitle) {
        Intrinsics.h(context, "context");
        Intrinsics.h(rawTitle, "rawTitle");
        String o11 = o(rawTitle);
        String p11 = p(j(), "notificationStyleTitle", o11);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(p11);
        int o02 = StringsKt.o0(p11, o11, 0, false, 6, null);
        spannableStringBuilder.setSpan(new StyleSpan(2), o02, o11.length() + o02, 33);
        return spannableStringBuilder;
    }

    public final SpannableStringBuilder b(Context context, String name, String fullText) {
        Intrinsics.h(context, "context");
        Intrinsics.h(name, "name");
        Intrinsics.h(fullText, "fullText");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fullText);
        int o02 = StringsKt.o0(fullText, name, 0, false, 6, null);
        spannableStringBuilder.setSpan(new StyleSpan(2), o02, name.length() + o02, 33);
        return spannableStringBuilder;
    }

    public final void d(boolean z10) {
        PsActivateBean psActivateBean;
        a.C0856a.g(lg.a.f68962a, "ActivateAdManager --> consumeActivateAd() --> 广告被消费 --> bestAd = " + f79209b, false, 2, null);
        if (z10 && (psActivateBean = f79209b) != null) {
            PSActivateManager.f42225a.a(psActivateBean);
        }
        f79209b = null;
    }

    public final PsActivateBean e(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (!c(activity)) {
            return null;
        }
        if (f79209b == null) {
            PsActivateBean b11 = PSActivateManager.f42225a.b();
            f79209b = b11;
            if (b11 != null) {
                q();
            }
        }
        return f79209b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g() {
        /*
            r6 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1a
            sm.f$a r2 = sm.f.f75530c     // Catch: java.lang.Throwable -> L1a
            sm.f r2 = r2.a()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "activate_config"
            r4 = 1
            com.transsion.mb.config.manager.ConfigBean r2 = r2.c(r3, r4)     // Catch: java.lang.Throwable -> L1a
            if (r2 == 0) goto L1c
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L1e
            goto L1c
        L1a:
            r2 = move-exception
            goto L37
        L1c:
            java.lang.String r2 = ""
        L1e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "notificationStyleIntervalMinutes"
            long r2 = r3.optLong(r2)     // Catch: java.lang.Throwable -> L1a
            r4 = 60
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L1a
            long r2 = r2 * r4
            long r2 = r2 * r0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r2 = kotlin.Result.m1185constructorimpl(r2)     // Catch: java.lang.Throwable -> L1a
            goto L41
        L37:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.ResultKt.a(r2)
            java.lang.Object r2 = kotlin.Result.m1185constructorimpl(r2)
        L41:
            java.lang.Throwable r3 = kotlin.Result.m1188exceptionOrNullimpl(r2)
            if (r3 != 0) goto L48
            goto L4c
        L48:
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
        L4c:
            java.lang.Number r2 = (java.lang.Number) r2
            long r0 = r2.longValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.g():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "activate_config"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "notificationStyleLimit"
            int r0 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L46
        L41:
            r0 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L46:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.h():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "activate_config"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "notificationStyleOff"
            boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L43
        L41:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L43:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.i():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String j() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1a
            sm.f$a r1 = sm.f.f75530c     // Catch: java.lang.Throwable -> L1a
            sm.f r1 = r1.a()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "activate_config"
            r3 = 1
            com.transsion.mb.config.manager.ConfigBean r1 = r1.c(r2, r3)     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L1c
            java.lang.String r1 = r1.getValue()     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L1d
            goto L1c
        L1a:
            r1 = move-exception
            goto L2d
        L1c:
            r1 = r0
        L1d:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L1a
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r1 = "notificationStyleTitle"
            java.lang.String r1 = r2.optString(r1)     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> L1a
            goto L37
        L2d:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.a(r1)
            java.lang.Object r1 = kotlin.Result.m1185constructorimpl(r1)
        L37:
            java.lang.Throwable r2 = kotlin.Result.m1188exceptionOrNullimpl(r1)
            if (r2 != 0) goto L3e
            r0 = r1
        L3e:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.j():java.lang.String");
    }

    public final boolean k(MemberSource sceneId) {
        Object m1185constructorimpl;
        String value;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.INSTANCE;
            int i11 = C1000a.f79210a[sceneId.ordinal()];
            String str = "";
            String str2 = i11 != 1 ? i11 != 2 ? i11 != 3 ? "" : "activateDialogNoResolutionOff" : "activateDialogTipResolutionOff" : "activateDialogResolutionOff";
            ConfigBean c11 = sm.f.f75530c.a().c("activate_config", true);
            if (c11 != null && (value = c11.getValue()) != null) {
                str = value;
            }
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(new JSONObject(str).optBoolean(str2)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.TRUE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "activate_config"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "installedGuideTipViewAutoCloseTime"
            int r0 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L47
        L41:
            r0 = 10
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L47:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.l():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "activate_config"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "isAutoOpenApp"
            boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L43
        L41:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L43:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.m():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            sm.f$a r0 = sm.f.f75530c     // Catch: java.lang.Throwable -> L18
            sm.f r0 = r0.a()     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "activate_config"
            r2 = 1
            com.transsion.mb.config.manager.ConfigBean r0 = r0.c(r1, r2)     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1a
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L30
        L1a:
            java.lang.String r0 = ""
        L1c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L18
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.String r0 = "isShowInstalledGuideTipView"
            boolean r0 = r1.optBoolean(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L18
            goto L3a
        L30:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        L3a:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto L41
            goto L43
        L41:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L43:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: yx.a.n():boolean");
    }

    public final String o(String text) {
        Intrinsics.h(text, "text");
        if (text.length() <= 10) {
            return text;
        }
        String substring = text.substring(0, 9);
        Intrinsics.g(substring, "substring(...)");
        return substring + "…";
    }

    public final String p(String text, String placeholder, String target) {
        Intrinsics.h(text, "text");
        Intrinsics.h(placeholder, "placeholder");
        Intrinsics.h(target, "target");
        return StringsKt.c0(text, placeholder, false, 2, null) ? StringsKt.Q(text, placeholder, target, false, 4, null) : text;
    }

    public final void q() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("activate_show_date", "");
        p pVar = p.f76389a;
        if (!TextUtils.equals(string, pVar.c())) {
            bVar.b().putString("activate_show_date", pVar.c());
            bVar.b().putInt("activate_show_times", 0);
            a.C0856a.g(lg.a.f68962a, "ActivateAdManager --> showActivateAd() --> 广告展示 --> bestAd = " + f79209b + " --> 日期重置", false, 2, null);
        }
        int i11 = bVar.b().getInt("activate_show_times", 0) + 1;
        bVar.b().putInt("activate_show_times", i11);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bVar.b().putLong("activate_show_timestamp", elapsedRealtime);
        a.C0856a.g(lg.a.f68962a, "ActivateAdManager --> showActivateAd() --> 广告展示 --> bestAd = " + f79209b + " --> cur = " + elapsedRealtime + " --> showTimes = " + i11, false, 2, null);
    }
}
