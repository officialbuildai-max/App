package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class Preconditions {

    /* renamed from: com.cloud.sdk.commonutil.util.Preconditions$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a val$callback;

        AnonymousClass2(a aVar) {
            this.val$callback = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onRun();
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void onRun();
    }

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Must be called from the UiThread");
        }
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str);
    }

    public static void d(final a aVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.sdk.commonutil.util.Preconditions.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onRun();
                }
            });
        } else {
            aVar.onRun();
        }
    }
}
