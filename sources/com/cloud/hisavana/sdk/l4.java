package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class l4 implements c4 {

    /* renamed from: a, reason: collision with root package name */
    protected a f22707a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile int f22708b = 1;

    /* renamed from: c, reason: collision with root package name */
    protected int f22709c;

    /* renamed from: d, reason: collision with root package name */
    protected int f22710d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(TaErrorCode taErrorCode, Bundle bundle);

        void a(List list);

        void b(List list, Bundle bundle);

        void c(TaErrorCode taErrorCode, Bundle bundle);
    }

    public int b() {
        return this.f22708b;
    }

    public void c(int i11) {
        this.f22710d = i11;
    }

    public void d(a aVar) {
        this.f22707a = aVar;
    }

    public void e(int i11) {
        this.f22709c = i11;
    }
}
