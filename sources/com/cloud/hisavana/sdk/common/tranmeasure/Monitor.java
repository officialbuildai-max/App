package com.cloud.hisavana.sdk.common.tranmeasure;

/* loaded from: classes3.dex */
public abstract class Monitor {

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Monitor f22173a = new b();
    }

    public static Monitor getInstance() {
        return a.f22173a;
    }

    public abstract void end();

    public abstract void start();
}
