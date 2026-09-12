package com.transsion.usercenter.devicemanagement.repository;

import android.os.Build;
import com.transsion.usercenter.devicemanagement.model.LinkedDeviceDto;
import ih.b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg.c;

/* loaded from: classes6.dex */
public final class DeviceManagementRepository {

    /* renamed from: b, reason: collision with root package name */
    private static final a f56803b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f56804a = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.devicemanagement.repository.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            hw.a b11;
            b11 = DeviceManagementRepository.b();
            return b11;
        }
    });

    /* loaded from: classes6.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hw.a b() {
        return (hw.a) c.f79537e.a().h(hw.a.class);
    }

    private final hw.a c() {
        return (hw.a) this.f56804a.getValue();
    }

    private final List f() {
        String obj;
        String MODEL = Build.MODEL;
        Intrinsics.g(MODEL, "MODEL");
        String BRAND = Build.BRAND;
        Intrinsics.g(BRAND, "BRAND");
        if (StringsKt.a0(MODEL, BRAND, true)) {
            Intrinsics.g(MODEL, "MODEL");
            obj = StringsKt.n1(MODEL).toString();
        } else {
            obj = StringsKt.n1(BRAND + " " + MODEL).toString();
        }
        return CollectionsKt.e(new LinkedDeviceDto(obj, null, null, b.f65364a.h(), 6, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:11:0x0027, B:12:0x0064, B:14:0x006e, B:21:0x007b, B:29:0x0045, B:31:0x004f, B:33:0x0054), top: B:8:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getLinkedDevicesOrLocal$1
            if (r0 == 0) goto L14
            r0 = r8
            com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getLinkedDevicesOrLocal$1 r0 = (com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getLinkedDevicesOrLocal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getLinkedDevicesOrLocal$1 r0 = new com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getLinkedDevicesOrLocal$1
            r0.<init>(r7, r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Exception -> L2b
            goto L64
        L2b:
            r8 = move-exception
            goto L80
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.b(r8)
            nh.m r8 = nh.m.f70597a
            boolean r8 = r8.e()
            if (r8 != 0) goto L45
            java.util.List r8 = kotlin.collections.CollectionsKt.l()
            return r8
        L45:
            bh.b$a r8 = bh.b.f16553a     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = "{}"
            okhttp3.RequestBody r3 = r8.a(r1)     // Catch: java.lang.Exception -> L2b
            if (r3 != 0) goto L54
            java.util.List r8 = r7.f()     // Catch: java.lang.Exception -> L2b
            return r8
        L54:
            hw.a r1 = r7.c()     // Catch: java.lang.Exception -> L2b
            r4.label = r2     // Catch: java.lang.Exception -> L2b
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = hw.a.C0807a.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L2b
            if (r8 != r0) goto L64
            return r0
        L64:
            com.tn.lib.net.bean.BaseDto r8 = (com.tn.lib.net.bean.BaseDto) r8     // Catch: java.lang.Exception -> L2b
            java.lang.Object r8 = r8.getData()     // Catch: java.lang.Exception -> L2b
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Exception -> L2b
            if (r8 == 0) goto L7b
            r0 = r8
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L2b
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L2b
            if (r0 != 0) goto L78
            goto L79
        L78:
            r8 = 0
        L79:
            if (r8 != 0) goto La3
        L7b:
            java.util.List r8 = r7.f()     // Catch: java.lang.Exception -> L2b
            goto La3
        L80:
            lg.a$a r0 = lg.a.f68962a
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getLinkedDevices failed: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = r1.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "DeviceManagementRepository"
            r3 = 0
            lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)
            java.util.List r8 = r7.f()
        La3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002b, B:13:0x0057, B:15:0x005f, B:17:0x0067, B:22:0x006f, B:27:0x003c, B:31:0x0049), top: B:8:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:12:0x002b, B:13:0x0057, B:15:0x005f, B:17:0x0067, B:22:0x006f, B:27:0x003c, B:31:0x0049), top: B:8:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r8, boolean r9, kotlin.coroutines.Continuation r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getUpgradeRightsWithCache$1
            if (r0 == 0) goto L14
            r0 = r10
            com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getUpgradeRightsWithCache$1 r0 = (com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getUpgradeRightsWithCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getUpgradeRightsWithCache$1 r0 = new com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository$getUpgradeRightsWithCache$1
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r4.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Exception -> L2f
            goto L57
        L2f:
            r9 = move-exception
            goto L82
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.b(r10)
            hw.a r1 = r7.c()     // Catch: java.lang.Exception -> L2f
            if (r9 == 0) goto L46
            java.lang.String r9 = "pro"
        L44:
            r3 = r9
            goto L49
        L46:
            java.lang.String r9 = "basic"
            goto L44
        L49:
            r4.L$0 = r8     // Catch: java.lang.Exception -> L2f
            r4.label = r2     // Catch: java.lang.Exception -> L2f
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r10 = hw.a.C0807a.b(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L2f
            if (r10 != r0) goto L57
            return r0
        L57:
            com.tn.lib.net.bean.BaseDto r10 = (com.tn.lib.net.bean.BaseDto) r10     // Catch: java.lang.Exception -> L2f
            java.lang.Object r9 = r10.getData()     // Catch: java.lang.Exception -> L2f
            if (r9 == 0) goto L6f
            java.lang.Object r9 = r10.getData()     // Catch: java.lang.Exception -> L2f
            com.transsion.usercenter.devicemanagement.model.UpgradeRightsDto r9 = (com.transsion.usercenter.devicemanagement.model.UpgradeRightsDto) r9     // Catch: java.lang.Exception -> L2f
            if (r9 == 0) goto L6d
            iw.b r10 = iw.b.f65783a     // Catch: java.lang.Exception -> L2f
            r10.f(r8, r9)     // Catch: java.lang.Exception -> L2f
            goto La7
        L6d:
            r9 = 0
            goto La7
        L6f:
            lg.a$a r0 = lg.a.f68962a     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = "DeviceManagementRepository"
            java.lang.String r2 = "getUpgradeRights business failed"
            r4 = 4
            r5 = 0
            r3 = 0
            lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2f
            iw.b r9 = iw.b.f65783a     // Catch: java.lang.Exception -> L2f
            com.transsion.usercenter.devicemanagement.model.UpgradeRightsDto r9 = r9.c(r8)     // Catch: java.lang.Exception -> L2f
            goto La7
        L82:
            lg.a$a r0 = lg.a.f68962a
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "getUpgradeRights failed: "
            r10.append(r1)
            r10.append(r9)
            java.lang.String r2 = r10.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "DeviceManagementRepository"
            r3 = 0
            lg.a.C0856a.l(r0, r1, r2, r3, r4, r5)
            iw.b r9 = iw.b.f65783a
            com.transsion.usercenter.devicemanagement.model.UpgradeRightsDto r9 = r9.c(r8)
        La7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.devicemanagement.repository.DeviceManagementRepository.e(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
