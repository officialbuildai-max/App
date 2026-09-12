package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* loaded from: classes2.dex */
abstract class AbstractSSEHandler extends AbstractHandler implements ServerSideEncryptionResult {
    protected abstract ServerSideEncryptionResult f();

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSEAlgorithm(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSEAlgorithm(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSECustomerAlgorithm(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSECustomerAlgorithm(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSECustomerKeyMd5(String str) {
        ServerSideEncryptionResult f11 = f();
        if (f11 != null) {
            f11.setSSECustomerKeyMd5(str);
        }
    }
}
