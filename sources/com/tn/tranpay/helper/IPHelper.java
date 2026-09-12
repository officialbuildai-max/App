package com.tn.tranpay.helper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: classes4.dex */
public final class IPHelper {

    /* renamed from: b, reason: collision with root package name */
    private static String f41687b;

    /* renamed from: c, reason: collision with root package name */
    private static long f41688c;

    /* renamed from: a, reason: collision with root package name */
    public static final IPHelper f41686a = new IPHelper();

    /* renamed from: d, reason: collision with root package name */
    private static final List f41689d = CollectionsKt.o("https://api.ipify.org", "https://ifconfig.me/ip", "https://icanhazip.com", "https://ipinfo.io/ip");

    private IPHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(String str, Continuation continuation) {
        return i.g(y0.b(), new IPHelper$fetchIPFromService$2(str, null), continuation);
    }

    public static /* synthetic */ Object j(IPHelper iPHelper, boolean z10, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        return iPHelper.i(z10, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String str) {
        List S0 = StringsKt.S0(str, new String[]{"."}, false, 0, 6, null);
        if (S0.size() != 4) {
            return false;
        }
        List list = S0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    int parseInt = Integer.parseInt((String) it.next());
                    if (parseInt < 0 || parseInt >= 256) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
        }
        return true;
    }

    public final Object i(boolean z10, Continuation continuation) {
        return i.g(y0.b(), new IPHelper$getCurrentIP$2(z10, null), continuation);
    }
}
