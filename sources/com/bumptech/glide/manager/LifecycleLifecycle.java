package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle;
import androidx.view.d0;
import androidx.view.t;
import androidx.view.u;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class LifecycleLifecycle implements Lifecycle, t {

    @NonNull
    private final androidx.view.Lifecycle lifecycle;

    @NonNull
    private final Set<LifecycleListener> lifecycleListeners = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleLifecycle(androidx.view.Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.a(this);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.lifecycle.b() == Lifecycle.State.DESTROYED) {
            lifecycleListener.onDestroy();
        } else if (this.lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @d0(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull u uVar) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        uVar.getLifecycle().d(this);
    }

    @d0(Lifecycle.Event.ON_START)
    public void onStart(@NonNull u uVar) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    @d0(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull u uVar) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
