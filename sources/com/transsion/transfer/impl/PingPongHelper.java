package com.transsion.transfer.impl;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.impl.PingPongHelper;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class PingPongHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f55737a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f55738b;

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.transfer.androidasync.http.b0 f55739c;

    /* renamed from: d, reason: collision with root package name */
    private final a f55740d;

    /* renamed from: e, reason: collision with root package name */
    private final Stack f55741e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55742f;

    /* renamed from: g, reason: collision with root package name */
    private int f55743g;

    /* renamed from: h, reason: collision with root package name */
    private final int f55744h;

    /* renamed from: i, reason: collision with root package name */
    private final Timer f55745i;

    /* renamed from: j, reason: collision with root package name */
    private final PingPongHelper$task$1 f55746j;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, com.transsion.transfer.androidasync.http.b0 b0Var);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.transsion.transfer.impl.PingPongHelper$task$1] */
    public PingPongHelper(String remoteIP, boolean z10, com.transsion.transfer.androidasync.http.b0 socket, a pingPongListener) {
        Intrinsics.h(remoteIP, "remoteIP");
        Intrinsics.h(socket, "socket");
        Intrinsics.h(pingPongListener, "pingPongListener");
        this.f55737a = remoteIP;
        this.f55738b = z10;
        this.f55739c = socket;
        this.f55740d = pingPongListener;
        this.f55741e = new Stack();
        this.f55744h = 2;
        socket.G(new b0.b() { // from class: com.transsion.transfer.impl.j
            @Override // com.transsion.transfer.androidasync.http.b0.b
            public final void a(String str) {
                PingPongHelper.b(PingPongHelper.this, str);
            }
        });
        this.f55745i = new Timer();
        this.f55746j = new TimerTask() { // from class: com.transsion.transfer.impl.PingPongHelper$task$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                int i11;
                int i12;
                boolean z11;
                String m11;
                Stack stack;
                com.transsion.transfer.androidasync.http.b0 b0Var;
                int i13;
                Stack stack2;
                int i14;
                Stack stack3;
                PingPongHelper.a aVar;
                String str;
                com.transsion.transfer.androidasync.http.b0 b0Var2;
                i11 = PingPongHelper.this.f55743g;
                i12 = PingPongHelper.this.f55744h;
                if (i11 >= i12) {
                    aVar = PingPongHelper.this.f55740d;
                    str = PingPongHelper.this.f55737a;
                    b0Var2 = PingPongHelper.this.f55739c;
                    aVar.a(str, b0Var2);
                    PingPongHelper.this.f55742f = true;
                }
                z11 = PingPongHelper.this.f55742f;
                if (z11) {
                    return;
                }
                m11 = PingPongHelper.this.m();
                stack = PingPongHelper.this.f55741e;
                stack.push(m11);
                b0Var = PingPongHelper.this.f55739c;
                b0Var.A(m11);
                i13 = PingPongHelper.this.f55743g;
                PingPongHelper.this.f55743g = i13 + 1;
                stack2 = PingPongHelper.this.f55741e;
                int size = stack2.size();
                i14 = PingPongHelper.this.f55744h;
                if (size > i14) {
                    stack3 = PingPongHelper.this.f55741e;
                    stack3.remove(0);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PingPongHelper pingPongHelper, String str) {
        pingPongHelper.f55743g = 0;
        pingPongHelper.f55741e.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        return (this.f55738b ? TmcConstants.CHANNEL_REQUEST_SERVER : "client") + "-" + System.currentTimeMillis();
    }

    public final void n() {
        this.f55745i.schedule(this.f55746j, 0L, 2000L);
    }

    public final void o() {
        this.f55742f = true;
        cancel();
        this.f55745i.cancel();
    }
}
