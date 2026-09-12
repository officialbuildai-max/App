package com.cloud.tmc.integration.invoke;

import com.cloud.tmc.integration.invoke.ExtensionInvoker;
import com.cloud.tmc.kernel.datastructure.immutable.ImmutableList;
import com.cloud.tmc.kernel.extension.Extension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resolver.ResultResolver;
import com.cloud.tmc.kernel.scheduler.Interruptable;
import com.cloud.tmc.kernel.scheduler.internal.DefaultInterruptor;
import com.cloud.tmc.kernel.utils.ReflectUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ResolveExtensionInvoker extends ExtensionInvoker {
    private static final String TAG = "TmcKernel:ExtensionInvoker:Resolve";
    private static final ResultResolver sDefaultResolver = new ResultResolver() { // from class: com.cloud.tmc.integration.invoke.ResolveExtensionInvoker.1
        @Override // com.cloud.tmc.kernel.resolver.ResultResolver
        public Object resolve(List list) {
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) != null) {
                    return list.get(size);
                }
            }
            return null;
        }
    };
    private ResultResolver mResultResolver;

    public ResolveExtensionInvoker(ResultResolver resultResolver, ExtensionInvoker extensionInvoker) {
        super(extensionInvoker);
        this.mResultResolver = resultResolver;
        if (resultResolver == null) {
            TmcLogger.d(TAG, "use default resolver!");
            this.mResultResolver = sDefaultResolver;
        }
    }

    @Override // com.cloud.tmc.integration.invoke.ExtensionInvoker
    protected ExtensionInvoker.InvokeResult onInvoke(Object obj, Method method, Object[] objArr) {
        Extension extension;
        if (!hasNext()) {
            return ExtensionInvoker.InvokeResult.decide(ReflectUtils.getDefaultValue(method.getReturnType()));
        }
        ArrayList arrayList = new ArrayList();
        ExtensionInvoker.InvokeCallback invokeCallback = this.invokeCallback;
        Throwable th2 = null;
        ExtensionCallback extensionCallback = invokeCallback instanceof ExtensionCallback ? (ExtensionCallback) invokeCallback : null;
        if (extensionCallback != null) {
            extensionCallback.onStart(this.targetExtensions.mutable());
        }
        Iterator it = this.targetExtensions.iterator();
        DefaultInterruptor defaultInterruptor = null;
        Object obj2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            extension = (Extension) it.next();
            if (extension instanceof Interruptable) {
                if (defaultInterruptor == null) {
                    defaultInterruptor = new DefaultInterruptor();
                } else {
                    defaultInterruptor.setInterrupted(false);
                }
                ((Interruptable) extension).setInterruptor(defaultInterruptor);
            }
            try {
                this.nextInvoker.targetExtensions = new ImmutableList<>(extension);
                obj2 = this.nextInvoker.invoke(obj, method, objArr);
                arrayList.add(obj2);
                if (extensionCallback != null) {
                    extensionCallback.onProgress(extension, obj2);
                }
                if (defaultInterruptor != null && defaultInterruptor.isInterrupted()) {
                    if (extensionCallback != null) {
                        extensionCallback.onInterrupt(extension);
                    }
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (extensionCallback != null) {
                    extensionCallback.onException(extension, th2);
                }
            }
        }
        extension = null;
        ResultResolver resultResolver = this.mResultResolver;
        if (resultResolver != null) {
            obj2 = resultResolver.resolve(arrayList);
        }
        if (th2 != null) {
            TmcLogger.e(TAG, "return defaultValue due to exception " + th2 + " in ext: " + extension);
            obj2 = ReflectUtils.getDefaultValue(method.getReturnType());
        }
        return ExtensionInvoker.InvokeResult.decide(obj2);
    }
}
