package com.transsion.shorttv.base.widget.toast.core;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f53035a;

    public c(Handler mHandler) {
        Intrinsics.h(mHandler, "mHandler");
        this.f53035a = mHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.h(msg, "msg");
        try {
            this.f53035a.handleMessage(msg);
        } catch (WindowManager.BadTokenException e11) {
            e11.printStackTrace();
        } catch (IllegalStateException e12) {
            e12.printStackTrace();
        }
    }
}
