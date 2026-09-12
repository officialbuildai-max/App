package com.permissionx.guolindev.request;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.a;
import androidx.activity.result.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import be.g;
import cf.e;
import cf.o0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.permissionx.guolindev.dialog.RationaleDialog;
import com.permissionx.guolindev.request.InvisibleFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import f.h;
import f.i;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ye.c;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b%\u0010$J\u001d\u0010&\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b&\u0010$J\u001d\u0010'\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b'\u0010$J\u001f\u0010(\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b(\u0010$J\u001d\u0010)\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b)\u0010$J\u001d\u0010*\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b*\u0010$J\u001d\u0010+\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b+\u0010$J\u001d\u0010,\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b,\u0010$J\r\u0010-\u001a\u00020\b¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b.\u0010\u0003R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R.\u0010>\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 ;*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:0:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00050\u0005098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\"\u0010C\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010=R\"\u0010E\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010=R\"\u0010G\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010=R\"\u0010I\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010=R\"\u0010K\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010=R\"\u0010M\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010=R\"\u0010O\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010\u00050\u0005098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010=R\"\u0010Q\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010A0A098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010=¨\u0006R"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "", "", "grantResults", "", "H0", "(Ljava/util/Map;)V", "granted", "z0", "(Z)V", "M0", "N0", "F0", "D0", "I0", "K0", "B0", "w0", "()Z", "Lkotlin/Function0;", "callback", "P0", "(Lkotlin/jvm/functions/Function0;)V", "Lcf/o0;", "permissionBuilder", "", "permissions", "Lcf/e;", "chainTask", "i1", "(Lcf/o0;Ljava/util/Set;Lcf/e;)V", "s1", "(Lcf/o0;Lcf/e;)V", "R0", "o1", "r1", "c1", "Z0", "h1", "l1", "W0", "x0", "onDestroy", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcf/o0;", "pb", "c", "Lcf/e;", "task", "Landroidx/activity/result/b;", "", "kotlin.jvm.PlatformType", "d", "Landroidx/activity/result/b;", "requestNormalPermissionLauncher", "e", "requestBackgroundLocationLauncher", "Landroid/content/Intent;", "f", "requestSystemAlertWindowLauncher", g.f16474b, "requestWriteSettingsLauncher", "h", "requestManageExternalStorageLauncher", "i", "requestInstallPackagesLauncher", j.f35620b, "requestNotificationLauncher", CampaignEx.JSON_KEY_AD_K, "requestPipLauncher", "l", "requestBodySensorsBackgroundLauncher", "m", "forwardToSettingsLauncher", "PermissionX_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class InvisibleFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private o0 pb;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private e task;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b requestNormalPermissionLauncher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b requestBackgroundLocationLauncher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b requestSystemAlertWindowLauncher;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final b requestWriteSettingsLauncher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b requestManageExternalStorageLauncher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final b requestInstallPackagesLauncher;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final b requestNotificationLauncher;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final b requestPipLauncher;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final b requestBodySensorsBackgroundLauncher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b forwardToSettingsLauncher;

    public InvisibleFragment() {
        b registerForActivityResult = registerForActivityResult(new h(), new a() { // from class: cf.i
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.d1(InvisibleFragment.this, (Map) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.requestNormalPermissionLauncher = registerForActivityResult;
        b registerForActivityResult2 = registerForActivityResult(new i(), new a() { // from class: cf.t
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.S0(InvisibleFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.g(registerForActivityResult2, "registerForActivityResult(...)");
        this.requestBackgroundLocationLauncher = registerForActivityResult2;
        b registerForActivityResult3 = registerForActivityResult(new f.j(), new a() { // from class: cf.b0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.m1(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult3, "registerForActivityResult(...)");
        this.requestSystemAlertWindowLauncher = registerForActivityResult3;
        b registerForActivityResult4 = registerForActivityResult(new f.j(), new a() { // from class: cf.c0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.p1(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult4, "registerForActivityResult(...)");
        this.requestWriteSettingsLauncher = registerForActivityResult4;
        b registerForActivityResult5 = registerForActivityResult(new f.j(), new a() { // from class: cf.d0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.a1(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult5, "registerForActivityResult(...)");
        this.requestManageExternalStorageLauncher = registerForActivityResult5;
        b registerForActivityResult6 = registerForActivityResult(new f.j(), new a() { // from class: cf.e0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.X0(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult6, "registerForActivityResult(...)");
        this.requestInstallPackagesLauncher = registerForActivityResult6;
        b registerForActivityResult7 = registerForActivityResult(new f.j(), new a() { // from class: cf.f0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.f1(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult7, "registerForActivityResult(...)");
        this.requestNotificationLauncher = registerForActivityResult7;
        b registerForActivityResult8 = registerForActivityResult(new f.j(), new a() { // from class: cf.g0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.j1(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult8, "registerForActivityResult(...)");
        this.requestPipLauncher = registerForActivityResult8;
        b registerForActivityResult9 = registerForActivityResult(new i(), new a() { // from class: cf.h0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.U0(InvisibleFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.g(registerForActivityResult9, "registerForActivityResult(...)");
        this.requestBodySensorsBackgroundLauncher = registerForActivityResult9;
        b registerForActivityResult10 = registerForActivityResult(new f.j(), new a() { // from class: cf.i0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                InvisibleFragment.y0(InvisibleFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult10, "registerForActivityResult(...)");
        this.forwardToSettingsLauncher = registerForActivityResult10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        if (r6.f17278h == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit A0(boolean r6, com.permissionx.guolindev.request.InvisibleFragment r7) {
        /*
            java.lang.String r0 = "task"
            java.lang.String r1 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            java.lang.String r2 = "pb"
            r3 = 0
            if (r6 == 0) goto L3e
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L11
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L11:
            java.util.Set r6 = r6.f17280j
            r6.add(r1)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L1e
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L1e:
            java.util.Set r6 = r6.f17281k
            r6.remove(r1)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L2b
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L2b:
            java.util.Set r6 = r6.f17282l
            r6.remove(r1)
            cf.e r6 = r7.task
            if (r6 != 0) goto L38
            kotlin.jvm.internal.Intrinsics.z(r0)
            goto L39
        L38:
            r3 = r6
        L39:
            r3.finish()
            goto Lca
        L3e:
            boolean r6 = r7.shouldShowRequestPermissionRationale(r1)
            cf.o0 r4 = r7.pb
            if (r4 != 0) goto L4a
            kotlin.jvm.internal.Intrinsics.z(r2)
            r4 = r3
        L4a:
            r4.getClass()
            cf.o0 r4 = r7.pb
            if (r4 != 0) goto L55
            kotlin.jvm.internal.Intrinsics.z(r2)
            r4 = r3
        L55:
            ze.b r4 = r4.f17287q
            if (r4 == 0) goto Lb3
            if (r6 == 0) goto Lb3
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r1)
            cf.o0 r1 = r7.pb
            if (r1 != 0) goto L6b
            kotlin.jvm.internal.Intrinsics.z(r2)
            r1 = r3
        L6b:
            ze.b r1 = r1.f17287q
            if (r1 == 0) goto L99
            cf.o0 r1 = r7.pb
            if (r1 != 0) goto L77
            kotlin.jvm.internal.Intrinsics.z(r2)
            r1 = r3
        L77:
            ze.b r1 = r1.f17287q
            kotlin.jvm.internal.Intrinsics.e(r1)
            cf.e r4 = r7.task
            if (r4 != 0) goto L84
            kotlin.jvm.internal.Intrinsics.z(r0)
            r4 = r3
        L84:
            cf.f r4 = r4.b()
            r5 = 0
            r1.a(r4, r6, r5, r5)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L94
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L94:
            boolean r6 = r6.f17278h
            if (r6 != 0) goto Lca
            goto Lbe
        L99:
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto La1
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        La1:
            r6.getClass()
            kotlin.jvm.internal.Intrinsics.e(r3)
            cf.e r6 = r7.task
            if (r6 != 0) goto Laf
            kotlin.jvm.internal.Intrinsics.z(r0)
            r6 = r3
        Laf:
            r6.b()
            throw r3
        Lb3:
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        Lbb:
            r6.getClass()
        Lbe:
            cf.e r6 = r7.task
            if (r6 != 0) goto Lc6
            kotlin.jvm.internal.Intrinsics.z(r0)
            goto Lc7
        Lc6:
            r3 = r6
        Lc7:
            r3.finish()
        Lca:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.A0(boolean, com.permissionx.guolindev.request.InvisibleFragment):kotlin.Unit");
    }

    private final void B0(final boolean granted) {
        if (w0()) {
            P0(new Function0() { // from class: cf.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit C0;
                    C0 = InvisibleFragment.C0(granted, this);
                    return C0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        if (r6.f17278h == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit C0(boolean r6, com.permissionx.guolindev.request.InvisibleFragment r7) {
        /*
            java.lang.String r0 = "task"
            java.lang.String r1 = "android.permission.BODY_SENSORS_BACKGROUND"
            java.lang.String r2 = "pb"
            r3 = 0
            if (r6 == 0) goto L3e
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L11
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L11:
            java.util.Set r6 = r6.f17280j
            r6.add(r1)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L1e
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L1e:
            java.util.Set r6 = r6.f17281k
            r6.remove(r1)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L2b
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L2b:
            java.util.Set r6 = r6.f17282l
            r6.remove(r1)
            cf.e r6 = r7.task
            if (r6 != 0) goto L38
            kotlin.jvm.internal.Intrinsics.z(r0)
            goto L39
        L38:
            r3 = r6
        L39:
            r3.finish()
            goto Lca
        L3e:
            boolean r6 = r7.shouldShowRequestPermissionRationale(r1)
            cf.o0 r4 = r7.pb
            if (r4 != 0) goto L4a
            kotlin.jvm.internal.Intrinsics.z(r2)
            r4 = r3
        L4a:
            r4.getClass()
            cf.o0 r4 = r7.pb
            if (r4 != 0) goto L55
            kotlin.jvm.internal.Intrinsics.z(r2)
            r4 = r3
        L55:
            ze.b r4 = r4.f17287q
            if (r4 == 0) goto Lb3
            if (r6 == 0) goto Lb3
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r1)
            cf.o0 r1 = r7.pb
            if (r1 != 0) goto L6b
            kotlin.jvm.internal.Intrinsics.z(r2)
            r1 = r3
        L6b:
            ze.b r1 = r1.f17287q
            if (r1 == 0) goto L99
            cf.o0 r1 = r7.pb
            if (r1 != 0) goto L77
            kotlin.jvm.internal.Intrinsics.z(r2)
            r1 = r3
        L77:
            ze.b r1 = r1.f17287q
            kotlin.jvm.internal.Intrinsics.e(r1)
            cf.e r4 = r7.task
            if (r4 != 0) goto L84
            kotlin.jvm.internal.Intrinsics.z(r0)
            r4 = r3
        L84:
            cf.f r4 = r4.b()
            r5 = 0
            r1.a(r4, r6, r5, r5)
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto L94
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        L94:
            boolean r6 = r6.f17278h
            if (r6 != 0) goto Lca
            goto Lbe
        L99:
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto La1
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        La1:
            r6.getClass()
            kotlin.jvm.internal.Intrinsics.e(r3)
            cf.e r6 = r7.task
            if (r6 != 0) goto Laf
            kotlin.jvm.internal.Intrinsics.z(r0)
            r6 = r3
        Laf:
            r6.b()
            throw r3
        Lb3:
            cf.o0 r6 = r7.pb
            if (r6 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.z(r2)
            r6 = r3
        Lbb:
            r6.getClass()
        Lbe:
            cf.e r6 = r7.task
            if (r6 != 0) goto Lc6
            kotlin.jvm.internal.Intrinsics.z(r0)
            goto Lc7
        Lc6:
            r3 = r6
        Lc7:
            r3.finish()
        Lca:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.C0(boolean, com.permissionx.guolindev.request.InvisibleFragment):kotlin.Unit");
    }

    private final void D0() {
        if (w0()) {
            P0(new Function0() { // from class: cf.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit E0;
                    E0 = InvisibleFragment.E0(InvisibleFragment.this);
                    return E0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(InvisibleFragment invisibleFragment) {
        boolean canRequestPackageInstalls;
        e eVar = null;
        if (Build.VERSION.SDK_INT >= 26) {
            canRequestPackageInstalls = invisibleFragment.requireActivity().getPackageManager().canRequestPackageInstalls();
            if (canRequestPackageInstalls) {
                e eVar2 = invisibleFragment.task;
                if (eVar2 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar2;
                }
                eVar.finish();
            } else {
                o0 o0Var = invisibleFragment.pb;
                if (o0Var == null) {
                    Intrinsics.z("pb");
                    o0Var = null;
                }
                o0Var.getClass();
                o0 o0Var2 = invisibleFragment.pb;
                if (o0Var2 == null) {
                    Intrinsics.z("pb");
                    o0Var2 = null;
                }
                if (o0Var2.f17287q != null) {
                    o0 o0Var3 = invisibleFragment.pb;
                    if (o0Var3 == null) {
                        Intrinsics.z("pb");
                        o0Var3 = null;
                    }
                    if (o0Var3.f17287q == null) {
                        o0 o0Var4 = invisibleFragment.pb;
                        if (o0Var4 == null) {
                            Intrinsics.z("pb");
                            o0Var4 = null;
                        }
                        o0Var4.getClass();
                        Intrinsics.e(null);
                        e eVar3 = invisibleFragment.task;
                        if (eVar3 == null) {
                            Intrinsics.z("task");
                            eVar3 = null;
                        }
                        eVar3.b();
                        CollectionsKt.e("android.permission.REQUEST_INSTALL_PACKAGES");
                        throw null;
                    }
                    o0 o0Var5 = invisibleFragment.pb;
                    if (o0Var5 == null) {
                        Intrinsics.z("pb");
                        o0Var5 = null;
                    }
                    ze.b bVar = o0Var5.f17287q;
                    Intrinsics.e(bVar);
                    e eVar4 = invisibleFragment.task;
                    if (eVar4 == null) {
                        Intrinsics.z("task");
                    } else {
                        eVar = eVar4;
                    }
                    bVar.a(eVar.b(), CollectionsKt.e("android.permission.REQUEST_INSTALL_PACKAGES"), false, false);
                }
            }
        } else {
            e eVar5 = invisibleFragment.task;
            if (eVar5 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar5;
            }
            eVar.finish();
        }
        return Unit.f67184a;
    }

    private final void F0() {
        if (w0()) {
            P0(new Function0() { // from class: cf.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit G0;
                    G0 = InvisibleFragment.G0(InvisibleFragment.this);
                    return G0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(InvisibleFragment invisibleFragment) {
        boolean isExternalStorageManager;
        e eVar = null;
        if (Build.VERSION.SDK_INT >= 30) {
            isExternalStorageManager = Environment.isExternalStorageManager();
            if (isExternalStorageManager) {
                e eVar2 = invisibleFragment.task;
                if (eVar2 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar2;
                }
                eVar.finish();
            } else {
                o0 o0Var = invisibleFragment.pb;
                if (o0Var == null) {
                    Intrinsics.z("pb");
                    o0Var = null;
                }
                o0Var.getClass();
                o0 o0Var2 = invisibleFragment.pb;
                if (o0Var2 == null) {
                    Intrinsics.z("pb");
                    o0Var2 = null;
                }
                if (o0Var2.f17287q != null) {
                    o0 o0Var3 = invisibleFragment.pb;
                    if (o0Var3 == null) {
                        Intrinsics.z("pb");
                        o0Var3 = null;
                    }
                    if (o0Var3.f17287q == null) {
                        o0 o0Var4 = invisibleFragment.pb;
                        if (o0Var4 == null) {
                            Intrinsics.z("pb");
                            o0Var4 = null;
                        }
                        o0Var4.getClass();
                        Intrinsics.e(null);
                        e eVar3 = invisibleFragment.task;
                        if (eVar3 == null) {
                            Intrinsics.z("task");
                            eVar3 = null;
                        }
                        eVar3.b();
                        CollectionsKt.e("android.permission.MANAGE_EXTERNAL_STORAGE");
                        throw null;
                    }
                    o0 o0Var5 = invisibleFragment.pb;
                    if (o0Var5 == null) {
                        Intrinsics.z("pb");
                        o0Var5 = null;
                    }
                    ze.b bVar = o0Var5.f17287q;
                    Intrinsics.e(bVar);
                    e eVar4 = invisibleFragment.task;
                    if (eVar4 == null) {
                        Intrinsics.z("task");
                    } else {
                        eVar = eVar4;
                    }
                    bVar.a(eVar.b(), CollectionsKt.e("android.permission.MANAGE_EXTERNAL_STORAGE"), false, false);
                }
            }
        } else {
            e eVar5 = invisibleFragment.task;
            if (eVar5 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar5;
            }
            eVar.finish();
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x027b, code lost:
    
        if (r9.f17278h == false) goto L176;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H0(java.util.Map r9) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.permissionx.guolindev.request.InvisibleFragment.H0(java.util.Map):void");
    }

    private final void I0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !w0()) {
            return;
        }
        P0(new Function0() { // from class: cf.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit J0;
                J0 = InvisibleFragment.J0(FragmentActivity.this, this);
                return J0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(FragmentActivity fragmentActivity, InvisibleFragment invisibleFragment) {
        e eVar = null;
        if (Build.VERSION.SDK_INT < 26) {
            e eVar2 = invisibleFragment.task;
            if (eVar2 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar2;
            }
            eVar.finish();
        } else if (c.f79116a.b(fragmentActivity)) {
            e eVar3 = invisibleFragment.task;
            if (eVar3 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar3;
            }
            eVar.finish();
        } else {
            o0 o0Var = invisibleFragment.pb;
            if (o0Var == null) {
                Intrinsics.z("pb");
                o0Var = null;
            }
            o0Var.getClass();
            o0 o0Var2 = invisibleFragment.pb;
            if (o0Var2 == null) {
                Intrinsics.z("pb");
                o0Var2 = null;
            }
            if (o0Var2.f17287q != null) {
                o0 o0Var3 = invisibleFragment.pb;
                if (o0Var3 == null) {
                    Intrinsics.z("pb");
                    o0Var3 = null;
                }
                if (o0Var3.f17287q == null) {
                    o0 o0Var4 = invisibleFragment.pb;
                    if (o0Var4 == null) {
                        Intrinsics.z("pb");
                        o0Var4 = null;
                    }
                    o0Var4.getClass();
                    Intrinsics.e(null);
                    e eVar4 = invisibleFragment.task;
                    if (eVar4 == null) {
                        Intrinsics.z("task");
                        eVar4 = null;
                    }
                    eVar4.b();
                    CollectionsKt.e("android.permission.POST_NOTIFICATIONS");
                    throw null;
                }
                o0 o0Var5 = invisibleFragment.pb;
                if (o0Var5 == null) {
                    Intrinsics.z("pb");
                    o0Var5 = null;
                }
                ze.b bVar = o0Var5.f17287q;
                Intrinsics.e(bVar);
                e eVar5 = invisibleFragment.task;
                if (eVar5 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar5;
                }
                bVar.a(eVar.b(), CollectionsKt.e("android.permission.POST_NOTIFICATIONS"), false, false);
            }
        }
        return Unit.f67184a;
    }

    private final void K0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !w0()) {
            return;
        }
        P0(new Function0() { // from class: cf.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit L0;
                L0 = InvisibleFragment.L0(FragmentActivity.this, this);
                return L0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(FragmentActivity fragmentActivity, InvisibleFragment invisibleFragment) {
        e eVar = null;
        if (Build.VERSION.SDK_INT < 26) {
            e eVar2 = invisibleFragment.task;
            if (eVar2 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar2;
            }
            eVar.finish();
        } else if (c.f79116a.c(fragmentActivity)) {
            e eVar3 = invisibleFragment.task;
            if (eVar3 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar3;
            }
            eVar.finish();
        } else {
            o0 o0Var = invisibleFragment.pb;
            if (o0Var == null) {
                Intrinsics.z("pb");
                o0Var = null;
            }
            o0Var.getClass();
            o0 o0Var2 = invisibleFragment.pb;
            if (o0Var2 == null) {
                Intrinsics.z("pb");
                o0Var2 = null;
            }
            if (o0Var2.f17287q != null) {
                o0 o0Var3 = invisibleFragment.pb;
                if (o0Var3 == null) {
                    Intrinsics.z("pb");
                    o0Var3 = null;
                }
                if (o0Var3.f17287q == null) {
                    o0 o0Var4 = invisibleFragment.pb;
                    if (o0Var4 == null) {
                        Intrinsics.z("pb");
                        o0Var4 = null;
                    }
                    o0Var4.getClass();
                    Intrinsics.e(null);
                    e eVar4 = invisibleFragment.task;
                    if (eVar4 == null) {
                        Intrinsics.z("task");
                        eVar4 = null;
                    }
                    eVar4.b();
                    CollectionsKt.e("android.permission.PICTURE_IN_PICTURE");
                    throw null;
                }
                o0 o0Var5 = invisibleFragment.pb;
                if (o0Var5 == null) {
                    Intrinsics.z("pb");
                    o0Var5 = null;
                }
                ze.b bVar = o0Var5.f17287q;
                Intrinsics.e(bVar);
                e eVar5 = invisibleFragment.task;
                if (eVar5 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar5;
                }
                bVar.a(eVar.b(), CollectionsKt.e("android.permission.PICTURE_IN_PICTURE"), false, true);
            }
        }
        return Unit.f67184a;
    }

    private final void M0() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !w0()) {
            return;
        }
        e eVar = null;
        if (Settings.canDrawOverlays(activity)) {
            e eVar2 = this.task;
            if (eVar2 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar2;
            }
            eVar.finish();
            return;
        }
        o0 o0Var = this.pb;
        if (o0Var == null) {
            Intrinsics.z("pb");
            o0Var = null;
        }
        o0Var.getClass();
        o0 o0Var2 = this.pb;
        if (o0Var2 == null) {
            Intrinsics.z("pb");
            o0Var2 = null;
        }
        if (o0Var2.f17287q != null) {
            o0 o0Var3 = this.pb;
            if (o0Var3 == null) {
                Intrinsics.z("pb");
                o0Var3 = null;
            }
            if (o0Var3.f17287q != null) {
                o0 o0Var4 = this.pb;
                if (o0Var4 == null) {
                    Intrinsics.z("pb");
                    o0Var4 = null;
                }
                ze.b bVar = o0Var4.f17287q;
                Intrinsics.e(bVar);
                e eVar3 = this.task;
                if (eVar3 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar3;
                }
                bVar.a(eVar.b(), CollectionsKt.e("android.permission.SYSTEM_ALERT_WINDOW"), false, false);
                return;
            }
            o0 o0Var5 = this.pb;
            if (o0Var5 == null) {
                Intrinsics.z("pb");
                o0Var5 = null;
            }
            o0Var5.getClass();
            Intrinsics.e(null);
            e eVar4 = this.task;
            if (eVar4 == null) {
                Intrinsics.z("task");
                eVar4 = null;
            }
            eVar4.b();
            CollectionsKt.e("android.permission.SYSTEM_ALERT_WINDOW");
            throw null;
        }
    }

    private final void N0() {
        final FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !w0()) {
            return;
        }
        P0(new Function0() { // from class: cf.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit O0;
                O0 = InvisibleFragment.O0(FragmentActivity.this, this);
                return O0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(FragmentActivity fragmentActivity, InvisibleFragment invisibleFragment) {
        e eVar = null;
        if (Settings.System.canWrite(fragmentActivity)) {
            e eVar2 = invisibleFragment.task;
            if (eVar2 == null) {
                Intrinsics.z("task");
            } else {
                eVar = eVar2;
            }
            eVar.finish();
        } else {
            o0 o0Var = invisibleFragment.pb;
            if (o0Var == null) {
                Intrinsics.z("pb");
                o0Var = null;
            }
            o0Var.getClass();
            o0 o0Var2 = invisibleFragment.pb;
            if (o0Var2 == null) {
                Intrinsics.z("pb");
                o0Var2 = null;
            }
            if (o0Var2.f17287q != null) {
                o0 o0Var3 = invisibleFragment.pb;
                if (o0Var3 == null) {
                    Intrinsics.z("pb");
                    o0Var3 = null;
                }
                if (o0Var3.f17287q == null) {
                    o0 o0Var4 = invisibleFragment.pb;
                    if (o0Var4 == null) {
                        Intrinsics.z("pb");
                        o0Var4 = null;
                    }
                    o0Var4.getClass();
                    Intrinsics.e(null);
                    e eVar3 = invisibleFragment.task;
                    if (eVar3 == null) {
                        Intrinsics.z("task");
                        eVar3 = null;
                    }
                    eVar3.b();
                    CollectionsKt.e("android.permission.WRITE_SETTINGS");
                    throw null;
                }
                o0 o0Var5 = invisibleFragment.pb;
                if (o0Var5 == null) {
                    Intrinsics.z("pb");
                    o0Var5 = null;
                }
                ze.b bVar = o0Var5.f17287q;
                Intrinsics.e(bVar);
                e eVar4 = invisibleFragment.task;
                if (eVar4 == null) {
                    Intrinsics.z("task");
                } else {
                    eVar = eVar4;
                }
                bVar.a(eVar.b(), CollectionsKt.e("android.permission.WRITE_SETTINGS"), false, false);
            }
        }
        return Unit.f67184a;
    }

    private final void P0(final Function0 callback) {
        this.handler.post(new Runnable() { // from class: cf.s
            @Override // java.lang.Runnable
            public final void run() {
                InvisibleFragment.Q0(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(final InvisibleFragment invisibleFragment, final Boolean granted) {
        Intrinsics.h(granted, "granted");
        invisibleFragment.P0(new Function0() { // from class: cf.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit T0;
                T0 = InvisibleFragment.T0(InvisibleFragment.this, granted);
                return T0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(InvisibleFragment invisibleFragment, Boolean bool) {
        Intrinsics.e(bool);
        invisibleFragment.z0(bool.booleanValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(final InvisibleFragment invisibleFragment, final Boolean granted) {
        Intrinsics.h(granted, "granted");
        invisibleFragment.P0(new Function0() { // from class: cf.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit V0;
                V0 = InvisibleFragment.V0(InvisibleFragment.this, granted);
                return V0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(InvisibleFragment invisibleFragment, Boolean bool) {
        Intrinsics.e(bool);
        invisibleFragment.B0(bool.booleanValue());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit Y0;
                Y0 = InvisibleFragment.Y0(InvisibleFragment.this);
                return Y0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(InvisibleFragment invisibleFragment) {
        invisibleFragment.D0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit b12;
                b12 = InvisibleFragment.b1(InvisibleFragment.this);
                return b12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(InvisibleFragment invisibleFragment) {
        invisibleFragment.F0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(final InvisibleFragment invisibleFragment, final Map grantResults) {
        Intrinsics.h(grantResults, "grantResults");
        invisibleFragment.P0(new Function0() { // from class: cf.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e12;
                e12 = InvisibleFragment.e1(InvisibleFragment.this, grantResults);
                return e12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(InvisibleFragment invisibleFragment, Map map) {
        Intrinsics.e(map);
        invisibleFragment.H0(map);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g12;
                g12 = InvisibleFragment.g1(InvisibleFragment.this);
                return g12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(InvisibleFragment invisibleFragment) {
        invisibleFragment.I0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit k12;
                k12 = InvisibleFragment.k1(InvisibleFragment.this);
                return k12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(InvisibleFragment invisibleFragment) {
        invisibleFragment.K0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit n12;
                n12 = InvisibleFragment.n1(InvisibleFragment.this);
                return n12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(InvisibleFragment invisibleFragment) {
        invisibleFragment.M0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(final InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        invisibleFragment.P0(new Function0() { // from class: cf.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit q12;
                q12 = InvisibleFragment.q1(InvisibleFragment.this);
                return q12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(InvisibleFragment invisibleFragment) {
        invisibleFragment.N0();
        return Unit.f67184a;
    }

    private final boolean w0() {
        if (this.pb != null && this.task != null && getContext() != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(InvisibleFragment invisibleFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (invisibleFragment.w0()) {
            e eVar = invisibleFragment.task;
            o0 o0Var = null;
            if (eVar == null) {
                Intrinsics.z("task");
                eVar = null;
            }
            o0 o0Var2 = invisibleFragment.pb;
            if (o0Var2 == null) {
                Intrinsics.z("pb");
            } else {
                o0Var = o0Var2;
            }
            eVar.a(new ArrayList(o0Var.f17285o));
        }
    }

    private final void z0(final boolean granted) {
        if (w0()) {
            P0(new Function0() { // from class: cf.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit A0;
                    A0 = InvisibleFragment.A0(granted, this);
                    return A0;
                }
            });
        }
    }

    public final void R0(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        this.requestBackgroundLocationLauncher.a("android.permission.ACCESS_BACKGROUND_LOCATION");
    }

    public final void W0(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        this.requestBodySensorsBackgroundLauncher.a("android.permission.BODY_SENSORS_BACKGROUND");
    }

    public final void Z0(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            D0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestWriteSettingsLauncher.a(intent);
        } catch (Throwable unused) {
            D0();
        }
    }

    public final void c1(o0 permissionBuilder, e chainTask) {
        boolean isExternalStorageManager;
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT >= 30) {
            isExternalStorageManager = Environment.isExternalStorageManager();
            if (!isExternalStorageManager) {
                try {
                    Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                    intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
                    if (intent.resolveActivity(requireActivity().getPackageManager()) == null) {
                        intent = new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION");
                        if (intent.resolveActivity(requireActivity().getPackageManager()) == null) {
                            F0();
                            return;
                        }
                    }
                    this.requestManageExternalStorageLauncher.a(intent);
                    return;
                } catch (Throwable unused) {
                    F0();
                    return;
                }
            }
        }
        F0();
    }

    public final void h1(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            D0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireActivity().getPackageName());
            this.requestNotificationLauncher.a(intent);
        } catch (Throwable unused) {
            D0();
        }
    }

    public final void i1(o0 permissionBuilder, Set permissions, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        this.requestNormalPermissionLauncher.a(permissions.toArray(new String[0]));
    }

    public final void l1(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Build.VERSION.SDK_INT < 26) {
            K0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            Context context = getContext();
            intent.setData(Uri.fromParts("package", context != null ? context.getPackageName() : null, null));
            this.requestPipLauncher.a(intent);
        } catch (Throwable unused) {
            K0();
        }
    }

    public final void o1(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Settings.canDrawOverlays(activity)) {
            M0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestSystemAlertWindowLauncher.a(intent);
        } catch (Throwable unused) {
            M0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (w0()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                o0 o0Var = this.pb;
                Unit unit = null;
                if (o0Var == null) {
                    Intrinsics.z("pb");
                    o0Var = null;
                }
                RationaleDialog rationaleDialog = o0Var.f17274d;
                if (rationaleDialog != null) {
                    rationaleDialog.dismissAllowingStateLoss();
                    unit = Unit.f67184a;
                }
                Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void r1(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.pb = permissionBuilder;
        this.task = chainTask;
        if (Settings.System.canWrite(activity)) {
            N0();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + requireActivity().getPackageName()));
            this.requestWriteSettingsLauncher.a(intent);
        } catch (Throwable unused) {
            N0();
        }
    }

    public final void s1(o0 permissionBuilder, e chainTask) {
        Intrinsics.h(permissionBuilder, "permissionBuilder");
        Intrinsics.h(chainTask, "chainTask");
        this.pb = permissionBuilder;
        this.task = chainTask;
    }

    public final void x0() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
            this.forwardToSettingsLauncher.a(intent);
        } catch (Throwable unused) {
        }
    }
}
