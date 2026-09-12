package com.cloud.tmc.kernel.bridge.extension.bind;

import com.cloud.tmc.kernel.bridge.extension.annotation.BindingId;

/* loaded from: classes3.dex */
public class IdBinder implements Binder<BindingId, String> {

    /* renamed from: id, reason: collision with root package name */
    private String f23568id;

    public IdBinder(String str) {
        this.f23568id = str;
    }

    @Override // com.cloud.tmc.kernel.bridge.extension.bind.Binder
    public String bind(Class<String> cls, BindingId bindingId) throws BindException {
        return this.f23568id;
    }
}
