package com.transsion.commercialization.pslink;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.component_api_ps.ipc.constants.MiniAppIpcConfig;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ky.a;
import ky.b;

/* loaded from: classes5.dex */
public final class PsLinkServiceHelper {

    /* renamed from: b, reason: collision with root package name */
    private static ky.b f43879b;

    /* renamed from: d, reason: collision with root package name */
    private static long f43881d;

    /* renamed from: a, reason: collision with root package name */
    public static final PsLinkServiceHelper f43878a = new PsLinkServiceHelper();

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArrayList f43880c = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private static final ServiceConnection f43882e = new a();

    /* loaded from: classes5.dex */
    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.h(componentName, "componentName");
            Intrinsics.h(iBinder, "iBinder");
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f43883a;
            PsLinkServiceHelper psLinkServiceHelper = PsLinkServiceHelper.f43878a;
            aVar.a(psLinkServiceHelper.j() + " --> onServiceConnected() --> 连接成功 --> componentName = " + componentName);
            psLinkServiceHelper.l(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.h(componentName, "componentName");
            com.transsion.commercialization.pslink.a.f43883a.b(PsLinkServiceHelper.f43878a.j() + " --> onServiceDisconnected() --> 断开连接 --> componentName = " + componentName);
            PsLinkServiceHelper.f43879b = null;
            PsLinkInstallReceiver.INSTANCE.d();
        }
    }

    private PsLinkServiceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = PsLinkServiceHelper.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(IBinder iBinder) {
        Object m1185constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            ky.b Y0 = b.a.Y0(iBinder);
            f43879b = Y0;
            if (Y0 != null) {
                Y0.c0(new a.AbstractBinderC0846a() { // from class: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1
                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
                    
                        if (r9.equals("onAction") == false) goto L21;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
                    
                        if (r9.equals("addTask") != false) goto L17;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
                    
                        if (r9.equals("onProgress") == false) goto L21;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:5:0x004a, code lost:
                    
                        r0 = com.blankj.utilcode.util.o.e(r10, new com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1().getType());
                        r3 = (com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo) r0;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:6:0x005a, code lost:
                    
                        if (r3 == null) goto L20;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x005c, code lost:
                    
                        r2 = r3.getPkgName();
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0060, code lost:
                    
                        r7 = r2;
                        r2 = r0;
                        r0 = r7;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // ky.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public void N0(java.lang.String r9, java.lang.String r10) {
                        /*
                            r8 = this;
                            java.lang.String r0 = "callBackName"
                            kotlin.jvm.internal.Intrinsics.h(r9, r0)
                            java.lang.String r0 = "param"
                            kotlin.jvm.internal.Intrinsics.h(r10, r0)
                            int r0 = r9.hashCode()
                            java.lang.String r1 = "onProgress"
                            r2 = 0
                            switch(r0) {
                                case -1148589626: goto L42;
                                case 975459573: goto L39;
                                case 1098563625: goto L1c;
                                case 1768875308: goto L15;
                                default: goto L14;
                            }
                        L14:
                            goto L64
                        L15:
                            boolean r0 = r9.equals(r1)
                            if (r0 != 0) goto L4a
                            goto L64
                        L1c:
                            java.lang.String r0 = "removeTask"
                            boolean r0 = r9.equals(r0)
                            if (r0 != 0) goto L25
                            goto L64
                        L25:
                            com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$info$1 r0 = new com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$info$1
                            r0.<init>()
                            java.lang.reflect.Type r0 = r0.getType()
                            java.lang.Object r0 = com.blankj.utilcode.util.o.e(r10, r0)
                            com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo r0 = (com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo) r0
                            java.lang.String r0 = r0.getPkgName()
                            goto L66
                        L39:
                            java.lang.String r0 = "onAction"
                            boolean r0 = r9.equals(r0)
                            if (r0 != 0) goto L4a
                            goto L64
                        L42:
                            java.lang.String r0 = "addTask"
                            boolean r0 = r9.equals(r0)
                            if (r0 == 0) goto L64
                        L4a:
                            com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1 r0 = new com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1$callBackCommon$1
                            r0.<init>()
                            java.lang.reflect.Type r0 = r0.getType()
                            java.lang.Object r0 = com.blankj.utilcode.util.o.e(r10, r0)
                            r3 = r0
                            com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo r3 = (com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo) r3
                            if (r3 == 0) goto L60
                            java.lang.String r2 = r3.getPkgName()
                        L60:
                            r7 = r2
                            r2 = r0
                            r0 = r7
                            goto L66
                        L64:
                            java.lang.String r0 = ""
                        L66:
                            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r9, r1)
                            if (r1 == 0) goto L7c
                            long r3 = java.lang.System.currentTimeMillis()
                            long r5 = com.transsion.commercialization.pslink.PsLinkServiceHelper.b()
                            long r3 = r3 - r5
                            r5 = 1000(0x3e8, double:4.94E-321)
                            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                            if (r1 >= 0) goto L7c
                            return
                        L7c:
                            com.transsion.commercialization.pslink.PsLinkServiceHelper r1 = com.transsion.commercialization.pslink.PsLinkServiceHelper.f43878a
                            long r3 = java.lang.System.currentTimeMillis()
                            com.transsion.commercialization.pslink.PsLinkServiceHelper.e(r3)
                            java.util.concurrent.CopyOnWriteArrayList r1 = com.transsion.commercialization.pslink.PsLinkServiceHelper.c()
                            java.util.Iterator r1 = r1.iterator()
                        L8d:
                            boolean r3 = r1.hasNext()
                            if (r3 == 0) goto La0
                            java.lang.Object r3 = r1.next()
                            com.transsion.commercialization.pslink.b r3 = (com.transsion.commercialization.pslink.b) r3
                            r4 = r2
                            com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo r4 = (com.transsnet.launcherlib.PalmStoreDownLoadTaskInfo) r4
                            r3.a(r9, r10, r4, r0)
                            goto L8d
                        La0:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.transsion.commercialization.pslink.PsLinkServiceHelper$register$1$1.N0(java.lang.String, java.lang.String):void");
                    }
                }, "Moviebox");
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        com.transsion.commercialization.pslink.a.f43883a.b(f43878a.j() + " --> register() --> it = " + Log.getStackTraceString(m1188exceptionOrNullimpl));
    }

    public final void g(b psLinkCallBackCommon) {
        Intrinsics.h(psLinkCallBackCommon, "psLinkCallBackCommon");
        if (f43880c.contains(psLinkCallBackCommon)) {
            return;
        }
        f43880c.add(psLinkCallBackCommon);
    }

    public final void h() {
        Object m1185constructorimpl;
        if (f43879b != null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.commercialization.pslink.a aVar = com.transsion.commercialization.pslink.a.f43883a;
            PsLinkServiceHelper psLinkServiceHelper = f43878a;
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... ");
            Intent intent = new Intent();
            intent.setClassName(MiniAppIpcConfig.PALM_STORE_PACKAGE_NAME, "com.transsnet.launcherlib.services.DispenseCommonService");
            boolean bindService = Utils.a().bindService(intent, f43882e, 1);
            aVar.a(psLinkServiceHelper.j() + " --> bindService() --> 开始bindService .... --> isConnect = " + bindService);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            com.transsion.commercialization.pslink.a.f43883a.b(f43878a.j() + " --> bindService() --> " + Log.getStackTraceString(m1188exceptionOrNullimpl));
        }
        PsLinkInstallReceiver.INSTANCE.b();
    }

    public final CopyOnWriteArrayList i() {
        return f43880c;
    }

    public final boolean k() {
        return f43879b == null;
    }

    public final void m(b psLinkCallBackCommon) {
        Intrinsics.h(psLinkCallBackCommon, "psLinkCallBackCommon");
        f43880c.remove(psLinkCallBackCommon);
    }
}
