package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.view.Lifecycle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuHostHelper {
    private final Runnable mOnInvalidateMenuCallback;
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders = new CopyOnWriteArrayList<>();
    private final Map<MenuProvider, a> mProviderToLifecycleContainers = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lifecycle f8370a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.view.r f8371b;

        a(Lifecycle lifecycle, androidx.view.r rVar) {
            this.f8370a = lifecycle;
            this.f8371b = rVar;
            lifecycle.a(rVar);
        }

        void a() {
            this.f8370a.d(this.f8371b);
            this.f8371b = null;
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.mOnInvalidateMenuCallback = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$0(MenuProvider menuProvider, androidx.view.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addMenuProvider$1(Lifecycle.State state, MenuProvider menuProvider, androidx.view.u uVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            addMenuProvider(menuProvider);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            removeMenuProvider(menuProvider);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.mMenuProviders.remove(menuProvider);
            this.mOnInvalidateMenuCallback.run();
        }
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.add(menuProvider);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(final MenuProvider menuProvider, androidx.view.u uVar) {
        addMenuProvider(menuProvider);
        Lifecycle lifecycle = uVar.getLifecycle();
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new androidx.view.r() { // from class: androidx.core.view.w
            @Override // androidx.view.r
            public final void onStateChanged(androidx.view.u uVar2, Lifecycle.Event event) {
                MenuHostHelper.this.lambda$addMenuProvider$0(menuProvider, uVar2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final MenuProvider menuProvider, androidx.view.u uVar, final Lifecycle.State state) {
        Lifecycle lifecycle = uVar.getLifecycle();
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mProviderToLifecycleContainers.put(menuProvider, new a(lifecycle, new androidx.view.r() { // from class: androidx.core.view.v
            @Override // androidx.view.r
            public final void onStateChanged(androidx.view.u uVar2, Lifecycle.Event event) {
                MenuHostHelper.this.lambda$addMenuProvider$1(state, menuProvider, uVar2, event);
            }
        }));
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onPrepareMenu(Menu menu) {
        Iterator<MenuProvider> it = this.mMenuProviders.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuProviders.remove(menuProvider);
        a remove = this.mProviderToLifecycleContainers.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.mOnInvalidateMenuCallback.run();
    }
}
