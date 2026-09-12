package com.transsion.push.utils;

import java.util.Calendar;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f50987a = new a(null);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String a() {
        return Calendar.getInstance().get(5) % 2 == 0 ? "push/2/notification.json" : "push/1/notification.json";
    }
}
