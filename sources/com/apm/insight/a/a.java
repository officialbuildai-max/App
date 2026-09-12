package com.apm.insight.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b.i;
import com.apm.insight.runtime.m;

/* loaded from: classes2.dex */
public class a implements ICrashCallback {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f19398d;

    /* renamed from: a, reason: collision with root package name */
    private volatile String f19399a;

    /* renamed from: b, reason: collision with root package name */
    private volatile i.a f19400b;

    /* renamed from: c, reason: collision with root package name */
    private volatile i.a f19401c;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f19402e = false;

    private a() {
    }

    public static a a() {
        if (f19398d == null) {
            synchronized (a.class) {
                try {
                    if (f19398d == null) {
                        f19398d = new a();
                    }
                } finally {
                }
            }
        }
        return f19398d;
    }

    public final void a(String str, i.a aVar, i.a aVar2) {
        this.f19399a = str;
        this.f19400b = aVar;
        this.f19401c = aVar2;
        if (this.f19402e) {
            return;
        }
        this.f19402e = true;
        m.a().a(new Runnable() { // from class: com.apm.insight.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // com.apm.insight.ICrashCallback
    public void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }
}
