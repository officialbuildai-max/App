package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
public abstract class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f30241a;

    /* renamed from: b, reason: collision with root package name */
    private final String f30242b = "com.google.android.play.core.appupdate.protocol.IAppUpdateService";

    /* JADX INFO: Access modifiers changed from: protected */
    public a(IBinder iBinder, String str) {
        this.f30241a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f30241a;
    }
}
