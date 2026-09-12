package com.transsnet.flow.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f60380a = new a(null);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.transsnet.flow.event.c
    public void log(String msg) {
        Intrinsics.h(msg, "msg");
    }

    @Override // com.transsnet.flow.event.c
    public void log(String msg, String th2) {
        Intrinsics.h(msg, "msg");
        Intrinsics.h(th2, "th");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(msg);
        sb2.append(",ex:");
        sb2.append(th2);
    }
}
