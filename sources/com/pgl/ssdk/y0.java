package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.b1;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class y0 extends b1 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f40291b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(HandlerThread handlerThread, b1.a aVar) {
        super(handlerThread.getLooper(), aVar);
        this.f40291b = handlerThread;
    }

    public void a(b1.a aVar) {
        this.f40139a = new WeakReference<>(aVar);
    }

    public void a(String str) {
        HandlerThread handlerThread = this.f40291b;
        if (handlerThread != null) {
            handlerThread.setName(str);
        }
    }
}
