package com.transsion.ad.monopoly;

import com.transsion.ad.strategy.c;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final class MonopolyAdManager {

    /* renamed from: a, reason: collision with root package name */
    public static final MonopolyAdManager f42177a = new MonopolyAdManager();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f42178b = new AtomicBoolean(false);

    private MonopolyAdManager() {
    }

    public static /* synthetic */ Object c(MonopolyAdManager monopolyAdManager, String str, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return monopolyAdManager.b(str, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function1 function1, boolean z10) {
        if (z10) {
            c.f42284a.b();
        }
        if (function1 == null) {
            return null;
        }
        function1.invoke(Boolean.valueOf(z10));
        return Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:12:0x0034, B:13:0x00c0, B:20:0x004c, B:21:0x009e, B:23:0x00ab, B:26:0x00c6, B:28:0x00d3, B:30:0x0058, B:31:0x008f, B:41:0x007e), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6 A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:12:0x0034, B:13:0x00c0, B:20:0x004c, B:21:0x009e, B:23:0x00ab, B:26:0x00c6, B:28:0x00d3, B:30:0x0058, B:31:0x008f, B:41:0x007e), top: B:7:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r17, kotlin.jvm.functions.Function1 r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.MonopolyAdManager.b(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
