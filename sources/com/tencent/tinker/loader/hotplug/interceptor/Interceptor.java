package com.tencent.tinker.loader.hotplug.interceptor;

import com.tencent.tinker.loader.shareutil.ShareTinkerLog;

/* loaded from: classes5.dex */
public abstract class Interceptor<T_TARGET> {
    private T_TARGET mTarget = null;
    private volatile boolean mInstalled = false;

    /* loaded from: classes5.dex */
    protected interface ITinkerHotplugProxy {
    }

    protected T_TARGET decorate(T_TARGET t_target) throws Throwable {
        return t_target;
    }

    protected abstract T_TARGET fetchTarget() throws Throwable;

    protected abstract void inject(T_TARGET t_target) throws Throwable;

    public synchronized void install() throws InterceptFailedException {
        try {
            T_TARGET fetchTarget = fetchTarget();
            this.mTarget = fetchTarget;
            T_TARGET decorate = decorate(fetchTarget);
            if (decorate != fetchTarget) {
                inject(decorate);
            } else {
                ShareTinkerLog.w("Tinker.Interceptor", "target: " + fetchTarget + " was already hooked.", new Object[0]);
            }
            this.mInstalled = true;
        } finally {
        }
    }

    public synchronized void uninstall() throws InterceptFailedException {
        InterceptFailedException interceptFailedException;
        if (this.mInstalled) {
            try {
                inject(this.mTarget);
                this.mTarget = null;
                this.mInstalled = false;
            } finally {
            }
        }
    }
}
