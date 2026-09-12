package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.integration.invoke.ExtensionInvoker;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.remote.RemoteCallArgs;
import com.cloud.tmc.kernel.remote.RemoteCallResult;
import com.cloud.tmc.kernel.remote.RemoteController;
import com.cloud.tmc.kernel.utils.ProcessUtils;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RemoteNormalExtensionInvoker extends ExtensionInvoker {
    private static final String TAG = "TmcKernel:ExtensionInvoker:Remote";
    private boolean mIsMainProcess;
    private RemoteController mRemoteController;

    public RemoteNormalExtensionInvoker(RemoteController remoteController, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.mIsMainProcess = ProcessUtils.isMainProcess();
        this.mRemoteController = remoteController;
    }

    @Override // com.cloud.tmc.integration.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Extension extension;
        boolean isRemoteCallExtension;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mIsMainProcess || this.mRemoteController == null || !(isRemoteCallExtension = this.mRemoteController.isRemoteCallExtension((extension = this.targetExtensions.get(0)), method))) {
            return ExtensionInvoker.InvokeResult.proceed();
        }
        TmcLogger.d(TAG, "extension: " + extension.getClass() + " method: " + method + " isRemote: " + isRemoteCallExtension);
        RemoteCallResult remoteCall = this.mRemoteController.remoteCall(new RemoteCallArgs(this.targetNode, extension, method, objArr, null));
        Object value = remoteCall.getValue();
        if (remoteCall.isError() && (value instanceof Throwable)) {
            throw ((Throwable) value);
        }
        TmcLogger.debug(TAG, "extension " + extension + " method: " + method + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return ExtensionInvoker.InvokeResult.decide(remoteCall.getValue());
    }
}
