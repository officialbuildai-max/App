package com.cloud.hisavana.net.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes3.dex */
public class CommonWorkThread {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f21509a;

    /* loaded from: classes3.dex */
    private static class WorkThreadHolder {

        /* renamed from: a, reason: collision with root package name */
        private static final CommonWorkThread f21510a = new CommonWorkThread();

        private WorkThreadHolder() {
        }
    }

    private CommonWorkThread() {
        HandlerThread handlerThread = new HandlerThread("common_work_thread");
        handlerThread.start();
        this.f21509a = new Handler(handlerThread.getLooper());
    }
}
