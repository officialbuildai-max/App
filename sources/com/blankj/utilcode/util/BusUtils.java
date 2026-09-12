package com.blankj.utilcode.util;

/* loaded from: classes2.dex */
public abstract class BusUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f20086a = "nULl";

    /* renamed from: com.blankj.utilcode.util.BusUtils$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BusUtils this$0;
        final /* synthetic */ Object val$arg;
        final /* synthetic */ Object val$bus;
        final /* synthetic */ a val$busInfo;
        final /* synthetic */ boolean val$sticky;

        AnonymousClass1(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z10) {
            this.val$bus = obj;
            this.val$arg = obj2;
            this.val$sticky = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusUtils.a(null, this.val$bus, this.val$arg, null, this.val$sticky);
        }
    }

    /* loaded from: classes2.dex */
    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    /* loaded from: classes2.dex */
    private static final class a {
    }

    static /* synthetic */ void a(BusUtils busUtils, Object obj, Object obj2, a aVar, boolean z10) {
        throw null;
    }
}
