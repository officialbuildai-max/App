package com.transsion.rewardscenter.task.dada;

import com.tencent.mmkv.MMKV;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f51239a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f51240b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.dada.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = q.d();
            return d11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f51241c = 8;

    private q() {
    }

    private final MMKV b() {
        return (MMKV) f51240b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        return MMKV.I("DadaCache");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DadaTaskState c(List list) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int i11 = b().getInt("task_state_" + str, -1);
            if (i11 != -1) {
                return (DadaTaskState) DadaTaskState.getEntries().get(i11);
            }
        }
        return null;
    }

    public final void e(String str, DadaTaskState taskState) {
        Intrinsics.h(taskState, "taskState");
        if (str == null) {
            return;
        }
        b().putInt("task_state_" + str, taskState.ordinal());
    }
}
